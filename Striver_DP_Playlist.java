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


}
