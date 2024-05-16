import java.util.Scanner;

public class Ex4 {
    public static int restoDivisaoSubtraindo(int dividendo, int divisor) {
        if(dividendo < divisor)
            return dividendo;
        return restoDivisaoSubtraindo(dividendo - divisor, divisor);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividendo = Integer.valueOf(scanner.nextLine());
        int divisor = Integer.valueOf(scanner.nextLine());
        System.out.println(restoDivisaoSubtraindo(dividendo, divisor));
        scanner.close();
    }
}
