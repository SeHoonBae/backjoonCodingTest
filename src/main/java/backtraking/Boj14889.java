package backtraking;

import java.io.*;
import java.util.StringTokenizer;

// 백준 알고리즘 14889번 문제
// 시간 제한 2초 ->
// max, min 은 문제에서 대놓고 -10억 ~ 10억이라고 명시되어 있어 int형으로 문제를 풀자
// 4 <= N <= 20, N은 짝수
// i번 줄의 j번째 수는 S(i,j)라고 하며 S(i,i)는 항상 0이고, 나머지 S(i,j)는 1보다 크거나 같고, 100보다 작거나 같은 정수
// 축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다.

/**
 * 4
 * 0 1 2 3
 * 4 0 5 6              -> 0
 * 7 1 0 2
 * 3 4 5 0
 *
 *
 * 6
 * 0 1 2 3 4 5
 * 1 0 2 3 4 5
 * 1 2 0 3 4 5
 * 1 2 3 0 4 5          -> 2
 * 1 2 3 4 0 5
 * 1 2 3 4 5 0
 *
 *
 *
 * 8
 * 0 5 4 5 4 5 4 5
 * 4 0 5 1 2 3 4 5
 * 9 8 0 1 2 3 1 2
 * 9 9 9 0 9 9 9 9
 * 1 1 1 1 0 1 1 1      -> 1
 * 8 7 6 5 4 0 3 2
 * 9 1 9 1 9 1 0 9
 * 6 5 4 3 2 1 9 0
 */
public class Boj14889 {

    public static void main(String[] args){
        input();
        rec_func(1, 0);
        System.out.println(min);
    }

    static int N, min;
    static int[][] score;
    static boolean[] team;

    static void rec_func(int k, int start){
        if(N/2+1 == k){
            calculator();
            return;
        }else{
            for(int i=start; i<N; i++){
                if(!team[i]){
                    team[i] = true;
                    rec_func(k+1, i);
                    team[i] = false;
                }
            }
        }
    };

    static void calculator(){
        int teamA = 0, teamB = 0;

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(team[i] && team[j]){
                    teamA += score[i][j];
                    teamA += score[j][i];
                }else if(!team[i] && !team[j]){
                    teamB += score[i][j];
                    teamB += score[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(teamA - teamB));
    }

    static void input(){
        FastReader scan = new FastReader();

        min = Integer.MAX_VALUE;
        N = scan.nextInt();
        score = new int[N][N];
        team = new boolean[N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                score[i][j] = scan.nextInt();
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
