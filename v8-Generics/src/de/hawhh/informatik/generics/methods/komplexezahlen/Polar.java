package de.hawhh.informatik.generics.methods.komplexezahlen;

public class Polar extends AbstractComplex implements Complex {
	private final double dist;
	private final double phase;

	// Variante 1
	public Polar(Polar p){
		this.dist= p.dist;
		this.phase= p.phase;
	}
	// Variante 2
	public Polar(Complex c){
		this.dist = c.getDist();
		this.phase = c.getPhase();
	}
	public Polar(double dist, double phase){
		this.dist= dist;
		this.phase=phase;
	}
	public double getDist() {
		return dist;
	}
	public double getPhase() {
		return phase;
	}
	public double getImag() {
		return dist * Math.cos(phase);
	}
	public double getReal() {
		return dist * Math.sin(phase);
	}
	public String toString() {
		return String.format("Polar(%1$g,%2$g)", dist,phase);
	}
}
