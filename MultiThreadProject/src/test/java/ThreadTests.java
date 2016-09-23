

import com.lgd.jcip.Sequence;
import org.junit.Test;

/**
 * Created by liguodong on 2016/2/25.
 */

public class ThreadTests {

    @Test
    public void testThread(){
        new Runnable(){

            public void run() {
                new Sequence().getNext();
            }
        };


    }

}
