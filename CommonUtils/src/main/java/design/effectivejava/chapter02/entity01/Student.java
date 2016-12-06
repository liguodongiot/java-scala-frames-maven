package design.effectivejava.chapter02.entity01;

/**
 * Created by liguodong on 2016/12/2.
 */
public class Student {

    private String name;

    private Integer score;

    private Student(){}

    private Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public static Student newInstance(String name,Integer score){
        return new Student(name,score);
    }

    private final static Student GOOD_STUDENT = new Student("xiaoA",100);
    private final static Student BAD_STUDENT = new Student("xiaoE",60);


    public static Student getInstance(String grade){

        if(grade.equals("GOOD")){
            return GOOD_STUDENT;
        }else{
            return BAD_STUDENT;
        }

    }


}
