package design.effectivejava.chapter02.entity06;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by liguodong on 2016/12/5.
 */
public class Stack {

    private Object[] elements;

    private int size = 0;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack(){
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++]=e;
    }

    //栈内部维护做对象的过期引用
    public Object pop(){
        if(size==0){
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity(){
        if(elements.length==size){
            elements = Arrays.copyOf(elements,2*size+1);
        }
    }

}
