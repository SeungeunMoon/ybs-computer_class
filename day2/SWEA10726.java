import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean isOn = true;
			int check = (1 << N) - 1;
			if ((M & check) != check) isOn = false; 
			if (isOn) 
				sb.append("#").append(t).append(" ").append("ON").append("\n");
			else 
				sb.append("#").append(t).append(" ").append("OFF").append("\n");
		}
		System.out.println(sb.toString());
	}
}
