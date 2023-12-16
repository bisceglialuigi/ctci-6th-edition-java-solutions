package Chapter1_ArraysAndStrings.E7_RotateMatrix;

public class RotateMatrix {
    /**
     * Given an image represented by an NxN matrix, where each pixel in the image is
     * represented by an integer, write a method to rotate by 90 degrees. Can you do this in place?
     */

    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();

        int[][][] matrixes = new int[][][]{
            {
                {1,2},
                {4,3}
            },
            {
                {1,3,2},
                {2,9,5},
                {4,1,3}
            },
            {
                {1,3,3,2},
                {2,1,2,4},
                {2,4,3,4},
                {4,5,5,3}

            },
            {
                {1,3,3,3,2},
                {2,1,3,2,4},
                {2,6,1,4,4},
                {2,4,5,3,4},
                {4,5,5,5,3}

            }
        };

        for(int i=0; i<matrixes.length; i++){
            matrixes[i] = rotateMatrix.solution1(matrixes[i]);
            rotateMatrix.print(matrixes[i]);
        }
    }

    /*
        Time Complexity: O(n^2)
        Space Complexity: O(n)
     */

    private int[][] solution1(int[][] matrix){

        int displacementSize = 0;

        int rowColSwapCounter = 0;

        if(matrix.length % 2 == 0){
            displacementSize = matrix.length/2;
            rowColSwapCounter = matrix.length/2 - 1;
        } else {
            displacementSize = (matrix.length-1)/2;
            rowColSwapCounter = displacementSize;
        }

        for(int i=0; i<displacementSize; i++){
            matrix = switchCorners(matrix, i);
        }

        for(int i=0; i<rowColSwapCounter; i++){
            matrix = switchRowsAndCols(matrix, i);
        }

        return matrix;
    }

    private int[][] switchCorners(int[][] matrix, int displacement){

        int n = matrix.length - 1 - displacement;

        int start = displacement;
        int end = n;

        int buffer = matrix[start][start];
        matrix[start][start] = matrix[end][end];
        matrix[end][end] = buffer;

        buffer = matrix[start][end];
        matrix[start][end] = matrix[end][start];
        matrix[end][start] = buffer;

        return matrix;
    }

    private int[][] switchRowsAndCols(int[][] matrix, int displacement){

        int n = matrix.length - 2*(displacement+1);

        int iFirstColBias = displacement + 1;
        int jFirstColBias = displacement;

        int iLastColBias = displacement + 1;
        int jLastColBias = matrix.length - 1 - displacement;

        int[] swapBuffer = new int[n];

        for(int i=0; i<n; i++){
            swapBuffer[i] = matrix[iFirstColBias + i][jFirstColBias];
            matrix[iFirstColBias + i][jFirstColBias] = matrix[iLastColBias + i][jLastColBias];
            matrix[iLastColBias + i][jLastColBias] = swapBuffer[i];

            swapBuffer[i] = matrix[jFirstColBias][iFirstColBias + i];
            matrix[jFirstColBias][iFirstColBias + i] = matrix[jLastColBias][iLastColBias + i];
            matrix[jLastColBias][iLastColBias + i] = swapBuffer[i];
        }

        return matrix;
    }

    private void print(int[][] matrix){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                stringBuilder.append(matrix[i][j]);
                stringBuilder.append(", ");
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("_________________________\n");
        System.out.print(stringBuilder);
    }

}
