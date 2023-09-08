package backtraking;

import java.io.*;
import java.util.StringTokenizer;

// 백준 알고리즘 15654번 문제
// 시간제한 1초, 메모리 제한 512MB
public class Boj15654 {

    static int N, M;
    static int[] nums, selected;
    static StringBuffer sb;

    public static void main(String[] args){
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }

    static void rec_func(int k){
        if(M+1 == k){
            for(int i=1; i<=M; i++){
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
        }else{
            for(int i=1; i<=N; i++){
                if(!isDuplicated(nums[i])){
                    selected[k] = nums[i];
                    rec_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }

    static boolean isDuplicated(int num){
        for(int i=1; i< selected.length; i++){
            if(selected[i] == 0){
                return false;
            } else if(num == selected[i]){
                return true;
            }
        }
        return false;
    }

    static void input(){
        sb = new StringBuffer();
        FastReader scan = new FastReader();

        N = scan.nextInt();
        M = scan.nextInt();
        nums = new int[N+1];
        selected = new int[M+1];

        for(int i=1; i<=N; i++){
            nums[i] = scan.nextInt();
        }
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
