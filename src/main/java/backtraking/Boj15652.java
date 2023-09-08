package backtraking;

// 백준 알고리즘 9663문제

import java.util.Scanner;

public class Boj15652 {

    static int N, M;
    static int[] selected;
    static StringBuffer sb;

    static void input(){
        sb = new StringBuffer();
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        selected = new int[M+1];
    }

    static void rec_func(int k){
        if(k == M+1){
            for(int i=1; i< selected.length; i++){
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
        }else{
            for(int i=1; i<=N; i++){
                if(selected[k-1] <= i){
                    selected[k] = i;
                    rec_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        input();

        rec_func(1);

        System.out.println(sb.toString());
    }

}
