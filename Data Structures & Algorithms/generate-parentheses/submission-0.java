class Solution {
    public static List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generateParenthesis("", n*2, 0);
        return result;
    }

    public void generateParenthesis(String curr, int remainingPos, int openingBracketCount)
    {
        // generates only valid sequence till now, i.e. no multiple closing brackets.
        if(remainingPos == 0)
        {
            if(openingBracketCount == 0)
                result.add(curr);
            return;
        }
        if(openingBracketCount > 0)
        {
            generateParenthesis(curr+")", remainingPos-1, openingBracketCount-1);   
        }
        generateParenthesis(curr+"(", remainingPos-1, openingBracketCount+1);
    }
}
