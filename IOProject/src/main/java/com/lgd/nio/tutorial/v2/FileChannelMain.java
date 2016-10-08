package com.lgd.nio.tutorial.v2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * Created by liguodong on 2016/9/28.
 */
public class FileChannelMain {
    public static void main(String[] args) throws IOException {

        String path = "D:"+ File.separator+"lilili.txt";

        RandomAccessFile aFile = new RandomAccessFile(path,"rw");

        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("\nRead " + bytesRead);

            //注意 buf.flip()的调用，首先读取数据到Buffer，然后反转Buffer,接着再从Buffer中读取数据。
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

}
