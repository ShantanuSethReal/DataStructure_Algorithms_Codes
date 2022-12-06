public class Stacks {
    //**********************Next Greater Element*************************************************************** */
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int n=nums.length;
            int nge[]=new int[n];
            Stack<Integer> st=new Stack<>();
            for(int i=2*n-1;i>=0;i--){
                while(st.isEmpty()==false && st.peek()<=nums[i%n]){
                    st.pop();
                }
                if(i<n){
                    if(st.isEmpty()==false)
                    {nge[i]=st.peek();}
                    else {nge[i]=-1;}
                }
                st.push(nums[i%n]);
            }
            return nge;
        }
    }
    
}
//*************************************Valid Paranthesis*************************************************************** */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(char it:s.toCharArray()){
            if(it=='('||it=='['||it == '{')
                st.push(it);
            else {
                if(st.isEmpty()) 
                {
                    return false;
                }
                char ch = st.pop(); 
                if((it==')'&&ch =='(')||(it==']'&&ch=='[')||(it=='}'&&ch=='{'))
                {
                   continue;
                }
                else 
                {
                    return false;
                }
            }
        }
        return st.isEmpty();
}
}
//*********************************Extra Brackets******************************************************************** */
class Solution {
    public boolean ExtraBrackets(String exp) {
        // Write your code here
		int n=exp.length();
		Stack<Character> st=new Stack<>();
		for(int i=0;i<n;i++){
			char ch=exp.charAt(i);
			if(ch!=')'){
				st.push(ch);
			}
			else{
				if(st.size()>0&&st.peek()=='('){
					return true;
				}
				else{
					while(st.size()>0&&st.peek()!='('){
						st.pop();
					}
					st.pop();
				}
			}
		}
		return false;
    }
}
//*****************************Next Greater Element**********************************************AccioJob************** */

class Solution
{
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        //Write code here and print output
		long nge[]=new long[n];
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<n;i++){
			while(st.size()>0 && arr[i]>arr[st.peek()]){
				nge[st.peek()]=arr[i];
				st.pop();
			}
			st.push(i);
		}
		while(st.size()>0){
			nge[st.peek()]=-1;
			st.pop();
		}
		return nge;
    } 
}
//******************************Largest Rectangle in a Histogram*************AccioJob/Striver****Optimized 1**************************** */
class Solution
{
    public long maximumArea(long heights[],long n){
		int n1=heights.length;
        Stack<Integer> st=new Stack<>();
        long leftSmall[] = new long[n1];
        long rightSmall[] = new long[n1];
        for(int i=0;i<n1;i++) {
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i]){
                st.pop();
            }

            if (st.isEmpty()) 
			{leftSmall[i]=0;}
            else 
			{leftSmall[i]=st.peek()+1;}
            st.push(i);
        }
        while (!st.isEmpty()) 
			{st.pop();}

        for(int i=n1-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }

            if (st.isEmpty()) 
			{rightSmall[i]=n1-1;}
            else 
			{rightSmall[i]=st.peek()-1;}
            st.push(i);
        }

        long maxA = 0;
        for (int i=0;i<n1;i++) {
            maxA=Math.max(maxA, heights[i]*(rightSmall[i]-leftSmall[i]+1));
        }
        return maxA;
	}
}
//********************************Stock Span Problem*********************** */
class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        int S[]=new int[n];
        Stack<Integer> st=new Stack<>();
        st.push(0);
        S[0]=1;
        for(int i=1;i<n;i++){
            while(!st.isEmpty()&&price[st.peek()]<=price[i]){
                st.pop();
            }
            S[i]=(st.isEmpty())?(i+1):(i-st.peek());
            st.push(i);
        }
        return S;
    }
}
//***********************Previous Greater Element************************************** */
class Solution
{
    public static long[] prevGreater(long[] price, int n)
    { 
        //Write code here and print output  
		long pge[]=new long[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&price[st.peek()]<=price[i]){
                st.pop();
            }
			if(st.isEmpty()){pge[i]=-1;}
			else{
				pge[i]=price[st.peek()];
			}
            st.push(i);
        }
        return pge;
    } 
}
//*********************Sliding Window Maximum*************************** */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int maxEle[]=new int[n-k+1];
        int ri=0;
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!q.isEmpty()&&q.peek()==i-k){
                q.poll();
            }
            while(!q.isEmpty()&&nums[q.peekLast()]<=nums[i])
            {
                q.pollLast();
            }
            q.offer(i);
            if(i>=k-1){
                maxEle[ri++]=nums[q.peek()];
            }
        }
        return maxEle;
        }
}



