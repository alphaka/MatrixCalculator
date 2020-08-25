import java.util.Arrays;
import java.util.Scanner;

public class Matrix {

	public static void main(String[] args) {

	System.out.println("Enter a 3 by 3 matrix line by line each after the return key");

	Scanner sc = new Scanner(System.in);

	double [] mat = new double[9];

	double [] matR; // that matrix is printing Row space (matrix)

	double b,c,d,g,h;

	for(int i = 0; i<9; i++) {

		mat[i] = sc.nextDouble();
	}

	System.out.println("\nThe entered-matrix is:\n");
	for(int z=0;z<9;z += 3)
		System.out.println("\t"+mat[z] + "\t"+mat[z+1] +"\t"+mat[z+2]);

	double[] matO = Arrays.copyOf(mat, mat.length);

	// Transpose of mat

	System.out.println("\nThe transpose of the matrix is:\n");
	System.out.println("\t"+mat[0] + "\t"+mat[3] +"\t"+mat[6] +"\n"+
			   "\t"+mat[1] + "\t"+mat[4] +"\t"+mat[7] +"\n"+
			   "\t"+mat[2] + "\t"+mat[5] +"\t"+mat[8]);

	// Swapping the rows		

	if((mat[0]==0.0) && (mat[3]!=0.0 || (mat[6]!=0.0))) {
		System.out.println("Swap some rows than try again" +
		"\nNote: Row(A) will be correct, but Col(A) WON'T BE CORRECT, consider" +
		"\nonly the dimension of the displayed one and copy your original vectors.\n\n");
		System.exit(0);
	}

	// zeroing the 3rd index
	d = -mat[3]/mat[0];
	for(int i = 3; i<6; i++)
		mat[i] += d*mat[i-3];


	// zeroing the 6th index
	g = -mat[6]/mat[0];
	for(int i = 6; i<9; i++)
		mat[i] += g*mat[i-6];

	// zeroing the 7th index
	h = -mat[7]/mat[4];
	for(int i = 7; i<9; i++)
		mat[i] += h*mat[i-3];

	matR = Arrays.copyOf(mat,9);

	if(mat[8]==0.0) {

        System.out.println("\nThe Row-Echelon form of the matrix is:\n");
        for(int z=0;z<9;z+= 3)
              System.out.println("\t"+mat[z] + "\t"+mat[z+1] +"\t"+mat[z+2]);

	System.out.println("\nAs the third row is free, this matrix doesn't have any LU factor.");

	// Priting the Col(matrix)
	System.out.println("\nA basis of the Column Space of the matrix is:\n" +
			   "\t|"+matO[0]+ "\t|"+matO[1]+
			   "\n\t|"+matO[3]+ "\t|"+matO[4]+
			   "\n\t|"+matO[6]+ "\t|"+matO[7]);

	// Priting the Row(matrix)
	System.out.println("\nA basis of the Row Space of the matrix is:\n" +
			   "\t|"+mat[0]+ "\t|"+mat[3]+
                           "\n\t|"+mat[1]+ "\t|"+mat[4]+
                           "\n\t|"+mat[2]+ "\t|"+mat[5]);

                } else {

	System.out.println("\nThe U factorization or Row-Echelon form of the matrix is:\n");

	for(int z=0;z<9;z += 3)
                System.out.println("\t"+mat[z] + "\t"+mat[z+1] +"\t"+mat[z+2]);

	System.out.println("\nThe L factorization of the matrix is:\n");

	double [] matL = new double [9];
	for(int i= 0; i<9; i++)
		matL[i] = 0.0;

	matL[0] = matL[4] = matL[8] = 1.0;
	matL[3] = -d;
	matL[6] = -g;
	matL[7] = -h;

	for(int z=0;z<9;z += 3)
                System.out.println("\t"+matL[z] + "\t"+matL[z+1] +"\t"+matL[z+2]);

	// making 1 the last index
	mat[8] = 1.0;

	// zeroing the 5th index
        double f = -mat[8]/mat[5];
        mat[4] = mat[7] + f*mat[4];
	mat[5] = 0.0;

	// making 1 the 4th index
	if(mat[4]==0.0)
                mat[4] = 0.0;
                else
                mat[4] = 1.0;

	// zeroing the 2nd index
	c = -mat[2];
	for(int i =0; i<3; i++)
		mat[i] += c*mat[i+6];

	// zeroing the 1st index
	b = -mat[1];
	for(int i = 0; i<3; i++)
		mat[i] += b*mat[i+3];

	// making 1 the last index
	 if(mat[0]==0.0)
                mat[0] = 0.0;
                else
                mat[0] = 1.0;

	System.out.println("\nThe Reduced Row-Echelon form of the matrix is:\n");
	for(int z=0;z<9;z+= 3)
              System.out.println("\t"+mat[z] + "\t"+mat[z+1] +"\t"+mat[z+2]);

 	// Priting the Col(matrix)
        System.out.println("\nA basis of the Column Space of the matrix is:");
        System.out.println("\t|"+matO[0]+ "\t|"+matO[1]+ "\t|"+matO[2]+
                           "\n\t|"+matO[3]+ "\t|"+matO[4]+ "\t|"+matO[5]+
                           "\n\t|"+matO[6]+ "\t|"+matO[7]+ "\t|"+matO[8]);

        // Priting the Row(matrix)
        System.out.println("\nA basis of the Row Space of the matrix is:");
	System.out.println("\t|"+matR[0]+ "\t|"+matR[3]+ "\t|"+matR[6]+
                           "\n\t|"+matR[1]+ "\t|"+matR[4]+ "\t|"+matR[7]+
                           "\n\t|"+matR[2]+ "\t|"+matR[5]+ "\t|"+matR[8]);

	System.out.println("\nAs this matrix has trivial solution only:" +
                        "\nThis means the Null Space consists only of the zero vector," +
                        "\nand consequently has NO BASIS.\n\n\n");

	} // end else of mat[8]==0.0

	} // end main

}// end reducedMatrix
