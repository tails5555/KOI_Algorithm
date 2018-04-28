package net.kang.gomoku;
import java.util.Map;
import java.util.HashMap;
public class Example01 {
	// 인덱스 제약 상 -1 좌표에는 아무 것도 존재할 수 없기 때문에 애석하게도 모서리 부분에 대해서는 @로 경계를 뒀다. 이 내부 안에 O, X만 존재하게끔 만들어서 풀이를 하였으니 참고하길 바란다.
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
	public static boolean gomokuConfirm(){ // 오목의 유효성을 확인하기 위해 만든 함수이다.
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
	public static boolean horizon(char ball, int x, int y){ // 수평적으로 맞는지 확인
		int count=0;
		while(ball==playRound[x][y]){
			y++;
			count++;
		}
		return count==5 ? true : false;
	}
	public static boolean vertical(char ball, int x, int y){ // 수직적으로 맞는지 확인
		int count=0;
		while(ball==playRound[x][y]){
			x++;
			count++;
		}
		return count==5 ? true : false;
	}
	public static boolean downDiagonal(char ball, int x, int y){ // 하방향 대각선으로 맞는지 확인
		int count=0;
		while(ball==playRound[x][y]){
			x++;
			y++;
			count++;
		}
		return count==5 ? true : false;
	}
	public static boolean upDiagonal(char ball, int x, int y){ // 상방향 대각선으로 맞는지 확인
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
