package MatrixDeterminant;

/**
 * Created by Omotayo on 11/06/2016.
 */

public class Determinant2by2 {

	// This method calls the determinant for the 2_2 matrix
    public static int getDeterminant(int[][] matrix) {
        int determinant = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        
        return determinant;
    }

}
