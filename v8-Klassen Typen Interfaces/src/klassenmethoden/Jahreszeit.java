package klassenmethoden;

public class Jahreszeit {
	
	private String name;
	private Jahreszeit succ;
	
	public static final Jahreszeit FRUEHJAHR;
	public static final Jahreszeit SOMMER;
	public static final Jahreszeit HERBST;
	public static final Jahreszeit WINTER;
	
	static {
		WINTER = new Jahreszeit("Winter",null);
		HERBST = new Jahreszeit("Herbst",WINTER);
		SOMMER = new Jahreszeit("Sommer",HERBST);
		FRUEHJAHR = new Jahreszeit("Frühjahr", SOMMER);
		WINTER.setSucc(FRUEHJAHR);
	}
	
	private Jahreszeit(String name,Jahreszeit succ){
		this.name = name;
		this.succ = succ;
	}

	private void setSucc(Jahreszeit succ) {
		this.succ = succ;
	}
}
