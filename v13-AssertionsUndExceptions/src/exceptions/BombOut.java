package exceptions;

public class BombOut {
	public static void main(String[] args) throws StringClipException {
		String s = null;
		s= "12";
		System.out.println(clip(s));
	}

	static String clip(String s) throws StringClipException {
		if (s== null){
			throw new NoStringException("no string");  
		}
		if (s.length() < 2){   
			throw new ShortStringException("short string"); 
		}
		return s.substring(0, s.length()-1);
	}
}