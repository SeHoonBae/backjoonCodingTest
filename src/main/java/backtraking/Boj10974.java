package backtraking;

import java.io.*;
import java.util.StringTokenizer;

// 백준 10974번 문제
// 1 <= N <= 8
// 중복 X, 순서 O -> 8! ? -> 백트래킹을 이용해서 1초안에 가능
public class Boj10974 {

    public static void main(String[] args){
        input();

        rec_func(1);

        System.out.println(sb.toString());
    }

    static int N;
    static int[] nums;
    static boolean[] selected;

    static StringBuffer sb;

    static void rec_func(int k){
        if(k == N +1){
            for(int i=1; i<nums.length; i++){
                sb.append(nums[i] + " ");
            }
            sb.append("\n");
        }else{
            for (int i=1; i<=N; i++){
                if(!selected[i]){
                    selected[i] = true;
                    nums[k] = i;
                    rec_func(k+1);
                    nums[k] = 0;
                    selected[i] = false;
                }
            }
        }
    }

    static void input(){
        FastReader scan = new FastReader();
        sb = new StringBuffer();

        N = scan.nextInt();

        selected = new boolean[N+1];
        nums = new int[N+1];
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
