package com.example.stimulate.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2019/6/9.
 */
public class PageUtils {

    /**
     * 封装请求参数
     *
     * @param request
     * @return
     */
    public static Map<String, Object> getParametersMap(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map m = request.getParameterMap();
        for (Iterator iter = m.entrySet().iterator(); iter.hasNext(); ) {
            Map.Entry element = (Map.Entry) iter.next();
            map.put(element.getKey().toString(), ((String[]) element.getValue())[0]);
            System.out.println(element.getKey().toString() + "=" + ((String[]) element.getValue())[0]);
        }
        return map;
    }

    /**
     * 传入request获取前台传来的分页参数
     *
     * @param request
     */
    public void setPage(HttpServletRequest request) {
        String page = request.getParameter("page");
        int pageNum = Constant.DEFAULT_PAGENUM;
        if (page != null && page.trim().length() != 0) {
            pageNum = Integer.parseInt(page);
        }
        int rows;
        if (ObjectUtils.isEmpty(request.getParameter("rows"))) {
            rows = Constant.DEFAULT_ROWS;
        } else {
            rows = Integer.valueOf(request.getParameter("rows"));
        }
	/*	PageHelper.startPage(pageNum, rows);*/
    }

    /**
     * 传入request获取前台传来的分页参数
     *
     * @param requestMap 获取参数
     */
    public void setPage(Map<String, Object> requestMap) {
        String page = (String) requestMap.get("page");
        Integer pageInt;
        boolean pageFlag = ObjectUtils.isEmpty(page);
        if (!pageFlag && page.matches("^[0-9]*$")) {
            pageInt = Integer.parseInt(page);
        } else {
            pageInt = Constant.DEFAULT_PAGENUM;
        }
        String rows = (String) requestMap.get("rows");
        Integer rowsInt;
        boolean rowsFlag = ObjectUtils.isEmpty(rows);
        if (!rowsFlag && rows.matches("^[0-9]*$")) {
            rowsInt = Integer.parseInt(rows);
        } else {
            rowsInt = Constant.DEFAULT_ROWS;
        }
        PageHelper.startPage(pageInt, rowsInt);

    }

    /**
     * <p>
     * Title: jsonToListMap
     * </p>
     * <p>
     * Description:要求json
     * 格式为[{"k":"v","k":"v"},{"k":"v","k":"v"},{"k":"v","k":"v"}]
     * </p>
     *
     * @param json
     * @return
     */
    protected List<Map<String, Object>> jsonToListMap(String json) {

        TypeReference<List<Map<String, Object>>> typef = new TypeReference<List<Map<String, Object>>>() {
        };
        ObjectMapper omp = new ObjectMapper();
        Object jsonObj = com.alibaba.fastjson.JSONArray.parse(json);//
        List<Map<String, Object>> tableList = omp.convertValue(jsonObj, typef);
        return tableList;

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 严格限制日期转换
        sdf.setLenient(false);

        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    /**
     * 开启分页
     * @param page 当前页数
     * @param rows 每页记录数
     */
    public void startPage(String page, String rows) {
        Integer pageInt;
        boolean pageFlag = ObjectUtils.isEmpty(page);
        if (!pageFlag && page.matches("^[0-9]*$")) {
            pageInt = Integer.parseInt(page);
        } else {
            pageInt = Constant.DEFAULT_PAGENUM;
        }
        Integer rowsInt;
        boolean rowsFlag = ObjectUtils.isEmpty(rows);
        if (!rowsFlag && rows.matches("^[0-9]*$")) {
            rowsInt = Integer.parseInt(rows);
        } else {
            rowsInt = Constant.DEFAULT_ROWS;
        }
        PageHelper.startPage(pageInt, rowsInt);
    }
}
