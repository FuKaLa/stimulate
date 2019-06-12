package com.example.stimulate.controller;

import com.example.stimulate.entity.Summary;
import com.example.stimulate.service.SummaryService;
import com.example.stimulate.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 指导总结
 */
@CrossOrigin
@Controller
@RequestMapping("/summary")
public class SummaryController extends BaseController{
    @Autowired
    private SummaryService summaryService;

    /**
     * 新增总结
     */
    @ResponseBody
    @RequestMapping("/save")
    public R saveSummary(@RequestBody Summary summary){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        if(getUser().getId() == null || getUser().getId() == 0){
//            return R.error(900,"用户信息失效，请重新登录");
//        }
//        summary.setCreateuser(getUser().getId());
        summary.setCreatetime((new Date()));
        if(summaryService.save(summary)<1){
            return R.error();
        }
        return R.ok();
    }

    /**
     * 用户总结列表显示
     * @return
     */
    @ResponseBody
    @RequestMapping("/getList")
    public R getSummaryList(Integer userId){
//        if(getUser().getId() == null || getUser().getId() == 0){
//            return R.error(900,"用户信息失效，请重新登录");
//        }
//        Integer userId = getUser().getId();
        return R.resultData(summaryService.getSummaryList(userId));
    }

    /**
     * 用户详情查看
     * @param summaryId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getSummaryDetail")
    public R getSummaryDetail(Integer summaryId){
        return R.resultData(summaryService.getSummaryDetail(summaryId));
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R updateSummary(@RequestBody Summary summary){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        summary.setUpdatetime(new Date());
        if(summaryService.update(summary)<1){
            return R.error();
        }
        return R.ok();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/delete")
    public R deleteSummary(Integer summaryId){
        if(summaryService.deleteSummary(summaryId)<1){
            return R.error();
        }
        return R.ok();
    }

    /**
     * 权限查看总结
     */
    @ResponseBody
    @RequestMapping("/getSummaryList")
    public R getSummaryList333(){
        return R.resultData(summaryService.getSummaryAllList());
    }
}
