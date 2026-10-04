
class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            // If token is a number
            if (!token.equals("+") &&
                !token.equals("-") &&
                !token.equals("*") &&
                !token.equals("/")) {

                stack.push(Integer.parseInt(token));
            }

            // If token is an operator
            else {

                int b = stack.pop();
                int a = stack.pop();

                if (token.equals("+")) {
                    stack.push(a + b);
                }
                else if (token.equals("-")) {
                    stack.push(a - b);
                }
                else if (token.equals("*")) {
                    stack.push(a * b);
                }
                else if (token.equals("/")) {
                    stack.push(a / b);
                }
            }
        }

        return stack.pop();
    }
}
