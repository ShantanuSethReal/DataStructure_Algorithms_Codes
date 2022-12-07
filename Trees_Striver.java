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
//***********************Right View of a Binary Tree********************************************** */
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
//*************************Top  View of a Binary Tree**************************************** */
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
//************************Bottom View of a Binary Tree***************************************** */
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
//****************Vertical Order Traversal**************************************/
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
    //***************Root  to Node Path in a Binary Tree******************************** */
    //***************Maximum Width Of a Binary Tree************************************** */
