package com.example.stimulate.service.impl;

import com.example.stimulate.StimulateApplication;
import com.example.stimulate.dao.TeamDao;
import com.example.stimulate.entity.Team;
import com.example.stimulate.entity.TeamVO;
import com.example.stimulate.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/6/6.
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDao teamDao;

    @Override
    public int save(Team team) {
        return teamDao.save(team);
    }

    @Override
    public List<TeamVO> getJoinList(Integer userId) {
        List<TeamVO> list = teamDao.getJoinList(userId);
        if (CollectionUtils.isEmpty(list)){
            return list;
        }
        //查询团队加入的人数
        for(TeamVO aList :list){
            Integer count = teamDao.getJoinCount(aList.getId());
            if(count != null){
                aList.setJoinCount(count);
            }
        }
        return list;
    }

    @Override
    public List<TeamVO> getTeamList(String name) {
        //查询所有的团队
        List<TeamVO> allList = teamDao.getTeamList(name);
        if (CollectionUtils.isEmpty(allList)){
            return allList;
        }
        //查询团队加入的人数
        for(TeamVO aList :allList){
            Integer count = teamDao.getJoinCount(aList.getId());
            if(count != null){
                aList.setJoinCount(count);
            }
        }
        return allList;
    }

    @Override
    public TeamVO getTeamDetail(Integer id) {
        return teamDao.getTeamDetail(id);
    }

    @Override
    public int existTeamUser(Integer userId, Integer teamId) {
        return teamDao.existTeamUser(userId,teamId);
    }

    @Override
    public int saveTeamUser(Integer userId, Integer teamId, Integer roleId) {
        return teamDao.saveTeamUser(userId,teamId,roleId);
    }

    @Override
    public int checkJoin(Integer teamId) throws ParseException {
        TeamVO vo = teamDao.getTeamDetail(teamId);
        //判断是否可以加入①人数是否满员②时间是否截至
        //1.查询需要团队人数
        Integer allCount = vo.getTeamCount();
        //2.团队总人数
        Integer count = null;
        //3.截至时间
        String deadTime = vo.getDeadtime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String nowTime = df.format(new Date());// new Date()为获取当前系统时间

        if(allCount == 0){
            if(dateCom(nowTime,deadTime)){
                return 0;//可以报名
            }
            return 1;//报名时间截至

        }else {
            count = teamDao.getJoinCount(teamId);
            if(allCount > count){
                //判断时间是否满足
                if(dateCom(nowTime,deadTime)){
                    return 0;//可以报名
                }
                return 1;//报名时间截至
            }
            return 2;//人数已满
        }

    }

    @Override
    public int deleteTeamUser(Integer userId, Integer teamId) {
        return teamDao.deleteTeamUser(userId,teamId);
    }


    public static boolean dateCom(String time1,String time2)throws ParseException{

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date a = format.parse(time1);
        Date b = format.parse(time2);

        if(a.before(b)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        boolean b = dateCom("2017-09-09", "2019-09-08");
        if(b){
            System.out.println(77);
        }
        System.out.println("===================项目启动");
    }


}
