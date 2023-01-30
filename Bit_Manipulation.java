public class Bit_Manipulation {
    //Single Number I
    class Solution {
        public int singleNumber(int[] nums) {
           int ans=0;
           int n=nums.length;
           for(int i=0;i<n;i++){
               ans=ans^nums[i];
           } 
           return ans;
        }
    }
    //Single Number II
    class Solution {
        public int singleNumber(int[] nums) {
            int n=nums.length;
            int ans=0;
            for(int j=0;j<32;j++){
                int bitmask=1<<j;
                int countOfZeros=0;
                int countOfOnes=0;
                for(int i=0;i<n;i++){
                    int p=nums[i]&bitmask;
                    if(p==0){countOfZeros++;}
                    else countOfOnes++;
                }
                if(countOfOnes%3!=0){ans+=bitmask;}
            }
            return ans;
        }
    }
    //Single Number III
    class Solution {
        public int[] singleNumber(int[] nums) {
            int[] ans=new int[2];
            int n=nums.length;
            int xor=0,firstbit=0;
            for(int i=0;i<n;i++){
                xor=xor^nums[i];
            }
            firstbit=f(xor);
            int mask=1<<firstbit;
            for(int i=0;i<n;i++){
                int check=nums[i]&mask;
                if(check!=0)ans[1]=ans[1]^nums[i];
                else ans[0]=ans[0]^nums[i];
            }
            return ans;
        }
        public int f(int xor){
            int bitmask=1;
            for(int i=0;i<32;i++){
                bitmask=bitmask<<i;
                int check=xor&bitmask;
                if(check!=0){return i;}
            }
            return -1;
        }
    }
    //Reverse Bits
    class Solution{
        public static boolean checkKthBit(long n,long k){
            long bitmask=1L<<k;
            long check=n&bitmask;
            return check!=0;
        }
        public static long reverse(long A) {
            // Your code here
            long ans=0;
            for(int i=0;i<=31;i++){
                if(checkKthBit(A,i)==true){
                    ans=ans+(1L<<(31-i));
                }
            }
            return ans;
        }
    }
    //Game of XOR
    class Solution
    {
       static int xorSubarrayXors(int arr[], int n) {
        //Write code here
		   int ans=0;
		   for(int i=0;i<n;i++){
			   int freq=(i+1)*(n-i);
			   if(freq%2==1){ans=ans^arr[i];}
		   }
		   return ans;
    }
    }
    //Subsets of an Array
    class Solution{
        public static boolean checkKthBit(long n,long k){
                long bitmask=1L<<k;
                long check=n&bitmask;
                return check!=0;
            }
        public static ArrayList<ArrayList<Integer>> subsets(int[] arr, int n) {
            //Write your code here
            ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
            int total=1<<n;
            for(int num=0;num<total;num++){
                ArrayList<Integer> subset=new ArrayList<>();
                for(int i=0;i<n;i++){
                    int idx=n-i-1;
                    if(checkKthBit(num,idx)==true){subset.add(arr[i]);}
                }
                ans.add(subset);
            }
            return ans;
        }
    }
    //Flip the bits;
    class Solution{
        public static boolean checkKthBit(long n,long k){
            long bitmask=1L<<k;
            long check=n&bitmask;
            return check!=0;
        }
        public static long reverse(long A) {
            // Your code here
            long ans=0;
            for(int i=0;i<=31;i++){
                if(checkKthBit(A,i)==false){
                    ans=ans+(1L<<i);
                }
            }
            return ans;
        }
    }
