public class Trees {
    //**************************INORDER************************************************************************************
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
    //**************************PREORDER************************************************************************************
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
    //**************************POSTORDER***********************************************************************************    
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
    //**************************HEIGHT**************************************************************************************
    class Solution {
        public int maxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        }
    }
    //**************************SIZE****************************************************************************************
    class Solution {
        public int sizeOfTree(TreeNode root) {
            if(root==null){
                return 0;
            }
            return 1+sizeOfTree(root.left)+sizeOfTree(root.right);
        }
    }
    //**************************LEVEL ORDER TRAVERSAL***********************************************************************
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            List<List<Integer>> w=new LinkedList<List<Integer>>();
            if(root==null){
                return w;
            }
            q.offer(root);
            while(!q.isEmpty()){
                int s=q.size();
                List<Integer> w1=new LinkedList<Integer>();
                for(int i=0;i<s;i++){
                    if(q.peek().left!=null){q.offer(q.peek().left);}
                    if(q.peek().right!=null){q.offer(q.peek().right);}
                    w1.add(q.poll().val);
                }
                w.add(w1);
            }
            return w;
        }
    }
    //**************************RIGHT VIEW***********************************************************************

    class Solution{
        ArrayList<Integer> rightView(Node root) {
          ArrayList<Integer> result=new ArrayList<>();
          getLeftViewUtil(root,result,0);
          return result;
        }
        void getLeftViewUtil(Node root,ArrayList<Integer> result,int level){
            if(root==null){
                return ;
            }
            if(level==result.size()){
                result.add(level,root.data);
            }
            getLeftViewUtil(root.left,result,level+1);
            getLeftViewUtil(root.right,result,level+1);
        }
    }
    ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int s=queue.size();
            for(int i=0;i<s;i++){
                Node t=queue.poll();
                if(i==s-1){
                    ans.add(t.data);
                }
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }
                
            }
        }
        return ans;
    }
    //**************************LEFT VIEW***********************************************************************
    class Tree
    {
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> result=new ArrayList<>();
      getLeftViewUtil(root,result,0);
      return result;
    }
    void getLeftViewUtil(Node root,ArrayList<Integer> result,int level){
        
        if(root==null){
            return ;
        }
        if(level==result.size()){
            result.add(root.data);
        }
        getLeftViewUtil(root.left,result,level+1);
        getLeftViewUtil(root.right,result,level+1);
    }

    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int s=queue.size();
            for(int i=0;i<s;i++){
                Node t=queue.poll();
                if(i==0){
                    ans.add(t.data);
                }
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }   
            }
        }
        return ans;
    }
}

//**************************DIAMETER**********************************************************************
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
            int lh=height(root.left);
            int rh=height(root.right);
        
            int ld=diameterOfBinaryTree(root.left);
            int rd=diameterOfBinaryTree(root.right);
        
            return Math.max(lh+rh,Math.max(ld,rd));
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
}
//**************************TOP VIEW**********************************************************************
class Solution
{
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        Queue<Pair> q=new ArrayDeque<>();
        Map<Integer,Integer> map=new TreeMap<>();
        
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            if(!map.containsKey(curr.hd)){
                map.put(curr.hd,curr.node.data);
            }
            if(curr.node.left!=null){
             q.add(new Pair(curr.hd-1,curr.node.left));   
            }
            if(curr.node.right!=null){
             q.add(new Pair(curr.hd+1,curr.node.right));   
            }
        }
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
        
    }
    
    static class Pair{
        int hd;
        Node node;
        
        public Pair(int h,Node n){
            this.hd=h;
            this.node=n;
        }
    }
}
//**************************BOTTOM VIEW**********************************************************************
class Solution
{
    public ArrayList <Integer> bottomView(Node root)
        {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        Queue<Pair> q=new ArrayDeque<>();
        Map<Integer,Integer> map=new TreeMap<>();
        
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            map.put(curr.hd,curr.node.data);
            
            if(curr.node.left!=null){
             q.add(new Pair(curr.hd-1,curr.node.left));   
            }
            if(curr.node.right!=null){
             q.add(new Pair(curr.hd+1,curr.node.right));   
            }
        }
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
        
        }
    
    static class Pair{
        int hd;
        Node node;
        
        public Pair(int h,Node n){
            this.hd=h;
            this.node=n;
        }
    }
}
//******************Vertical Order Traversal*************************************** */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        {
        Queue<Pair> q=new ArrayDeque<>();
        Map<Integer,ArrayList<Integer>> map=new TreeMap<>();
        List<List<Integer>> wrapList=new ArrayList<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            if(map.containsKey(curr.hd)){
                map.get(curr.hd).add(curr.node.val);
            }
            else{
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(curr.node.val);
                map.put(curr.hd,temp);
            }
            if(curr.node.left!=null){
             q.add(new Pair(curr.hd-1,curr.node.left));   
            }
            if(curr.node.right!=null){
             q.add(new Pair(curr.hd+1,curr.node.right));   
            }
        }
        for(Map.Entry<Integer,ArrayList<Integer>> entry: map.entrySet()){
            wrapList.add(entry.getValue());
        }
        return wrapList;
        }
    }
    
    class Pair{
        int hd;
        TreeNode node;
        public Pair(int h,TreeNode n){
            this.hd=h;
            this.node=n;
        }
    }
    }