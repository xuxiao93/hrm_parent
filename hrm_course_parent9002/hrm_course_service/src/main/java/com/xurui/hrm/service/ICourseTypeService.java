package com.xurui.hrm.service;

import com.xurui.hrm.domain.CourseType;
import com.baomidou.mybatisplus.service.IService;
import com.xurui.hrm.query.CourseTypeQuery;
import com.xurui.hrm.util.PageList;

/**
 * <p>
 * 课程目录 服务类
 * </p>
 *
 * @author xuxiao
 * @since 2019-09-02
 */
public interface ICourseTypeService extends IService<CourseType> {

    /**
     * 高级查询+分页+关联查询
     * @param query
     * @return
     */
    PageList<CourseType> selectListPage(CourseTypeQuery query);
}
