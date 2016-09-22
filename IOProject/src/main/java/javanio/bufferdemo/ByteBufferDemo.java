package javanio.bufferdemo;

import java.nio.ByteBuffer;

/**
 * 只有ByteBuffer可以创建直接缓冲区
 *
 * 好处；尽可能直接对其执行本机的IO操作。
 *
 * Created by liguodong on 2016/7/22.
 */
public class ByteBufferDemo {

    public static void main(String[] args) {

        ByteBuffer buffer = null;
        buffer = ByteBuffer.allocate(10); //开设直接缓冲区

        byte temp[] = {1,2,3,4,5};
        buffer.put(temp);
        buffer.flip();

        System.out.println("缓冲区的内容：");
        while(buffer.hasRemaining()){
            int x = buffer.get();
            System.out.print(x + "/");
        }

    }


}
