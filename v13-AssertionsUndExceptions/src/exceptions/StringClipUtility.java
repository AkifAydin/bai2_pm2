package exceptions;

import java.util.Arrays;

public class StringClipUtility {

	/*
	 * Schneidet das erste und letzte Zeichen einer Zeichenkette ab und gibt die
	 * Restzeichenkette zurück
	 */
	// public static String clip(String s) {
	// return s.substring(1, s.length()-1);
	// }

	/*
	 * Erkennen der fehlerhaften Zustände
	 */
	// public static String clip(String s) {
	// if (s == null) {
	// // s ist null
	// } else if (s.length() < 2) {
	// // s ist zu kurz
	// } else
	// return s.substring(1, s.length() - 1);
	// }

	// /*
	// * Signalisieren der Fehler durch Exceptions
	// */
	// public static String clip(String s) throws Exception {
	// if (s == null) {
	// throw new Exception("keine gültige Zeichenkette");// s ist null
	// } else if (s.length() < 2) {
	// throw new Exception("Zeichenkette muss mindestens Länge 2 haben.");// s
	// ist null
	// } else
	// return s.substring(1, s.length() - 1);
	// }

	// /*
	// * Throw unterbricht das laufende Programm
	// * if-Schachtelung nicht notwendig
	// */
	// public static String clip(String s) throws Exception {
	// if (s == null) {
	// throw new Exception("keine gültige Zeichenkette");// s ist null
	// }
	// if (s.length() < 2) {
	// throw new Exception("Zeichenkette muss mindestens Länge 2 haben.");// s
	// ist zu kurz
	// }
	// return s.substring(1, s.length() - 1);
	// }

	// /*
	// * Vordefinierte Exceptionsklassen
	// */
	// public static String clip(String s) throws StringClipException {
	// if (s == null) {
	// throw new NullPointerException("keine gültige Zeichenkette");
	// }
	// if (s.length() < 2) {
	// throw new IllegalArgumentException(
	// "Zeichenkette muss mindestens Länge 2 haben.");
	// }
	// return s.substring(1, s.length() - 1);
	// }
	//
	// public static String tripleClip(String s) throws StringClipException{
	// return clip(clip(clip(s)));
	// }
	//
	//
	// public static void main(String[] args) {
	// try {
	// String s = "123";
	// StringClipUtility.clip(s);
	// System.out.println(s);
	// } catch (StringClipException e) {
	// System.out.println("Clip Fehler");
	// }
	// }

	/*
	 * Spezifische vordefinierte Exceptionsklassen
	 */

	public static String clip(String s) throws NoStringException,
			ShortStringException {
		if (s == null) {
			throw new NoStringException("keine gültige Zeichenkette");
		}
		if (s.length() < 2) {
			throw new ShortStringException(
					"Zeichenkette muss mindestens Länge 2 haben.");
		}
		return s.substring(1, s.length() - 1);
	}

	// public static void main(String[] args) {
	// try {
	// String s = "123";
	// StringClipUtility.clip(s);
	// System.out.println(s);
	// } catch (NoStringException ne) {
	// System.out.println("Ungültiger Wert-keine Zeichenkette");
	// } catch (StringClipException se) {
	// System.out.println("Clip Fehler");
	// }
	// }
//	public static void main(String[] args) {
//		try {
//			String s = "1";
//			StringClipUtility.clip(s);
//			System.out.println(s);
//		} catch (NoStringException ne) {
//			System.out.println("NoStringException " + ne.getMessage());
//		} catch (StringClipException se) {
//			se.printStackTrace();
//		}
//	}

	static String tripleClip(String s) throws StringClipException {
		try {
			return clip(clip(clip(s)));
		} catch (NoStringException ex) {
			throw new StringClipException(ex);
		} catch (ShortStringException ex) {
			throw new StringClipException(ex);
		}
	}
	
	public static void main(String[] args) throws StringClipException   {
		String s = null;
		StringClipUtility.tripleClip(s);
	}

}
