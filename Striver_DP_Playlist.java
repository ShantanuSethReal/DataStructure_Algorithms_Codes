public class Striver_DP_Playlist {
 //*********************************DP-1 Introduction to Dynamic Programming*******************************************/  
 //*********************************DP-2 Climbing Stairs***************************************************************/  
 //*********************************DP-3 Frog Jump**********************************************************************/  
 //*********************************DP-4 Frog Jump with K Distance******************************************************/  
 //*********************************DP-5 Maximum Sum of Non Adjacent Elements*******************************************/  
 //*********************************DP-6 House Robber*******************************************************************/  
 //*********************************DP-7 Ninja Training*****************************************************************/  
 //*********************************DP-8 Grid Unique Paths**************************************************************/  
 class TUF{
    //*****************************Memoization********************************************************************** */  
    static int countWaysUtil(int i,int j,int[][] dp){
      if(i==0&&j == 0){return 1;}
      if(i<0||j<0){return 0;}
      if(dp[i][j]!=-1)return dp[i][j];
        
      int up=countWaysUtil(i-1,j,dp);
      int left=countWaysUtil(i,j-1,dp);
      return dp[i][j]=up+left;
    }
    static int countWays(int m,int n){
        int dp[][]=new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countWaysUtil(m-1,n-1,dp);
        
    }
    //*****************************Tabulation********************************************************************** */  
    static int countWaysUtil(int m,int n,int[][] dp){     
         for(int i=0;i<m;i++){
              for(int j=0;j<n;j++){
                  if(i==0&&j==0){
                      dp[i][j]=1;
                      continue;
                  }
                  int up=0;
                  int left = 0;
                  if(i>0) 
                    up=dp[i-1][j];
                  if(j>0)
                    left=dp[i][j-1];
                    
                  dp[i][j]=up+left;
              }
          }
          return dp[m-1][n-1];
        }
    static int countWays(int m,int n){
            int dp[][]=new int[m][n];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            return countWaysUtil(m,n,dp);
        }
    }
 //*********************************DP-9 Grid Unique Paths with Obstacles***********************************************/  
 class TUF{
    //*****************************Memoization********************************************************************** */  
    static int mazeObstaclesUtil(int i,int j,int[][] maze,int[][] dp){
      if(i>0&&j>0&&maze[i][j]==-1){return 0;}
      if(i==0&&j==0){return 1;}
      if(i<0||j<0){return 0;}
      if(dp[i][j]!=-1) return dp[i][j];
        
      int up=mazeObstaclesUtil(i-1,j,maze,dp);
      int left=mazeObstaclesUtil(i,j-1,maze,dp);
      
      return dp[i][j]=up+left;
    }
    static int mazeObstacles(int n,int m,int[][] maze){
        int dp[][]=new int[n][m];
        for(int row[]: dp)
        Arrays.fill(row,-1);
        return mazeObstaclesUtil(n-1,m-1,maze,dp);
    }
    //*****************************Tabulation********************************************************************** */  
    static int mazeObstaclesUtil(int n,int m,int[][] maze,int[][] dp){
        for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                 if(i>0&&j>0 && maze[i][j]==-1){
                   dp[i][j]=0;
                   continue;
                 }
                 if(i==0&&j==0){
                     dp[i][j]=1;
                     continue;
                 }
                 int up=0;
                 int left=0;
                 if(i>0) 
                   up=dp[i-1][j];
                 if(j>0)
                   left=dp[i][j-1];
                   
                 dp[i][j]=up+left;
             }
         }
         return dp[n-1][m-1];
       }
} 
    //******************************DP-10 Minimum Path Sum in Grid******************************************************/
 class TUF{
    //*****************************Memoization********************************************************************** */  
    static int minSumPathUtil(int i,int j,int[][] matrix,int[][] dp){
      if(i==0&&j==0){return matrix[0][0];}
      if(i<0||j<0){return (int)Math.pow(10,9);}
      if(dp[i][j]!=-1){return dp[i][j];}
        
      int up=matrix[i][j]+minSumPathUtil(i-1,j,matrix,dp);
      int left=matrix[i][j]+minSumPathUtil(i,j-1,matrix,dp);
      return dp[i][j]=Math.min(up,left);
      
    } 
    static int minSumPath(int n,int m,int[][] matrix){
        int dp[][]=new int[n][m];
        for(int row[]: dp)
        Arrays.fill(row,-1);
        return minSumPathUtil(n-1,m-1,matrix,dp);
        
    } 
    //*****************************Tabulation********************************************************************** */  
    static int minSumPath(int n,int m,int[][] matrix){
    int dp[][]=new int[n][m];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(i==0&&j==0) {dp[i][j] = matrix[i][j];}
            else{
                int up=matrix[i][j];
                if(i>0) up+=dp[i-1][j];
                else up+=(int)Math.pow(10,9);
                
                int left=matrix[i][j];
                if(j>0) left+=dp[i][j-1];
                else left+=(int)Math.pow(10,9);
                
                dp[i][j]=Math.min(up,left);
            }
        }
    }
    
    return dp[n-1][m-1];
    
}
}

//**********************************DP-11 Triangle******************************************** */
//**********************************DP-12 Minimum/Maximum Falling Path Sum******************************************** */
//**********************************DP-13 Cherry PickUp -II******************************************** */
//**********************************DP-14 Subset Sum Equals Target******************************************** */
//**********************************DP-15 Partition Equal Subset Sum******************************************** */
//**********************************DP-16 Partition A Set into Two Subsets with minimum Difference******************************************** */
//**********************************DP-17 Count Subsets with Sum equals K******************************************** */
//**********************************DP-18 Count Partitions with given difference******************************************** */
//**********************************DP-19 0/1 KnapSack******************************************** */
//**********************************DP-20 Minimum Coins******************************************** */
//**********************************DP-21 Target Sum******************************************** */
//**********************************DP-22 Coin Change II******************************************** */
//**********************************DP-23 Unbounded KnapSack******************************************** */
//**********************************DP-24 Rod Cutting Problem******************************************** */
//**********************************DP-25 Longest Common Subsequence******************************************** */
class TUF{
  static int lcsUtil(String s1,String s2,int ind1,int ind2,int[][] dp){
      if(ind1<0||ind2<0)return 0;
      if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];
      
