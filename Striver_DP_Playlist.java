public class Striver_DP_Playlist {
 //*******************************DP-7 Introduction to Dynamic Programming*******************************************/  
 //*******************************DP-2 Climbing Stairs***************************************************************/  
 //*******************************DP-3 Frog Jump**********************************************************************/  
 //*******************************DP-4 Frog Jump with K Distance******************************************************/  
 //*******************************DP-5 Maximum Sum of Non Adjacent Elements*******************************************/  
 //*******************************DP-6 House Robber*******************************************************************/  
 //*******************************DP-7 Ninja Training*****************************************************************/  
 //*******************************DP-8 Grid Unique Paths**************************************************************/  
 class Solution{
    //************Memoization***************** */
    class Solution{
    public static int UniquePaths(int row,int col,int dp[][]){
        if(row==0&&col==0){
            return 1;
        }
        if(row<0||col<0){
            return 0;
        }
        if(dp[row][col]!=-1)return dp[row][col];
        int up=UniquePaths(row-1,col,dp);
        int left=UniquePaths(row,col-1,dp);
        
        return dp[row][col]=up+left;
    }
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int dp[][]=new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                dp[i][j]=-1;
            }
        }
        dp[0][0]=1;
        int ans=UniquePaths(a-1,b-1,dp);
        return dp[a-1][b-1];
    }
}
    //************Tabulation****************** */
    class Solution{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        int dp[][]=new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                dp[i][j]=0;
            }
        }
        
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(i==0&&j==0)dp[i][j]=1;
                else{
                    int up=0;
                    int left=0;
                    if(i>0){up=dp[i-1][j];}
                    if(j>0){left=dp[i][j-1];}
                    dp[i][j]=up+left;
                }
            }
        }
        
        return dp[a-1][b-1];
    }
}
 } 
 //*******************************DP-9 Grid Unique Paths with Obstacles***********************************************/  
 class Solution{
    //************Memoization***************** */
    class Solution{
    public static int UniquePaths(int row,int col,int dp[][],int matrix[][]){
        //**************Add condition in base case********* */
        if(matrix[row][col]==0){return 0;}
        if(row==0&&col==0){
            return 1;
        }
        if(row<0||col<0){
            return 0;
        }
        if(dp[row][col]!=-1)return dp[row][col];
        int up=UniquePaths(row-1,col,dp);
        int left=UniquePaths(row,col-1,dp);
        
        return dp[row][col]=up+left;
    }
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b,int matrix[][]) 
    {
        //Your code here
        int dp[][]=new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                dp[i][j]=-1;
            }
        }
        dp[0][0]=1;
        int ans=UniquePaths(a-1,b-1,dp,matrix);
        return dp[a-1][b-1];
    }
}
    //************Tabulation****************** */
    class Solution{
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b,int matrix[][]) 
    {
        //Your code here
        int dp[][]=new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                dp[i][j]=0;
            }
        }
        
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(i==0&&j==0)dp[i][j]=1;
                else if(matrix[i][j]==0){dp[i][j]=0;}
                else{
                    int up=0;
                    int left=0;
                    if(i>0){up=dp[i-1][j];}
                    if(j>0){left=dp[i][j-1];}
                    dp[i][j]=up+left;
                }
            }
        }
        
        return dp[a-1][b-1];
    }
}
 }
}
