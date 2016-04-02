import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static PlayerPaddle player;
	public static AIPaddle ai;
	public static Ball ball;
	InputHandle IH;

	static boolean gameRunning = false;
	JFrame frame;
	public final int WIDTH = 400;
	public final int HEIGHT = WIDTH/16 * 9;
	public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);
	public final String TITLE = "Pong";

	Thread thread;

	BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	int p1Score, p2Score;
	public static void main(String[] args) {
		Game game = new Game();
		game.start();

	}

	public void run() {

		while(gameRunning){
			tick();
			render();

			try{
				Thread.sleep(7);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public synchronized void start(){
		gameRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	public static synchronized void stop(){
		gameRunning = false;
		System.exit(0);
	}
	public Game(){
		frame = new JFrame();

		setMinimumSize(gameSize);
		setPreferredSize(gameSize);
		setMaximumSize(gameSize);


		frame.add(this, BorderLayout.CENTER);
		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle(TITLE);
		frame.setLocationRelativeTo(null);


		IH = new InputHandle(this);

		player = new PlayerPaddle(10, 60);
		ai = new AIPaddle(getWidth() - 20, 60);
		ball = new Ball(10, 10);



	}
	public void tick(){
		player.tick(this);
		ai.tick(this);
		ball.tick(this);
	}

	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		g.setColor(Color.WHITE);
		g.drawString("Player 1: "+ p1Score, 5, 10);
		g.drawString("Player 2: "+ p2Score, 5, 20);

		player.render(g);
		ai.render(g);
		ball.render(g);

		g.dispose();
		bs.show();
	}

}
