/*
 * https://leetcode-cn.com/problems/minimum-subsequence-in-non-increasing-order/
 */

class MinSubsequence {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        Arrays.sort(nums);
        int half = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--){
            half += nums[i];
            ans.add(nums[i]);
            if(half > sum / 2) break;
        }
        return ans;
    }
}
