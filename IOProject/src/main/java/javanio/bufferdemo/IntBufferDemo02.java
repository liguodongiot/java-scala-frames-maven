package javanio.bufferdemo;

import java.nio.IntBuffer;

/**
 * 创建子缓冲区
 * Created by liguodong on 2016/7/22.
 */
public class IntBufferDemo02 {

    public static void main(String[] args) {

        IntBuffer buf = IntBuffer.allocate(10);
        IntBuffer sub = null; //定义缓冲区对象

        for (int i = 0; i < 10; i++) {
            buf.put(2*i+1);
        }

        buf.position(2);//主缓冲区指针设置在第三个元素上

        buf.limit(6);//主缓冲区limit为6
        sub = buf.slice(); //开辟子缓冲区

        for (int i = 0; i < sub.capacity(); i++) {
            int temp = sub.get(i); //根据下标获取元素
            sub.put(temp-1);    //修改缓冲区内容
        }

        buf.flip(); //重设缓冲区
        buf.limit(buf.capacity()); //设置limit
        System.out.println("主缓冲区中的内容：");
        while(buf.hasRemaining()){
            int x = buf.get();
            System.out.print(x+"/");
        }

        //修改了子缓冲区的内容，因为是共享数据，所以主缓冲区的内容也一起改变。




    }


}
