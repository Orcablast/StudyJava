package kh.java.game;

import java.util.Scanner;
import java.util.Random;

public class UpAndDown {
	public void exam01() {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		int bestScore = 1000;
		int keepPlay = 0;
		while (keepPlay == 0) {
			System.out.println("==== Up & Down Game ====");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("선택 >");
			int selectMenu = sc.nextInt();
			switch (selectMenu) {
			case 1:
				System.out.println("<< Game Start >>");
				int playScore = 1;
				int comNum = rn.nextInt(99) + 1;
				int userNum;
				while (true) {
					System.out.print(playScore + "회차 번호 입력 : ");
					userNum = sc.nextInt();
					if (userNum < 1 || userNum > 99) {
						System.out.println("입력범위 오류 (1~99 사이의 값을 입력하세요)");
					}
					if (userNum > comNum) {
						playScore++;
						System.out.println("<< DOWN >>");
					} else if (userNum < comNum) {
						playScore++;
						System.out.println("<< UP >>");
					} else if (userNum == comNum) {
						System.out.println("<< 정답 >>");
						if (playScore < bestScore) {
							bestScore = playScore;
						}
						break;
					} else {
						System.out.println("입력범위 오류 (1~99 사이의 값을 입력하세요");
					}
				}
				break;
			case 2:
				if (bestScore == 1000) {
					System.out.println("아직 기록이 없습니다");
					break;
				} else {
					System.out.println("현재 최고 기록은 " + bestScore + "회 입니다.");
					break;
				}
			case 3:
				keepPlay++;
				System.out.println("=========== 프로그램을 종료합니다 ===========");
				break;
			default:
				System.out.println("1~3사이의 값을 입력하세요.");
			}
		}
	}

	public void exam02() {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		int keepPlay = 0;
		int scrWin = 0;
		int scrLose = 0;
		while (keepPlay == 0) {
			System.out.println("===== Baskin&Robbins 31 Game");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("선택 > ");
			int selectMenu = sc.nextInt();
			int userNum;
			int gameNum = 0;
			int gameSet = 0; // 0은 게임이 끝나지않은 상태, 1은 게임이 끝난 상태
			switch (selectMenu) {
			case 1:
				System.out.println("<< Game Start >>");
				while (gameSet == 0) {
					System.out.println("<< Your Turn >>");
					System.out.print("Input Number (1~3) :");
					userNum = sc.nextInt();
					int comNum = rn.nextInt(3) + 1;
					for (int i = 1; i <= userNum && gameSet == 0; i++) {
						gameNum++;
						System.out.println(gameNum + "!");
						if (gameNum == 31) {
							gameSet++;
							scrLose++;
							System.out.println("당신의 패배 ㅠㅠ");
							break;
						}
					}
					System.out.println("<< Computer Turn >>");
					for (int j = 1; j <= comNum && gameSet == 0; j++) {
						gameNum++;
						System.out.println(gameNum + "!");
						if (gameNum == 31) {
							gameSet++;
							scrWin++;
							System.out.println("당신의 승리!!");
							break;
						}
					}
				}
				break;
			case 2:
				System.out.println("<< 당신의 전적 >>");
				System.out.println("WIN : " + scrWin);
				System.out.println("LOSE : " + scrLose);
				break;
				
			case 3:
				System.out.println("프로그램을 종료합니다.");
				keepPlay++;
				break;
				
			default:
				System.out.println("잘못된 입력입니다");
			}
		}
	}

