class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> allNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            allNums.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (allNums.containsKey(target-nums[i]) && allNums.get(target-nums[i]) != i) {
                return new int[]{i, allNums.get(target-nums[i])};
            }
        }

        return null;
        
    }
}
