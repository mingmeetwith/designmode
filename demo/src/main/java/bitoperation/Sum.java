package bitoperation;

public class Sum {
    public static void main(String[] argc){
//        sum(5,7);
        difference(new int[]{0,1,2,4});
    }

    public static void sum(int a, int b){
        int temp = 0;
        for(;b>0;){
            temp =a;
            a=a^b;
            b=(temp&b)<<1;
            a &= 0xFFFFFFFF;
            b &= 0xFFFFFFFF;
            if( a>0x7FFFFFFF){
                a = ~(a ^ 0xFFFFFFFF);
            }
        }
        System.out.println(a);
    }

    public static void difference(int[] intArray){
        int ret = 0;
        for(int i=0; i<intArray.length; i++){
            int x=intArray[i];
            ret ^=i;
            ret ^=x;
        }
        System.out.println( ret^intArray.length);

    }
}

