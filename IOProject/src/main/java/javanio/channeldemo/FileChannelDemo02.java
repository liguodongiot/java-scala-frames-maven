package javanio.channeldemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel是双向操作的，可以同时完成输出和输入数据的功能。
 *
 * Created by liguodong on 2016/7/22.
 */
public class FileChannelDemo02 {

    public static void main(String[] args) throws Exception {

        File fileIn = new File("d:"+File.separator+"note.txt");
        File fileOut = new File("d:"+File.separator+"noteOut.txt");

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        fileInputStream = new FileInputStream(fileIn);
        fileOutputStream = new FileOutputStream(fileOut);

        FileChannel fin = null; //声明输入的通道对象
        FileChannel fout = null;

        fin = fileInputStream.getChannel();  //得到文件输入通道
        fout = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        int temp = 0;

        while((temp = fin.read(byteBuffer))!=-1){ //如果没读到低
            byteBuffer.flip();
            fout.write(byteBuffer);
            byteBuffer.clear();//清空缓冲区
        }
        fin.close();
        fout.close();
        fileInputStream.close();
        fileOutputStream.close();






    }


}
