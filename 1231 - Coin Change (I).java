import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int dp[][] = new int[55][1005];
	static final int MD = 100000007;

	static int solve(int arr[], int freq[], int N, int K, int pos, int sum) {
		if (pos == N) {
			return (sum == K) ? 1 : 0;
		}
		if (sum == K) {
			return 1;
		}
		if (dp[pos][sum] != -1) {
			return dp[pos][sum];
		}
		int ret = 0;
		for (int i = 1; i <= freq[pos]; i++) {
			if (sum + arr[pos] * i <= K) {
				ret += solve(arr, freq, N, K, pos + 1, sum + arr[pos] * i) % MD;
				ret %= MD;
			} else
				break;
		}
		ret += solve(arr, freq, N, K, pos + 1, sum);
		ret %= MD;
		return dp[pos][sum] = ret;
	}

	public static void main(String args[]) {
		Scanner ob = new Scanner(System.in);
		int T = ob.nextInt();
		for (int cs = 1; cs <= T; cs++) {
			int N = ob.nextInt();
			int K = ob.nextInt();
			int arr[] = new int[N];
			int freq[] = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = ob.nextInt();
			for (int i = 0; i < N; i++)
				freq[i] = ob.nextInt();
			for (int i = 0; i < N; i++)
				for (int j = 0; j < K; j++)
					dp[i][j] = -1;
			Arrays.sort(arr);
			int ans = solve(arr, freq, N, K, 0, 0);
			System.out.println("Case " + cs + ": " + ans);
		}
		ob.close();
	}
}
