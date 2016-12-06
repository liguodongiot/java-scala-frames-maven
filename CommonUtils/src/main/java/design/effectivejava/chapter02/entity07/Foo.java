package design.effectivejava.chapter02.entity07;

/**
 * Created by liguodong on 2016/12/6.
 */
//Finalizer Guardian idiom
public class Foo {

    //Sole purpose of this object is to finalize outer Foo object
    private final Object finalizerGuardian = new Object(){
        @Override protected  void finalize() throws Throwable{
            //Finalize outer Foo object
        }
    };

    //Remainder omitted


}
