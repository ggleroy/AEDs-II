import java.util.Scanner;

public class Ex2 {
    public static int somaDigitos(int num) {
        if(num == 0)
            return 0;
        return num % 10 + somaDigitos(num/10);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer num = Integer.valueOf(scanner.nextLine());
        System.out.println(somaDigitos(num));
        scanner.close();
    }
}
