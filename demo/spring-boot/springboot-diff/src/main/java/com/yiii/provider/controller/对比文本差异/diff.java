package com.yiii.provider.controller.对比文本差异;


import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"WeakerAccess", "unused"})
    public class LCSDiff {

        private static final int CDATA_META_LEN = 3;
        private char[] c1;
        private char[] c2;
        private MetadataSpec[] specs1;
        private MetadataSpec[] specs2;
        private MetadataPicker metadataPicker = new CharactMetadataPicker();

        private byte[][] cdata;

        public LCSDiff(String str1, String str2) {
            this(str1, str2, null);
        }

        public LCSDiff(String str1, String str2, MetadataPicker metadataPicker) {
            this.c1 = str1.toCharArray();
            this.c2 = str2.toCharArray();
            if (metadataPicker != null) {
                this.metadataPicker = metadataPicker;
            }
            this.specs1 = toSpecArray(str1);
            this.specs2 = toSpecArray(str2);
        }

        public CommonInfo seekCommon() {
            calculate();
            CommonInfo commonInfo = lookback();
            this.cdata = null;
            return commonInfo;
        }

        private MetadataSpec[] toSpecArray(String str) {
            Metadatas metas = metadataPicker.doPick(str);
            String[] data = metas.getData();
            MetadataSpec[] specs = new MetadataSpec[data.length];
            int cursor = 0;
            for (int i = 0; i < data.length; i++) {
                MetadataSpec spec = new MetadataSpec();
                spec.start = cursor;
                cursor += data[i].length();
                spec.end = cursor;
                spec.string = null; // 这里用不到
                specs[i] = spec;
            }
            return specs;
        }

        private void calculate() {
            cdata = new byte[specs2.length + 1][];
            for (int i = 0; i < cdata.length; i++) {
                cdata[i] = new byte[(specs1.length + 1) * CDATA_META_LEN];
            }

            for (int i = 0; i < specs2.length; i++) {
                MetadataSpec spec2 = specs2[i];
                for (int j = 0; j < specs1.length; j++) {
                    MetadataSpec spec1 = specs1[j];
                    boolean equals = metaEquals(spec1, spec2);

                    int count = equals ? (getCount(i, j) + 1) : (Math.max(getCount(i,j + 1), getCount(i + 1, j)));
                    setCount(i + 1, j + 1, count);
                }
            }
        }

        private CommonInfo lookback() {
            List<MetadataSpec> sameSpecs1 = new ArrayList<>();
            List<MetadataSpec> sameSpecs2 = new ArrayList<>();

            List<MetadataSpec> specCache1 = new ArrayList<>();
            List<MetadataSpec> specCache2 = new ArrayList<>();
            int i = specs2.length - 1;
            int j = specs1.length - 1;
            int count = getCount(i,j);
            for (; i > 0 && j > 0; ) {
                int count_i = getCount(i - 1, j);
                int count_j = getCount(i,j - 1);
                int count_ij = getCount(i - 1, j - 1);
                int max = max(count_i, count_j, count_ij);
                if (max < count) {
                    specCache1.add(0, specs1[j - 1]);
                    specCache2.add(0, specs2[i - 1]);
                    count = max;
                    i--;
                    j--;
                } else {
                    if (specCache1.size() > 0) {
                        MetadataSpec spec1 = aggregateSpec(specCache1, c1);
                        sameSpecs1.add(0, spec1);
                        MetadataSpec spec2 = aggregateSpec(specCache2, c2);
                        sameSpecs2.add(0,spec2);
                    }
                    if (count_i > count_j || (count_i == count_j && i > j)) {
                        i--;
                        count = count_i;
                    } else {
                        j--;
                        count = count_j;
                    }
                    specCache1.clear();
                    specCache2.clear();
                }
            }
            if (specCache1.size() > 0) {
                MetadataSpec spec1 = aggregateSpec(specCache1, c1);
                sameSpecs1.add(0, spec1);
                MetadataSpec spec2 = aggregateSpec(specCache2, c2);
                sameSpecs2.add(0,spec2);
            }
            CommonInfo commonInfo = new CommonInfo();
            commonInfo.specs1 = sameSpecs1;
            commonInfo.specs2 = sameSpecs2;

            return commonInfo;
        }

        private MetadataSpec aggregateSpec(List<MetadataSpec> list, char[] cs) {
            if (list.size() == 0) return null;
            int start = list.get(0).start;
            int end = list.get(list.size() - 1).end;
            MetadataSpec spec = new MetadataSpec();
            spec.start = start;
            spec.end = end;
            spec.string = new String(cs, start, end - start);
            return spec;
        }

        private int max(int a, int b, int c) {
            return Math.max(Math.max(a, b), c);
        }

        private boolean metaEquals(MetadataSpec spec1, MetadataSpec spec2) {
            int startSpec1 = spec1.start;
            int endSpec1 = spec1.end;
            int startSpec2 = spec2.start;
            int endSpec2 = spec2.end;
            if (endSpec1 - startSpec1 != endSpec2 - startSpec2) return false;

            for (int i = 0; i + startSpec1 < endSpec1; i++) {
                if (c1[i + startSpec1] != c2[i + startSpec2]) return false;
            }

            return true;
        }

        private int getCount(int i, int j) {
            byte[] row = cdata[i];
            int start = j * CDATA_META_LEN;
            int count = 0;
            count += (row[start] & 0xff) << 16;
            count += (row[start + 1] & 0xff) << 8;
            count += (row[start + 2] & 0xff);
            return count;
        }

        private void setCount(int i, int j, int data) {
            byte[] row = cdata[i];
            int start = j * CDATA_META_LEN;
            row[start] = (byte) ((data >>> 16) & 0xff);
            row[start + 1] = (byte) ((data >>> 8) & 0xff);
            row[start + 2] = (byte) (data & 0xff);
        }

        @SuppressWarnings("unused")
        static
        class MetadataSpec {
            int start;
            int end;
            String string;

            public int getStart() {
                return start;
            }

            public void setStart(int start) {
                this.start = start;
            }

            public int getEnd() {
                return end;
            }

            public void setEnd(int end) {
                this.end = end;
            }

            public String getString() {
                return string;
            }

            public void setString(String string) {
                this.string = string;
            }
        }

        /**
         * 共同数据
         * @author : Vince
         */
        @SuppressWarnings({"unused", "WeakerAccess"})
        class CommonInfo {
            List<MetadataSpec> specs1;
            List<MetadataSpec> specs2;

            public List<MetadataSpec> getSpecs1() {
                return specs1;
            }

            public void setSpecs1(List<MetadataSpec> specs1) {
                this.specs1 = specs1;
            }

            public List<MetadataSpec> getSpecs2() {
                return specs2;
            }

            public void setSpecs2(List<MetadataSpec> specs2) {
                this.specs2 = specs2;
            }
        }

        public static void main(String[] args) throws IOException {
            String str1 = FileUtils.readFileToString(new File("C:\\Users\\Vince\\Desktop\\re.txt"), StandardCharsets.UTF_8);
            String str2 = FileUtils.readFileToString(new File("C:\\Users\\Vince\\Desktop\\rr.txt"), StandardCharsets.UTF_8);

            // diff算法比较耗内存，一般代码文件字符数较多，使用EnglishWordMetadataBuilder模式，较少内存消耗
            // EnglishWordMetadataBuilder模式，将英文单词作为不可分割的数据元来比较，适合代码等相似风格的文件文本比较
            // CharBaseMetadataBuilder模式，以单个字符作为不可分割的数据元来比较，适合文本字符较少、分隔符号较少时使用，适用场景相对较少点
            LCSDiff lcsDiff = new LCSDiff(str1, str2, new EnglishWordMetadataPicker());
//        LCSDiff lcsDiff = new LCSDiff(str1, str2);
            CommonInfo diff = lcsDiff.seekCommon();
            List<MetadataSpec> sameSpecs1 = diff.getSpecs1();
            List<String> collect = sameSpecs1.stream().map(MetadataSpec::getString).collect(Collectors.toList());
            FileUtils.writeLines(new File("C:\\Users\\Vince\\Desktop\\diff.txt"), collect);
        }
    }

