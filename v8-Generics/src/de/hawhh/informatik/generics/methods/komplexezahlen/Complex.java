package de.hawhh.informatik.generics.methods.komplexezahlen;

public interface Complex {
		public double getReal();
		public double getImag();
		double getDist();
		double getPhase();
		public Complex add(Complex c);
		public Complex mult(Complex c);
}
