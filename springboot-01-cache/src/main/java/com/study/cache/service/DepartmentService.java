package com.study.cache.service;

import com.study.cache.bean.Department;
import com.study.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 缓存的数据能够存入redis
     * 但是第二次从缓存中查询就不能反序列化回来了
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id) {
        System.out.println("查询"+id+"号部门");
        Department department = departmentMapper.getDeptById(id);
        return department;
    }
}
