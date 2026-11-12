class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for(int r=0;r<n;r++){
            dfs(board,r,0);
            dfs(board,r,m-1);
        }
        for(int c=0;c<m;c++){
            dfs(board,0,c);
            dfs(board,n-1,c);
        }
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                }else if(board[r][c]=='S'){
                    board[r][c]='O';
                }
            }
        }
    }
    public void dfs(char[][] board,int r,int c){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!='O'){
            return;
        }
        board[r][c]='S';
        dfs(board,r+1,c);
        dfs(board,r-1,c);
        dfs(board,r,c+1);
        dfs(board,r,c-1);
    }
}