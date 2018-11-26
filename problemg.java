import java.util.Scanner;

/**
 * @author Tino Muzambi
 * @version 2018/11/25 4:10 PM
 */

//TODO Figure out how to use Scanner properly.

public class problemg {
    private static int count=0;

    /**
     * Prints out a 2D array.
     * @param matrix 2D array to be printed.
     */
    public static void printMatrix(String matrix[][]) {
        for (int i=0;i<matrix.length;i++) {
            String out="";
            for (int j=0;j<matrix[i].length;j++) {
                out+=matrix[i][j];
            }
            System.out.println(out);
        }
        System.out.println();
    }

    /**
     * Turns all the columns of a 2D array
     * into the rows and vice versa.
     * @param matrix 2D array to be transposed.
     */
    public static String[][] transpose(String matrix[][]) {
        String[][] temp=new String[matrix.length][matrix.length];
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                temp[i][j]=matrix[i][j];
            }
        }
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                matrix[i][j]=temp[j][i];
            }
        }
        return matrix;
    }

    /**
     * Swaps row1 of the 2D array with row2.
     * @param matrix 2D array to be swapped.
     * @return
     */
    public static String[][] row(String matrix[][], int row1, int row2) {
        String[][] temp=new String[matrix.length][matrix.length];
        for (int i=0;i<matrix.length;i++) {     //System.arraycopy()
            for (int j=0;j<matrix[i].length;j++) {
                temp[i][j]=matrix[i][j];
            }
        }
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                if (i==row1) {
                    matrix[i][j]=matrix[row2][j];
                    matrix[row2][j]=temp[i][j];
                }
            }
        }
        return matrix;
    }

    /**
     * Swaps col1 column of the 2D array
     * with col2 column.
     * @param matrix 2D array to be swapped.
     */
    public static String[][] col(String matrix[][], int col1, int col2) {
        String[][] temp=new String[matrix.length][matrix.length];
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                temp[i][j]=matrix[i][j];
            }
        }
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                if (j==col1) {
                    matrix[i][j]=matrix[i][col2];
                    matrix[i][col2]=temp[i][j];
                }
            }
        }
        return matrix;
    }

    /**
     * Increases every value of a 2D
     * array by 1.
     * @param matrix 2D array to be increased.
     */
    public static String[][] inc(String matrix[][]) {
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                matrix[i][j]=String.valueOf(Integer.parseInt(matrix[i][j])+1);
            }
        }
        return matrix;
    }

    /**
     * Decreases every value of a 2D
     * array by 1.
     * @param matrix 2D array to be decreased.
     */
    public static String[][] dec(String matrix[][]) {
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[i].length;j++) {
                matrix[i][j]=String.valueOf(Integer.parseInt(matrix[i][j])-1);
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int noTrials=Integer.parseInt(input.next());
        for (int i=0;i<noTrials;i++) {
            count+=1;
            System.out.println("Case #"+count);
            int matrixSize=Integer.parseInt(input.next());
            String[][] matrix=new String[matrixSize][matrixSize];
            for (int j=0;j<matrixSize;j++) {
                String line=input.next();
                matrix[j]=line.split("");
            }
            int noQueries=Integer.parseInt(input.next());
            String query;
            for (int k=0;k<noQueries;k++){
                query=input.next();
                if (query.equals("transpose")) {
                    matrix=transpose(matrix);
                }
                else if (query.contains("row")) {
                    int row1=Integer.parseInt(input.next())-1;
                    int row2=Integer.parseInt(input.next())-1;
                    matrix=row(matrix,row1,row2);
                }
                else if (query.contains("col")){
                    int col1=Integer.parseInt(input.next())-1;
                    int col2=Integer.parseInt(input.next())-1;
                    matrix=col(matrix,col1,col2);
                }
                else if (query.equals("inc")) {
                    matrix=inc(matrix);
                }
                else {
                    matrix=dec(matrix);
                }
            }
            printMatrix(matrix);
        }
    }
}


//Sample IO

/*
2
4
1234
5678
1234
5678
1
transpose
3
000
111
000
2
row 1 2
inc
 */

/*
2
4
1234
5678
1234
5678
1
transpose
3
012
345
678
1
col 1 2
 */

/*
1
4
1234
5678
1234
5678
2
dec
dec
 */