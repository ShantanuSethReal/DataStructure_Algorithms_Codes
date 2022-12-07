public class SlidingWindow {
    //*********************************Maximum Sum of SubArray of Size K***************************/
    class Solution{
        static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
            // code here
            int start=0,end=0;
            long Max_Sum=Integer.MIN_VALUE;
            long Current_Sum=0;
            while(end<N){
                Current_Sum+=Arr.get(end);
                if(end-start+1<K){
                    end++;
                }
                else if(end-start+1==K){
                    Max_Sum=Math.max(Current_Sum,Max_Sum);
                    Current_Sum-=Arr.get(start);
                    start++;
                    end++;
                }
            }
            return Max_Sum;
        }
    }
    //************************First Negative Integer in Window of Size K*************************** */
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
                    if(q.size()!=0)
                    res[i]=q.peekFirst();
                    else
                    res[i]=0;
                    if(A[i]<0){
                        q.removeFirst();
                    }
                    i++;
                    j++;
                }
            }
            return res;
        }
    }
    //***************Count number of anagrams in a string****************************** */
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
    //***********************Minimum Window Substring************************************* */
}
