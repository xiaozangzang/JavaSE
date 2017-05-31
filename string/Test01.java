package string;

/**
 * 字符串的使用
 * Created by 张志鹏 on 2017/5/21.
 */
public class Test01 {
    public static void main(String[] args) {
        String s1 = "abc" + "def";
        String s2 = new String("abcdef");
        if(s1 == s2)
            System.out.println("==");
        if(s1.equals(s2))
            System.out.println("equal");
        int i = 10000;
        Integer j = new Integer(10000);
        System.out.println(i == j);
        System.out.println(j.equals(i));
        byte a = 127;

    }
}
