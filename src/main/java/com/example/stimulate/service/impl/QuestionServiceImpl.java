package com.example.stimulate.service.impl;

import com.example.stimulate.dao.QuestionDao;
import com.example.stimulate.dao.UserDao;
import com.example.stimulate.entity.*;
import com.example.stimulate.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/6/10.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private UserDao userDao;


    @Override
    public int saveQuestion(Question question) {
        return questionDao.saveQuestion(question);
    }

    @Override
    public List<QuestionSVO> getAnsweredS(Integer studentId,Integer status) {
        return questionDao.getAnsweredS(studentId,status);
    }

    @Override
    public List<QuestionTVO> getAnsweredT(Integer teacherId,Integer status) {
        return questionDao.getAnsweredT(teacherId,status);
    }

    @Override
    public int saveQuestionDetail(QuestionAnswered questionAnswered) {
        return questionDao.saveQuestionDetail(questionAnswered);
    }

    @Override
    public int updateStatus(Integer questionId) {
        return questionDao.updateStatus(questionId);
    }

    @Override
    public QuestionDetailVO getQuestionDetail(Integer questionId) {

        //查看详情
        List<QuestionAnswered> DetailList =questionDao.getQuestionDetail(questionId);
        //返回VO
        String questionName = questionDao.getQuestionName(questionId);
        QuestionDetailVO vo = new QuestionDetailVO();
        vo.setId(questionId);
        vo.setQuestionName(questionName);
        vo.setQuestionDetailList(DetailList);
        return vo;
    }

    @Override
    public List<UserVO> getTeacherList() {
        return userDao.getTeacherList();
    }
}
