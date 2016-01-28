package com.lgd.application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liguodong on 2016/1/27.
 */

public class Main {
    //匹配邮箱
    //([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,5})+
    private static String regex = "([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,5})+";

    private static Log log = LogFactory.getLog(Main.class);


    public static void main(String[] args) {
        FilterUser f1 = new FilterUser();
        f1.setId(10); //查询id为10的用户

        FilterUser f2 = new FilterUser();
        f2.setUsername("wintfru");   //查询用户名为wintfru的用户
        f2.setAge(22);
        f2.setEmail("liguodong@163.com");

        //查询邮箱为其中任意一个的用户
        FilterUser f3 = new FilterUser();
        f3.setEmail("liguodong@163.com; 66668888@qq.com; thinkpad@sina.com");

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);


        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);


        FilterDepartment fd1 = new FilterDepartment();
        fd1.setName("项目研发部");
        fd1.setAmount(10);;
        String sql4 = query(fd1);
        System.out.println(sql4);
    }



    public static String query(Object filter){
        StringBuilder sb = new StringBuilder();

        //1.获取到class
        Class c = filter.getClass();
        //2.获取到table的名字
        boolean exists = c.isAnnotationPresent(Table.class);
        if(!exists){
            return null;
        }

        Table table = (Table)c.getAnnotation(Table.class);
        String tableName = table.value(); //表名

        sb.append("select * from ").append(tableName).append(" where 1=1");

        //3.遍历所有的字段
        Field[] fArray = c.getDeclaredFields();

        for (Field field:fArray){
            //4.处理每个字段对应的sql
            //4.1 拿到字段名
            boolean fExists = field.isAnnotationPresent(Column.class);

            if (!fExists){
                continue;
            }

            Column column = field.getAnnotation(Column.class);
            String columnName = column.value(); //字段名 注解上面的值

            log.info("columnName:"+columnName);
            log.info("fieldName:"+field.getName());

            //4.2 拿到字段的值
            String fieldName = field.getName(); //属性值
            String getMethodName = "get" +
                    fieldName.substring(0,1).toUpperCase() +
                    fieldName.substring(1);

            Object fieldValue = null;
            try {
                Method getMethod = c.getMethod(getMethodName);

                //通过反射调用
                fieldValue = getMethod.invoke(filter,null);

            } catch (Exception e) {
                e.printStackTrace();
            }

            if(fieldValue == null || (fieldValue instanceof Integer && (Integer)fieldValue ==0)) {
                continue;
            }


            //4.3 拼装sql
            sb.append(" and ").append(fieldName);

            if (fieldValue instanceof String){

                Pattern pattern = Pattern.compile(regex);

                Matcher matcher = pattern.matcher((String)fieldValue);


                if(!matcher.find()) {
                    sb.append(" = ").append("'").append(fieldValue).append("'");
                }
                else{
                    sb.append(" in ( ");
                    String temp = matcher.group();
                    sb.append("'").append(temp).append("'");
                    while (matcher.find()){
                        temp = matcher.group();
                        sb.append(", ").append("'").append(temp).append("'");
                    }

                    sb.append(" )");
                }




            }else if(fieldValue instanceof Integer){
                sb.append(" = ").append(fieldValue);
            }


        }

        return sb.toString();
    }


}
