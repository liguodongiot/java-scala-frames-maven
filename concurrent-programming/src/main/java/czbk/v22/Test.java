package czbk.v22;

/**
 * Created by liguodong on 2016/9/25.
 */
//不能改动此TestBefore类
public class Test extends Thread{
    //private TestDoBefore testDo;
    private TestDoAfter testDo;
    private String key;
    private String value;

    public Test(String key, String key2, String value) {
        //this.testDo = TestDoBefore.getInstance();

        this.testDo = TestDoAfter.getInstance();
        /*
        常量"1"和"1"是同一个对象，下面这行代码就是要用"1"+""的方式产生新的对象，
        以实现内容没有改变，仍然相等（都还为"1"），但对象却不再是同一个的效果
        */
        this.key = key+key2;
        /**
         * a = "1"+""
         * b = "1"+""
         * a和b是同一个对象
         * 但是this.key = key+key2 不是同一个对象，因为是变量+变量。
         */


        this.value = value;
    }

    public static void main(String[] args) {
        Test a = new Test("1","","1");
        Test b = new Test("1","","2");
        Test c = new Test("3","","3");
        Test d = new Test("4","","4");
        System.out.println("begin:"+(System.currentTimeMillis()/1000));
        a.start();
        b.start();
        c.start();
        d.start();
    }

    public void run(){
        testDo.doSome(key,value);
    }

}