      if(s1.charAt(ind1)==s2.charAt(ind2))
          return dp[ind1][ind2]=1+lcsUtil(s1,s2,ind1-1,ind2-1,dp);
      else 
          return dp[ind1][ind2]=0+Math.max(lcsUtil(s1,s2,ind1,ind2-1,dp),lcsUtil(s1,s2,ind1-1,ind2,dp));
    }
  static int lcs(String s1, String s2) {
      int n=s1.length();
      int m=s2.length();
      int dp[][]=new int[n][m];
      for(int rows[]: dp)
      Arrays.fill(rows,-1);
      return lcsUtil(s1,s2,n-1,m-1,dp);
  }
  static int lcs(String s1, String s2) {
    int n=s1.length();
    int m=s2.length();
    int dp[][]=new int[n+1][m+1];
    for(int rows[]: dp)
    Arrays.fill(rows,-1);
    for(int i=0;i<=n;i++){
        dp[i][0] = 0;
    }
    for(int i=0;i<=m;i++){
        dp[0][i] = 0;
    }
    for(int ind1=1;ind1<=n;ind1++){
        for(int ind2=1;ind2<=m;ind2++){
            if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
            else
                dp[ind1][ind2]=0+ ath.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
        }
    }
    return dp[n][m];
  }
  static int lcs(String s1, String s2) {
    int n=s1.length();
    int m=s2.length();
    int prev[]=new int[m+1];
    int curr[]=new int[m+1];
    for(int ind1=1;ind1<=n;ind1++){
        for(int ind2=1;ind2<=m;ind2++){
            if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                curr[ind2]=1+prev[ind2-1];
            else
                curr[ind2]=0+Math.max(prev[ind2],cur[ind2-1]);
        }
        prev=(int[])(cur.clone());
    }
    return prev[m];
}
}
//**********************************DP-26 Printing Longest Common Subsequence******************************************** */
class TUF{
  static void lcs(String s1, String s2) {
      int n=s1.length();
      int m=s2.length();
      int dp[][]=new int[n+1][m+1];
      for(int i=0;i<=n;i++){
          dp[i][0] = 0;
      }
      for(int i=0;i<=m;i++){
          dp[0][i] = 0;
      }
      for(int ind1=1;ind1<=n;ind1++){
          for(int ind2=1;ind2<=m;ind2++){
              if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                  dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
              else
                  dp[ind1][ind2]=0+Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
          }
      }
      int len=dp[n][m];
      int i=n;
      int j=m;
      int index = len-1;
      String str="";
      for(int k=1; k<=len;k++){
          str +="$"; // dummy string
      }
      StringBuilder ss= new StringBuilder(s1);
      StringBuilder str2=new StringBuilder(str);
      while(i>0 && j>0){
          if(ss.charAt(i-1)==s2.charAt(j-1)){
              str2.setCharAt(index,ss.charAt(i-1) ); 
              index--;
              i--;
              j--;
          }
          else if(ss.charAt(i-1)>s2.charAt(j-1)){
              i--;
          }
          else j--;
      }
      System.out.println(str2);
    }
}
//**********************************DP-27 Longest Common Substring******************************************** */
class TUF{
  static int lcs(String s1, String s2){
      int n = s1.length();
      int m = s2.length();
      int prev[]=new int[m+1];
      int cur[]=new int[m+1];
      int ans = 0;
      for(int i=1;i<=n;i++){
          for(int j=1;j<=m;j++){
              if(s1.charAt(i-1)==s2.charAt(j-1)){
                  int val=1+prev[j-1];
                  cur[j]=val;
                  ans=Math.max(ans,val);
              }
              else
                  cur[j] = 0;
            }
              prev=cur;
        }
      return ans;
  }
}
//**********************************DP-28 Longest Palindromic Subsequence******************************************** */
class TUF{
  static int lcs(String s1, String s2) {
      int n=s1.length();
      int m=s2.length();
      int dp[][]=new int[n+1][m+1];
      for(int rows[]:dp)
      Arrays.fill(rows,-1);
      for(int i=0;i<=n;i++){
          dp[i][0] = 0;
      }
      for(int i=0;i<=m;i++){
          dp[0][i] = 0;
      }
      for(int ind1=1;ind1<=n;ind1++){
          for(int ind2=1;ind2<=m;ind2++){
              if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                  dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
              else
                  dp[ind1][ind2]=0+Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
          }
      }
      return dp[n][m];
  } 
  static int longestPalindromeSubsequence(String s){
      String t=s;
      String ss=new StringBuilder(s).reverse().toString();
      return lcs(ss,t);
  }
  static int lcs(String s1, String s2) {
    int n=s1.length();
    int m=s2.length();
    int prev[]=new int[m+1];
    int cur[]=new int[m+1];
    for(int ind1=1;ind1<=n;ind1++){
        for(int ind2=1;ind2<=m;ind2++){
            if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                cur[ind2]=1+prev[ind2-1];
            else
                cur[ind2]=0+Math.max(prev[ind2],cur[ind2-1]);
        }
        prev= cur;
    }
    return prev[m];
}
}  
//**********************************DP-29 Minimum Insertions to make string palindrome******************************************** */
class TUF{
  static int lcs(String s1, String s2) {
      int n=s1.length();
      int m=s2.length();
      int dp[][]=new int[n+1][m+1];
      for(int rows[]:dp)
      Arrays.fill(rows,-1);
      for(int i=0;i<=n;i++){
          dp[i][0] = 0;
      }
      for(int i=0;i<=m;i++){
          dp[0][i] = 0;
      }
      for(int ind1=1;ind1<=n;ind1++){
          for(int ind2=1;ind2<=m;ind2++){
              if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                  dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
              else
                  dp[ind1][ind2]=0+Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
          }
      }
      return dp[n][m];
  }
  static int longestPalindromeSubsequence(String s){
      String t = s;
      String ss=new StringBuilder(s).reverse().toString();
      return lcs(ss,t);
  }
  static int minInsertion(String s){
      int n = s.length();
      int k = longestPalindromeSubsequence(s);
      return n-k;
    }
    static int lcs(String s1, String s2) {
      int n=s1.length();
      int m=s2.length();
      int[] prev=new int[m+1];
      int[] cur=new int[m+1];
      for(int ind1=1;ind1<=n;ind1++){
          for(int ind2=1;ind2<=m;ind2++){
              if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                  cur[ind2]=1+prev[ind2-1];
              else
                  cur[ind2]=0+Math.max(prev[ind2],cur[ind2-1]);
          }
          prev = (int[])(cur.clone());
      }
      return prev[m];
  }
  }
