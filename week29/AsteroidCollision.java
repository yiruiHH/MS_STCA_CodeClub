/*
 * https://leetcode-cn.com/problems/asteroid-collision/
 */

class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            int n = asteroids[i];
            if(s.isEmpty()) s.push(n);
            else{
                while(!s.isEmpty() && n < 0 && s.peek() > 0){
                    if(-n == s.peek()){
                        s.pop();
                        n = 0;
                        break;
                    }
                    else if(-n < s.peek()){
                        break;
                    }
                    else{
                        s.pop();
                    }
                }
                if(n == 0) continue;
                if(n != 0 && s.isEmpty()){
                    s.push(n);
                    continue;
                }
                if(!s.isEmpty() && (n * s.peek() > 0 || (n > 0 && s.peek() < 0))){
                    s.push(n);
                    continue;
                }
            }
        }
        int[] ans = new int[s.size()];
        int index = s.size() - 1;
        while(!s.isEmpty()){
            ans[index--] = s.pop();
        }
        return ans;
    }
}
