import java.util.Arrays;
public class ArraySort2 {

    public static void main(String[] args){
        String[] strings = {"Hello", "Badger", "Dolphin", "Dragon", "Fish", "Elephant", "Eagle"};
        printArray(strings, "Original");

        Arrays.sort(strings, (String a, String b) -> a.length() - b.length());
        printArray(strings, "Sorted from shortest to longest");

        Arrays.sort(strings, (String a, String b) -> b.length() - a.length());
        printArray(strings, "Sorted from longest to shortest");

        Arrays.sort(strings, (String a, String b) -> a.charAt(0) - b.charAt(0));
        printArray(strings, "Sorted by first character");

        Arrays.sort(strings, (String a, String b) -> StringUtils.eChecker(a, b));
        printArray(strings, "Es preferred");

    }

    private static void printArray(String[] arr, String message){
        System.out.println();
        System.out.println(message);
        System.out.println("----");
        for(String string : arr) {
            System.out.println(string);
        }
    }



}