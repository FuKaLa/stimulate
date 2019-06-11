package com.example.stimulate.dao;

import com.example.stimulate.entity.ChatRecord;
import com.example.stimulate.entity.ChatRecordVO;
import com.example.stimulate.entity.TeamMembers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2019/6/9.
 */
@Mapper
@Repository
public interface ChatRecordDao {

    int save(ChatRecord chatRecord);

    List<ChatRecordVO> getTeamChatRecord(@Param("teamId") Integer teamId);


}
