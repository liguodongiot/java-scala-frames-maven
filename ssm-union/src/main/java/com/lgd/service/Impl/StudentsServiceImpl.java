package com.lgd.service.impl;

import com.lgd.model.mapper.StudentsMapper;
import com.lgd.model.pojo.Students;
import com.lgd.service.IStudentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liguodong on 2016/1/18.
 */

@Service("studentsService")
public class StudentsServiceImpl implements IStudentsService {

    @Resource
    private StudentsMapper studentsMapper;

    @Override
    public Students getStudentsById(int studentsId) {
        return this.studentsMapper.selectByPrimaryKey(studentsId);
    }

}
