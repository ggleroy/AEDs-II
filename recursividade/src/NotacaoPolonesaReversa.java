import java.util.Scanner;

public class NotacaoPolonesaReversa {

    private static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    private static class CharStack {
        private Node top;

        public boolean isEmpty() {
            return top == null;
        }

        public void push(char item) {
            Node newNode = new Node(item);
            newNode.next = top;
            top = newNode;
        }

        public char pop() {
            if (isEmpty()) {
                throw new RuntimeException("Empty Stack");
            }
            char item = top.data;
            top = top.next;
            return item;
        }

        public char peek() {
            if (isEmpty()) {
                throw new RuntimeException("Empty Stack");
            }
            return top.data;
        }
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public static String reversePolishNotation(String expression) {
        StringBuilder output = new StringBuilder();
        CharStack operators = new CharStack();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (precedence(c) > 0) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    output.append(operators.pop()).append(' ');
                }
                operators.push(c);
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    output.append(operators.pop()).append(' ');
                }
                operators.pop();
            } else {
                output.append(c);
                if (i < expression.length() - 1 && !Character.isDigit(expression.charAt(i + 1))) {
                    output.append(' ');
                }
            }
        }

        while (!operators.isEmpty()) {
            output.append(operators.pop()).append(' ');
        }
        
        return output.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("FIM")) {
                break;
            }
            String output = reversePolishNotation(input);
            System.out.println(output);
        }

        scanner.close();
    }
}
