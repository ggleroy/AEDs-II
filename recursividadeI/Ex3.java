import java.util.Scanner;

public class Ex3 {
    public static int divideSubtraindo(int dividendo, int divisor) {
        if(dividendo < divisor)
            return 0;
        return 1 + divideSubtraindo(dividendo - divisor, divisor);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividendo = Integer.valueOf(scanner.nextLine());
        int divisor = Integer.valueOf(scanner.nextLine());
        System.out.println(divideSubtraindo(dividendo, divisor));
        scanner.close();
    }
}
