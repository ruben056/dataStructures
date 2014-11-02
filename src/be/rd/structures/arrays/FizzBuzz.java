package be.rd.structures.arrays;

/**
 * Created by ruben on 11/2/14.
 */
public class FizzBuzz {

    private static String NEW_LINE = System.getProperty("line.separator");

    public static void main(String[] args) {
        int[] nrs = RandomNumberGenerator.generateUniqueNrList(15);
        StringBuilder sb = new StringBuilder();
        for (int nr : nrs){
            boolean isNotAnyMultiple = true;
            if(isMultipleOf3(nr)){
                sb.append("Fizz");
                isNotAnyMultiple = false;
            }
            if(isMulipleOf5(nr)){
                sb.append("Buzz");
                continue; //SHORTCUT
            }
            if(isNotAnyMultiple){
                sb.append(String.valueOf(nr));
            }
            sb.append(NEW_LINE);
        }
        System.out.println(sb.toString());
    }

    private static boolean isMultipleOf15(int nr){
        return nr % 15 == 0;
    }

    private static boolean isMultipleOf3(int nr){
        return nr % 3 == 0;
    }

    private static boolean isMulipleOf5(int nr){
        return nr % 5 == 0;
    }
}
