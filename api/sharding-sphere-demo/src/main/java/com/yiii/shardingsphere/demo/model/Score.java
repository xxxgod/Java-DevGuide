package com.yiii.shardingsphere.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "score")
@NoArgsConstructor
@AllArgsConstructor
public class Score {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private Integer userId;

    private Integer score;

}
