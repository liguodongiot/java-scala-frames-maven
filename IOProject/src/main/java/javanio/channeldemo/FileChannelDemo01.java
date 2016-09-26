package javanio.channeldemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel
 *
 * Created by liguodong on 2016/7/22.
 */
public class FileChannelDemo01 {

    public static void main(String[] args) throws Exception {
        //待输出的数据
        String info[] = {"liguodong","wintfru","java","github","csdn"};
        File file = new File("d:"+File.separator+"out.txt");

        //文件输出流
        FileOutputStream outputStream = null;
        //实例化输出流
        outputStream = new FileOutputStream(file);

        //声明输出的通道对象
        FileChannel fout = null;
        //得到输出的文件通道
        fout = outputStream.getChannel();

        //开辟缓冲
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //循环将内容写入缓冲
        for (int i = 0; i < info.length; i++) {
            buffer.put(info[i].getBytes());
        }
        //重设缓冲区
        buffer.flip();
        //输出
        fout.write(buffer);
        //关闭输出通道
        fout.close();
        //关闭输出流
        outputStream.close();

    }

}
