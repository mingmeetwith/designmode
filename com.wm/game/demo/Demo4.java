package game.demo;

public class Demo4 {
	static int value = 0;
	static int inc(){
		int value =0;
		return value++;
	}
	static int dec(){
		return value--;
	}
	
	static int getResult(){
		try{
			return inc();
		}finally{
			return dec();
		}
	}
	
	public static void main(String[] argc){
		System.out.println(getResult());
		System.out.println(value);
	}
}
