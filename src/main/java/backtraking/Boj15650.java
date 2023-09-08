package backtraking;

import java.util.Scanner;

// 백준 알고리즘 15650문제
// 1 <= M <= N <= 8
// M = 8, N = 8 일 때 최대이므로 8^8이 최대 값 = 1677만 이므로 1초안에 해결된다.
public class Boj15650 {

    static int N, M;
    static StringBuffer sb;

    static int[] selected, duplicated;

    static void input(){
        sb = new StringBuffer();
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();

        selected = new int[M+1];
        duplicated = new int[N+1];
    }

    static void rec_fun(int k){
        if(k == M + 1){
            for(int i=1; i<=M; i++){
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
        }else {
            for(int i=1; i<=N; i++){
                if(duplicated[i] == 0 && selected[k-1] < i){
                    selected[k] = i;
                    duplicated[i]++;
                    rec_fun(k+1);
                    duplicated[i]--;
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        input();
        rec_fun(1);
        System.out.println(sb.toString());
    }

}
