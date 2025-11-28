import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Day3_jaebong_swea1230 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			// 원본 암호문 개수
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			list.add(0);
			
			// 원본 입력
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			// 멸령어 개수
			int M = Integer.parseInt(br.readLine());
			
			// 명령어
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				char op = st.nextToken().charAt(0);
				
				if(op == 'I') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; j++) {
						list.add(x+1+j, Integer.parseInt(st.nextToken()));
					}
				} else if(op == 'D') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; j++) {
						list.remove(x);
					}
				} else if(op == 'A') {
					int y = Integer.parseInt(st.nextToken());
					for(int j = 0; j < y; j++) {
						list.addLast(Integer.parseInt(st.nextToken()));
					}
				}
			}
			sb = new StringBuilder();
			
			sb.append("#" + t + " ");
			for(int i = 1; i <= 10; i++) {
				sb.append(list.get(i) + " ");
			}
			System.out.println(sb);
		}
	}
}
