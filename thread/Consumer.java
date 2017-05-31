package thread;

/**
 * Created by 张志鹏 on 2017/4/30.
 */
public class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(){}
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        System.out.println("消费者开始消耗整数！");
        for(int i = 1;i <=10;i ++){
            try{
                clerk.getProduct();
            }catch (InterruptedException ex){
                throw new RuntimeException();
            }
        }
    }
}
