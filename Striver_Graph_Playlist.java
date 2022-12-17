public class Striver_Graph_Playlist {
    //*******************Number of Provinces**************************** */
    class Solution {
        static void  dfs(int i,ArrayList<ArrayList<Integer>> adjLs,boolean []visited){
            visited[i]=true;
            for(Integer it: adjLs.get(i)){
                if(visited[it]==false){
                    dfs(it,adjLs,visited);
                }
            }
        }
        static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
            // code here
            ArrayList<ArrayList<Integer>> adjLs=new ArrayList<>();
            for(int i=0;i<V;i++){
                adjLs.add(new ArrayList<>());
            }
        
            for(int i=0;i<V;i++){
             for(int j=0;j<V;j++){
                 if(adj.get(i).get(j)==1&&i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
             }
            }
            
            boolean visited[]=new boolean[V];
            for(int i=0;i<V;i++){
                visited[i]=false;
            }
            int cnt=0;
            for(int i=0;i<V;i++){
                if(visited[i]==false){
                    dfs(i,adjLs,visited);
                    cnt++;
                }
            }
            return cnt;
    }
    }
    //*******************Number of Islands****************************** */  
    class Solution {
        class Pair{
            int row;
            int col;
            Pair(int _row,int _col){
            this.row=_row;
            this.col=_col;
            }
        }
    public void bfs(int i,int j,char [][]grid,boolean [][]visited,int n,int m){
        visited[i][j]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            q.remove();
            for(int dx=-1;dx<=1;dx++){
                for(int dy=-1;dy<=1;dy++){
                    int nr=r+dx;
                    int nc=c+dy;
                    if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]=='1'&&visited[nr][nc]==false){
                     {
                        visited[nr][nc]=true;
                        q.add(new Pair(nr,nc));
                     }
                }
            }
        }
    }
    }
    public int numIslands(char[][] grid) {
            int n=grid.length;
            int m=grid[0].length;
            boolean visited[][]=new boolean[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    visited[i][j]=false;
                }
            }
            int cnt=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(visited[i][j]==false && grid[i][j]=='1'){
                    cnt++;
                    bfs(i,j,grid,visited,n,m);
                }
            }
        }
            return cnt;
    }
}
    //*******************Flood Fill************************************* */
    class Solution{
        public void dfs(int sr,int sc,int [][]ans,int [][]image,int []dx,int []dy,int iniColor,int newColor,int n,int m){
            ans[sr][sc]=newColor;
            for(int i=0;i<4;i++){
                int nr=sr+dx[i];
                int nc=sc+dy[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&image[nr][nc]==iniColor&&ans[nr][nc]!=newColor){
                       dfs(nr,nc,ans,image,dx,dy,iniColor,newColor,n,m);
                }
            }
        }
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
        {
            // Code here
            int n=image.length;
            int m=image[0].length;
            int iniColor=image[sr][sc];
            int ans[][]=image;
            int dx[]={-1,0,1,0};
            int dy[]={0,1,0,-1};
            dfs(sr,sc,ans,image,dx,dy,iniColor,newColor,n,m);
            return ans;
        }
    }
    //*******************Rotten Oranges**********************************/
   class Solution{
    class Pair{
        int rows;
        int cols;
        int time;
        Pair(int _x,int _y,int _z){
            this.rows=_x;
            this.cols=_y;
            this.time=_z;
        }
    }
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int rows=grid.length;
        int cols=grid[0].length;

        Queue<Pair> q=new LinkedList<>();
        boolean visited[][]=new boolean[rows][cols];
        int cntFresh=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
              if(grid[i][j]==2){
                  q.add(new Pair(i,j,0));
                  visited[i][j]=true;
              }    
              else{
                  visited[i][j]=false;
              }
              if(grid[i][j]==1){
                  cntFresh++;
              }
            }
        }
        if(cntFresh==0){
            return 0;
        }
        int tm=0;
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        int cnt=0;
        while(!q.isEmpty()){
            int r=q.peek().rows;
            int c=q.peek().cols;
            int t=q.peek().time;
            tm=Math.max(t,tm);
            q.remove();
            for(int i=0;i<4;i++){
                int nr=r+dx[i];
                int nc=c+dy[i];
                if(nr>=0&&nr<rows&&nc<cols&&nc>=0&&grid[nr][nc]==1&&visited[nr][nc]==false){
                    q.add(new Pair(nr,nc,t+1));
                    visited[nr][nc]=true;
                    cnt++;
                    }
                }
            }
        if(cnt!=cntFresh)return -1;
        return tm;
    }
}
    //******************Distance of nearest cell having 1|0/1 Matrix|******** */
    class Solution  {
    class Tuple{
        int row;
        int col;
        int steps;
        Tuple(int _row,int _col,int _steps){
            this.row=_row;
            this.col=_col;
            this.steps=_steps;
        }
    }
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        Queue<Tuple> q=new LinkedList<>();
        boolean visited[][]=new boolean[n][m];
        int distance[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new Tuple(i,j,0));
                    visited[i][j]=true;
                }
                else{
                    visited[i][j]=false;
                }
            }
        }
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int st=q.peek().steps;
            q.remove();
            distance[r][c]=st;
            for(int i=0;i<4;i++){
                int nr=r+dx[i];
                int nc=c+dy[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&visited[nr][nc]==false&&grid[nr][nc]==0){
                    visited[nr][nc]=true;
                    q.add(new Tuple(nr,nc,st+1));
                }
            }
        }
        return distance;
    }
}
    //****************Replace 'O' with 'X'*********************************** */
    class Solution{
        static void dfs(int row,int col,char [][]a,boolean [][]visited,int []dx,int []dy,int n,int m){
            visited[row][col]=true;
            
            for(int i=0;i<4;i++){
                    int nr=row+dx[i];
                    int nc=col+dy[i];
                    if(nr>=0&&nr<n&&nc>=0&&nc<m&&visited[nr][nc]==false&&a[nr][nc]=='O'){
                        dfs(nr,nc,a,visited,dx,dy,n,m);
                    }
                }
        }
        static char[][] fill(int n, int m, char a[][])
        {
            // code here
            int dx[]={-1,0,1,0};
            int dy[]={0,1,0,-1};
            
            boolean visited[][]=new boolean[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    visited[i][j]=false;
                }
            }
            
            for(int j=0;j<m;j++){
                if(visited[0][j]==false&&a[0][j]=='O'){
                    dfs(0,j,a,visited,dx,dy,n,m);
                }
                 if(visited[n-1][j]==false&&a[n-1][j]=='O'){
                    dfs(n-1,j,a,visited,dx,dy,n,m);
                }
            }
            for(int i=0;i<n;i++){
                if(visited[i][0]==false&&a[i][0]=='O'){
                    dfs(i,0,a,visited,dx,dy,n,m);
                }
                 if(visited[i][m-1]==false&&a[i][m-1]=='O'){
                    dfs(i,m-1,a,visited,dx,dy,n,m);
                }
            }
            
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(visited[i][j]==false&&a[i][j]=='O'){
                    a[i][j]='X';
                    }
                }
            }
            return a;
            
        }
    }
    //*******************Number of Enclaves*************************** */
    class Solution {
        class Pair{
            int row;
            int col;
            Pair(int _row,int _col){
            this.row=_row;
            this.col=_col;
            }
        }
        int numberOfEnclaves(int[][] grid) {
            Queue<Pair> q=new LinkedList<>();
            int n=grid.length;
            int m=grid[0].length;
            boolean visited[][]=new boolean[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                 visited[i][j]=false;
                }
            }
            
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(i==0||i==n-1||j==0||j==m-1){
                        if(grid[i][j]==1)
                        {
                            q.add(new Pair(i,j));
                            visited[i][j]=true;
                        }
                    }
                }
            }
                
            int dx[]={-1,0,1,0};
            int dy[]={0,1,0,-1};
            
            while(!q.isEmpty()){
                int r=q.peek().row;
                int c=q.peek().col;
                q.remove();
                for(int i=0;i<4;i++){
                    int nr=r+dx[i];
                    int nc=c+dy[i];
                    if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==1&&visited[nr][nc]==false){
                         {
                            visited[nr][nc]=true;
                            q.add(new Pair(nr,nc));
                         }
                    }
                }
            }
            
            int cnt=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                 if(visited[i][j]==false&&grid[i][j]==1){
                     cnt++;
                    }
                }
                
            }
            return cnt;
    }
    }
    //*****************Number of Distinct Islands****************************Constructive+DFS**************** */
    class Solution {
        class Pair{
            int row;
            int col;
            Pair(int _row,int _col){
            this.row=_row;
            this.col=_col;
            }
        }
        public void dfs(int row,int col,int [][]grid,boolean [][]visited,int []dx,int []dy,ArrayList<String> res,int sr,int sc,int n,int m){
                visited[row][col]=true;
                res.add(toString(row-sr,col-sc));
                
                for(int i=0;i<4;i++){
                    int nr=row+dx[i];
                    int nc=col+dy[i];
                    if(nr>=0&&nr<n&&nc>=0&&nc<m&&visited[nr][nc]==false&&grid[nr][nc]==1){
                          dfs(nr,nc,grid,visited,dx,dy,res,sr,sc,n,m);
                    }
                }
            }
            public String toString(int r,int c){
                return Integer.toString(r)+" "+Integer.toString(c);
            }
        int countDistinctIslands(int[][] grid) {
            // Your Code here
                int n=grid.length;
                int m=grid[0].length;
                boolean visited[][]=new boolean[n][m];
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        visited[i][j]=false;
                    }
                }
                int dx[]={-1,0,1,0};
                int dy[]={0,1,0,-1};
                HashSet<ArrayList<String>> hs=new HashSet<>();
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(visited[i][j]==false && grid[i][j]==1){
                        ArrayList<String> res=new ArrayList<>();
                        dfs(i,j,grid,visited,dx,dy,res,i,j,n,m);
                        hs.add(res);
                    }
                }
            }
            return hs.size();
        }
    }
    //*****************Bipartite Graph******BFS************************************************************** */
    class Solution
{
    public boolean check(int start,int V,ArrayList<ArrayList<Integer>> adj,int []color){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        color[start]=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            
            for(Integer it: adj.get(node)){
                if(color[it]==-1){
                    color[it]=1-color[node];
                    q.add(it);
                }
                else if(color[it]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int color[]=new int[V];
        for(int i=0;i<V;i++)
        {
            color[i]=-1;
        }
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(check(i,V,adj,color)==false){
                return false;
                }
            }
        }
        return true;
    }
}
    //*****************Bipartite Graph******DFS************************************************************** */
    class Solution{
    public boolean check(int start,int c,ArrayList<ArrayList<Integer>> adj,int []color){
        color[start]=c;
        for(Integer it: adj.get(start)){
            if(color[it]==-1){
                if(check(it,1-c,adj,color)==false){
                    return false;
                    }
                }
            else if(color[it]==color[start]){
                    return false;
                }
            }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int color[]=new int[V];
        for(int i=0;i<V;i++)
        {
            color[i]=-1;
        }
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(check(i,0,adj,color)==false){
                return false;
                }
            }
        }
        return true;
    }
}
    //*****************Find Eventual States DFs*************************************************************** */

    //*****************Djikstra's Shortest Path Algorithm******************************************************* */ 
    class Solution
    {
        class Pair{
            int distance;
            int node;
            Pair(int _dis,int _node){
                this.distance=_dis;
                this.node=_node;
            }
        }
        //Function to find the shortest distance of all the vertices
        //from the source vertex S.
        static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
        {
            // Write your code here
            PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.distance-y.distance);
            int distance[]=new int[V];
            for(int i=0;i<V;i++){
                distance[i]=(int)(1e9);
            }
            distance[S]=0;
            pq.add(new Pair(0,S));
            while(pq.size()!=0){
                int dis=pq.peek().distance;
                int node=pq.peek().node;
                pq.remove();
                for(int i=0;i<adj.get(node).size();i++){
                    int edgeW=adj.get(node).get(i).get(1);
                    int adjNode=adj.get(node).get(i).get(0);
                    
                    if(dis+edgeW<distance[adjNode]){
                        distance[adjNode]=dis+edgeW;
                        pq.add(new Pair(dis+edgeW,adjNode));
                    }
                }
            }
            return distance;
        }
    }
    //*****************Print Shortest Path Djikstra************************************************************* */
    class Solution {
    class Pair{
        int first;
        int second;
        Pair(int _first,int _second){
            this.first=_first;
            this.second=_second;
        }
    }
public static List<Integer> shortestPath(int n, int m, int edges[][]) {
    // code here
    ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
    for(int i=0;i<=n;i++){
        adj.add(new ArrayList<>());
    }
    for(int i=0;i<m;i++){
        adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
    }
    PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.first-y.first);
    int distance[]=new int[n+1];
    int parent[]=new int[n+1];
    for(int i=1;i<=n;i++){
        distance[i]=(int)(1e9);
        parent[i]=i;
    }
    distance[1]=0;
    pq.add(new Pair(0,1));
    while(pq.size()!=0){
        Pair it=pq.peek();
        int dis=it.first;
        int node=it.second;
        pq.remove();
        
        for(Pair iter: adj.get(node)){
            int adjNode=iter.first;
            int edgeWeight=iter.second;
            if(dis+edgeWeight<distance[adjNode]){
                distance[adjNode]=dis+edgeWeight;
                pq.add(new Pair(dis+edgeWeight,adjNode));
                parent[adjNode]=node;
            }
        }
    }
       
    List<Integer> path=new ArrayList<>();
    if(distance[n]==1e9){
        path.add(-1);
        return path;
    }
    int node=n;
    while(parent[node]!=node){
        path.add(node);
        node=parent[node];
    }
    path.add(1);
    Collections.reverse(path);
    return path;
}
}
//********************Bellman Ford - Negative Cycle |Base Code************************************************ */
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] distance=new int[V];
        for(int i=0;i<V;i++){
            distance[i]=(int)(1e8);
        }
        distance[S]=0;

        for(int i=0;i<V-1;i++) {
            for(ArrayList<Integer> it: edges){
                int u=it.get(0);
                int v=it.get(1);
                int wt=it.get(2);
                if(distance[u]!=(int)(1e8)&&distance[u]+wt<distance[v]){
                    distance[v]=distance[u]+wt;
                }
            }
        }
        for(ArrayList<Integer> it: edges){
                int u=it.get(0);
                int v=it.get(1);
                int wt=it.get(2);
                if(distance[u]!=(int)(1e8)&&distance[u]+wt<distance[v]){
                    int temp[]=new int[1];
                    temp[0]=-1;
                    return temp;
                    }
                }
        return distance;
    }
}
}
