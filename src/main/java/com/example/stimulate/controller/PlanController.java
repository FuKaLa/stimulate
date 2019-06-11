package com.example.stimulate.controller;

import com.example.stimulate.entity.Plan;
import com.example.stimulate.service.PlanService;
import com.example.stimulate.utils.PageUtils;
import com.example.stimulate.utils.R;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 激励计划相关
 * 列表显示、
 * 新建竞赛、
 * 竞赛信息的修改
 * 逻辑删除
 */
@CrossOrigin
@Controller
@RequestMapping("/plan")
public class PlanController extends BaseController{

    @Autowired
    private PlanService planService;

    /**
     * 列表查询
     */
    @ResponseBody
    @RequestMapping("/list")
    public R list(@RequestParam() Map<String, Object> params){
        //查询列表数据
        setPage(params);
        List<Plan> courseList = planService.list(params);
        Page<Plan> list = (Page<Plan>) courseList;
        return R.resultData(list);
    }

    @ResponseBody
    @RequestMapping("/save")
    public R save(@RequestBody Plan plan){
        if(planService.save(plan) < 1 ){
            R.error();
        }
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/update")
    public R update(@RequestBody Plan plan){
        if(planService.update(plan) < 1 ){
            R.error();
        }
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/delete")
    public R deleteById(Integer id){
        if(planService.deleteById(id) < 1 ){
            R.error();
        }
        return R.ok();
    }

    @ResponseBody
    @RequestMapping("/getPlanById")
    public R getPlanById(Integer id){
        return R.resultData(planService.getPlanById(id));
    }

}
