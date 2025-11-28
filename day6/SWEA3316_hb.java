import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int answer, N;
	static String masters;
	static int MOD = 1000000007;
	static boolean[] possible;
	static int[][] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			masters = br.readLine().trim();
			N = masters.length();
			memo = new int[N][16];
			
			// 첫날 설정
			int firstmanager = 1 << (masters.charAt(0) - 'A');;
			int firstprev = 1;
			for (int mask = 1; mask < 16; mask++) {
				if ((firstprev & mask) == 0) continue;
				if ((mask & firstmanager) == 0) continue;
				memo[0][mask] = 1;
			}

			// 2 - N 날 설정
			for (int day = 1; day < N; day++) {
				int curmanager = 1 << (masters.charAt(day) - 'A');
				for (int prev = 1; prev < 16; prev++) { // 전날을 비교
					if (memo[day-1][prev] == 0) continue; 
					for (int mask = 1; mask < 16; mask++) { // 다음날이 적합한지 확인
						if ((prev & mask) == 0) continue;
						if ((mask & curmanager) == 0) continue;
						memo[day][mask] = (memo[day][mask] + memo[day-1][prev]) % MOD;
					}
				}
			}
			
			int answer = 0;
			for (int i = 1; i < 16; i++) {
				answer = (answer + memo[N-1][i]) % MOD;
			}

			bw.write("#" + tc + " " + answer + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}

}