//**********************************DP-30 Minimum Insertions/Deletions to convert one string to another******************************************** */
class TUF{
  static int lcs(String s1, String s2) {
      int n=s1.length();
      int m=s2.length();
      int dp[][]=new int[n+1][m+1];
      for(int rows[]: dp)
      Arrays.fill(rows,-1);
      for(int i=0;i<=n;i++){
          dp[i][0] = 0;
      }
      for(int i=0;i<=m;i++){
          dp[0][i] = 0;
      }
      for(int ind1=1;ind1<=n;ind1++){
          for(int ind2=1;ind2<=m;ind2++){
              if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                  dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
              else
                  dp[ind1][ind2]=0+Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
          }
      }
      return dp[n][m];
  }
  static int canYouMake(String str1, String str2){
      int n = str1.length();
      int m = str2.length();
      int k = lcs(str1,str2);
      return (n-k)+(m-k);
  }
  static int lcs(String s1, String s2) {
    int n=s1.length();
    int m=s2.length();
   int[] prev=new int[m+1];
   int[] cur=new int[m+1];
   for(int ind1=1;ind1<=n;ind1++){
       for(int ind2=1;ind2<=m;ind2++){
           if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
               cur[ind2]=1+prev[ind2-1];
           else
               cur[ind2]=0+Math.max(prev[ind2],cur[ind2-1]);
       }
       prev= cur;
   }
   return prev[m];
  }
static int canYouMake(String str1, String str2){
   int n = str1.length();
   int m = str2.length();
   int k = lcs(str1,str2); 
   return (n-k)+(m-k);
  }
}
//**********************************DP-31 Shortest Common SuperSequence******************************************** */
class TUF{
  static String shortestSupersequence(String s1, String s2){
    int n = s1.length();
    int m = s2.length();
    int[][] dp =new int[n+1][m+1];
    for (int i=0;i<=n;i++) {
      dp[i][0]=0;
    }
    for (int i=0;i<=m;i++) {
      dp[0][i]=0;
    }
    for(int ind1=1;ind1<=n;ind1++){
      for(int ind2=1;ind2<=m;ind2++) {
        if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
          dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
        else
          dp[ind1][ind2]=0+Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
      }
    }
    int len = dp[n][m];
    int i = n;
    int j = m;
    int index=len-1;
    String ans = "";
    while (i>0&&j>0) {
      if(s1.charAt(i-1)==s2.charAt(j-1)) {
        ans+=s1.charAt(i-1);
        index--;
        i--;
        j--;
      } 
      else if(dp[i-1][j]>dp[i][j-1]){
          ans+= s1.charAt(i-1);
          i--;
      } 
      else{
          ans+=s2.charAt(j-1);
          j--;
      }
    }
    while(i>0){
        ans+=s1.charAt(i-1);
        i--;
    }
    while(j>0){
        ans+=s2.charAt(j-1);
        j--;
    }
    String ans2=new StringBuilder(ans).reverse().toString();
    return ans2;
  }
}  
//**********************************DP-32 Distinct Subsequences******************************************** */
class TUF{
    static int prime = (int)(Math.pow(10,9)+7);
    static int countUtil(String s1, String s2, int ind1, int ind2,int[][] dp){
        if(ind2<0)return 1;
        if(ind1<0)return 0;
        if(dp[ind1][ind2]!=-1)
            return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            int leaveOne=countUtil(s1,s2,ind1-1,ind2-1,dp);
            int stay=countUtil(s1,s2,ind1-1,ind2,dp);
            return dp[ind1][ind2]=(leaveOne+stay)%prime;
        }
        else{
            return dp[ind1][ind2]=countUtil(s1,s2,ind1-1,ind2,dp);
        }
    }
    
    static int subsequenceCounting(String t, String s, int lt, int ls) {
        int dp[][]=new int[lt][ls];
        for(int rows[]: dp)
        Arrays.fill(rows,-1);
        return countUtil(t,s,lt-1,ls-1,dp);
    }   
        static int subsequenceCounting(String s1, String s2, int n, int m) {
            int dp[][]=new int[n+1][m+1];
            for(int i=0;i<n+1;i++){
                dp[i][0]=1;
            }
            for(int i=1;i<m+1;i++){
                dp[0][i]=0;
            }
            for(int i=1;i<n+1;i++){
                for(int j=1;j<m+1;j++){
                    if(s1.charAt(i-1)==s2.charAt(j-1))
                        dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%prime;
                    else
                        dp[i][j]=dp[i-1][j];
                }
            }
            return dp[n][m];
        } 
    }
