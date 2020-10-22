package basedatatypes;

public class NumericLiterals {
	public static void main(String[] args) {
		int i1 = 0x2f; // hex (47)
		i1 = 47;
		int i2 = 0X2F; // hex (47)
		int i3 = 0177; // octal (leading 0) (127)
		char c = 0xffff; // max char in hex (2**16-1)
		byte b = 0x7f; // max byte in hex (2**7-1)
		short s = 0x7fff; // max short in hex (2**15 -1)
		long n1 = 200L; // long suffix   
		long n2 = 200L; // long suffix
		long n3 = 200;  // 
		float f1 = 1;
		//f1 = 1.4;        // 1.4 wird als double
		// interpretiert Fehler
		float f2 = 1F;   // float suffix
		float f3 = 1f;   // float suffix
		double d1 = 1;
		d1 = 1.4;        //ok
		double d2 = 1d;  // double suffix
		double d3 = 1D;  // double suffix
	}
}
