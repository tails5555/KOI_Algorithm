package net.kang.budget;

import java.util.Arrays;
import java.util.Scanner;
 
public class ExampleAnother {
    public static int B = 0;    // ���� ����
    public static int N = 0;    // ����Ȱ�� ��
    public static int[] actValue = null;    // ����Ȱ�� ���迭
    public static int[] visited = null;        // ����Ȱ�� ���迭
    public static int max = Integer.MIN_VALUE;    // �ִ� ����Ȱ�� ���
    public static String maxPath = "";            // �ִ� ����Ȱ�� ����
    
    public static void main(String[] args){
        long begin = System.currentTimeMillis();
        
        B = 40;    // ���� ����
        N = 6;    // ����Ȱ�� ��
        actValue = new int[] {7, 13, 17, 19, 29, 31};    // ����Ȱ�� ���迭 �ʱ�ȭ
        visited = new int[N];    // ����Ȱ�� ���迭 �ʱ�ȭ
        int curValue = 0;    // ���� ����� ���
        int curIndex = 0;    // ���� index
 
        String curPath = "";
 
//        f1(actValue[curIndex], curIndex, curPath + actValue[curIndex]);
        f2(curValue, curIndex, curPath);
        
        System.out.println(max);
        
//        // ����� ��� : � ���� ���õǾ�����.
//        System.out.println(maxPath);
        
        long end = System.currentTimeMillis();
        System.out.printf("%.3f(secs)", (end-begin)/1000.0);
    }
    private static void f2(int curValue, int curIndex, String curPath) {
        // ���� ����� ����� ���� ���꺸�� ũ�� ����
        if(curValue > B
                // ���� �ε����� ����Ȱ�� ���� �������� ����
                || curIndex == N) {
            return;
        }
        
        // ������� ����� ���� �ִ밪 ��
//                max = Math.max(max, curValue);
        if(max <= curValue) {
            max = curValue;
            maxPath = curPath;
        }
        
        // ���� Ȱ������� �������� ���� ���
        f2(curValue, curIndex+1, curPath);    
        
        // ���� Ȱ������� ������ ���
        f2(curValue + actValue[curIndex], curIndex+1, curPath + "," + actValue[curIndex]);    
    }
    
    private static void f1(int curValue, int curIndex, String curPath) {
        // ���� ����� ����� ���� ���꺸�� ũ�� ����
        if(curValue > B) {
            return;
        }
 
        // ���� ����Ȱ���� ����ߴٰ� ǥ��
        visited[curIndex] = 1;
        
        // ������� ����� ���� �ִ밪 ��
//        max = Math.max(max, curValue);
        if(max <= curValue) {
            max = curValue;
            maxPath = curPath;
        }
        
        // ��� ����Ȱ�� �߿� --- (1)
        // ���� ������� �ʴ� ����Ȱ���� ---(2)
        // ������.
        for (int i = 0; i < N; i++) {
            if(visited[i] == 0 && curValue != i) {
                f1(curValue + actValue[i], i, curPath+","+actValue[i]);
            }
        }
        
        visited[curIndex] = 0;    // ��Ʈ��ŷ�� ���� ����
    }
}

