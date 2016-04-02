import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;





public class InputHandle implements KeyListener{
	public InputHandle(Game game){
		game.addKeyListener(this);
	}
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		//player1
		if(keyCode == KeyEvent.VK_W){
			Game.player.goingUP = true;
		}
		if(keyCode == KeyEvent.VK_S){
			Game.player.goingDown = true;
		}

		//player2
		if(keyCode == KeyEvent.VK_UP){
			Game.ai.goingUP = true;
		}
		if(keyCode == KeyEvent.VK_DOWN){
			Game.ai.goingDown = true;
		}
		
		if(keyCode == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		
	}

	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//player 1
		if(keyCode == KeyEvent.VK_W){
			Game.player.goingUP = false;
		}
		if(keyCode == KeyEvent.VK_S){
			Game.player.goingDown = false;
		}

		//player2
		if(keyCode == KeyEvent.VK_UP){
			Game.ai.goingUP = false;
		}
		if(keyCode == KeyEvent.VK_DOWN){
			Game.ai.goingDown = false;
		}



	}
	public void keyTyped(KeyEvent arg0){}



}
