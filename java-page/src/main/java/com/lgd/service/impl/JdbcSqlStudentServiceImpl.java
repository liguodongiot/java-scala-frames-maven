package com.lgd.service.impl;

import com.lgd.dao.StudentDao;
import com.lgd.dao.impl.JdbcSqlStudentDaoImpl;
import com.lgd.model.Pager;
import com.lgd.model.Student;
import com.lgd.service.StudentService;

/**
 * Created by liguodong on 2016/1/21.
 */
public class JdbcSqlStudentServiceImpl implements StudentService{

    private StudentDao studentDao;

    public JdbcSqlStudentServiceImpl() {
        studentDao = new JdbcSqlStudentDaoImpl();
    }

    public Pager<Student> findStudent(Student searchModel,
                                      int pageNum,
                                      int pageSize) {
        Pager<Student> result = studentDao.findStudent(
                searchModel,pageNum,pageSize);

        return result;
    }

}
