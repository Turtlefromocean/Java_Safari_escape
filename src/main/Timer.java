package main;


public class Timer implements Runnable {
	public volatile static boolean running = true;
	public int 걸린시간 = 1;
	
	public static void terminate() {
		running = false;
	}
	
	public void run() {
		while(running) {
			try {
				showMin();
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				running = false;
			}
		}
	}
	
	private void showMin() {
		걸린시간++;
		if(걸린시간% 60 == 0) {
			System.out.println("\n🧨마을에 들어온지 "+(걸린시간/60)+"일 지났습니다.(남은 시간: "+(15-걸린시간/60)+"일)🧨\n");
			if(걸린시간 == 900) {
				System.out.println("Time Over! 게임을 종료합니다.");
				System.exit(0);
			}
		}
	}
	
	
}