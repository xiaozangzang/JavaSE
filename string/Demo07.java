package string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 张志鹏 on 2017/4/30.
 * 七、输入一个整型数组，arr=(1,2,5)
     输出数组中数字对应英文字母表中对应的字母，如果不
     在字母表中用"?"表示
     例如，输入arr=（1,2,30，3），输出：a b ? c
 */
public class Demo07 {
    public static void main(String[] args) {
        System.out.println("输入一组整型数字(' '隔开)：");
        Scanner scanner = new Scanner(System.in);
        String[] inStrArr = scanner.nextLine().split(" ");
        int[] inIntArr = new int[inStrArr.length];
        for(int i = 0;i < inStrArr.length;i++){
            inIntArr[i] = Integer.parseInt(inStrArr[i]);
        }
        char[] returnLetterArr = getNumToLetter(inIntArr);
        System.out.println("输出数字对应的字母：");
        System.out.println(Arrays.toString(returnLetterArr));
    }
    //返回数字对应的字母，不在字母表中则？替代
    private static char[] getNumToLetter(int[] inIntArr){
        char[] returnLetterArr = new char[inIntArr.length];
        for(int i = 0;i < inIntArr.length;i++){
            if(inIntArr[i] < 27 && inIntArr[i] > 0)
                returnLetterArr[i] = (char)('A' + inIntArr[i] - 1);
                else
                    returnLetterArr[i] = '?';
        }
        return returnLetterArr;

    }
}
