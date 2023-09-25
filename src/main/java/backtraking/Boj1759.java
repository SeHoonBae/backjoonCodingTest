package backtraking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1759 {

    public static void main(String[] args){

        input();
        Arrays.sort(arr);

        rec_func(0);

        System.out.println(sb);
    }



    // 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음
    // 중복 x, 순서 o(사전순)
    static void rec_func(int k){
        if(k == L){
            StringBuffer tmp = new StringBuffer();
            int vowelCnt = 0; // 모음(a, e, i, o, u)
            int consonantCnt = 0; // 자음

            for(int i=0; i<L; i++){
                if(selected[i].equals("a") || selected[i].equals("e") || selected[i].equals("i") || selected[i].equals("o") || selected[i].equals("u")){
                    vowelCnt++;
                }else{
                    consonantCnt++;
                }

                tmp.append(selected[i]);
            }

            if(vowelCnt >= 1 && consonantCnt >=2){
                sb.append(tmp.toString() + "\n");
            }

        }else{
            for(int i=0; i<C; i++){
                if(!visited[i] && isBigger(k, arr[i])){
                    visited[i] = true;
                    selected[k] = arr[i];
                    rec_func(k+1);
                    selected[k] = null;
                    visited[i] = false;
                }
            }
        }
    }

    static boolean isBigger(int k, String s){
        if(k==0) return true;

        if(selected[k-1].compareTo(s) < 0){
            return true;
        }

        return false;
    }

    static int C, L;
    static String[] arr, selected;
    static boolean[] visited;
    static StringBuffer sb;


    static void input(){
        FastReader scan = new FastReader();
        sb = new StringBuffer();

        L = scan.nextInt();
        C = scan.nextInt();
        arr = new String[C];
        selected = new String[L];
        visited = new boolean[C];

        for(int i=0; i<C; i++){
            arr[i] = scan.next();
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
