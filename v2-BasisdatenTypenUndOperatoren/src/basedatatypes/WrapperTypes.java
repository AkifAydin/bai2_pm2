package basedatatypes;

public class WrapperTypes {
	public static void main(String[] args) {
		//Integer in = new Integer(0x7fffffff);
		Integer in = new Integer(127);
		// Groesse des Typs
		System.out.println("size: " + Integer.SIZE);
		// Lesen des Basisdatentypen
		System.out.println("int:" + in.intValue());
		System.out.println("as binary integer: "
				+ Integer.toBinaryString(in.intValue()));
		// hier wird der Typ verkleinert es geht Information
		// verloren. Gleiches Phänomen auf bei in.byteValue();
		System.out.println("byte: " + in.byteValue());
		System.out.println("as binary integer: "
				+ Integer.toBinaryString(in.byteValue()));
		// hier wird der Typ vergr��ert. Information bleibt erhalten
		System.out.println("long: " + in.longValue());
		System.out.println("float: " + in.floatValue());
		System.out.println("double: " + in.doubleValue());
		// Wrappertypen sind untereinander nicht typkompatibel
		Double dD = 4.5;
		Float fF = 4.5f;
		Integer iI = 999;
		//dD = iI;
		//dD = fF;
		//fF = iI;
		// Für Basisdatentypen gibt es Typkompatibilität 
		double d = 4.5;
		float f = 4.5f;
		int i = 900;
		d = f;
		d = i;
		f = i;
	}
}
