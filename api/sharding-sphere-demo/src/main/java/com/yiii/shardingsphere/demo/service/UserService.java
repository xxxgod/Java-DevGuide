package com.yiii.shardingsphere.demo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiii.shardingsphere.demo.dao.ScoreDao;
import com.yiii.shardingsphere.demo.dao.UserDao;
import com.yiii.shardingsphere.demo.model.Score;
import com.yiii.shardingsphere.demo.model.User;
import com.yiii.shardingsphere.demo.vo.UserScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ScoreDao scoreDao;


    public void insertUser(User user) {
        userDao.insert(user);
    }


    public User selectUserById(Integer userId) {
        return userDao.selectByPrimaryKey(userId);
    }


    public List<User> selectUserList() {
        Example example = new Example(User.class);
        example.setOrderByClause(" id asc ");
        return userDao.selectByExample(example);
    }


    public List<User> selectByIdAndAge(Integer id, Integer age) {
        User user = new User();
        user.setAge(age);
        user.setId(id);
        return userDao.select(user);
    }

    public List<User> selectByAge(Integer age) {
        User user = new User();
        user.setAge(age);
        return userDao.select(user);
    }

    public List<User> selectByName(String name) {
        User user = new User();
        user.setName(name);
        return userDao.select(user);
    }

    public User selectByOneName(String name) {
        User user = new User();
        user.setName(name);
        return userDao.selectOne(user);
    }

    public List<User> selectByUser(User user) {
        return userDao.select(user);
    }


    public PageInfo<User> pageUser(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(User.class);
        example.setOrderByClause(" id asc ");
        example.createCriteria().andLike("name", "%1%");
        List<User> users = userDao.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        PageHelper.clearPage();
        return pageInfo;
    }


    public UserScoreVo selectUserScoreByUserId(Integer userId) {

        User user = userDao.selectByPrimaryKey(userId);

        if (user != null) {
            Score score = new Score();
            score.setUserId(userId);
            Score score1 = scoreDao.selectOne(score);

            UserScoreVo userScoreVo = new UserScoreVo();
            userScoreVo.setUserId(user.getId());
            userScoreVo.setScoreId(score1.getId());
            userScoreVo.setName(user.getName());
            userScoreVo.setScore(score1.getScore());
            return userScoreVo;
        } else {
            return null;
        }


    }

    public List<Score> getUserScore(Integer userId) {
        Score score = new Score();
        score.setUserId(userId);
        return scoreDao.select(score);
    }
}
