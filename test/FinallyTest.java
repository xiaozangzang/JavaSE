package test;

/**
 * Created by 张志鹏 on 2017/4/29.
 */
public class FinallyTest {
    public static void main(String[] args) {
        System.out.println(new A().test());
        System.out.println(new B().test());
        System.out.println(new C().test());
        System.out.println(new D().test());

    }
}
class A{
    String str1 = "Hello";
    public String test(){
        try{
            System.out.println(str1);
            return str1;
        }finally {
            str1 += ",world!";
            System.out.println(str1);
        }
    }
}
class B{
    StringBuffer str2 = new StringBuffer("Hello");
    public StringBuffer test(){
        try{
            System.out.println(str2);
            return str2;
        }finally {
            str2.append(",world!");
            System.out.println(str2);
        }
    }
}

class C{
    Integer x = new Integer(12);
    public Integer test(){
        try{
            System.out.println(x);
            return x;
        }finally {
            x += 3;
            System.out.println(x);
        }
    }
}

class D{
    StringBuilder str2 = new StringBuilder("Hello");
    public StringBuilder test(){
        try{
            System.out.println(str2);
            return str2;
        }finally {
            str2.append(",world!");
            System.out.println(str2);
        }
    }
}
