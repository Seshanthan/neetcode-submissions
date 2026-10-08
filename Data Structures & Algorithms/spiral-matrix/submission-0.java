class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n= matrix.length;
        int m=matrix[0].length;
        int top=0,bot=n-1,l=0,r=m-1;
        List<Integer> ans=new ArrayList<>();
        while(true){
            if(top>bot || l>r) break;
            for(int i=l;i<=r;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            if(top>bot || l>r) break;
            for(int i=top;i<=bot;i++){
                ans.add(matrix[i][r]);
            }
            r--;
            if(top>bot || l>r) break;
            for(int i=r;i>=l;i--){
                ans.add(matrix[bot][i]);
            }
            bot--;
            if(top>bot || l>r) break;
            for(int i=bot;i>=top;i--){
                ans.add(matrix[i][l]);
            }
            l++;
            if(top>bot || l>r) break;
        }
        return ans;
    }
}