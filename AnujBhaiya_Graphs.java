public class Graphs {
    //**************************BREADTH FIRST SEARCH***********************************************************************

    class Solution {
        // Function to return Breadth First Traversal of given graph.
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean visited[]=new boolean[V];
            int distance[]=new int[V];
            int pred[]=new int[V];
            LinkedList<Integer> queue=new LinkedList<>();
            ArrayList<Integer> result=new ArrayList<Integer>();
            
            for(int i=0;i<V;i++){
                visited[i]=false;
            }
            visited[0]=true;
            distance[0]=0;
            pred[0]=0
            queue.add(0);
            result.add(0);
            
            
            while(!queue.isEmpty()){
                int c=queue.poll();
                for(int j=0;j<adj.get(c).size();j++){
                    int neighbor=adj.get(c).get(j);
                    if(visited[neighbor]==false){
                        visited[neighbor]=true;
                        pred[neighbor]=c;
                        distance[neighbor]=distance[c]+1;
                        result.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            return result;
        }
    }
    //**************************DEPTH FIRST SEARCH***********************************************************************

    class Solution {
        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean visited[]=new boolean[V];
            ArrayList<Integer> result=new ArrayList<Integer>();
            for(int i=0;i<V;i++){
                    visited[i]=false;
                }
            dfsUtil(0,adj,visited,result);
            return result;
            
        }
         public void dfsUtil(int src, ArrayList<ArrayList<Integer>> adj,boolean visited[],ArrayList<Integer> result) {
            // Code here
            visited[src]=true;
            result.add(src);
            
            for(Integer neighbor: adj.get(src)){
                if(!visited[neighbor]){
                    dfsUtil(neighbor,adj,visited,result);
                }
            }
            
        }
    }
    //**************************CYCLE DETECTION DFS-UNDIRECTED***********************************************************************

    class Solution {
        // Function to detect cycle in an undirected graph.
        public boolean dfs(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean visited[]=new boolean[V];
            for(int i=0;i<V;i++){
                    visited[i]=false;
            }
            for(int i=0;i<V;i++){
                    if(!visited[i]){
                        if(dfsCycleDetection(i,-1,adj,visited)){
                            return true;
                        }
                    }
                }
            return false;
        }
         public boolean dfsCycleDetection(int src,int parent,ArrayList<ArrayList<Integer>> adj,boolean visited[]) {
            // Code here
            visited[src]=true;
            
            for(Integer neighbor: adj.get(src)){
                if(!visited[neighbor]){
                    if(dfsCycleDetection(neighbor,src,adj,visited))
                    return true;
                }
                else if(parent!=neighbor){
                    return true;
                }
            }
            return false;
            
        }
    }
    //**************************CYCLE DETECTION DFS-DIRECTED***********************************************************************
    class Solution {
        // Function to detect cycle in a directed graph.
        public boolean dfs(int V, ArrayList<ArrayList<Integer>> adj) {
            // code here
            boolean visited[]=new boolean[V];
            boolean recS[]=new boolean[V];
            for(int i=0;i<V;i++){
                    visited[i]=false;
                    recS[i]=false;
            }
            for(int i=0;i<V;i++){
                    if(!visited[i]){
                        if(dfsCycleDetection(i,adj,visited,recS)){
                            return true;
                        }
                    }
                }
            return false;
        }
        public boolean dfsCycleDetection(int src, ArrayList<ArrayList<Integer>> adj,boolean visited[],boolean recS[]) {
            // Code here
            visited[src]=true;
            recS[src]=true;
            
            for(Integer neighbor: adj.get(src)){
                if(!visited[neighbor]){
                    if(dfsCycleDetection(neighbor,adj,visited,recS))
                    return true;
                }
                else if(recS[neighbor]==true){
                    return true;
                }
            }
            recS[src]=false;
            return false;
            
        }
    }

    //**************************TOPOLOGICAL SORT STACK***********************************************************************
    class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        // Code here
            Stack<Integer> st=new Stack<>();
            boolean visited[]=new boolean[V];
            for(int i=0;i<V;i++){
                    visited[i]=false;
                }
                 for(int i=0;i<V;i++){
                    if(!visited[i])
                    {
                        dfsUtil(i,adj,visited,st);
                    }
                }
            int ans[]=new int[V];
            int i=0;
            while(!st.isEmpty()){
                ans[i++]=st.pop();
            }
            return ans;
        }
    public static void dfsUtil(int src, ArrayList<ArrayList<Integer>> adj,boolean visited[],Stack<Integer> st) {
            // Code here
            visited[src]=true;
            
            for(Integer neighbor: adj.get(src)){
                if(!visited[neighbor]){
                    dfsUtil(neighbor,adj,visited,st);
                }
            }
            st.push(src);
        }
}

    //**************************TOPOLOGICAL SORT KAHN BFS***********************************************************************
    
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
	    Queue<Integer> q=new LinkedList<>();
	    ArrayList<Integer> ans=new ArrayList<Integer>();
	    int inDeg[]=new int[V];
	    for(int i=0;i<V;i++){
	        for(int neighbor: adj.get(i)){
	            inDeg[neighbor]++;
	        }
	    }
	    
	    for(int i=0;i<V;i++){
	        if(inDeg[i]==0){
	            q.add(i);
	        }
	    }
	    
	    while(!q.isEmpty()){
	        int curr=q.poll();
	        ans.add(curr);
	        for(int neighbor: adj.get(curr)){
	            if(--inDeg[neighbor]==0){
	                q.add(neighbor);
	            }
	        }
	    }
	    int A[]=new int[V];
	    int i=0;
	    for(int e:ans){
	        A[i++]=e;
	    }
	    return A;
    }
    
}
 //**************************PRIM'S ALGO- MIN SPANNING TREES***********************************************************************

    class Pair implements Comparable<Pair>{
        int wt;
        int v;
        Pair(int v,int wt){
            this.v=v;
            this.wt=wt;
        }
        public int compareTo(Pair that){
            return this.wt-that.wt;
        }
    }
    class Solution
    {
        //Function to find sum of weights of edges of the Minimum Spanning Tree.
        static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
        {
            // Add your code here
            boolean visited[]=new boolean[V];
            PriorityQueue<Pair> q=new PriorityQueue<>();
            q.add(new Pair(0,0));
            int ans=0;
            while(q.size()!=0){
                Pair cur=q.poll();
                int u=cur.v;
                if(visited[u]==true){
                    continue;
                }
                ans+=cur.wt;
                visited[u]=true;
                
                ArrayList<ArrayList<Integer>> neighbor=adj.get(u);
                for(ArrayList<Integer> list: neighbor){
                    int vertex=list.get(0);
                    int weight=list.get(1);
                    if(visited[vertex]==false){
                        q.add(new Pair(vertex,weight));
                    }
                }
            }
            return ans;
        }
    }
 //**************************DIJSKTRA'S ALGORITHM***********************************************************************
    class Pair implements Comparable<Pair>{
        int wt;
        int v;
        Pair(int v,int wt){
            this.v=v;
            this.wt=wt;
        }
        public int compareTo(Pair that){
            return this.wt-that.wt;
       }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
            boolean visited[]=new boolean[V];
            PriorityQueue<Pair> q=new PriorityQueue<>();
            
            
            int ans[]=new int[V];
            Arrays.fill(ans,Integer.MAX_VALUE);
            ans[S]=0;
            q.add(new Pair(S,0));
            while(q.size()!=0){
                Pair cur=q.poll();
                int u=cur.v;
                if(visited[u]==true){
                    continue;
                }
                visited[u]=true;
                
                ArrayList<ArrayList<Integer>> neighbor=adj.get(u);
                for(ArrayList<Integer> list: neighbor){
                    int vertex=list.get(0);
                    int weight=list.get(1);
                    if(ans[vertex]>ans[u]+weight){
                        ans[vertex]=ans[u]+weight;
                        q.add(new Pair(vertex,ans[vertex]));
                    }
                }
            }
            return ans;
    }
 //**************************BELLMAN-FORD ALGORITHM***********************************************************************
 class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dis = new int[V];
        for(int i=0;i<V;i++)
        dis[i] = 100000000;
        dis[S] = 0;

        for(int i=0;i<V-1;i++) {
            for(int j=0;j<edges.size();j++) {
                int src=edges.get(j).get(0);
                int des=edges.get(j).get(1);
                int wt=edges.get(j).get(2);
                if(dis[src]+wt<dis[des])
                    dis[des]=dis[src]+wt;
            }
        }
          for(int j=0;j<edges.size();j++) {
                int src=edges.get(j).get(0);
                int des=edges.get(j).get(1);
                int wt=edges.get(j).get(2);
                if(dis[src]+wt<dis[des])
                return new int[]{-1};
            }
        return dis;
    }
     //**************************KRUSAKAL ALGORITHM***********************************************************************




    
}
