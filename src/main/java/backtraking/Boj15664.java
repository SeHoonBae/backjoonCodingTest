package backtraking;

import java.io.*;
import java.util.*;

public class Boj15664 {

    public static void main(String[] args){
        input();
        Arrays.sort(nums);

        rec_func(1);

        for(int i=0; i<ansList.size(); i++){
            System.out.println(ansList.get(i));
        }
    }

    static int N, M;

    static int[] nums, selectedNums;
    static boolean[] selected;

    static ArrayList<String> ansList;

    static void rec_func(int k){
        if(k == M+1){
            StringBuffer sb = new StringBuffer();
            for(int i = 1; i< selectedNums.length; i++){
                sb.append(selectedNums[i] + " ");
            }

            boolean flag = true;

            for(int i = 0; i<ansList.size(); i++){
                if(ansList.get(i).equals(sb.toString())){
                    flag = false;
                }
            }

            if(flag){
                ansList.add(sb.toString());
            }
        }else{
            for(int i=0; i<N; i++){
                if(!selected[i] && selectedNums[k-1] <= nums[i]){
                    selected[i] = true;
                    selectedNums[k] = nums[i];
                    rec_func(k+1);
                    selectedNums[k] = 0;
                    selected[i] = false;
                }
            }
        }
    }

    static void input(){
        FastReader scan = new FastReader();
        ansList = new ArrayList<>();

        N = scan.nextInt();
        M = scan.nextInt();

        nums = new int[N];
        selected = new boolean[N+1];
        selectedNums = new int[M+1];

        for(int i=0; i<N; i++){
            nums[i] = scan.nextInt();
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
