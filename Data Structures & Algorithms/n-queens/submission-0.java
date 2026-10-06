class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans= new ArrayList<>();
        char[][] board =  new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        
        backtrack(ans,board,0);
        return ans;
    }
    public void backtrack(List<List<String>> ans,char[][] board, int row){
        if(row==board.length){
            ArrayList<String> list = new ArrayList<>();
            for(int i=0;i<row;i++){
                list.add(new String(board[i]));
            }
            ans.add(list);
            return;
        }
        for(int col=0;col<board.length;col++){
            if(!isValid(board,row,col)){
                continue;
            }
            board[row][col]='Q';
            backtrack(ans,board,row+1);
            board[row][col]='.';
        }
    }
    public boolean isValid(char[][] board,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        int i=row-1;
        int j=col-1;
        while(i>=0 && j>=0){
            
            if(board[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }
        i=row-1;
        j=col+1;
        while(i>=0 && j<board.length){
            
            if(board[i][j]=='Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}