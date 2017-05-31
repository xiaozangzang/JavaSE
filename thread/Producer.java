package thread;

/**
 * Created by 张志鹏 on 2017/4/30.
 */
public class Producer implements Runnable {

    private Clerk clert;

    public Producer(Clerk clerk){
        this.clert = clerk;
    }
    @Override
    public void run() {
        System.out.println("生产者开始生产整数！");
        for(int product = 1;product <= 10;product++){
            try{
                clert.setProduct(product);
            }catch (InterruptedException ex){
                throw new RuntimeException();
            }
        }
    }
}
