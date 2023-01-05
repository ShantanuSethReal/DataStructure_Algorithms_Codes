public class Striver_TreesPlayList {
    //***********L1.Introduction to Trees | Types of Trees************************************************************/
    //**Types of Trees- Make Notes */
    //***********L2.Binary Tree Representation in C++ ****************************************************************/
    //***********L3.Binary Tree Representation in Java ***************************************************************/
    class Solution{
        class TreeNode{
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int _val){
                this.val=_val;
            }
        }
    }
    //***********L4.Binary Tree Traversals in Binary Tree|BFS|DFS ************************** ***********************/
    class Solution{
        DFS:
        Preorder
        Inorder
        Postorder
        BFS:
        LevelOrder
    }
    //***********L5.Preorder Traversal ********************************************************************************/
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> result=new ArrayList<>();
            preOrder(root,result);
            return result;
        }
        public void preOrder(TreeNode root,ArrayList<Integer> result){
            if(root==null){
                return ;
            }
            result.add(root.val);
            preOrder(root.left,result);
            preOrder(root.right,result);
        }    
    }      
    //***********L6.Inorder Traversal  ********************************************************************************/
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> result=new ArrayList<>();
            inOrder(root,result);
            return result;
        }
        public void inOrder(TreeNode root,ArrayList<Integer> result){
            if(root==null){
                return ;
            }
            inOrder(root.left,result);
            result.add(root.val);
            inOrder(root.right,result);
        }
    }
    //***********L7.Postorder Traversal  ******************************************************************************/
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            ArrayList<Integer> result=new ArrayList<>();
            postOrder(root,result);
            return result;
        }
        public void postOrder(TreeNode root,ArrayList<Integer> result){
            if(root==null){
                return ;
            }
            postOrder(root.left,result);
            postOrder(root.right,result);
            result.add(root.val);
        }
    }
    //***********L8.Level Order Traversal of Binary Tree*************************************** */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            List<List<Integer>> wraplist=new LinkedList<List<Integer>>();
            if(root==null){
                return wraplist;
            }
            q.offer(root);
            while(!q.isEmpty()){
                int size=q.size();
                List<Integer> sublist=new LinkedList<Integer>();
                for(int i=0;i<size;i++){
                    if(q.peek().left!=null){q.offer(q.peek().left);}
                    if(q.peek().right!=null){q.offer(q.peek().right);}
                    sublist.add(q.poll().val);
                }
                wraplist.add(sublist);
            }
            return wraplist;
        }
    }
    //***********L9.Iterative Preorder Traversal*********************************
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> preorder=new ArrayList<>();
         if(root==null)return preorder;
         Stack<TreeNode> st=new Stack<TreeNode>();
         st.push(root);
         while(!st.isEmpty()){
            root=st.pop();
            preorder.add(root.val);
            if(root.right!=null){
                st.push(root.right);
            }
            if(root.left!=null){
                st.push(root.left);
            }
         }
         return preorder;
        }    
    }
    //***********L10.Iterative Inorder Traversal*********************************/
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node=root;
        while(true){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node=stack.pop();
                inorder.add(node.val);
                node=node.right;
             }
            }
         return inorder;
    }
    }
    //***********L11.Iterative Postorder Traversal using 2 Stack*********************************/
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder=new ArrayList<>();
        Stack<TreeNode> st1=new Stack<TreeNode>();
        Stack<TreeNode> st2=new Stack<TreeNode>();
        if(root==null)return postorder;
    
        st1.push(root);
        while(!st1.isEmpty()){
            root=st1.pop();
            st2.add(root);
            if(root.left!=null)st1.push(root.left);
            if(root.right!=null)st1.push(root.right);
        }
        while(!st2.isEmpty()){
            postorder.add(st2.pop().val);
        }
        return postorder;
        }
    }
    //***********L12.Iterative Postorder Traversal using 1 Stack*********************************/
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder=new ArrayList<>();
        Stack<TreeNode> st1=new Stack<TreeNode>();
        TreeNode cur=root;
        while(cur!=null||!st1.isEmpty()){
            if(cur!=null){
                st1.push(cur);
                cur=cur.left;
            }
            else{
                TreeNode temp=st1.peek().right;
                if(temp==null){
                    temp=st1.peek();
                    st1.pop();
                    postorder.add(temp.val);
                    while(!st1.isEmpty()&&temp==st1.peek().right){
                        temp=st1.peek();
                        st1.pop();
                        postorder.add(temp.val);
                    }
                }
                else{cur=temp;}
            }
        }
                return postorder;
    }
    }
    //**************L13.Preorder Inorder Postorder Traversals in One Traversal********************/
    
    //**************L14.Maximum Depth in Binary Tree | Height of Binary Tree********************/
    class Solution{
        public int heightOfBinaryTree(TreeNode root){
            if(root==null){
                return 0;
            }
            int lh=heightOfBinaryTree(root.left);
            int rh=heightOfBinaryTree(root.right);
            return 1+Math.max(lh,rh);
        }
    }
    //**************L15.Check for Balanced Binary Tree********************/
    class Solution{
        public boolean isBalanced(TreeNode root){
            return dfsHeight(root)!=-1
        }
        public int dfsHeight(TreeNode root){
            if(root==null){
                return 0;
            }
            int lh=dfsHeight(root.left);
            if(lh==-1)return -1;
            int rh=dfsHeight(root.right);
            if(rh==-1)return -1;
            if(Math.abs(lh-rh)>1)return -1;
            return 1+Math.max(lh,rh);
        }
    }
    //**************L16.Diameter of Binary Tree********************/
    class Solution{
        public int diameterOfBinaryTree(TreeNode root){
            int []diameter=new int[]{0};
            heightOfBinaryTree(root,diameter);
            return diameter[0];
        }
        public int heightOfBinaryTree(TreeNode root,int diameter[]){
            if(root==null){
                return 0;
            }
            int lh=heightOfBinaryTree(root.left,diameter);
            int rh=heightOfBinaryTree(root.right,diameter);
            diameter[0]=Math.max(diameter[0],lh+rh);
            return 1+Math.max(lh,rh);
        }
    }
    //**************L17.Maximum Path Sum in Binary Tree********************/
    
    //**************L18.Check it two trees are Identical or Not********************/
    
    //**************L19.Zig-Zag or Spiral Traversal in Binary Tree********************/
    
    //**************L20.Boundary Traversal in Binary Tree********************/
    
    //**************L21.Vertical Order Traversal of Binary Tree********************/
    class Solution{
        class Tuple{
            TreeNode node;
            int row;
            int col;
            Tuple(TreeNode _node,int _row,int _col){
                this.node=_node;
                this.row=_row;
                this.col=_col;
            }
        }
        public List<List<Integer>> verticalTraversal(TreeNode root){
            List<List<Integer>> list=new ArrayList<>();
            TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
            q.offer(new Tuple(root,0,0));
            while(!q.isEmpty()){
                Tuple tup=q.peek();
                TreeNode Node=tup.node;
                int x=tup.row;
                int y=tup.col;

                if(!map.containsKey(x)){
                    map.put(x,new TreeMap<>());
                }
                if(map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<Integer>());
                }
                map.get(x).get(y).offer(Node.val);
                if(Node.left!=null){
                    q.offer(new Tuple(Node.left,x-1,y+1));
                }
                if(Node.right!=null){
                    q.offer(new Tuple(Node.left,x+1,y+1));
                }
            }
            for(TreeMap<Integer,PriorityQueue<Integer>> ys: map.values()){
                list.add(new ArrayList<>());
                for(PriorityQueue<Integer>> nodes: ys.values())
                    while(!nodes.isEmpty()){
                        System.out.println(nodes.peek());
                        list.get(list.size()-1).add(nodes.poll());
                    }
            }
            return list;
        }
    }
    //**************L22.Top View of Binary Tree********************/
    //**************L23.Bottom View of Binary Tree********************/
    //**************L24.Right View of Binary Tree********************/
    //**************L25.Check for Symmetrical Binary Tree********************/
    //**************L26.Print Root to Node Path of Binary Tree********************/
    //**************L27.Lowest Common Ancestor of two nodes in Binary Tree********************/
    //**************L28.Maximum Width of Binary Tree********************/
    //**************L29.Children Sum Property********************/
    //**************L30.Print All Nodes at a distance K from a Node********************/
    //**************L31.Minimum time taken to burn a Tree********************/
    //**************L32.Count Total Nodes in a Binary Tree********************/
    //**************L33.Requirements to construct a unique Binary Tree********************/
    //**************L34.Construct a Binary Tree from PreOrder and InOrder********************/
    //**************L35.Construct a Binary Tree from PostOrder and InOrder********************/
    //**************L36.Serialize and DeSerialize a Binary Tree********************/
    //**************L37.Morris Traversal********************/
    //**************L38.Flatten a Binary Tree to a Linked List********************/

    //**************L39.Introduction to BST*****************************/
    class Solution{
        Left < Node < Right;
        Left <= Node < Right;//Duplicates;
        Height =Log N
        Left Subtree= BST;
        Right Subtree= BST;
    } 
    //**************L40.Search in a BST*********************************/
    class Solution{
        //O(Log N)
        public TreeNode searchBST(TreeNode root, int val) {
            while(root=null&&root.val!=val){
                root=val<root.val?root.left:root.right;
            }
            return root;
        }
    }
    //**************L41.Ceil in a BST***********************************/
    class Solution {
        public static int findCeil(TreeNode<Integer> root,int key) {
            int ceil=-1; 
            while(root!=null){
                if(root.data==key){
                    ceil=root.data;
                    return ceil;
                }
    
                if(key>root.data){
                    root=root.right;
                }
                else{
                    ceil=root.data; 
                    root=root.left;
                }
            }
            return ceil;
        }
    }
    //**************L42.Floor in a BST**********************************/
    class Solution {
        public static int floorInBST(TreeNode<Integer> root,int key) {
            int floor=-1; 
            while(root!=null){
                if(root.data==key){
                    floor=root.data;
                    return floor;
                }
                if(key>root.data) {
                    floor=root.data;
                    root=root.right;
                }
                else {
                    root=root.left;
                }
            }
            return floor;
        }
    }
    //**************L43.Insert a given node in a BST********************/
    class Solution {
        public TreeNode insertIntoBST(TreeNode root,int val) {
            if(root==null) return new TreeNode(val);
            TreeNode curr=root;
            while(true){
                if(curr.val<=val){
                    if(curr.right!=null) 
                    curr=cur.right;
                    else{
                        curr.right=new TreeNode(val);
                        break;
                    }
                } 
                else{
                    if(curr.left!=null)
                     curr=curr.left;
                    else{
                        curr.left=new TreeNode(val);
                        break;
                    }
                }
            }
            return root;
        }
    }
    //**************L44.Delete a given node in a BST********************/
    class Solution {
        public TreeNode deleteNode(TreeNode root,int key) {
            if(root==null) {
                return null;
            }
            if(root.val==key){
                return helper(root);
            }
            TreeNode dummy=root;
            while(root!=null) {
                if(root.val>key) {
                    if (root.left!=null&&root.left.val==key){
                        root.left=helper(root.left);
                        break;
                    } 
                    else{
                        root=root.left;
                    }
                } 
                else{
                    if(root.right!=null&&root.right.val==key) {
                        root.right=helper(root.right);
                        break;
                    } 
                    else{
                        root=root.right;
                    }
                }
            }
            return dummy;
        }
        public TreeNode helper(TreeNode root) {
                if(root.left==null) {
                    return root.right;
                } 
                else if(root.right==null){
                    return root.left;
                } 
                else {
                    TreeNode rightChild=root.right;
                    TreeNode lastRight=findLastRight(root.left);
                    lastRight.right=rightChild;
                    return root.left;
                }
        }
        public TreeNode findLastRight(TreeNode root) {
            if(root.right==null){
                return root;
            }
            return findLastRight(root.right);
        }
    }
    //**************L45.Kth Smallest/Largest Element in BST********************/
    class Solution{
    static Node kthlargest(Node root,int k[])
    {
	if(root==null)return null;
	Node right=kthlargest(root.right,k);
	if(right!=null){return right;}
	k[0]--;
	if(k[0]==0){return root;}
	return kthlargest(root.left,k);
    }

    static Node kthsmallest(Node root,int k[])
    {
        if(root==null){return null;}
        Node left=kthsmallest(root.left,k);
        if(left!=null){return left;}
        k[0]--;
        if(k[0]==0){return root;}
        return kthsmallest(root.right,k);
    }
}
    //**************L46.Check if a tree is BST or BT********************/
    class Solution {
        private boolean checkBST(TreeNode node,long min,long max) {
            if(node==null)return true; 
            if(node.val<=min||node.val>=max)return false; 
            
            if(checkBST(node.left,min,node.val)&&checkBST(node.right,node.val,max)){
                return true; 
            }
            return false; 
        }
        public boolean isValidBST(TreeNode root) {
            return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE); 
        }
    }
    //**************L47.LCA in a BST********************/
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
            if(root==null)return null;
            int curr=root.val; 
            if(curr<p.val&&curr<q.val) {
                return lowestCommonAncestor(root.right,p,q);
            }
            if(curr>p.val&&curr>q.val) {
                return lowestCommonAncestor(root.left,p,q);
            }
            return root; 
        }
    }
    //**************L48.Construct BST from Preorder********************/
    class Solution {
        public TreeNode bstFromPreorder(int[] A) {
            return bstFromPreorder(A,Integer.MAX_VALUE,new int[]{0});
        }
        public TreeNode bstFromPreorder(int[] A,int bound,int[] i){
            if(i[0]==A.length||A[i[0]]>bound) return null;
            TreeNode root=new TreeNode(A[i[0]++]);
            root.left=bstFromPreorder(A,root.val,i);
            root.right=bstFromPreorder(A,bound,i);
            return root;
        }
    }
    //**************L49.Inorder Successor/Predecessor********************/
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root,TreeNode p){
            TreeNode successor = null;
            while (root != null) {
                if (p.val>=root.val) {
                    root=root.right;
                }else{
                    successor=root;
                    root=root.left;
                }
            }
            return successor;
        }
        public TreeNode inorderPredecessor(TreeNode root,TreeNode p){
            TreeNode predecessor=null;
            while(root!=null) {
                if (p.val<=root.val) {
                    root=root.left;
                }else{
                    predecessor=root;
                    root=root.right;
                }
            }
            return predecessor;
        }
    }
    //**************L50.BST Iterator********************/
    class Solution{
        public class BSTIterator {
            private Stack<TreeNode> stack = new Stack<TreeNode>();
            public BSTIterator(TreeNode root){
                pushAll(root);
            }
            /** @return whether we have a next smallest number */
            public boolean hasNext(){
                return !stack.isEmpty();
            }
            /** @return the next smallest number */
            public int next(){
                TreeNode tmpNode=stack.pop();
                pushAll(tmpNode.right);
                return tmpNode.val;
            }
            
            private void pushAll(TreeNode node) {
                for (;node!=null;stack.push(node),node=node.left);
            }
        }
    }
    //**************L51.Two Sum in a BST********************/
    class Solution{
    class BSTIterator {
        private Stack<TreeNode> stack=new Stack<TreeNode>();
        boolean reverse=true; 
        
        public BSTIterator(TreeNode root,boolean isReverse){
            reverse=isReverse; 
            pushAll(root);
        }
        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    
        /** @return the next smallest number */
        public int next() {
            TreeNode tmpNode=stack.pop();
            if(reverse==false) pushAll(tmpNode.right);
            else pushAll(tmpNode.left); 
            return tmpNode.val;
        }
        
        private void pushAll(TreeNode node){
            while(node!=null){
                 stack.push(node);
                 if(reverse==true){
                     node=node.right; 
                 }else{
                     node=node.left; 
                 }
            }
        }
    }
    class Solution {
        public boolean findTarget(TreeNode root,int k){
            if(root==null) return false; 
            BSTIterator l=new BSTIterator(root,false); 
            BSTIterator r=new BSTIterator(root,true); 
            
            int i=l.next(); 
            int j=r.next(); 
            while(i<j){
                if(i+j==k) return true; 
                else if(i+j<k) i=l.next(); 
                else j=r.next(); 
            }
            return false; 
        }
    }
}
    //**************L52.Recover BST/Correct BST********************/
    class Solution {
        private TreeNode first;
        private TreeNode prev;
        private TreeNode middle;
        private TreeNode last; 
        private void inorder(TreeNode root){
            if(root==null) return; 
            inorder(root.left);
            if (prev!=null&&(root.val<prev.val))
            {
                if(first==null)
                {
                    first = prev;
                    middle = root;
                }
                else
                    last = root;
            }
            prev=root;
            inorder(root.right); 
        }
        public void recoverTree(TreeNode root) {
            first=middle=last=null; 
            prev=new TreeNode(Integer.MIN_VALUE); 
            inorder(root);
            if(first!=null&&last!=null){
                int t=first.val;
                first.val=last.val;
                last.val=t; 
            }
            else if(first!=null&&middle!=null){
                int t=first.val;
                first.val=middle.val;
                middle.val=t; 
            }
        }
       
    }
    //**************L53.Largest BST in a BT********************/
    class Solution {
        class NodeValue {
            public int maxNode, minNode, maxSize;
            NodeValue(int minNode,int maxNode,int maxSize){
                this.maxNode=maxNode;
                this.minNode=minNode;
                this.maxSize=maxSize;
            }
        }
        private NodeValue largestBSTSubtreeHelper(TreeNode root){
            if(root==null) {
                return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
            }
            NodeValue left = largestBSTSubtreeHelper(root.left);
            NodeValue right = largestBSTSubtreeHelper(root.right);
            if (left.maxNode < root.val && root.val < right.minNode) {
                return new NodeValue(Math.min(root.val,left.minNode),Math.max(root.val,right.maxNode),left.maxSize+right.maxSize+1);
            }
            return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSize, right.maxSize));
        }
        public int largestBSTSubtree(TreeNode root) {
            return largestBSTSubtreeHelper(root).maxSize;
        }
    }

    //***************************TAKE U FORWARD YOUTUBE TREES PLAYLIST************************************************* */







}
