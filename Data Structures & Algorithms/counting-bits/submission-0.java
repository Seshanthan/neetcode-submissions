class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0]=0;
        for(int i=1;i<=n;i++){
            int temp=i;
            int c=0;
            while(temp>0){
                if((temp&1)==1){
                    c++;
                }
                temp>>=1;
            }
            ans[i]=c;
        }
        return ans;
    }
}