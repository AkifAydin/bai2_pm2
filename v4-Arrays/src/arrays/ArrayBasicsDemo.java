package arrays;
import static util.Printer.pAry;
import static util.Printer.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import misc.Person;
import misc.Student;

public class ArrayBasicsDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		// Arrays sind Anordnungen fester Länge von "gleichartigen" Objekten.
		// Die Ordnung definiert durch die Anordnung der natürlichen Zahlen.
		// Man spricht von einem Arraytyp und einem Komponententyp.
		// Der Komponententyp ist der Typ der Elemente eines Arrays.
		// Arrays definieren eine Familie von Typen, da jeder Typ in Java
		// Komponententyp eines Arrays sein kann. Dies gilt auch für Arraytypen.
		// Basidatentypen, Arraytypen und Objekttypen definieren die Javatypen
		// vollständig.
		// Arraytypen können nicht erweitert werden. Sie verfügen über ein
		// begrenzte Zahl von Methoden, mehr als diese Methoden stehen für die
		// Programmierung
		// mit Arrays nicht zur Verfügung (im Unterschied zu Ruby, hier durfte
		// von Array abgleitet werden und Array erweitert werden).
		// Ausnahme bilden die generischen Typen: Diese sind als Komponententyp
		// nicht zulässig.
		// Alle Objekte in einem Array müssen zum Komponententyp kompatibel sein
		// oder in diesen umwandelbar sein (-> siehe coercion).
		// Die Länge eines Arrays wird bei der Initialisierung festgelegt und
		// kann nicht verändert werden (im Unterschied zu Ruby!!!).
		// Der Zugriff auf die Elemente eines Arrays erfolgt indiziert über die
		// Positionen der Elemente.
		// Die Zählung der Positionen in einem Array beginnt mit 0 und endet mit
		// (Länge-1).
		// Indizierter Zugriff außerhalb des Intervall [0,Länge-1] führt immer
		// zu einem Fehler: ArrayIndexOutOfBoundsException
		
		
		// Arrays werden durch Nennung des Komponententyps und nachgestelltem [] definiert
		p("Arrays deklarieren");
		boolean[] bAry;
		char[] cAry;
		int[] iAry;
		double[] dAry;
		float[] fAry;
		Integer[] iWrapAry;
		Double[] dWrapAry;
		Float[] fWrapAry;
		Person[] perAry;
		Object[] oAry;
		int[][] iMatrix;
		
					   
		// Deklarierte Arrays sind noch nicht initialisiert.
		// Zugriffe auf Arrayvariablen erzeugen einen Compilerfehler.
		// Bei der Initialisierung von Arrays wird immer der Speicher für das Array festgelegt. 
		// Speicher = Speicher für den Komponententyp * Länge des Arrays.
		// Initialisierung mit Defaultwerten allokiert Speicher und füllt das Array mit den Defaultwerten des Komponententyps.
		// Initialisierung mit Arrayliteralen allokiert Speicher und belegt die Elemente des Arrays mit den Objekten zwischen den {} Klammern 
		// des Literals. 

		p("Um mit einem Array arbeiten zu können, muss dieses initialisiert sein");
		//p(iAry);     // Compilerfehler iAry nicht initialisiert

		p("Arrays  mit Defaultwerten initialisieren");
		bAry = new boolean[10];
		cAry = new char[10];
		iAry = new int[10];    
		dAry  = new double[10];
		fAry = new float[10];
		iWrapAry = new Integer[10];
		dWrapAry = new Double[10];
		fWrapAry = new Float[10];
		perAry = new Person[2];
		oAry = new Object[10];
		iMatrix = new int[4][6];
		
		p("Default Werte in initialisierten Arrays");
		pAry("boolean Defaults", bAry);
		pAry("char Defaults", cAry);
		p(Character.isSpaceChar(cAry[0]));
		p((int) cAry[0]);
		pAry("int Defaults",iAry); 
		pAry("double Defaults",dAry);
		pAry("float Defaults",fAry);
		pAry("Integer Defaults",iWrapAry);
		pAry("Double Defaults",dWrapAry);
		pAry("Float Defaults", fWrapAry);
		pAry("Person Defaults",perAry);
		pAry("Object Defaults",oAry);
		pAry("int Matrix Defaults", iMatrix);
		
		p("Arrays mit Literalen intialisieren");
		p(" Initialisierung mit Literalen, die separat von der Deklaration erfolgt," +
		" muss immer explizit den Speicher mit new <KompTyp>[<numKomps>] anfordern.");
		//iAry = {11,12,13,14,15,16,17,18,19,110}; // Compiler Fehler
		iAry = new int[] {11,12,13,14,15,16,17,18,19,110};
		pAry(iAry);
		int[] iAry2 =  {1,2,3,4,5,6,7,8,9,10};
		pAry(iAry2);

		p("Elementzugriff");
        cAry = new char[]{'c','h','a','r','a','c','t','e','r'};
		p(cAry[cAry.length-1]);
		p(cAry[0]);
		//p(cAry[cAry.length]);
			
		p("Elementzuweisung");
		cAry[0] = 's';
		cAry[cAry.length-1] = 'l'; 
		pAry(cAry);
		//cAry[-1] = 'x';
		
		p("Typkompatibilität zwischen Arrays mit Basisdatentypen, Wrappertypen und Objekttypen");
		p("Arrays, deren Komponententyp ein Basisdatentyp ist, sind nur zu Arrays desselben Komponententyps kompatibel");
		// oAry = iAry;      // Compilerfehler
		// dAry = iAry;      // Compilerfehler 
		// dAry = fAry;      // Compilerfehler 
		p("Arrays, deren Komponententyp ein Basisdatentyp ist, sind nicht zu Arrays mit den korrespondierenen Wrappertypen kompatibel");
		// iWrapAry = iAry;  // Compilerfehler
		// iAry = iWrapAry;  // Compilerfehler
		p("für Arrays, deren Komponententyp ein Objekttyp ist, gilt: Wenn A < B dann ist A[] kompatibel zu B[]");
		oAry = perAry;   
		oAry = iWrapAry;
		oAry = dWrapAry;
		p("für Arrays, deren Komponententyp ein Array ist, gelten die obigen Regeln");
		Person[][] perMatrix = new Student[3][3];   // ok
		// Integer[][] intMatrix = new int[3][3];   // Compilerfehler 
		// int[][] iMatrix = new short[3][3];       // Compilerfehler 
		p("Alle Arrays sind  zu Object kompatibel");
		Object o;
		o = iAry;
		System.out.println(Arrays.toString((int[])o));
		o = iWrapAry;
		System.out.println(Arrays.toString((Integer[])o));
		o = oAry;
		System.out.println(Arrays.toString((Double[])o));
		o = perAry;
		System.out.println(Arrays.toString((Person[])o));
		o = new int[][]{{1,2},{3,4}};
		pAry((Object[])o);
		
		p("Ungeschützte Kovarianz");
		
		Object[] oa = new String[3];
