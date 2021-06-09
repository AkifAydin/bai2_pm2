package assertions;

public class Rational {

	public static final Rational ONE = new Rational(1,1);
	public static final Rational ZERO = new Rational(0,1);
	
	private int num;
	private int denom;

	public int getNumer() {
		return num;
	}
	public int getDenom() {
		return denom;
	}
	public Rational(int nom){
		this(nom,1);
	}
//	public Rational(int zaehler, int nenner) {
//		if (nenner == 0) throw new IllegalArgumentException("Nenner darf nicht 0 sein");
//		this.num = zaehler;
//		this.denom = nenner;
//	}

	public Rational(int zaehler, int nenner) {
		assert nenner !=0;
		this.num = zaehler;
		this.denom = nenner;
	}

	public Rational add(Rational other) {
		return new Rational(num * other.denom + other.num * denom,
				denom * other.denom).reduce();
	}

	public Rational sub(Rational other) {
		return new Rational(num * other.denom - other.num * denom,
				denom * other.denom).reduce();
	}

	public Rational mult(Rational other) {
		return new Rational(num * other.num, denom * other.denom)
				.reduce();
	}

	public Rational div(Rational other) {
		if (other.isZero()) throw new ArithmeticException("/ by zero");
		return new Rational(num * other.denom, denom * other.num)
				.reduce();
	}

	public Rational reduce() {
		int ggt = Rational.ggt(num,denom);
		assert ggt>0: "ggt nicht positiv";
		num /= ggt;
		denom /= ggt;
		assert denom!=0;
		return new Rational(num / ggt, denom / ggt);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		Rational r = this.reduce();
		result = prime * result + r.getNumer()*r.getDenom();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())return false;
		Rational other = (Rational) obj;	
		return (this.isZero() && other.isZero())  
				 || !other.isZero() && this.div(other).isOne();
	}

	public boolean isZero() {
		return num == 0;
	}
	public boolean isOne() {
		return this.num== this.denom;
	}

	public double toReal() {
		return num/(double)denom;
	}
	
	public int[] toArray(){
		return new int[]{num,denom};
	}
	

	public static int ggt(int m, int n) {
		int r;
		while (Math.abs(r = m % n) > 0) {
			m = n;
			n = r;
		}
		//return Math.abs(n);
		return n;
	}
	
	
	@Override
	public String toString() {
		return String.format("%d/%d", num, denom);
	}	
	
}
