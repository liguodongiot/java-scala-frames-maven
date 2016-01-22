package com.lgd.service.impl;

import com.lgd.dao.StudentDao;
import com.lgd.dao.impl.SubListStudentDaoImpl;
import com.lgd.model.Pager;
import com.lgd.model.Student;
import com.lgd.service.StudentService;

/**
 * Created by liguodong on 2016/1/21.
 */
public class SubListStudentServiceImpl implements StudentService{

    private StudentDao studentDao;

    public SubListStudentServiceImpl(){
        //创建service实现类时，初始化dao对象。
        studentDao = new SubListStudentDaoImpl();
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Pager<Student> findStudent(Student searchModel,
                                      int pageNum, int pageSize) {

        Pager<Student> result = studentDao.findStudent(searchModel,pageNum,pageSize);

        return result;
    }
}
