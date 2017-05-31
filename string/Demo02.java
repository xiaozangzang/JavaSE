package string;

import java.util.Arrays;

/**
 * Created by 张志鹏 on 2017/4/30.
 * 二、给一个二维数组inArr[ ][ ],写一个方法获取每一列
 的最小值，输出到一个一维数组outArr[ ]中。
 */
public class Demo02 {
    public static void main(String[] args) {
        int[][] inArr = {{2,4,1},{5,2,5},{7,3,6}};
        int[] outArr = getMinOfAllCloumn(inArr);
        System.out.println(Arrays.toString(outArr));
    }
    private static int[] getMinOfAllCloumn(int[][] inArr){
        int rowNum = inArr.length;
        int[] outArr = new int[rowNum];
        int temp = inArr[0][0];
        for(int i = 0;i < rowNum;i++){
            for(int j = 0;j < inArr[i].length;j++){
                if(inArr[j][i] < temp) {
                    temp = inArr[j][i];
                }
            }
            outArr[i] = temp;
        }
        return outArr;

    }
}
