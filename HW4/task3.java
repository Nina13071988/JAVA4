package HW4;

public class task3 {
    private int[] arr;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public task3(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Method to check if the stack is empty
    public boolean empty() {
        return top == -1;
    }

    // Method to check the size of the stack
    public int size() {
        return top + 1;
    }

    // Method to push an element onto the stack
    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack overflow");
            return;
        }
        arr[++top] = x;
    }

    // Method to pop an element from the stack
    public int pop() {
        if (empty()) {
            System.out.println("Stack underflow");
            return -1;
        }
        return arr[top--];
    }

    // Method to peek the top element of the stack
    public int peek() {
        if (empty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }
}
