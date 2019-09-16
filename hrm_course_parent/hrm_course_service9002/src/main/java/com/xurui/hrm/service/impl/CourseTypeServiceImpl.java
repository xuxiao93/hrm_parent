package com.xurui.hrm.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.xurui.hrm.domain.CourseType;
import com.xurui.hrm.mapper.CourseTypeMapper;
import com.xurui.hrm.query.CourseTypeQuery;
import com.xurui.hrm.service.ICourseTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xurui.hrm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程目录 服务实现类
 * </p>
 *
 * @author xuxiao
 * @since 2019-09-05
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements ICourseTypeService {
    @Autowired
    private CourseTypeMapper courseTypeMapper;

    @Override
    public PageList<CourseType> selectListPage(CourseTypeQuery query) {
        Page page = new Page(query.getPage(),query.getRows()); //Page
        List<CourseType> courseTypes = courseTypeMapper.loadListPage(page, query);
        return new PageList<>(page.getTotal(),courseTypes);
    }

    @Override
    public List<CourseType> queryTypeTree(Long pid) {
        return getCourseTypeLoop(pid);
    }

    private List<CourseType> getCourseTypeLoop(Long pid) {
        List<CourseType> result = new ArrayList<>();
        //查询所有类型
        List<CourseType> courseallTypes = courseTypeMapper.selectList(null);
        //建立ID和coursetype的关系
        Map<Long, CourseType> allTypesDto = new HashMap<>();
        for (CourseType courseType : courseallTypes) {
            //把id和类型放入map
            allTypesDto.put(courseType.getId(), courseType);
        }
        //判断是否是第一级
        for (CourseType type : courseallTypes) {
            Long pid1 = type.getPid();
            if (pid1.longValue()==pid.longValue()){
                //如果是直接添加入列表
                result.add(type);
            }else {
                //不是就把自己作为子类
                CourseType parent = allTypesDto.get(pid1);
                parent.getChildren().add(type);
            }
        }
        return result;
    }

}
