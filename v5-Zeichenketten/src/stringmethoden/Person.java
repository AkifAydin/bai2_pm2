package stringmethoden;

public class Person {
	
	private String name;
	private String vorname;
	public Person(String vorname, String name) {
		this.name = name;
		this.vorname = vorname;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "P(" + vorname + "," + name+ ")";
	}

}
