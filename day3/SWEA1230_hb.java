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

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine().trim()); // 원본 암호문 개수 (2000 - 4000)
			st = new StringTokenizer(br.readLine().trim());
			LinkedList<Integer> input = new LinkedList<>();
			input.add(0);
			for (int i = 0; i < N; i++) {
				input.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine().trim()); // 명령어 개수 (250 - 500)

			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < M; i++) {
				char cmd = st.nextToken().charAt(0);
				if (cmd == 'I') {
					int start = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					for (int j = 1; j < num + 1; j++) {
						input.add(start + j, Integer.parseInt(st.nextToken()));
					}

				} else if (cmd == 'D') {
					int start = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					for (int j = 0; j < num; j++) {
						input.remove(start);
					}
				} else if (cmd == 'A') {
					int start = Integer.parseInt(st.nextToken());
					for (int j = 0; j < start; j++) {
						input.addLast(Integer.parseInt(st.nextToken()));
					}
				}
			}
			bw.write("#" + tc + " " );
			for (int i = 1; i <= 10; i++) {
				bw.write(input.get(i) + " ");
			} bw.newLine();

		}

		bw.flush();
		bw.close();
		br.close();
	}

}