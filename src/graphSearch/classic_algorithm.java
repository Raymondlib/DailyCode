package graphSearch;

public class classic_algorithm {
    // 弗洛伊德算法, 求 多源最短路径
    public void floyd(){
        int k;// 第几个允许加入的节点
        int i;// 遍历
        int j;// 遍历
        int n=30;// 节点总数
        int [][] e = new int[0][];
        for(k=1;k<=n;k++)
            for(i=1;i<=n;i++)
                for(j=1;j<=n;j++)
                    if(e[i][j]>e[i][k]+e[k][j])
                        e[i][j]=e[i][k]+e[k][j];
    }
    //Dijkstra算法使用了广度优先搜索解决赋权有向图或者无向图的单源最短路径问题，
    // 算法最终得到一个最短路径树。该算法常用于路由算法或者作为其他图算法的一个子模块
    //时间复杂度是n的平方，可以使用堆优化
    //只能适用于权值为正的情况下
    public void dijkstra(){
        
    }
    public int[] dijkstra(int v) {
        int numOfVexs=8; //点数
        int [][] edges =new int[numOfVexs][numOfVexs];
        if (v < 0 || v >= numOfVexs)
            throw new ArrayIndexOutOfBoundsException();
        boolean[] st = new boolean[numOfVexs];// 默认初始为false
        int[] distance = new int[numOfVexs];// 存放源点到其他点的矩离

        for (int i = 0; i < numOfVexs; i++)
            for (int j = i + 1; j < numOfVexs; j++) {
                if (edges[i][j] == 0) {
                    edges[i][j] = Integer.MAX_VALUE;
                    edges[j][i] = Integer.MAX_VALUE;
                }
            }
        for (int i = 0; i < numOfVexs; i++) {
            distance[i] = edges[v][i];
        }
        st[v] = true;
        // 处理从源点到其余顶点的最短路径
        for (int i = 0; i < numOfVexs; ++i) {
            int min = Integer.MAX_VALUE;
            int index=-1;
            // 比较从源点到其余顶点的路径长度
            for (int j = 0; j < numOfVexs; ++j) {
                // 从源点到j顶点的最短路径还没有找到
                if (st[j]==false) {
                    // 从源点到j顶点的路径长度最小
                    if (distance[j] < min) {
                        index = j;
                        min = distance[j];
                    }
                }
            }
            //找到源点到索引为index顶点的最短路径长度
            if(index!=-1)
                st[index] = true;
            // 更新当前最短路径及距离
            for (int w = 0; w < numOfVexs; w++)
                if (st[w] == false) {
                    if (edges[index][w] != Integer.MAX_VALUE
                            && (min + edges[index][w] < distance[w]))
                        distance[w] = min + edges[index][w];
                }
        }
        return distance;
    }

}
