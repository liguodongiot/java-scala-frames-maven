package com.lgd.dao.impl;

import com.lgd.dao.StudentDao;
import com.lgd.model.Pager;
import com.lgd.model.Student;
import com.lgd.utils.Constant;
import com.lgd.utils.JdbcUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 使用mysql数据库limit关键字实现分页
 * Created by liguodong on 2016/1/21.
 */
public class JdbcSqlStudentDaoImpl implements StudentDao{

    private static Logger logger = LoggerFactory.getLogger(SubListStudentDaoImpl.class);



    public Pager<Student> findStudent(Student searchModel,
                                      int pageNum,
                                      int pageSize) {

        Pager<Student> result = null;

        // 存放查询参数
        List<Object> paramList = new ArrayList<Object>();

        String name = searchModel.getName();
        int gender = searchModel.getGender();

        StringBuilder sql = new StringBuilder(
                "select * from student where 1=1");

        //统计总的记录数
        StringBuilder countSql = new StringBuilder(
                "select count(id) as totalRecord from student where 1=1 ");

        if (name != null && !name.equals("")) {
            sql.append(" and name like ?");
            countSql.append(" and name like ?");
            paramList.add("%" + name + "%");
        }

        if (gender == Constant.FEMALE || gender == Constant.MALE) {
            sql.append(" and gender = ?");
            countSql.append(" and gender = ?");
            paramList.add(gender);
        }

        // 起始索引
        int fromIndex	= pageSize * (pageNum -1);

        // 使用limit关键字，实现分页
        sql.append(" limit " + fromIndex + ", " + pageSize );


        // 存放所有查询出的学生对象
        List<Student> studentList = new ArrayList<Student>();


        Connection conn = JdbcUtil.getMysqlConn();//获取数据库的连接
        logger.info("连接成功");

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            //获取总的记录数
            List<Map<String,Object>> countResult =
                    JdbcUtil.findResult(conn, ps, rs, countSql.toString(), paramList);

            logger.info("查询结果："+countResult.size());

            Map<String,Object> countMap = countResult.get(0);//只有一条记录

            int totalRecord = ((Number)countMap.get("totalRecord")).intValue();


            // 获取查询的学生记录
            List<Map<String, Object>> studentResult = JdbcUtil.findResult
                    (conn, ps, rs, sql.toString(), paramList);

            if (studentResult != null) {
                for (Map<String, Object> map : studentResult) {

                    Student s = new Student(map);//一个学生

                    studentList.add(s);
                }
            }

            //获取总页数
            int totalPage = totalRecord / pageSize;
            if(totalRecord % pageSize !=0){
                totalPage++;
            }

            // 组装pager对象  pageNum表示当前页
            result = new Pager<Student>(pageSize, pageNum,
                    totalRecord, totalPage, studentList);


        } catch (SQLException e) {
            throw new RuntimeException("查询所有数据异常",e);
        }finally {
            JdbcUtil.close(rs,ps,conn);
        }

        return result;
    }
}
