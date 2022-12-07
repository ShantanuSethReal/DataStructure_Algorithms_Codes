public class TreesStriver {
    //***************************InOrder Traversal******************************************************************************************************************** */
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
    //************************Post Order Traversal******************************************************************************************************************** */
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
    //************************Pre Order Traversal********************************************************************************************************************* */
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
    //*************************Left View of a Binary Tree************************************************************************************************************* */
    class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
     ArrayList<Integer> result=new ArrayList<>();
     printLeftView(root,result,0);
     return result;
    }
    public void printLeftView(Node root,ArrayList<Integer> result,int level){
        if(root==null){
            return;
        }
        if(level==result.size()){
            result.add(root.data);
        }
        printLeftView(root.left,result,level+1);
        printLeftView(root.right,result,level+1);
    }
    
}
    //***********************Right View of a Binary Tree************************************************************************************************************** */
    class Tree
{
    ArrayList<Integer> RightView(Node root)
    {
     ArrayList<Integer> result=new ArrayList<>();
     printRightView(root,result,0);
     return result;
    }
    public void printRightView(Node root,ArrayList<Integer> result,int level){
        if(root==null){
            return;
        }
        if(level==result.size()){
            result.add(root.data);
        }
        printRightView(root.right,result,level+1);
        printRightView(root.left,result,level+1);
    }
    
}
    //*************************Top  View of a Binary Tree************************************************************************************************************* */
    class Pair{
    Node node;
    int hd;
    
    Pair(Node temp,int h){
        this.node=temp;
        this.hd=h;
    }
}
    class Solution
{
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>(); 
        if(root==null)
            return ans;
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<Pair>();
        q.add(new Pair(root,0)); 
        while(!q.isEmpty()) {
            Pair it=q.remove();
            int hd =it.hd; 
            Node temp=it.node; 
            if(map.get(hd)==null)
                map.put(hd, temp.data); 
            if(temp.left!=null) {
                q.add(new Pair(temp.left,hd-1)); 
            }
            if(temp.right!=null) {
                q.add(new Pair(temp.right,hd+1)); 
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans; 
    }
}
    //************************Bottom View of a Binary Tree************************************************************************************************************ */
    class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
        // Code here
    {
        ArrayList<Integer> ans = new ArrayList<>(); 
        if(root==null)
            return ans;
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Node> q=new LinkedList<Node>();
        root.hd = 0;
        q.add(root); 
        while(!q.isEmpty()) {
            Node temp=q.remove();
            int hd=temp.hd; 
            map.put(hd,temp.data); 
            if(temp.left!=null){
                temp.left.hd=hd-1; 
                q.add(temp.left); 
            }
            if(temp.right!=null) {
                temp.right.hd=hd+1; 
                q.add(temp.right); 
            }
        }
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans.add(entry.getValue()); 
        }
        return ans; 
        }
}
    }
    //****************Vertical Order Traversal**************************************************************************************************************************/
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
    class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue <Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList <Tuple>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tuple=q.poll();
            TreeNode node=tuple.node;
            int x=tuple.row;
            int y=tuple.col;
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);

            if(node.left!=null){
                q.offer(new Tuple(node.left,x-1,y+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,x+1,y+1));
            }
        }
        List<List<Integer>> list=new ArrayList<>();
        for (TreeMap<Integer,PriorityQueue<Integer>> ys: map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes: ys.values()) {
                while(!nodes.isEmpty()) {
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
        }
    }
    //***************Root  to Node Path in a Binary Tree************************************************************************************************************* */
    public class Solution {
        public ArrayList<Integer> solve(TreeNode A, int B) {
            ArrayList<Integer> ans=new ArrayList<>();
            if(A==null){
                return ans;
            }
            boolean res=getPath(A,ans,B);
            return res==true?ans:new ArrayList<>();
        }
        public boolean getPath(TreeNode A,ArrayList<Integer> ans,int B){
            if(A==null){
                return false;
            }
            ans.add(A.val);
            if(A.val==B){
                return true;
            }
            
            if(getPath(A.left,ans,B)||getPath(A.right,ans,B)){
                return true;
            }
            ans.remove(ans.size()-1);
            return false;
        }
    }    
    //***************Maximum Width Of a Binary Tree****************************************************************************************************************** */
    class Pair {
        TreeNode node;
        int num;
        Pair(TreeNode _node,int _num){
            node=_node;
            num=_num;
        }
    }
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if(root==null){
                return 0;
            }
            int ans=0;
            Queue<Pair> q=new LinkedList<Pair>();
            q.offer(new Pair(root,0));
            while(!q.isEmpty()){
                int size=q.size();
                int mmin=q.peek().num;
                int first=0,last=0;
                for(int i=0;i<size;i++){
                    int cur_id=q.peek().num-mmin;
                    TreeNode node=q.peek().node;
                    q.poll();
                    if(i==0){first=cur_id;}
                    if(i==size-1){last=cur_id;}
                    if(node.left!=null){
                        q.offer(new Pair(node.left,cur_id*2+1));
                    }
                    if(node.right!=null){
                        q.offer(new Pair(node.right,cur_id*2+2));
                    }
                }
                ans=Math.max(ans,last-first+1);
            }
            return ans;
        }
    }
    //***************Pre/In/PostOrder Traversal************************************************************************************************************************ */
    class Pair {
        TreeNode node;
        int num;
        Pair(TreeNode _node, int _num) {
            num = _num;
            node = _node;
        }
    }
    public class TUF {
        public static void allTraversal(TreeNode root,List<Integer> pre,List<Integer> in,List<Integer> post){
            Stack<Pair> st=new Stack<Pair>();
            st.push(new Pair(root,1));
            
            if (root == null) 
            return;
    
            while (!st.isEmpty()) {
                Pair it = st.pop();
                if(it.num == 1) {
                    pre.add(it.node.val);
                    it.num++;
                    st.push(it);
                    if(it.node.left!=null){
                        st.push(new Pair(it.node.left,1));
                    }
                }
                else if(it.num == 2){
                    in.add(it.node.val);
                    it.num++;
                    st.push(it);
    
                    if(it.node.right!=null){
                        st.push(new Pair(it.node.right,1));
                    }
                }
                else {
                    post.add(it.node.val);
                }
            }
        }
    }
    //******************Level Order Traversal*************************************************************************************************************************** */
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
    //****************Height of a Binary Tree****************************************************************************************************************************/
    class Solution {
        public int maxDepth(TreeNode root) {
            if(root==null) 
            return 0; 
            int lh=maxDepth(root.left); 
            int rh=maxDepth(root.right); 
            
            return 1+Math.max(lh,rh); 
        }
    }    
    //***************Diameter of a Binary Tree******************* ********************************************************************************************************/
    public class Solution{
        public int diameterOfBinaryTree(TreeNode root){
            int[] diameter=new int[1];
            height(root,diameter);
            return diameter[0];        
        }
    
        private int height(TreeNode node,int[] diameter){
            if(node==null){
                return 0;
            }
            int lh=height(node.left,diameter);
            int rh=height(node.right,diameter);
            diameter[0]=Math.max(diameter[0],lh+rh);
            return 1+Math.max(lh,rh);
        }
    } 
    //***********************LCA of Two Nodes(Lowest Common Ancestor)************************************************************************************************** */
    class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        else{
            return root;
        }
    }
}
    //*********************Check If Two Binary Trees Are Equal******************************************************************************************************** */
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null&&q==null){
                return true;
            }
            else if((p==null&&q!=null)||(p!=null&&q==null))
            {return false;}
            return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
    }
    //***********************Zig Zag Traversal************************************************************************************************************************* */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            Queue<Node> queue=new LinkedList<Node>();
            ArrayList<ArrayList<Integer>> wrapList=new ArrayList<>();
            if (root == null) return wrapList;
            queue.offer(root);
            boolean flag = true;
            while (!queue.isEmpty()) {
                int levelNum = queue.size();
                ArrayList<Integer> subList=new ArrayList<Integer>(levelNum);
                for (int i=0;i<levelNum;i++) {
                    int index = i;
                    if (queue.peek().left != null) queue.offer(queue.peek().left);
                    if (queue.peek().right != null) queue.offer(queue.peek().right);
                    if (flag == true) subList.add(queue.poll().val);
                    else subList.add(0, queue.poll().val);
                }
                flag = !flag;
                wrapList.add(subList);
            }
            return wrapList;
        }
    }
    //****************Boundary Traversal********************************************************************************************************************************* */
    public class Main {
        static Boolean isLeaf(Node root) {
            return(root.left==null)&&(root.right==null);
        }
        static void addLeftBoundary(Node root,ArrayList<Integer> res){
            Node cur=root.left;
            while(cur!=null){
                if(isLeaf(cur)==false)
                res.add(cur.data);
                if(cur.left!=null) 
                    cur=cur.left;
                else 
                    cur=cur.right;
            }
        }
        static void addRightBoundary(Node root,ArrayList<Integer> res){
            Node cur=root.right;
            ArrayList<Integer> tmp=new ArrayList<Integer>();
            while(cur!=null){
                if(isLeaf(cur)==false) 
                    tmp.add(cur.data);
                if(cur.right!=null) 
                    cur = cur.right;
                else 
                    cur = cur.left;
            }
            int i;
            for(i=tmp.size()-1;i>=0;--i){
                res.add(tmp.get(i));
            }
        } 
        static void addLeaves(Node root,ArrayList<Integer> res){
            if(isLeaf(root)){
                res.add(root.data);
                return;
            }
            if(root.left!=null) 
                addLeaves(root.left,res);
            if(root.right!=null) 
                addLeaves(root.right,res);
        }
        static ArrayList<Integer> printBoundary(Node node){
            ArrayList<Integer> ans=new ArrayList<Integer>();
            if(isLeaf(node)==false) 
                ans.add(node.data);
            addLeftBoundary(node,ans);
            addLeaves(node,ans);
            addRightBoundary(node,ans);
            return ans;
        }