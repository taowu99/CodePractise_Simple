package org.tao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueensSolution {
	public List<List<String>> solveNQueens(int n) {
		char[][] board=new char[n][n];
		for (int i=0; i<n; ++i)
			for (int j=0; j<n; ++j)
				board[i][j]='.';

		return solveNQueens(n, board);
	}
	
	public List<String> snapBoard(char[][] board) {
		List<String> result = new ArrayList();
		for (char[] row : board) {
			result.add(String.valueOf(row));
		}
		return result;
	}
	
	public List<List<String>> solveNQueens(int leftQueens, char[][] existingBoard) {
		final int sz = existingBoard.length;
		List<List<String>> results = new ArrayList();
		for (int c=0; c<sz; ++c) {
			//existingBoard[sz-leftQueens][c]='Q';
			if (validPositionOnBoard(existingBoard, sz-leftQueens,c)){
				existingBoard[sz-leftQueens][c]='Q';
				if (leftQueens>1)
					results.addAll(solveNQueens(leftQueens - 1, existingBoard));
				else {
					results.add(snapBoard(existingBoard));
				}
			}

			existingBoard[sz-leftQueens][c]='.';
		}
		return results;
	}
	
	public int totalNQueens(int n) {
        return 0;
    }
	
	public boolean validPositionOnBoard(char[][] board, int row, int col) {
		final int sz = board.length;
				
		
		for (int r=0; r<sz; ++r) {
			if (r==row)
				continue;
			if (board[r][col]=='Q')
				return false;
		}
		
		for (int c=0; c<sz; ++c) {
			if (c==col)
				continue;
			if (board[row][c]=='Q')
				return false;
		}
		
		int r=row, c=col;
		while (r>0 && c<sz-1) {
			--r; ++c;
		}
		
//		int r=row, c=col;
//		
//		while (r>0) {
//			if (board[--r][c]=='Q')
//				return false;
//		}
//		r=row;
//		c=col;
//		while (r<sz-1) {
//			if (board[++r][c]=='Q')
//				return false;
//		}
//		r=row;
//		c=col;
//		while (c>0) {
//			if (board[r][--c]=='Q')
//				return false;
//		}
//		r=row;
//		c=col;
//		while (c<sz-1) {
//			if (board[r][++c]=='Q')
//				return false;
//		}
//		
//		r=row; c=col;
//		while (r>0 && c<sz-1) {
//			if (board[--r][++c]=='Q')
//				return false;
//		}
//		r=row;
//		c=col;
//		while (r<sz-1 && c<sz-1) {
//			if (board[++r][++c]=='Q')
//				return false;
//		}
//		r=row;
//		c=col;
//		while (c>0 && r<sz-1) {
//			if (board[++r][--c]=='Q')
//				return false;
//		}
//		r=row;
//		c=col;
//		while (r>0 && c>0) {
//			if (board[--r][--c]=='Q')
//				return false;
//		}
		return true;
	}
	
	public boolean validBoard(char[][] board) {
		final int sz = board.length;
		
		int cnt=0;
		
		//check row
		for (int c=0; c<sz; ++c) {
			cnt=0;
			for (int r=0; r<sz; ++r) {
				if (board[r][c]=='Q') ++cnt;
				if (cnt>1)
					return false;
			}
		}

		//check column
		for (int r=0; r<sz; ++r) {
			cnt=0;
			for (int c=0; c<sz; ++c) {
				if (board[r][c]=='Q') ++cnt;
				if (cnt>1)
					return false;
			}
		}
		
		//check diagnol
		for (int c=0; c<sz; ++c) {
			int x=0, y=c;
			cnt=0;
			while (x>=0 && y>=0 && x<sz && y<sz) {
				if (board[x][y]=='Q') ++cnt;
				if (cnt>1)
					return false;
				++x;
				--y;
			}
		}

		for (int r=0; r<sz; ++r) {
			int x=r, y=sz-1;
			cnt=0;
			while (x>=0 && y>=0 && x<sz && y<sz) {
				if (board[x][y]=='Q') ++cnt;
				if (cnt>1)
					return false;
				--x;
				--y;
			}
		}

		for (int r=0; r<sz-1; ++r) {
			int x=r, y=0;
			cnt=0;
			while (x>=0 && y>=0 && x<sz && y<sz) {
				if (board[x][y]=='Q') ++cnt;
				if (cnt>1)
					return false;
				++x;
				++y;
			}
		}
		
		for (int c=0; c<sz-1; ++c) {
			int x=sz-1, y=c;
			cnt=0;
			while (x>=0 && y>=0 && x<sz && y<sz) {
				if (board[x][y]=='Q') ++cnt;
				if (cnt>1)
					return false;
				--x;
				++y;
			}
		}
		
		return true;
	}
}
