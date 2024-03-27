package com.yiii.shardingsphere.demo.service;

import com.github.pagehelper.PageInfo;
import com.yiii.shardingsphere.demo.dao.ScoreDao;
import com.yiii.shardingsphere.demo.dao.UserDao;
import com.yiii.shardingsphere.demo.model.Score;
import com.yiii.shardingsphere.demo.model.User;
import com.yiii.shardingsphere.demo.vo.UserScoreVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {


    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ScoreDao scoreDao;

    // 插入 方法。通过打印的sql执行日志 可以看出
    // id为基数  分配得到 db1 偶数分配到 db0
    // user 中 age 奇数分配到 user_1  偶数分配到user_0
    @Test
    public void insertUser() {


        for (int i = 1; i < 50; i++) {
            User user = new User(i, "test" + i, i + 11);
            userService.insertUser(user);
        }

        for (int i = 50; i < 100; i++) {
            User user = new User(i, "test" + i, i + 10);
            userService.insertUser(user);
        }
    }

    // 通过id查询数据 这里也是通过id 确定了数据库
    @Test
    public void selectUserById() {


        User user1 = userService.selectUserById(11);
        log.info(user1.toString());
        User user2 = userService.selectUserById(12);
        log.info(user2.toString());
    }

    // 查询列表 这里是每个数据库中每个表返回值的集合
    // 从结果看出 排序是生效的
    @Test
    public void selectUserList() {
        List<User> users = userService.selectUserList();
        log.info(users.toString());
    }


    // 这里通过 age确定了 是哪张表 但是不确定库 所以两个库都执行了
    @Test
    public void selectByAge() {
        List<User> users = userService.selectByAge(12);
        log.info(users.toString());
        List<User> users1 = userService.selectByAge(13);
        log.info(users1.toString());
    }

    //这里通过 id和age 确定了 库和表 所以就
    @Test
    public void selectByIdAndAge() {
        List<User> users = userService.selectByIdAndAge(1, 12);
        log.info(users.toString());
    }


    //这里 因为没有指定 id 和 age 所以 是每个库的每个表中搜索结果的集合
    @Test
    public void selectByName() {
        List<User> test33 = userService.selectByName("test33");
        log.info(test33.toString());
    }

    //这里 如果在数据库中每张表的数据不重复的情况下 可以正常执行
    //如果 任意两个表中 通过都可以通过name获取到数据 就会报错 跟不分库时一样
    @Test
    public void selectByOneName() {
        User user = userService.selectByOneName("test33");
        log.info(user.toString());
    }


    // 这里分页正常进行 条件查询正常进行
    @Test
    public void pageUser() {
        PageInfo<User> pageInfo = userService.pageUser(1, 10);
        for (User user : pageInfo.getList()) {
            log.info(user.getId() + "");
        }
        log.info(pageInfo.toString());
    }


    @Test
    public void selectUserScoreByUserId() {
//        UserScoreVo userScoreVo1 = userService.selectUserScoreByUserId(1);
//        log.info(userScoreVo1.toString());
        UserScoreVo userScoreVo2 = userService.selectUserScoreByUserId(2);
        log.info(userScoreVo2.toString());
    }

    @Test
    public void selectScoreByUserId() {
        List<Score> userScore = userService.getUserScore(1);
        log.info(userScore.toString());
    }


    //这里的事务在数据库中正常进行 如果抛出异常 数据会回滚数据，即使是不在一个数据库中也会分别进行
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void testSingleTableTransactional() throws Exception {
        User user = new User(1, "test111111", 2222);
        userDao.updateByPrimaryKey(user);
        throw new Exception("异常");
    }


    @Test
    @Transactional(rollbackFor = Exception.class)
    public void testTwoTableTransactional() throws Exception {
        User user = new User(2, "test111111", 2222);
        userDao.updateByPrimaryKey(user);
        Score score = new Score();
        score.setUserId(1);
        score.setId(1);
        score.setScore(10000);
        scoreDao.updateByPrimaryKey(score);
        throw new Exception("异常");
    }
}