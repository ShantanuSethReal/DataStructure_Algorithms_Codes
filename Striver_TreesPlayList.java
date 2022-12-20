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
    
    //**************L15.Check for Balanced Binary Tree********************/
    
    //**************L16.Diameter of Binary Tree********************/
    
    //**************L17.Maximum Path Sum in Binary Tree********************/
    
    //**************L18.Check it two trees are Identical or Not********************/
    
    //**************L19.Zig-Zag or Spiral Traversal in Binary Tree********************/
    
    //**************L20.Boundary Traversal in Binary Tree********************/
    
    //**************L21.Vertical Order Traversal of Binary Tree********************/










}
