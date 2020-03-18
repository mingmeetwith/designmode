package game.demo;

public class Demo5 {
	
	public static int getDivision(int n){
		try{
			n+=1;
			if(n/0>0){
				n+=10;
			}else{
				n-=10;
			}
		}catch(Exception e){
			n ++;
		}
		n++;
		return n++;
	}

	public static void main(String[] args){
		System.out.println(getDivision(10));
	}
}
