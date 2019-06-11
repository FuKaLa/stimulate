package com.example.stimulate.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/6/10.
 */
public class QuestionDetailVO implements Serializable {


    private Integer id;

    private String questionName;

    private List<QuestionAnswered> questionDetailList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public List<QuestionAnswered> getQuestionDetailList() {
        return questionDetailList;
    }

    public void setQuestionDetailList(List<QuestionAnswered> questionDetailList) {
        this.questionDetailList = questionDetailList;
    }
}
