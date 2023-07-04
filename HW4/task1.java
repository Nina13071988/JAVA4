package HW4;
 
import java.util.*;

public class task1 {
    public static void main(String[] args) {
        Deque<Integer> d1 = new LinkedList<>(Arrays.asList(1, 2, 3));
        Deque<Integer> d2 = new LinkedList<>(Arrays.asList(4, 5, 6));
        Deque<Integer> product = multiplyDeques(d1, d2);
        System.out.println(product);
    }

    public static Deque<Integer> multiplyDeques(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new LinkedList<>(Collections.singletonList(0));
        for (int digit1 : d1) {
            int carry = 0;
            Deque<Integer> temp = new LinkedList<>();
            for (int digit2 : d2) {
                int product = digit1 * digit2 + carry;
                temp.addFirst(product % 10);
                carry = product / 10;
            }
            if (carry > 0) {
                temp.addFirst(carry);
            }
            for (int i = 0; i < d1.size() - temp.size(); i++) {
                temp.addLast(0);
            }
            result = addDeques(result, temp);
        }
        while (result.size() > 1 && result.peekFirst() == 0) {
            result.removeFirst();
        }
        return result;
    }

    public static Deque<Integer> addDeques(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new LinkedList<>();
        int carry = 0;
        while (!d1.isEmpty() || !d2.isEmpty() || carry != 0) {
            int digit1 = d1.isEmpty() ? 0 : d1.removeLast();
            int digit2 = d2.isEmpty() ? 0 : d2.removeLast();
            carry += digit1 + digit2;
            result.addFirst(carry % 10);
            carry /= 10;
        }
        return result;
    }
}

