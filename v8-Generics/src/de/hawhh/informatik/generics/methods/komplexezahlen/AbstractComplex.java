package de.hawhh.informatik.generics.methods.komplexezahlen;

public abstract class AbstractComplex implements Complex {

	@Override
	public Complex add(Complex c) {
		return new Cartesian(getReal()+c.getReal(),getImag()+c.getImag());
	}
	@Override
	public Complex mult(Complex c) {
		return new Polar(getDist()*c.getDist(),getPhase()*c.getPhase());
	}
	@Override
	public abstract double getDist();

	@Override
	public abstract double getImag();

	@Override
	public abstract double getPhase();

	@Override
	public abstract double getReal();
}
