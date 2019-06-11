package com.example.stimulate.dao;

import com.example.stimulate.entity.Question;
import com.example.stimulate.entity.QuestionAnswered;
import com.example.stimulate.entity.QuestionSVO;
import com.example.stimulate.entity.QuestionTVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2019/6/10.
 */
@Mapper
@Repository
public interface QuestionDao {

    int saveQuestion(Question question);

    List<QuestionSVO> getAnsweredS(@Param("studentId") Integer studentId,@Param("status") Integer status);

    List<QuestionTVO> getAnsweredT(@Param("teacherId") Integer teacherId,@Param("status") Integer status);

    int saveQuestionDetail(QuestionAnswered questionAnswered);

    int updateStatus(@Param("questionId") Integer questionId);

    List<QuestionAnswered> getQuestionDetail(@Param("questionId") Integer questionId);

    String getQuestionName(@Param("questionId") Integer questionId);

}
