package leetcode1000.bfs;

public class t130 {
    static void bfs(int x, int y, int m, int n, char[][] board){
        board[x][y] = 'A';
        int [] dx= {-1,0,1,0};
        int [] dy= {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nx = dx[i] +x;
            int ny = dy[i] +y;
            if(nx>=0 && nx< m && ny>=0 && ny<n){
                if(board[nx][ny]=='O'){
                    board[nx][ny] ='A';
                    bfs(nx,ny,m,n,board);
                }
            }
        }
    }

    public static void solve(char[][] board)  {
        int m = board.length;
        if(m==0) return;
        int n= board[0].length;
        if( n==0) return ;
        // 从边界开始bfs，但是这个代码写的太麻烦了
        for(int i=0;i<m;i++){
            if(board[i][0] == 'O'){
                bfs(i,0,m,n,board);
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][n-1] == 'O'){
                bfs(i,n-1,m,n,board);
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i] == 'O'){
                bfs(0,i,m,n,board);
            }
        }
        for(int i=0;i<n;i++){
            if(board[m-1][i] == 'O'){
                bfs(m-1,i,m,n,board);
            }
        }
        //应该改成
//        for(int i){
//            for (int j){
//                boolean isEdge = i==0||j == 0 || i == m - 1 || j == n - 1;
//                if(isEdge && board[i][j] == 'O'){
//                    bfs()
//                }
//            }
//        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='A'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]= 'X';
                }
            }
        }


    }
    public static void main(String[] args) {
        char [][] b = new char[4][4];
        b= new char[][]{{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
        solve(b);
    }
}
