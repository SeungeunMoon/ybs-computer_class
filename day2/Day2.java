import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int mask = (1 << N) - 1;

            if ((M & mask) == mask) {
                System.out.println("#" + tc + " ON");
            } else {
                System.out.println("#" + tc + " OFF");
            }
        }
    }
}

// public class Day2 {
	
// 	static String ans;
// 	static int N,M;

// 	public static void main(String[] args) throws IOException {

// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int T = Integer.parseInt(br.readLine());

// 		for (int tc = 1; tc <= T; tc++) {
// 			StringTokenizer st = new StringTokenizer(br.readLine());
// 			N = Integer.parseInt(st.nextToken());
// 			M = Integer.parseInt(st.nextToken());
			
// 			List<Integer> bits = new ArrayList<>();
			
// 			if(M == 1) {
// 				bits = new ArrayList<>(Arrays.asList(1));
// 			}
// 			while(M > 1) {
// 				bits.add(M%2);
// 				if(M < 4) bits.add(M/2);
// 				M /= 2;
// 			}	
			
// 			Collections.reverse(bits);
			
// 			ans = check(bits);
// 			System.out.println("#"+tc+ " "+ans);
// 		}

// 	}
	
// 	static String check(List<Integer> bits) {
// 		int s = bits.size()-1;
// 		for(int i=0; i<N; i++) {
// 			if(s< i) return "OFF";
// 			if(bits.get(s-i) == 0) {
// 				return "OFF";
// 			}
// 		}
// 		return "ON";
// 	}

// }
