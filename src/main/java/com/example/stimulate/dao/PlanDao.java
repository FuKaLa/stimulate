package com.example.stimulate.dao;

import com.example.stimulate.entity.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/9.
 */
@Mapper
@Repository
public interface PlanDao {
    //TODO
    List<Plan> getList(@Param("name") String name);
    //TODO
    int save(Plan plan);
    //TODO
    int update(Plan plan);
    //TODO
    int deleteById(@Param("id") Integer id);
    //TODO
    Plan getPlanById(@Param("id") Integer id);

    Map selectOne();
}
