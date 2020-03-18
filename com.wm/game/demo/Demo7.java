package game.demo;

public class Demo7 {
	public static int LIS(int[] a ){

        int[] arr=new int[a.length];//用于记录当前个元素作为最大元素的最长递增序列的长度

        for (int i = 0; i < a.length; i++) { //初始化
            arr[i]=1;
        }

        int max=1;

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j <i; j++) {

                if (a[j]<a[i]&&(arr[j]+1)>arr[i]) {                   
                    arr[i]=arr[j]+1;
                }
                if (max<arr[i]) { //得到当前最长递增序列的长度以及该子序列的最末元素的位置
                    max=arr[i];
                }           
            }
        }
        return max;
    }
	
	public static void main(String[] args){
		int[] arr={1,6,2,5,8,3,4};
		System.out.println(LIS(arr));
	}
}
