public class Striver_DP_Playlist {
 //*******************************DP-7 Introduction to Dynamic Programming*******************************************/  
 //*******************************DP-2 Climbing Stairs***************************************************************/  
 //*******************************DP-3 Frog Jump**********************************************************************/  
 //*******************************DP-4 Frog Jump with K Distance******************************************************/  
 //*******************************DP-5 Maximum Sum of Non Adjacent Elements*******************************************/  
 //*******************************DP-6 House Robber*******************************************************************/  
 //*******************************DP-7 Ninja Training*****************************************************************/  
 //*******************************DP-8 Grid Unique Paths**************************************************************/  
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
 //*******************************DP-9 Grid Unique Paths with Obstacles***********************************************/  
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
    //****************************DP-10 Minimum Path Sum in Grid******************************************************/
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
}
