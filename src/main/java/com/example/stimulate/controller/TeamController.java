package com.example.stimulate.controller;

import com.example.stimulate.entity.Plan;
import com.example.stimulate.entity.Team;
import com.example.stimulate.entity.TeamVO;
import com.example.stimulate.service.TeamService;
import com.example.stimulate.utils.R;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 创建团队相关
 * 团队的查询、已加入、未加入的团队查询、详情、修改、解散、人员的调整
 * 团队加入
 */
@CrossOrigin
@Controller
@RequestMapping("/team")
public class TeamController extends BaseController {
    @Autowired
    private TeamService teamService;

    /**
     * 团队创建
     */
    @ResponseBody
    @RequestMapping("/save")
    public R saveTeam(@RequestBody Team team){
        team.setCity("上海");
        team.setSchool("上海商学院");
        if(teamService.save(team)<1){
            return R.error();
        }
        return R.ok();
    }

    /**
     * 已加入团队的查询
     */
    @ResponseBody
    @RequestMapping("/getJoinList")
    public R getJoinList(Integer userId){
        return R.resultData(teamService.getJoinList(userId));
    }

    /**
     * 查询团队 TODO 用户id
     */
    @ResponseBody
    @RequestMapping("/getNotJoinList")
    public R  getNotJoinList(@RequestParam() Map<String, Object> params){
        //查询列表数据
        setPage(params);
        List<TeamVO> courseList = teamService.getTeamList(params);
        Page<TeamVO> list = (Page<TeamVO>) courseList;
        return R.resultData(list);
    }

    /**
     * 团队详情查询
     */
    @ResponseBody
    @RequestMapping("/getTeamDetail")
    public R getTeamDetail(Integer teamId){
        return R.resultData(teamService.getTeamDetail(teamId));
    }

//    /**
//     * 团队信息修改
//     */
//    @ResponseBody
//    @RequestMapping("/update")
//    public Team update(@RequestParam Team team){
//        return teamService.updateTeam(team);
//    }

    /**
     * 团队人员加入
     */
    @ResponseBody
    @RequestMapping("/join")
    public R saveTeamUser(Integer userId,Integer teamId,Integer roleId){
        //判断用户是否已经加入
        if(teamService.existTeamUser(userId,teamId)>0){
            return R.ok();
        }
        //判断是否可以加入①人数是否满员②时间是否截至
        //0 可以报名  1 报名时间截至  2 人数已满
        int flag = teamService.checkJoin(teamId);
        if(flag == 0){
            if( teamService.saveTeamUser(userId,teamId,roleId) < 1){
                return R.error();
            }
        }
        if(flag == 1){
            return R.error("报名时间截至");
        }
        if(flag == 2){
            return R.error("人数已满");
        }
        return R.ok();
    }

    /**
     * 团队人员删除
     */
    @ResponseBody
    @RequestMapping("/deleteTeamUser")
    public R deleteTeamUser(Integer userId,Integer teamId){
        if(teamService.deleteTeamUser(userId,teamId) < 1){
            return R.error();
        }
        return R.ok();
    }

}
