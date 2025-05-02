package STS2;
import java.util.*;
public class StockSpan {
    public int[] calculaeSpan(int[] prices){
        int n = prices.length;
        int [] span = new int[n];
        span[0] = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while stack is not empty
            // and price at top of stack is less than or equal to current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack becomes empty, then price[i] is greater than all elements on left
            // Else, the difference between current index and top of stack
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push this element to stack
            stack.push(i);
        }

        return span;

    }
    public static void main(String[] args) {
        StockSpan stockSpan = new StockSpan();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = stockSpan.calculaeSpan(prices);
        System.out.println("Stock Spans: " + Arrays.toString(spans));
    }
}
