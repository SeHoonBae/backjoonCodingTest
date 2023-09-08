package backtraking;

import java.util.Scanner;

// 백준 알고리즘 15649문제
// 1 <= M <= N <= 8
// M = 8, N = 8 일 때 최대이므로 8^8이 최대 값 = 1677만 이므로 1초안에 해결된다.
public class Boj15649 {

    static int M, N;
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

    static void rec_func(int k){
        if(k == M+1){
            for(int i=1; i<=M; i++){
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
        }else{
            for(int i=1; i<=N; i++){
                if(duplicated[i] == 0){
                    selected[k] = i;
                    duplicated[i]++;
                    rec_func(k+1);
                    selected[k] = 0;
                    duplicated[i]--;
                }

            }
        }
    }

    static boolean isDuplication(int k, int val){
        for(int i = 0; i<k; i++){
            if(selected[i] == val){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        input();

        rec_func(1);

        System.out.println(sb.toString());
    }

}
