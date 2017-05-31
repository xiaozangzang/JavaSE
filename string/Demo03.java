package string;

import java.util.Scanner;

/**
 * Created by 张志鹏 on 2017/4/30.
 * 三、判断一个字符串是否是首字母大写，其余字母都是小写。
 例如
 输入：True
 输出： true
 */
public class Demo03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = scanner.nextLine();
        boolean result = isUpperCaseFirstChar(str);
        if (result)
            System.out.println(str.toLowerCase());
        else
            System.out.println("不是一个首字母大写，其余小写的字符串！");
    }
    //判断是否首字母大写，其余是小写
    public static boolean isUpperCaseFirstChar(String str){
        if(str.charAt(0) < 'A' || str.charAt(0) > 'Z'){
            return false;
        }
        for(int i = 1; i < str.length();i++){
            if(str.charAt(i) > 'z' || str.charAt(i) < 'a')
                return false;
        }
        return true;
    }

}

