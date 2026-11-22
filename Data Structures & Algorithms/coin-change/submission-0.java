class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] dp= new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<amount+1;i++){
            for(int j:coins){
                if(i>=j) dp[i]=Math.min(dp[i],dp[i-j]+1);
            }
        }
        if(dp[amount]==amount+1) return -1;
        return dp[amount];
    }
}