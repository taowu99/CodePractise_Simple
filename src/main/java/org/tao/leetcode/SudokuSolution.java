package org.tao.leetcode;

public class SudokuSolution {
	public boolean solve(char[][] board) {
        for (int row=0; row<board.length; row++) {
            for (int col=0; col<board[0].length; ++col) {
                if (board[row][col]!='.')
                    continue;
                    
                for (char c='a'; c<='9'; ++c) {
                    if (validBoardPos(board, row, col,c)){
                        board[row][col]=c;
                    	
                    	if(!solve(board))
                    		board[row][col]='.';
                    	else
                    		return true;
                    }
                }
                
                if (board[row][col]=='.')
                	return false;
            }
        }
        return true;
    }
    
    public boolean validBoardPos(char[][] board,int row, int col, char chr) {
        for (int r=0; r<board.length; ++r)
            if (board[r][col]==chr)
                return false;
        for (int c=0; c<board[0].length; ++c)
            if (board[row][c]==chr)
                return false;
        for (int r=((int)row/3)*3; r<((int)row/3+1)*3; ++r)
            for (int c=((int)col/3)*3; c<((int)col/3+1)*3; ++c)
            	if (board[r][c]==chr)
            		return false;
        return true;
    }
}
