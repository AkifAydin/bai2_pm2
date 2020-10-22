package figuren;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FigurenTestJUnit {
	Rechteck r1, r2, r3;
	Kreis k1, k2, k3;
	Ueberlagert u1, u2, u3, u4, u5;
	Punkt punkt;

	@Before
	public void irgendwas() {
		r1 = new Rechteck(new Punkt(3, 3));
		r2 = new Rechteck(new Punkt(2.5, 2.5));
		r3 = new Rechteck(new Punkt(3.5, 3.5));
		k1 = new Kreis(new Punkt(3.5, 4));
		k2 = new Kreis(new Punkt(2, 2), 3);
		k3 = new Kreis(new Punkt(3, 4), 1.5);
		u1 = new Ueberlagert(r1, r2);
		u2 = new Ueberlagert(r3, k1);
		u3 = new Ueberlagert(k2, k3);
		u4 = new Ueberlagert(u1, u2);
		u5 = new Ueberlagert(u3, u4);
		punkt = new Punkt(3, 4);
	}

	@Test
	public void punktIn() {
		assertTrue(u5.in(punkt));
		assertTrue(u4.in(punkt));
		assertTrue(u3.in(punkt));
		assertTrue(u2.in(punkt));
		assertTrue(u1.in(punkt));
		assertTrue(k2.in(punkt));
		assertTrue(k1.in(punkt));
		assertFalse(r3.in(punkt));
		assertFalse(r2.in(punkt));
		assertTrue(r1.in(punkt));
	}
}
