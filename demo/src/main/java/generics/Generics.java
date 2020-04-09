package generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main(String[] args){

        List<String> list1 = new ArrayList<String>();
        List list2 = new ArrayList();
        Class c1 = list1.getClass();
        Class c2 = list2.getClass();
        System.out.println(c1==c2);
    }
}
