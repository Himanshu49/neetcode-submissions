class Solution {
    HashMap<String, Integer> map;
    public int lastStoneWeightII(int[] stones) {
        map =new HashMap<>();
        return lastStoneWeightII(stones, 0, 0, 0);
    }

    public int lastStoneWeightII(int[] stones, int pos, int leftSum, int rightSum){
        if(pos == stones.length){
            return Math.abs(leftSum - rightSum);
        }

        if(!map.containsKey(pos+" "+leftSum+" "+rightSum)){
            // include stone in left and get the best sum
            int incl= lastStoneWeightII(stones, pos+1, leftSum + stones[pos], rightSum);

            // include stone in right and get the best sum
            int excl = lastStoneWeightII(stones, pos+1, leftSum, rightSum+stones[pos]);

            map.put(pos+" "+leftSum+" "+rightSum, Math.min(incl, excl));
        }

        return map.get(pos+" "+leftSum+" "+rightSum);
    }
}