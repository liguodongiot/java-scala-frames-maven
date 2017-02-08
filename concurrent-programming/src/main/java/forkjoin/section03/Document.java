package forkjoin.section03;

import java.util.Random;

/**
 * 将产生用来模拟文档的字符串的二维数组。
 * Created by liguodong on 2016/11/18.
 */
public class Document {

    //创建一个带有一些单词的字符串数组。这个数组将被用来生成字符串二维数组。
    private String words[]={"the","hello","goodbye","packt", "java","thread","pool","random","class","main"};


    //它接收以下参数：行数、每行的单词数。
    // 这个例子返回一个字符串二维数组，来表示将要查找的单词。
    public String[][] generateDocument(int numLines, int numWords,String word){

        //创建生成这个文档必需的对象：字符串二维对象和生成随机数的Random对象。
        int counter=0;
        String document[][]=new String[numLines][numWords];
        Random random=new Random();

        //用字符串填充这个数组。存储在每个位置的字符串是单词数组的随机位置，
        // 统计这个程序将要在生成的数组中查找的单词出现的次数。你可以使用这个值来检查程序是否执行正确。
        for (int i=0; i<numLines; i++){
            for (int j=0; j<numWords; j++) {
                int index=random.nextInt(words.length);
                document[i][j]=words[index];
                if (document[i][j].equals(word)){
                    counter++;
                }
            }
        }

        //将单词出现的次数写入控制台，并返回生成的二维数组。
        System.out.println("DocumentMock: The word appears "+counter+" times in the document");
        return document;

    }

}
