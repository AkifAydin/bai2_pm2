package basedatatypes;

public class TypeCompDemo {

	public static void main(String[] args) {

		boolean bool = true;
		char ch = 'a';
		byte b = 127;
		short sh = 354;
		int i = 1089;
		long l = 56666666;
		float f = 1.4f;
		double d = 45499995.7878;

		//ch=bool; b = bool; sh= bool; i = bool; l = bool; f=bool; d = bool;
		//ch = b; ch = sh;
		//sh = ch; sh = b;
		i = ch;
		i = b;
		i = sh;
		l = ch;
		l = b;
		l = sh;
		l = i;
		f = ch;
		f = b;
		f = sh;
		f = i;
		f = l;
		d = ch;
		d = b;
		d = sh;
		d = i;
		d = l;
		d = f;
	}
}
