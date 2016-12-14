package akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by liguodong on 2016/11/16.
 */

public class Demo {

    public static void main(String[] args) {

        ActorSystem system = ActorSystem.create("actor-demo-java");

        ActorRef hello = system.actorOf(Props.create(Hello.class));

        hello.tell("Bob",ActorRef.noSender());

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            /* ignore */
        }

        system.shutdown();

    }


    private static class Hello extends UntypedActor{

        @Override
        public void onReceive(Object message) throws Exception {
            if(message instanceof String){
                System.out.println("Hello," + message+".");
            }
        }

    }

}
