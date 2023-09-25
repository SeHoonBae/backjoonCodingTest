package backtraking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj6603 {

    public static void main(String[] args){
        FastReader scan = new FastReader();

        while(true){
            int N = scan.nextInt();
            int[] nums = new int[N+1];
            boolean[] visited = new boolean[N+1];
            int[] selectedNums = new int[7];

            if(N == 0) break;

            for(int i=1; i<=N; i++){
                nums[i] = scan.nextInt();
            }

            Arrays.sort(nums);

            StringBuffer sb = new StringBuffer();

            rec_func(1, sb, visited, selectedNums, nums);

            System.out.println(sb.toString());
        }
    }

    static void rec_func(int k, StringBuffer sb, boolean[] visited, int[] selectedNums, int[] nums){
        if(k == 7){
            for(int i=1; i<selectedNums.length; i++){
                sb.append(selectedNums[i] + " ");
            }
            sb.append("\n");
        }else{
            for(int i=1; i<nums.length; i++){
                if(!visited[i] && selectedNums[k-1] < nums[i]){
                    visited[i] = true;
                    selectedNums[k] = nums[i];
                    rec_func(k+1, sb, visited, selectedNums, nums);
                    selectedNums[k] = 0;
                    visited[i] = false;
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
