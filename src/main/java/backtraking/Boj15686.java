package backtraking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 알고리즘 15686번 문제
 * 시간제한 1초, 메모리 제한 512MB
 * 첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 13)이 주어진다.
 *
 * 둘째 줄부터 N개의 줄에는 도시의 정보가 주어진다.
 *
 * 도시의 정보는 0, 1, 2로 이루어져 있고, 0은 빈 칸, 1은 집, 2는 치킨집을 의미한다. 집의 개수는 2N개를 넘지 않으며, 적어도 1개는 존재한다. 치킨집의 개수는 M보다 크거나 같고, 13보다 작거나 같다.
 *
 * 1. 각 치킨집(2)과 집(1)의 모든 거리 더한 값(치킨 거리 값)를 배열로 나타내라.
 * 2. 각 치킨집에서 집과의 거리를 구하고 모두 더한 값을 가까운 M개를 제외하고 나머지는 제거
 */
public class Boj15686 {

    public static void main(String[] args){
        input();


    }

    static int N, M;
    static int[][] nums;
    static ArrayList<Coordinate> chickens, homes;

    static class Coordinate{
        int x, y;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void input(){
        FastReader scan = new FastReader();

        int N = scan.nextInt();
        int M = scan.nextInt();

        nums = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int num = scan.nextInt();
                nums[i][j] = num;
                if(num == 1){
                    homes.add(new Coordinate(i+1, j+1));
                }else if(num == 2){
                    chickens.add(new Coordinate(i+1, j+1));
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
