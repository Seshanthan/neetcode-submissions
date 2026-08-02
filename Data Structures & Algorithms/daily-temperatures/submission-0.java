class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> s = new Stack<>();
        int n = t.length;
        int[] ans = new int[n];
        s.push(0);
        for (int i = 1; i<n; i++) {
            while(!s.isEmpty() && t[s.peek()]<t[i]){
                int j=s.pop();
                ans[j]=i-j;
            }
            s.push(i);
        }

        return ans;
    }
}