public class Accio_Module_4 {
    class BST-1{
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
        //***************************************************Size of BST*************************************
        class Solution{
        public int sizeOfTree(TreeNode root){
            if(root==null)return 0;
            return 1+sizeOfTree(root.left)+sizeOfTree(root.right);
        }}
        //***************************************************Sum of BST*************************************
        class Solution{
            public int sumOfTree(TreeNode root){
            if(root==null)return 0;
            return root.data+sumOfTree(root.left)+sumOfTree(root.right);
        }}
        //***************************************************Minimum of BST*************************************
        class Solution{
            public int minOfBST(TreeNode root){
            TreeNode temp=root;
            while(temp.left!=null){temp=temp.left;}
            return temp.data;
        }}
        //***************************************************Maximum of BST*************************************
        class Solution{
            public int maxOfBST(TreeNode root){
            TreeNode temp=root;
            while(temp.right!=null){temp=temp.right;}
            return temp.data;
        }}
        //***************************************************Search a Value*************************************
        class Solution{
            public TreeNode searchVal(TreeNode root,int target){
            if(root==null)return false;
            
            if(root.data>target)searchVal(root.left,target);
            else if(root.data<target)searchVal(root.right,target);
            else{return true};
        }}
        //*************************************************Insertions Delete*******************************************
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
        //***************************************************Delete a Node************************************* 
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
        //***************************************************Validate BST*************************************
        class Solution{
        public boolean isValidBSTUtil(Node root,int min,int max){
            if(root==null){
                return true;
            }
            if(root.data>max||root.data<min){return false;}
            return isValidBSTUtil(root.left,min,root.data)&&isValidBSTUtil(root.right,root.data,max);
        }
    }
        //***************************************************Code 2 - Inorder Traversal*************************************
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
        //***************************************************LCA*************************************
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
    class PrefixSum,Kadane,Kmp-1{
        class TreeNode
        //***************************************************Serialize and Deserealize************************************* 
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
        //***************************************************Convert BST to Greater Tree*************************************
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
        //***************************************************Prefix Sum-Two Versions*************************************  
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
        //*****************************************************Range Query**************************************************
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
        //****************************************************Car Pooling***************************************************
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
        //***************************************************XOR Query******************************************************
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
        //************************************************2D-Prefix Sum*****************************************************
        class Solution{ 
            public List<Integer> solve(int matrix[][], Pair query[]) {
            // Your code here
            List<Integer> ans=new ArrayList<>();
            int n=matrix.length;
            int m=matrix[0].length;
            int preSum[][]=new int[n][m];
            //Prefix-Row
            for(int i=0;i<n;i++){
                preSum[i][0]=matrix[i][0];
                for(int j=1;j<m;j++){
                    preSum[i][j]+=preSum[i][j-1]+matrix[i][j];
                }
            }
            //Prefix-Col
            for(int j=0;j<m;j++){
                for(int i=1;i<n;i++){
                    preSum[i][j]+=preSum[i-1][j];
                }
            }
            for(Pair qu: query){
                int r1=qu.row1,c1=qu.col1,r2=qu.row2,c2=qu.col2;
                int sum=preSum[r2][c2]-(preSum[r2][c1-1]+preSum[r1-1][c2]-preSum[r1-1][c1-1]);
                ans.add(sum);
                sum=0;
            }
            return ans;
            
        }

    }}
    class Kadane{

    }
    class KMP{
        
    }
}
