/*
 * https://leetcode-cn.com/problems/sort-colors/
 */

class SortColors {
    public void sortColors(int[] nums) {
        int p0 = 0, cur = 0, p2 = nums.length-1;
        while(cur <= p2){
            if(nums[cur] == 2){
                swap(nums, cur, p2--);
            }else if(nums[cur] == 0){
                swap(nums, cur++, p0++);
            }else{
                cur++;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
