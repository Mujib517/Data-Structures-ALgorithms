package Questions.DP_15;

public class CoinChange1 {
    public static void main(String[] args) {
        int[]a={1,2,5};
        int K=11;
        if(minCoins(a,K)==Integer.MAX_VALUE/2)
            System.out.println(-1);
        else
            System.out.println(minCoins(a,K));
    }
    static int minCoins(int[]a,int K){
        int N=a.length;
        int[][]dp=new int[N+1][K+1];
        for(int i=0;i<=K;i++)
            dp[0][i]=Integer.MAX_VALUE/2;
        for(int i=1;i<=N;i++)
            dp[i][0]=0;
        for(int i=1;i<=K;i++){
            if(a[0]%i==0)
                dp[1][i]=1;
            else
                dp[1][i]=Integer.MAX_VALUE/2;
        }
        for(int i=2;i<=N;i++){
            for(int j=1;j<=K;j++){
                if(j>=a[i-1])
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-a[i-1]]+1);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
            return dp[N][K];
    }
}
