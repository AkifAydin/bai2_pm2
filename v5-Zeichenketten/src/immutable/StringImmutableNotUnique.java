package immutable;

public class StringImmutableNotUnique {

	public static void main(String[] args) {
		String str1, str2,str3;
		str1 = "Hallo";
		str2 = args[0];
		System.out.println("str2 " + str2);
		str3 =  "Hallo";
		System.out.println("str1 == str2 " + (str1 == str2));
		System.out.println("str1 == str3 " + (str1 == str3));
		System.out.println("str1.equals(str2) " + str1.equals(str2));
	}
}
