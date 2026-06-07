class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();
        for(String curr: strs)
        {
            // sort string and check if that key is already if yes add the unsorted string
            char[] currString = curr.toCharArray();
            Arrays.sort(currString);
            if(result.containsKey(new String(currString)))
            {
                result.get(new String(currString)).add(curr);
            }
            else
            {
                List<String> temp = new ArrayList<>();
                temp.add(curr);
                result.put(new String(currString), temp);
            }
        }
        List<List<String>> resultList = new ArrayList<>();

        for(List<String> currGroup: result.values())
        {
            resultList.add(currGroup);
        }
        return resultList;
    }
}
