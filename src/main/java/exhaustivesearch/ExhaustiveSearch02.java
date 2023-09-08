package exhaustivesearch;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

// fastcampus 코딩테스트 369
// Part3. 알고리즘 유형별 문제풀이
// Ch02 - 01
public class ExhaustiveSearch02 {

    static StringBuilder sb = new StringBuilder();
    static int[] selected = {};
    static int N;
    static int M;

    static void input(){
        ExhaustiveSearch01.FastReader scan = new ExhaustiveSearch01.FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M+1];
    }

    /**
     * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
     *
     * 1부터 N까지 자연수 중에서 M개를 고른 수열
     * 같은 수를 여러 번 골라도 된다.
     *
     * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)
     *
     * 시간 제한 1초, 메모리 제한 512MB
     */

    // Recurrence Function (재귀 함수)
    // N개 중 중복을 허용하지 않고 M개를 순서 있게 나열하기(백준 15649 - N과 M(1) 문제)
    // 만약 M개를 전부 고름 -> 조건에 맞는 탐색을 한 가지 성공한 것!
    // 아직 M개를 고르지 않음 -> K 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.

    // 시간 복잡도는 최악의 상황에서 7! = 40320 -> 시간제한 1초 성립
    // 시간: O(N! / (N-M)! => 8! / 0! = 40320
    static void rec_func(int k){

        if(k==M+1){
            for(int i=1; i<=M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for(int i=1; i<=N; i++){
                if(k==i) continue;
                selected[k] = i;
                rec_func(k+1);
                selected[k] = 0;
            }
        }

    }

    public static void main(String[] args){
        input();

        rec_func(1);
        System.out.println(sb.toString());
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
