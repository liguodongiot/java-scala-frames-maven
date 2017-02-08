package com.lgd.controller;

import com.lgd.model.pojo.Students;
import com.lgd.service.IStudentsService;
import org.apache.log4j.Logger;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by liguodong on 2016/1/18.
 */


@Controller
@RequestMapping("/students")
public class StudentsController {
    @Resource
    private IStudentsService studentsService;

    private static Logger logger = Logger.getLogger(StudentsController.class);

    //private static Logger logger = LoggerFactory.getLogger(StudentsController.class);



    @RequestMapping("/showStudents")
    public String toIndex(HttpServletRequest request,Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        logger.info("toIndex.........");
        Students students = this.studentsService.getStudentsById(userId);

        model.addAttribute("name", students.getName());

        return "showStudents";
    }
}

