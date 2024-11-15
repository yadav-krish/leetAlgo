class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        String ans = "";
        // Correct operator precedence
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('^', 3);

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // If character is an operand, add it to the result
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                ans += ch;
            }
            // If character is an opening parenthesis, push it to the stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If character is a closing parenthesis
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Remove the opening parenthesis
                }
            }
            // If character is an operator
            else {
                while (!stack.isEmpty() && stack.peek() != '(' && map.getOrDefault(ch, -1) <= map.getOrDefault(stack.peek(), -1)) {
                    ans += stack.pop();
                }
                stack.push(ch); // Push the current operator to the stack
            }
        }

        // Pop all remaining operators in the stack
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }
