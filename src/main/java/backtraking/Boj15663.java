package backtraking;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

// 백준 15663 문제
// 중복 X, 사전순(순서 O)
public class Boj15663 {

    public static void main(String[] args){
        input();
        Arrays.sort(nums);

        rec_func(1);

        System.out.println(sb.toString());

    }

    // 1 <= M <= N <= 8 -> int 가능
    static int N, M;
    static boolean[] selected;
    static int[] nums, selectedNums;
    static StringBuffer sb;
    static HashSet<String> set;

    static void rec_func(int k){
        if(k == M+1){
            StringBuffer sb2 = new StringBuffer();
            for(int i=1; i<=M; i++){
                    sb2.append(selectedNums[i] + " ");
            }

            if(!set.contains(sb2.toString())){
                sb.append(sb2.toString());
                set.add(sb2.toString());
                sb.append("\n");
            }
        }else{
            for(int i=1; i<=N; i++){
                if(!selected[i]){
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
        set = new HashSet<>();

        N = scan.nextInt();
        M = scan.nextInt();

        nums = new int[N+1];
        selected = new boolean[N+1];

        selectedNums = new int[M+1];

        for(int i=1; i<= N; i++){
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
