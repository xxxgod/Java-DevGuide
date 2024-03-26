package com.yiii.es.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName = "picocr_index", type = "picocr", shards = 5,
        replicas = 1, indexStoreType = "fs", refreshInterval = "-1")
public class PicOcr implements Serializable {

    private static final long serialVersionUID = 551589397625941750L;
    /** 图片id */
    @Id
    // @Field(index = FieldIndex.not_analyzed, store = true, type = FieldType.Long)
    private Long id;
    /** 案件id */
    @Field(index = FieldIndex.not_analyzed, store = true, type = FieldType.Long)
    private Long caseId;
    /** folderId */
    @Field(index = FieldIndex.not_analyzed, store = true, type = FieldType.String)
    private String nId;



    /** 图片名称 */
    @Field(index = FieldIndex.analyzed, store = true, type = FieldType.String,searchAnalyzer = "ik", analyzer = "ik")
    private String title;
    /** 图片ocr内容 */
    @Field(index = FieldIndex.analyzed, store = true, type = FieldType.String,searchAnalyzer = "ik", analyzer = "ik")
    private String content;

    public PicOcr() {
    }
// 省略 get set
}
