import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day1_bong_swea1288 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			Set<Integer> set = new HashSet<>();
			
			int cnt = 1;
			int A = 0;
			StringBuilder sb = new StringBuilder();
			while(set.size()!=10) {
				A = N*cnt;
				sb.append(A);
				for(int i = 0; i < sb.length(); i++) {
					set.add(sb.charAt(i)-'0');
				}
				sb.setLength(0);
				cnt++;
			}
			
			
			System.out.println("#" + t + " " + A);
		} // 테스트케이스 for문
	}
}
