package com.yiii.shardingsphere.demo.dao;


import com.yiii.shardingsphere.demo.model.Score;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;

public interface ScoreDao extends BaseMapper<Score>, ExampleMapper<Score> {
}
