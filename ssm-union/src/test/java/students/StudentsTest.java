package students;

import com.alibaba.fastjson.JSON;
import com.lgd.model.pojo.Students;
import com.lgd.service.IStudentsService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 *
 * 测试类中注释掉的部分是不使用Spring时，
 * 一般情况下的一种测试方法；如果使用了Spring那么就可以使用注解的方式来
 * 引入配置文件和类，然后再将service接口对象注入，就可以进行测试了。
 * 如果测试成功，表示Spring和Mybatis已经整合成功了。
 * 输出信息使用的是Log4j打印到控制台。
 *
 *
 * Created by liguodong on 2016/1/18.
 */

//表示继承了SpringJUnit4ClassRunner类
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath*:/config/spring-mybatis-cfg.xml"})
public class StudentsTest {
    private static Logger logger = Logger.getLogger(StudentsTest.class);

    //	private ApplicationContext ac = null;

    //@Autowired
    @Resource
    private IStudentsService studentsService = null;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

    @Test
    public void test() {
        logger.info("开始执行...");
        Students students = studentsService.getStudentsById(1);
        // System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());
        System.out.println(students.getName());
        logger.info(JSON.toJSONString(students));
        logger.info("结束执行...");
    }
}