//**********************************DP-33 Edit Distance******************************************** */
//**********************************DP-34 Wild Card Matching******************************************** */
//**********************************DP-35 Best Time To Buy and Sell Stocks I******************************************** */
class TUF{
  static int maximumProfit(int []Arr){
    int maxProfit=0;
    int mini=Arr[0];
    for(int i=1;i<Arr.length;i++){
          int curProfit=Arr[i]-mini;
          maxProfit=Math.max(maxProfit,curProfit);
          mini=Math.min(mini,Arr[i]);
        }
    return maxProfit;
  }
}
//**********************************DP-36 Best Time To Buy and Sell Stocks II******************************************** */
class TUF{
  long getAns(long *Arr,int ind,int buy,int n,vector<vector<long>> &dp){
    if(ind==n) return 0; //base case
    if(dp[ind][buy]!=-1)return dp[ind][buy];
    long profit;
    if(buy==0){// We can buy the stock
        profit=max(0+getAns(Arr,ind+1,0,n,dp),-Arr[ind]+getAns(Arr,ind+1,1,n,dp));
    }
    if(buy==1){// We can sell the stock
        profit= max(0+getAns(Arr,ind+1,1,n,dp),Arr[ind]+getAns(Arr,ind+1,0,n,dp));
    }
    return dp[ind][buy] = profit;
  } 
  static long getMaximumProfit(long Arr[], int n)
  {
      long dp[][]=new long[n+1][2];
      for(long row[]: dp)
      Arrays.fill(row,-1);
      dp[n][0] = dp[n][1] = 0;
      long profit=0;
      for(int ind=n-1;ind>=0;ind--){
          for(int buy=0;buy<=1;buy++){
              if(buy==0){// We can buy the stock
                  profit=Math.max(0+dp[ind+1][0],-Arr[ind]+dp[ind+1][1]);
              }
              if(buy==1){// We can sell the stock
                  profit=Math.max(0+dp[ind+1][1],Arr[ind]+dp[ind+1][0]);
              }
              dp[ind][buy]=profit;
          }
      }
      return dp[0][0];
  }
  static long getMaximumProfit(long Arr[], int n)
  {
      long ahead[]=new long[2];
      long cur[] =new long[2];
      ahead[0] = ahead[1] = 0;
      long profit=0;
      for(int ind=n-1;ind>=0;ind--){
          for(int buy=0;buy<=1;buy++){
              if(buy==0){// We can buy the stock
                  profit=Math.max(0+ahead[0],-Arr[ind]+ahead[1]);
              }
              if(buy==1){// We can sell the stock
                  profit=Math.max(0+ahead[1],Arr[ind]+ahead[0]);
              }
              cur[buy]  = profit;
          }
          ahead = (long[])(cur.clone());
      }
      return cur[0];
  }
}
//**********************************DP-37 Best Time To Buy and Sell Stocks III******************************************** */
class TUF{
    int getAns(vector<int>& Arr, int n, int ind, int buy, int cap, vector<vector<vector<int>>>& dp ){
    if(ind==n||cap==0)return 0; //base case
    if(dp[ind][buy][cap]!=-1)return dp[ind][buy][cap];
    int profit;
    if(buy==0){// We can buy the stock
        profit=max(0+getAns(Arr,n,ind+1,0,cap,dp),-Arr[ind]+getAns(Arr,n,ind+1,1,cap,dp));
    }
    if(buy==1){// We can sell the stock
        profit=max(0+getAns(Arr,n,ind+1,1,cap,dp),Arr[ind]+getAns(Arr,n,ind+1,0,cap-1,dp));
    }
    return dp[ind][buy][cap] = profit;
  }
    int maxProfit(vector<int>& prices, int n)
  {
      // Creating a 3d - dp of size [n][2][3]
      vector<vector<vector<int>>> dp(n,vector<vector<int>>(2,vector<int>(3,-1)));
      return getAns(prices,n,0,0,2,dp);
  }
    int Tabulation{
    for(int ind=n-1;ind>=0;ind--){
        for(int buy=0;buy<=1;buy++){
            for(int cap=1;cap<=2;cap++){
                
                if(buy==0){// We can buy the stock
                  dp[ind][buy][cap]=max(0+dp[ind+1][0][cap],-Arr[ind]+dp[ind+1][1][cap]);
                 }
                if(buy==1){// We can sell the stock
                  dp[ind][buy][cap]=max(0+dp[ind+1][1][cap],Arr[ind]+dp[ind+1][0][cap-1]);
                }
            }
        }
    }
    return dp[0][0][2];
  }
    int maxProfit(vector<int>& Arr, int n)
    {
    vector<vector<int>> ahead(2,vector<int> (3,0));
    vector<vector<int>> cur(2,vector<int> (3,0));
    for(int ind=n-1;ind>=0;ind--){
        for(int buy=0;buy<=1;buy++){
            for(int cap=1;cap<=2;cap++){
                if(buy==0){// We can buy the stock
                    cur[buy][cap] = max(0+ahead[0][cap],-Arr[ind]+ahead[1][cap]);
                 }
                if(buy==1){// We can sell the stock
                    cur[buy][cap] = max(0+ahead[1][cap],Arr[ind]+ahead[0][cap-1]);
                }
            }
        }
        ahead = cur;
    }
    return ahead[0][2];
  }
}
}
//**********************************DP-38 Best Time To Buy and Sell Stocks IV******************************************** */
class TUF{
  int getAns(vector<int>& Arr, int n, int ind, int buy, int cap, vector<vector<vector<int>>>& dp ){
    if(ind==n || cap==0)return 0; //base case
    if(dp[ind][buy][cap]!=-1)return dp[ind][buy][cap];
    int profit;
    if(buy==0){// We can buy the stock
        profit=max(0+getAns(Arr,n,ind+1,0,cap,dp),-Arr[ind]+getAns(Arr,n,ind+1,1,cap,dp));
    }
    if(buy==1){// We can sell the stock
        profit=max(0+getAns(Arr,n,ind+1,1,cap,dp),Arr[ind]+getAns(Arr,n,ind+1,0,cap-1,dp));
    }
    return dp[ind][buy][cap] = profit;
  }
  int maximumProfit(vector<int>& prices, int n, int k)
  {
      // Creating a 3d - dp of size [n][2][k+1]
      vector<vector<vector<int>>> dp(n,vector<vector<int>>(2,vector<int>(k+1,-1)));
      return getAns(prices,n,0,0,k,dp);
  }
  int maximumProfit(vector<int>& Arr, int n, int k)
  {
      vector<vector<vector<int>>> dp(n+1,vector<vector<int>(2,vector<int>(k+1,0)));
      for(int ind=n-1;ind>=0;ind--){
          for(int buy=0;buy<=1;buy++){
              for(int cap=1;cap<=k;cap++){
                  if(buy==0){// We can buy the stock
                      dp[ind][buy][cap]=max(0+dp[ind+1][0][cap],-Arr[ind]+dp[ind+1][1][cap]);
                  }
                  if(buy==1){// We can sell the stock
                      dp[ind][buy][cap]=max(0+dp[ind+1][1][cap],Arr[ind]+dp[ind+1][0][cap-1]);
                  }
              }
          }
      }
      return dp[0][0][k];
  }
  int maxProfit(vector<int>& Arr, int n, int k)
  {
      vector<vector<int>> ahead(2,vector<int> (k+1,0));
      vector<vector<int>> cur(2,vector<int> (k+1,0));
      for(int ind=n-1;ind>=0;ind--){
          for(int buy=0;buy<=1;buy++){
              for(int cap=1;cap<=k;cap++){
                  if(buy==0){// We can buy the stock
                      cur[buy][cap]=max(0+ahead[0][cap],-Arr[ind]+ahead[1][cap]);
                  }
                  if(buy==1){// We can sell the stock
                      cur[buy][cap]=max(0+ahead[1][cap],Arr[ind]+ahead[0][cap-1]);
                  }
              }
          }
          ahead = cur;
      }
      return ahead[0][k];
  }
}
}
//**********************************DP-39 Best Time To Buy and Sell Stocks with Cooldown******************************************** */
class TUF{
  static int getAns(int[] Arr, int ind, int buy, int n, int[][] dp ){
      if(ind>=n) return 0; //base case
      if(dp[ind][buy]!=-1)
          return dp[ind][buy];
      int profit=0;
      if(buy==0){// We can buy the stock
      profit=Math.max(0+getAns(Arr,ind+1,0,n,dp),-Arr[ind]+getAns(Arr,ind+1,1,n,dp));
      }
      
      if(buy==1){// We can sell the stock
      profit=Math.max(0+getAns(Arr,ind+1,1,n,dp),Arr[ind]+getAns(Arr,ind+2,0,n,dp));
      }
      return dp[ind][buy] = profit;
  }
  static int stockProfit(int[] Arr)
  {
      int n = Arr.length;
      int dp[][]=new int[n][2];
      for(int row[]: dp)
      Arrays.fill(row,-1);
      int ans = getAns(Arr,0,0,n,dp);
      return ans;
  }
  static int stockProfit(int[] Arr)
  {  
      int n=Arr.length;
      int dp[][]=new int[n+2][2];
      for(int ind =n-1;ind>=0;ind--){
          for(int buy=0;buy<=1;buy++){
              int profit=0;
              if(buy==0){// We can buy the stock
                  profit=Math.max(0+dp[ind+1][0],-Arr[ind]+dp[ind+1][1]);
              }
              if(buy==1){// We can sell the stock
                  profit=Math.max(0+dp[ind+1][1],Arr[ind]+dp[ind+2][0]);
              }       
              dp[ind][buy] = profit;
          }
      }
      return dp[0][0];
  }
  static int stockProfit(int[] Arr)
  {  
      int n = Arr.length;
      int cur[] = new int[2];
      int front1[] = new int[2];
      int front2[] = new int[2];
      for(int ind = n-1;ind>=0;ind--){
          for(int buy=0;buy<=1;buy++){
              int profit=0;
              if(buy==0){// We can buy the stock
                  profit=Math.max(0+front1[0],-Arr[ind]+front1[1]);
              }
              if(buy==1){// We can sell the stock
                  profit=Math.max(0+front1[1],Arr[ind]+front2[0]);
              }   
              cur[buy] = profit;
          }
          front2=(int[])(front1.clone());
          front1=(int [])(cur.clone());
      }
      return cur[0];
  }  
}
  //**********************************DP-40 Buy and Sell Stock with Transaction Fee******************************************** */
