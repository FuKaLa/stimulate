package com.example.stimulate.controller;

import com.example.stimulate.entity.ChatRecord;
import com.example.stimulate.entity.User;
import com.example.stimulate.service.ChatRecordService;
import com.example.stimulate.utils.ObjectUtils;
import com.example.stimulate.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/6/9.
 */
@CrossOrigin
@Controller
@RequestMapping("/chat")
public class ChatRecordController extends BaseController {

    @Autowired
    private ChatRecordService chatRecordService;

    /**
     * 添加记录
     */
    @ResponseBody
    @RequestMapping("/save")
    public R saveTeam(@RequestBody ChatRecord chatRecord){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

//        if(getUser().getId() == null || getUser().getId() == 0){
//            return R.error(900,"用户信息失效，请重新登录");
//        }
//        chatRecord.setRoleId(getUser().getRoleId());
//        chatRecord.setUserId(getUser().getId());
        chatRecord.setCreatetime((new Date()));
        if(chatRecordService.save(chatRecord)<1){
            return R.error();
        }
        return R.ok();
    }

    /**
     * 聊天记录
     */
    @ResponseBody
    @RequestMapping("/getTeamChatRecord")
    public R getTeamChatRecord(Integer teamId){
        return R.resultData(chatRecordService.getTeamChatRecord(teamId));
    }

    /**
     * 团队成员
     */
    @ResponseBody
    @RequestMapping("/getTeamMembers")
    public R getListByTeamId(Integer teamId){
        return R.resultData(chatRecordService.getListByTeamId(teamId));
    }

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        String str = null;
        User user = new User();
        user.setId(null);
        user.setUserName(null);
        System.out.println(user.getUserName());
        if(ObjectUtils.isEmpty(user)){
            System.out.println(1);
        }
        System.out.println(2);

    }
//============================================================================================
    /**
     * 单独聊天
     */
    /**
     * 创建单独聊天的关联关系
     */
//    @ResponseBody
//    @RequestMapping("/saveAlone")
//    public R saveAlone(Integer tId ,Integer sId){
//        //是否已经存在关联
//        Integer count = chatRecordService.existAlone(tId,sId);
//        if(count == null || count == 0){
//            if(chatRecordService.saveAlone(tId,sId)<1){
//                return R.error();
//            }
//        }
//        return R.ok();
//    }
//
//    /**
//     * 一个人的聊天记录
//     */
//
//    @ResponseBody
//    @RequestMapping("/getAloneRecord")
//    public R getAloneRecord(Integer tId ,Integer sId){
//        chatRecordService.getAloneRecord(tId,sId);
//        if(chatRecordService.saveAlone(tId,sId)<1){
//            return R.error();
//        }
//        return R.resultData();
//    }
//
//    /**
//     * 两个人的聊天记录
//     */
//    @ResponseBody
//    @RequestMapping("/getAloneALLRecord")
//    public R getAloneALLRecord(Integer tId ,Integer sId){
//        //是否已经存在关联
//        chatRecordService.existAlone(tId,sId);
//        if(chatRecordService.saveAlone(tId,sId)<1){
//            return R.error();
//        }
//        return R.resultData();
//    }

    /**
     * 老师的列表以及与老师沟通的记录
     */
}
