package com.cx.mybatis.dao.mapper;

import com.cx.mybatis.bean.Dept;
import com.cx.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeptMapper {

    public Dept getDeptById(Integer id);

    public Dept getDeptByIdPlus(Integer id);

    /**延迟加载 分步查询
     * @param id
     * @return
     */
    public Dept getDeptByIdStep(Integer id);
}
