import java.io.*;
import java.util.*;

public class Solution {

    static int N,M,L,ans;
    static List<Integer> nums;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            //수열 input
            st =  new StringTokenizer(br.readLine());
            nums = new ArrayList<>();
            for (int j = 1; j <= N; j++) {
                nums.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < M ; j++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                switch (cmd) {
                    case "I":
                        int idx = Integer.parseInt(st.nextToken());
                        int num = Integer.parseInt(st.nextToken());
                        nums.add(idx, num);
                        break;
                    case "D":
                        idx =  Integer.parseInt(st.nextToken());
                        nums.remove(idx);
                        break;
                    case "C":
                        idx = Integer.parseInt(st.nextToken());
                        num = Integer.parseInt(st.nextToken());
                        nums.set(idx, num);
                        break;
                    default:
                        break;
                }
            }
            
            if (nums.size() <= L) {
                ans = -1;
            } else {
               ans = nums.get(L);
            }

            System.out.println("#" + i + " " + ans);

        }
    }
}
