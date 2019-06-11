package com.example.stimulate.service.impl;

import com.example.stimulate.dao.ChatRecordDao;
import com.example.stimulate.dao.TeamDao;
import com.example.stimulate.entity.ChatRecord;
import com.example.stimulate.entity.ChatRecordVO;
import com.example.stimulate.entity.TeamMembers;
import com.example.stimulate.service.ChatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/6/9.
 */
@Service
public class ChatRecordServiceImpl implements ChatRecordService {

    @Autowired
    private ChatRecordDao chatRecordDao;

    @Autowired
    private TeamDao teamDao;

    @Override
    public int save(ChatRecord chatRecord) {
        return chatRecordDao.save(chatRecord);
    }

    @Override
    public List<ChatRecordVO> getTeamChatRecord(Integer teamId) {
        return chatRecordDao.getTeamChatRecord(teamId);
    }

    @Override
    public List<TeamMembers> getListByTeamId(Integer teamId) {
        return teamDao.getListByTeamId(teamId);
    }
}
