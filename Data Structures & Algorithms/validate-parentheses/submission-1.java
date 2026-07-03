class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                if(stack.size() == 0)
                    return false;
                char temp = stack.pop();
                if(ch == ')' && temp != '(')
                    return false;
                if(ch == ']' && temp != '[')
                    return false;
                if(ch == '}' && temp != '{')
                    return false;
            }
        }
        return stack.size() == 0;
    }
}
