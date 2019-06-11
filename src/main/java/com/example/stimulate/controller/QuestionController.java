package com.example.stimulate.controller;

import com.example.stimulate.entity.Question;
import com.example.stimulate.entity.QuestionAnswered;
import com.example.stimulate.service.QuestionService;
import com.example.stimulate.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/6/10.
 */

/**
 * 第二组问题提问相关
 */
@CrossOrigin
@Controller
@RequestMapping("/question")
public class QuestionController extends BaseController {

    @Autowired
    private QuestionService questionService;

    /**
     * 学生提问  创建问题
     */
    @ResponseBody
    @RequestMapping("/saveQuestion")
    public R saveQuestion(@RequestBody Question question){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        question.setStatus(1);
//        question.setStudentId(getUser().getId());
       // question.setStudentId(2);
        question.setCreatetime((new Date()));
        if(questionService.saveQuestion(question)<1){
            return R.error();
        }
        return R.ok();
    }
    /**
     * 问题详情
     */
    @ResponseBody
    @RequestMapping("/getQuestionDetail")
    public R getQuestionDetail(@RequestParam(value = "questionId",required = true) Integer questionId){
        return R.resultData(questionService.getQuestionDetail(questionId));
    }


    /**
     * 问题列表（学生）
     */
    @ResponseBody
    @RequestMapping("/getAnsweredS")
    public R getAnsweredS(Integer studentId,Integer status){
//        if(getUser().getId() == null || getUser().getId() == 0){
//            return R.error(900,"用户信息失效，请重新登录");
//        }
//        Integer studentId = getUser().getId();
        return R.resultData(questionService.getAnsweredS(studentId,status));
    }
    //===============================================================
    /**
     * 问题列表（老师）
     */
    @ResponseBody
    @RequestMapping("/getAnsweredT")
    public R getAnsweredT(Integer teacherId,Integer status){
        return R.resultData(questionService.getAnsweredT(teacherId,status));
    }

    /**
     * 老师回答问题(问题记录详情)(老师回答、学生再次提问)
     */
    @ResponseBody
    @RequestMapping("/saveQuestionDetail")
    public R saveQuestionDetail(@RequestBody QuestionAnswered question){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        if(getUser().getId() == null || getUser().getId() == 0){
//            return R.error(900,"用户信息失效，请重新登录");
//        }
//        question.setUserId(getUser().getId());
        question.setCreatetime((new Date()));
        if(questionService.saveQuestionDetail(question)<1){
            return R.error();
        }
        //修改状态
        if( questionService.updateStatus(question.getQuestionId())<1){
            return R.error();
        }
        return R.ok();
    }

    /**
     * 获取老师列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/getTeacherList")
    public R getTeacherList(){
        return R.resultData(questionService.getTeacherList());
    }


}
