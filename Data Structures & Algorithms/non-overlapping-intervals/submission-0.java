class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1], removed=0;
        for(int i=1;i<intervals.length;i++){
            int currInterval[] = intervals[i];
            if(currInterval[0] < prevEnd){
                // overlap is there
                removed++;
                prevEnd = Math.min(currInterval[1], prevEnd);
            }
            else{
                // continue to next by updating prev end
                prevEnd = currInterval[1];
            }
        }

        return removed;
    }
}
