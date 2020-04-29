class test{
    static void print(char [][] b){
//        int m =b.length;
//        int n = b[0].length;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(b[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
    static void bfs(int x, int y, int m, int n, char[][] board){
        board[x][y] = 'A';
        print(board);
        System.out.println();
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
        int n= board[0].length;

        if(m==0 || n==0) return ;
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
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='A'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]= 'X';
                }
            }
        }
        print(board);

    }
    public static void main(String[] args) {
        char [][] b = new char[4][4];
        b= new char[][]{{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
        solve(b);
    }
}