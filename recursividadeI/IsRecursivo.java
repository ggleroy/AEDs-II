import java.util.Scanner;

public class IsRecursivo {

    static int count = 0;
    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
    private static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstwxyzBCDFGHJKLMNPQRSTWXYZ".indexOf(c) != -1;
    }
    private static boolean isInteger(char c) {
        return "0123456789".indexOf(c) != -1;
    }
    private static boolean isRealNumber(char c) {
        return "0123456789,.".indexOf(c) != -1;
    }

    public static boolean isAllVowels(String str) {
        if (str.isEmpty()) {
            return true;
        }
        if (!isVowel(str.charAt(0))) {
            return false;
        }

        return isAllVowels(str.substring(1));
    }

    public static boolean isAllConsonants(String str) {
        if (str.isEmpty()) {
            return true;
        }
        if(!isConsonant(str.charAt(0))) {
            return false;
        }

        return isAllConsonants(str.substring(1));
    }
    public static boolean isAllIntegers(String str) {
        if (str.isEmpty()) {
            return true;
        }
        if(!isInteger(str.charAt(0))) {
            return false;
        }

        return isAllIntegers(str.substring(1));
    }
    public static boolean isAllRealNumbers(String str) {
        if (str.isEmpty()) {
            return true;
        }
        if(!isRealNumber(str.charAt(0))) {
            return false;
        }
        if(str.charAt(0) == ',' || str.charAt(0) == '.') {
            count++;
        }
        if(count > 1) {
            return false;
        }

        return isAllRealNumbers(str.substring(1));
    }
    private static void printResults(String str) {
        boolean[] results = new boolean[]{
                isAllVowels(str),
                isAllConsonants(str),
                isAllIntegers(str),
                isAllRealNumbers(str)
        };

        for (boolean result : results) {
            System.out.print(result ? "SIM " : "NAO ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            if (str.equals("FIM")) {
                break;
            }
            printResults(str);
        }
        scanner.close();
    }
}
