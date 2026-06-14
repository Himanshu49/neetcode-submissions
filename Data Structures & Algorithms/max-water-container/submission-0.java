class Solution {
    public int maxArea(int[] heights) {
        int global = 0, local = 0, l=0,r=heights.length-1;
        while(l<r){
            local = (r-l)*Math.min(heights[l], heights[r]);
            if(heights[l] < heights[r])
                l++;
            else
                r--;
            global = Math.max(global, local);
        }
        return global;
    }
}
