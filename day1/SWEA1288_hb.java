import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());//

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());// 1 - 10^6
			int curVal = N;
			answer = 0;
			int bitMask = 0;

			shoot: while (true) {
				int tmp = curVal; // 임시로 값을 저장
				while (tmp > 0) {
					int mask = tmp % 10;
					bitMask = bitMask | (1 << mask); // 순회하며 비트마스크에 기록
					tmp /= 10;
				}
				answer++;
				if (bitMask == ((1 << 10) - 1)) // 다 기록되었다면 탈출
					break shoot;
				curVal += N;
			}

			bw.write("#" + tc + " " + curVal + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}