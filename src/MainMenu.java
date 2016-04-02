import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;


public class MainMenu extends JFrame{
	private static final long serialVersionUID = 1L;

	int screenWidth = 200;
	int screenHeight = 155;
	int buttonWidth = 100;
	int buttonHeight = 40;

	JButton Play, Quit;
	JCheckBox twoPlayer;

	public MainMenu(){
		addButtons();
		addActions();

		getContentPane().setLayout(null);

		Play.setBounds((screenWidth - buttonWidth) / 2, 5, buttonWidth, buttonHeight);
		Quit.setBounds((screenWidth - buttonWidth) / 2, 50, buttonWidth, buttonHeight);
		twoPlayer.setBounds((screenWidth - buttonWidth) / 2, 95, buttonWidth, buttonHeight);

		getContentPane().add(Play);
		getContentPane().add(Quit);
		getContentPane().add(twoPlayer);

		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(screenWidth, screenHeight);
		setTitle("Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	private void addButtons(){
		Play = new JButton("Play");
		Quit = new JButton("Quit");
		twoPlayer = new JCheckBox("Two Player?: ");
	}
	private void addActions(){
		Play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();

				Game game = new Game();
				if(twoPlayer.isSelected()){
					game.ai.isTwoPlayer = true;
				}
				else{
					game.ai.isTwoPlayer = false;
				}
				game.start();
			}	
		});
		Quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}	
		});

	}
}
