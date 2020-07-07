/*
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 */

class RemoveOuterParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int t = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') t++;
            else t--;
            if(t == 0){
                if(i - start + 1 > 2)
                    sb.append(s.substring(start+1, i));
                start = i + 1;
            }
        }
        return sb.toString();
    }
}
