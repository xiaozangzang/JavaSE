package test;

/**
 * 最大公约数
 * ——
 * Created by 张志鹏 on 2017/5/3.
 */
public class GcdAndLcm {

    //最大公约数，非递归实现
    private int gcd(int m,int n){
        int temp = m;
        if(m == 0 || n == 0){
            return m == 0?n:m;
        }
        //保证m > n
        if(m < n){
            temp = m ;
            m = n;
            n = temp;
        }
        while(temp != 0){
            temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }

    //最小公倍数
    private int lcm(int m, int n){
        int i = 0;
        if(m == 0 || n == 0)
            return 0;
        while(true){
            if(m * ++i % n == 0){
                return m*i;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(new GcdAndLcm().gcd(0,9));
//       System.out.println(new GcdAndLcm().lcm(11,9));



    }
}
