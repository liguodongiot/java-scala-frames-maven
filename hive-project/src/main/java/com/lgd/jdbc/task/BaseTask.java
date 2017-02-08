package com.lgd.jdbc.task;

import com.lgd.jdbc.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * Created by liguodong on 2016/9/26.
 */

@Controller
public class BaseTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTask.class);

    @Autowired
    BaseService baseService;

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/*.xml");
        BaseTask baseTask = context.getBean(BaseTask.class);
        baseTask.doTask();

    }

    public void doTask(){
        boolean flag = baseService.checkTableResult();
        System.out.println(flag);
    }


}
