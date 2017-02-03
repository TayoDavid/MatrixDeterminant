package MatrixDeterminant;

/**
 * Created by Omotayo on 13/06/2016.
 */

public class Determinant4by4 {
	
    public static int MatrixDeterminant(int[][] matrix) {
        int[][] newMatrix = new int[1][4];
        int[][] cofactor0_0 = new int[3][3];
        int[][] cofactor0_1 = new int[3][3];
        int[][] cofactor0_2 = new int[3][3];
        int[][] cofactor0_3 = new int[3][3];

        // Computing the A(i,j)
        int k = 0;
        while (k < 1) {
            for (int j = 0; j < 4; j++) {
                if (j % 2 != 0)
                    newMatrix[k][j] = -matrix[k][j];
                else
                    newMatrix[k][j] = matrix[k][j];
            }
            k += 1;
        }

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                cofactor0_0[i-1][j-1] = matrix[i][j];
            }
        }

        // Cofactor for A(0,1)
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 1) {
                    continue;
                }

                if (j >= 1)
                    cofactor0_1[i-1][j-1] = matrix[i][j];
                else
                    cofactor0_1[i-1][j] = matrix[i][j];
            }
        }

        // Cofactor for A(0,2)
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 2) {
                    continue;
                }

                if (j >= 2)
                    cofactor0_2[i-1][j-1] = matrix[i][j];
                else
                    cofactor0_2[i-1][j] = matrix[i][j];
            }
        }

        // Cofactor for A(0,3)
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 3) {
                    continue;
                }

                if (j >= 3)
                    cofactor0_3[i-1][j-1] = matrix[i][j];
                else
                    cofactor0_3[i-1][j] = matrix[i][j];
            }
        }


        // Computing the determinant
        int c0_0 = cofactor0_0[0][0] * (cofactor0_0[1][1] * cofactor0_0[2][2] - cofactor0_0[1][2] * cofactor0_0[2][1])
                 - cofactor0_0[0][1] * (cofactor0_0[1][0] * cofactor0_0[2][2] - cofactor0_0[2][0] * cofactor0_0[1][2])
                 + cofactor0_0[0][2] * (cofactor0_0[1][0] * cofactor0_0[2][1] - cofactor0_0[2][0] * cofactor0_0[1][1]);

        int c0_1 = cofactor0_1[0][0] * (cofactor0_1[1][1] * cofactor0_1[2][2] - cofactor0_1[1][2] * cofactor0_1[2][1])
                 - cofactor0_1[0][1] * (cofactor0_1[1][0] * cofactor0_1[2][2] - cofactor0_1[2][0] * cofactor0_1[1][2])
                 + cofactor0_1[0][2] * (cofactor0_1[1][0] * cofactor0_1[2][1] - cofactor0_1[2][0] * cofactor0_1[1][1]);

        int c0_2 = cofactor0_2[0][0] * (cofactor0_2[1][1] * cofactor0_2[2][2] - cofactor0_2[1][2] * cofactor0_2[2][1])
                 - cofactor0_2[0][1] * (cofactor0_2[1][0] * cofactor0_2[2][2] - cofactor0_2[2][0] * cofactor0_2[1][2])
                 + cofactor0_2[0][2] * (cofactor0_2[1][0] * cofactor0_2[2][1] - cofactor0_2[2][0] * cofactor0_2[1][1]);

        int c0_3 = cofactor0_3[0][0] * (cofactor0_3[1][1] * cofactor0_3[2][2] - cofactor0_3[1][2] * cofactor0_3[2][1])
                 - cofactor0_3[0][1] * (cofactor0_3[1][0] * cofactor0_3[2][2] - cofactor0_3[2][0] * cofactor0_3[1][2])
                 + cofactor0_3[0][2] * (cofactor0_3[1][0] * cofactor0_3[2][1] - cofactor0_3[2][0] * cofactor0_3[1][1]);

        int determinant = newMatrix[0][0] * c0_0 + newMatrix[0][1] * c0_1 + newMatrix[0][2] * c0_2 + newMatrix[0][3] * c0_3;


        return determinant;
    }
}
