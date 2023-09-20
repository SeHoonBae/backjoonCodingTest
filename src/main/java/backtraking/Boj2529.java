package backtraking;

import java.io.*;
import java.util.StringTokenizer;

// 백준 2529번 문제
// 2 <= k <= 9
// 0 ~ 9까지 사이 수를 순서대로 배치하는 방법
// 1. k+1개 만큼의 0~9까지의 수를 배치하는 방법을 구한다.
// 2. 주어진 k개의 부등호를 기반으로 만족하는지 확인한다.
// 3. 2번이 만족된다면 해당 숫자를 자리수 기반(ex: 1 2 3 -> 123)으로 합쳐서 최소값과 최대값을 갱신한다.
public class Boj2529 {

    public static void main(String[] args){
        input();

        rec_func(0);

        matchDigit();

        System.out.println(max);
        System.out.println(min);
    }

    static int k;
    static String min, max;
    static String[] quote;

    static int[] nums;
    static boolean[] selected;

    static void matchDigit(){
        if(min.length() != k+1){
            int minLength = k + 1 - min.length();

            for(int i=0; i<minLength; i++){
                min = "0"+min;
            }

        }

        if(max.length() != k+1){
            int maxLength = k + 1 - max.length();

            for(int i=0; i<maxLength; i++){
                max = "0"+max;
            }
        }
    }
    static boolean check(){
        boolean ans = true;
        // nums는 부등호 길이보다 항상 1 크기 때문에 별도로 확인 X
        for(int i=0; i< nums.length-1; i++){
            String q = quote[i];

            if(q.equals(">") && nums[i] > nums[i+1]){
                continue;
            }else if(q.equals("<") && nums[i] < nums[i+1]){
                continue;
            }else{
                ans = false;
                break;
            }
        }
        return ans;
    }

    static long makeNums(){
        StringBuffer sb = new StringBuffer();

        for(int n : nums){
            sb.append(n);
        }

        return Long.parseLong(sb.toString());
    }

    static void rec_func(int idx){
        if(idx == k+1){
            boolean isOk = check();

            if(isOk){
                long num = makeNums();

                if(Long.parseLong(min) > num){
                    min = num + "";
                }

                if(Long.parseLong(max) < num){
                    max = num + "";
                }
            }

        }else{
            for(int i=0; i<=9; i++){
                if(!selected[i]){
                    selected[i] = true;
                    nums[idx] = i;
                    rec_func(idx+1);
                    selected[i] = false;
                    nums[idx] = 0;
                }
            }
        }
    }

    static void input(){
        FastReader scan = new FastReader();

        min = Long.MAX_VALUE+"";
        max = Long.MIN_VALUE+"";

        k = scan.nextInt();
        quote = new String[k];
        nums = new int[k+1];
        selected = new boolean[10];

        for(int i=0; i< quote.length; i++){
            quote[i] = scan.next();
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
