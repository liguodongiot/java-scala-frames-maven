package javanio.bufferdemo;

import java.nio.IntBuffer;

/**
 * Created by liguodong on 2016/7/22.
 */
public class IntBufferDemo01 {
    public static void main(String[] args) {

        //开辟10个大小的缓冲区
        IntBuffer buffer = IntBuffer.allocate(10);

        System.out.println("1、写入数据之前的position、limit和capacity：");
        System.out.println("Position = " + buffer.position() + ",limit = "
                + buffer.limit() + ", capacity = " + buffer.capacity());

        int arr[] ={1,2,3,4};
        buffer.put(arr); //向缓冲区写入数据
        buffer.put(5);
        buffer.put(7);

        System.out.println("2、写入数据之后的position、limit和capacity：");
        System.out.println("Position = " + buffer.position() + ",limit = "
                + buffer.limit() + ", capacity = " + buffer.capacity());

        buffer.flip();//重设缓冲区

        System.out.println("3、准备输出数据时的position、limit和capacity：");
        System.out.println("Position = " + buffer.position() + ",limit = "
                + buffer.limit() + ", capacity = " + buffer.capacity());

        System.out.println("缓冲区的内容：");
        while(buffer.hasRemaining()){
            int x = buffer.get();//取出
            System.out.print(x + "/");
        }

        System.out.println();
        System.out.println("Position = " + buffer.position() + ",limit = "
                + buffer.limit() + ", capacity = " + buffer.capacity());

        buffer.flip();//重设缓冲区
        buffer.put(6);


        System.out.println("Position = " + buffer.position() + ",limit = "
                + buffer.limit() + ", capacity = " + buffer.capacity());
        System.out.println("缓冲区的内容：");
        while(buffer.hasRemaining()){
            int x = buffer.get();//取出
            System.out.print(x + "/");
        }
//        buffer.limit(8);
//        System.out.println("缓冲区的内容：");
//        while(buffer.hasRemaining()){
//            int x = buffer.get();//取出
//            System.out.print(x + "/");
//        }
//


    }

}
