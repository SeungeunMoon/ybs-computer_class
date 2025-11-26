import java.util.Arrays;
import java.util.Scanner;

public class Day1 {
    
    static int T;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        T = sc.nextInt();
        for (int test = 1; test <= T; test++) {
            int input = sc.nextInt();
            long num = input;
            int multi = 1;
            int ans = 0;
            int[] flag = new int[10];

            while(true) {
                ans++;
                //num split해서 확인
                String[] number = Long.toString(num).split("");
                for (String n : number) {
                    flag[Integer.parseInt(n)] = 1;
                }


                int check = 0;
                for (int i = 0; i < 10; i++) {
                    if (flag[i] == 1) check++;
                }
                if (check == 10) break;

                multi++;
                num = input*multi;
            }

            sb.append("#").append(test).append(" ").append(ans*input).append("\n");
        }
        System.out.println(sb);
    }
}
