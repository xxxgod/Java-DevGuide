package com.yiii.shardingsphere.demo.dao;


import com.yiii.shardingsphere.demo.model.User;
import com.yiii.shardingsphere.demo.vo.UserScoreVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;

public interface UserDao extends BaseMapper<User>, ExampleMapper<User> {

    //    这个个米有结果的尝试！！。。本来一条sql就只能在一个session中执行，
//    只有在两张表在同一个数据库中存在的时候才可以通过join的方式来获取数据
//
//    @Select("SELECT \n" +
//            "u.id as userId,\n" +
//            "s.id as scoreId,\n" +
//            "u.name as name,\n" +
//            "s.score as score\n" +
//            "FROM \n" +
//            "user u \n" +
//            "LEFT JOIN \n" +
//            "score s \n" +
//            "ON u.id = s.user_id \n" +
//            "WHERE u.id = ${userId}")
    @Select("SELECT \n" +
            "u.id as userId,\n" +
            "s.id as scoreId,\n" +
            "u.name as name,\n" +
            "s.score as score\n" +
            "FROM\n" +
            "user_0 u,score s\n" +
            "WHERE u.id = s.user_id AND u.id = ${userId}")
    UserScoreVo selectScoreByUserId(@Param("userId") Integer userId);
}
