package preconditions;

import java.util.Arrays;
import java.util.stream.Stream;

public class MatrixUtility {

	public static void main(String[] args) throws NoMatrixException {
		//transponiere(null);  
		System.out.println(Arrays.deepToString(transponiere(new Object[][]{})));
		System.out.println(Arrays.deepToString(transponiere(new Object[][]{new Object[]{1,2,3},new Object[]{4,5,6}})));
		//transponiere(new Object[][]{new Object[]{1,2},new Object[]{1,2,3}});
	}

	public static Object[][] transponiere(Object[][] matrix) throws NoMatrixException {
		/*
		 * Preconditions
		 */
		if (matrix == null) throw new NoMatrixException("Matrix darf nicht null sein");	
		if (Stream.of(matrix).map(ary-> ary.length).distinct().count() > 1) {
			throw new NoMatrixException("Matrix enthaelt Zeilen unterschiedlicher Laenge");
		}	
		/*
		 * Sonderfall leere Matrix
		 */
		if (matrix.length == 0) return new Object[][]{};
			
		/*
		 * Regelfall
		 */
		Object[][] result = new Object[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				result[j][i] = matrix[i][j];
			}
		}
		/*
		 * Postconditions für den Regelfall
		 */
		assert result!=null : "Transponierte nicht initialisiert";
		assert result.length==matrix[0].length : "Transponierte hat falsche Anzahl an Zeilen";
		assert result[0].length == matrix.length : "Transponierte hat falsche Anzahl an Spalten";
		assert Stream.of(result).map(ary-> ary.length).distinct().count() == 1 : "Transponierte ist keine Matrix";
		return result;
	}
}
