import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < count; i++) {
            int value = input.nextInt();
            if (value > 0) {
                stack.push(value);
            } else {
                stack.pop();
            }
        }

        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        System.out.println(total);
    }
}
