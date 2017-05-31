package dataStructures.stringOp;

import java.util.Scanner;

/**
 * 将字符串反转，将字符串指定前几个字符连接到字符串右边，
 * 时间复杂度O(n),空间复杂度O(1)比如：abcdef ——>cdefab
 * Created by 张志鹏 on 2017/5/30.
 */
public class StringDemo01 {

    public static StringBuffer returnStr(StringBuffer str,int k){
        restaveStr(str,0,k);
        restaveStr(str,k,str.length());
        restaveStr(str,0,str.length());
        return str;
    }
    public static StringBuffer restaveStr(StringBuffer str,int low,int high){
        int i = low;
        int j = high - 1;
        while(i < j){
            char temp = str.charAt(i);
            str.setCharAt(i++,str.charAt(j));
            str.setCharAt(j--,temp);
        }
        return str;
    }
    public static void main(String[] args) {
        System.out.println("请输入字符串和操作的字符数：");
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        System.out.println(returnStr(new StringBuffer(arr[0]),Integer.valueOf(arr[1])));
    }
}
