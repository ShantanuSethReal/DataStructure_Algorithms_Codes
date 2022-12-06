public class TreesStriver {
    //***************************InOrder Traversal*************************************** */
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
    //************************Post Order Traversal******************************************** */
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
    //************************Pre Order Traversal********************************************* */
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
    //*************************Left View of a Binary Tree**************************************** */
    //*************************Top  View of a Binary Tree**************************************** */
}
