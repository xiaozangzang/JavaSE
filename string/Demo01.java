package string;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

/**
 * Created by 张志鹏 on 2017/4/30.
 *
 * 一、根据以下要求，比较两个字符串的大小，并返回比较结果：
 1、比较两字符串的大小；
 2、忽视大小写；
 3、 按字典序 如果第一个字符串大于第二个字符串
 返回大于0，如果第一个字符串字等于第二个符串 返回等于0 ，
 如果第一个字符串小于第二个字符串返回小于0；
 4、例子 compareToIgnoreCase("HARD","hark")的比较
 结果返回小于0 。
 */
public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("请输入要比较的字符串(中间','隔开)：");
        String[] str = scanner1.nextLine().split(",");
        int returnNum = compareToIgnoreCase(str[0],str[1]);
        System.out.println("比较结果为：");
        if(returnNum == 0){
            System.out.println(str[0]+"=="+str[1]);
        }else if(returnNum > 0){
            System.out.println(str[0]+">"+str[1]);
        }else{
            System.out.println(str[0]+"<"+str[1]);
        }
    }
    //比较两个字符串，返回大小，忽略大小写
    private static int compareToIgnoreCase(String stringA,String stringB){
        String strA = stringA.toLowerCase();
        String strB = stringB.toLowerCase();
        return strA.compareTo(strB);
    }


}














