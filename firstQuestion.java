/*     *************PROBLEM STATEMENT*************

Given a 2D board and a word, find if the word exists within the grid. The word can be constructed
from letters of sequentially adjacent cells, where "adjacent" cells are those horizontally or vertically
neighbouring. The same letter cell may not be used more than once.*/

import java.util.*;

class firstQuestion {
	public static void main(String []args){
       
		System.out.println("Enter the rows and columns for Board: ");
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		char board[][] = new char[row][col];

		System.out.println("Enter the characters for Board: ");
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				board[i][j] = sc.next().charAt(0);
			}
		}
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if (Character.isLowerCase(board[i][j])) 
					board[i][j] = Character.toUpperCase(board[i][j]); 
            
			}
		}
		
		System.out.println();
		System.out.print("How many Strings You want?: ");
		int s = sc.nextInt();
		
		String[] words = new String[s];
		
		System.out.print("Enter your all strings: ");
		for(int i=0;i<s;i++){
			words[i] = sc.next();
		}

        for (String word : words) {
			String w = word.toUpperCase();
            boolean isFound = contain(board, w);

            if (isFound) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
     }
	
    
    public static boolean contain(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        
        
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                visited[i][j] = false;
            }
        }
        
        boolean state = false;
        
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                state = wordSearch(board, visited, word, i, j, 0);
                if(state) 
					return true;
            }
        }
        
        return state;
    }
    
    public static boolean wordSearch(char[][] board, boolean[][] visited, String word, int n, int m, int index) {
        if (index >= word.length()) return true; 

        if (n < 0 || n >= board.length || m < 0 || m >= board[0].length) return false;
        
        if (visited[n][m] || board[n][m] != word.charAt(index)) return false;
        
       
        visited[n][m] = true;
        boolean state = false;
        
        state = wordSearch(board, visited, word, n, m - 1, index + 1);
        if (!state) state = wordSearch(board, visited, word, n, m + 1, index + 1);
        if (!state) state = wordSearch(board, visited, word, n - 1, m, index + 1);
        if (!state) state = wordSearch(board, visited, word, n + 1, m, index + 1);
        
        visited[n][m] = false;  
        return state;
    }
}