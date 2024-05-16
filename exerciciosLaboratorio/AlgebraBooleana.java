import java.util.Scanner;

public class AlgebraBooleana {
    private static int not(char a) {
        return a == '0' ? 1 : 0;
    }

    private static int or(char a, char b) {
        return a == '1' || b == '1' ? 1 : 0;
    }

    private static int and(char a, char b) {
        return a == '1' && b == '1' ? 1 : 0;
    }

    public static int countOp(String exp) {
        return exp.length() - exp.replace("(", "").length();
    }

    public static int getFirstOp(String exp) {
        int position = 0;
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                if (exp.charAt(i - 1) == 't' || exp.charAt(i - 1) == 'd') {
                    position = i - 3;
                } else if (exp.charAt(i - 1) == 'r') {
                    position = i - 2;
                }
            }
        }

        return position;
    }

    public static int getEndExp(String exp, int pos) {
        int end = 0;
        for (int i = exp.length() - 1; i > pos; i--) {
            if (exp.charAt(i) == ')') {
                end = i;
            }
        }

        return end;
    }

    public static String solveExp(String exp, int pos, int lastPos) {
        StringBuilder newString = new StringBuilder();
        newString.append(exp.substring(0, pos));

        if (exp.charAt(pos) == 'n') {
            newString.append(not(exp.charAt(pos + 4)));
        } else if (exp.charAt(pos) == 'o') {
            newString.append(or(exp.charAt(pos + 3), exp.charAt(pos + 5)));
        } else {
            newString.append(and(exp.charAt(pos + 4), exp.charAt(pos + 6)));
        }

        newString.append(exp.substring(lastPos + 1));

        return newString.toString();
    }

    public static String substituteValues(String exp, int[] values) {
        String newString = "";
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == 'A') {
                newString += values[0];
            } else if (exp.charAt(i) == 'B') {
                newString += values[1];
            } else if (exp.charAt(i) == 'C') {
                newString += values[2];
            } else if (exp.charAt(i) == 'D') {
                newString += values[3];
            } else {
                newString += exp.charAt(i);
            }
        }

        return newString;
    }


    public static String clearStr(String str) {
        return str.replace(" ", "");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int entrada = scanner.nextInt();
            if (entrada == 0) {
                break;
            }
            int n = entrada;

            int values[] = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = scanner.nextInt();
            }

            String expr = scanner.nextLine();

            String cleanedExp = substituteValues(clearStr(expr), values);
            int quantityOp = countOp(cleanedExp);

            for (int i = 0; i < quantityOp; i++) {
                int firstOp = getFirstOp(cleanedExp);
                int endOp = getEndExp(cleanedExp, firstOp);
                cleanedExp = solveExp(cleanedExp, firstOp, endOp);
            }

            System.out.println(cleanedExp);
        }
        scanner.close();


    }
}