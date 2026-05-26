class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0)
            return res;
        res.add("");
        for(int i=0;i<digits.length();i++)
        {
            for(int j=res.size()-1;j>=0;j--)
            {
                String curr = res.get(j);
                res.remove(curr);
                String[] options = returnCombo(digits.charAt(i));
                for(int k=0; k<options.length; k++)
                {
                    res.add(curr+options[k]);
                }
            }
        }
        return res;
    }

    public String[] returnCombo(char digit){
        if(digit == '2')
            return new String[] {"a","b","c"};
        if(digit == '3')
            return new String[] {"d","e","f"};
        if(digit == '4')
            return new String[] {"g","h","i"};
        if(digit == '5')
            return new String[] {"j","k","l"};
        if(digit == '6')
            return new String[] {"m","n","o"};
        if(digit == '7')
            return new String[] {"p","q","r","s"};
        if(digit == '8')
            return new String[] {"t","u","v"};
        if(digit == '9')
            return new String[] {"w","x","y","z"};
        return null;
    }
}
