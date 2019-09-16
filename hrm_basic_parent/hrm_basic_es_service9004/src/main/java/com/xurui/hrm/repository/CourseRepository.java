package com.xurui.hrm.repository;


import com.xurui.hrm.doc.EsCourse;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CourseRepository extends ElasticsearchRepository<EsCourse,Long> {
}
