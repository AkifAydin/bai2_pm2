package klassenmethoden;

public class Player {
	
	private int points;
	private static int score=0;
	
	public static int getScore() {return score;}
	//public static int getPlayerPoints() {return this.points;}
	//public static int getPlayerPoints() {return points;}

	public Player(){points = 0;}
	
	public Player win(){
		points++;
		score = Math.max(points, score);
		return this;
	}
	
	public Player loose(){
		points = Math.max(--points,0);
		return this;
	}
	public int getPoints() {return points;}
}
