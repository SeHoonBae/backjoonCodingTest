package backtraking;

import java.io.*;
import java.util.StringTokenizer;

// 백준 1987번 문제
// 첫 HashMap을 사용하여 중복 체크 -> 알파벳이므로 boolean 값으로 체크하는게 효율
// 재귀를 호출하기 전, 후 모두에서 Map을 넣고 빼고를 진행 하였음 -> 1번만 해도 됨
public class Boj1987 {

    static int R, C, max;
    static char[][] alphabet;
    static boolean[][] visited;
    static boolean[] selected;

    public static void main(String[] args){
        input();

        rec_func(1, 0, 0);

        System.out.println(max);
    }

    // 상,하,좌,우 1칸씩 이동 가능
    // 알파벳을 뽑은 상황일 때, 더 이상 갈 곳이 없을 때 stop
    static void rec_func(int cnt, int i, int j){
        if(i < 0 || i >= R || j < 0 || j >= C || selected[alphabet[i][j] - 'A'] || visited[i][j]){
            max = Math.max(max, cnt-1);
        }else{
            visited[i][j] = true;
            selected[alphabet[i][j] - 'A'] = true;
            rec_func(cnt+1, i-1, j);
            rec_func(cnt+1, i+1, j);
            rec_func(cnt+1, i, j-1);
            rec_func(cnt+1, i, j+1);
            selected[alphabet[i][j] - 'A'] = false;
            visited[i][j] = false;
        }
    }

    static void input(){
        FastReader scan = new FastReader();
        selected = new boolean[26];
        max = Integer.MIN_VALUE;
        R = scan.nextInt();
        C = scan.nextInt();

        alphabet = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            String tmp = scan.next();
            for(int j=0; j<C; j++){
                alphabet[i][j] = tmp.charAt(j);
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
