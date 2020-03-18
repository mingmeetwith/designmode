package game.demo;

public class Demo6 {

	public static void main(String[] args){
		Thread.currentThread().interrupt();
		System.out.println(Thread.currentThread().isInterrupted()+"   "+Thread.currentThread().getName());
		if(Thread.interrupted()){
			System.out.println("interruped:"+ Thread.interrupted());
		}else{
			System.out.println("Not interruped:"+ Thread.interrupted());
		}
	}
}
