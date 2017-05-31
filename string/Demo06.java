package string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 张志鹏 on 2017/4/30.
 * 六、将一个字符里出现最多的字母截取，如，addcbbs变为acs。
 */
public class Demo06 {
    public static void main(String[] args) {
        System.out.println("请输入字符串：");
        Scanner scanner = new Scanner(System.in);
        String returnStr = toSpilt(scanner.nextLine());
        System.out.println("输出结果：\n" + returnStr);
    }
    //将字符串中的出现最多的字母截取，如，addcbbs变为acs。
    private static String toSpilt(String str){
        StringBuffer returnStr = new StringBuffer(str);
        //存放字符串中每个字符
        char[] chars = new char[str.length()];
        //存放对应字符出现的次数
        int[] numbers = new int[str.length()];
        int index = 0;
        int temp = 0;
        for(int i = 0;i < str.length();i++){
            for(int j = 0;j < chars.length;j++){
                if(str.charAt(i) == chars[j]){
                    numbers[j]++;
                    //如果字符串中的字符出现过，则对应数组次数自增跳出当前循环
                    break;
                }
                //如果字符串中的字符首次出现，则创建
                if( j == chars.length - 1){
                    chars[index++] = str.charAt(i);
                    numbers[index - 1] = 1 ;
                }
            }
        }
        //确定字符数组中的出现次数最多的字符
       for(int i = 0;i < numbers.length - 1;i++){
            if(numbers[i] > temp)
                temp = numbers[i];
       }
       //截取次数最多的字符，将其他字符连接起来
       for(int i = 0;i < numbers.length;i++){
           if(temp == numbers[i]){
               for(int j = 0;j < returnStr.length();j++){
                   if(chars[i] == returnStr.charAt(j)){
                      returnStr = returnStr.deleteCharAt(j);
                      j--;
                   }
               }
           }
       }
        return returnStr.toString();
    }
}
