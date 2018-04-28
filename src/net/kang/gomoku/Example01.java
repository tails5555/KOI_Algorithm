package net.kang.gomoku;
import java.util.Map;
import java.util.HashMap;
public class Example01 {
	// �ε��� ���� �� -1 ��ǥ���� �ƹ� �͵� ������ �� ���� ������ �ּ��ϰԵ� �𼭸� �κп� ���ؼ��� @�� ��踦 �״�. �� ���� �ȿ� O, X�� �����ϰԲ� ���� Ǯ�̸� �Ͽ����� �����ϱ� �ٶ���.
	static char[][] playRound={
			{ '@', '@', '@', '@', '@', '@', '@', '@', '@' },
			{ '@', 'O', 'O', 'X', 'O', 'X', 'X', 'O', '@' },
			{ '@', '-', 'O', '-', 'X', '-', '-', 'O', '@' },
			{ '@', '-', 'X', '-', 'O', 'X', '-', 'X', '@' },
			{ '@', 'X', '-', 'O', 'O', 'O', 'X', 'O', '@' },
			{ '@', '-', 'X', 'X', 'X', '-', '-', 'X', '@' },
			{ '@', '-', '-', 'X', 'O', 'X', '-', '-', '@' },
			{ '@', 'X', 'X', 'O', 'O', 'X', 'X', '-', '@' },
			{ '@', '@', '@', '@', '@', '@', '@', '@', '@' }
	};
	public static boolean gomokuConfirm(){ // ������ ��ȿ���� Ȯ���ϱ� ���� ���� �Լ��̴�.
		Map<Character, Integer> confirmMap=new HashMap<Character, Integer>();
		for(int k=0;k<playRound.length;k++){
			for(int l=0;l<playRound[k].length;l++){
				if(confirmMap.containsKey(playRound[k][l])) confirmMap.put(playRound[k][l], confirmMap.get(playRound[k][l])+1);
				else confirmMap.put(playRound[k][l], 1);
			}
		}
		System.out.println(confirmMap);
		return Math.abs(confirmMap.get('O')-confirmMap.get('X'))<=1;
	}
	public static boolean horizon(char ball, int x, int y){ // ���������� �´��� Ȯ��
		int count=0;
		while(ball==playRound[x][y]){
			y++;
			count++;
		}
		return count==5 ? true : false;
	}
	public static boolean vertical(char ball, int x, int y){ // ���������� �´��� Ȯ��
		int count=0;
		while(ball==playRound[x][y]){
			x++;
			count++;
		}
		return count==5 ? true : false;
	}
	public static boolean downDiagonal(char ball, int x, int y){ // �Ϲ��� �밢������ �´��� Ȯ��
		int count=0;
		while(ball==playRound[x][y]){
			x++;
			y++;
			count++;
		}
		return count==5 ? true : false;
	}
	public static boolean upDiagonal(char ball, int x, int y){ // ����� �밢������ �´��� Ȯ��
		int count=0;
		while(ball==playRound[x][y]){
			x--;
			y++;
			count++;
		}
		return count==5 ? true : false;
	}
	public static void winner(){
		for(int k=1;k<playRound.length-1;k++){
			for(int l=1;l<playRound[k].length-1;l++){
				if(playRound[k][l]!='-'){
					if(playRound[k][l-1]!=playRound[k][l] && horizon(playRound[k][l], k, l)){
						System.out.printf("%d %d %c\n", k, l, playRound[k][l]);
					}
					if(playRound[k-1][l]!=playRound[k][l] && vertical(playRound[k][l], k, l)){
						System.out.printf("%d %d %c\n", k, l, playRound[k][l]);
					}
					if(playRound[k-1][l-1]!=playRound[k][l] && downDiagonal(playRound[k][l], k, l)){
						System.out.printf("%d %d %c\n", k, l, playRound[k][l]);
					}
					if(playRound[k+1][l-1]!=playRound[k][l] && upDiagonal(playRound[k][l], k, l)){
						System.out.printf("%d %d %c\n", k, l, playRound[k][l]);
					}
				}
			}
		}
	}
	public static void main(String[] args){
		System.out.println(gomokuConfirm());
		winner();
	}
}
