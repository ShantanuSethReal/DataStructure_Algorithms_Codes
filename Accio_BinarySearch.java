public class BinarySearch_Accio {
    //**************************Binary Search**********************************************
    class Solution{
        public static int BinarySearch(int arr[],int ele,int n){
            int start=0,end=n-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(arr[mid]==ele){
                    return mid;
                }
                else if(arr[mid]>ele){
                    end=mid-1;
                }
                else if(ele>arr[mid]){
                    start=mid+1;
                }
            }
        }
    }
    //*********************Binary Search Recursive************************************** */
    class Solution{
            public static int BinarySearchRecursive(int arr[],int start,int end,int ele){
            if(start>end){
                return -1;
            }
            int mid=(start+end)/2;
            if(arr[mid]==ele)return mid;
            else if(arr[mid]<ele)BinarySearchRecursive(arr,start,mid-1,ele);
            else BinarySearchRecursive(arr,mid+1,end,ele);
        }
    }
    //*********************Binary Search Floor & Ceil Function********************************* */
    class Solution{
        public static int floor(int arr[],int target){
        int n=arr.length,start=0,end=n-1,ans=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==target)return arr[mid];
            else if(arr[mid]<target){
                ans=arr[mid];
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
        public static int ceil(int arr[],int target){
        int n=arr.length,start=0,end=n-1,ans=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==target)return arr[mid];
            else if(arr[mid]>target){
                ans=arr[mid];
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;

        }
        public static int[] floorAndCeil(int arr[],int target){
            int f=floor(arr, target);
            int c=ceil(arr,target);
            return new int[]{f,c};
        }    
    }
    //*********************Floor and Ceil Using Binary Search*********************************** */
    class Solution{    
        public static int[] floorAndCeilUsingBS(int arr[],int target){
            int ,n=arr.length,start=0,end=n-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(arr[mid]==target){floor=arr[mid];ceil=arr[mid];return new int[]{floor,ceil};
                else if(arr[mid]<target)start=mid+1;
                else end=mid-1;
            }
            return new int[]{arr[end],arr[start]};
        }
    }
}
    //*********************Last One************************************************************** */
    //****************{1,1,1,1,1,0,0,0}********************************************************** */
    class Solution{
            public static int LasttOne(int arr[]){
            int n=arr.length,start=0,end=n-1,ans=-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(arr[mid]==1){
                    ans=mid;
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
                return ans;
            }
        }
    
        //*********************First zero************************************************************** */
        public static int ceil(int arr[],int target){
            int n=arr.length,start=0,end=n-1,ans=-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(arr[mid]==1){
                    start=mid+1;
                }
                else{
                    ans=mid;
                    end=mid-1;
                }
            }
            return ans;
            }
        }
    //*********************Sorted Inserted position************************************************** */
    class Solution{
            public int SortedInsertedPosition(int arr[],int target){
            nt n=arr.length,start=0,end=n-1,ans=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==target)return mid;
            else if(arr[mid]>target){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return mid;

        }
    }
    //********************Smaller than or Equal to**************************************************** */
    class Solution{
            public static int smallerEqual(int[] A, int B) {
                    int ans=-1;
                    int start=0;
                    int end=A.length - 1;
                    while(start<=end){
                        int mid=start+(end - start)/2;
                        if(A[mid]<=B){
                            ans=mid;
                            start=mid + 1;
                        }else{
                            end=mid-1;
                        }
                    }
                    return ans+1;
    }
}
    //**********************Find First and Last Occurence of an Element in an Array********************** */
    class Solution {
        public int firstOccur(int[] arr,int target,int n){
            int start=0,end=n-1,ans=-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(arr[mid]==target){
                    ans=mid;
                    end=mid-1;
                }
                else if(arr[mid]>target){end=mid-1;}
                else {start=mid+1;}
            }
            return ans;
        }
        public int lastOccur(int[] arr,int target,int n){
            int start=0,end=n-1,ans=-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(arr[mid]==target){
                    ans=mid;
                    start=mid+1;
                }
                else if(arr[mid]>target){end=mid-1;}
                else {start=mid+1;}
            }
            return ans;
        }
        public int[] searchRange(int[] nums, int target){
            int n=nums.length;
            int first=firstOccur(nums,target,n);
            int last=lastOccur(nums,target,n);
            if(first==-1){
                return new int[]{-1,-1};
            }
            else{
                return new int[]{first,last};
            }
        }
    }
    //**********************Search a 2D matrix**************O(log(mn))********************* */
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rows=matrix.length;
            int cols=matrix[0].length;
            
            int start=0;
            int end=(rows*cols)-1;
            
            while(start<=end){
                int mid=(start+end)/2;
                int r=mid/cols;
                int c=mid%cols;
                if(matrix[r][c]==target){return true;}
                else if(matrix[r][c]<target){start=mid+1;}
                else{end=mid-1;}
            }
            return false;
        }
            public int floor(int [][]matrix,int target){
                int rows=matrix.length;
                int cols=matrix[0].length;
                
                int ans=-1;
                int start=0;
                int end=rows-1;
                
                while(start<=end){
                    int mid=(start+end)/2;
                    if(matrix[mid][0]==target){return mid;}
                    else if(matrix[mid][0]<target){
                        ans=mid;
                        start=mid+1;
                        }
                    else{end=mid-1;}
                }
                return ans;
            }
            public boolean binarysearch(int [][]matrix,int target,int row){
                int rows=matrix.length;
                int cols=matrix[0].length;
                
                int start=0;
                int end=cols-1;
                
                while(start<=end){
                    int mid=(start+end)/2;
                    if(matrix[row][mid]==target){return true;}
                    else if(matrix[row][mid]>target){end=mid-1;}
                    else{start=mid+1;}
                }
                return false;
            }
            public boolean searchMatrix(int[][] matrix, int target) {
                int rows=matrix.length;
                int cols=matrix[0].length;
                int R=floor(matrix,target);
                if(R==-1){
                    return false;
                }
                return binarysearch(matrix,target,R);
            }
        }
    //*********************Search in a Rotated Sorted Array****************************** */
    class Solution {
        //********Solution 1************** */
        public int maxIdx(int arr[]){
            int n=arr.length;
            int start=0;
            int end=n-1;
    
            while(start<=end){
                int mid=(start+end)/2;
    
                if(mid+1<n&&arr[mid]>arr[mid+1])return mid;
                else if(arr[start]<=arr[mid])start=mid+1;
                else{end=mid-1;}
            }
    
            return n-1;
        }
        public static int BinarySearch(int arr[],int ele,int start,int end){
                while(start<=end){
                    int mid=(start+end)/2;
                    if(arr[mid]==ele){
                        return mid;
                    }
                    else if(arr[mid]>ele){
                        end=mid-1;
                    }
                    else if(ele>arr[mid]){
                        start=mid+1;
                    }
                }
                return -1;
            }
        public int search(int[] arr, int target) {
            int idx=maxIdx(arr);
            if(arr[0]<=target&&target<=arr[idx])return BinarySearch(arr,target,0,idx);
            else return BinarySearch(arr,target,idx+1,arr.length-1);
        }
        //*******************Solution 2***************************** */
        class Solution {
            public int search(int[] arr, int target) {
             int start=0;
             int end=arr.length-1;
        
             while(start<=end){
                 int mid=(start+end)/2;
                 if(arr[mid]==target)return mid;
                 else if(arr[start]<=arr[mid]){
                     if(arr[start]<=target&&target<arr[mid]){end=mid-1;}
                     else{start=mid+1;}
                 }
                 else{
                     if(arr[mid]<target&&target<=arr[end]){start=mid+1;}
                     else{end=mid-1;}
                 }
             }
             return -1;   
            }
        }
    }
    //**********************Square Root of an Integer************************************ */
    class Solution {
        public int mySqrt(int target) {
            int start=1;
            int end=target;
            int ans=0;
            while(start<=end){
                int mid=start+((end-start)/2);
                if(mid==target/mid)return mid;
                else if(mid<target/mid){
                    ans=mid;
                    start=mid+1;
                }
                else{end=mid-1;}
            }
            return ans;
        }
    }
    //**********************Triangular Number********************************************** */
    class Solution {
        int isTriangular(int N){
            //code here
            int start=1,end=N;
            while(start<=end){
                int mid=(start+end)/2;
                if((mid*(mid+1)/2)==N) return 1;
                else if((mid*(mid+1)/2)>N){end=mid-1;}
                else{start=mid+1;}
            }
            return 0;
        }
    }
    //**********************Ship Within Days*********************************************** */
    class Solution {
        public boolean isPossible(int[] weights,int truckWeight,int days){
            int currWeight=0;
            int currDay=1;
            int n=weights.length;
            for(int i=0;i<n;i++){
                currWeight+=weights[i];
                if(currWeight>truckWeight){
                    currWeight=weights[i];
                    currDay++;
                }
            }
            return (currDay<=days);
        }
        public int shipWithinDays(int[] weights, int days) {
            int maxLoad=Integer.MIN_VALUE;
            int totalLoad=0;
            int n=weights.length;
    
            for(int i=0;i<n;i++){
                maxLoad=Math.max(maxLoad,weights[i]);
                totalLoad+=weights[i];
            }
    
            int start=maxLoad;
            int end=totalLoad;
            int ans=-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(isPossible(weights,mid,days)==true){
                    ans=mid;
                    end=mid-1;
                }
                else start=mid+1;
            }
            return ans;
        }
    }
    //**********************Flowers Bloom in M bouquets within K days************************ */
    class Solution {
        public boolean isPossible(int[] bloomDay,int days,int m,int k){
            int boques=0;
            int flower=0;
            int n=bloomDay.length;
            for(int i=0;i<n;i++){
                if(bloomDay[i]<=days){
                    flower++;
                }
                else flower=0;
    
    
                if(flower==k){
                    boques++;
                    flower=0;
                    if(boques==m)return true;
                }
            }
            return false;
        }
        public int minDays(int[] bloomDay, int m, int k) {
            int maxDays=Integer.MIN_VALUE;
            int n=bloomDay.length;
    
            for(int i=0;i<n;i++){
                maxDays=Math.max(maxDays,bloomDay[i]);
            }
            int start=1;
            int end=maxDays;
            int ans=-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(isPossible(bloomDay,mid,m,k)==true){
                    ans=mid;
                    end=mid-1;
                }
                else start=mid+1;
            }
    
            return ans;
        }
    }
}
