import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
    static int prec(char c) {
        switch (c) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression (no spaces): ");
        String exp = sc.next();
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) res.append(c);
            else if (c == '(') st.push(c);
            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') res.append(st.pop());
                if (!st.isEmpty()) st.pop();
            } else {
                while (!st.isEmpty() && prec(st.peek()) >= prec(c)) res.append(st.pop());
                st.push(c);
            }
        }
        while (!st.isEmpty()) res.append(st.pop());
        System.out.println("Postfix: " + res.toString());
    }
}
