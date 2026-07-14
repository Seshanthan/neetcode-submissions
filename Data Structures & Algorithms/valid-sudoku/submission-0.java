class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(rows[j].contains(board[i][j]) || cols[i].contains(board[i][j]) || box[(i/3)*3+(j/3)].contains(board[i][j])){
                    return false;
                }
                rows[j].add(board[i][j]);
                cols[i].add(board[i][j]);
                box[(i/3)*3+j/3].add(board[i][j]);

            }         
        }
        return true;
    }
}
