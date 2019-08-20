

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        jadenCasingStrings("jeden dwa trzy");


      /*   // wierzcholki paraboli

        System.out.println("p="+ parabolasStandardToVertexForm(1,-10,16)[0] +
                ", q= "+parabolasStandardToVertexForm(1,-10,16)[1]);


        // suma kątów w n-kącie

        int a = 5;
        System.out.println("Suma kątów w "+a+" kącie to "+sumOfAngles(a));

       // getVertex wspolrzedne wierzcholka paraboli
        //int a = 2;
        //int b = 4;
        //int c = 6;
        //   System.out.println("p=" + getVertex(a, b, c)[0] + ", q= " + getVertex(a, b, c)[1]);

        // getPerimeter - calculate perimeter with input: width and length
       // int length = 10;
        int width = 6;
        //   System.out.println("Perimeter of rectangle where lenght = " + length + "; width = " + width + " is: "
        //           + getPerimeter(length, width));


        //Run toBinary
        System.out.println(toBinary(57));

        // Run countPositivesSumNegatives with input as parameter
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15};
        //    System.out.println(countPositivesSumNegatives(input)[0]);
        //   System.out.println(countPositivesSumNegatives(input)[1]);

        //Run even_or_odd
        //   System.out.println(even_or_odd(6));

        //Run remove firstFirstAndLastCharacter
        String str = "Michal";
             System.out.println(firstFirstAndLastCharacter(str));

        //Run stringy
        //    System.out.println(stringy(5));

        //Run pythagoreanTriple
        int[] triple = {3, 5, 4};
        //     System.out.println(pythagoreanTriple(triple));

        //Run barTriang
        double[] x = {5.33, 2};
        double[] y = {47, 5};
        double[] z = {7, 8};
        //    System.out.println(barTriang(x, y, z)[1]);

        //    String phrase1 = "Michal Musial to ja";
        //    System.out.println(convertFirstLetterOfStringValuesToUpper(phrase1));

        //int A = 5;
        //int [] tablica = [1,2,3];
        System.out.println("Zamek: " + solution2(new int[]{1, 1, 3, 3, 4, 4, 4}));
*/
    }

    public static int solution2(int[] A) {
        // write your code in Java SE 8
        int numberOfCastles = 0;
        for (int i = 0; i < A.length - 1; i++) {
            System.out.println("i= " + i);
            int k = A.length - i - 1;
            System.out.println("k= " + k);

            while (k > i) {
                if ((A[i + k] == A[i])) {
                    numberOfCastles++;
                    //   System.out.println("Number of castles at segment "+(i+2)+" is: "+numberOfCastles);
                }
            }

        }
        return numberOfCastles;
    }

    public static int solution(int A, int B) {

        int res = 0;

// not a smart solution, but used the fact that B < 10000
// Here we have 8th power of 2 and 3
        if ((A < 256 && B > 256) || (A < 6561 && B > 6561)) {
            res = 3;
        }
// here we have 4th power of 2,3,5,6,7,10; 4th power of 11 is > 10000
        else if ((A < 16 && B > 16) || (A < 81 && B > 81) || (A < 625 && B > 625) || (A < 1296 && B > 1296) || (A < 2401 && B > 2401) || (A < 10000 && B > 10000)) {
            res = 2;
// here we have 2nd power of 2,3,5,6,7,10
        } else if ((A < 4 && B > 4) || (A < 9 && B > 9) || (A < 25 && B > 25) || (A < 36 && B > 36) || (A < 49 && B > 49) || (A < 100 && B > 100)) {
            res = 1;
        } else {
// FIXME
// I know it should also return zero when there is no square root for any number between A & B; e.g. A = 344, B=346, but dont know how to implement it
            res = 1;
        }
        return res;
    }

    public static double[] getVertex(double a, double b, double c) {

        double[] returnArray = new double[2];

        returnArray[0] = (-b) / (2 * a);
        returnArray[1] = -((b * b - 4 * a * c) / (4 * a));
        return returnArray;
    }

    public static int getPerimeter(int length, int width) {
// Calculate Perimeter of . give length and width
        return ((2 * length) + (2 * width));
    }

    public static String convertFirstLetterOfStringValuesToUpper(String phrase) {
        // TODO put your code below this comment
        String[] divided = phrase.split(" ");
        for (int i = 0; i < divided.length; i++) {
            divided[i] = divided[i].substring(0, 1).toUpperCase() + divided[i].substring(1);
        }
        System.out.println(Arrays.toString(divided));


        return divided.toString();
    }

    public static List<String> sortList(List<String> textbooks) {
        //Cramming right before a test can't be that bad?
        // sortowanie listy wartosci, case insensitive
        Collections.sort(textbooks, String.CASE_INSENSITIVE_ORDER);
        return textbooks;
    }

    public static double[] barTriang(double[] x, double[] y, double[] z) {
        // liczenie srodka ciezkosci trojkata
        double xs = ((x[0] + y[0] + z[0]) / 3);
        double ys = ((x[1] + y[1] + z[1]) / 3);
        // zaokraglenie do 4 miejsc po przecinku
        double[] d = {Math.round(xs * 10000) / 10000.0d, Math.round(ys * 10000) / 10000.0d};
        return d;
    }

    public static int pythagoreanTriple(int[] triple) {

/**
 * check if triple is pithagoreian
 * - sort array first
 */

        Arrays.sort(triple);

        return Math.pow(triple[2], 2) == Math.pow(triple[1], 2) + Math.pow(triple[0], 2) ? 1 : 0;
    }

    public static String stringy(int size) {
/**
 * convert size (int) to 101010, e.g. 2 -> 10, 6 -> 101010, 12 -> 101010101010
 * 1) insert data to arraylist
 * 2) use stream to convert arraylist to string
 */

        List<String> lista = new ArrayList<String>();
        for (int i = 0; i < size + 1; i++)
            if (i % 2 == 0) {
                lista.add("1");
            } else
                lista.add("0");

        return lista.stream().map(Object::toString).collect(Collectors.joining());
    }

    public static String firstFirstAndLastCharacter(String str) {
/**
 * method to remove first and last character from input string
 */
        return str.substring(1).substring(0, str.length() - 2);
    }

    public static int toBinary(int n) {
/**
 * Method to convert integer to binary with integer as parameter
 *
 * @param n
 * @return
 */
        n = Integer.parseInt(Integer.toBinaryString(n));
        return n;
    }

    public static int[] countPositivesSumNegatives(int[] input) {
        /**
         * Method with sample array as parameter and return array with two values
         * count of possitive values and sum of negative values
         * when input paramater is empty or null, returns empty array new int[1]
         *
         * @param input
         * @return
         */

        int counter = 0;
        int sum = 0;
        int[] a;

        // Check if array is not empty or null

        if (input == null || input.length == 0) {
            a = new int[1];
        } else {

            for (int i = 0; i < input.length; i++) {
                if (input[i] > 0)
                    counter++;
                else
                    sum = sum + input[i];
            }

            a = new int[]{counter, sum};
        }
        return a; //return an array with count of positives and sum of negatives
    }

    public static String even_or_odd(int number) {
        /**
         * Method to check if a number os odd (nieparzysta) or even (parzysta)
         */
        String oddOrEven;
        if (number % 2 == 0) {
            oddOrEven = "Even";
        } else oddOrEven = "Odd";
        return oddOrEven;
    }

    public static int sumOfAngles(int numberOfSides) {

        return (numberOfSides - 2) * 180;
    }

    public static double[] parabolasStandardToVertexForm(double a, double b, double c) {
        return new double[]{(-b) / (2 * a), (-(b * b - 4 * a * c)) / (4 * a)};
    }

    public static String jadenCasingStrings(String inputStringForJadenCOnversion) {
        String[] inputSplit = inputStringForJadenCOnversion.split(" ");
        StringBuilder outputStringForJadenCOnversion = new StringBuilder();

        int i = 0;
        while (i < inputSplit.length) {
            inputSplit[i] = Character.toUpperCase(inputSplit[i].charAt(0)) + inputSplit[i].substring(1);
            outputStringForJadenCOnversion.append(inputSplit[i]).append(" ");
            i++;
        }
        return outputStringForJadenCOnversion.toString();
    }
}

