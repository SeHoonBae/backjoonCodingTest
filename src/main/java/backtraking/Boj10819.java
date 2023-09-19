package backtraking;

import java.io.*;
import java.util.StringTokenizer;

// 백준 알고리즘 10819번 문제
// 3 <= N <8
// 최대 100 이라 했을 때 800 이므로 int
// 배열의 순서를 섞어야 하므로 배열의 인덱스 0 ~ N-1까지를 중복 X, 순서 X 나열한 값을 기반으로 계산을 해줌
public class Boj10819 {

    public static void main(String[] args){
        input();
        rec_func(0);
        System.out.println(max);
    }

    static int N, max;
    static int[] arr, nums;
    static boolean[] selected;
    static StringBuffer sb;

    static void input(){
        FastReader scan = new FastReader();
        sb = new StringBuffer();

        max = Integer.MIN_VALUE;
        N = scan.nextInt();
        arr = new int[N];
        nums = new int[N];
        selected = new boolean[N];

        for(int i=0; i<N; i++){
            arr[i] = scan.nextInt();
        }
    }

    static void rec_func(int k){
        if(k == N){
            int total = 0;
            for (int i=0; i< nums.length-1; i++){
                total += Math.abs(arr[nums[i]] - arr[nums[i+1]]);
            }
            max = Math.max(max, total);
        }else{
            for(int i=0; i<N; i++){
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