class TUF{
  static int getAns(int[] Arr, int ind, int buy, int n, int fee, int[][] dp ){
      if(ind==n) return 0; //base case
      if(dp[ind][buy]!=-1)return dp[ind][buy];
      int profit=0;
      if(buy==0){// We can buy the stock
          profit = Math.max(0+getAns(Arr,ind+1,0,n,fee,dp),-Arr[ind]+getAns(Arr,ind+1,1,n,fee,dp));
      }
      if(buy==1){// We can sell the stock
          profit = Math.max(0+getAns(Arr,ind+1,1,n,fee,dp),Arr[ind]-fee+getAns(Arr,ind+1,0,n,fee,dp));
      }
      return dp[ind][buy] = profit;
  }
  static int maximumProfit(int n, int fee, int[] Arr)
  {
      int dp[][]= new int[n][2];
      for(int row[]: dp)
      Arrays.fill(row,-1);
      if(n==0) return 0;
      int ans = getAns(Arr,0,0,n,fee,dp);
      return ans;
  }
  static int maximumProfit(int n, int fee, int[] Arr)
  {
      if(n==0) return 0;
    int dp[][]=new int[n+1][2];
      for(int ind=n-1;ind>=0;ind--){
        for(int buy=0; buy<=1;buy++){
            int profit=0;
            if(buy==0){// We can buy the stock
                profit=Math.max(0+dp[ind+1][0],-Arr[ind]+dp[ind+1][1]);
            }
            if(buy==1){// We can sell the stock
                profit=Math.max(0+dp[ind+1][1],Arr[ind]-fee+dp[ind+1][0]);
            }
            dp[ind][buy]=profit;
        }
    }
    return dp[0][0];
}
  static long maximumProfit(int n, int fee, int[] Arr)
{
    if(n==0) return 0;
    long ahead[]=new long[2];
    long cur[]=new long[2];
    ahead[0]=ahead[1]=0;
    long profit=0;
    for(int ind=n-1;ind>=0;ind--){
        for(int buy=0;buy<=1;buy++){
            if(buy==0){// We can buy the stock
                profit=Math.max(0+ahead[0],-Arr[ind]+ahead[1]);
            }
            if(buy==1){// We can sell the stock
                profit=Math.max(0+ahead[1],Arr[ind]-fee+ahead[0]);
            }
            cur[buy]  = profit;
        }
        ahead = (long[])(cur.clone());
    }
    return cur[0];
}
}
//**********************************DP-41 Longest Increasing Subsequence|Memoization******************************************** */
class TUF{
  static int f(ind,prev_index){
    notTake=0+f(ind+1,prev_index)
    if(prev_index==-1||arr[ind]>arr[prev_index]){
        take=1+f(ind+1,ind);
      }
  }
  static int f(ind,prev_index){
    if(ind==n)
        return 0;
    notTake=0+ f(ind+1,prev_index)
    if(prev_index==-1||arr[ind]>arr[prev_index]){
        take=1+f(ind + 1, ind)
    }
    return max(notTake, take)
  }
  static int getAns(int arr[],int n, int ind,int prev_index,int[][] dp){
      if(ind==n)
          return 0; 
      if(dp[ind][prev_index+1]!=-1)
          return dp[ind][prev_index+1];
      int notTake=0+getAns(arr,n,ind+1,prev_index,dp);
      int take=0;
      if(prev_index==-1||arr[ind]>arr[prev_index]){
          take=1+getAns(arr,n,ind+1,ind,dp);
      }
      return dp[ind][prev_index+1]=Math.max(notTake,take);
  }
  
