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
    }}
        class BinarySearchTree-2(CLASS-2){
        //*****************************************************Target Sum Pair*********************************************************************************** */
        //*****************************************************Recover a BST************************************************************************************** */
        //*****************************************************Construct BST from PreOrder************************************************************************ */ 
        //*****************************************************Construct BST from PostOrder************************************************************************ */    
        //*****************************************************Construct BST from LevelOrder************************************************************************ */    
        //*****************************************************BST Iterator************************************************** */    
        }}
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
    }
        class PrefixSum,Kadane,Kmp-2(CLASS-4){
        //***********************************************2D Range Query**********************************************************************************************
        //***********************************************Array Sum Divisible by P**********************************************************************************************
        //***********************************************LeetCode 2017-Grid**********************************************************************************************
        }
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

        class Sliding Window(Class-1){
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
        }
}
