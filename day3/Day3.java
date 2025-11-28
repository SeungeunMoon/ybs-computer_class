import java.io.*;
import java.util.*;

public class Day3 {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=10; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			List<Integer> codes = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int each = Integer.parseInt(st.nextToken());
				codes.add(each);
			}
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M;i++) {
				String cmd = st.nextToken();
				switch(cmd) {
				case "I":
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y;j++) {
						codes.add(x+j, Integer.parseInt(st.nextToken()));
					}
					break;
				case "D":
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y;j++) {
						codes.remove(x);
					}
					break;
				case "A":
					y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y;j++) {
						codes.add(Integer.parseInt(st.nextToken()));
					}
					break;
				}
			}
			sb.append("#").append(tc).append(" ");
			for(int i=0; i<10;i++) {
				sb.append(codes.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
