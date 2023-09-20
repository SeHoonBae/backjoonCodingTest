package backtraking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘 1182번 문제
 * 합은 int 가능 -> 최대 절대값이 100만이고 N의 값의 최대가 20이므로 20 * 100만 -> 2000만
 *
 *
 */
public class Boj1182 {

    public static void main(String[] args){
        input();
        rec_func(1, 0);

        if(S==0){
            ans--;
        }

        System.out.println(ans);
    }

    static int N, S, ans;
    static int[] nums;


    static void rec_func(int k, int value){
        if(k == N+1){
            if(value == S) {
                ans++;
            }
        }else{
            if (k == N + 1) {  // 부분 수열을 하나 완성 시킨 상태
                // value 가 S 랑 같은 지 확인하기
                if (value == S) ans++;
            } else {
                // k 번째 원소를 포함시킬 지 결정하고 재귀호출해주기
                // Include
                rec_func(k + 1, value + nums[k]);
                // Not Include
                rec_func(k + 1, value);
            }
        }
    }

    static void input(){
        FastReader scan = new FastReader();

        N = scan.nextInt();
        S = scan.nextInt();

        nums = new int[N+1];

        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();

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
