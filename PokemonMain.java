//몬스터 키우기
// TODO 대문자 / 메소드는 소문자 클래스는 대문자 변수는 소문자
package pokemon;

import java.util.Random;
import java.util.Scanner;

public class PokemonMain {
	static int bbagi = User.grayBbagi + User.blueBbagi;
	static User user = new User();
	static Scanner scan = new Scanner(System.in);
	static String userName;
	static int randomNumber;

	public static void main(String[] args) throws InterruptedException {
		// 오프닝음악 나오면서 시작 페이지
		Music openingMusic = new Music("opening.mp3", true);
		openingMusic.start();
		System.out.println("\r\n" + " _____         _       ______         _  _  _ \r\n"
				+ "|  __ \\       | |      | ___ \\       (_)| |(_)\r\n"
				+ "| |  \\/  ___  | |      | |_/ /  __ _  _ | | _ \r\n"
				+ "| | __  / _ \\ | |      |  __/  / _` || || || |\r\n"
				+ "| |_\\ \\| (_) ||_|      | |    | (_| || || || |\r\n"
				+ " \\____/ \\___/ (_)      \\_|     \\__,_||_||_||_|\r\n"
				+ "                                              \r\n"
				+ "                                              \r\n" + "");
		System.out.println("");
		System.out.println("");
		System.out.print("사용자 명을 입력해주세요:");
		userName = scan.nextLine();
		System.out.println("");
		System.out.println("");
		// 게임설명
		System.out.println("                               *게임 설명*");
		System.out.println("============================================================================");
		System.out.print(userName + "님 안녕하세요! ");
		System.out.println("포켓몬세계에 오신걸 환영합니다!");
		System.out.println("이 게임은 게임의 주인공이 되어 포켓몬을 데리고 돌아다니며  ");
		System.out.println("야생포켓몬도 잡고 포켓몬 배틀도 할 수 있습니다.");
		System.out.println("이 게임을 클리어하기 위해서는");
		System.out.println("회색시티,블루시티의 체육관을 돌아다니며 그곳의 관장과 싸워서 이겨 총 2개의 뺏지를 따야지 종료 되는 게임입니다.");
		System.out.println("============================================================================");
		System.out.println("");
		System.out.println("게임을 진행하시겠습니까?");
		System.out.println("진행하시려면 엔터키를 눌러주세요.");
		System.out.print("");
		System.out.println("");
		String storystart = scan.nextLine();

		// 태초마을
		openingMusic.close();
		// 태초마을 음악 재생
		Music cityMusic = new Music("town theme.mp3", true);
		cityMusic.start();
		// 밤낮 쓰레드
		DayNight dayNight = new DayNight(true);
		dayNight.start();
		Narration TaechoNarration = new Narration();
		TaechoNarration.TaechovillageNarration();
		System.out.println("이 소년의 이름은  " + userName + " 10살!!");
		System.out.println(userName + "가(이) 사는 태초마을에선 10살만 되면 포켓몬을 가질 수 있다.");
		System.out.println("그리고 포켓몬 연구가 오박사님에게 초보자용 포켓몬을 1마리 받을 수 있다.");
		System.out.println("이제 포켓몬 트레이너가 되기 위해 여행을 떠나보자!");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(userName + ": 으악!!! ");
		System.out.println(userName + ": !!!!");
		System.out.println(userName + ": !!!!");
		System.out.println(userName + ": !!!!");
		System.out.println(userName + ": 포켓몬 받을 생각에 너무 늦잠잤다ㅠㅠ ");
		System.out.println(userName + ": 얼른 오박사님께 가야지...");
		System.out.println("");
		System.out.println("");

		// 테초마을에서 선택할 수 있는 기능
		while (true) {
			Choice TaechovillageChoice = new Choice();
			TaechovillageChoice.TaechovillageChoice();
			System.out.print("번호 입력 :");
			int Taechochoice = scan.nextInt();
			switch (Taechochoice) {

			// 현재 사용자 상태창 보여주기
			case 1:
				System.out.println("현재 사용자 정보:");
				Choice startuserchoice = new Choice();
				startuserchoice.UserChoice();
				continue;

			// 오박사님께 포켓몬얻기,선물 받기
			case 2:
				if (User.userMedicine > 1) {
					System.out.println("오박사 : 이미 포켓몬을 얻었으니 어서 여행을 떠나보거라~!");
					System.out.println("");
					continue;
				}
				System.out.println("");
				System.out.println("======================================================");
				System.out.println("오박사님 연수소에 도착했다.");
				System.out.println(userName + ": 박사님 포켓몬 받으러왔어요!");
				System.out.println("오박사 : 아이구......! 너무 늦게 왔구나");
				System.out.println("오박사 : 포켓몬이 파이리만 남아있단다.");
				System.out.println(userName + ":파이리 좋아요!!! 제가 제일 좋아하는  포켓몬이에요");
				System.out.println("======================================================");
				System.out.println("");
				
				// 오박사 메뉴
				Narration ObaksaNarration = new Narration();
				ObaksaNarration.ObaksaNarration();
				System.out.print("번호입력 : ");
				Choice Obaksamenu = new Choice();
				int Obaksachoice = scan.nextInt();

				// 오박사 포켓몬 초이스
				if (Obaksachoice == 1) {
					Obaksamenu.Obaksapokemonchoice();
					Obaksamenu.Obaksagift();
					continue;
				}
				// 되돌아가기
				else if (Obaksachoice == 2) {
					continue;
				}

				// 다음 맵 이동, 포켓몬을 선택하지 않았으면 다음 맵 이동 불가.
			case 3:
				if (User.userMedicine > 1) {
					System.out.println("다음 맵으로 이동합니다.");
					break;
				} else {
					System.out.println("");
					System.err.println("포켓몬을 얻지 않았습니다.");
					System.err.println("다음 맵으로 이동할 수 없습니다.");
					System.err.println("오박사님께 돌아가 포켓몬을 얻고 여행을 떠나실 수 있습니다");
					System.out.println("");
					System.out.println("");
					continue;
				}
			}
			break;
		}

		System.out.println("");
		System.out.println("");
		System.out.println("포켓몬도 얻었으니 이제 여행을 떠나보자!");

		while (true) {
			System.out.println("어디로 향하시겠습니까?");
			System.out.println("[1번]그레이시티   [2번]블루시티");
			System.out.print("번호 입력:");
			int citychoice = scan.nextInt();

			switch (citychoice) {

			// 그레이시티 입장
			case 1:
				cityMusic.close();
				Narration grayNarration = new Narration();
				grayNarration.GraycityNarration();
				while (true) {

					// 그레이시티 메뉴
					// 그레이시티 음악재생
					Music graycityMusic = new Music("town theme.mp3", true);
					graycityMusic.start();
					Choice Graycitymenu = new Choice();
					Graycitymenu.Graycitychoice();
					System.out.print("번호 입력 :");
					int grayChoice = scan.nextInt();
					switch (grayChoice) {

					// 그레이체육관 입장
					case 1:
						graycityMusic.close();
						// 체육관 음악 재생
						Music GraygymMusic = new Music("pokemon gym.mp3", true);
						GraygymMusic.start();
						if (User.grayBbagi == 0) {
							System.out.println("체육관도착했습니다.");
							System.out.println("체육관에는 포켓몬 체육관 관장 웅이가 있다.");
							// 초이스클래스에 들어가 웅 선택창 보여주기
							Choice graygym = new Choice();
							graygym.Woongchoice();
							GraygymMusic.close();
							continue;
						} else if (User.grayBbagi == 1) {
							System.err.println("이미 그레이뱃지를 취득하셨습니다");
							System.out.println("");
							GraygymMusic.close();
							continue;
						}
						// 포켓못센터 입장
					case 2:
						graycityMusic.close();
						// 포켓몬 센터 뮤직 재생
						Music PokemoncenterMusic = new Music("pokemon center.mp3", true);
						PokemoncenterMusic.start();
						System.out.println("포켓몬센터 도착했습니다.");
						System.out.println("");
						// 포켓몬센터 나레이션
						Narration center = new Narration();
						center.NurseNarration();
						System.out.print("번호 입력 :");
						int nursechoice = scan.nextInt();

						// 포켓몬 치료
						if (nursechoice == 1) {
							Choice cure = new Choice();
							cure.Nursepokemoncure();
							PokemoncenterMusic.close();
						}
						// 아이템 사기
						else if (nursechoice == 2) {
							Choice itemsell = new Choice();
							itemsell.Nurseitemsell();
							PokemoncenterMusic.close();
						}
						// 나가기
						else if (nursechoice == 3) {
							PokemoncenterMusic.close();
							continue;
						}
						continue;

					// 사용자 상태창 보기
					case 3:
						graycityMusic.close();

						// 도시 음악 재생
						Music userMusic = new Music("town theme.mp3", true);
						userMusic.start();
						System.out.println(userName + "상태를 보겠습니다.");
						Choice userchoice = new Choice();
						userchoice.UserChoice();
						userMusic.close();
						continue;

					// 야생포켓몬 사냥
					case 4:
						graycityMusic.close();
						// 야생포켓몬과 전투 시 음악 재생
						Music wildpokemonMusic = new Music("battle (vs wild pokemon).mp3", true);
						wildpokemonMusic.start();
						System.out.println("야생포켓몬 잡으러 가자!");
						System.out.println("야생포켓몬이 나오기를 기다리고 있다.");
						System.out.println("");
						System.out.println("");
						Random graywildpokemon = new Random(); // 야생포켓몬 랜덤으로 나오게 하기
						randomNumber = graywildpokemon.nextInt(2) + 1; // case 넘버 1부터 주기 위해 +1
						switch (randomNumber) {
						case 1:
							System.out.println("야생포켓몬 캐터피 출현!!!");
							System.out.println("배틀 시작하겠습니다.");
							// 야생포켓몬과 <1.배틀을 한다. 2.도망간다> 선택
							Choice wildbattleketupi = new Choice();
							wildbattleketupi.WildchoiceKetupi();
							wildpokemonMusic.close();
							continue;
						case 2:
							System.out.println("야생포켓몬  롱스톤 출현!!!");
							System.out.println("배틀 시작하겠습니다.");
							System.out.println("");
							// 야생포켓몬과 <1.배틀을 한다. 2.도망간다> 선택
							Choice wildbattlelongston = new Choice();
							wildbattlelongston.WildchoiceLongston();
							wildpokemonMusic.close();
							continue;
						}
						// 다음 맵 이동
					case 5:
						graycityMusic.close();
						if (User.grayBbagi == 0) {
							System.err.println("뱃지를 얻지 못하면 다음 맵으로 이동할 수 없습니다.");
							continue;
						} else if (User.grayBbagi == 1) {
							break;
						}
					}
					break;
				}
				// 블루시티 입장
			case 2:
				if (User.grayBbagi == 0) {
					System.err.println("그레이 뱃지를 얻어야 블루시티로 이동할 수 있습니다.");
					System.out.println("");
					continue;
				} else if (User.grayBbagi == 1) {
					// 블루시티 설명
					Narration BlueNarration = new Narration();
					BlueNarration.BluecityNarration();
					while (true) {
						// 블루시티 음악 재생
						Music BluecityMusic = new Music("town theme.mp3", true);
						BluecityMusic.start();
						// 블루시티 메뉴
						Choice bluecitymenu = new Choice();
						bluecitymenu.Bluecitychoice();
						System.out.print("번호 입력 :");
						int Bluechoice = scan.nextInt();
						switch (Bluechoice) {
						// 체육관 입장
						case 1:
							BluecityMusic.close();
							Music BluegymMusic = new Music("pokemon gym.mp3", true);
							BluegymMusic.start();
							if (User.blueBbagi == 0) {
								System.out.println("체육관도착했습니다.");
								System.out.println("체육관에는 포켓몬 체육관 관장 이슬이 있다.");
								// 블루체육관 (1.배틀을 한다, 2.도망간다)
								Choice bluegym = new Choice();
								bluegym.EsuelChoice();
								BluegymMusic.close();
								continue;
							} else if (User.blueBbagi == 1) {
								System.err.println("이미 블루배지를 취득하셨습니다.");
								BluegymMusic.close();
								continue;
							}
							// 포켓몬센터 입장
						case 2:
							BluecityMusic.close();
							// 포켓몬센터 음악 재생
							Music PokemoncenterMusic = new Music("pokemon center.mp3", true);
							PokemoncenterMusic.start();
							System.out.println("포켓몬센터 도착했습니다.");
							// 간호사 설명
							Narration center = new Narration();
							center.NurseNarration();
							System.out.print("번호 입력 :");
							int nursechoice = scan.nextInt();
							// 포켓몬 치료하기
							if (nursechoice == 1) {
								Choice cure = new Choice();
								cure.Nursepokemoncure();
								PokemoncenterMusic.close();
							} else if (nursechoice == 2) {
								// 아이템 사기
								Choice itemsell = new Choice();
								itemsell.Nurseitemsell();
								PokemoncenterMusic.close();
							} else if (nursechoice == 3) {
								// 포켓몬 센터 나가기
								PokemoncenterMusic.close();
								continue;
							}
							continue;
						// 사용자 상태보기
						case 3:
							BluecityMusic.close();
							// 도시 음악 재생
							Music UserMusic = new Music("town theme.mp3", true);
							UserMusic.start();
							System.out.println(userName + "상태를 보겠습니다.");
							// 유저 상태 창 보여주기
							Choice userchoice = new Choice();
							userchoice.UserChoice();
							UserMusic.close();
							continue;
						// 야생포켓몬 사냥
						case 4:
							BluecityMusic.close();
							// 야생포켓몬 배틀 음악 재생
							Music WildpokemonMusic = new Music("battle (vs wild pokemon).mp3", true);
							WildpokemonMusic.start();
							System.out.println("야생포켓몬 잡으러 가자!");
							System.out.println("야생포켓몬이 나오기를 기다리고 있다.");
							System.out.println("");
							System.out.println("");
							// 블루시티 지역 야생포켓몬 랜덤 만남
							Random bluewildpokemon = new Random();
							randomNumber = bluewildpokemon.nextInt(2) + 1;
							switch (randomNumber) {
							case 1:
								System.out.println("야생포켓몬 캐터피 출현!!!");
								Choice wildbattleketupi = new Choice();
								wildbattleketupi.WildchoiceKetupi();
								WildpokemonMusic.close();
								continue;
							case 2:
								System.out.println("야생포켓몬  아쿠스타 출현!!!");
								Choice wildbattleaqustar = new Choice();
								wildbattleaqustar.WildchoiceAqustar();
								WildpokemonMusic.close();
								continue;
							}
							System.out.println("");
							break;
						// 엔딩
						case 5:
							BluecityMusic.close();
							if (User.blueBbagi == 0) {
								System.err.println("마지막 뱃지를 얻지 못하면 엔딩을 볼 수 없습니다.");
								continue;
							} else if (User.blueBbagi == 1) {
								// 블루시티 음악 끄기
								BluecityMusic.close();
								// 밤낮 쓰레드 끄기
								dayNight.close();
								// 엔딩 음악 재생
								Music EndingMusic = new Music("ending.mp3", true);
								EndingMusic.start();
								System.out.println("게임이 종료 되었습니다.");
								System.out.println("");
								System.out.println("2개의 배지를 모두 모은 " + userName + "님은 이 게임을 클리어하셨습니다.");
								System.out.println("축하드립니다!!!");
								System.out.println("");
								System.out.println("\r\n"
										+ "                                                                                                                    \r\n"
										+ "    ,o888888o.    8 8888         8 8888888888            .8.          8 888888888o.                                 \r\n"
										+ "   8888     `88.  8 8888         8 8888                 .888.         8 8888    `88.                                \r\n"
										+ ",8 8888       `8. 8 8888         8 8888                :88888.        8 8888     `88                                \r\n"
										+ "88 8888           8 8888         8 8888               . `88888.       8 8888     ,88                                \r\n"
										+ "88 8888           8 8888         8 888888888888      .8. `88888.      8 8888.   ,88'                                \r\n"
										+ "88 8888           8 8888         8 8888             .8`8. `88888.     8 888888888P'                                 \r\n"
										+ "88 8888           8 8888         8 8888            .8' `8. `88888.    8 8888`8b                                     \r\n"
										+ "`8 8888       .8' 8 8888         8 8888           .8'   `8. `88888.   8 8888 `8b.                                   \r\n"
										+ "   8888     ,88'  8 8888         8 8888          .888888888. `88888.  8 8888   `8b.                                 \r\n"
										+ "    `8888888P'    8 888888888888 8 888888888888 .8'       `8. `88888. 8 8888     `88.                               \r\n"
										+ "");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");
								System.out.println("");

								System.out.println("\r\n"
										+ " _____                     _         _     _____                      _   \r\n"
										+ "/  ___|                   (_)       | |   |  ___|                    | |  \r\n"
										+ "\\ `--.  _ __    ___   ___  _   __ _ | |   | |__  __   __  ___  _ __  | |_ \r\n"
										+ " `--. \\| '_ \\  / _ \\ / __|| | / _` || |   |  __| \\ \\ / / / _ \\| '_ \\ | __|\r\n"
										+ "/\\__/ /| |_) ||  __/| (__ | || (_| || |   | |___  \\ V / |  __/| | | || |_ \r\n"
										+ "\\____/ | .__/  \\___| \\___||_| \\__,_||_|   \\____/   \\_/   \\___||_| |_| \\__|\r\n"
										+ "       | |                                                                \r\n"
										+ "       |_|                                                                \r\n"
										+ "");
								System.out.println("");
								System.out.println("배지 2개를 모았으니  전설의 포켓몬을 만날 수  있는 기회가  생겼습니다.");
								System.out.println("전설의 포켓몬과 배틀을 할 수 있습니다.");
								System.out.println("\r\n" + "\r\n" +

										"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@~\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:,,-\r\n"
										+ "@@@@@@@@@@@@@@@@@~~@@@@ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@--..-\r\n"
										+ "@@@@@@@@@@@@@@@@;.~~@-,.-@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@~,  .=\r\n"
										+ "@@@@@@@@@@@@@@@@~ .-.   .-@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-. ,,!\r\n"
										+ "@@@@@@@@@@@@@@@@;.       -@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-,,. ., :\r\n"
										+ "@@@@@~@@@@@@@@@@@.       ,-@---@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@.   .- ,!\r\n"
										+ "@@@@@---~@@@@--@@@,       -@,.~ --@@@@@@@@@@@@@@@@@@@@@@@@@ @. .-  -=@\r\n"
										+ "@@@@@,  -~#@*,,~@@~,      ,:. ,. .@@@@@@~,~@@@@@@@@@@@@@@@@-- .- .:*@@\r\n"
										+ "@@@@@,. ..~:;,..-, .     .~-      ,@@@@@- ..~@@@@@@@@@@@@-... ~.,;@@@@\r\n"
										+ "--,-@--.  ,..~.           ..      , @@@@-.  ~-,~@@@@@@@@@,   . .!@@@@@\r\n"
										+ "-. .. ... .-  -.                 .@@@@@@@.  .. .;~@@@@,--.   , ;@@@@@@\r\n"
										+ "@,-.       :.  .~          .     .: @@@@-       .,@@@@,..   , .*@@@@@@\r\n"
										+ "@@@-.        ,.  .,.              ..,@@@-        ,-@~,    .-, ;@@@@@@@\r\n"
										+ "@@@~..,      ,~-   .,,.             ,@@@@,,      -~~-.   -:,,:#@@@@@@@\r\n"
										+ "@@@@@@~-.     ..-,    .,,...       .--;@@@,      .,~....~--~=@@@@@@@@@\r\n"
										+ "@@@@@@@@~-~,     ., .,.   .-        .-@@@@,,..    .,...--!#@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@-      .,-,,    ,~        ,@@@@@-,-.   ...-~:=@@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@-,..       ,,,  ..-,,,   .-@@@@@@:.     ...,~@@@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@,..       ,,~~  ,~-   ,@=!;!#@@.     ..  .,@@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@-~:,      .~~~    ,,..-~.   ,~**,         .@@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@:. .-..   .;~!.   ,--~,    -~,--.      -@@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@;~;-.. ..   ,,--     .~    ,~~~-     .,;@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@--,,:~,.    --,,   .,,,  .-!~..,    -@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@~@@@@~...,,,.-:,   ..        ..   ,@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@!;@*--,,,,,.     .     .-...-@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@$*#=*:---,,,,,,..:**-  .- --=@@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@#*~:;=*;;;:--,,,-:!@@$;..,=-~=@@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@$:~!$@@@@@#=!!;!$@@@@@#~,.:-,:@@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@;;:=@@@@@@$=$=#@@@@@@@@@!~:;-,;@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@*;;*$@@@@@@=$*=@@@@@@@@@@@@@#*:-!@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@$=!*#@@@@@@@==@@@@@@@@@@@@@@@@=*-;@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@$=#@@@@@@@@@@@@@@@@@@@@@@@@@@@@*;!@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@=@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n"
										+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\r\n" +

										"");
								System.out.println("도전하시겠습니까? ");
								System.out.println("[1번] 네       [2번] 아니오");
								System.out.print("번호 입력 :");
								int LegendChallenge = scan.nextInt();
								if (LegendChallenge == 1) {
									EndingMusic.close();
									// 레전드 포켓몬 발견시 야생포켓몬 배틀 노래 재생
									Music LegendMusic = new Music("battle (vs wild pokemon).mp3", true);
									LegendMusic.start();
									// 유저 포켓몬 생성
									GroupBattle pokemon1 = new GroupBattle(Choice.userPaili.Name);
									// 전설의 포켓몬 생성
									BattleLegend pokemon2 = new BattleLegend(BattleLegend.Fire.Name);
									// 유저(웅원해주는 사람) 생성
									Cheer usercheer = new Cheer();

									// 유저가 사용하는 포켓몬과 전설포켓몬의 우선순위를 같이 주었다.
									// 유저를 우선순위를 높이 주어 먼저 행동할 수 있게 만들었다.
									pokemon1.setPriority(Thread.MIN_PRIORITY);
									pokemon2.setPriority(Thread.MIN_PRIORITY);
									usercheer.setPriority(Thread.MAX_PRIORITY);

									// 쓰레드 시작
									usercheer.start();
									pokemon1.start(); // 유저 포켓몬 공격
									Thread.sleep(5000);
									pokemon2.start(); // 전설의 포켓몬 공격

								}
								// 전설의 포켓몬 도전 안하기
								else if (LegendChallenge == 2) {
									System.out.println("아니오. 이만 게임을 종료하겠습니다.");
									System.out.println("");
									System.out.println("");
									System.out.println();
									System.out.println("\r\n" + " _____  _                  _____             _ \r\n"
											+ "|_   _|| |                |  ___|           | |\r\n"
											+ "  | |  | |__    ___       | |__   _ __    __| |\r\n"
											+ "  | |  | '_ \\  / _ \\      |  __| | '_ \\  / _` |\r\n"
											+ "  | |  | | | ||  __/      | |___ | | | || (_| |\r\n"
											+ "  \\_/  |_| |_| \\___|      \\____/ |_| |_| \\__,_|\r\n"
											+ "                                               \r\n"
											+ "                                               \r\n" + "");

								}

								break;
							}
							break;
						}
						break;
					}
					break;
				}
				break;
			}
			break;
		}

	}
}
