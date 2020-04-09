package generics;

import java.util.Random;

public class ManGenerator implements Generator<String>{
    String[] names = {"ryan","anni","john"};

    @Override
    public String text() {
        Random random = new Random();
        return names[random.nextInt(3)];
    }

    public static void main(String[] args){
        ManGenerator age = new ManGenerator();
        System.out.println(age.text());
    }
}
