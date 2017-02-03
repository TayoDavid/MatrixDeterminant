package MatrixDeterminant;

/**
 * Created by Omotayo on 11/06/2016.
 */

public class Determinant3by3 {

    public static int getDeterminant(int[][] matriix) {

    	int determinant = matriix[0][0] * (matriix[1][1] * matriix[2][2] - matriix[1][2] * matriix[2][1])
                    - matriix[0][1] * (matriix[1][0] * matriix[2][2] - matriix[2][0] * matriix[1][2])
                    + matriix[0][2] * (matriix[1][0] * matriix[2][1] - matriix[2][0] * matriix[1][1]);

        return determinant;
    }
}
