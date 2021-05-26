package de.hawhh.informatik.generics.multipletypebounds;

public class InfoDeLuxe extends Info implements Printable, TimeStamped {
	String timeStamp;
	public InfoDeLuxe(){
		timeStamp = Long.toString(System.currentTimeMillis());
	}
	public String getTimeStamp() {
		return timeStamp;
	}
}
