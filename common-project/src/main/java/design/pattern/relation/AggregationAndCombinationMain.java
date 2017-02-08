package design.pattern.relation;

/**
 * 聚合：属性  整体与部分 不一致的生命周期 人与手
 * 组合：属性 整体与部分 一致的生命周期 人与大脑
 * Created by liguodong on 2016/10/14.
 */
public class AggregationAndCombinationMain {
    public static void main(String[] args) {
        PersonOne personOne = new PersonOne();
        PersonTwo personTwo = new PersonTwo();

    }
}


class Hand{ }
class Computer{ }


//组合：
class PersonOne{
    private Hand hand;
    public PersonOne(){ hand = new Hand(); }
}


//聚合：
class PersonTwo{
    private Computer computer;
    public void setComputer(){ computer = new Computer(); }
}
