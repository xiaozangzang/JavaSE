package thread;

/**
 * Created by 张志鹏 on 2017/4/30.
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        new Thread(new Producer(clerk)).start();
        new Thread(new Consumer(clerk)).start();
    }
}
