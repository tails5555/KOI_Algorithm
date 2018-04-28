package net.kang.budget;

import java.util.Arrays;
import java.util.Scanner;
 
public class ExampleAnother {
    public static int B = 0;    // 남은 예산
    public static int N = 0;    // 예산활동 수
    public static int[] actValue = null;    // 예산활동 비용배열
    public static int[] visited = null;        // 예산활동 사용배열
    public static int max = Integer.MIN_VALUE;    // 최대 예산활동 비용
    public static String maxPath = "";            // 최대 예산활동 선택
    
    public static void main(String[] args){
        long begin = System.currentTimeMillis();
        
        B = 40;    // 남은 예산
        N = 6;    // 예산활동 수
        actValue = new int[] {7, 13, 17, 19, 29, 31};    // 예산활동 비용배열 초기화
        visited = new int[N];    // 예산활동 사용배열 초기화
        int curValue = 0;    // 현재 사용한 비용
        int curIndex = 0;    // 현재 index
 
        String curPath = "";
 
//        f1(actValue[curIndex], curIndex, curPath + actValue[curIndex]);
        f2(curValue, curIndex, curPath);
        
        System.out.println(max);
        
//        // 디버깅 출력 : 어떤 값이 선택되었는지.
//        System.out.println(maxPath);
        
        long end = System.currentTimeMillis();
        System.out.printf("%.3f(secs)", (end-begin)/1000.0);
    }
    private static void f2(int curValue, int curIndex, String curPath) {
        // 현재 사용한 비용이 남은 예산보다 크면 종료
        if(curValue > B
                // 현재 인덱스가 예산활동 수와 같아지면 종료
                || curIndex == N) {
            return;
        }
        
        // 현재까지 사용한 비용과 최대값 비교
//                max = Math.max(max, curValue);
        if(max <= curValue) {
            max = curValue;
            maxPath = curPath;
        }
        
        // 현재 활동비용을 선택하지 않은 경우
        f2(curValue, curIndex+1, curPath);    
        
        // 현재 활동비용을 선택한 경우
        f2(curValue + actValue[curIndex], curIndex+1, curPath + "," + actValue[curIndex]);    
    }
    
    private static void f1(int curValue, int curIndex, String curPath) {
        // 현재 사용한 비용이 남은 예산보다 크면 종료
        if(curValue > B) {
            return;
        }
 
        // 현재 예산활동을 사용했다고 표시
        visited[curIndex] = 1;
        
        // 현재까지 사용한 비용과 최대값 비교
//        max = Math.max(max, curValue);
        if(max <= curValue) {
            max = curValue;
            maxPath = curPath;
        }
        
        // 모든 예산활동 중에 --- (1)
        // 아직 사용하지 않는 예산활동을 ---(2)
        // 수행함.
        for (int i = 0; i < N; i++) {
            if(visited[i] == 0 && curValue != i) {
                f1(curValue + actValue[i], i, curPath+","+actValue[i]);
            }
        }
        
        visited[curIndex] = 0;    // 백트래킹을 위해 복원
    }
}

