package iteratoren.eigene;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Liste implements Iterable<Object> {
	// Liste verwendet eine Array für die Verwaltung der Elemente
	private Object[] intern;
	// cursor steht auf der Position, auf der als nächstes geschrieben wird
	private int cursor = 0;
	// Platz, der im internen Array initial angelegt wird. Wenn intern voll ist
	// wird intern um initCap erweitert
	private int initCap;
	private static final int INITIAL_CAP_DEFAULT = 16;

	// Konstruktor, mit dem sich die initiale Kapazität festlegen lässt.
	public Liste(int initCap) {
		intern = new Object[initCap];
		this.initCap = initCap;
	}
	// Konstruktor, der den Default INITIAL_CAP_DEFAULT verwendet.
	public Liste() {
		this(INITIAL_CAP_DEFAULT);
	}
	// Fügt elem hinten an die Liste an
	public void add(Object elem) {
		// Wenn intern voll ist, d.h. cursor am Ende von intern steht
		if (cursor == intern.length) {
			// dann erweitere intern um initCap Elemente
			intern = Arrays.copyOf(intern, cursor + initCap);
		}
		intern[cursor] = elem;
		cursor++;
	}

	// Löscht ein Element an Position index
	public void remove(int index) {
		// ungültiger Index -> Fehler
		if (index<0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		// Grenzfall Ende von intern, dann muss nur das letzte Element auf null gesetzt werden
		if (index != intern.length-1) {
			// Kopiert in intern die Elemente ab Position index+1 auf Position index
			// (dadurch wird Element auf Position index durch Element auf Position index+1 überschrieben)
			//
			System.arraycopy(intern, index + 1, intern, index, intern.length - 1 - index);
		}
		// letzte Element ist ggf. doppelt. Löschen
		intern[size()-1]=null;
		cursor--;
	}


	// Gibt die Anzahl der geschriebenen Elemente zurück
	public int size(){
		return cursor;
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(intern,size()));
	}

	public String internToString() {
		return Arrays.toString(intern);
	}

	@Override
	public Iterator<Object> iterator() {
		return new MyIterator();
	}

	// MyIterator ist eine innere Klasse von Liste und hat damit
	// Zugriff auf die Instanzvariablen von Liste
	private class MyIterator implements Iterator<Object> {
		// die nächste zu lesende Position
		private int readCursor = 0;
		// Indikator für das Lesen mit next
		private boolean nextGiven = false;

		@Override
		public boolean hasNext() {
			return readCursor < cursor;
		}

		@Override
		// Liefert das nächste Element und setzt nextGiven auf true
		// so dass ein gültiger Zustand für das potentielle Löschen erreicht ist
		public Object next() {
			if (!hasNext()) throw new NoSuchElementException();
			nextGiven = true;
			return intern[readCursor++];
		}

		// Löscht das letzte gelesene Element
		// Wenn vorher kein Element gelesen wurde, dann wird eine IllegalStateException generiert
		// Ruft die remove Methode des Objektes der umgebenden Klasse auf und passt
		// den readCursor und nextGiven an.
		@Override
		public void remove() {
			if (!nextGiven) throw new IllegalStateException("no next element");
			// --, da der readCursor hinter dem letzten gelesenen Element steht
			Liste.this.remove(--readCursor);
			// letztes gelesenes Element wurde gelöscht nextGiven wird zurückgesetzt
			nextGiven= false;
		}
	}
}