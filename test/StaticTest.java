package test;

/**
 * 执行顺序：
 * 父类静态代码块>子类静态代码块>父类代码块>父类构造器>子类代码块>子类构造器
 * Created by 张志鹏 on 2017/4/29.
 */
public class StaticTest {
    public static void main(String[] args) {
        new Child();
    }
}

class Parent{
    static String name = "hello";
        {
        System.out.println("parent block");
        }
        static {
        System.out.println("parent static block");
        }
        public Parent(){
        System.out.println("parent constructor");
        }
        }

class Child extends Parent{
    static String childName = "hello";
    {
        System.out.println("child block");
    }
    static {
        System.out.println("child static block");
    }
    public Child(){
        System.out.println("child constructor");
    }
}