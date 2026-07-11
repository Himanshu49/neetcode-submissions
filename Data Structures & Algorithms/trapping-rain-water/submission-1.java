class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxLeft[] = new int[n];
        int maxRight[] = new int[n];
        maxLeft[0] = height[0];
        maxRight[n-1] = height[n-1];
        for(int i=1;i<n;i++){
            maxLeft[i] = height[i] > maxLeft[i-1]?height[i]:maxLeft[i-1];
        }
        for(int i=n-2;i>=0;i--){
            maxRight[i] = height[i] > maxRight[i+1]?height[i]:maxRight[i+1];
        }

        int totalWaterTrapped = 0;
        for(int i=1;i<n-1;i++){
            if(height[i] < maxLeft[i-1] && height[i] < maxRight[i+1]){
                totalWaterTrapped += Math.min(maxLeft[i-1], maxRight[i+1]) - height[i];
            }
        }
        return totalWaterTrapped;
    }
}
