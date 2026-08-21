class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int l=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int h=(n*m)-1;
        
        while(l<=h){
            int mid=l+(h-l)/2;
            int row=mid/m;
            int col=mid%m;
            if(matrix[row][col]>target){
                h=mid-1;
            }
            else if(matrix[row][col]<target){
                l=mid+1;
            }
            else{
                return true;
            }
        }
        return false;

        
    }
}