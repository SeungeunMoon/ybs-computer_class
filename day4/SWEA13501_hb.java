import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken()); // 수열의 길이 (5 - 1000)
			int M = Integer.parseInt(st.nextToken()); // 추가 횟수 (1 - 1000)
			int L = Integer.parseInt(st.nextToken()); // 인덱스 번호 (6 - N+M)

			st = new StringTokenizer(br.readLine().trim());
			LinkedList<Integer> input = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				input.add(Integer.parseInt(st.nextToken()));
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				char cmd = st.nextToken().charAt(0);
				if (cmd == 'I') {
					int pos = Integer.parseInt(st.nextToken());
					int val = Integer.parseInt(st.nextToken());
					input.add(pos, val);
				} else if (cmd == 'D') {
					int pos = Integer.parseInt(st.nextToken());
					input.remove(pos);
				} else if (cmd == 'C') {
					int pos = Integer.parseInt(st.nextToken());
					int val = Integer.parseInt(st.nextToken());
					input.set(pos, val);
				}
			}
			if (input.size() < L) {
				bw.write("#" + tc + " " + (-1) + "\n");
			} else {
				bw.write("#" + tc + " " + input.get(L) + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}