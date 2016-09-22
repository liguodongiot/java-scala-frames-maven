package javanio.bufferdemo;

import java.nio.IntBuffer;

/**
 * 创建只读缓冲区 ，但是创建完毕之后不能改为可写状态
 * Created by liguodong on 2016/7/22.
 */
public class IntBufferDemo03 {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);

        IntBuffer read = null;

        for (int i = 0; i < 10; i++) {
            buffer.put(i*2+1);
        }

        read = buffer.asReadOnlyBuffer();//创建只读缓冲区

        read.flip();

        System.out.println("缓冲区中的内容：");
        while (read.hasRemaining()){
            int x = read.get();
            System.out.print(x+"/");
        }
        System.out.println();
        //read.put(20);

    }


}