	public void exam03() {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		int userMoney = 10000; // 유저의 기본 자금 10000원
		int scrWin = 0; // 유저의 승리 횟수
		int scrLose = 0; // 유저의 패배 횟수
		int scrDraw = 0; // 유저의 비긴 횟수
		int programOn = 0; // 프로그램을 종료하는 변수, 0 != 게임 종료

		while (programOn == 0) {
			System.out.println("===== Dice Game =====");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("선택 > ");
			int selectMenu = sc.nextInt(); // 메뉴를 선택하는 변수 = 유저 입력값
			int keepPlay = 0; // 게임을 계속 진행할지 결정하는 변수, 0 != 메뉴로 돌아감
			switch (selectMenu) { // 유저가 입력한 selectMenu 변수의 리터럴값으로 분기
			case 1:
				while (keepPlay == 0) { // 게임을 계속 진행할지 결정하는 변수 (0 == 무한루프 , 0 != 메뉴로 돌아감)
					if (userMoney == 0) { // 유저의 잔액이 없으면 무한루프를 종료하도록 keepPlay값을 1 증가
						System.out.println("잔액이 없습니다.");
						keepPlay++;
						break;
					}
					System.out.println("<< Game Start >>");
					int userSum = 0; // 유저의 주사위 총 합, 초기화 0
					int userD; // 유저의 주사위 결과, for문에서 반복될 것
					char userBetAns; // 유저가 베팅을 진행할지 결정하는 변수
					int betSet = 0; // 배팅 시퀀스 루프를 결정하는 변수, 0이 아니면 루프 탈출
					for (int i = 1; i <= 3; i++) {
						userD = rn.nextInt(6) + 1;
						userSum += userD;
						System.out.println(i + "번째 주사위 값 : " + userD);
					}
					System.out.println("내 주사위 총 합  : " + userSum);
					while (betSet == 0) {
						System.out.print("배팅 하시겠습니까? [y/n] : ");
						userBetAns = sc.next().charAt(0);
						int userBet;
						if (userBetAns == 'y') {
							System.out.println("현재 내 소지금 : " + userMoney);
							System.out.print("얼마를 배팅하시겠습니까? : ");
							userBet = sc.nextInt();
							if (userBet > userMoney) {
								System.out.println("소지금이 부족합니다.");
								break;
							}
							int comSum = 0;
							int comD;
							for (int j = 1; j <= 3; j++) {
								comD = rn.nextInt(6) + 1;
								System.out.println("컴퓨터 " + j + "번째 주사위 값 : " + comD);
								comSum += comD;
							}
							System.out.println("컴퓨터 주사위 총 합 : " + comSum);
							System.out.println("<< 결과 >>");
							System.out.println("나의 주사위 합       : " + userSum);
							System.out.println("컴퓨터의 주사위 합 : " + comSum);
							if (userSum == comSum) {
								scrDraw++;
								System.out.println("비겼습니다........");
							} else if (userSum > comSum) {
								scrWin++;
								System.out.println("승리!!!!");
								System.out.println("소지금이 " + userBet + "원 증가했습니다.");
								userMoney += userBet;
								System.out.println("현재 소지금 : " + userMoney);
							} else {
								scrLose++;
								System.out.println("패배...");
								System.out.println("소지금이 " + userBet + "원 감소했습니다.");
								userMoney -= userBet;
								if (userMoney == 0) {
									betSet++;
									System.out.println("거지 Bye~~~");
								}
								System.out.println("현재 소지금 : " + userMoney);
							}
						} else if (userBetAns == 'n') {
							keepPlay++;
							System.out.println("메뉴로 돌아갑니다.");
							System.out.println();
							break;
						} else {
							System.out.println("y 또는 n을 입력하세요.");
						}
						while (betSet == 0) {
							System.out.print("한번 더 하시겠습니까? [y/n] : ");
							char userAns = sc.next().charAt(0);
							switch (userAns) {
							case 'y':
								betSet++;
								break;
							case 'n':
								betSet++;
								keepPlay++;
								System.out.println("메뉴로 돌아갑니다.");
								System.out.println();
								break;
							default:
								System.out.println("잘못 입력하셨습니다.");
								System.out.println();
							}
						}
					}
				} // keepPlay while 종료 지점
				break;
			case 2:
				System.out.println("Win  : " + scrWin);
				System.out.println("Lose : " + scrLose);
				System.out.println("Draw : " + scrDraw);
				System.out.println("내 소지금 : " + userMoney);
				break;
			case 3:
				programOn++;
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}

	public void exam04() {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();

		boolean programOn = true; // 메뉴에서 프로그램을 재실행하는 변수
		
		int userWin = 0;
		int userLose = 0;
		int userDraw = 0;
		int userMoney = 10000;		
		
		int userDice, comDice;
		int userSum = 0;
		int comSum = 0;
		
		while (programOn == true) { // false 일시 프로그램 종료
			System.out.println("====== Dice Game ======");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.print("선택 > ");
						
			int selectMenu = sc.nextInt();
			
			switch (selectMenu) {
			case 2:
				System.out.println("<< 당신의 전적 >>");
				System.out.println("WIN : " + userWin);
				System.out.println("LOSE : " + userLose);
				System.out.println("DRAW : " + userDraw);
				System.out.println("내 소지금 : " + userMoney);				
				break;
				
			case 3:
				programOn = false;
				System.out.println("프로그램을 종료합니다.");
				break;
				
			case 1:
				while(true) {
					if(userMoney==0) { // 유저의 소지금이 부족하면 case 1 진행자체를 차단.
						System.out.println("소지금이 부족합니다");
						break;
					}
					
					System.out.println("<< Game Start >>");
					
					for(int i=1; i<=3; i++) {
						userDice=rn.nextInt(6)+1;
						userSum += userDice;
						System.out.println(i+"번째 주사위 값 : "+userDice); 						
					}					
					
					System.out.println("내 주사위 총 합 : " + userSum);
					
					System.out.print("배팅 하시겠습니까? [y/n] : ");
					char betAns = sc.next().charAt(0);
					int userBet;
					
					while (betAns=='y') {
						System.out.println("얼마를 배팅하시겠습니까?");
						System.out.println("현재 내 소지금 : "+userMoney);
						userBet = sc.nextInt();
						if(userBet>userMoney) {
							System.out.println("소지금이 부족합니다");
							continue;
						}
					} 
					if (betAns=='n') {
						
					}
					
				
					
					
				}
				break;
			default:				
				System.out.println("잘못된 입력입니다.");				
			}
		}
	}
}
