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
 * 1. 각 치킨집(2)과 집(1)의 위치를 저장
 * 2. 입력받은 치킨집 중 M개를 선택할 수 있는 모든 방법을 비교해야 한다.
 * 3. 2번에서 구한 M개의 치킨집에 대해 각각의 집과의 최소 거리를 구한 후 도시의 치킨거리 값을 구한다.
 * 4. 도시의 치킨거리 중에서 가장 최소값을 구한다.
 */
public class Boj15686 {

    public static void main(String[] args){
        input();

        rec_func(1, 1);

        System.out.println(min);
    }

    static int N, M, min;
    static int[][] nums;
    static ArrayList<Point> chickens, homes;

    static boolean[] selected;
    static int[] indexs;

    static int calculator(){
        int total = 0;

        for(Point point : homes){
            int minDistance = Integer.MAX_VALUE;
            for(int i=1; i<indexs.length; i++){
                minDistance = Math.min(minDistance, Math.abs(point.x - chickens.get(indexs[i]-1).x) + Math.abs(point.y - chickens.get(indexs[i]-1).y));
            }
            total += minDistance;

        }

        return total;
    }

    static void rec_func(int k, int start){
        if(k == M+1){
            min = Math.min(min, calculator());
        }else{
            for(int i=start; i<= chickens.size(); i++){
                if(!selected[i]){
                    selected[i] = true;
                    indexs[k] = i;
                    rec_func(k+1, i+1);
                    indexs[k] = 0;
                    selected[i] = false;
                }
            }
        }
    }

    static class Point{
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void input(){
        FastReader scan = new FastReader();
        chickens = new ArrayList<>();
        homes = new ArrayList<>();
        N = scan.nextInt();
        M = scan.nextInt();
        min = Integer.MAX_VALUE;

        indexs = new int[M+1];


        nums = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int num = scan.nextInt();
                nums[i][j] = num;
                if(num == 1){
                    homes.add(new Point(i+1, j+1));
                }else if(num == 2){
                    chickens.add(new Point(i+1, j+1));
                }
            }
        }

        selected = new boolean[chickens.size()+1];
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
