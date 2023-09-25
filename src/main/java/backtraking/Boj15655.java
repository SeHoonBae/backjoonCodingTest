package backtraking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15655 {

    public static void main(String[] args){
        input();

        Arrays.sort(nums);

        rec_func(1);

        System.out.println(sb.toString());
    }

    static int N, M;
    static int[] nums, selectedNums;
    static boolean[] selected;
    static StringBuffer sb;

    static void rec_func(int k){
        if(k == M+1){
            for(int i=1; i<=M; i++){
                sb.append(selectedNums[i] + " ");
            }
            sb.append("\n");
        }else{
            for(int i=1; i<=N; i++){
                if(!selected[i] && selectedNums[k-1] < nums[i]){
                    selected[i] = true;
                    selectedNums[k] = nums[i];
                    rec_func(k+1);
                    selectedNums[k] = 0;
                    selected[i] = false;
                }
            }
        }
    }

    static void input(){
        FastReader scan = new FastReader();
        sb = new StringBuffer();

        N = scan.nextInt();
        M = scan.nextInt();

        nums = new int[N+1];
        selectedNums = new int[M+1];
        selected = new boolean[N+1];

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
