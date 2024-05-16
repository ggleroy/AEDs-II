import java.util.Scanner;

public class Fib {
    public static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine()) - 1;
        System.out.println(fib(n));
        scanner.close();
    }
}
