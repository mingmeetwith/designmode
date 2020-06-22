package bitoperation;

public class SwapTwoNumber {

    /**
     *首先介绍一下异或位运算符
     *
     * 0^0=0
     *
     * 1^0=0^1=1
     *
     * 1^1=0
     *
     * 若假设a,b为两个不同的整数，则：
     *
     * a^a=0   b^b=0
     *
     * 同时异或满足交换律和结合律：
     *
     * a^b=b^a  (应该不需要解释吧)
     *
     * (a^b)^c=a^(b^c) (自己可以写个例子证明一下很简单)
     *
     * 现在我们写交换的语句：
     *
     * a=a^b
     *
     * b=a^b     //因为我们上面写了a=a^b,所以这里的b=a^b=(a^b)^b=a^(b^b)=a^0=a
     *
     * a=b^a     //因为上面b已经是a了，所以结合第一步就有a=b^a=a^(a^b)=(a^a)^b=0^b=b
     *
     * 至此就实现了a,b的交换
     * **/
    public static void main(String[] argc){
        swap(3,4);
    }

    public static void swap(int a, int b){
        if(a!=b){
            a^=b;
            b^=a;
            a^=b;
        }
        System.out.println(a+" "+b);
    }
}
