package forkjoin.section02;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来产生随机产品的数列。
 * Created by liguodong on 2016/11/18.
 */

public class ProductListGenerator {

    public List<Product> generate (int size) {

        //创建返回产品数列的对象。
        List<Product> ret=new ArrayList<Product>();

        //创建产品队列。给所有产品赋予相同值。
        // 比如，10用来检查程序是否工作得很好。
        for (int i=0; i<size; i++){
            Product product=new Product();
            product.setName("Product"+i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }

}
