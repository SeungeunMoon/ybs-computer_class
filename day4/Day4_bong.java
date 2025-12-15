import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Day4_bong {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sbP = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				if(cmd == 'I') {
					int pos = Integer.parseInt(st.nextToken());
					int val = Integer.parseInt(st.nextToken());
					list.add(pos, val);
				} else if(cmd == 'D') {
					int pos = Integer.parseInt(st.nextToken());
					list.remove(pos);
				}  else if(cmd == 'C') {
					int pos = Integer.parseInt(st.nextToken());
					int val = Integer.parseInt(st.nextToken());
					list.set(pos, val);
				}
			}
			sbP.append("#").append(t).append(" ");
			if(list.size() < L) {
				sbP.append(-1);
			} else {
				sbP.append(list.get(L));
			}
			sbP.append("\n");
		}
		System.out.println(sbP);
	}
}
