package czbk.v8;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by liguodong on 2016/9/11.
 */
public class SequencerMain {

    public static void main(String[] args) {
        final Sequencer sequencer = new Sequencer();
        //System.out.println(sequencer.next());
        //System.out.println(sequencer.next());
        //System.out.println(sequencer.next());

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"--"+sequencer.next());
                }

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()+"--"+sequencer.next());
                }

            }
        }).start();
    }
}

class Sequencer {
    //初始值为0
    private final AtomicLong sequenceNumber
            = new AtomicLong(0);
    public long next() {
        return sequenceNumber.getAndIncrement();
    }
}
