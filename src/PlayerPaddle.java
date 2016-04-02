import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class PlayerPaddle {
	int x;
	int y;
	int width = 15;
	int height = 40;
	int speed = 1;

	Rectangle boundingBox;

	boolean goingUP = false;
	boolean goingDown = false;

	public PlayerPaddle(int x, int y){
		this.x = x;
		this.y = y;

		boundingBox = new Rectangle(this.x, this.y, width, height);
		boundingBox.setBounds(this.x, this.y, width, height);
	}
	public void tick(Game game){
		boundingBox.setBounds(this.x, this.y, width, height);

		if(goingUP && y>0){
			y-= speed;
		}
		if(goingDown && y < game.getHeight()-height){
			y+= speed;
		}

	}
	public void render(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}
