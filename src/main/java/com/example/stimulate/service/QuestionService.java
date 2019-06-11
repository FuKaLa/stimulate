package com.example.stimulate.service;

import com.example.stimulate.entity.*;

import java.util.List;

/**
 * Created by Administrator on 2019/6/10.
 */
public interface QuestionService {

    int saveQuestion(Question question);

    List<QuestionSVO> getAnsweredS(Integer studentId,Integer status);

    List<QuestionTVO> getAnsweredT(Integer teacherId,Integer status);

    int saveQuestionDetail(QuestionAnswered questionAnswered);

    int updateStatus(Integer questionId);

    QuestionDetailVO getQuestionDetail(Integer questionId);


    List<UserVO> getTeacherList();
}
