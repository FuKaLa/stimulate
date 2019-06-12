package com.example.stimulate.service;

import com.example.stimulate.entity.Plan;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/9.
 */
public interface PlanService {

    List<Plan> list(String name);

    int save(Plan plan);

    int update(Plan plan);

    int deleteById(Integer id);

    Plan getPlanById(Integer id);
}
