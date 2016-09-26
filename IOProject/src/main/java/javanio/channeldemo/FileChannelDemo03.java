package javanio.channeldemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件映射
 *
 * 使用MappedByteBuffer写入数据可能非常危险。
 * 因为修改数据与数据重新保存到磁盘是一样的。
 *
 * Created by liguodong on 2016/7/22.
 */
public class FileChannelDemo03 {

    public static void main(String[] args) throws Exception {
        File file = new File("d:"+File.separator+"note.txt");

        FileInputStream fileInputStream = null;
        FileChannel fin = null;
        MappedByteBuffer mbb = null; //声明文件的内存映射

        fileInputStream = new FileInputStream(file);
        fin = fileInputStream.getChannel();

        //将文件映射到内存中
        mbb = fin.map(FileChannel.MapMode.READ_ONLY,0,file.length());

        //开辟字节数组接收
        byte data[] = new byte[(int)file.length()];

        int foot = 0;
        while(mbb.hasRemaining()){
            data[foot++] = mbb.get();
        }
        System.out.println(new String(data));
        fin.close();
        fileInputStream.close();
    }
}
