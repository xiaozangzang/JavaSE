package string;

import java.util.Scanner;

/**
 * Created by 张志鹏 on 2017/4/30.
 * 五、一个字符串，获取最长的一个单词，如有多个相同长度
 的单词返回第一个单词。入输入："hello china"则返回 hello。
 */
public class Demo05 {
    public static void main(String[] args) {
        System.out.println("请输入字符串(单词间' '隔开)：");
        Scanner scanner = new Scanner(System.in);
        String returnStr = getMaxLengthWord(scanner.nextLine().trim());
        System.out.println("输出最大长度的单词为："+returnStr);
    }
    //返回字符串中最长的单词，如果有相同长度的，返回第一个
    private static String getMaxLengthWord(String str){
        String[] strArr = str.split(" ");
        String maxWord = "";
        for(int i = 0;i < strArr.length - 1;i++){
            if(strArr[i].length() >= strArr[i+1].length())
                maxWord = strArr[i];
        }
        return maxWord;
    }
}
