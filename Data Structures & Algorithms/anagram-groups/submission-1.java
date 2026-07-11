class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String curr: strs){
            int count[] = new int[26];
            for(int i=0;i<curr.length();i++){
                count[curr.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(count);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(curr);
        }

        return new ArrayList<>(map.values());
    }
}
