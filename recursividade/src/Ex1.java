import java.util.Scanner;

public class Ex1 {
    public static int contaDigitos(int num) {
        if(num<10)
            return 1;
        return 1 + contaDigitos(num/10);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer num = Integer.valueOf(scanner.nextLine());
        System.out.println(contaDigitos(num));
        scanner.close();
    }
}