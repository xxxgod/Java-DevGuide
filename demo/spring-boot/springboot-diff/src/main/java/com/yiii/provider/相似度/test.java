package com.yiii.provider.相似度;

import lombok.extern.slf4j.Slf4j;

@Slf4j
 public class test {
    public static void main(String[] args) {
        String src = "hello world!";
        String tar = "hello";
        System.out.println("sim=" + SimilarityUtils.similarity(src, tar));
    }


}
