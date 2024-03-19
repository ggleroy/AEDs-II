import java.util.Scanner;

public class CiframentoCesar {
    public static String ciframento(String entrada) {
        char c = entrada.charAt(0);
        char cifrado = (char) (c + 3);

        if (entrada.length() > 1) {
            return cifrado + ciframento(entrada.substring(1));
        } else {
            return String.valueOf(cifrado);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String entrada = scanner.nextLine();
            if (entrada.equals("FIM")){
                break;
            }
            System.out.println(ciframento(entrada));
        }
        scanner.close();
    }
}
