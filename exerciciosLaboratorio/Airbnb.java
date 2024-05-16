import java.io.*;
import java.util.Scanner;

public class Airbnb {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filePath = "tmp/dados_airbnb.txt";

        while (true) {
            String roomId = scanner.nextLine();

            if ("FIM".equals(roomId)) {
                break;
            }

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\t");
                if (data[0].equals(roomId)) {
                    String formattedOutput = String.format(
                            "[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s]",
                            data[0], data[1], data[2], data[3], data[4], data[5], data[6],
                            data[7], data[8], data[9], data[10], data[11]
                    );
                    System.out.println(formattedOutput);
                    break;
                }
            }
            reader.close();
        }
        scanner.close();
    }
}
