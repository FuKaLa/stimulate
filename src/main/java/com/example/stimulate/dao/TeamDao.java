package com.example.stimulate.dao;

import com.example.stimulate.entity.Team;
import com.example.stimulate.entity.TeamMembers;
import com.example.stimulate.entity.TeamVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/6.
 */
@Mapper
@Repository
public interface TeamDao {

    int save(Team team);

    List<TeamVO> getJoinList(@Param("userId") Integer userId);

    Integer getJoinCount(@Param("id") Integer id);

    List<TeamVO> getTeamList(Map<String, Object> map);

    TeamVO getTeamDetail(@Param("id") Integer id);

    int saveTeamUser(@Param("userId") Integer userId,@Param("teamId") Integer teamId,@Param("roleId") Integer roleId);

    int existTeamUser(@Param("userId") Integer userId,@Param("teamId") Integer teamId);

    List<TeamMembers> getListByTeamId(@Param("teamId") Integer teamId);

    Integer getTeamCount(@Param("id") Integer id);

    int deleteTeamUser(@Param("userId") Integer userId,@Param("teamId") Integer teamId);
}
