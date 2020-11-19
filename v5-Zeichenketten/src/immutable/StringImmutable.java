package immutable;

public class StringImmutable {
	public static void main(String[] args) {
		String str = "original";
		String strMod;
		strMod = str + " Modified";
		System.out.println("str " + str);
		System.out.println("strMod " + strMod);
	}
}
