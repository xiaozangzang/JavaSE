package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by 张志鹏 on 2017/4/30.
 * 八、输入一整型数组，按照顺序，输出每个数字对
 应的英文26个字母，如果查不到，则输出？。如[1,3,30]，输出ac?。
 */
public class Demo08 {
    public static void main(String[] args) {
        System.out.println("输入一组整型数字(' '隔开)：");
        Scanner scanner = new Scanner(System.in);
        String[] inStrArr = scanner.nextLine().split(" ");
        int[] inIntArr = new int[inStrArr.length];
        for(int i = 0;i < inStrArr.length;i++){
            inIntArr[i] = Integer.parseInt(inStrArr[i]);
        }
        int temp ;
        for(int i = 0;i < inIntArr.length ;i++)
            for(int j = 1;j <inIntArr.length - i ;j++)
                if(inIntArr[j - 1] > inIntArr[j]){
                    temp = inIntArr[j];
                    inIntArr[j] = inIntArr[j - 1];
                    inIntArr[j - 1] = temp;
                }
        System.out.println("输出正确顺序的数组：");
        System.out.println(Arrays.toString(inIntArr));
        char[] returnLetterArr = getNumToLetter(inIntArr);
        System.out.println("输出对应的字母数组：\n" + Arrays.toString(returnLetterArr));
    }
    //输出每个数字对应的英文26个字母，如果查不到，则输出？
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
