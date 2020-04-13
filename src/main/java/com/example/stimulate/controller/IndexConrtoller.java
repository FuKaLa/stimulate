package com.example.stimulate.controller;

import com.example.stimulate.service.PlanService;
import com.example.stimulate.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("index")
@RestController
public class IndexConrtoller {

    @Autowired
    private PlanService planService;
    @RequestMapping("test")
    public R test(){
        System.out.println("输出方法了");
       Map map =  planService.selectOne();
        return R.succse(map);
    }
}