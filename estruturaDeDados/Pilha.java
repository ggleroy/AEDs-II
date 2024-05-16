public class Pilha <T> {
    private Node<T> top;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Pilha() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty. Cannot perform peek.");
        }
        return top.data;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty. Cannot perform pop.");
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public static void main(String[] args) {
        Pilha<Integer> stack = new Pilha<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element is: " + stack.peek()); 
        System.out.println("Element popped: " + stack.pop()); 
        System.out.println("Next top element is: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println("Popping: " + stack.pop());
        }
    }
}