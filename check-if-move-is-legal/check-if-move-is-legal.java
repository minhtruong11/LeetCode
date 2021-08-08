class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        board[rMove][cMove] = color;
        
        int m = board.length;
        int n = board[0].length;
        
        char altColor = '-';
        
        switch(color) {
            case 'B':
                altColor = 'W';
                break;
            case 'W': 
                altColor = 'B';
                break;
        }
        
        for(int i=rMove+1; i<m; i++) {
            if(i == rMove+1 && board[i][cMove] != altColor) {
                break;
            } else {
                if(board[i][cMove] == color) {
                    return true;
                } else if(board[i][cMove] != altColor) {
                    break;
                }
            }
        }
        
        for(int i=rMove-1; i>=0; i--) {
            if(i == rMove-1 && board[i][cMove] != altColor) {
                break;
            } else {
                if(board[i][cMove] == color) {
                    return true;
                } else if(board[i][cMove] != altColor) {
                    break;
                }
            }
        }
        
        for(int j=cMove-1; j>=0; j--) {
            if(j == cMove-1 && board[rMove][j] != altColor) {
                break;
            } else {
                if(board[rMove][j] == color) {
                    return true;
                } else if(board[rMove][j] != altColor) {
                    break;
                }
            }
        }
        
        for(int j=cMove+1; j<n; j++) {
            if(j == cMove+1 && board[rMove][j] != altColor) {
                break;
            } else {
                if(board[rMove][j] == color) {
                    return true;
                } else if(board[rMove][j] != altColor) {
                    break;
                }
            }
        }
        
        for(int i=rMove-1, j=cMove-1; i>=0 && j>=0; i--, j--) {
            if(i==rMove-1 && j == cMove-1 && board[i][j] != altColor) {
                break;
            } else {
                if(board[i][j] == color) {
                    return true;
                } else if(board[i][j] != altColor) {
                    break;
                }
            }
        }
        
        for(int i=rMove+1, j=cMove+1; i<m && j<n; i++, j++) {
            if(i==rMove+1 && j == cMove+1 && board[i][j] != altColor) {
                break;
            } else {
                if(board[i][j] == color) {
                    return true;
                } else if(board[i][j] != altColor) {
                    break;
                }
            }
        }
        
         for(int i=rMove-1, j=cMove+1; i>=0 && j<n; i--, j++) {
            if(i==rMove-1 && j == cMove+1 && board[i][j] != altColor) {
                break;
            } else {
                if(board[i][j] == color) {
                    return true;
                } else if(board[i][j] != altColor) {
                    break;
                }
            }
        }
        
        for(int i=rMove+1, j=cMove-1; i<m && j>=0; i++, j--) {
            if(i==rMove+1 && j == cMove-1 && board[i][j] != altColor) {
                break;
            } else {
                if(board[i][j] == color) {
                    return true;
                } else if(board[i][j] != altColor) {
                    break;
                }
            }
        }
        
        return false;
        
    }
}