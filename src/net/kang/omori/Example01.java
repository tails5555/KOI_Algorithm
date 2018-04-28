package net.kang.omori;
// 이건 매우 어려운 문제이기 때문에 그냥 참고로 끝내도록 하자...ㅜㅜ
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
 
public class Example01 {
    public static int T;    // 테스트 수
    public static int W;    // 무게
    // 추 무게배열
    public static int[] weight = new int[] {1, 3, 9, 27, 81, 243, 729};
    public static int[] used;    // 사용여부 배열
    public static TreeSet left;    // 왼쪽에 올려놓은 추 집합
    public static TreeSet right;// 오른쪽에 올려놓은 추 집합
    public static String leftStr;    // 왼쪽에 올려놓은 추 문자열
    public static String rightStr;    // 오른쪽에 올려놓은 추 문자열
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long begin = System.currentTimeMillis();
        
        for (int i = 0; i < 100; i++) {
            W = i;
            // 디버깅 출력
//            System.out.println(W);
            
            used = new int[weight.length];    // 사용여부 배열 초기화
            left = new TreeSet();    // 왼쪽에 올려놓은 추 집합 초기화     
            right = new TreeSet();    // 오른쪽에 올려놓은 추 집합 초기화
            
            int curLeftWeight = W;        // 현재 왼쪽 무게
            int curRightWeight = 0;        // 현재 오른쪽 무게
            String curLeftStr = "";        // 현재 왼쪽 추 목록
            String curRightStr = "";    // 현재 오른쪽 추 목록
            f(curLeftWeight, curRightWeight, curLeftStr, curRightStr);
            if("".equals(leftStr)) {
                System.out.println(W + " 0 " + rightStr.trim());
            }
            else {
                System.out.println(W + " " + leftStr.trim() + " 0 " + rightStr.trim());
            }
        }
        
        long end = System.currentTimeMillis();
        System.out.printf("%.3f(secs)", (end-begin)/1000.0);
        scanner.close();
    }
    private static void f(int curLeftWeight, int curRightWeight, String curLeftStr, String curRightStr) {
        // 저울의 왼쪽 오른쪽이 같으면 종료
        if(curLeftWeight == curRightWeight) {
            // 현재까지 왼쪽에 올려놓은 추의 문자열을 집합으로 설정
            left.addAll(Arrays.asList(curLeftStr.trim().split(" ")));
            // 왼쪽 추 문자열 저장
            leftStr = curLeftStr.trim();
            
            // 현재까지 오른쪽에 올려놓은 추의 문자열을 집합으로 설정
            right.addAll(Arrays.asList(curRightStr.trim().split(" ")));
            // 오른쪽 추 문자열 저장
            rightStr = curRightStr;
            return;
        }
        
        for (int i = 0; i < weight.length; i++) {
            // 사용한 추가 아니고,
            if(used[i] == 0 
                    // 저울의 왼쪽 추집합에도 없고,
                    && !left.contains(""+weight[i])
                    // 저울의 오른쪽 추집합에도 없으면
                    && !right.contains(""+weight[i])) {
                
                // 추를 사용한 것으로 표시
                used[i] = 1;
                
                // 저울 오른쪽에 추를 올림.
                f(curLeftWeight, curRightWeight + weight[i], curLeftStr, curRightStr + " " + weight[i]);
                // 저울 왼쪽에 추를 올림
                f(curLeftWeight + weight[i], curRightWeight, curLeftStr + " " + weight[i], curRightStr);
                
                // 저울 추의 사용을 원복
                used[i] = 0;
            }
        }
    }
}