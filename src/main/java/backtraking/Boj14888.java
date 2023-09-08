package backtraking;

import java.io.*;
import java.util.StringTokenizer;

// 백준 알고리즘 14888번 문제
// 시간 제한 2초 ->
// max, min 은 문제에서 대놓고 -10억 ~ 10억이라고 명시되어 있어 int형으로 문제를 풀자
public class Boj14888 {

    static int N, max, min;
    static int[] operator, a;

    public static void main(String[] args){
        input();
        rec_func(1, a[1]);
        System.out.println(max);
        System.out.println(min);
    }

    static void rec_func(int k, int value){
        if(k == N){
            // 끝
            max = Math.max(max, value);
            min = Math.min(min, value);
        }else{
            for(int i=0; i<4; i++){
                if(operator[i] != 0){
                    operator[i] --;
                    rec_func(k+1, calculator(value, i, a[k+1]));
                    operator[i] ++;
                }
            }
        }
    }

    static int calculator(int op1, int operator, int op2){
        if(operator == 0) return op1 + op2;
        else if(operator == 1) return op1 - op2;
        else if(operator == 2) return op1 * op2;
        else return op1 / op2;
    }


    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        a = new int[N+1];
        operator = new int[4];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for(int i=1; i<=N; i++){
            a[i] = scan.nextInt();
        }

        for(int i=0; i<4; i++){
            operator[i] = scan.nextInt();
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
