class Solution {
    public int[] productExceptSelf(int[] nums) {
        long grandProduct = 1;
        int countZero = 0;
        int result[] = new int[nums.length];
        for(int num:nums)
        {
            if(num == 0){
                countZero++;
                continue;
            }
            grandProduct = grandProduct*num;
        }
        if(countZero >= 2)
            return result;
        
        if(countZero == 1){
            for(int i=0;i<nums.length;i++){
                if(nums[i] == 0)
                    result[i] = (int)grandProduct;
            }
        }
        else{
            for(int i=0;i<nums.length;i++){
                result[i] = (int)(grandProduct/nums[i]);
            }
        }
        return result;
    }
}  
