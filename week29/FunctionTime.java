/*
 * https://leetcode-cn.com/problems/exclusive-time-of-functions/
 */
class FunctionTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Record> stack = new Stack<>();
        Record first = new Record(logs.get(0));
        stack.push(first);
        int prev = first.timeStamp;
        for(int i = 1; i < logs.size(); i++){
            Record cur = new Record(logs.get(i));
            if(cur.isStart){
                if(!stack.isEmpty())
                    ans[stack.peek().id] += cur.timeStamp - prev;
                stack.push(cur);
                prev = cur.timeStamp;
            }
            else{
                Record last = stack.pop();
                ans[last.id] += cur.timeStamp - prev + 1;
                prev = cur.timeStamp + 1;
            }
        }
        return ans;
    }

    static class Record{
        int id;
        int timeStamp;
        boolean isStart;

        public Record(String s){
            String[] strs = s.split(":");
            id = Integer.parseInt(strs[0]);
            isStart = strs[1].equals("start");
            timeStamp = Integer.parseInt(strs[2]);
        }
    }

}
