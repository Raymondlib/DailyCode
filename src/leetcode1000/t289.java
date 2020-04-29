package leetcode1000;

/**
 * 2020年4月24日 周五
 * 生命游戏
 * 1 重新复制一个 数组，更新状态
 * 2 利用int 有 32位，而0-1 只用了 1位，利用第二位来记录更新的状态，然后数字右移
 * 3 利用状态码，区分 0-1， 1-0
 */

public class t289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if(m==0 ) return ;
        int n = board[0].length;
        if(n==0) return ;
        int [] dx= {1,1,1,0,0,-1,-1,-1};
        int [] dy = {1,0,-1,1,-1,1,0,-1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int temp=0;
                for(int k =0;k<8;k++){
                    int nextX = i+dx[k];
                    int nextY = j+dy[j];
                    if(nextX>=0 && nextX<m && nextY>=0 && nextY<n
                            // key
                            && (board[nextX][nextY]==1 || board[nextX][nextY]==-1)){
                        temp++;
                    }
                }
                if(board[i][j]==1){
                    if(temp <2 || temp>3) board[i][j]=-1;
                }else if(board[i][j] == 0){
                    if(temp == 3) board[i][j] =2;
                }
            }
        }
        // 更新
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == -1){
                    board [i][j] =0;
                }else if(board[i][j]==2)
                    board[i][j]=1;
            }
        }
    }
}
