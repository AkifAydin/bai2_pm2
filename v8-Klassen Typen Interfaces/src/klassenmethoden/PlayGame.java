package klassenmethoden;
import static util.Printer.*;
public class PlayGame {
	
	public static void main(String[] args) {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		p1.win().win().win();
		p("score= " + Player.getScore());
		p2.loose().loose().win();
		p("score= " + Player.getScore());
		for(int i = 0; i < 10; i++) {
			p3.win();
		}
		p("score= " + Player.getScore());		
	}
}
