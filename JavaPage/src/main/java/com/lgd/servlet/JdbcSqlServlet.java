package com.lgd.servlet;

import com.lgd.model.Pager;
import com.lgd.model.Student;
import com.lgd.service.StudentService;
import com.lgd.service.impl.JdbcSqlStudentServiceImpl;
import com.lgd.utils.Constant;
import com.lgd.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liguodong on 2016/1/21.
 */
public class JdbcSqlServlet extends HttpServlet {

    private static final long serialVersionUID = -3658128508633145268L;

    private static Logger logger = LoggerFactory.getLogger(SubListServlet.class);

    private StudentService studentService = new JdbcSqlStudentServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 接收request里的参数
        String name = request.getParameter("name"); //学生姓名

        // 获取学生性别
        int gender = Constant.DEFAULT_GENDER;
        String genderStr = request.getParameter("gender");

        if(genderStr!=null && !"".equals(genderStr.trim())){
            gender = Integer.parseInt(genderStr);
        }

        // 校验pageNum参数输入合法性
        String pageNumStr = request.getParameter("pageNum");
        if(pageNumStr !=null && !StringUtil.isNum(pageNumStr)){
            request.setAttribute("errorMsg", "参数传输错误");
            request.getRequestDispatcher("sublistStudent.jsp").forward(request, response);
            return;
        }

        int pageNum = Constant.DEFAULT_PAGE_NUM; //显示第几页数据
        if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
            pageNum = Integer.parseInt(pageNumStr);
        }

        int pageSize = Constant.DEFAULT_PAGE_SIZE;  // 每页显示多少条记录
        String pageSizeStr = request.getParameter("pageSize");
        if(pageSizeStr!=null && !"".equals(pageSizeStr.trim())){
            pageSize = Integer.parseInt(pageSizeStr);
        }

        // 组装查询条件
        Student searchModel = new Student();
        searchModel.setName(name);
        searchModel.setGender(gender);

        logger.info("查询数据");
        //调用service 获取查询结果
        Pager<Student> result = studentService.findStudent(searchModel,
                pageNum, pageSize);

        logger.info("返回数据");
        // 返回结果到页面
        request.setAttribute("result", result);
        request.setAttribute("name", name);
        request.setAttribute("gender", gender);

        logger.info("result:" + result + " name:" + name + " gender:" + gender);

        request.getRequestDispatcher("jdbcSqlStudent.jsp").forward(request, response);
        //request.getRequestDispatcher("demo.jsp").forward(request, response);


    }

}
