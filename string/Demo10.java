package string;

import java.util.Scanner;

/**
 * Created by 张志鹏 on 2017/4/30.
 * 十、输入A-Z 26个字母，输入一个大写字母后，输出该字母
     之后第5个字母的小写。
     如输入A，输出f，输入Z，则输出e，超出Z是，超过1
     个，则返回a，超过两个，则返回b，以此类推。
 */
public class Demo10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请输入A-Z之间的字符：");
            String str = scanner.nextLine();
            char c1 = str.charAt(0);
            if(c1 < 'A' || c1 > 'Z'){
                System.out.println("输入的字符有误！");
                break;
            }
            System.out.println("输出转化后的字母:");
            System.out.println(toExchange(c1));
        }
    }
    private static char toExchange(char c1){
        char c2 ;
        if(c1 < 'W')
            c2 = (char)(c1 + 36);
         else
             c2 = (char)(c1 + 10);

        return c2;
    }
}
