package komplexezahlen;

public class Cartesian extends AbstractComplex implements Complex {

	private final double real;
	private final double imag;

	public Cartesian(Complex c){
		this.real = c.getReal();
		this.imag = c.getImag();
	}
	public Cartesian(double real,double imag){
		this.real = real;
		this.imag = imag;
	}
	public double getImag() {
		return imag;
	}

	public double getReal() {
		return real;
	}

	public double getDist() {
		return Math.hypot(real, imag);
	}

	public double getPhase() {
		return Math.atan2(imag, real);
	}
	public String toString() {
		return String.format("Cartesian(%1$g,%2$g)", real,imag);

	}
}
