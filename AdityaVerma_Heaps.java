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
    class Solution{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                ans.add(pq.remove());
            }
        }
        while(pq.size()>0){
            ans.add(pq.remove());
        }
        return ans;
    }
}
    //***********K closest numbers***************************************** **********************************/
    class Solution {
        class Pair{
            int key;
            int value;
            Pair(int k,int v){
                this.key=k;
                this.value=v;
            }
        }
        int[] printKClosest(int[] arr, int n, int k, int x) {
            // code here
            PriorityQueue<Pair> pq=new PriorityQueue<>(
                (Pair X,Pair Y)->{
                    if(X.key==Y.key){return X.value-Y.value;}
                    else return Y.key-X.key;
                });
            for(int i=0;i<n;i++){
                if(arr[i]==x){continue;}
                pq.add(new Pair(Math.abs(arr[i]-x),arr[i]));
                if(pq.size()>k){
                    pq.remove();
                }
            }
    
            
            int ans[]=new int[k];
            int i=1;
            while(pq.size()>0){
                Pair it=pq.remove();
                ans[k-i]=it.value;
                i++;
            }
            return ans;
        }
    }
    //***********Top K frequent numbers********************************************************************* */
    class Solution {
        class Pair{
                int freq;
                int value;
                Pair(int X,int Y){
                    this.freq=X;
                    this.value=Y;
                }
                }
        public int[] topKFrequent(int[] nums, int k) {
            PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.freq-y.freq);
            HashMap<Integer,Integer> mp=new HashMap<>();
            int n=nums.length;
            for(int i=0;i<n;i++){
                mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            }
            for(Integer it: mp.keySet()){
                int F=mp.get(it);
                int V=it;
                pq.add(new Pair(F,V));
                if(pq.size()>k){pq.remove();}
            }
            int ans[]=new int[k];
            int i=0;
            while(pq.size()>0){
                Pair p=pq.remove();
                ans[i++]=p.value;
            }
            return ans;
    
        }
    }
    //***********Frequency Sort***************************************************************************** */
    class Solution {

        class Pair{
            int freq;
            int value;
            Pair(int X,int Y){
                this.freq=X;
                this.value=Y;
            }
            }
        public int[] frequencySort(int[] nums) {
            PriorityQueue<Pair> pq=new PriorityQueue<>(
            (Pair x,Pair y)->{
                if(x.freq==y.freq){return y.value-x.value;}
                else return x.freq-y.freq;
            });
            HashMap<Integer,Integer> mp=new HashMap<>();
            int n=nums.length;
            for(int i=0;i<n;i++){
                mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            }
            for(Integer it: mp.keySet()){
                int F=mp.get(it);
                int V=it;
                pq.add(new Pair(F,V));
            }
            int ans[]=new int[n];
            int j=0;
            while(pq.size()>0){
                Pair p=pq.remove();
                int f=p.freq;
                int ele=p.value;
                for(int i=0;i<f;i++)ans[j++]=ele;
            }
            return ans;
        }
    }
    //***********K closest points to origin******************************************************************* */
    class Solution {
        class Pair{
            int dist;
            int x;
            int y;
            Pair(int D,int X,int Y){
                this.dist=D;
                this.x=X;
                this.y=Y;
            }
        }
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->y.dist-x.dist);
                for(int i=0;i<points.length;i++){
                    pq.add(new Pair((points[i][0]*points[i][0]+points[i][1]*points[i][1]),points[i][0],points[i][1]));
                    if(pq.size()>k){
                        pq.remove();
                    }
                }
                int i=0;
                int [][]ans=new int[k][2];
                while(pq.size()>0){
                    Pair it=pq.remove();
                    ans[i][0]=it.x;
                    ans[i][1]=it.y;
                    i++;
                }
                return ans;
            }
        }
    //***********Connect ropes to minimise cost*************************************************************** */
    class Solution{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        // your code here
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){pq.add(arr[i]);}
        long sum=0;
        while(pq.size()>=2){
            long first=pq.remove();
            long second=pq.remove();
            long newrope=first+second;
            sum+=newrope;
            pq.add(newrope);
        }
        return sum;
    }
}
    //***********Sum of Elements between k1 smallest and k2 smallest****************************************** */
    class Solution {
        public static long getKthSmallest(long arr[],long N,long k){
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i<N;i++){
                pq.add(arr[i]);
                if(pq.size()>k){
                    pq.remove();
                }
            }
            return pq.peek();
        }
        public static long sumBetweenTwoKth(long A[], long N, long K1, long K2)
        {
            // Your code goes here
            long ks1=getKthSmallest(A,N,K1);
            long ks2=getKthSmallest(A,N,K2);
            long sum=0;
            for(int i=0;i<N;i++){if(A[i]>ks1&&A[i]<ks2)sum+=A[i];}
            return sum;
        }
        
    }
}
