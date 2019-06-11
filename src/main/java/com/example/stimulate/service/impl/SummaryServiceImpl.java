package com.example.stimulate.service.impl;

import com.example.stimulate.dao.SummaryDao;
import com.example.stimulate.entity.Summary;
import com.example.stimulate.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/6/9.
 */
@Service
public class SummaryServiceImpl implements SummaryService {
    @Autowired
    private SummaryDao summaryDao;

    @Override
    public int save(Summary summary) {
        return summaryDao.save(summary);
    }

    @Override
    public int update(Summary summary) {
        return summaryDao.update(summary);
    }

    @Override
    public List<Summary> getSummaryList(Integer userId) {
        return summaryDao.getSummaryList(userId);
    }

    @Override
    public Summary getSummaryDetail(Integer summaryId) {
        return summaryDao.getSummaryDetail(summaryId);
    }

    @Override
    public int deleteSummary(Integer summaryId) {
        return summaryDao.deleteSummary(summaryId);
    }
}
