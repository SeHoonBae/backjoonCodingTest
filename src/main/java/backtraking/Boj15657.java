package backtraking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 15657번 문제
// 중복 O, 순서 O(오름차순)
public class Boj15657 {

    public static void main(String[] args){
        input();
        Arrays.sort(arr);

        rec_func(1);
        System.out.println(sb.toString());
    }

    static StringBuffer sb;
    static int N, M;
    static int[] arr, nums;

    static void rec_func(int k){
        if(M+1 == k){
            for(int i=1; i<nums.length; i++){
                sb.append(nums[i] + " ");
            }
            sb.append("\n");

        }else{
            for(int i=0; i<N; i++){
                if(nums[k-1] <= arr[i]){
                    nums[k] = arr[i];
                    rec_func(k+1);
                    nums[k] = 0;
                }
            }
        }
    }

    static void input(){
        FastReader scan = new FastReader();
        sb = new StringBuffer();

        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N];
        nums = new int[M+1];

        for(int i=0; i<N; i++){
            arr[i] = scan.nextInt();
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
