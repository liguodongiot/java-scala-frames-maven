package com.lgd.dao.impl;

import com.lgd.dao.StudentDao;
import com.lgd.model.Pager;
import com.lgd.model.Student;
import com.lgd.utils.Constant;
import com.lgd.utils.JdbcUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * sublist方式实现分页
 * Created by liguodong on 2016/1/20.
 */
public class SubListStudentDaoImpl implements StudentDao{

    private static Logger logger = LoggerFactory.getLogger(SubListStudentDaoImpl.class);



    public Pager<Student> findStudent(Student searchModel, int pageNum, int pageSize) {

        List<Student> allStudent = getAllStudent(searchModel);

        logger.info("学生人数:"+allStudent.size());

        logger.info("开始分页");
        Pager<Student> pager = new Pager<Student>(pageNum,pageSize,allStudent);
        logger.info("结束分页");
        return pager;
    }

    /**
     * 模仿获取所有数据
     * @param searchModel   查询参数
     * @return  查询结果
     */
    private List<Student> getAllStudent(Student searchModel){
        List<Student> result = new ArrayList<Student>();//返回值

        //参数列表
        List<Object> paramList = new ArrayList<Object>();

        //获取姓名与性别进行过滤
        String name = searchModel.getName();
        int gender = searchModel.getGender();

        StringBuilder sql = new StringBuilder("select * from student where 1=1");

        if(name!=null && name.equals("")){
            sql.append(" and name like ?");
            paramList.add("%" + name  + "%");
        }

        if(gender == Constant.MALE || gender == Constant.FEMALE){
            sql.append(" and gender=?");
            paramList.add(gender);
        }


        Connection conn = JdbcUtil.getMysqlConn();//获取数据库的连接
        logger.info("连接成功");

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            List<Map<String,Object>> mapList =
                    JdbcUtil.findResult(conn, ps, rs, sql.toString(), paramList);

            logger.info("查询结果："+mapList.size());


            if (mapList != null){
                for (Map<String,Object> map:mapList){
                    Student s = new Student(map);//将Map转化成学生
                    result.add(s);//将学生放入结果街
                }
            }

        } catch (SQLException e) {
           throw new RuntimeException("查询所有数据异常",e);
        }finally {
            JdbcUtil.close(rs,ps,conn);
        }

        return result;

    }
}


