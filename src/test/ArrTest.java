package test;

public class ArrTest {
    public static void main(String[] args) {
        Object[] objects = new Object[4];
        String[] strings = new String[2];
        strings[0] = "abcd";
        strings[1] = "defg";

        Integer[] integers = new Integer[2];
        integers[1] = 3;
        integers[0] = 2;

        objects[0] = strings;
        objects[1] = integers;
        objects[2] = Integer.valueOf(3);

        for(Object i : objects){
            System.out.println(i);
        }
    }
}