  static int longestIncreasingSubsequence(int arr[], int n){
      int dp[][]=new int[n][n+1];
      for(int row[]: dp)
      Arrays.fill(row,-1);
      return getAns(arr,n,0,-1,dp);
  }
}
//**********************************DP-42 Printing Longest Increasing Subsequence******************************************** */
class TUF{
  //****************Tabulation LIS********************** */
  static int longestIncreasingSubsequence(int arr[],int n){
      int dp[][]=new int[n+1][n+1];
      for(int ind=n-1;ind>=0;ind--){
          for(int prev_index=ind-1;prev_index >=-1;prev_index--){
              int notTake =0+dp[ind+1][prev_index+1];
              int take=0;
              if(prev_index==-1||arr[ind]>arr[prev_index]){
                  take=1+dp[ind+1][ind+1];
              }
              dp[ind][prev_index+1] = Math.max(notTake,take);
          }
      }
      return dp[0][0];
  }
  static int longestIncreasingSubsequence(int arr[],int n){
    int next[]=new int[n+1];
    int curr[]=new int[n+1];
    
    for(int ind=n-1;ind>=0;ind--){
        for (int prev_index=ind-1;prev_index >=-1;prev_index--){
            int notTake=0+next[prev_index+1];
            int take=0;
            if(prev_index==-1||arr[ind]>arr[prev_index]){
                take=1+next[ind+1];
            }
            curr[prev_index+1]=Math.max(notTake,take);
        }
        next = curr.clone();
    }
    return cur[0];
  }
  static int longestIncreasingSubsequence(int arr[],int n){
  int dp[]=new int[n];
  Arrays.fill(dp,1);
  for(int i=0;i<=n-1;i++){
      for(int prev_index=0;prev_index<=i-1;prev_index++){
          if(arr[prev_index]<arr[i]){
              dp[i] = Math.max(dp[i],1+dp[prev_index]);
          }
      }
  }
  int ans=-1;
  for(int i=0;i<=n-1;i++){
      ans=Math.max(ans, dp[i]);
  }
  return ans
}
  static int longestIncreasingSubsequence(int arr[],int n){
  int[] dp=new int[n];
  Arrays.fill(dp,1);
  int[] hash=new int[n];
  Arrays.fill(hash,1);
  
  for(int i=0;i<=n-1;i++){
      hash[i] = i; // initializing with current index
      for(int prev_index = 0;prev_index<=i-1;prev_index++){          
          if(arr[prev_index]<arr[i]&&1 + dp[prev_index]>dp[i]){
              dp[i]=1+dp[prev_index];
              hash[i]=prev_index;
          }
      }
  }
  int ans = -1;
  int lastIndex =-1;
  
  for(int i=0;i<=n-1;i++){
      if(dp[i]>ans){
          ans=dp[i];
          lastIndex=i;
      }
  }
  ArrayList<Integer> temp=new ArrayList<>();
  temp.add(arr[lastIndex]);
  while(hash[lastIndex]!=lastIndex){ // till not reach the initialization value
      lastIndex=hash[lastIndex];
      temp.add(arr[lastIndex]);    
  }
  System.out.print("The subsequence elements are ");  
  for(int i=temp.size()-1;i>=0;i--){
      System.out.print(temp.get(i)+" ");
  }
  System.out.println();
  return ans;
}
}
//**********************************DP-43 Longest Increasing Subsequence|Binary Search******************************************** */
class TUF{
  int getAns(int arr[],int n,int ind,int prev_index,int[][] dp){    
    if(ind==n)
        return 0;
    if(dp[ind][prev_index+1]!=-1)
        return dp[ind][prev_index+1];
    int notTake=0+getAns(arr,n,ind+1,prev_index,dp);
    int take = 0;
    if(prev_index==-1||arr[ind]>arr[prev_index]){
        take=1+getAns(arr,n,ind+1,ind,dp);
    }
    return dp[ind][prev_index+1] = max(notTake,take);
}
int longestIncreasingSubsequence(int arr[],int n){
    vector<int> temp;
    temp.push_back(arr[0]);
    int len=1;
    for(int i=1;i<n;i++){
        if(arr[i]>temp.back()){
           temp.push_back(arr[i]);
           len++;
        } 
        else{
            int ind=lower_bound(temp.begin(),temp.end(),arr[i])-temp.begin();
            temp[ind]=arr[i];
        }
    }
    return len;
  }
}
//**********************************DP-44 Largest Divisible Subset******************************************** */
class TUF{
  vector<int> divisibleSet(vector<int>& arr){
    int n=arr.size();
    sort(arr.begin(),arr.end());
    vector<int> dp(n,1);
    vector<int> hash(n,1);
    for(int i=0;i<=n-1;i++){
        hash[i]=i; // initializing with current index
        for(int prev_index = 0;prev_index <=i-1;prev_index ++){          
            if(arr[i]%arr[prev_index]==0&&1+dp[prev_index]>dp[i]){
                dp[i]=1+dp[prev_index];
                hash[i]=prev_index;
            }
        }
    }
    int ans = -1;
    int lastIndex =-1;
    for(int i=0;i<=n-1;i++){
        if(dp[i]>ans){
            ans=dp[i];
            lastIndex=i;
        }
    }
    vector<int> temp;
    temp.push_back(arr[lastIndex]);
    while(hash[lastIndex]!=lastIndex){ // till not reach the initialization value
        lastIndex=hash[lastIndex];
        temp.push_back(arr[lastIndex]);    
    }
    reverse(temp.begin(),temp.end());
    return temp;
    }
}
}
//**********************************DP-45 Longest String chain******************************************** */
class TUF{
  bool compare(string &s1,string &s2){
    if(s1.size()!=s2.size()+1) return false;
    int first = 0;
    int second = 0;
    while(first<s1.size()){
        if(second<s2.size()&&s1[first]==s2[second]){
            first++;
            second++;
        }
        else first++;
    }
    if(first==s1.size()&&second==s2.size()) return true;
    else return false; 
  }

