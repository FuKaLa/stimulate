package com.example.stimulate.service;

import com.example.stimulate.entity.ChatRecord;
import com.example.stimulate.entity.ChatRecordVO;
import com.example.stimulate.entity.TeamMembers;

import java.util.List;

/**
 * Created by Administrator on 2019/6/9.
 */
public interface ChatRecordService {

    int save(ChatRecord chatRecord);

    List<ChatRecordVO> getTeamChatRecord(Integer teamId);

    List<TeamMembers> getListByTeamId(Integer teamId);

//    int saveAlone(Integer tId ,Integer sId);
}
