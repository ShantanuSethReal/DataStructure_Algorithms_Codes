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
                else if(arr[i]<arr[mid]){
                    end=mid-1;
                }
                else if(arr[i]>arr[mid]){
                    start=mid+1;
                }
            }
        }
        //*********************Binary Search Recursive************************************** */
        public static int BinarySearchRecursive(int arr[],int start,int end,int ele){
            if(start>end){
                return -1;
            }
            int mid=(start+end)/2;
            if(arr[mid]==ele)return mid;
            else if(arr[mid]<ele)BinarySearchRecursive(arr,start,mid-1,ele);
            else BinarySearchRecursive(arr,mid+1,end,ele);
        }
        //*********************Binary Search Floor & Ceil Function********************************* */
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
        //*********************Floor and Ceil Using Binary Search*********************************** */
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
        //*********************Last One************************************************************** */
        //****************8{1,1,1,1,1,0,0,0}********************************************************** */
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
