public class SlidingWindow {
    //***********************************Base Code***************************************************************** */
    class Solution{
        public SlidingWindow(){
            int i=0,j=0;
            while(j<size){
                sum=sum+arr[j];
                if(j-i+1<K){
                    j++;
                }
                else if(j-i+1==K){
                    max=Math.max(sum,max);
                    sum=sum-arr[i];
                    i++;
                    j++;
                }
            }
        }
    }
    //***************************Maximum Sum of SubArray of Size K*******************************************************/
    class Solution{
        static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
            // code here
            int start=0,end=0;
            long max_Sum=Integer.MIN_VALUE;
            long current_Sum=0;
            while(end<N){
                current_Sum+=Arr.get(end);
                if(end-start+1<K){
                    end++;
                }
                else if(end-start+1==K){
                    max_Sum=Math.max(current_Sum,max_Sum);
                    current_Sum-=Arr.get(start);
                    start++;
                    end++;
                }
            }
            return Max_Sum;
        }
    }
    //***************************First Negative Integer in Window of Size K********************************************** */
    class Compute {
    
        public long[] printFirstNegativeInteger(long A[], int N, int K)
        {
            int i=0,j=0;
            ArrayDeque<Long> q=new ArrayDeque<>();
            long res[]=new long[N-K+1];
            while(j<N){
                if(A[j]<0){
                    q.addLast(A[j]);
                }
                if(j-i+1<K){
                    j++;
                }
                else if(j-i+1==K){
                    if(q.size()!=0){
                    res[i]=q.peekFirst();
                    }
                    else
                    {res[i]=0;
                    if(A[i]<0){
                        q.removeFirst();
                    }
                }
                    i++;
                    j++;
                }
            }
            return res;
        }
    }
    //**************************Count number of anagrams in a string************************************************** */
    class Solution {
        int search(String pat, String txt) {
            // code here
            int n=txt.length(),k=pat.length();
            int i=0,j=0;
            HashMap<Character,Integer> mpp=new HashMap<>();
            int count=0,ans=0;
            for(int p=0;p<k;p++){
                if(mpp.get(pat.charAt(p))==null){
                    mpp.put(pat.charAt(p),1);
                }
                else{
                    mpp.put(pat.charAt(p),mpp.get(pat.charAt(p))+1);
                }
            }
            count=mpp.size();
            while(j<n){
                if(mpp.get(txt.charAt(j))!=null){
                    mpp.put(txt.charAt(j),mpp.get(txt.charAt(j))-1);
                    if(mpp.get(txt.charAt(j))==0){
                        count--;
                    }
                }
                
                if(j-i+1<k){
                    j++;
                }
                else if(j-i+1==k){
                    if(count==0){
                        ans++;
                    }
                    if(mpp.get(txt.charAt(i))!=null){
                       mpp.put(txt.charAt(i),mpp.get(txt.charAt(i))+1);
                        if(mpp.get(txt.charAt(i))==1){
                        count++;
                        }
                    }
                    i++;
                    j++;
                }
            }
            return ans;
        }
    }
    //**************************Maximum of all SubArrays of Size K***************************************************** */
    class Solution{
        public int[] maxSlidingWindow(int[] nums, int k){
        int ans[]=new int[nums.length-k+1];
        Deque<Integer> q=new LinkedList<>();
        
        int i = 0,j=0;
        while(j < nums.length){
            // calculation
            if(q.size()==0){
                q.add(nums[j]);
            }
            else{
                while(q.size()>0&&q.peekLast()<nums[j]){
                    q.removeLast();
                }
                q.add(nums[j]);
            }
            // now move j pointer
            if(j-i+1<k) 
            {j++;}
            // if we hit the window size
            else if(j-i+1==k){
                // answer -> calculation;
                ans[i]=q.peek();
                // slide the window
                // calculation
                if(nums[i]==q.peek()){
                    q.removeFirst();
                }
                // now slide the pointer
                i++;
                j++;
            }
        }
        return ans;
        }
    }
    //**************************Largest SubArray of Sum K************************************************************** */
    class Solution{
        public static int lenOfLongSubarr (int A[], int N, int K) {
            //Complete the function
            int i=0,j=0;
            int sum=0,len=Integer.MIN_VALUE;
            while(j<N){
                sum=sum+A[j];
                if(sum<K){
                    j++;
                }
                else if(sum==K){
                    len=Math.max(len,j-i+1);
                    j++;
                }
                else if(sum>K){
                    while(sum>K){
                        sum=sum-A[i];
                        i++;
                    }
                j++;
                }
            }
            return len;
        }
    
    }
    //**************************Longest Substring with K unique characters********************** */
    class Solution {
        public int longestkSubstr(String s, int k) {
            // code here
            int ans=-1,i=0,j=0;
            HashMap<Character,Integer> mpp=new HashMap<>();
            while(j<s.length()){
                char ch=s.charAt(j);
                if(mpp.get(ch)==null){
                    mpp.put(ch,1);
                }
                else{
                    mpp.put(ch,mpp.get(ch)+1);
                }
                if(mpp.size()<k){
                    j++;
                }
                else if(mpp.size()==k){
                    ans=Math.max(ans,j-i+1);
                    j++;
                }
                else if(mpp.size()>k){
                    while(mpp.size()>k){
                        char l=s.charAt(i);
                        if(mpp.get(l)==1){
                            mpp.remove(l);
                        }
                        else{
                            mpp.put(l,mpp.get(l)-1);
                        }
                        i++;
                    }
                    j++;
                }
            }
            return ans;
        }
    }
    //*****************Longest Substring without repeating /with no repeating Characters******************* */
    class Solution {
        public int lengthOfLongestSubstring(String s) {
              int ans=0,i=0,j=0;
                HashMap<Character,Integer> mpp=new HashMap<>();
                while(j<s.length()){
                    char ch=s.charAt(j);
                    if(mpp.get(ch)==null){
                        mpp.put(ch,1);
                    }
                    else{
                        mpp.put(ch,mpp.get(ch)+1);
                    }
                     if(mpp.size()==j-i+1){
                        ans=Math.max(ans,j-i+1);
                        j++;
                    }
                    else if(mpp.size()<j-i+1){
                        while(mpp.size()<j-i+1){
                            char l=s.charAt(i);
                            if(mpp.get(l)==1){
                                mpp.remove(l);
                            }
                            else{
                                mpp.put(l,mpp.get(l)-1);
                            }
                            i++;
                        }
                        j++;
                    }
                }
                return ans;
        }
    }
    //************************Pick Toys**************************************************** */
    //***********************Minimum Window Substring************************************* */
    //**L-Longer String S Shorter String*************************************************** */
    class Solution {
        public String minWindow(String L,String S) {
            HashMap<Character,Integer> map=new HashMap<>();
            for(int k=0;k<S.length();k++){
                map.put(S.charAt(k),map.getOrDefault(S.charAt(k),0)+1);
            }
            int min=Integer.MAX_VALUE;
            String res=""; 
            int count=map.size();
            int i=0,j=0;
            while(j<L.length()){
                if(map.get(L.charAt(j))!=null){
                map.put(L.charAt(j),map.get(L.charAt(j))-1);
                if(map.get(L.charAt(j))==0)
                    count--;
                }
                 if(count>0){
                     j++;
                 }       
                 else{
                    if(count==0){
                       while(count==0){
                            if(min>j-i+1){
                             res=L.substring(i,j+1);
                             min=Math.min(min,j-i+1);
                            }
                         
                            if(map.get(L.charAt(i))!=null){
                            map.put(L.charAt(i),map.get(L.charAt(i))+1);
                            if(map.get(L.charAt(i))==1)
                                  count++;
                                }
                          i++;
                       }
                       j++;
                    } 
                 }
            }
            return res;
        }
        }
}
