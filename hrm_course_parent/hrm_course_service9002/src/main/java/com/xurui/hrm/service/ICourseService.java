package com.xurui.hrm.service;

import com.xurui.hrm.domain.Course;
import com.baomidou.mybatisplus.service.IService;
import com.xurui.hrm.query.CourseQuery;
import com.xurui.hrm.util.PageList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuxiao
 * @since 2019-09-05
 */
public interface ICourseService extends IService<Course> {
    /**
     * 分页+高级查询+关联查询
     * @param query
     * @return
     */
    PageList<Course> selectListPage(CourseQuery query);

    /**
     * 上线
     * @param ids
     */
    void onLine(Long[] ids);

    /**
     *
     * @param ids
     */
    void offLine(Long[] ids);
}
