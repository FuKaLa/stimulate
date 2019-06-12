package com.example.stimulate.service;

import com.example.stimulate.entity.Summary;

import java.security.PrivateKey;
import java.util.List;

/**
 * Created by Administrator on 2019/6/9.
 */
public interface SummaryService {

    int save(Summary summary);

    int update(Summary summary);

    List<Summary> getSummaryList(Integer userId);

    List<Summary> getSummaryAllList();

    Summary getSummaryDetail(Integer summaryId);

    int deleteSummary(Integer summaryId);
}
