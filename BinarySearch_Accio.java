public class BinarySearch_Accio {
    //**************************Binary Search**********************************************
    class Solution{
        int BinarySearch(int arr[],int ele,int n){
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
        int BinarySearchRecursive(int arr[],int start,int end,int ele){
            if(start>end){
                return -1;
            }
            int mid=(start+end)/2;
            if(arr[mid]==ele)return mid;
            else if(arr[mid]<ele)BinarySearchRecursive(arr,start,mid-1,ele);
            else BinarySearchRecursive(arr,mid+1,end,ele);
        }
        int floor()[

        ]
        int ceil(){

        }
    }
}
