/*
 * https://leetcode-cn.com/problems/h-index/
 */
 
class HIndex {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        Arrays.sort(citations);
        int ans = 0;
        for(int i = citations.length - 1; i >= 0; i--){
            if(citations.length - i >= citations[i]) return Math.max(citations[i],ans);
            else ans = citations.length - i;
        }
        return citations.length;
    }
}
