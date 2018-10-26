import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
 
    static int dp[] = new int[10005];
    static final int MD = 100000007;
 
    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        int T = ob.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int N = ob.nextInt();
            int K = ob.nextInt();
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = ob.nextInt();
            for (int i = 0; i <= K; i++) dp[i] = 0;
            Arrays.sort(arr);
            dp[0] = 1;
            for(int i = 0 ; i < N ; i++) {
                for(int j = 1 ; j <= K ; j++) {
                    if( j - arr[i] >= 0) dp[j] = ( dp[ j - arr[i] ] + dp[j] ) % MD;
                }
            }
            System.out.println("Case " + cs + ": " + dp[K]);
        }
        ob.close();
    }
}
