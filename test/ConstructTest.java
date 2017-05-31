package test;

/**
 * Created by 张志鹏 on 2017/4/30.
 */
public class ConstructTest {

    public static ConstructTest t1 = new ConstructTest();

    public static ConstructTest t2 = new ConstructTest();
    {
        System.out.println("构造块 ");
    }
    static {
        System.out.println("静态块 ");
    }

    public static void main(String[] args) {
        ConstructTest t = new ConstructTest();

    }
}


