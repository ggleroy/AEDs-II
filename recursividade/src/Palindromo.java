import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String entrada = scanner.nextLine();
            if (entrada.equals("FIM")) {
                break;
            }
            System.out.println(isPalindromo(entrada));
        }
        scanner.close();
    }
    public static String isPalindromo(String entrada) {
        if (entrada.length() <= 1) {
            return "SIM";
        }
        if (entrada.charAt(0) == entrada.charAt(entrada.length() - 1)) {
            return isPalindromo(entrada.substring(1, entrada.length() - 1));
        } else {
            return "NAO";
        }
    }
}
