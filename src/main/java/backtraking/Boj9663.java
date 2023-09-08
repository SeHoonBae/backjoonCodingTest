package backtraking;

import java.util.Queue;
import java.util.Scanner;

// 백준 알고리즘 9663문제
// 1 <= N < 15
public class Boj9663 {


    static int N, ans;
    static int[] selected;

    static void input(){
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        selected = new int[N];
    }

    // 퀸은 위아래, 좌우, 대각선을 공격할 수 있다.
    static boolean isAttack(int currentVerse, int currentRow, int beforeVerse, int beforeRow){
        if(currentRow == beforeRow) return true;
        if(currentRow+currentVerse == beforeRow+beforeVerse) return true;
        if(currentRow-currentVerse == beforeRow-beforeVerse) return true;

        return false;
    }

    static void rec_fun(int k){
        if(k == N){
            ans++;
        }else{
            for(int i=1; i<N; i++){
                if(k==0 || !isAttack(k, i, k-1, selected[k-1])){
                    selected[k] = i;
                    rec_fun(k+1);
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        input();

        rec_fun(0);

        System.out.println(ans);
    }

}
