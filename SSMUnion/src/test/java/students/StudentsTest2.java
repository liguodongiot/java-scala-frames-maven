package students;

import com.alibaba.fastjson.JSON;
import com.lgd.model.pojo.Students;
import com.lgd.service.IStudentsService;
import org.apache.log4j.Logger;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import util.logger.JUnit4ClassRunner;

import javax.annotation.Resource;



/**
 * 对比StudentsTest和StudentsTest2
 *
 * StudentsTest（需要将log4j.properties放在resource目录下）
 * @RunWith(SpringJUnit4ClassRunner.class)
 *
 *
 * StudentsTest2
 * 自己实现了JUnit4ClassRunner类，指定log4j.properties的位置
 * @RunWith(JUnit4ClassRunner.class)
 *
 *
 * Created by liguodong on 2016/1/18.
 */

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/config/spring-mybatis-cfg.xml"})
public class StudentsTest2 {
    private static Logger logger = Logger.getLogger(StudentsTest2.class);

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

