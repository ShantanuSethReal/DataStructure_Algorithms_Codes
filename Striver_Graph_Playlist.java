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
    class Pair{
        int row;
        int col;
        Pair(int _row,int _col){
        this.row=_row;
        this.col=_col;
        }
    }
    class Solution {
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
    class Solution{
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
}
