package com.example.stimulate.service;

import com.example.stimulate.entity.Team;
import com.example.stimulate.entity.TeamVO;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/6.
 */
public interface TeamService {


    int save(Team team);

    List<TeamVO> getJoinList(Integer userId);

    List<TeamVO> getTeamList(String name);

    TeamVO getTeamDetail(Integer id);

    int existTeamUser(Integer userId,Integer teamId);

    int saveTeamUser(Integer userId,Integer teamId,Integer roleId);
    //判断是否可以加入①人数是否满员②时间是否截至
    int checkJoin(Integer teamId) throws ParseException;

    int deleteTeamUser(Integer userId,Integer teamId);

}
