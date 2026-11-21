class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean[][] dp= new boolean[n][n];
        int c=0;
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            c++;
        }
        for(int len=2;len<=n;len++){
            for(int i=0;i+len<=n;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j) &&(len==2 ||  dp[i+1][j-1])){
                    dp[i][j]=true;
                    c++;
                }
            }
        }
        return c;
    }
}