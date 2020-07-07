/*
 * https://leetcode-cn.com/problems/build-an-array-with-stack-operations/
 */

class BuildArray {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int need = 1;
        for(int i = 0; i < target.length; i++){
            int cur = target[i];
            while(cur > need){
                ans.add("Push");
                ans.add("Pop");
                need++;
            }
            ans.add("Push");
            need++;
        }
        return ans;
    }
}
