class Solution {
    class Pair{
        int temp;
        int day;
        public Pair(int t, int d){
            temp = t;
            day = d;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> record = new Stack<>();
        int n = temperatures.length;
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            while(record.size() > 0 && record.peek().temp < temperatures[i]){
                Pair curr = record.pop();
                res[curr.day] = i - curr.day;
            }
            record.push(new Pair(temperatures[i], i));
        }
        return res;
    }
}
