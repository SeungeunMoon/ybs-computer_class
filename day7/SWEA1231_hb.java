import java.io.*;
import java.util.*;
public class Solution {
    static List<Integer>[] tree;
    static StringBuilder sb;
    static int nodeNum;
    static String[] chars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
 
        for (int tc = 1; tc <= 10; tc++) {
            nodeNum = Integer.parseInt(br.readLine().trim());
            tree = new ArrayList[nodeNum + 1];
            chars = new String[nodeNum + 1]; 
            for (int i = 0; i <= nodeNum; i++) {
                tree[i] = new ArrayList<>();
            }
 
            for (int i = 1; i <= nodeNum; i++) {
                // List<Object>[] tree 구조에 차곡차곡 넣기 현재노드번호, 현재노드문자, 왼쪽자식번호, 오른쪽자식번호 순서로
                String[] input = br.readLine().trim().split(" ");
 
                int pos = Integer.parseInt(input[0]);
                String letter = input[1];
                chars[pos] = letter;
                 
                if (input.length == 2) {
                    tree[pos].add(null);
                    tree[pos].add(null);
                }
                else if(input.length == 3) {
                    tree[pos].add(Integer.parseInt(input[2]));
                    tree[pos].add(null);
                }
                else if(input.length == 4) {
                    tree[pos].add(Integer.parseInt(input[2]));
                    tree[pos].add(Integer.parseInt(input[3]));
                }
                 
            }
//          for (List<Integer> t : tree) {
//              System.out.println(t);
//          }
            sb = new StringBuilder();
            preOrder(1);
            bw.write("#" + tc + " " + sb.toString() + "\n");
 
        }
        bw.flush();
        bw.close();
        br.close();
    }
     
    public static void preOrder(int currentNum) {
        if (currentNum <= nodeNum && !tree[currentNum].isEmpty()) {
            List<Integer> currentNode = tree[currentNum];
//          System.out.println(currentNode);
            if (currentNode.get(0) != null) {
                preOrder(currentNode.get(0));
            }
            sb.append(chars[currentNum]);
            if (currentNode.get(1) != null) {
                preOrder(currentNode.get(1));
                 
            }
        }
         
         
    }
 
}