  bool comp(string &s1,string &s2){
    return s1.size()<s2.size();
  }


int longestStrChain(vector<string>& arr){
  int n=arr.size();
  sort(arr.begin(),arr.end(),comp);
  vector<int> dp(n,1);
  int maxi = 1;
  for(int i=0;i<=n-1;i++){
      for(int prev_index=0;prev_index<=i-1;prev_index++){
          if(compare(arr[i],arr[prev_index])&&1+dp[prev_index]>dp[i]){
              dp[i]=1+dp[prev_index];
          }
      }
      if(dp[i]>maxi)
          maxi=dp[i];
  }
  return maxi;
  }
}
}
//**********************************DP-46 Longest Bitonic Sequence******************************************** */
class TUF{
  static int longestBitonicSequence(int[] arr,int n){
      int[] dp1=new int[n];
      int[] dp2=new int[n];
      Arrays.fill(dp1,1);
      Arrays.fill(dp2,1);
      for(int i=0;i<=n-1;i++){
          for(int prev_index =0;prev_index<=i-1;prev_index++){
              if(arr[prev_index]<arr[i]){
                  dp1[i] = Math.max(dp1[i],1+dp1[prev_index]);
              }
          }
      }
      for(int i=n-1;i>=0;i--){
          for(int prev_index=n-1;prev_index>i;prev_index--){
              if(arr[prev_index]<arr[i]){
                  dp2[i]=Math.max(dp2[i],1+dp2[prev_index]);
              }
          }
      }
      int maxi=-1;
      for(int i=0;i<n;i++){
          maxi=Math.max(maxi,dp1[i]+dp2[i]-1);
      }
      return maxi;
  }
}
//**********************************DP-47 Number of Longest Increasing Subsequence******************************************** */
class TUF{
  static int findNumberOfLIS(int[] arr){
      int n=arr.length;
      int[] dp=new int[n];
      int[] ct=new int[n];
      Arrays.fill(dp,1);
      Arrays.fill(ct,1);
      int maxi=1;
      for(int i=0;i<=n-1;i++){
          for(int prev_index=0;prev_index<=i-1;prev_index++){
              if(arr[prev_index]<arr[i]&&dp[prev_index]+1>dp[i]){
                  dp[i]=dp[prev_index]+1;
                  ct[i]=ct[prev_index];
              }
              else if(arr[prev_index]<arr[i]&&dp[prev_index]+1==dp[i]){
                  ct[i]=ct[i]+ct[prev_index];
              }
          }
          maxi=Math.max(maxi,dp[i]);
      }
      int nos=0;
      for(int i=0;i<=n-1;i++){
        if(dp[i]==maxi) 
            nos+=ct[i];
        }
      return nos;
    }
}
//**********************************DP-48 Matrix Change Multiplication******************************************** */
class TUF{
  static int f(int[] arr,int i,int j){
      if(i==j)
          return 0;
      int mini = Integer.MAX_VALUE;
      for(int k=i;k<=j-1;k++){
          int ans=f(arr,i,k)+f(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
          mini=Math.min(mini,ans);
      }
      return mini;
  }
  static int matrixMultiplication(int[] arr,int N){   
      int i=1;
      int j=N-1;
      return f(arr,i,j);
    }
  static int f(int arr[],int i,int j,int[][] dp){
      if(i==j)
          return 0;
      if(dp[i][j]!=-1)
          return dp[i][j];
      int mini = Integer.MAX_VALUE;
      for(int k=i;k<=j-1;k++){
      int ans=f(arr,i,k,dp)+f(arr, k+1,j,dp)+arr[i-1]*arr[k]*arr[j];
      mini = Math.min(mini,ans);
      }
      return mini;
  }
 }
//**********************************DP-49 Matrix Change Multiplication|Bottom Up******************************************** */
class TUF{
  static int matrixMultiplication(int[] arr, int N){
      int [][] dp=new int[N][N];
      for(int row[]: dp)
      Arrays.fill(row,-1);
      for(int i=1;i<N;i++){
          dp[i][i] = 0;
      }
      for(int i=N-1;i>=1;i--){
          for(int j=i+1;j<N;j++){
              int mini = Integer.MAX_VALUE;
              for(int k=i;k<=j-1;k++){
                  int ans=dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j];
                  mini = Math.min(mini,ans);
              }
              dp[i][j] = mini;
          }
      }
      return dp[1][N-1];
      }
}
//**********************************DP-50 Minimum Cost to Cut the Rod******************************************** */
class TUF{
  int f(int i,int j,vector<int> &cuts){
    if(i>j)
        return 0;
    int mini = INT_MAX;
    for(int ind=i; ind<=j; ind++){
        int ans = cuts[j+1]-cuts[i-1]+f(i,ind-1,cuts)+f(ind+1,j,cuts);
        mini = min(mini, ans);
    }
    return mini;
  }
  int cost(int n,int c,vector<int> &cuts){
    cuts.push_back(n);
    cuts.insert(cuts.begin(),0);
    sort(cuts.begin(),cuts.end());
    return f(1,c,cuts);
  }
  int f(int i,int j,vector<int> &cuts,vector<vector<int>> &dp){
    if(i>j)return 0;
    if(dp[i][j]!=-1)return dp[i][j];
    int mini=INT_MAX;
    for(int ind=i;ind<=j;ind++){
        int ans=cuts[j+1]-cuts[i-1]+f(i,ind-1,cuts,dp)+f(ind+1,j,cuts,dp);
        mini = min(mini, ans);
    }
    return dp[i][j]=mini;
}


int cost(int n,int c,vector<int> &cuts){
  cuts.push_back(n);
  cuts.insert(cuts.begin(),0);
  sort(cuts.begin(),cuts.end());
  vector<vector<int>> dp(c+1,vector<int>(c+1,-1));
  return f(1,c,cuts,dp);
}

int cost(int n, int c, vector<int> &cuts){
  cuts.push_back(n);
  cuts.insert(cuts.begin(),0);
  sort(cuts.begin(),cuts.end());
  vector<vector<int>> dp(c+2,vector<int>(c+2,0));
  for(int i=c;i>=1;i--){
      for(int j=1;j<=c;j++){
          if(i>j) continue;
          int mini = INT_MAX;
          for(int ind=i; ind<=j; ind++){
              int ans=cuts[j+1]-cuts[i-1]+dp[i][ind-1]+dp[ind+1][j];
              mini=min(mini, ans);
          }
          dp[i][j] = mini;
      }
  }
  return dp[1][c];
}
}
}
//**********************************DP-51 Burst Balloons******************************************** */
//**********************************DP-52 Evaluate Boolean Expression to True******************************************** */
//**********************************DP-53 Palindrome Partitioning II******************************************** */
//**********************************DP-54 Partition Array for Maximum Sum******************************************** */
//**********************************DP-55 Maximum Rectangle Area with All 1's******************************************** */
//**********************************DP-56 Count Square SubMatrices with All 1's******************************************** */


