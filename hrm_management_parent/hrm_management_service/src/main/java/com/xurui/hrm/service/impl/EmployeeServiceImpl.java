package com.xurui.hrm.service.impl;

import com.xurui.hrm.domain.Employee;
import com.xurui.hrm.mapper.EmployeeMapper;
import com.xurui.hrm.service.IEmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuxiao
 * @since 2019-09-02
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
