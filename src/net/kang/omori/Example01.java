package net.kang.omori;
// �̰� �ſ� ����� �����̱� ������ �׳� ����� �������� ����...�̤�
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
 
public class Example01 {
    public static int T;    // �׽�Ʈ ��
    public static int W;    // ����
    // �� ���Թ迭
    public static int[] weight = new int[] {1, 3, 9, 27, 81, 243, 729};
    public static int[] used;    // ��뿩�� �迭
    public static TreeSet left;    // ���ʿ� �÷����� �� ����
    public static TreeSet right;// �����ʿ� �÷����� �� ����
    public static String leftStr;    // ���ʿ� �÷����� �� ���ڿ�
    public static String rightStr;    // �����ʿ� �÷����� �� ���ڿ�
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long begin = System.currentTimeMillis();
        
        for (int i = 0; i < 100; i++) {
            W = i;
            // ����� ���
//            System.out.println(W);
            
            used = new int[weight.length];    // ��뿩�� �迭 �ʱ�ȭ
            left = new TreeSet();    // ���ʿ� �÷����� �� ���� �ʱ�ȭ     
            right = new TreeSet();    // �����ʿ� �÷����� �� ���� �ʱ�ȭ
            
            int curLeftWeight = W;        // ���� ���� ����
            int curRightWeight = 0;        // ���� ������ ����
            String curLeftStr = "";        // ���� ���� �� ���
            String curRightStr = "";    // ���� ������ �� ���
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
        // ������ ���� �������� ������ ����
        if(curLeftWeight == curRightWeight) {
            // ������� ���ʿ� �÷����� ���� ���ڿ��� �������� ����
            left.addAll(Arrays.asList(curLeftStr.trim().split(" ")));
            // ���� �� ���ڿ� ����
            leftStr = curLeftStr.trim();
            
            // ������� �����ʿ� �÷����� ���� ���ڿ��� �������� ����
            right.addAll(Arrays.asList(curRightStr.trim().split(" ")));
            // ������ �� ���ڿ� ����
            rightStr = curRightStr;
            return;
        }
        
        for (int i = 0; i < weight.length; i++) {
            // ����� �߰� �ƴϰ�,
            if(used[i] == 0 
                    // ������ ���� �����տ��� ����,
                    && !left.contains(""+weight[i])
                    // ������ ������ �����տ��� ������
                    && !right.contains(""+weight[i])) {
                
                // �߸� ����� ������ ǥ��
                used[i] = 1;
                
                // ���� �����ʿ� �߸� �ø�.
                f(curLeftWeight, curRightWeight + weight[i], curLeftStr, curRightStr + " " + weight[i]);
                // ���� ���ʿ� �߸� �ø�
                f(curLeftWeight + weight[i], curRightWeight, curLeftStr + " " + weight[i], curRightStr);
                
                // ���� ���� ����� ����
                used[i] = 0;
            }
        }
    }
}