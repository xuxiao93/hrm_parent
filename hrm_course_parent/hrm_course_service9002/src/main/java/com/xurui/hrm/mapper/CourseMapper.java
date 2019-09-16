package com.xurui.hrm.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.xurui.hrm.domain.Course;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xurui.hrm.query.CourseQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuxiao
 * @since 2019-09-05
 */
public interface CourseMapper extends BaseMapper<Course> {
    List<Course> loadListPage(Page<Course> page, @Param("query") CourseQuery query);

    /**
     *
     * @param ids
     */
    void batchOnline(List<Long> ids);

    /**
     * 下线
     * @param ids
     */
    void batchOffline(List<Long> ids);

}
