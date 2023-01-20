public class Heaps {
    //***********Heaps Introduction****************************************** ********************************/
    Min Heap Implementation
    PriorityQueue<Integer> pQueue=new PriorityQueue<Integer>();
    Max Heap Implementation
    PriorityQueue<Integer> pQueue=new PriorityQueue<Integer>(Collections.reverseOrder());
    //***********Kth Smallest Element****************************************** ******************************/
    class Solution{
        public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=l;i<=r;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();
    } 
    public static int kthLargest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=l;i<=r;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();
    } 
}
    //***********Return K Smallest Elements***************************************************************** */
    class Solution{
        public static ArrayList<Integer> kSmallest(int arr[], int n, int k)
    {
        // code here 
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(pq.size()>0){
            ans.add(0,pq.remove());
        }
        return ans;
    }
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        // code here 
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(pq.size()>0){
            ans.add(0,pq.remove());
        }
        return ans;
    }
    }
    //***********Sort a K Sorted Array************************************* **********************************/
    //***********K closest numbers***************************************** **********************************/
    //***********Top K frequent numbers********************************************************************* */
    //***********Frequency Sort***************************************************************************** */
    //***********K closest points to origin******************************************************************* */
    //***********Connect ropes to minimise cost*************************************************************** */
    //***********Sum of Elements between k1 smallest and k2 smallest****************************************** */

}
