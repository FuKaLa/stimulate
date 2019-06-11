package com.example.stimulate.dao;

import com.example.stimulate.entity.Summary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import javax.management.relation.InvalidRelationTypeException;
import java.util.List;

/**
 * Created by Administrator on 2019/6/9.
 */

@Mapper
@Repository
public interface SummaryDao {

    int save(Summary summary);

    List<Summary> getSummaryList(@Param("userId") Integer userId);

    Summary getSummaryDetail(@Param("summaryId") Integer summaryId);

    int update(Summary summary);

    int deleteSummary(@Param("summaryId") Integer summaryId);
}
