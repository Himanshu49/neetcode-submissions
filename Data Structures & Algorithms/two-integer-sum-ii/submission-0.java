class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int result[] = {};
        for(int i=0;i<numbers.length;i++){
            int pos = findPos(numbers, target-numbers[i], i+1, numbers.length-1);
            if(pos!=-1){
                return new int[] {i+1, pos+1};
            }
        }
        return result;
    }

    public int findPos(int[] nums, int target, int low, int high){
        if(low>high)
            return -1;
        int mid = (low+high)/2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid] > target){
            high = mid-1;
        }
        else{
            low = mid+1;
        }
        return findPos(nums,target,low,high);
    }
}