//		oa[0] = 4;
		
		p("In Arrays, deren Komponententyp ein Basisdatentyp ist, dürfen Werte vom Typ A zugewiesen werden, " +
				"wenn A mittels coercion in B  umgewandelt werden kann.");
		iAry[0] = (short)89;
		dAry[0] = 12.34f;
		p("In Arrays, deren Komponententyp ein Basisdatentyp ist, dürfen Werte des " +
				"korrepondierenden Wrappertypen zugewiesen werden, und umgekehrt.");
		iAry[0] =Integer.valueOf(4);
		iWrapAry[0] = 4;
		p("In Arrays, deren Komponententyp ein Objecttyp B ist, dürfen Objekte vom Typ A zugewiesen werden, " +
				"wenn gilt, dass  A < B. für Werte von Basisdatentypen greift das Autoboxing.");
		oAry = new Object[3];
		oAry[0] = new Person("Donald", "Knuth");
		perAry[1] = new Student("Donald", "Knuth",1111111);
		oAry[1] = Integer.valueOf(1);
		oAry[2] = 4;

		p("In Arrays, deren Komponententyp ein Arraytyp ist, gelten" +
				"die Kompatibilitätsregeln für Arrays, wenn ein Array zugewiesen wird, sonst " +
				"die Kompatibilitätsregeln für die Elementzuweisung");
		perMatrix[0] = new Student[] {new Student("Donald", "Knuth",1111111),null,null};
		Integer[][] intMatrix = new Integer[3][3];  
		intMatrix[0][0] = 67;
		Object[] o1 = new int[][]{};
		//intMatrix[0] = new int[]{1,7,9};       // Compilerfehler
		
		
		p("über Arrays Iterieren");
		p("Iterieren ohne den Inhalt eines Arrays zu ändern.");
		pAry(oAry);
		for (Object  obj : oAry) {
			p(obj);
			obj = new Person("Never In", "oAry");
		}
		pAry(oAry);
		
		p("Indiziert über ein Array iterieren");
		p("Inhalt eines Arrays in ein anderes kopieren");
		pAry("iAry",iAry);
		for (int i = 0; i < iAry2.length; i++) {
			iAry2[i] = iAry[i];
		}
		pAry("iAry",iAry2);

		p("Vergleich von Arrays: Beispiel Ordnung auf char[] Arrays");
		char[] cAry1 = {'N','e','u','m','a','n','n'};
		char[] cAry2 = {'N','e','u','m','a','r','k','t'}; 		
		compareCharArys(cAry1,cAry2);
		cAry1 = new char[] {'N','e','u','m','a','r','k','t'};
		compareCharArys(cAry1,cAry2);
		cAry1 = new char[] {'N','e','u','w','a','r','k','t'};
		compareCharArys(cAry1,cAry2);
		
		p("Arrays mit Inhalt befüllen");
		
		p("3'tens mittels der toArray(),  getChars() Methode von String StringBuffer");
		String s = "In the computer business, soon means the same thing as manana in Spanish, but without the same kind of urgency.";
		cAry = s.toCharArray();
		pAry(cAry);
		char[] cAry3 = new char[s.length()];
		s.getChars(10, 15, cAry3, 0);
		pAry(cAry3);
		
		p("4'tens: toArray Methode der Collection Klassen SPÄTER GENAUER!!!!");
		List<String> ls = new ArrayList<String>();
		String[] sAry; 
		ls.add("one");
		ls.add("two");
		ls.add("three");
		sAry = new String[ls.size()];
		sAry = ls.toArray(new String[0]);
		ls.toArray(sAry); // alternativ
		pAry(sAry);
		
		p("Mehrdimensionale Arrays");		
		p("Arrays sind Typen in Java und können selber wieder Komponententyp sein.");
		p("Dadurch entstehen mehrdimensionale Arrays.");
		p("mit 2-dimensionale Arrays lassen sich Matrizen darstellen.");
		int[][] matrix1 = new int[4][7];  
		int[][] matrix2 = new int[7][5]; 
		int[][] matrix3 = new int[4][5];
		matrix1 = new int[][] {{11,12,13,14,15,16,17},{21,22,23,24,25,26,27},{31,32,33,34,35,36,37},{41,42,43,44,45,46,47}};		
		
		p("mit 3-dimensionalen Arrays lassen sich z.B. Würfel darstellen.");
		int[][][] cube = new int[3][3][3];
		
		for(int i=0; i< cube.length; i++){
			for(int j=0; j< cube[0].length; j++){
				for(int z=0; z<cube[0][0].length; z++){
					cube[i][j][z] = Integer.parseInt(""+ (i+1) +(j+1)+(z+1));
				}
			}
		}
		
		p("Elementzugriff über den ersten Index eines n-dimensionalen Arrays liefert ein Array der Dimension n-1");
		p("Elementzugriff über die ersten beiden Indizes eines n-dimensionalen Arrays liefert ein Array der Dimension n-2. etc...");
		pAry("matrix1:", matrix1);
		pAry("matrix1[0]:",matrix1[0]);
		System.out.println("matrix1[0][1]:"+ matrix1[0][1]);
		
		pAry("cube:", cube);
		pAry("cube[0]:", cube[0]);
		pAry("cube[0][2]:",cube[0][2]);
		System.out.println("cube[1][1][1]:"+ cube[1][1][1]);
		
		p("Matrizen mit Werten füllen");
		p("Wir weisen den Zeilen einer Matrix Werte zu, indem wir jeder Zeile ein eindimensionales Array zuweisen");
		p("Dazu iterieren wir über die Zeilen einer Matrix");
		int[] sevenInts = {1,2,3,4,5,6,7};
		for (int i = 0; i < matrix1.length; i++) {
			matrix1[i] = sevenInts.clone();   // Kopien, um Seiteneffekte zu unterbinden
		}
		pAry("matrix1: ", matrix1);
		
		int[] fiveInts = {1,2,3,4,5};
		for (int i = 0; i < matrix2.length; i++) {
			matrix2[i] = fiveInts.clone();
		}
		pAry("matrix2: ", matrix2);

		p("Soll eine Matrix spaltenweise gefüllt werden, muss man die einzelnen Elemente in den Spalten setzen");
		p("Dazu iterieren wir über die Spalten und füllen einzeln die Positionen in den Zeilen");
		p("si ist der Spaltenindex, zi ist der Zeilenindex");
		int[] fourInts = {8,9,10,11};
		for (int si = 0; si < matrix1[0].length; si++) {
			for(int zi=0; zi < matrix1.length; zi++) {
			matrix1[zi][si] = fourInts[zi];
			//p("matrix1[" + zi + "][" + si + "]= " + matrix1[zi][si]);
			}
		}
		pAry("matrix1:",matrix1);
		pAry("matrix2:",matrix2);


		for (int i = 0; i < matrix1.length; i++) {
			matrix1[i] = sevenInts.clone();   // Kopien, um Seiteneffekte zu unterbinden
		}
		pAry("matrix1: ", matrix1);

		p("Matrixmultiplikation");
		matrix3 = matrixMult(matrix1,matrix2);

        pAry("matrix3 ", matrix3);

		p("Würfel scheibenweise über den ersten Index  befüllen");
		int[][] slices1 = {{1,2,3},{1,2,3},{1,2,3}};
		int[][] slices2 = {{4,5,6},{4,5,6},{4,5,6}};
		int[][] slices3 = {{7,8,9},{7,8,9},{7,8,9}};
		
		int[][][] threeSlices = new int[][][]{slices1,slices2,slices3};
		// oder auch direkt cube = new int[][][]{slices1,slices2,slices3};
		
		for (int i = 0; i < cube.length; i++) {
			cube[i] = threeSlices[i].clone();
		}
		pAry("cube ",cube);

		p("Würfel streifenweise über den 1'ten und 2'ten Index  befüllen");	
		int[] threePerRow = {6,7,8};
		
		for (int i = 0; i < cube.length; i++) {
			int[][] slice = cube[i];
			for (int j = 0; j < slice.length; j++) {
				cube[i][j] = threePerRow.clone();
			}
		}		
		pAry("cube ",cube);


		p("Würfel elementweise befüllen");
		for(int i=0; i< cube.length; i++){
			for(int j=0; j< cube[0].length; j++){
				for(int z=0; z<cube[0][0].length; z++){
					cube[i][j][z] = Integer.parseInt(""+ (i+1) +(j+1)+(z+1));
				}
			}
		}
		pAry("cube ",cube);
		
		
		p("Würfel über den 2'ten Index scheibenweise ausgeben");
		int xDim = cube.length;
		int zDim = cube[0][0].length;
		int yDim = cube[0].length;
		
		int[][] slice = new int[3][3];
		
		for(int i = 0; i < yDim; i++ ) {
			for(int j =0; j < xDim; j++ ){
				for(int k = 0; k < zDim; k++){
					slice[j][k] = cube[j][i][k];
				}
			}
			pAry("slice", slice);			
		}
		
		
		p("Arrays kopieren");
		p("Variante 1: in Schleifen");
		Person[] perAry2 = new Person[perAry.length];
		for( int i =0; i <perAry.length; i++) {
			perAry2[i] = perAry[i];
		}		
		pAry("Variante 1:", perAry2);
		p("Variante 2: mit der Methode clone, die Arrays von Object erben");
		perAry2 = perAry.clone();
		pAry("Variante 2:", perAry2);
		p("Variante 3: mit Arrays.copyOfRange");
		perAry2 = Arrays.copyOf(perAry,0);
		perAry2 = Arrays.copyOfRange(perAry,0,perAry.length);
		pAry("Variante 3:", perAry2);
		p("Variante 4: mit System.arraycopy");
		System.arraycopy(perAry, 0, perAry2, 0, perAry.length);
		pAry("Variante 4:", perAry2);

		
		p("Alle vier Kopiervarianten erzeugen flache Kopien von perAry. " +
				"d.h. die Instanzvariablen, aber nicht deren Referenzen werden kopiert");
		p("Flache Kopien und Elementzuweisung");
		perAry[0] = new Student("Hugo","Hastig",1212121);
		pAry("Original" ,perAry);
		pAry("Kopie", perAry2);
		
		p("Flache Kopien und Änderung referenzierter Objekte");
		perAry2 = perAry.clone();
		perAry[0].setName("$UNKNOWN$");
		perAry2[1].setName("$ALIEN$");
		pAry("Original" ,perAry);
		pAry("Kopie", perAry2);
		
		
		p("Tiefe Kopien von Arrays müssen eigenhändig erzeugt werden");
		p("Wir erzeugen beim Kopieren der Personen zwischen Arrrays, flache Kopien der Objekte mit clone. " +
				"Dazu haben wir zuvor Personen Cloneable gemacht und die Methode clone von Object " +
				"in der Klasse Person geeignet überschrieben.");
		
		perAry = new Person[]{ new Student("Hugo","Hastig",1212121), new Person("Donald","Knuth")};
		perAry2 = new Person[2];
		for(int i =0; i <perAry.length; i++){
			perAry2[i] = (Person)perAry[i].clone();
		}
		perAry[0].setName("$UNKNOWN$");
		perAry2[1].setName("$ALIEN$");
		p("Jetzt sind die Änderungen auf den enthaltenen Elementen nur in dem Array sichtbar, auf das " +
				"die Änderungen angewendet wurden.");
		pAry("Original" ,perAry);
		pAry("Kopie", perAry2);
		
		p("Tiefe Kopien von Arrays mit clonen von enthaltenen Arrays");
		p("Zunächst die Effekte mit flachen Kopien");
		int[][] matCopy = new int[4][7];
		
		for (int i = 0; i < matrix1.length; i++) {
			matCopy[i] = matrix1[i];    // Kopieren durch Elementzuweisung
		}
		matrix1[0][0]=999999;
		matCopy[3][0]=444444;
		p("Änderungen in den enthaltenen Arrays werden im Original und der Kopie sichtbar");
		pAry("Original",matrix1);
		pAry("Kopie",matCopy);
		
		p("Werden hingegen Kopien der enthaltenen Teilarrays den Elementen von matCopy zugewiesen, " +
				"dann werden Änderungen nur jeweils im Original / bzw. der Kopie sichtbar.");	
		for (int i = 0; i < matrix1.length; i++) {
			matCopy[i] = matrix1[i].clone();    // flache Kopie der enthaltenen Arrays 
		}
		matrix1[0][0]=-55555;
		matCopy[3][0]=111111;
		pAry("Original",matrix1);
		pAry("Kopie",matCopy);
		
		p("Arrays vergleichen.");
		p("equals prüft auf Identität");
		perAry2 = perAry.clone();
		
		p("perAry2 == perAry: " + (perAry2 == perAry));
		p("perAry2.equals(perAry): " + perAry2.equals(perAry));
		
		
		p("Arrays.equals prüft Arrays auf Inhaltsgleichheit");
		p("Arrays.equals(perAry,perAry2): " + Arrays.equals(perAry2,perAry));
		
		p("Arrays.equals stösst bei mehrdimensionalen Arrays an Grenzen." +
				" Das erste enthaltene Array wird wieder mit equals von Array-Objekten verglichen");
		for (int i = 0; i < matrix1.length; i++) {
			matCopy[i] = matrix1[i].clone();
		}
		p("Arrays.equals(matCopy,matrix1): " + Arrays.equals(matCopy,matrix1));
		
		p("für den Inhaltsvergleich mehrdimensionaler Arrays muss die Methode deepEquals der Klasse Arrays verwendet werden.");
		p("Arrays.deepEquals(matCopy,matrix1): " + Arrays.deepEquals(matCopy,matrix1));
		p("deepHashCode " + Arrays.deepHashCode(matrix1));
		
		p("Hilfsklasse Arrays für die Ausgabe von Object Arrays.");
		p("deepToString" + Arrays.deepToString(matrix1));
		// p("deepToString" + Arrays.deepToString(new int[]{1,2,3,4})); Fehler kein Object-Array
		p("Hilfsklasse Arrays zum Sortieren / Suchen  von / in Arrays");
		perAry[0]= new Person("Alex","Wollik");
		pAry(perAry);
		Arrays.sort(perAry);    // destruktiv, Objekte müssen das Interface Comparable implementieren
		pAry("sort ", perAry);
		p("search and found at " + Arrays.binarySearch(new int[]{1,2,3,4,5,6,7,8,9}, 5));
		p("search and found at " + Arrays.binarySearch(new int[]{1,2,3,4,5,6,7,8,9}, -1));
		
	}

    private static void compareCharArys(char[] ary1, char[] ary2) {
		int min = ary1.length <= ary2.length ? ary1.length : ary2.length;
		for(int i = 0; i <min ; i++ ) {
			if (ary1[i] < ary2[i]) { p("ary1 <=> ary2: " + -1); return;}
			if (ary1[i] > ary2[i]) { p("ary1 <=> ary2: " + 1); return;}
		}
		if (ary1.length < ary2.length) {p("ary1 <=> ary2: " + -1);}
		else if (ary1.length > ary2.length) {p("ary1 <=> ary2: " + 1);}
		else { p("ary1 <=> ary2: " + 0); }
	}

	private static int[][]  matrixMult(int[][] m1, int[][] m2) {
	    int[][] m3 = new int[m1.length][m2[0].length];
	    for (int i = 0; i< m1.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                int cij = 0;
                for (int k = 0; k < m2.length; k++) {
                    cij += m1[i][k] * m2[k][j];
                }
                m3[i][j] = cij;
                p(String.format("m3[%1$d][%2$d]=%3$d",i,j,m3[i][j]));
            }
            pAry("m3=",m3);
        }
        return m3;
    }
}
