import java.util.Random;
import java.util.Scanner;

public class AlteracaoAleatoria {

    public static void main(String[] args) {
        Random rand = new Random();
        rand.setSeed(4);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            if (str.equals("FIM")) {
                break;
            }
            char rand1 = (char)('a' + (Math.abs(rand.nextInt()) % 26));
            char rand2 = (char)('a' + (Math.abs(rand.nextInt()) % 26));

            str = alteracaoAleatoria(str, rand1, rand2);

            System.out.println(str);
        }
        scanner.close();
    }
    public static String alteracaoAleatoria(String str, char letra1, char letra2) {
        String strTrocada = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == letra1) {
                strTrocada += letra2;
            } else {
                strTrocada += str.charAt(i);
            }
        }
        return strTrocada;
    }
}