//********************************PART II FINAL CODES************************************************************** */
//**********************************DP-1 Introduction to Dynamic Programming*******************************************/  
//**********************************DP-2 Climbing Stairs***************************************************************/  
//**********************************DP-3 Frog Jump**********************************************************************/  
//**********************************DP-4 Frog Jump with K Distance******************************************************/  
//**********************************DP-5 Maximum Sum of Non Adjacent Elements*******************************************/  
//**********************************DP-6 House Robber*******************************************************************/  
//**********************************DP-7 Ninja Training*****************************************************************/  
//**********************************DP-8 Grid Unique Paths**************************************************************/  
//**********************************DP-9 Grid Unique Paths with Obstacles***********************************************/  
//**********************************DP-10 Minimum Path Sum in Grid******************************************************/
//**********************************DP-11 Triangle******************************************** */
//**********************************DP-12 Minimum/Maximum Falling Path Sum******************************************** */
//**********************************DP-13 Cherry PickUp -II******************************************** */
//**********************************DP-14 Subset Sum Equals Target******************************************** */
//**********************************DP-15 Partition Equal Subset Sum******************************************** */
//**********************************DP-16 Partition A Set into Two Subsets with minimum Difference******************************************** */
//**********************************DP-17 Count Subsets with Sum equals K******************************************** */
//**********************************DP-18 Count Partitions with given difference******************************************** */
//**********************************DP-19 0/1 KnapSack******************************************** */
//**********************************DP-20 Minimum Coins******************************************** */
//**********************************DP-21 Target Sum******************************************** */
//**********************************DP-22 Coin Change II******************************************** */
//**********************************DP-23 Unbounded KnapSack******************************************** */
//**********************************DP-24 Rod Cutting Problem******************************************** */
//**********************************DP-25 Longest Common Subsequence******************************************** */
//**********************************DP-26 Printing Longest Common Subsequence******************************************** */
//**********************************DP-27 Longest Common Substring******************************************** */
//**********************************DP-28 Longest Palindromic Subsequence******************************************** */
//**********************************DP-29 Minimum Insertions to make string palindrome******************************************** */
//**********************************DP-30 Minimum Insertions/Deletions to convert one string to another******************************************** */
//**********************************DP-31 Shortest Common SuperSequence******************************************** */
//**********************************DP-32 Distinct Subsequences******************************************** */
//**********************************DP-33 Edit Distance******************************************** */
//**********************************DP-34 Wild Card Matching******************************************** */
//**********************************DP-35 Best Time To Buy and Sell Stocks I******************************************** */
//**********************************DP-36 Best Time To Buy and Sell Stocks II******************************************** */
//**********************************DP-37 Best Time To Buy and Sell Stocks III******************************************** */
//**********************************DP-38 Best Time To Buy and Sell Stocks IV******************************************** */
//**********************************DP-39 Best Time To Buy and Sell Stocks with Cooldown******************************************** */
//**********************************DP-40 Buy and Sell Stock with Transaction Fee******************************************** */
//**********************************DP-41 Longest Increasing Subsequence|Memoization******************************************** */
//**********************************DP-42 Printing Longest Increasing Subsequence******************************************** */
//**********************************DP-43 Longest Increasing Subsequence|Binary Search******************************************** */
//**********************************DP-44 Largest Divisible Subset******************************************** */
//**********************************DP-45 Longest String chain******************************************** */
//**********************************DP-46 Longest Bitonic Sequence******************************************** */
//**********************************DP-47 Number of Longest Increasing Subsequence******************************************** */
//**********************************DP-48 Matrix Change Multiplication******************************************** */
//**********************************DP-49 Matrix Change Multiplication|Bottom Up******************************************** */
//**********************************DP-50 Minimum Cost to Cut the Rod******************************************** */
//**********************************DP-51 Burst Balloons******************************************** */
//**********************************DP-52 Evaluate Boolean Expression to True******************************************** */
//**********************************DP-53 Palindrome Partitioning II******************************************** */
//**********************************DP-54 Partition Array for Maximum Sum******************************************** */
//**********************************DP-55 Maximum Rectangle Area with All 1's******************************************** */
//**********************************DP-56 Count Square SubMatrices with All 1's******************************************** */

