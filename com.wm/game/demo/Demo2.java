package game.demo;

public class Demo2 {
	static int value = 0;

	static int get() {
		try {
			return value;
		} finally {
			value = 1;
		}
	}

	public static void main(String[] ar) {
		System.out.print(get());
	}

}
