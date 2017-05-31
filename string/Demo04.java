package string;

import java.util.Scanner;

/**
 * Created by 张志鹏 on 2017/4/30.
 * 四、输入一个字符串，字符串是字母和数字的组合，编程实
 现输出一个新的字符串，要求字母在前面，数字在后面，顺
 序不变，例如：2s7ess83a 变成sessa2783。
 */
public class Demo04 {
    public static void main(String[] args) {
        System.out.println("请输入字符串(字母和数字的组合)：");
        Scanner scanner = new Scanner(System.in);
        String strA = scanner.nextLine();
        System.out.println("转换后的结果：");
        System.out.println(toChangeString(strA));
    }
    //返回转换后的字符串，要求字母在前面，数字在后面,顺序不变
    public static String toChangeString(String str){
        StringBuffer str1 = new StringBuffer();
        StringBuffer str2 = new StringBuffer();
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
                str2.append(str.charAt(i));
            else
                str1.append(str.charAt(i));
        }
        str1.append(str2);
        return str1.toString();
    }
}
