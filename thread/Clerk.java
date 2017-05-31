package thread;

/**
 * Created by 张志鹏 on 2017/4/30.
 */
public class Clerk {

    private int product = -1;//-1表示没有产品

    public synchronized void setProduct(int product) throws InterruptedException{
        waitIfFull();
        this.product = product;
        System.out.println("生产者设定 "+this.product);
        notify();
    }

    private synchronized void waitIfFull() throws InterruptedException{
        while(this.product != -1){
            wait();

        }
    }
    public synchronized int getProduct() throws InterruptedException{
        waitIfEmpty();
        int p = this.product;
        this.product = -1;
        System.out.println("消费者取走"+p);
        notify();
        return p;
    }
    public synchronized void waitIfEmpty() throws InterruptedException{
        while(this.product == -1){
            wait();
        }
    }
}
