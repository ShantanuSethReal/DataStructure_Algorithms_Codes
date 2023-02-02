public class Accio_Module_4 {
        class BinarySearchTree-1(CLASS-1){
        //BST-1
        //LeftMost Node is Minimum Value and RightMost Node is Maximum Value
        //****************************************************Construct BST from Sorted Array*************************
        class Solution{
        public TreeNode createArraytoBST(int []nums,int start,int end){
            if(start>end){
                return null;
            }
            int mid=(start+end)/2;
            TreeNode root=new TreeNode(nums[mid]);
            root.left=createArraytoBST(nums,start,mid-1);
            root.right=createArraytoBST(nums,mid+1,end);
            return root;
        }
        }
        //***************************************************Basic Operations*******************************************
        //***************************************************Size of BST*******************************************************************************************
        class Solution{
        public int sizeOfTree(TreeNode root){
            if(root==null)return 0;
            return 1+sizeOfTree(root.left)+sizeOfTree(root.right);
        }}
        //***************************************************Sum of BST*******************************************************************************************
        class Solution{
            public int sumOfTree(TreeNode root){
            if(root==null)return 0;
            return root.data+sumOfTree(root.left)+sumOfTree(root.right);
        }}
        //***************************************************Minimum of BST*******************************************************************************************
        class Solution{
            public int minOfBST(TreeNode root){
            TreeNode temp=root;
            while(temp.left!=null){temp=temp.left;}
            return temp.data;
        }}
        //***************************************************Maximum of BST*******************************************************************************************
        class Solution{
            public int maxOfBST(TreeNode root){
            TreeNode temp=root;
            while(temp.right!=null){temp=temp.right;}
            return temp.data;
        }}
        //***************************************************Search a Value*******************************************************************************************
        class Solution{
            public TreeNode searchVal(TreeNode root,int target){
            if(root==null)return false;
            
            if(root.data>target)searchVal(root.left,target);
            else if(root.data<target)searchVal(root.right,target);
            else{return true};
        }}
        //*************************************************Insertions Delete*************************************************************************************************
        //***************************************************Insert a Node
        class Solution{
            public static TreeNode insertNode(TreeNode root,int target){
            if(root==null){
                TreeNode root=new TreeNode(target);
                return root;
            }
            if(target<root.data)
                root.left=insertNode(root.left, target);
            else 
                root.right=insertNode(root.right, target);

            return root;
        }}
        //***************************************************Delete a Node******************************************************************************************* 
        //Case-1 Delete a Leaf Node|Case 2- Delete a Node with one child|Case 3- Delete a Node with two child
        //Inorder Predecessor or Inorder Successor
        class Solution{
            public int min(Node root){
                int minval=root.val;
                while(root.left!=null){
                    minval=root.left.val;
                    root=root.left;
                }
                return minval;
            }
            public Node deleteNode(Node root, int target){
                // WRITE YOUR CODE HERE
                if(root==null){return null;}
                if(root.val<target){root.right=deleteNode(root.right,target);}
                else if(root.val>target){root.left=deleteNode(root.left,target);}
                else{
                    if(root.left==null&&root.right==null){return null;}
                    else if(root.left==null){return root.right;}
                    else if(root.right==null){return root.left;}
                    else{
                        root.val=min(root.right);
                        root.right=deleteNode(root.right,root.val);
                    }
                }
                return root;
            }
        }
        //***************************************************Validate BST*******************************************************************************************
        class Solution{
        public boolean isValidBSTUtil(Node root,int min,int max){
            if(root==null){
                return true;
            }
            if(root.data>max||root.data<min){return false;}
            return isValidBSTUtil(root.left,min,root.data)&&isValidBSTUtil(root.right,root.data,max);
        }
    }
        //***************************************************Code 2 - Inorder Traversal*******************************************************************************************
        class Solution{
        Node prev=null;
        boolean isBST(TreeNode root){
            if(root==null)return true;
            if(!isBST(root.left))return false;
            if(prev!=null&&prev.data>=root.data)return false;
            prev=root;
            if(!isBST(root.right))return false;
            return true;
        }
    }
        //***************************************************LCA*******************************************************************************************
        class Solution{
        Node LCA(Node node, int n1, int n2)
        {
            // Your code here
            if(node==null)return null;
            if(node.data<n1&&node.data<n2)return LCA(node.right,n1,n2);
            if(node.data>n1&&node.data>n2)return LCA(node.left,n1,n2);
            return node;
        }}
        //Target Sum Pair
    }
        class BinarySearchTree-2(CLASS-2){
        //*****************************************************Target Sum Pair*********************************************************************************** */
        class Solution{
            public boolean find(Node root,int tar){
                Node curr=root;
                while(curr!=null&&curr.data!=tar){
                    curr=curr.data<tar?curr.right:curr.left;
                }
                if(curr==null){return false;}
                else return true;
            }
            public void targetSumHelper(Node root,Node node,int tar)
            {
                // your code here
                if(node==null)return;
                targetSumHelper(root,node.left,tar);
                int comp=tar-node.data;
                if(comp>node.data){
                    if(find(root,comp)){
                        System.out.println(node.data+" "+comp);
                        pair++;
                    }
                }
                targetSumHelper(root,node.right,tar);
            }
            int pair=0;
            public void targetSum(Node root, int tar)
            {
                // your code here
                targetSumHelper(root,root,tar);
                if(pair==0){
                    System.out.println("-1");
                }
            }
        
        }
        //*****************************************************Recover a BST************************************************************************************** */
        class Solution{
            static TreeNode first=null;
            static TreeNode second=null;
            static TreeNode prev=new TreeNode(Integer.MIN_VALUE);
            public static void inorder(TreeNode root){
                if(root==null){return;}
                inorder(root.left);
                if(first==null&&prev.val>root.val){
                    first=prev;
                }
                if(first!=null&&prev.val>root.val){
                    second=root;
                }
                prev=root;
                inorder(root.right);
            }
            public static void recoverTree(TreeNode root) {
                //Write code here
                inorder(root);
                int temp=first.val;
                first.val=second.val;
                second.val=temp;
            }
        }
        //*****************************************************Construct BST from PreOrder************************************************************************ */ 
        class Solution{
        static int idx=0;
        public static TreeNode CreateTree(int n,int[] A) {
        // Write Your Code here
		    return bstFromPreOrder(A,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        public static TreeNode bstFromPreOrder(int[] A,int min,int max){
                if(idx>=A.length||A[idx]>max||A[idx]<min){return null;}
                TreeNode root=new TreeNode(A[idx++]);
                root.left=bstFromPreOrder(A,min,root.val);
                root.right=bstFromPreOrder(A,root.val,max);
                return root;
		}
    }
        //*****************************************************Construct BST from PostOrder************************************************************************ */    
        class Solution{
            static int idx=0;
            public static TreeNode CreateTree(int n,int[] postOrder) {
                idx=n-1;
                return bstFromPostOrder(postOrder,Integer.MIN_VALUE,Integer.MAX_VALUE);
            }
            public static TreeNode bstFromPostOrder(int[] A,int min,int max){
                if(idx<0||A[idx]>max||A[idx]<min){return null;}
                TreeNode root=new TreeNode(A[idx--]);
                root.right=bstFromPostOrder(A,root.val,max);
                root.left=bstFromPostOrder(A,min,root.val);
                return root;
		    }
        }
        //*****************************************************Construct BST from LevelOrder************************************************************************ */    
        class Solution{
            class Pair{
                Node par=null;
                int lr=-(int)1e9,rr=(int)1e9;
                Pair(){}
                Pair(Node par,int lr,int rr){
                    this.par=par;
                    this.lr=lr;
                    this.rr=rr;
                }
            }
            Node bstFromLevel(int arr[],int n){
                LinkedList<Pair> que=new LinkedList<>();
                que.add(new Pair());
                Node root=null;
                int idx=0;
                while(que.size()!=0&&idx<n){
                    Pair rem=que.removeFirst();
                    int ele=arr[idx];
                    if(ele<rem.lr||ele>rem.rr){continue;}
                    Node node=new Node(ele);
                    idx++;
                    Node par=rem.par;
                    if(par==null) root=node;
                    else if(ele<par.data)par.left=node;
                    else par.right=node;
                
                    que.addLast(new Pair(node,rem.lr,ele));
                    que.addLast(new Pair(node,ele,rem.rr));
                }
                return root;
            }
    }        
        //*****************************************************BST Iterator************************************************** */    
        }
        class PrefixSum,Kadane,Kmp-1(CLASS-3){
        //***************************************************Serialize and Deserealize******************************************************************************************* 
        class Solution{
            public static String serialize(TreeNode root) {
            //Write code here
            StringBuilder sb=new StringBuilder();
            serialize(root,sb);
            return sb.toString();
        }
    
        public static void serialize(TreeNode root,StringBuilder sb){
            if(root==null){
                sb.append("null,");
                return ;
            }
            sb.append(root.val+",");
            S(root.left,sb);
            S(root.right,sb);
        }
        static int idx=0;
        // Decodes your encoded data to tree.
        public static TreeNode deserialize(String str) {
            //Write code here
            String sr[]=str.split(",");
            return deserealize(sr);
        }
        public static TreeNode deserealize(String str[]){
            if(idx>=str.length||str[idx].equals("null")){
                idx++;
                return null;
            }
            TreeNode root=new TreeNode(Integer.parseInt(str[idx++]));
            root.left=deserealize(str);
            root.right=deserealize(str);
    
            return root;
        }}
        //***************************************************Convert BST to Greater Tree*******************************************************************************************
        class Solution{
            int sum=0;
        public TreeNode convertBST(TreeNode root) {
            //Write code here
            convertBSTUtil(root);
            return root;
        
        }
        public void convertBSTUtil(TreeNode root){
            if(root==null)return ;  
            convertBSTUtil(root.right);
            root.val+=sum;
            sum=root.val;
            convertBSTUtil(root.left);
        }}
        //***************************************************Prefix Sum-Two Versions*******************************************************************************************  
        class Solution{
            //Version-1
            int prefixSum[]=new int[n];
		int prefixSum[0]=arr[0];
		for(int i=1;i<n;i++){
			prefixSum[i]=prefixSum[i-1]+arr[i];
		}
        int rangeSum=prefixSum[j]-prefixSum[i-1];
        //Version 2
        int prefixSum[]=new int[n+1];
		for(int i=0;i<n;i++){
			prefixSum[i+1]=prefixSum[i]+arr[i];
		}
        int rangeSum=prefixSum[j+1]-prefixSum[i];
    }
        //*****************************************************Range Query********************************************************************************************************
        class Solution{
            public int[] sumQuery(int[] arr, int[][] ranges) {
            // Your code here.
			int prefixSum[]=new int[n+1];
            int prefixSum[0]=0;
            for(int i=0;i<n;i++){
                prefixSum[i+1]=prefixSum[i]+arr[i];
            }
            int ans[]=new int[ranges.length];
            int idx=0;	
            for(int range[]: ranges){
                int start=range[0];
                int end=range[1];
                ans[idx++]=prefixSum[end+1]-prefixSum[start];
            }
            return ans;
        }}
        //****************************************************Car Pooling*********************************************************************************************************
        class Solution{
            public boolean carPooling(int[][] trips, int capacity) {
            //your code
                    int lastDropLoc=-1;
                    for(int trip[]: trips){
                        lastDropLoc=Math.max(lastDropLoc,trip[2]);
                    }
            
                    int prefix[]=new int[lastDropLoc];
            
                    for(int trip[]: trips){
                        int startPoint=trip[1];
                        int endPoint=trip[2];
                        prefix[startPoint]+=trip[0];
                        prefix[endPoint]-=trip[0];
                    }
            
                    for(int i=1;i<lastDropLoc;i++){
                        prefix[i]+=prefix[i-1];
                        if(prefix[i]>capacity){return false;}
                    }
                    return true;
                }}
        //***************************************************XOR Query************************************************************************************************************
        class Solution{
            public static int[] xorQueries(int[] arr, int[][] ranges) {
            // your code goes here
          int n=arr.length;
          int l=ranges.length;
 
          int ans[]=new int[l];
          int preXOR[]=new int[n+1];
 
          for(int i=0;i<n+1;i++){
              preXOR[i+1]=preXOR[i]^arr[i];
          }
          int idx=0;
          for(int query[]: ranges){
              int i=query[0];
              int j=query[1];
 
              ans[idx++]=preXOR[j+1]^preXOR[i]
          }
          return ans;
         }   }
        //************************************************2D-Prefix Sum***********************************************************************************************************
        class Solution{ 
            public List<Integer> solve(int matrix[][], Pair query[]) {
            // Your code here
            List<Integer> ans=new ArrayList<>();
            int n=matrix.length;
            int m=matrix[0].length;
            //Prefix-Row
            for(int i=0;i<matrix.length;i++){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j]+=matrix[i][j-1];
                }
            }
            //Prefix-Col
            for(int i=1;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    matrix[i][j]+=matrix[i-1][j];
                }
            }
            for(Pair qu: query){
                int r1=qu.row1,c1=qu.col1,r2=qu.row2,c2=qu.col2;
                int origsum=matrix[r2][c2];
                int extrasum=(c1!=0?matrix[r2][c1-1]:0+r1!=0?matrix[r1-1][c2]:0-r1!=0&&c1!=0?matrix[r1-1][c1-1]:0);
                int sum=origsum-extrasum;
                ans.add(sum);
                sum=0;
            }
            return ans;
            
        }

    }
        }
    
        class PrefixSum,Kadane,Kmp-2(CLASS-4){
        //***********************************************2D Range Query**********************************************************************************************
        //***********************************************Array Sum Divisible by P**********************************************************************************************
        //***********************************************LeetCode 2017-Grid**********************************************************************************************
        }
    
        class PrefixSum,Kadane,Kmp-3(CLASS-5){
        //**************************************************Kadane's Algorithm*****************************************************************************************
        class Solution{
            public int kadane(int arr[]){
            int presum=0;
            int maxsum=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                presum+=arr[i];
                maxsum=Math.max(presum,maxsum);
                if(presum<0)presum=0;
                }
            return maxsum;
            }   
        } 
        //*************************************************Maximum Sum Circular Array***************************************************************************** */
        class Solution{
            public int MaxSum(int[] arr, int n) {
                // Write your code here
                int maxSum=Integer.MIN_VALUE,maxSumSoFar=0,minSum=Integer.MAX_VALUE,minSumSoFar=0,total=0;
                for(int i=0;i<n;i++){
                    total+=arr[i];
                    maxSumSoFar+=arr[i];
                    if(maxSumSoFar>maxSum){maxSum=maxSumSoFar;}
                    if(maxSumSoFar<0){maxSumSoFar=0;}
                    minSumSoFar+=arr[i];
                    if(minSumSoFar<minSum){minSum=minSumSoFar;}
                    if(minSumSoFar>0){minSumSoFar=0;}
                }
                int result=Math.max(maxSum,total-minSum);
                return result;
        }}
        //***********************************************KMP Algorithm********************************************************************************************* */
        //LeetCode 2017
         }
        class Sliding Window(CLASS-1){
            //*****************************************Subarray product less than K*********************************************************************************
            class Solution{
                public int numSubarrayProductLessThanK(int[] nums, int k) {
                int start=0,end=0,ans=0,prod=1,n=nums.length;
                while(end<n){
                    //*********Expansion*************** */
                    prod=prod*nums[end];
                    end++;
                    //********Contraction************** */
                    while(start<end&&prod>=k){
                        prod=prod/nums[start];
                        start++;
                    }
                    //*******Calculation*************** */
                    if(prod<k)ans+=end-start;
                }
                return ans;
            }}
            //***************************************Maximum Consecutive Ones with Flips******************************************************************** */
            class Solution{
                static int maxOne(int arr[], int n,int k)
            {
                int start=0,end=0,flips=0,ans=Integer.MIN_VALUE;
                while(end<n){
                    if(arr[end]==0)flips++;
                    end++;
                    while(start<end&&flips>k){
                        if(arr[start]==0)flips--;
                        start++;
                    }
                    ans=Math.max(ans,end-start);
                    }
                    return ans;
            }}
            //*************************************Longest Substring with No Repeating Character************************************************************ */
            class Solution{
                public int longestSubstring(String s) {
                //Write your code here
                int start=0,end=0,ans=Integer.MIN_VALUE,n=s.length(),repeat=0;;
                int freq[]=new int[256];
                while(end<n){
                    freq[s.charAt(end)]++;
                    if(freq[s.charAt(end)]>1)repeat++;
                    end++;
                    
                    while(start<end&&repeat>0){
                        if(freq[s.charAt(start)]>1)repeat--;
                        freq[s.charAt(start)]--;
                        start++;
                    }
                    if(repeat==0)ans=Math.max(ans,end-start);
                }
                return ans;
            }}
            //*************************************Longest Substring with At Least K Repeating Characters*************************************************** */
            class Solution{
                private int XUniqueK(String s,int x,int k){
                int ans=0,start=0,end=0,unique=0,char_atleastk=0,n=s.length();
                int freq[]=new int[256];
                while(end<n){
                    freq[s.charAt(end)]++;
                    if(freq[s.charAt(end)]==1)unique++;
                    if(freq[s.charAt(end)]==k)char_atleastk++;
                    end++;
                    
                    while(start<end&&unique>x){
                        freq[s.charAt(start)]--;
                        if(freq[s.charAt(start)]==0)unique--;
                        if(freq[s.charAt(start)]==k-1)char_atleastk--;
                        start++;
                    }
                    
                    if(unique==x&&char_atleastk==x)
                    {ans=Math.max(ans,end-start);}
                }
                return ans;
            }
            public int longestSubstring(String s, int k) {
                // write code here
                    int freq[]=new int[256];
                    int n=s.length();
                    int unique=0;
                    int ans=0;
                    for(int i=0;i<n;i++){
                        freq[s.charAt(i)]++;
                        if(freq[s.charAt(i)]==1)unique++;
                    }
                    for(int i=1;i<=unique;i++){
                        ans=Math.max(ans,XUniqueK(s,i,k));
                    }
                    return ans;
                }
            }
            //*************************************Minimum Window Substring **********************************************************************************/
            //*************************************Sliding window maximum*********************************************************************************** */
        }
        class Sliding Window(CLASS-2){
            
        }
        class Sliding Window(CLASS-3){

        }
        class Graphs(CLASS-1){
            //**************************************Graph Construction************************************************* */
            class Solution{
                class Edge{
                    int v;
                    int w;
                    Edge(int v,int w){
                        this.v=v;
                        this.w=w;
                    }
                }
                public class Main {
                    public static void display(ArrayList<Edge>[] graph){
                        int vertices=graph.length;
                        for(int i= 0;i<vertices;i++) {
                            System.out.print(i+"->");
                            for(Edge e: graph[i]){
                                System.out.print("(" +e.v+", "+ e.w +")");
                            }
                            System.out.println();
                        }
                    }
                    public static void main(String[] args){
                        Scanner sc=new Scanner(System.in);
                        int vertices=sc.nextInt();
                        int edges=sc.nextInt();
                        ArrayList<Edge>[] graph=new ArrayList[vertices];
                        for(int i=0;i<vertices;i++){
                            graph[i]=new ArrayList<>();
                        }
                        for (int i=0;i<edges;i++){
                            int u=sc.nextInt();
                            int v=sc.nextInt();
                            int w=sc.nextInt();
                            graph[u].add(new Edge(v,w));
                            graph[v].add(new Edge(u,w));
                        }
                        ArrayList<Integer>[] graphNW=new ArrayList[vertices];
                        for (int i=0;i<vertices;i++) {
                            graphNW[i]=new ArrayList<>();
                        }
                        for (int i=0;i<edges;i++){
                            int u=sc.nextInt();
                            int v=sc.nextInt();
                            graphNW[u].add(v);
                            graphNW[v].add(u);
                        }
                        int[][] graphMatrix=new int[vertices][vertices];
                        for (int i=0;i<edges;i++) {
                            int u=sc.nextInt();
                            int v=sc.nextInt();
                            int w=sc.nextInt();
                            graphMatrix[u][v]=w;
                            graphMatrix[v][u]=w;
                        }
                        display(graph);
                        sc.close();
                    }
                }
            }
            //**************************************************DFS*********************************************** */
            class Solution{
                public static void dfs(int src,ArrayList<Integer>[] adj,boolean[] visited){
                    System.out.print(src+" ");
                    visited[src]=true;
                    Collections.sort(adj[src]);
                    for(int nbr: adj[src]){
                        if(visited[nbr]==false)
                            dfs(nbr,adj,visited);
                    }
                }
                public static void DFSTraversal(List<List<Integer>> edges,int vertices){
                    // 1. Build our adjacency list
                    ArrayList<Integer>[] graphNW=new ArrayList[vertices];
                    for(int i=0;i<vertices;i++){
                        graphNW[i]=new ArrayList<>();
                    }
                    for(List<Integer> edge: edges){
                        int u=edge.get(0);
                        int v=edge.get(1);
                        graphNW[u].add(v);
                        graphNW[v].add(u);
                    }
                    boolean[] visited=new boolean[vertices];
                    for(int i=0;i<vertices;i++){
                        if(visited[i]==false)
                            dfs(i,graphNW,visited);
                    }
                }
                }                
        }
        class Graphs(CLASS-2,3){
            //*************************************************Path from source to destination*********************** */
            class Solution{
                boolean dfs(int src,int dest,ArrayList<Integer>[] graph,boolean[] visited){
                    if(src==dest)return true;
                    visited[src]=true;
                    boolean res=false;
                    for(int nbr: graph[src]){
                        if(visited[nbr]==false) {
                            res=res||dfs(nbr,dest,graph,visited);
                        }
                    }
                    return res;
                }
                boolean check(int vertices,int edges,ArrayList<ArrayList<Integer>> edgeList,int src,int dest){
                    ArrayList<Integer>[] graph=new ArrayList[vertices];
                    for(int i=0;i<vertices;i++){
                        graph[i]=new ArrayList<>();
                    }
                    for(ArrayList<Integer> edge: edgeList){
                        int u=edge.get(0);
                        int v=edge.get(1);
                        graph[u-1].add(v-1);
                        graph[v-1].add(u-1);
                    }
                    boolean[] visited=new boolean[vertices];
                    return dfs(src-1,dest-1,graph,visited);
                }
            }
            //*************************************************Count Components DFS*************************************************** */
            class Solution{
                private void dfs(int src,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
                    visited[src]=true;
                    int vertices=adj.size();
                    for(int nbr= 0;nbr<vertices;nbr++) {
                        if(adj.get(src).get(nbr)==1&&visited[nbr]==false){
                            dfs(nbr,adj,visited);
                        }
                    }
                }
                int components(ArrayList<ArrayList<Integer>> adj,int vertices){
                    boolean[] visited=new boolean[vertices];
                    int cnt=0;
                    for(int i=0;i<vertices;i++){
                        if(visited[i]==false){
                            dfs(i,adj,visited);
                            cnt++;
                        }
                    }
                    return cnt;
                }
            }
            //*************************************************Count Components BFS******************************** */
            class Solution{
                private void BFS(int src, ArrayList<ArrayList<Integer>> adj,boolean[] visited){
                    Queue<Integer> q=new LinkedList<>();
                    int vertices=adj.size();
                    q.add(src);
                    visited[src]=true;
                    while(q.size()>0)
                    {
                        int size=q.size();
                        for(int i= 0;i<size;i++)
                        {
                            int temp=q.remove();
                            for(int nbr=0;nbr<vertices;nbr++)
                            {
                                if(adj.get(temp).get(nbr)==1&&visited[nbr]==false){
                                    q.add(nbr);
                                    visited[nbr]=true;
                                }
                            }
                        }
                    }
                }
                int components(ArrayList<ArrayList<Integer>> adj,int vertices){
                    boolean[] visited=new boolean[vertices];
                    int cnt=0;
                    for(int i=0;i<vertices;i++) {
                        if(visited[i]==false) {
                            BFS(i,adj,visited);
                            cnt++;
                        }
                    }
                    return cnt;
                }
            }
            //*************************************************Print All Paths String Method*************************/
            class Solution{
                private static void dfs(int src,int dest,ArrayList<Edge>[]graph ,boolean[] visited,String path){
                    if(src==dest){
                        System.out.println(path);
                        return;
                    }
                    visited[src]=true;
                    for(Edge e: graph[src]){
                        if(visited[e.nbr]==false) {
                            dfs(e.nbr,dest,graph,visited,path+e.nbr);
                        }
                    }
                    visited[src]=false;
                }
                public static void printAllPath(ArrayList<Edge>[]graph,int src,int dest,int vertices){
                   boolean[] visited=new boolean[vertices];
                   String path=""+src;
                   dfs(src,dest,graph,visited,path);
                }
            }
            //*************************************************Print All Paths List Method*************************/
            class Solution{
                private void dfs(int src,int dest,int[][] graph,boolean[] visited,List<Integer> path,List<List<Integer>>ans){
                    if(src==dest){
                        List<Integer> temp=new ArrayList<>(path);
                        ans.add(temp);
                        return;
                    }
                    visited[src]=true;
                    for(int nbr: graph[src]) {
                        if(visited[nbr]==false){
                            path.add(nbr);
                            dfs(nbr,dest,graph,visited,path,ans);
                            path.remove(path.size()-1);
                        }
                    }
                    visited[src]=false;
                }
                public List<List<Integer>> allPathsSourceTarget(int[][] graph){
                    List<Integer>path=new ArrayList<>();
                    List<List<Integer>>ans=new ArrayList<>();
                    int vertices=graph.length;
                    boolean[] visited=new boolean[vertices];
                    path.add(0);
                    dfs(0,vertices-1,graph,visited,path,ans);
                    return ans;
                }
            }   
            //*************************************************BFS*************************************************/
            class Solution{
                void BFS(int src){
                    Queue<Integer> q=new LinkedList<>();
                    boolean[] visited=new boolean[vertices];
                    q.add(src);
                    visited[src]=true;
                    while(q.size()>0)
                    {
                        int size=q.size();
                        for(int i=0;i<size;i++)
                        {
                            int temp=q.remove();
                            System.out.print(temp+" ");
                            for(int nbr: adjList[temp])
                            {
                                if(visited[nbr]==false){
                                    q.add(nbr);
                                    visited[nbr]=true;
                                }
                            }
                        }
                    }
                }
            }
            //************************************************Shortest Path Using BFS********************************* */
            class Solution{
                int[] BFS(int src,ArrayList<Integer>[] graph){
                    int vertices=graph.length;
                    Queue<Integer> q=new LinkedList<>();
                    boolean[] visited=new boolean[vertices];
                    int[] distance=new int[vertices];
                    Arrays.fill(distance,-1);
                    q.add(src);
                    visited[src]=true;
                    int level=0;
                    while(q.size()>0){
                        int size=q.size();
                        for(int i=0;i<size;i++){
                            int temp=q.remove();
                            distance[temp]=level;
                            for(int nbr: graph[temp]){
                                if(visited[nbr]==false) {
                                    q.add(nbr);
                                    visited[nbr]=true;
                                }
                            }
                        }
                        level++;
                    }
                    return distance;
                }
                public int[] shortestPath(int[][] edgeList,int vertices,int edges,int src){
                    ArrayList<Integer>[] graph=new ArrayList[vertices];
                    for(int i=0;i<vertices;i++) graph[i]=new ArrayList<>();
                    for(int i=0;i<edges;i++){
                        int u=edgeList[i][0];
                        int v=edgeList[i][1];
                        graph[u].add(v);
                        graph[v].add(u);
                    }
                    return BFS(src, graph);
                }
            }
            //************************************************Cycle Detection Undirected DFS**************************** */
            class Solution{
                private static boolean checkCycle(int parent,int src,ArrayList<ArrayList<Integer>> graph,boolean[] visited){
                    visited[src]=true;
                    for(int nbr: graph.get(src)){
                        if(visited[nbr]==false){
                            boolean check=checkCycle(src,nbr,graph,visited);
                            if(check==true)return true;
                        }
                        else if(visited[nbr]==true&&nbr!=parent)return true;
                    }
                    return false;
                }
                public static boolean isCycle(int vertices,ArrayList<ArrayList<Integer>> graph){
                    boolean[] visited=new boolean[vertices];
                    for(int i=0;i<vertices;i++){
                        if(visited[i]==false){
                            boolean check=checkCycle(-1,i,graph,visited);
                            if(check==true)return true;
                        }
                    }
                    return false;
                }
            }
            //************************************************Cycle Detection Undirected BFS*************************** */
            class Solution{
                private static boolean checkCycle(int src,ArrayList<ArrayList<Integer>> graph,boolean[] visited,int[] parent){
                    Queue<Integer> q=new LinkedList<>();
                    q.add(src);
                    visited[src]=true;
                    parent[src]=-1;
                    while(q.size()>0){
                        int size=q.size();
                        for(int i=0;i<size;i++){
                            int temp=q.remove();
                            for(int nbr: graph.get(temp)){
                                if(visited[nbr]==false){
                                    q.add(nbr);
                                    visited[nbr]=true;
                                    parent[nbr]=temp;
                                }
                                else if(visited[nbr]==true&&nbr!=parent[temp])return true;
                            }
                        }
                    }
                    return false;
                }
                public static boolean isCycle(int vertices,ArrayList<ArrayList<Integer>> graph){
                    boolean[] visited=new boolean[vertices];
                    int[] parent=new int[vertices];
                    for(int i=0;i<vertices;i++){
                        if(visited[i]==false) {
                            boolean check=checkCycle(i,graph,visited,parent);
                            if(check==true)return true;
                        }
                    }
                    return false;
                }
            }
            //************************************************Cycle Detection Directed DFS*************************** */
            class Solution{
                private boolean dfs(int src,ArrayList<Integer>[] graph,boolean[] visited,boolean[] path){
                    visited[src]=true;
                    path[src]=true;
                    for(int nbr: graph[src]){
                        if(visited[nbr]==false){
                            boolean check=dfs(nbr,graph,visited,path);
                            if(check==true)return true;
                        }
                        else if(visited[nbr]&&path[nbr])return true;
                    }
                    path[src]=false;
                    return false;
                }
                public boolean isCyclic(int vertices,ArrayList<Integer>[] graph)
                {
                    boolean[] visited=new boolean[vertices];
                    boolean[] path=new boolean[vertices];
                    for(int i=0;i<vertices;i++){
                        if(visited[i]==false){
                            boolean check=dfs(i,graph,visited,path);
                            if(check==true)return true;
                        }
                    }
                    return false;
                }
            }
            //************************************************Bipartite Graph BFS*************************** */
            class Solution{
                private boolean bfs(int src,ArrayList<Integer>[] graph,boolean[] visited,int[] color)
                {
                    Queue<Integer> q=new LinkedList<>();
                    q.add(src);
                    visited[src]=true;
                    color[src]=0; // red
                    while(q.size()>0)
                    {
                        int size=q.size();
                        for(int i=0;i<size;i++)
                        {
                            int temp=q.remove();
                            for(int nbr: graph[temp])
                            {
                                if(visited[nbr]==false)
                                {
                                    q.add(nbr);
                                    visited[nbr]=true;
                                    color[nbr]=1-color[temp];
                                }
                                else if(visited[nbr]&&color[temp]==color[nbr])
                                    return false;
                            }
                        }
                    }
                    return true;
                }
                
            }
            //************************************************Bipartite Graph DFS*****************************/
            class Solution{
                private boolean dfs(int src,ArrayList<Integer>[] graph,boolean[] visited,int[] color,int c)
            {
                visited[src]=true;
                color[src]=c;
                for(int nbr: graph[src]) {
                    if(visited[nbr]==false) {
                        boolean check=dfs(nbr,graph,visited,color,1-c);
                        if(check==false)return false;
                    }
                    else if(visited[nbr]&&color[src]==color[nbr])
                        return false;
                }
                return true;
            }
            
            public int possibleBipartition(int n, int[][] dislikes){
                ArrayList<Integer>[] graph=new ArrayList[n];
                for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
                for(int[] edge: dislikes) {
                    int u=edge[0];
                    int v=edge[1];
                    // vertices from 1 to n, so make it 0 to n - 1
                    graph[u-1].add(v-1);
                    graph[v-1].add(u-1);
                }
                boolean[] visited=new boolean[n];
                int[] color=new int[n];
                for(int i=0;i<n;i++) {
                    if(visited[i]==false) {
                        boolean check=dfs(i,graph,visited,color,0);
                        // boolean check = bfs(i, graph, visited, color)
                        if(check==false)return 0;
                    }
                }
                return 1;
            }

            }
            //************************************************Flood Fill*********************************** */
            class Solution{
                private static int[] dr=new int[]{-1,0,1,0};
            private static int[] dc=new int[]{0,1,0,-1};
            private static void bfs(int r,int c,int[][] grid,boolean[][] visited,int newColor)
            {
                Queue<int[]> q=new LinkedList<>();
                visited[r][c]=true;
                q.add(new int[]{r,c});
                int rows=grid.length;
                int cols=grid[0].length;
                while(q.size()>0)
                {
                    int size=q.size();
                    for(int i=0;i<size;i++)
                    {
                        int[] temp=q.remove();
                        int sr=temp[0];
                        int sc=temp[1];
                        int myColor=grid[sr][sc];
                        grid[sr][sc]=newColor;
                        for(int j=0;j<4;j++)
                        {
                            int nr=sr+dr[j];
                            int nc=sc+dc[j];
                            if(nr<0||nr>= rows||nc< 0||nc>= cols)continue;
                            if(visited[nr][nc]==false&&grid[nr][nc]==myColor) {
                                q.add(new int[]{nr,nc});
                                visited[nr][nc]=true;
                            }
                        }
                    }
                }
            }
            private static void dfs(int r,int c,int[][] grid,boolean[][] visited,int newColor)
            {
                visited[r][c]=true;
                int myColor=grid[r][c];
                grid[r][c]=newColor;
                int rows=grid.length;
                int cols=grid[0].length;
                for(int i=0;i<4;i++) {
                    int nr=r+dr[i];
                    int nc=c+dc[i];
                    if(nr<0||nr>=rows||nc<0||nc>=cols) continue;
                    if(visited[nr][nc]==false&&grid[nr][nc]==myColor) {
                        dfs(nr,nc,grid,visited,newColor);
                    }
                }
            }

            public static void FloodFill(int[][] grid, int r, int c, int newColor) {
                int rows=grid.length;
                int cols=grid[0].length;
                if(r<0||r>=rows||c<0||c>= cols||grid[r][c]==newColor)
                    return;
                boolean[][] visited=new boolean[rows][cols];
                bfs(r,c,grid,visited,newColor);
                // dfs(r, c, grid, visited, newColor);
                return;
            }

}
            //************************************************Grid Based BFS and DFS********************************************** */
            class Solution{
                private static int[] dr=new int[]{-1,-1,0,1,1,1,0,-1};
                private static int[] dc=new int[]{ 0,1,1,1,0,-1,-1,-1};
                private static void bfs(int r,int c,int[][] grid,boolean[][] visited)
                {
                    Queue<int[]> q=new LinkedList<>();
                    visited[r][c]=true;
                    q.add(new int[]{r,c});
                    int rows=grid.length;
                    int cols=grid[0].length;
                    while(q.size()>0)
                    {
                        int size=q.size();
                        for(int i=0;i<size;i++)
                        {
                            int[] temp=q.remove();
                            int sr=temp[0];
                            int sc=temp[1];
                            for(int j=0;j<8;j++)
                            {
                                int nr=sr+dr[j];
                                int nc=sc+dc[j];
                                if(nr<0 || nr >= rows || nc < 0 || nc >= cols) continue;
                                if(visited[nr][nc] == false && grid[nr][nc] == 1) {
                                    q.add(new int[]{nr, nc});
                                    visited[nr][nc] = true;
                                }
                            }
                        }
                    }
                }
                private static void dfs(int r, int c, int[][] grid, boolean[][] visited){
                    int rows=grid.length;
                    int cols=grid[0].length;
                    visited[r][c] = true;
                    for(int i=0;i<8;i++){
                        int nr=r+dr[i];
                        int nc=c+dc[i];
                        if(nr<||nr>=rows||nc<0||nc>=cols)continue;
                        if(visited[nr][nc]==false&&grid[nr][nc]==1){
                            dfs(nr,nc,grid,visited);
                        }
                    }
                }
                static int numberOfIslands(int[][] grid,int n,int m){
                    boolean[][] visited=new boolean[n][m];
                    int cnt=0;
                    for(int i =0;i<n;i++) {
                        for(int j=0;j<m;j++) {
                            if(grid[i][j]==1&&visited[i][j]==false) {
                                bfs(i,j,grid,visited);
                                // dfs(i,j,grid,visited);
                                cnt++;
                            }
                        }
                    }
                    return cnt;
                }

}
            //************************************************Max Area of Islands**************************************************************** */
            class Solution{
            private int[] dr=new int[]{-1,0,1,0};
            private int[] dc=new int[]{0,1,0,-1};


        private int dfs(int r,int c,int[][] grid,boolean[][] visited){
            int rows=grid.length;
            int cols=grid[0].length;
            visited[r][c]=true;
            int cnt=1;
            for(int i=0;i<4;i++) {
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr<0 ||nr>= rows||nc<0||nc>= cols) continue;
                if(visited[nr][nc]==false&&grid[nr][nc]==1) {
                    cnt+=dfs(nr, nc, grid, visited);
                }
            }
            return cnt;
        }


        public int maxAreaOfIsland(int[][] grid){
            int n=grid.length;
            int m=grid[0].length;
            boolean[][] visited=new boolean[n][m];
            int maxArea=0;


            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==1&&visited[i][j]==false) {
                        int area =dfs(i,j,grid,visited);
                        maxArea=Math.max(maxArea, area);
                    }
                }
            }
            return maxArea;
        }

        }
            //***********************************************Update Matrix**************************************************************************** */
            class Solution{
                public int[][] updateMatrix(int[][] grid){
                int n=grid.length;
                int m=grid[0].length;
                boolean[][] visited=new boolean[n][m];
                Queue<int[]> q=new LinkedList<>();
                for(int i=0;i<n;i++) {
                    for(int j=0;j<m;j++) {
                        if(grid[i][j]==0) {
                            q.add(new int[]{i,j});
                            visited[i][j]=true;
                        }
                    }
                }
                int level = 0;
                while(q.size() > 0) {
                    int size = q.size();
                    for(int i=0;i< size;i++) {
                        int[] temp=q.remove();
                        int sr=temp[0];
                        int sc=temp[1];
                        grid[sr][sc]=level;
                        for(int j=0;j<4;j++) {
                            int nr=sr+dr[j];
                            int nc=sc+dc[j];
                            if(nr<0||nr>=n||nc<0||nc>=m) continue;
                            if(visited[nr][nc]==false) {
                                q.add(new int[]{nr,nc});
                                visited[nr][nc]=true;
                            }
                        }
                    }
                    level++;
                }
                return grid;
            }
    }    
        }
        
        class Graphs(CLASS-4){
            //**********************************Rotten Oranges*********************************************************/
            class Solution{
                public static int orangesRotting(int[][] grid){
                    int rows=grid.length;
                    int cols=grid[0].length;
                    Queue<int[]> q=new LinkedList<>();
                    int fresh=0;
                    for(int i=0;i<rows;i++){
                        for(int j=0;j<cols;j++){
                            if(grid[i][j]==2) q.add(new int[]{i,j});
                            else if(grid[i][j]==1)fresh++;
                        }
                    }
                    int level=0;
                    while(q.size()>0) {
                        int size=q.size();
                        for(int i=0;i<size;i++) {
                            int[] temp=q.remove();
                            int r=temp[0];
                            int c=temp[1];
                            for(int j=0;j<4;j++) {
                                int nr=r+dr[j];
                                int nc=c+dc[j];
                                if(nr<0||nr>=rows||nc<0| nc>=cols)continue;
                                if(grid[nr][nc]==1) {
                                    grid[nr][nc]=2;
                                    fresh--;
                                    q.add(new int[]{nr,nc});
                                }
                            }
                        }
                        level++;
                    }
                    if(fresh == 0) return level - 1;
                    return -1;
                }
            }
            //**********************************Jump Game IV********************************************************** */
            class Solution{
                public int minJumps(int[] arr){
                    HashMap<Integer,List<Integer>> hm=new HashMap<>();
                    int n=arr.length;
                    for(int i=0;i<n;i++){
                        if(hm.containsKey(arr[i])) {
                            hm.get(arr[i]).add(i);
                        }
                        else{
                            List<Integer> newlist=new ArrayList<>();
                            newlist.add(i);
                            hm.put(arr[i],newlist);
                        }
                    }
                    boolean[] visited=new boolean[n];
                    Queue<Integer> q=new LinkedList<>();
                    q.add(0);
                    visited[0]=true;
                    int level=0;
                    while(q.size()>0) {
                        int size=q.size();
                        for(int i=0;i<size;i++){
                            int idx=q.remove();
                            if(idx==n - 1) return level;
                            if(idx+1< n&&visited[idx+1]==false){
                                q.add(idx+1);
                                visited[idx+1]=true;
                            }
                            if(idx-1 >= 0 &&visited[idx-1]==false){
                                q.add(idx-1);
                                visited[idx-1]=true;
                            }
                            for(int new_idx: hm.get(arr[idx])){
                                if(visited[new_idx]==false) {
                                    q.add(new_idx);
                                    visited[new_idx]=true;
                                }
                            }
                            hm.get(arr[idx]).clear();
                        }
                        level++;
                    }
                    return -1;
                }
                
            }
            //**********************************Priority Queue Implementation****************************************** */
            class Solution{
                public static void kSmallLarge(int arr[],int n,int k){
                    PriorityQueue<Integer> minpq=new PriorityQueue<>();
                    PriorityQueue<Integer> maxpq=new PriorityQueue<>(Collections.reverseOrder());
                    for(int i=0;i<n;i++) {
                        minpq.add(arr[i]);
                        maxpq.add(arr[i]);
                        if(minpq.size()>k) minpq.remove();
                        if(maxpq.size()>k) maxpq.remove();
                    }
                    int kthSmall=maxpq.peek();
                    int kthLarge=minpq.peek();
                    System.out.println(kthSmall);
                    System.out.println(kthLarge);
                }
                
            }
            //**********************************Minimum Cost to Connect Ropes***************************************** */
            class Solution{
                long minCost(long arr[],int n)
                {
                    PriorityQueue<Long> minpq=new PriorityQueue<>();
                    for(int i=0;i<n;i++)minpq.add(arr[i]);
                    long cost=0;
                    while(minpq.size()>1) {
                        long r1=minpq.remove();
                        long r2=minpq.remove();
                        cost+=r1+r2;
                        minpq.add(r1+r2);    
                    }
                    return cost;
                }
                  
            }
            //**********************************Jump game II********************************************************** */
            class Solution{
                public int jump(int[] arr)
                {
                    int n=arr.length;
                    boolean[] visited=new boolean[n];
                    Queue<Integer> q=new LinkedList<>();
                    q.add(0);
                    visited[0]=true;
                    int level=0;
                    while(q.size()>0)
                    {
                        int size=q.size();
                        for(int i=0;i<size;i++)
                        {
                            int idx=q.remove();
                            if(idx==n-1)return level;
                            for(int jump=1;jump<=arr[idx];jump++)
                            {
                                if(idx+jump>= n) break;
                                if(visited[idx+jump]==false) {
                                    q.add(idx+jump);
                                    visited[idx+jump]=true;
                                }
                            }
                        }
                        level++;
                    }
                    return -1;
                }
                  
            }
        }
        class Graphs(CLASS-5){
            //**********************************Shortest Path -Djikstra*********************************************** */
            class Solution{
                static int[] dijkstra(int vertices,ArrayList<ArrayList<ArrayList<Integer>>> graph,int src){
                    PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
                    int[] distance=new int[vertices];
                    Arrays.fill(distance,Integer.MAX_VALUE);
                    distance[src]=0;
                    pq.add(new int[]{distance[src],src});
                    while(pq.size()>0) {
                        int[] temp=pq.remove();
                        int dist_node=temp[0];
                        int node=temp[1];
                        if(distance[node]<dist_node)continue;
                        for(ArrayList<Integer> edge: graph.get(node)) {
                            int nbr=edge.get(0);
                            int wt=edge.get(1);
                            if(distance[nbr]>distance[node]+wt){
                                distance[nbr]=distance[node]+wt;
                                pq.add(new int[]{distance[nbr],nbr});
                            }
                        }
                    }
                    return distance;
                }
            }
            //**********************************Course Schedule********************************************************** */
            class Solution{
                private void complete(int src,ArrayList<Integer>[] graph,boolean[] visited,ArrayList<Integer> order){
                    visited[src]=true;
                    for(int nbr: graph[src]){
                        if(visited[nbr]==false)
                            complete(nbr,graph,visited,order);
                    }
                    order.add(src);
                }
                public int[] findOrder(int numCourses,int[][] prerequisites){
                    ArrayList<Integer>[] graph=new ArrayList[numCourses];
                    for(int i=0;i<numCourses;i++) graph[i]=new ArrayList<>();
                   
                    for(int[] edge: prerequisites){
                        int u=edge[0];
                        int v=edge[1];
                        graph[u].add(v); // v is prereq of u (u -> v)
                    }
                    boolean cycle=isCyclic(numCourses,graph);
                    if(cycle==true)return new int[]{};
                    boolean[] visited=new boolean[numCourses];
                    ArrayList<Integer> order=new ArrayList<>();
                    for(int i=0;i<numCourses;i++){
                        if(visited[i]==false)
                            complete(i,graph,visited,order);
                    }
                    int ans[] = new int[numCourses];
                    for(int i=0;i<numCourses;i++)ans[i]=order.get(i);
                    return ans;
                }}
            //*********************************Kahn's Algorithm*************************************************** ' */    
            class Solution{
                    public int[] findOrder(int numCourses,int[][] prerequisites){
   
                        ArrayList<Integer>[] graph=new ArrayList[numCourses];
                        int[] indegree=new int[numCourses];
                        for(int i=0;i<numCourses;i++){
                            graph[i]=new ArrayList<>();
                        }
                        for(int[] edge: prerequisites) {
                            int u=edge[0];
                            int v=edge[1];
                            graph[v].add(u); // u is a dependent of v (v -> u)
                            indegree[u]++;
                        }
                        Queue<Integer> q=new LinkedList<>();
                        for(int i=0;i<numCourses;i++) {
                            if(indegree[i]==0)q.add(i);
                        }
                        int[] topo=new int[numCourses];
                        int idx=0;
                        while(q.size()>0) {
                            int size=q.size();
                            for(int i=0;i<size;i++) {
                                int src=q.remove();
                                topo[idx]=src;
                                idx++;
                                for(int nbr: graph[src]) {
                                    indegree[nbr]--;
                                    if(indegree[nbr]==0)q.add(nbr);
                                }
                            }
                        }
                        if(idx==numCourses)return topo;
                        return new int[]{}; // this means it has a cycle
                    }
                }  
            //*********************************Islands ************************************************************** */
            class Solution{
                    String island;
                    int[] dr={-1, 0, 1, 0};
                    int[] dc={0, 1, 0, -1};
                    String[] val={"T","R","D","L"};
                    private void dfs(int r,int c,boolean[][] visited,int[][] grid){
                        int rows=grid.length;
                        int cols=grid[0].length;
                        visited[r][c] = true;
                        for(int i=0;i<4;i++) {
                            int nr=r+dr[i];
                            int nc=c+dc[i];
                            if(nr<0||nr>=rows||nc<0||nc>=cols) continue;
                            if(visited[nr][nc]==false&&grid[nr][nc]==1){
                                island+= val[i];
                                dfs(nr,nc,visited,grid);
                            }
                        }
                        island+="X";      
                    }
                    int countDistinctIslands(int[][] grid) {
                        int rows=grid.length;
                        int cols=grid[0].length;
                        boolean[][] visited=new boolean[rows][cols];
                        HashMap<String, Integer> hm=new HashMap<>();
                        for(int i=0;i<rows;i++) {
                            for(int j=0;j<cols;j++) {
                                if(visited[i][j]==false&&grid[i][j]==1){
                                    island="";
                                    dfs(i,j,visited,grid);
                                    hm.put(island,hm.getOrDefault(island,0)+1);
                                }
                            }
                        }
                        return hm.size();
                    }

                }
            }
    }
    

    //***************************AccioJob Module 4******************************************** */
    //Revision

    //BIT MANIPULATION
    //Set Kth bit,Clear Kth bit,Toggle Kth bit
    //Game of XOR
    //Flip bits-Using Mask|Iterating over all bits
    //Reverse bits
    //Generate Subsets
    //Single Number I
    //Single Number II
    //Single Number III
    //Check whether Kth bit is set or not
    //Count Set Bits
    //Check power of 2

    //GRAPHS
    //Construct Graph
    //DFS Traversal
    //Path between 2 vertices
    //Count components
    //BFS Traversal
    //Print Paths'-String/List
    //BFS Implementation
    //Shortest path in undirected graph with unit distance
    //Detect a cycle in Undirected graph DFS
    //Detect a cycle in Undirected graph BFS'
    //Detect cycle in directed graph DFS
    //Bipartite DFS
    //Bipartite BFS
    //Flood Fill
    //Number of Islands
    //Max Area of Islands
    //Nearest 0 from every cell
    //Rotten Oranges    
    //Jump Game I,II,III,IV
    //Kth smallest/largest
    //Minimum cost to connect ropes
    //Implementing Djikstra
    //Topo Sort DFS
    //Topo Sort Kahn
    //Number of Distinct islands


    //SIDING WINDOW
    //SubArray Product Less than K
    //Maximum Consecutive Ones
    //Longest Substring with Unique Characters-Frequency Array+HashMap
    //Longest Subbstring with at least K repeating characters
    //Minimum Window Substring
    //Substring with concatenation of all words
    //Sliding Window Maximum
    //





    //Range Addition Query
    class Solution{
        public int[] getModifiedArray(int length, int[][] updates) {
            int arr[]=new int[length];
            for(int i=0;i<length;i++){
                int l=updates[i][0];
                int r=updates[i][1];
                int val=updates[i][2];
                arr[l]+=val;
                if(r+1<length){arr[r]-=val;}
            }
            for(int i=1;i<length;i++){
                arr[i]+=arr[i-1];
            }
            return arr;
        }
    }
    //2D prefix sum
    class Solution{

    }
    //Max rectangle
    class Solution{
        class Solution {
            int Kadane(int arr[],int n){
                int csum=0,msum=Integer.MIN_VALUE;
                for(int i=0;i<n;i++){
                    csum+=arr[i];
                    msum=Math.max(csum,msum);
                    if(csum<0){csum=0;}
                }
                return msum;
            }
            int maximumSumRectangle(int R, int C, int M[][]) {
                // code here
                int ans=Integer.MIN_VALUE;
                for(int slab=0;slab<R;slab++){
                    int ColPrefix[]=new int[C];
                    for(int moving=slab;moving<R;moving++){
                        for(int col=0;col<C;col++){
                            ColPrefix[col]+=M[moving][col];
                        }
                        ans=Math.max(ans,Kadane(ColPrefix,C));
                    }
                }
                return ans;
            }
        };
    } 
    //Number of matrices with sum
    class Solution{
        class Solution {
            public int SubArraySumEqualsTarget(int arr[],int n,int k){
                int csum=0,cnt=0;
                Map<Integer,Integer> hm=new HashMap<>();
                hm.put(0,1);
                for(int i=0;i<n;i++){
                    csum+=arr[i];
                    if(hm.containsKey(csum-k)){cnt+=hm.get(csum-k);}
                    hm.put(csum,hm.getOrDefault(csum,0)+1);
                }
                return cnt;
            }
            public int numSubmatrixSumTarget(int[][] matrix, int target) {
                int ans=0;
                int R=matrix.length,C=matrix[0].length;
                for(int slab=0;slab<R;slab++){
                    int ColPrefix[]=new int[C];
                    for(int moving=slab;moving<R;moving++){
                        for(int col=0;col<C;col++){
                            ColPrefix[col]+=matrix[moving][col];
                        }
                        ans+=SubArraySumEqualsTarget(ColPrefix,C,target);
                    }
                }
                return ans;
            }
        }
    }
    //Replacement
    class Solution{
            public int characterReplacement(String s, int k)
            {
                // code here
                int ans=Integer.MIN_VALUE;
                for(char ch='A';ch<='Z';ch++){
                    ans=Math.max(ans,solve(s,k,ch));
                }
                return ans;
            }
            public int solve(String s,int k,char ch){
                int start=0,end=0,changes=0,ans=0,n=s.length();
                while(end<n){
                    if(s.charAt(end)!=ch){changes++;}
                    end++;
                    while(start<end&&changes>k){
                        if(s.charAt(start)!=ch){changes--;}
                        start++;
                    }
                    ans=Math.max(ans,end-start);
                }
                return ans;
            }
    }
    //Rearrangement
    class Solution{
        
    }




















