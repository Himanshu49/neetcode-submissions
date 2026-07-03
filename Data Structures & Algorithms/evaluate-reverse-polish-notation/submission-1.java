class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        // Assumption its always valid reverse polish notation
        for(String curr: tokens){
            if(isOperator(curr)){
                // pop last two elements perform the operation and push back
                int second = stack.pop();
                int first = stack.pop();
                int res = performOp(first, second, curr);
                stack.push(res);
            }
            else{
                stack.push(Integer.parseInt(curr));
            }
        }

        return stack.pop();
    }

    private int performOp(int first, int second, String op){
        if(op.equals("+")){
            return first+second;
        }
        if(op.equals("-")){
            return first-second;
        }
        if(op.equals("*")){
            return first*second;
        }
        return first/second;
    }

    private boolean isOperator(String curr){
        if(curr.length() != 1)
            return false;
        return (curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/"));
    }
}
