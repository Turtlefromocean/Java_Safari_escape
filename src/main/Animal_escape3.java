package main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import bgm.게임종료bgm;
import bgm.던전bgm;
import bgm.마을bgm;
import character.Berry_tree;
import character.Monster_야생동물구조대;
import character.Monster_원숭이;
import character.Monster_전갈;
import character.Monster_팽귄;
import character.Piglet;
import character.Player_character;
import character.Pooh;
import character.Tiger;
import character.관리자모드;
import character.구조대원스킬;
import character.원숭이스킬;
import character.팽귄스킬;
import item.Cricket;
import item.Dobok;
import item.Glove;
import item.Goggle;
import item.Item_super;
import item.Potion_pill;
import 장소회복.숙소;
import 호스텔.NPC;

public class Animal_escape3 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String 게임시작 = "";
		int 최종기록 = 0;
		for (;;) {
			AudioClip clip;
			try {
				File file = new File(
						"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Unknown Artist/Unknown Album/게임시작화면.wav");
				clip = Applet.newAudioClip(file.toURL());
				clip.play();
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("                             =======================");
			System.out.println("                                  🌳사파리 탈출기🌳      ");
			System.out.println("                             =======================");
			System.out.println("                                    1. 게임시작      ");
			System.out.println("                                    2. 게임설명      ");

			게임시작 = sc.next();
			if (게임시작.equals("2")) {
				System.out.println("[게임설명]"); // 게임설명 넣기
				System.out
						.println("===================================================================================");
				System.out.println("\"사파리 탈출기\"를 찾아주신 모든 유저여러분 반갑습니다^0^\n");
				System.out.println("본 게임은 피글렛, 티거, 푸우 이 3마리 동물이 자유를 찾아 사파리동물원을 탈출해 나가는 내용입니다.\n");
				System.out.println("게임 첫 화면에서 이 3가지 동물 캐릭터 중 한 마리를 선택하실 수 있습니다.\n");
				System.out.println("각 캐릭터마다 쓸 수있는 스킬, hp, 공격력이 다르니 신중하게 선택해주세요!\n");
				System.out.println("캐릭터를 선택하면 본격적으로 게임이 진행됩니다.\n");
				System.out.println("캐릭터가 처음 있는 위치는 “숨겨진 마을”입니다.\n");
				System.out.println("“숨겨진 마을”에서 캐릭터는 상점, Cafe_Safari, 던전, 숙소로 이동할 수 있습니다.\n");
				System.out.println("상점에서는 아이템을 살 수도, 특정 아이템들을 강화하실 수도 있습니다.\n");
				System.out.println("Cafe_Safari 에서는 마을이웃들과 친밀도를 높여 도움을 주고 마을을 탈출하기 위한 비밀번호를 얻을 수 있습니다.");
				System.out.println("던전은 총 5개가 있습니다. 보유 아이템에 따라 출입에 제한이 있을 수 있으니 <마을內 공지>를 잘 살펴주세요!\n");
				System.out.println("숙소에 들어가면 캐릭터의 hp는 3초간 30씩, 스트레스지수는 1씩 줄어듭니다.\n");
				System.out.println("스트레스지수가 높을수록 플레이어의 공격속도가 줄어드므로 적절히 해소해 주세요!\n");
				System.out
						.println("===================================================================================");

				System.out.println("'엔터'키를 누르면 첫화면으로 돌아갑니다.");
				pause();
			}
			if (게임시작.equals("1"))
				break;
		}

		System.out.print("게임 로딩중 ");
		for (int i = 0; i <= 5; i++) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			if (i <= 4) {
				System.out.print("> ");
			}
			if (i == 5) {
				System.out.println("☑️ 로딩완료!(⤶)️️");
			}
		}

		pause();

		// 캐릭터 고르기//
		Piglet 피글렛 = new Piglet();
		Tiger 티거 = new Tiger();
		Pooh 푸우 = new Pooh();
		관리자모드 관리자 = new 관리자모드();
		Player_character 플레이어 = new Player_character();

		NPC 부엉이 = new NPC("???", 1, 0);
		NPC 독수리 = new NPC("???", 1, 0);
		NPC 거북이 = new NPC("???", 1, 0);
		NPC 공작 = new NPC("", 1, 0);

		Berry_tree 베리나무 = new Berry_tree();

		Item_super 아이템 = new Item_super();
		Item_super 던전1_보상 = new Item_super();
		Item_super 던전2_보상 = new Item_super();
		Item_super 던전3_보상 = new Item_super();
		Item_super 던전4_보상 = new Item_super();
		Item_super 던전5_보상 = new Item_super();

		Item_super 전갈의독해독제 = new Item_super();

		Item_super 차 = new Item_super();
		차.price = 500;

		Monster_전갈 전갈 = new Monster_전갈();
		Monster_원숭이 원숭이 = new Monster_원숭이();
		Monster_팽귄 팽귄 = new Monster_팽귄();
		Monster_야생동물구조대 야동구 = new Monster_야생동물구조대();

		Glove 권투글러브 = new Glove(); // 아이템 객체!
		Cricket 크리켓방망이 = new Cricket();
		Potion_pill 구급약 = new Potion_pill();
		Goggle 고글 = new Goggle();
		Dobok 유도도복 = new Dobok();

		String 캐릭터선정완료 = "";
		String 캐릭터고르기 = "";

		String 미션1 = "'🎄', '아이템'";
		String 미션2 = "'🦂', '제습'";
		String 미션3 = "'🐒', '롱OO'";
		String 미션4 = "'🐧', '...'";
		String 미션5 = "'☕️', 'Cafe_Safari'";
		String 미션 = 미션1;

		for (;;) {
			System.out.println("캐릭터를 골라주세요!");
			System.out.println("+----------+--------+--------+---------+");
			System.out.println("  [캐릭터]  |  체력   |  공격력  |   스킬   ");
			System.out.println("+----------+--------+--------+---------+");
			System.out.println(" 1. 피글렛🐷    160     15~25    코인증가 ");
			System.out.println("+----------+--------+--------+---------+");
			System.out.println(" 2. 푸우🐻     160     10~30    데미지감소 ");
			System.out.println("+----------+--------+--------+---------+");
			System.out.println(" 3. 티거🐯     180      20~40   시간단축  ");
			System.out.println("+----------+--------+--------+---------+");

			for (;;) {
				캐릭터고르기 = sc.next();
				if (캐릭터고르기.equals("1")) {
					플레이어 = 피글렛;
					break;
				} else if (캐릭터고르기.equals("2")) {
					플레이어 = 푸우;
					break;
				} else if (캐릭터고르기.equals("3")) {
					플레이어 = 티거;
					break;
				} else if (캐릭터고르기.equals("827")) {
					플레이어 = 관리자;
					break;
				} else {
					System.out.println("⚠️ 다시입력해주세요 ⚠️");
				}
			}

			System.out.printf("\"%s\"(으)로 게임을 진행하시겠습니까?\n", 플레이어.name);
			System.out.println("1. 네     2. 다시 고를래요");
			캐릭터선정완료 = sc.next();
			if (캐릭터선정완료.equals("1"))
				break;
			else {
			}
		}

		System.out.println("");
		System.out.printf("%s(은)는 가족들과 작별인사를 하고 무작정 걸어갔다.\n", 플레이어.name); // 로딩중 말고 스토리 넣기!
		System.out.println("‘언제까지 이런 울타리 속에서 지낼 수는 없어..!’");
		System.out.println("얼마쯤 걸었을까? 저 멀리서 동물들의 소리가 들리기 시작했다.");
		System.out.println("'??? 여기 마을이 있잖아?'(⤶)️");
		pause();
		System.out.println("————————————————————————— 숨겨진마을입구 🏕 ———————————————————————————————");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("<경고> 이 마을에 들어섰을때쯤 인간사육사들은 당신이 없어졌다는 것을 알게 될 겁니다.");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("     당신에게 주어진 시간은 15일 입니다. 15일이 지나면 마을의 위치가 노출될 위험이 ");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("     높아지므로 당신은 바로 퇴출됩니다. 그럼.. 굿럭🍀");
		System.out.println("                                          -숨겨진마을 촌장 및 마을주민 일동-");
		System.out.println("———————————————————————————————————————————————————————————————————————");
		System.out.println("                                                                     (⤶)️");
		pause();
		System.out.printf("%s: 15일..? 15일 정도면 충분해!(⤶)️", 플레이어.name);
		pause();
		System.out.println("\n⏰15일이내에 탈출구 비밀번호를 알아내어 탈출하세요!");
		System.out.println("(동물세계에서 하루는 인간세계로 1분 입니다!)(⤶)️");
		pause();

		System.out.println("제한시간 15일! 타이머 시작🧨🧨");
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}

		/*
		 * 원숭이스킬 원숭이의공격 = new 원숭이스킬(플레이어); Thread 원숭이의자동공격 = new Thread(원숭이의공격);
		 * 원숭이스킬.running = true; 원숭이의자동공격.start();
		 */
		Timer 타이머 = new Timer();
		Thread 제한시간스레드 = new Thread(타이머);
		제한시간스레드.start(); // 제한시간 타이머 스레드 사용!

		String 탈출이미지 = "|⑤";
		String 아이템사기 = "";
		String 마을_메뉴 = "";
		String 던전고르기 = "";
		String 아이템강화하기 = "";

		String 현재위치_플레이어_이미지 = "-";
		if (플레이어.name == "피글렛🐷") {
			현재위치_플레이어_이미지 = "\"🐷\"";
		}
		if (플레이어.name == "티거🐯") {
			현재위치_플레이어_이미지 = "\"🐯\"";
		}
		if (플레이어.name == "푸우🐻") {
			현재위치_플레이어_이미지 = "\"🐻\"";
		}
		if (플레이어.name == "관리자모드") {
			현재위치_플레이어_이미지 = "\"🎅🏼\"";
		}

		while (true) {
			if (던전1_보상.count != 0) {
				미션 = 미션2;
			}
			if (던전2_보상.count != 0) {
				미션 = 미션3;
			}
			if (던전3_보상.count != 0) {
				미션 = 미션4;
			}
			if (던전4_보상.count != 0) {
				미션 = 미션5;
			}
			if (던전5_보상.count != 0) {
				미션 = "던전 Clear!🥳";
			}
			if (플레이어.hp < 0) {
				플레이어.hp = 0;
			}
			String 비밀번호 = "";
			if (플레이어.동료수 == 0) {
				비밀번호 = "🔒🔒🔒🔒";
			}
			if (플레이어.동료수 == 1) {
				비밀번호 = "0️⃣🔒🔒🔒";
			}
			if (플레이어.동료수 == 2) {
				비밀번호 = "0️⃣4️⃣🔒🔒";
			}
			if (플레이어.동료수 == 3) {
				비밀번호 = "0️⃣4️⃣1️⃣🔒️";
			}
			if (플레이어.동료수 == 4) {
				비밀번호 = "0️⃣4️⃣1️⃣0️⃣";
				탈출이미지 = "🌟";
			}

			마을bgm.play(); // 마을bgm 시작

			플레이어.skill_cnt = 0;

			플레이어.플레이어속도 = 1000 + 플레이어.스트레스 * 10;
			String hp위험;
			String 스트레스위험;
			if (플레이어.hp < 50) {
				hp위험 = "❗️";
			} else {
				hp위험 = "";
			}
			if (플레이어.스트레스 < 4) {
				스트레스위험 = "️";
			} else {
				스트레스위험 = "❗";
			}

			System.out.println("==========================================================================");
			System.out.printf(" 숨겨진마을 🏕 | HP: %3d%s | 스트레스: %d%s | 보유코인: %d | 진행시간⏰: (%3d/900)\n", 플레이어.hp, hp위험,
					플레이어.스트레스, 스트레스위험, 플레이어.coin, 타이머.걸린시간);
			System.out.println("--------------------------------------------------------------------------");
			System.out.printf(" <마을內 공지> %s                                    %s\n", 미션, 비밀번호);
			System.out.println("                          ③ 🧟‍♂️: 던전                     ");
			System.out.println(
					"        ___________________|  |_____________________                                                ");
			System.out.printf("      %s____    _________    _______    __________%s \n", 현재위치_플레이어_이미지, 탈출이미지);
			System.out.println("              |  |         |  |       |  |               ");
			System.out.println("          ① 🍄: 상점        |  |     ④ 🛏: 숙소             s: 플레이어 상태창");
			System.out.println("                          ② 🍵: Cafe_Safari                    *: 게임종료");
			System.out.println("--------------------------------------------------------------------------");
			System.out.println(" [어디로 갈까요?]                     ");
			System.out.printf("  1. 상점    2. Cafe_Safari   3. 던전   4. 숙소   5. 탈출구\n");
			System.out.println("==========================================================================");
			마을_메뉴 = sc.next();
			if (마을_메뉴.equals("1")) {
				// System.out.printf("%s\n", 마을.isLoop);
				System.out.print("[상점]으로 이동중");
				for (int i = 0; i < 3; i++) {
					try {
						Thread.sleep(800);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
					System.out.print(". ");
				}

				while (true) {
					System.out.println("\n[상점]에서 무엇을 하시겠습니까?");
					System.out.println("1. 아이템사기     2. 장비강화");

					String 상점_선택 = sc.next();
					if (상점_선택.equals("1")) {
						while (true) {
							System.out.println("=================================================");
							System.out.printf(" 아이템 상점 🧚🏻‍♂️  |%-3s(HP: %-3d)  | 🍒: %4d베리\n", 플레이어.name, 플레이어.hp,
									플레이어.coin);
							System.out.println("-------------------------------------------------");
							System.out.println(" 1. 구급약 💊(HP 50 증가)            200베리");
							System.out.println(" 2. 고글 🥽 (체력범위 10 향상)         1000베리");
							System.out.println(" 3. 유도도복 🥋(체력범위 15 향상)       3000베리");
							System.out.println(" 4. 권투글러브 🥊 (공격력 10 향상)      1000베리");
							System.out.println(" 5. 크리켓방망이 🏏 (공격력 15 향상)    3000베리");
							System.out.println("-------------------------------------------------");
							System.out.println("필요한 아이템 번호를 입력해 주세요!         (Exit: 0) ");
							System.out.println(" - 주의: 한번 산 아이템은 되팔 수 없습니다           ");
							System.out.printf(" [인벤토리] 💊(%d) 🥽(%d) 🥋(%d) 🥊(%d) 🏏(%d)     ", 구급약.count, 고글.count,
									유도도복.count, 권투글러브.count, 크리켓방망이.count); // 플레이캐릭터에 '아이템 산다' 메서드 넣어놓기
							System.out.println("\n=================================================");
							아이템사기 = sc.next();
							if (아이템사기.equals("1") || 아이템사기.equals("2") || 아이템사기.equals("3") || 아이템사기.equals("4")
									|| 아이템사기.equals("5") || 아이템사기.equals("0")) {
								for (;;) {
									if (아이템사기.equals("0")) {
										마을bgm.stop();
										break;
									}
									if (아이템사기.equals("1")) {
										아이템 = 구급약;
									} else if (아이템사기.equals("2")) {
										아이템 = 고글;
									} else if (아이템사기.equals("3")) {
										아이템 = 유도도복;
									} else if (아이템사기.equals("4")) {
										아이템 = 권투글러브;
									} else if (아이템사기.equals("5")) {
										아이템 = 크리켓방망이;
									}

									System.out.printf("%s을 구입합니다.\n", 아이템.name);
									if (플레이어.coin >= 아이템.price) {
										if (아이템 != 구급약) {
											if (아이템.count == 1) {
												AudioClip 뭐안될때;
												try {
													File file = new File(
															"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
													뭐안될때 = Applet.newAudioClip(file.toURL());
													뭐안될때.play();
												} catch (Exception e) {
													e.printStackTrace();
												}
												System.out.println("이미 보유하셨습니다.");
												break;
											} else {
												AudioClip clip_1;
												try {
													File file = new File(
															"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Money Pickup by LeMudCrab Id-163451/Unknown Album/아이템살때.wav");
													clip_1 = Applet.newAudioClip(file.toURL());
													clip_1.play();
												} catch (Exception e) {
													e.printStackTrace();
												}

												플레이어.coin -= 아이템.price;
												아이템.count++;
												System.out.printf("-%d베리\n", 아이템.price);
												System.out.printf("%s을 구매하였습니다.\n", 아이템.name);
												break;
											}
										}
										if (아이템 == 구급약) {

											AudioClip clip_1;
											try {
												File file = new File(
														"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Money Pickup by LeMudCrab Id-163451/Unknown Album/아이템살때.wav");
												clip_1 = Applet.newAudioClip(file.toURL());
												clip_1.play();
											} catch (Exception e) {
												e.printStackTrace();
											}

											플레이어.coin -= 아이템.price;
											아이템.count++;
											System.out.printf("-%d베리\n", 아이템.price);
											System.out.printf("%s을 구매하였습니다.\n", 아이템.name);
											break;
										}
									} else {
										AudioClip 뭐안될때;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
											뭐안될때 = Applet.newAudioClip(file.toURL());
											뭐안될때.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										System.out.println("보유베리가 부족합니다.");
										break;
									}
								}
							} else {
								System.out.println("⚠️ 다시입력해주세요 ⚠️");
							}

							if (아이템사기.equals("0")) {
								마을bgm.stop();
								break;
							}
						}
						break;
					}

					if (상점_선택.equals("2")) {
						while (true) {
							System.out.println("=================================================");
							System.out.printf(" 장비강화소 🛠  |  %-3s(HP: %-3d) |   %4d베리\n", 플레이어.name, 플레이어.hp,
									플레이어.coin);
							System.out.println("-------------------------------------------------");
							System.out.println(" <현재 보유 강화재료 아이템>");
							System.out.printf(" - 전갈의 독🧪           %d개\n", Monster_전갈.전갈의독);
							System.out.printf(" - 원숭이의 바나나🍌      %d개\n", Monster_원숭이.바나나);
							System.out.printf(" - 황제팽귄의 왕관👑      %d개\n", Monster_팽귄.왕관);
							System.out.printf(" - 동물구조원의 뱃지     %d개\n", Monster_야생동물구조대.뱃지);
							System.out.println("**********************강화조건*********************");
							System.out.println(" - 권투글러브: '전갈의 독_2개', '원숭이의 바나나_3개'");
							System.out.println(" - 크리켓방망이: '황제팽귄의 왕관_2개', '동물구조원의 뱃지_2개'");
							System.out.println("-------------------------------------------------");
							System.out.println("[강화시킬 아이템을 골라주세요]                 (Exit: 0)");
							System.out.println(" 1. 권투글러브        2. 크리켓방망이               ");
							System.out.println("=================================================");

							아이템강화하기 = sc.next();

							if (아이템강화하기.equals("1")) {
								if (권투글러브.count == 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("강화시킬 아이템을 가지고 있지 않습니다.");
									System.out.println("                         (⤶)️");
									pause();
								} else {
									System.out.println("[아이템] '권투글러브' 강화");
									System.out.println("필요한 재료: '전갈의 독_ 2개', '원숭이의 바나나_3개' 입니다.");
									System.out.println("\n'엔터'키를 누르면 강화를 시작합니다.");
									pause();
									if (Monster_전갈.전갈의독 < 2 || Monster_원숭이.바나나 < 3) {
										AudioClip 뭐안될때;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
											뭐안될때 = Applet.newAudioClip(file.toURL());
											뭐안될때.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										System.out.println("[강화실패] 재료가 부족합니다.");
										System.out.println("                   (⤶)️");
										pause();
									}
									if (Monster_전갈.전갈의독 >= 2 && Monster_원숭이.바나나 >= 3) {
										int 강화랜덤 = (int) (Math.random() * 10 + 1);
										if (강화랜덤 <= 4) {
											AudioClip clip_2;
											try {
												File file = new File(
														"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Scale A6 by fins Id-171642/Unknown Album/장비강화성공&몬스터처치.wav");
												clip_2 = Applet.newAudioClip(file.toURL());
												clip_2.play();
											} catch (Exception e) {
												e.printStackTrace();
											}
											Glove.damage_to_atk += 10;
											System.out.printf("[강화성공] '권투글러브' 방어력 10 증가!(%d)\n", Glove.damage_to_atk);
											System.out.println("                                (⤶)️");
											pause();
										} else {
											AudioClip 뭐안될때;
											try {
												File file = new File(
														"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
												뭐안될때 = Applet.newAudioClip(file.toURL());
												뭐안될때.play();
											} catch (Exception e) {
												e.printStackTrace();
											}
											System.out.println("[강화실패] (⤶)️");
											pause();
										}
										Monster_전갈.전갈의독 -= 2;
										Monster_원숭이.바나나 -= 3;
									}
								}
							} else if (아이템강화하기.equals("2")) {
								if (크리켓방망이.count == 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("강화시킬 아이템을 가지고 있지 않습니다.");
									System.out.println("                          (⤶)️");
									pause();
								} else {
									System.out.println("[아이템] '크리켓방망이' 강화");
									System.out.println("필요한 재료: '황제팽귄의 왕관_2개', '동물구조원의 뱃지_2개' 입니다.");
									System.out.println("\n'엔터'키를 누르면 강화를 시작합니다.");
									pause();
									if (Monster_팽귄.왕관 < 2 || Monster_야생동물구조대.뱃지 < 2) {
										AudioClip 뭐안될때;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
											뭐안될때 = Applet.newAudioClip(file.toURL());
											뭐안될때.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										System.out.println("[강화실패] 재료가 부족합니다.");
										System.out.println("                   (⤶)️");
										pause();
										pause();
									}
									if (Monster_팽귄.왕관 >= 2 && Monster_야생동물구조대.뱃지 >= 2) {
										int 강화랜덤 = (int) (Math.random() * 10 + 1);
										if (강화랜덤 <= 4) {
											AudioClip clip_2;
											try {
												File file = new File(
														"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Scale A6 by fins Id-171642/Unknown Album/장비강화성공&몬스터처치.wav");
												clip_2 = Applet.newAudioClip(file.toURL());
												clip_2.play();
											} catch (Exception e) {
												e.printStackTrace();
											}
											Cricket.damage_to_atk += 10;
											System.out.printf("[강화성공] '크리켓방망이' 방어력 10 증가! (%d)\n",
													Cricket.damage_to_atk);
											System.out.println("                             (⤶)️");
											pause();
										} else {
											AudioClip 뭐안될때;
											try {
												File file = new File(
														"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
												뭐안될때 = Applet.newAudioClip(file.toURL());
												뭐안될때.play();
											} catch (Exception e) {
												e.printStackTrace();
											}
											System.out.println("[강화실패] (⤶)️");
											pause();
										}

										Monster_팽귄.왕관 -= 2;
										Monster_야생동물구조대.뱃지 -= 2;
									}
								}
							} else if (아이템강화하기.equals("0")) {
								마을bgm.stop();
								break; // 마을로 돌아감
							} else {
								System.out.println("⚠️ 다시입력해주세요 ⚠️");
							}
						}
						break;
					} else {
						System.out.println("⚠️ 다시입력해주세요 ⚠️");
					}
				}
			} else if (마을_메뉴.equals("2")) {
				// 카페사파리에서 호스텔 NPC 넣기!
				System.out.println("[카페]로 이동중.....");
				System.out.println("카페에서 차를 많이 마시면 친밀도가 상승합니다.");
				while (true) {
					if (플레이어.친밀도 > 1) {
						if (부엉이.미션완료 == 0) {
							부엉이.image = " - 🆙 마을촌장🦉: 황제팽귄의 왕관 1개가 필요하고 원숭이의 바나나 3개가 먹고싶네!!";
						}
						if (부엉이.미션완료 == 1) {
							부엉이.image = " - 마을촌장🦉: 미션완료!";
						}
					}
					if (부엉이.미션완료 == 1) {
						if (거북이.미션완료 == 0) {
							거북이.image = " - 🆙 이빨 빠진 거북이🐢: 잃어버린 내 틀니를 찾아줘 ㅠㅠ!";
						}
						if (거북이.미션완료 == 1) {
							거북이.image = " - 이빨 빠진 거북이🐢: 미션완료!";
						}

					}
					if (거북이.미션완료 == 1) {
						if (독수리.미션완료 == 0) {
							독수리.image = " - 🆙 다리 다친 독수리🦅: 전갈에게 물렸어.. 전갈의 독 해독제를 구해와줘!!";
						}
						if (독수리.미션완료 == 1) {
							독수리.image = " - 다리 다친 독수리🦅: 미션완료!";
						}
					}
					if (독수리.미션완료 == 1) {
						if (공작.미션완료 == 0) {
							공작.image = "🆙 '... 차만 팔기엔 수익이 안나.. 새로운 레시피가 필요해!'";
						}
						if (공작.미션완료 == 1) {
							공작.image = "미션완료!";
						}
					}

					System.out.println("=============================================================");
					System.out.printf(" Cafe_Safari 🍵                친밀도: %d  | 보유코인: %5d베리 \n", 플레이어.친밀도, 플레이어.coin);
					System.out.println("-------------------------------------------------------------");
					System.out.println("[카페주인] 🦚: 어서오세요! Cafe_Safari 입니다 ^0^");
					System.out.printf("             %s\n", 공작.image);
					System.out.println("[마을이웃]");
					System.out.printf("%s\n", 부엉이.image);
					System.out.printf("%s\n", 거북이.image);
					System.out.printf("%s\n", 독수리.image);
					System.out.println("-------------------------------------------------------------");
					System.out.println("무엇을 할까요?                                         (Exit: 0) ");
					System.out.println("1. 차 마시기(500베리)     2. 이웃 도와주기     3. 인벤토리 확인하기");
					System.out.println("=============================================================");
					String 카페_선택 = sc.next();
					for (;;) {
						if (카페_선택.equals("0")) {
							마을bgm.stop();
							break;
						} else if (카페_선택.equals("1")) {
							if (플레이어.coin >= 차.price) {
								AudioClip clip_1;
								try {
									File file = new File(
											"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Money Pickup by LeMudCrab Id-163451/Unknown Album/아이템살때.wav");
									clip_1 = Applet.newAudioClip(file.toURL());
									clip_1.play();
								} catch (Exception e) {
									e.printStackTrace();
								}
								플레이어.coin -= 차.price;
								차.count++;
								System.out.printf("-%d베리\n", 차.price);
								System.out.println("차를 마십니다."); // thread 넣기
								플레이어.친밀도++;
								System.out.printf("   친밀도 +1 (현재 친밀도: %d)\n", 플레이어.친밀도);

								break;
							} else {
								AudioClip 뭐안될때;
								try {
									File file = new File(
											"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
									뭐안될때 = Applet.newAudioClip(file.toURL());
									뭐안될때.play();
								} catch (Exception e) {
									e.printStackTrace();
								}
								System.out.println("보유베리가 부족합니다.");
								break;
							}
						} else if (카페_선택.equals("2")) { // NPC에게 말걸기
							if (플레이어.친밀도 < 2) {
								AudioClip 뭐안될때;
								try {
									File file = new File(
											"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
									뭐안될때 = Applet.newAudioClip(file.toURL());
									뭐안될때.play();
								} catch (Exception e) {
									e.printStackTrace();
								}
								System.out.println("친밀도가 낮아서 카페에 있는 마을이웃들이 말을 하기 꺼립니다.");
								System.out.println("                                          (⤶)️");
								pause();
								break;
							}
							if (플레이어.친밀도 >= 2) {
								if (부엉이.미션완료 == 0) {
									if (Monster_팽귄.왕관 < 1 || Monster_원숭이.바나나 < 3) {
										System.out.println("마을촌장 🦉: 그럼 부탁하네^^");
										System.out.println("                    (⤶)️");
										pause();
										break;
									} else if (Monster_팽귄.왕관 >= 1 && Monster_원숭이.바나나 >= 3) {
										System.out.println("마을촌장 🦉: 오오!! 고맙네^^ 고마우니 좋은 정보 하나 알려주지!");
										전갈의독해독제.count++;
										부엉이.미션완료 = 1;
										플레이어.동료수++;
										try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											System.out.println(e.getMessage());
										}
										AudioClip clip_2;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Scale A6 by fins Id-171642/Unknown Album/장비강화성공&몬스터처치.wav");
											clip_2 = Applet.newAudioClip(file.toURL());
											clip_2.play();
										} catch (Exception e) {
											e.printStackTrace();
										}

										System.out.printf(
												" ❇️️비밀번호 한자리 Get! 나머지 비밀번호를 알아내어 사파리를 빨리 탈출하세요! (남은시간: %d초)\n",
												900 - 타이머.걸린시간);
										System.out
												.println("                                                       (⤶)");
										Monster_팽귄.왕관--;
										Monster_원숭이.바나나 -= 3;

										pause();
										System.out.println("마을촌장 🦉: 부탁하나만 더 들어줄 수 있겠나?! 독수리군에게 이 전갈의독 해독제를 전해주게!");
										try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											System.out.println(e.getMessage());
										}
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Scale A6 by fins Id-171642/Unknown Album/장비강화성공&몬스터처치.wav");
											clip_2 = Applet.newAudioClip(file.toURL());
											clip_2.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										System.out.println(" ❇️[퀘스트아이템] '전갈의독 해독제'");
										System.out.println("                         (⤶)");
										pause();
										break;
									}
								} else if (거북이.미션완료 == 1 && 독수리.미션완료 == 0 && 전갈의독해독제.count != 0) {
									if (전갈의독해독제.count == 0) {
										System.out.println("다리다친독수리 🦅: ㅠㅠ 빨리 구해와줘");
										System.out.println("                          (⤶)️");
										pause();
										break;
									} else if (전갈의독해독제.count == 1) {
										System.out.printf("%s : 부엉이촌장님께 받은 전갈의 독 해독제를 전해주자!", 플레이어.name);
										System.out.println("                                                     (⤶)️");
										pause();
										System.out.println(
												"다리다친독수리 🦅: 넌 내 생명의 은인이야!! 마을을 탈출한다고 했지? 좋아! 내가 비밀번호 한자리 알려줄게!! ");
										전갈의독해독제.count--;
										독수리.미션완료 = 1;
										플레이어.동료수++;
										try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											System.out.println(e.getMessage());
										}
										AudioClip clip_2;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Scale A6 by fins Id-171642/Unknown Album/장비강화성공&몬스터처치.wav");
											clip_2 = Applet.newAudioClip(file.toURL());
											clip_2.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										System.out.printf(
												" ❇️️비밀번호 한자리 Get! 나머지 비밀번호를 알아내어 사파리를 빨리 탈출하세요! (남은시간: %d초)\n",
												900 - 타이머.걸린시간);
										System.out
												.println("                                                       (⤶)");
										pause();
										break;
									}
									break;
								}

								else if (부엉이.미션완료 == 1 && 거북이.미션완료 == 0) {
									if (Monster_야생동물구조대.구조대원이가져간틀니 == 0) {
										System.out.println("이빨빠진 거북이 🐢: 아마 구조대원이 가져갔을꺼야ㅜㅜ 독수리가 저번에 봤대");
										System.out.println("                                                     (⤶)️");
										pause();
										break;
									} else if (Monster_야생동물구조대.구조대원이가져간틀니 != 0) {
										System.out.printf("%s : 구조대원이 도망가면서 흘린 '거북이의 틀니'를 전해주자!", 플레이어.name);
										System.out.println("                                                     (⤶)️");
										pause();
										System.out.println("이빨빠진 거북이 🐢: 고마워ㅠㅠㅠ 틀니 찾아줬으니까 비밀정보 하나 알려줄게! ");
										거북이.미션완료 = 1;
										플레이어.동료수++;
										Monster_야생동물구조대.구조대원이가져간틀니--;
										try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											System.out.println(e.getMessage());
										}
										AudioClip clip_2;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Scale A6 by fins Id-171642/Unknown Album/장비강화성공&몬스터처치.wav");
											clip_2 = Applet.newAudioClip(file.toURL());
											clip_2.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										System.out.printf(
												" ❇️️비밀번호 한자리 Get! 나머지 비밀번호를 알아내어 사파리를 빨리 탈출하세요! (남은시간: %d초)\n",
												900 - 타이머.걸린시간);
										System.out
												.println("                                                       (⤶)");
										pause();

										break;
									}
								} else if (플레이어.동료수 == 3) {
									if (던전5_보상.count == 0) {
										System.out.printf("");
										break;
									} else if (던전5_보상.count != 0) {
										System.out.printf("%s : 구조대원을 물리치고 받은 아이템중에 믹스커피레시피를 갖다주자!", 플레이어.name);
										System.out.println("                                                     (⤶)️");
										pause();
										System.out.printf("카페주인 공작🦚: !!! 믹.스.커.피.레.시.피?!!!!\n");
										try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											System.out.println(e.getMessage());
										}
										System.out.printf("             원래는 안알려줄려고 했는데..기분이다! 내가 아는 비밀번호는 * 이야\n",
												플레이어.name);
										플레이어.동료수++;
										공작.미션완료 = 1;
										try {
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											System.out.println(e.getMessage());
										}
										AudioClip clip_2;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Scale A6 by fins Id-171642/Unknown Album/장비강화성공&몬스터처치.wav");
											clip_2 = Applet.newAudioClip(file.toURL());
											clip_2.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										System.out.printf("❇️마지막 비밀번호 Get! 빨리 사파리를 탈출하세요! (남은시간: %d초)\n",
												900 - 타이머.걸린시간);
										System.out.println("                                                   (⤶)");
										pause();

										break;
									}
								} else if (부엉이.미션완료 == 1 && 독수리.미션완료 == 1 && 거북이.미션완료 == 1 && 공작.미션완료 == 1) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("더이상 도울 이웃이 없습니다!");
									break;
								}

							}
						}
						if (카페_선택.equals("3")) {
							String 인벤토리퀘스트전갈의독 = "";
							String 인벤토리퀘스트거북이틀니 = "";
							String 인벤토리퀘스트커피믹스 = "";

							if (전갈의독해독제.count == 1) {
								인벤토리퀘스트전갈의독 = "'전갈의독 해독제'";
							}
							if (Monster_야생동물구조대.구조대원이가져간틀니 == 1) {
								if (거북이.미션완료 == 1) {
									인벤토리퀘스트거북이틀니 = "";
								} else{
									인벤토리퀘스트거북이틀니 = "'구조대원이 가져간 거북이의 틀니'";
								}
							}
							if (던전5_보상.count >= 1) {
								if (공작.미션완료 == 1) {
									인벤토리퀘스트커피믹스 = "";
								} else{
									인벤토리퀘스트커피믹스 = "'믹스커피 레시피'";
								}
							}

							System.out.println(
									"———————————————————————————————————————————————————————————————————————————");
							System.out.println("[인벤토리]                                        ");
							System.out.printf("- 몬스터 아이템: 전갈의독🧪(%d) 원숭이의바나나🍌(%d) 황제팽귄의 왕관👑(%d) 구조대원의 뱃지(%d)\n",
									Monster_전갈.전갈의독, Monster_원숭이.바나나, Monster_팽귄.왕관, Monster_야생동물구조대.뱃지);
							System.out.printf("- 기타 아이템: %s %s %s\n", 인벤토리퀘스트전갈의독, 인벤토리퀘스트거북이틀니, 인벤토리퀘스트커피믹스);
							System.out.println(
									"———————————————————————————————————————————————————————————————————————————");
							System.out.println(
									"                                                                       (⤶)️");
							pause();
							break;
						} else {
							System.out.println("⚠️ 다시입력해주세요 ⚠️");
							break;
						}
					}
					if (카페_선택.equals("0")) {
						마을bgm.stop();
						break;
					}
				}
			} else if (마을_메뉴.equals("3")) {
				String 자물쇠1 = "🎄";
				String 자물쇠2 = "🔒";
				String 자물쇠3 = "🔒";
				String 자물쇠4 = "🔒";
				String 자물쇠5 = "🔒";
				if (던전1_보상.count == 1) {
					자물쇠2 = "🦂";
				}
				if (던전2_보상.count == 1) {
					자물쇠3 = "🐒";
				}
				if (던전3_보상.count == 1) {
					자물쇠4 = "🐧";
				}
				if (던전4_보상.count == 1) {
					자물쇠5 = "👷🏼‍♂️";
				}

				System.out.println("==================================================");
				System.out.println("[들어갈 던전을 골라주세요]");
				System.out.printf("1. 던전1_여정의시작%s 2. 던전2_고난의시작%s 3. 던전3_고난의연속%s" + "\n4. 던전4_고난의중첩%s 5. 던전5_최후의고난%s\n",
						자물쇠1, 자물쇠2, 자물쇠3, 자물쇠4, 자물쇠5);

				던전고르기 = sc.next();
				if (던전고르기.equals("1")) {
					마을bgm.stop();
					던전bgm.play();
					System.out.println("이동중...");
					System.out.println("\n'엔터'키를 누르면 입장합니다.");
					pause();

					System.out.println("——————————————————————————————————————————————————");
					System.out.println("[던전1. 여정의 시작]");
					System.out.println(" ✉️ 던전1은 장비착용으로 인한 효과가 발동되지 않습니다.");
					System.out.println("——————————————————————————————————————————————————\n");

					System.out.printf("%s : 이 던전에는 몬스터가 없는 것 같다.(⤶)\n", 플레이어.name);
					pause();
					String 공격_or_마을 = "";
					int 쓰러뜨린_몬스터_수 = 0;

					for (;;) {

						System.out.println("===========================================");
						System.out.printf(" 던전1. 여정의 시작  |%-3s(HP: %-3d)|%4d베리\n", 플레이어.name, 플레이어.hp, 플레이어.coin);
						System.out.println("-------------------------------------------");
						System.out.println("               ###                      ");
						System.out.println("              #o###                     ");
						System.out.println("            #####o###                   ");
						System.out.println("            ###\\|/#o#                   ");
						System.out.println("             # }|{  #    _베리나무_       ");
						System.out.printf("               }|{        HP: %3d       \n", 베리나무.hp);
						System.out.println("-------------------------------------------");
						System.out.printf(" 베리나무를 공격해서 코인을 얻으세요! (%d그루)      \n", 쓰러뜨린_몬스터_수);
						System.out.println(" 1. 공격하기     2. 마을로 돌아가기            ");
						System.out.println("===========================================");

						공격_or_마을 = sc.next();
						if (공격_or_마을.equals("2")) {
							break;
						} else if (공격_or_마을.equals("1")) {
							플레이어.attack(베리나무);
							try {
								Thread.sleep(플레이어.플레이어속도 + 플레이어.스트레스 * 50);
							} catch (InterruptedException e) {
								System.out.println(e.getMessage());
							}
							베리나무.베리스킬(플레이어);
							if (베리나무.hp <= 0) {
								AudioClip clip_2;
								try {
									File file = new File(
											"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Scale A6 by fins Id-171642/Unknown Album/장비강화성공&몬스터처치.wav");
									clip_2 = Applet.newAudioClip(file.toURL());
									clip_2.play();
								} catch (Exception e) {
									e.printStackTrace();
								}
								쓰러뜨린_몬스터_수++;
								System.out.println("\n ❇️베리나무가 쓰러졌다!");
								System.out.printf("   + %d💰 \n", 베리나무.coin);
								플레이어.get_coin(베리나무);
								베리나무.hp = 30;
							}
						} else {
							System.out.println("⚠️ 다시입력해주세요 ⚠️");
						}
						if (쓰러뜨린_몬스터_수 >= 3)
							break;
					}
					던전bgm.stop();
					if (쓰러뜨린_몬스터_수 == 3) {

						AudioClip 던전클리어;
						try {
							File file = new File(
									"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Unknown Artist/Unknown Album/던전클리어효과음.wav");
							던전클리어 = Applet.newAudioClip(file.toURL());
							던전클리어.play();
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println("\n🔆[던전1]여정의 시작 Clear!!🔆");
						System.out.println(" > 아이템 보상: 미스트");
						던전1_보상.count = 1;
						System.out.println(" > 코인 보상: 300🍒"); // thread 구현
						플레이어.coin += 300;
						System.out.println("'엔터'키를 누르면 마을로 돌아갑니다.");
						pause();
					}

				} else if (던전고르기.equals("2")) {
					마을bgm.stop();

					if (던전1_보상.count == 0) {
						AudioClip 뭐안될때;
						try {
							File file = new File(
									"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
							뭐안될때 = Applet.newAudioClip(file.toURL());
							뭐안될때.play();
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println("[보유아이템이 부족해 입장하실 수 없습니다]");
					} else {
						if (플레이어.hp < 40) {
							AudioClip 뭐안될때;
							try {
								File file = new File(
										"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
								뭐안될때 = Applet.newAudioClip(file.toURL());
								뭐안될때.play();
							} catch (Exception e) {
								e.printStackTrace();
							}
							System.out.println("[체력이 부족합니다. 던전에 입장하실 수 없습니다.]");
						} else {
							던전bgm.play();
							System.out.println("이동중...");
							System.out.println("\n'엔터'키를 누르면 입장합니다.");
							pause();

							System.out.println("——————————————————————————————————————————————————");
							System.out.println("[던전2. 고난의 시작]");
							System.out.println(" ✉️ 던전2는 턴제형식입니다.");
							System.out.println("——————————————————————————————————————————————————\n");
							System.out.printf("%s : 더워.. 미스트 없었으면 큰일날 뻔 했다.\n", 플레이어.name);
							System.out.println("    !!!! 아야..!! \n");
							전갈.attack(플레이어);
							System.out.printf("- 현재HP %d\n", 플레이어.hp);
							System.out.println("\n'전갈'의 기습 공격!");
							System.out.println("\n'엔터'키를 누르면 전투를 시작합니다.(⤶)");
							pause();

							System.out.println("");
							// 이거 메소드로 놓고 싶은데....?
							if (권투글러브.count == 1) {
								플레이어.attack_max += Glove.damage_to_atk;
								System.out.printf("[권투글러브] 효과! 공격력 +%d\n", Glove.damage_to_atk);
							}

							if (크리켓방망이.count == 1) {
								플레이어.attack_max += Cricket.damage_to_atk;
								System.out.printf("[크리켓방망이] 효과! 공격력 +%d\n", Cricket.damage_to_atk);
							}

							if (고글.count == 1) {
								플레이어.hp_max += Goggle.plus_to_hp;
								System.out.println("[고글] 효과! 최대체력 +10");
							}

							if (유도도복.count == 1) {
								플레이어.hp_max += Dobok.plus_to_hp;
								System.out.println("[유도도복] 효과! 최대체력 +10");
							}
							// 여기까지

							String 공격_선택 = "";
							int 쓰러뜨린_몬스터_수 = 0;

							Piglet 피글렛스킬 = new Piglet(전갈);
							Thread 피글렛스킬쓰레드 = new Thread(피글렛스킬);

							Pooh 푸우스킬 = new Pooh(전갈);
							Thread 푸우스킬쓰레드 = new Thread(푸우스킬);

							Tiger 티거스킬 = new Tiger(티거);
							Thread 티거스킬쓰레드 = new Thread(티거스킬);

							전갈.coin = (int) (Math.random() * (300) + 100);
							전갈.attack_max = 20;
							티거.플레이어속도 = 1000;
							for (;;) {

								// System.out.println("================================================================");
								// System.out.printf(" 던전2. 고난의 시작 |%-3s(HP: %-3d)|야생성: %-4d |💊: %2d개
								// |%4d베리\n", 플레이어.name, 플레이어.hp, 플레이어.exp, 구급약.count, 플레이어.coin);
								// System.out.println("----------------------------------------------------------------");
								// System.out.println(" _ _ ");
								// System.out.println(" /_] [_\\ ");
								// System.out.println(" // \\ ");
								// System.out.println(" \\ // ");
								// System.out.println(" \\`-..-'/ _전갈_ ");
								// System.out.printf(" `\\ /` HP: %3d \n", 전갈.hp);
								// System.out.println(" || ( ) ");
								// System.out.println(" \\___/ ");
								// System.out.println("----------------------------------------------------------------");
								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}
								System.out
										.println("\n================================================================");
								System.out.printf(" 🔴전투🔴 %s(HP: %d) VS %s(HP: %d)  (%d마리)      \n", 플레이어.name,
										플레이어.hp, 전갈.name, 전갈.hp, 쓰러뜨린_몬스터_수);
								System.out.printf(" 1. 공격하기     2. 스킬사용     3. 구급약사용(%d)     4. 마을귀환\n", 구급약.count);
								System.out.println("================================================================");

								공격_선택 = sc.next();
								if (공격_선택.equals("1")) {
									플레이어.attack(전갈);
									try {
										Thread.sleep(플레이어.플레이어속도 + 플레이어.스트레스 * 50);
									} catch (InterruptedException e) {
										System.out.println(e.getMessage());
									}
									// System.out.println(플레이어.플레이어속도 + 플레이어.스트레스 * 50); // 로그!
									전갈.attack(플레이어);
									전갈.전갈스킬(플레이어);
									if (전갈.hp <= 0) {
										AudioClip clip_2;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Scale A6 by fins Id-171642/Unknown Album/장비강화성공&몬스터처치.wav");
											clip_2 = Applet.newAudioClip(file.toURL());
											clip_2.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										쓰러뜨린_몬스터_수++;
										플레이어.exp += 전갈.exp;
										System.out.println("\n ❇️전갈을 쓰러뜨렸다!");
										플레이어.get_coin(전갈);
										System.out.printf("   + %d💰 \n", 전갈.coin);
										전갈.아이템주기();
										전갈.hp = 100;
									}

								} else if (공격_선택.equals("2")) {
									if (플레이어 == 피글렛) {
										if (플레이어.skill_cnt == 1) {
											System.out.println("🛠스킬을 이미 사용하셨습니다.🛠");

										} else {

											Piglet.running = true;
											피글렛스킬쓰레드.start();
											플레이어.skill_cnt = 1;
										}
									}
									if (플레이어 == 푸우) {
										if (플레이어.skill_cnt == 1) {
											System.out.println("🛠스킬을 이미 사용하셨습니다.🛠");

										} else {

											Pooh.running = true;
											푸우스킬쓰레드.start();
											플레이어.skill_cnt = 1;
										}
									}
									if (플레이어 == 티거) {
										if (플레이어.skill_cnt != 0) {
											System.out.println("🛠스킬을 이미 사용하셨습니다.🛠");

										} else {
											Tiger.running = true;
											티거스킬쓰레드.start();
											플레이어.skill_cnt = 1;
										}
									}

								} else if (공격_선택.equals("3")) {
									if (구급약.count == 0) {
										AudioClip 뭐안될때;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
											뭐안될때 = Applet.newAudioClip(file.toURL());
											뭐안될때.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										System.out.println("보유한 구급약이 없습니다");
									}
									if (구급약.count > 0) {
										if (플레이어.hp < 플레이어.hp_max - 50) {
											플레이어.potion();
											구급약.count--;
										} else {
											AudioClip 뭐안될때;
											try {
												File file = new File(
														"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
												뭐안될때 = Applet.newAudioClip(file.toURL());
												뭐안될때.play();
											} catch (Exception e) {
												e.printStackTrace();
											}
											System.out.println("지금은 사용하실 수 없습니다.");
										}
									}

								} else if (공격_선택.equals("4")) {
									if (Piglet.running = true) {
										Piglet.terminate();
									}
									if (Pooh.running = true) {
										Pooh.terminate();
									}
									if (Tiger.running = true) {
										Tiger.terminate();
									}
									던전bgm.stop();

									break;
								} else {
									System.out.println("⚠️ 다시입력해주세요 ⚠️");
								}
								if (쓰러뜨린_몬스터_수 >= 3)
									break;
							}
							if (Piglet.running = true) {
								Piglet.terminate();
							}
							if (Pooh.running = true) {
								Pooh.terminate();
							}
							if (Tiger.running = true) {
								Tiger.terminate();
							}
							// 다시 원상복귀!
							if (권투글러브.count == 1) {
								플레이어.attack_max -= Glove.damage_to_atk;
							}

							if (크리켓방망이.count == 1) {
								플레이어.attack_max -= Cricket.damage_to_atk;
							}

							if (고글.count == 1) {
								플레이어.hp_max -= Goggle.plus_to_hp;
							}

							if (유도도복.count == 1) {
								플레이어.hp_max -= Dobok.plus_to_hp;
							}
							//

							if (쓰러뜨린_몬스터_수 == 3) {
								던전bgm.stop();
								AudioClip 던전클리어;
								try {
									File file = new File(
											"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Unknown Artist/Unknown Album/던전클리어효과음.wav");
									던전클리어 = Applet.newAudioClip(file.toURL());
									던전클리어.play();
								} catch (Exception e) {
									e.printStackTrace();
								}
								System.out.println("\n🔆[던전2]고난의 시작🦂 Clear!!🔆");
								System.out.println(" > 아이템 보상: 제습기");
								던전2_보상.count = 1;
								System.out.println(" > 코인 보상: 500🍒"); // thread 구현
								플레이어.coin += 500;
								System.out.println("('엔터'키를 누르면 마을로 돌아갑니다.)");
								pause();
							}
						}
					}
				} else if (던전고르기.equals("3")) {
					마을bgm.stop();

					if (던전2_보상.count == 0) {
						AudioClip 뭐안될때;
						try {
							File file = new File(
									"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
							뭐안될때 = Applet.newAudioClip(file.toURL());
							뭐안될때.play();
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println("[보유아이템이 부족해 입장하실 수 없습니다]");
					} else {
						if (플레이어.hp < 40) {
							AudioClip 뭐안될때;
							try {
								File file = new File(
										"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
								뭐안될때 = Applet.newAudioClip(file.toURL());
								뭐안될때.play();
							} catch (Exception e) {
								e.printStackTrace();
							}
							System.out.println("[체력이 부족합니다. 던전에 입장하실 수 없습니다.]"); // 이상?
						} else {
							던전bgm.play();
							System.out.println("이동중...");
							System.out.println("\n'엔터'키를 누르면 입장합니다.");
							pause();

							System.out.println("——————————————————————————————————————————————————");
							System.out.println("[던전3. 고난의 연속]");
							System.out.println(" ✉️ 던전3부터 출몰하는 몬스터는 자동공격을 진행합니다.");
							System.out.println("——————————————————————————————————————————————————\n");
							System.out.printf("%s : 아우 습해!!!.. 제습기 없었으면 큰일날 뻔 했다.\n", 플레이어.name);
							System.out.println("     아악..!! \n");
							원숭이.attack(플레이어);
							System.out.printf("- 현재HP %d\n", 플레이어.hp);
							System.out.println("\n'원숭이'의 기습 공격!");
							System.out.println("\n'엔터'키를 누르면 전투를 시작합니다.(⤶)");
							pause();

							System.out.println(""); //

							// 보유 아이템 ++
							if (권투글러브.count != 0) {
								플레이어.attack_max += Glove.damage_to_atk;
								System.out.printf("[권투글러브] 효과! 공격력 +%d\n", Glove.damage_to_atk);
							}

							if (크리켓방망이.count != 0) {
								플레이어.attack_max += Cricket.damage_to_atk;
								System.out.printf("[크리켓방망이] 효과! 공격력 +%d\n", Cricket.damage_to_atk);
							}

							if (고글.count != 0) {
								플레이어.hp_max += Goggle.plus_to_hp;
								System.out.println("[고글] 효과! 최대체력 +10");
							}

							if (유도도복.count != 0) {
								플레이어.hp_max += Dobok.plus_to_hp;
								System.out.println("[유도도복] 효과! 최대체력 +10");
							}
							// 여기까지

							String 공격_선택 = "";
							int 쓰러뜨린_몬스터_수 = 0;
							원숭이스킬 원숭이의공격 = new 원숭이스킬(플레이어);
							Thread 원숭이의자동공격 = new Thread(원숭이의공격);
							원숭이스킬.running = true;
							원숭이의자동공격.start();

							Piglet 피글렛스킬 = new Piglet(원숭이);
							Thread 피글렛스킬쓰레드 = new Thread(피글렛스킬);

							Pooh 푸우스킬 = new Pooh(원숭이);
							Thread 푸우스킬쓰레드 = new Thread(푸우스킬);

							Tiger 티거스킬 = new Tiger(티거);
							Thread 티거스킬쓰레드 = new Thread(티거스킬);

							원숭이.coin = (int) (Math.random() * (300) + 100);
							원숭이.attack_max = 30;
							티거.플레이어속도 = 1000;
							플레이어.skill_cnt = 0;
							for (;;) {
								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}

								// System.out.println("===============================================================");
								// System.out.printf(" 던전3. 고난의 연속 |%-3s(HP: %-3d)|야생성: %-4d |💊: %2d개
								// |%4d베리\n", 플레이어.name, 플레이어.hp, 플레이어.exp, 구급약.count, 플레이어.coin);
								// System.out.println("---------------------------------------------------------------");
								// System.out.println(" w c(..)o ( ");
								// System.out.println(" \\__(-) __) ");
								// System.out.println(" /\\ ( ");
								// System.out.println(" /(_)___) ");
								// System.out.println(" w /| _원숭이_ ");
								// System.out.printf(" | \\ HP: %3d \n", 원숭이.hp);
								// System.out.println(" m m ");
								// System.out.println("===============================================================");
								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}

								try {
									Thread.sleep(플레이어.플레이어속도 + 플레이어.스트레스 * 50);
								} catch (InterruptedException e) {
									System.out.println(e.getMessage());
								}

								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}
								System.out
										.println("\n================================================================");
								System.out.printf(" 🔴전투🔴 %s(HP: %d) VS %s(HP: %d)  (%d마리)      \n", 플레이어.name,
										플레이어.hp, 원숭이.name, 원숭이.hp, 쓰러뜨린_몬스터_수);
								System.out.printf(" 1. 공격하기     2. 스킬사용     3. 구급약사용(%d)     4. 마을귀환\n", 구급약.count);
								System.out.println("================================================================");
								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}

								공격_선택 = sc.next();
								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}
								if (공격_선택.equals("1")) {
									플레이어.attack(원숭이);
									원숭이.원숭이스킬(플레이어);
									if (원숭이.hp <= 0) {
										AudioClip clip_2;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Scale A6 by fins Id-171642/Unknown Album/장비강화성공&몬스터처치.wav");
											clip_2 = Applet.newAudioClip(file.toURL());
											clip_2.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										쓰러뜨린_몬스터_수++;
										플레이어.exp += 원숭이.exp;
										System.out.println("\n ❇️원숭이가 도망친다!");
										플레이어.get_coin(원숭이);
										System.out.printf("   + %d💰 \n", 원숭이.coin);
										원숭이.아이템주기();
										원숭이.hp = 120;
									}
								} else if (공격_선택.equals("2")) {
									if (플레이어 == 피글렛) {
										if (플레이어.skill_cnt == 1) {
											System.out.println("🛠스킬을 이미 사용하셨습니다.🛠");

										} else {

											Piglet.running = true;
											피글렛스킬쓰레드.start();
											플레이어.skill_cnt = 1;
										}
									}
									if (플레이어 == 푸우) {
										if (플레이어.skill_cnt == 1) {
											System.out.println("🛠스킬을 이미 사용하셨습니다.🛠");

										} else {

											Pooh.running = true;
											푸우스킬쓰레드.start();
											플레이어.skill_cnt = 1;
										}
									}
									if (플레이어 == 티거) {
										if (플레이어.skill_cnt != 0) {
											System.out.println("🛠스킬을 이미 사용하셨습니다.🛠");

										} else {
											Tiger.running = true;
											티거스킬쓰레드.start();
											플레이어.skill_cnt = 1;
										}
									}
								} else if (공격_선택.equals("3")) {
									if (구급약.count == 0) {
										AudioClip 뭐안될때;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
											뭐안될때 = Applet.newAudioClip(file.toURL());
											뭐안될때.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										System.out.println("보유한 구급약이 없습니다");
									}
									if (구급약.count > 0) {
										if (플레이어.hp < 플레이어.hp_max - 50) {
											플레이어.potion();
											구급약.count--;
										} else {
											AudioClip 뭐안될때;
											try {
												File file = new File(
														"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
												뭐안될때 = Applet.newAudioClip(file.toURL());
												뭐안될때.play();
											} catch (Exception e) {
												e.printStackTrace();
											}
											System.out.println("지금은 사용하실 수 없습니다.");
										}
									}

								} else if (공격_선택.equals("4")) {
									던전bgm.stop();
									원숭이스킬.terminate();
									if (Piglet.running = true) {
										Piglet.terminate();
									}
									if (Pooh.running = true) {
										Pooh.terminate();
									}
									if (Tiger.running = true) {
										Tiger.terminate();
									}

									break;
								} else {
									System.out.println("⚠️ 다시입력해주세요 ⚠️");
								}
								if (쓰러뜨린_몬스터_수 >= 3)
									break;
							}
							if (Piglet.running = true) {
								Piglet.terminate();
							}
							if (Pooh.running = true) {
								Pooh.terminate();
							}
							if (Tiger.running = true) {
								Tiger.terminate();
							}

							/*
							 * if(플레이어.hp <= 0) { System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다"); pause(); }
							 */
							// 다시 원상복귀!
							if (권투글러브.count != 0) {
								플레이어.attack_max -= Glove.damage_to_atk;
							}

							if (크리켓방망이.count != 0) {
								플레이어.attack_max -= Cricket.damage_to_atk;
							}

							if (고글.count != 0) {
								플레이어.hp_max -= Goggle.plus_to_hp;
							}

							if (유도도복.count != 0) {
								플레이어.hp_max -= Dobok.plus_to_hp;
							}
							//
							if (쓰러뜨린_몬스터_수 == 3) {
								던전bgm.stop();
								원숭이스킬.terminate();
								AudioClip 던전클리어;
								try {
									File file = new File(
											"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Unknown Artist/Unknown Album/던전클리어효과음.wav");
									던전클리어 = Applet.newAudioClip(file.toURL());
									던전클리어.play();
								} catch (Exception e) {
									e.printStackTrace();
								}
								System.out.println("\n🔆[던전3]고난의 연속🐒 Clear!!🔆");
								System.out.println(" > 아이템 보상: 롱패딩");
								던전3_보상.count = 1;
								System.out.println(" > 코인 보상: 700🍒"); // thread 구현
								플레이어.coin += 700;
								System.out.println("('엔터'키를 누르면 마을로 돌아갑니다.)");
								pause();
							}
						}
					}
				} else if (던전고르기.equals("4")) {
					마을bgm.stop();

					if (던전3_보상.count == 0) {
						AudioClip 뭐안될때;
						try {
							File file = new File(
									"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
							뭐안될때 = Applet.newAudioClip(file.toURL());
							뭐안될때.play();
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println("[보유아이템이 부족해 입장하실 수 없습니다]");
					} else {
						if (플레이어.hp < 40) {
							AudioClip 뭐안될때;
							try {
								File file = new File(
										"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
								뭐안될때 = Applet.newAudioClip(file.toURL());
								뭐안될때.play();
							} catch (Exception e) {
								e.printStackTrace();
							}
							System.out.println("[체력이 부족합니다. 던전에 입장하실 수 없습니다.]");
						} else {
							던전bgm.play();
							System.out.println("이동중...");
							System.out.println("\n'엔터'키를 누르면 입장합니다.");
							pause();

							System.out.println("——————————————————————————————————————————————————————");
							System.out.println("[던전4. 고난의 중첩]");
							System.out.println(" ✉️ 던전4부터 몬스터의 공격력은 급격히 증가합니다. 무기를 강화하세요!");
							System.out.println("——————————————————————————————————————————————————————\n");
							System.out.printf("%s : 아으 추워..🥶 롱패딩 없었으면 큰일날뻔 했다.. \n", 플레이어.name);
							System.out.println("🐧: 꾸웨엑!!!!!!!!! \n");
							팽귄.attack(플레이어);
							System.out.printf("- 현재HP %d\n", 플레이어.hp);
							System.out.println("\n'황제팽귄'의 기습 공격!");
							System.out.println("\n'엔터'키를 누르면 전투를 시작합니다.(⤶)");
							pause();

							// 보유아이템!!
							if (권투글러브.count != 0) {
								플레이어.attack_max += Glove.damage_to_atk;
								System.out.printf("[권투글러브] 효과! 공격력 +%d\n", Glove.damage_to_atk);
							}

							if (크리켓방망이.count != 0) {
								플레이어.attack_max += Cricket.damage_to_atk;
								System.out.printf("[크리켓방망이] 효과! 공격력 +%d\n", Cricket.damage_to_atk);
							}

							if (고글.count != 0) {
								플레이어.hp_max += Goggle.plus_to_hp;
								System.out.println("[고글] 효과! 최대체력 +10");
							}

							if (유도도복.count != 0) {
								플레이어.hp_max += Dobok.plus_to_hp;
								System.out.println("[유도도복] 효과! 최대체력 +10");
							}
							// 여기까지
							String 공격_선택 = "";
							int 쓰러뜨린_몬스터_수 = 0;
							팽귄스킬 팽귄의공격 = new 팽귄스킬(플레이어);
							Thread 팽귄의자동공격 = new Thread(팽귄의공격);
							팽귄스킬.running = true;
							팽귄의자동공격.start();

							Piglet 피글렛스킬 = new Piglet(팽귄);
							Thread 피글렛스킬쓰레드 = new Thread(피글렛스킬);

							Pooh 푸우스킬 = new Pooh(팽귄);
							Thread 푸우스킬쓰레드 = new Thread(푸우스킬);

							Tiger 티거스킬 = new Tiger(티거);
							Thread 티거스킬쓰레드 = new Thread(티거스킬);

							팽귄.coin = (int) (Math.random() * (500) + 300);
							팽귄.attack_max = 40;
							티거.플레이어속도 = 1000 + 플레이어.스트레스 * 10;
							플레이어.skill_cnt = 0;
							for (;;) {
								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}

								// System.out.println("================================================================");
								// System.out.printf(" 던전4. 고난의 중첩 |%-3s(HP: %-3d)| 야생성: %-4d |💊: %2d개
								// |%4d베리\n", 플레이어.name, 플레이어.hp, 플레이어.exp, 구급약.count, 플레이어.coin);
								// System.out.println("----------------------------------------------------------------");
								// System.out.println(" __ ");
								// System.out.println(" -=(o '. ");
								// System.out.println(" '.-.\\ ");
								// System.out.println(" /| \\\\ ");
								// System.out.println(" '| || _황제팽귄_ ");
								// System.out.printf(" _\\_):,_ HP: %3d \n", 팽귄.hp);
								// System.out.println("----------------------------------------------------------------");
								// System.out.printf(" [전투] %s VS %s (%d마리) \n", 플레이어.name, 팽귄.name,
								// 쓰러뜨린_몬스터_수);
								// System.out.println(" 1. 공격하기 2. 스킬사용 3. 구급약사용 4. 마을로 돌아가기 ");
								// System.out.println("================================================================");
								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}

								try {
									Thread.sleep(플레이어.플레이어속도 + 플레이어.스트레스 * 50);
								} catch (InterruptedException e) {
									System.out.println(e.getMessage());
								}

								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}

								System.out.println("================================================================");
								System.out.printf(" 🔴전투🔴 %s(HP: %d) VS %s(HP: %d)  (%d마리)      \n", 플레이어.name,
										플레이어.hp, 팽귄.name, 팽귄.hp, 쓰러뜨린_몬스터_수);
								System.out.printf(" 1. 공격하기     2. 스킬사용     3. 구급약사용(%d)     4. 마을귀환\n", 구급약.count);
								System.out.println("================================================================");
								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}

								공격_선택 = sc.next();

								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}

								if (공격_선택.equals("1")) {
									플레이어.attack(팽귄);
									팽귄.팽귄스킬(플레이어); // 팽귄스킬 만들기! 만듦..
									if (팽귄.hp <= 0) {
										AudioClip clip_2;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Scale A6 by fins Id-171642/Unknown Album/장비강화성공&몬스터처치.wav");
											clip_2 = Applet.newAudioClip(file.toURL());
											clip_2.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										쓰러뜨린_몬스터_수++;
										플레이어.exp += 원숭이.exp;
										System.out.println("\n ❇️황제팽귄이 도망친다!");
										플레이어.get_coin(팽귄);
										System.out.printf("   + %d💰 \n", 팽귄.coin);
										팽귄.아이템주기();
										팽귄.hp = 130;
									}
								} else if (공격_선택.equals("2")) {
									if (플레이어 == 피글렛) {
										if (플레이어.skill_cnt == 1) {
											System.out.println("🛠스킬을 이미 사용하셨습니다.🛠");

										} else {

											Piglet.running = true;
											피글렛스킬쓰레드.start();
											플레이어.skill_cnt = 1;
										}
									}
									if (플레이어 == 푸우) {
										if (플레이어.skill_cnt == 1) {
											System.out.println("🛠스킬을 이미 사용하셨습니다.🛠");

										} else {

											Pooh.running = true;
											푸우스킬쓰레드.start();
											플레이어.skill_cnt = 1;
										}
									}
									if (플레이어 == 티거) {
										if (플레이어.skill_cnt != 0) {
											System.out.println("🛠스킬을 이미 사용하셨습니다.🛠");

										} else {
											Tiger.running = true;
											티거스킬쓰레드.start();
											플레이어.skill_cnt = 1;
										}
									}
								}

								else if (공격_선택.equals("3")) {
									if (구급약.count == 0) {
										AudioClip 뭐안될때;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
											뭐안될때 = Applet.newAudioClip(file.toURL());
											뭐안될때.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										System.out.println("보유한 구급약이 없습니다");
									}
									if (구급약.count > 0) {
										if (플레이어.hp < 플레이어.hp_max - 50) {
											플레이어.potion();
											구급약.count--;
										} else {
											AudioClip 뭐안될때;
											try {
												File file = new File(
														"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
												뭐안될때 = Applet.newAudioClip(file.toURL());
												뭐안될때.play();
											} catch (Exception e) {
												e.printStackTrace();
											}
											System.out.println("지금은 사용하실 수 없습니다.");
										}
									}

								}

								else if (공격_선택.equals("4")) {
									던전bgm.stop();
									팽귄스킬.terminate();
									if (Piglet.running = true) {
										Piglet.terminate();
									}
									if (Pooh.running = true) {
										Pooh.terminate();
									}
									if (Tiger.running = true) {
										Tiger.terminate();
									}
									break;
								} else {
									System.out.println("⚠️ 다시입력해주세요 ⚠️");
								}
								if (쓰러뜨린_몬스터_수 >= 3)
									break;
							}

							if (Piglet.running = true) {
								Piglet.terminate();
							}
							if (Pooh.running = true) {
								Pooh.terminate();
							}
							if (Tiger.running = true) {
								Tiger.terminate();
							}
							// 다시 원상복귀!
							if (권투글러브.count != 0) {
								플레이어.attack_max -= Glove.damage_to_atk;
							}

							if (크리켓방망이.count != 0) {
								플레이어.attack_max -= Cricket.damage_to_atk;
							}

							if (고글.count != 0) {
								플레이어.hp_max -= Goggle.plus_to_hp;
							}

							if (유도도복.count != 0) {
								플레이어.hp_max -= Dobok.plus_to_hp;
							}
							//
							if (쓰러뜨린_몬스터_수 == 3) {
								던전bgm.stop();
								팽귄스킬.terminate();
								AudioClip 던전클리어;
								try {
									File file = new File(
											"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Unknown Artist/Unknown Album/던전클리어효과음.wav");
									던전클리어 = Applet.newAudioClip(file.toURL());
									던전클리어.play();
								} catch (Exception e) {
									e.printStackTrace();
								}
								System.out.println("\n🔆[던전4]고난의 중첩🐧 Clear!!🔆");
								System.out.println(" > 아이템 보상: 마스크");
								던전4_보상.count = 1;
								System.out.println(" > 코인 보상: 1000🍒"); // thread 구현
								플레이어.coin += 1000;
								System.out.println("('엔터'키를 누르면 마을로 돌아갑니다.)");
								pause();
							}
						}
					}
				} else if (던전고르기.equals("5")) {
					마을bgm.stop();
					if (던전4_보상.count == 0) {
						AudioClip 뭐안될때;
						try {
							File file = new File(
									"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
							뭐안될때 = Applet.newAudioClip(file.toURL());
							뭐안될때.play();
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println("[보유아이템이 부족해 입장하실 수 없습니다]");
					} else {
						if (플레이어.hp < 40) {
							AudioClip 뭐안될때;
							try {
								File file = new File(
										"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
								뭐안될때 = Applet.newAudioClip(file.toURL());
								뭐안될때.play();
							} catch (Exception e) {
								e.printStackTrace();
							}
							System.out.println("[체력이 부족합니다. 던전에 입장하실 수 없습니다.]");
						} else {

							던전bgm.play();
							System.out.println("이동중...");
							System.out.println("\n'엔터'키를 누르면 입장합니다.");
							pause();

							System.out.println("——————————————————————————————————————————————————————");
							System.out.println("[던전5. 최후의 고난]");
							System.out.println(" ✉️ 마지막던전입니다! 빠르게 클리어해서 동료들과 마을을 탈출하세요!");
							System.out.println("——————————————————————————————————————————————————————\n");
							System.out.printf("%s : 콜록콜록!! 마스크 없으면 숨도 못쉬겠다..\n", 플레이어.name);
							System.out.println("    빼애애애애애앵~!!!!! \n");
							야동구.attack(플레이어);
							System.out.printf("- 현재HP %d\n", 플레이어.hp);
							System.out.println("\n'야생동물구조대'에 발견되었다!!");
							System.out.println("\n'엔터'키를 누르면 전투를 시작합니다.(⤶)");
							pause();

							// 보유아이템!!
							if (권투글러브.count != 0) {
								플레이어.attack_max += Glove.damage_to_atk;
								System.out.printf("[권투글러브] 효과! 공격력 +%d\n", Glove.damage_to_atk);
							}

							if (크리켓방망이.count != 0) {
								플레이어.attack_max += Cricket.damage_to_atk;
								System.out.printf("[크리켓방망이] 효과! 공격력 +%d\n", Cricket.damage_to_atk);
							}

							if (고글.count != 0) {
								플레이어.hp_max += Goggle.plus_to_hp;
								System.out.println("[고글] 효과! 최대체력 +10");
							}

							if (유도도복.count != 0) {
								플레이어.hp_max += Dobok.plus_to_hp;
								System.out.println("[유도도복] 효과! 최대체력 +10");
							}
							// 여기까지

							String 공격_선택 = "";
							int 쓰러뜨린_몬스터_수 = 0;
							구조대원스킬 구조대원의공격 = new 구조대원스킬(플레이어);
							Thread 구조대원의자동공격 = new Thread(구조대원의공격);
							구조대원스킬.running = true;
							구조대원의자동공격.start();

							Piglet 피글렛스킬 = new Piglet(야동구);
							Thread 피글렛스킬쓰레드 = new Thread(피글렛스킬);

							Pooh 푸우스킬 = new Pooh(야동구);
							Thread 푸우스킬쓰레드 = new Thread(푸우스킬);

							Tiger 티거스킬 = new Tiger(티거);
							Thread 티거스킬쓰레드 = new Thread(티거스킬);

							야동구.coin = (int) (Math.random() * (1000) + 700);
							야동구.attack_max = 45;
							티거.플레이어속도 = 1000 + 플레이어.스트레스 * 10;
							플레이어.skill_cnt = 0;
							for (;;) {
								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}

								// System.out.println("==============================================================");
								// System.out.printf(" 던전5. 최후의 고난 |%-3s(HP: %-3d)|야생성: %-4d |💊: %2d개
								// |%4d베리\n", 플레이어.name, 플레이어.hp, 플레이어.exp, 구급약.count, 플레이어.coin);
								// System.out.println("--------------------------------------------------------------");
								// System.out.println(" \\\\ ///// ");
								// System.out.println(" | | ");
								// System.out.println(" (| _ _ |) ");
								// System.out.println(" |` | '| ");
								// System.out.println(" | __ | _야생동물구조대_ ");
								// System.out.printf(" >>>___/\\_^__/\\___<<< HP: %3d \n", 야동구.hp);
								// System.out.println(" / ||| \\ ");
								// System.out.println("--------------------------------------------------------------");
								// System.out.printf(" [전투] %s VS %s (%d명) \n", 플레이어.name, 야동구.name,
								// 쓰러뜨린_몬스터_수);
								// System.out.println(" 1. 공격하기 2. 스킬사용 3. 구급약사용 4. 마을로 돌아가기 ");
								// System.out.println("==============================================================");
								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}

								try {
									Thread.sleep(플레이어.플레이어속도 + 플레이어.스트레스 * 50);
								} catch (InterruptedException e) {
									System.out.println(e.getMessage());
								}

								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}
								System.out.println("================================================================");
								System.out.printf(" 🔴전투🔴 %s(HP: %d) VS %s(HP: %d)  (%d명)      \n", 플레이어.name, 플레이어.hp,
										야동구.name, 야동구.hp, 쓰러뜨린_몬스터_수);
								System.out.printf(" 1. 공격하기     2. 스킬사용     3. 구급약사용(%d)     4. 마을귀환\n", 구급약.count);
								System.out.println("================================================================");

								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}

								공격_선택 = sc.next();

								if (플레이어.hp <= 0) {
									AudioClip 뭐안될때;
									try {
										File file = new File(
												"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
										뭐안될때 = Applet.newAudioClip(file.toURL());
										뭐안될때.play();
									} catch (Exception e) {
										e.printStackTrace();
									}
									System.out.println("\n🚨HP부족🚨 마을로 돌아갑니다");
									던전bgm.stop();
									pause();
									break;
								}

								if (공격_선택.equals("1")) {
									플레이어.attack(야동구);
									야동구.구조대원스킬(플레이어);
									if (야동구.hp <= 0) {
										AudioClip clip_2;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Scale A6 by fins Id-171642/Unknown Album/장비강화성공&몬스터처치.wav");
											clip_2 = Applet.newAudioClip(file.toURL());
											clip_2.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										쓰러뜨린_몬스터_수++;
										플레이어.exp += 야동구.exp;
										System.out.println("\n ❇️야생동물구조대원이 도망친다!");
										플레이어.get_coin(야동구);
										System.out.printf("   + %d💰 \n", 야동구.coin);
										야동구.아이템주기();
										야동구.hp = 150;
									}

								} else if (공격_선택.equals("2")) {
									if (플레이어 == 피글렛) {
										if (플레이어.skill_cnt == 1) {
											System.out.println("🛠스킬을 이미 사용하셨습니다.🛠");

										} else {

											Piglet.running = true;
											피글렛스킬쓰레드.start();
											플레이어.skill_cnt = 1;
										}
									}
									if (플레이어 == 푸우) {
										if (플레이어.skill_cnt == 1) {
											System.out.println("🛠스킬을 이미 사용하셨습니다.🛠");

										} else {

											Pooh.running = true;
											푸우스킬쓰레드.start();
											플레이어.skill_cnt = 1;
										}
									}
									if (플레이어 == 티거) {
										if (플레이어.skill_cnt != 0) {
											System.out.println("🛠스킬을 이미 사용하셨습니다.🛠");

										} else {
											Tiger.running = true;
											티거스킬쓰레드.start();
											플레이어.skill_cnt = 1;
										}
									}
								}

								else if (공격_선택.equals("3")) {
									if (구급약.count == 0) {
										AudioClip 뭐안될때;
										try {
											File file = new File(
													"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
											뭐안될때 = Applet.newAudioClip(file.toURL());
											뭐안될때.play();
										} catch (Exception e) {
											e.printStackTrace();
										}
										System.out.println("보유한 구급약이 없습니다");
									}
									if (구급약.count > 0) {
										if (플레이어.hp < 플레이어.hp_max - 50) {
											플레이어.potion();
											구급약.count--;
										} else {
											AudioClip 뭐안될때;
											try {
												File file = new File(
														"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
												뭐안될때 = Applet.newAudioClip(file.toURL());
												뭐안될때.play();
											} catch (Exception e) {
												e.printStackTrace();
											}
											System.out.println("지금은 사용하실 수 없습니다.");
										}
									}

								}

								else if (공격_선택.equals("4")) {
									던전bgm.stop();
									구조대원스킬.terminate();
									if (Piglet.running = true) {
										Piglet.terminate();
									}
									if (Pooh.running = true) {
										Pooh.terminate();
									}
									if (Tiger.running = true) {
										Tiger.terminate();
									}

									break;
								} else {
									System.out.println("⚠️ 다시입력해주세요 ⚠️");
								}
								if (쓰러뜨린_몬스터_수 >= 5)
									break;
							}
							if (Piglet.running = true) {
								Piglet.terminate();
							}
							if (Pooh.running = true) {
								Pooh.terminate();
							}
							if (Tiger.running = true) {
								Tiger.terminate();
							}
							// 다시 원상복귀!
							if (권투글러브.count != 0) {
								플레이어.attack_max -= Glove.damage_to_atk;
							}

							if (크리켓방망이.count != 0) {
								플레이어.attack_max -= Cricket.damage_to_atk;
							}

							if (고글.count != 0) {
								플레이어.hp_max -= Goggle.plus_to_hp;
							}

							if (유도도복.count != 0) {
								플레이어.hp_max -= Dobok.plus_to_hp;
							}
							//
							if (쓰러뜨린_몬스터_수 == 5) {
								던전bgm.stop();
								구조대원스킬.terminate();
								AudioClip 던전클리어;
								try {
									File file = new File(
											"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Unknown Artist/Unknown Album/던전클리어효과음.wav");
									던전클리어 = Applet.newAudioClip(file.toURL());
									던전클리어.play();
								} catch (Exception e) {
									e.printStackTrace();
								}
								System.out.println("\n🔆[던전5]최후의 고난👷🏼‍♂️ Clear!!🔆");
								System.out.println(" > 아이템 보상: 믹스커피 레시피");
								던전5_보상.count++;
								System.out.println(" > 코인 보상: 1500🍒"); // thread 구현
								플레이어.coin += 1500;
								System.out.println("('엔터'키를 누르면 마을로 돌아갑니다.)");
								pause();
							}
						}
					}
				} else {
					System.out.println("⚠️ 다시입력해주세요 ⚠️");
					마을bgm.stop();
				}
			}

			else if (마을_메뉴.equals("4")) {
				System.out.println("숙소로 돌아갑니다.");
				System.out.printf("이동중");
				for (int i = 0; i < 2; i++) {
					try {
						Thread.sleep(800);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
					System.out.print(". ");
				}
				숙소 숙소회복 = new 숙소(플레이어);
				Thread 숙소자동회복 = new Thread(숙소회복);
				숙소.running = true;
				숙소자동회복.start();
				System.out.println("");
				System.out.printf("📝️[현재상태] HP: %d, 스트레스: %d \n", 플레이어.hp, 플레이어.스트레스);
				System.out.println("==========================================");
				System.out.printf(" %s의 숙소 💤\n", 플레이어.name);
				System.out.println("------------------------------------------");
				System.out.println("             __                         ");
				System.out.println("            /()\\````\\                 ");
				System.out.println("           /____\\____\\                ");
				System.out.println("           |n  n|.___|                  ");
				System.out.println("           | __ /_\\___\\               ");
				System.out.println("           | || |n|n_n|                 ");
				System.out.println("------------------------------------------");
				System.out.println("[숙소에 돌아와 휴식을 취합니다]");
				System.out.println("'엔터'키를 누르면 마을로 돌아갑니다.            ");
				System.out.println("==========================================");

				pause();
				숙소.running = false;
				마을bgm.stop();

			} else if (마을_메뉴.equals("5")) {
				System.out.println("비밀번호를 입력해주세요"); // 마을_메뉴 == 5 오버
				String 탈출비밀번호 = sc.next();
				if (탈출비밀번호.equals("0410")) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
					최종기록 = 타이머.걸린시간;
					Timer.terminate();

					System.out.println("🎉사파리 탈출 성공!🎉");

					마을bgm.stop();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
					break;
				} else {
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
					AudioClip 뭐안될때;
					try {
						File file = new File(
								"/Users/shinjiyoung/Music/iTunes/iTunes Media/Music/Ma Sfx Snes Jumps 1 by Dneproman Id-334850/Unknown Album/뭐 안될때.wav");
						뭐안될때 = Applet.newAudioClip(file.toURL());
						뭐안될때.play();
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("⚠️ 틀렸습니다! ⚠️");
					마을bgm.stop();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			} else if (마을_메뉴.equals("s")) {
				int 플레이어공격력 = 플레이어.attack_max;
				if (권투글러브.count == 1) {
					플레이어공격력 = 플레이어.attack_max + Glove.damage_to_atk;
				}
				if (크리켓방망이.count == 1) {
					플레이어공격력 = 플레이어.attack_max + Cricket.damage_to_atk;
				}
				System.out.println("———————————————————————————————————————————————————————————————————");
				System.out.printf("📝[플레이어 상태] (HP: %3d %s) / (스트레스: %2d %s)\n", 플레이어.hp, hp위험, 플레이어.스트레스, 스트레스위험);
				System.out.printf("(야생성: %3d) / (공격력: %3d) / (스피드: %2.2f초당 1회공격) / (보유코인: %5d)\n", 플레이어.exp,
						플레이어공격력 + (int) (플레이어.exp / 100) * 10, (double) (플레이어.플레이어속도 + 플레이어.스트레스 * 50) / 1000,
						플레이어.coin);
				System.out.println("———————————————————————————————————————————————————————————————————");
				System.out.println("                                                                (⤶)️");
				pause();
				마을bgm.stop();
			} else if (마을_메뉴.equals("*")) {
				System.out.println("게임을 종료합니다.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
				System.exit(0);
			} else if (마을_메뉴.equals("power_up")) {
				System.out.println("💬 [CheatKey] 플레이어의 공격력 +10 !");
				플레이어.attack_max += 10;
				플레이어.attack_min += 10;
				System.out.println("                             (⤶)️");
				pause();
				마을bgm.stop();
			} else if (마을_메뉴.equals("coin_plus")) {
				System.out.println("💬 [CheatKey] 플레이어의 보유코인 +1000 !");
				플레이어.coin += 1000;
				System.out.println("                                 (⤶)️");
				pause();
				마을bgm.stop();
			} else {
				System.out.println("⚠️ 다시입력해주세요 ⚠️");
				마을bgm.stop();
			}
		}
		if (Timer.running == true) {
			Timer.running = false;
		}
		게임종료bgm.play();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("==========================================");
		System.out.println("             🏆 최 종 기 록 🏆              ");
		System.out.println("==========================================");

		System.out.printf("  탈출하는데 걸린 시간 : ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.printf("%d 초\n", 최종기록);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.printf("  최 종 보 유 베 리 : ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.printf("%d 베리\n", 플레이어.coin);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.printf("  야 생 성 : ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.printf("%d \n", 플레이어.exp);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("------------------------------------------");
		System.out.printf("                            SCORE: %d\n", ((900 - 최종기록) * 100 + 플레이어.coin + 플레이어.exp * 100));
		System.out.println("==========================================");
		pause();
		게임종료bgm.stop();
		sc.close();
	}

	private static void pause() {
		try {
			System.in.read();
		} catch (IOException e) {
		}
	}
}
