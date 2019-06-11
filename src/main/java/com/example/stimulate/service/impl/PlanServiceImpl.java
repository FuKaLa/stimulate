package com.example.stimulate.service.impl;

import com.example.stimulate.dao.PlanDao;
import com.example.stimulate.entity.Plan;
import com.example.stimulate.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/9.
 */
@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanDao planDao;

    @Override
    public List<Plan> list(Map<String, Object> map) {
        return planDao.getList(map);
    }

    @Override
    public int save(Plan plan) {
        return planDao.save(plan);
    }

    @Override
    public int update(Plan plan) {
        return planDao.update(plan);
    }

    @Override
    public int deleteById(Integer id) {
        return planDao.deleteById(id);
    }

    @Override
    public Plan getPlanById(Integer id) {
        return planDao.getPlanById(id);
    }
}
