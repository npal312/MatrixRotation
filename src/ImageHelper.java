public class ImageHelper {

	static boolean validMatrix(int[][] matrix) {
		if (matrix.length < 1 || matrix.length > 1000) return false;
		else {
			for (int i = 0; i < matrix.length; i++) {
				if (matrix.length != matrix[i].length) return false;
			}
		}
		return true;
	}
	
	static int[][] rotateClockwise(int[][] matrix){
		int e = 0; //I used e to work through the concept, so I shall keep it as "e"
		
		if (matrix.length % 2 == 0) {	//even n value
			for (int i = 0; i < (matrix.length) / 2; i++) {
				for (int j = 0; j < (matrix.length) / 2; j++){
					e = matrix[i][j];
					matrix[i][j] = matrix[matrix.length-j-1][i];
					matrix[matrix.length-j-1][i] = matrix[matrix.length-i-1][matrix.length-j-1];
					matrix[matrix.length-i-1][matrix.length-j-1] = matrix[j][matrix.length-i-1];
					matrix[j][matrix.length-i-1] = e;					
				}
			}
		}
		else {							//odd n value
			for (int i = 0; i < (matrix.length) / 2; i++) {
				for (int j = 0; j < ((matrix.length) / 2) + 1; j++){
					e = matrix[i][j];
					matrix[i][j] = matrix[matrix.length-j-1][i];
					matrix[matrix.length-j-1][i] = matrix[matrix.length-i-1][matrix.length-j-1];
					matrix[matrix.length-i-1][matrix.length-j-1] = matrix[j][matrix.length-i-1];
					matrix[j][matrix.length-i-1] = e;					
				}
			}
		}
		return matrix;
	}
	
	static int[][] rotateCounterClockwise(int[][] matrix) {
		int e = 0; //I used e to work through the concept, so I shall keep it as "e"
		
		if (matrix.length % 2 == 0) {	//even n value
			for (int i = 0; i < (matrix.length) / 2; i++) {
				for (int j = 0; j < (matrix.length) / 2; j++){
					e = matrix[i][j];
					matrix[i][j] = matrix[j][matrix.length-i-1];
					matrix[j][matrix.length-i-1] = matrix[matrix.length-i-1][matrix.length-j-1];
					matrix[matrix.length-i-1][matrix.length-j-1] = matrix[matrix.length-j-1][i];
					matrix[matrix.length-j-1][i] = e;					
				}
			}
		}
		else {							//odd n value
			for (int i = 0; i < (matrix.length) / 2; i++) {
				for (int j = 0; j < ((matrix.length) / 2) + 1; j++){
					e = matrix[i][j];
					matrix[i][j] = matrix[j][matrix.length-i-1];
					matrix[j][matrix.length-i-1] = matrix[matrix.length-i-1][matrix.length-j-1];
					matrix[matrix.length-i-1][matrix.length-j-1] = matrix[matrix.length-j-1][i];
					matrix[matrix.length-j-1][i] = e;				
				}
			}
		}
		return matrix;
	}
	
	static int[][] flipVertical(int[][] matrix) {
		int c = 0; //used c to work through the concept to understand it myself so I shall keep it named "c"
		
		for (int i = 0; i < (matrix.length) / 2; i++) {
			for (int j = 0; j < matrix.length; j++) { //don't need matrix[i].length and could use matrix.length since they're definitely the same but whatever
				c = matrix[matrix.length-i-1][j];
				matrix[matrix.length-i-1][j] = matrix[i][j];
				matrix[i][j] = c;
			}
		}
		return matrix;
	}
	
	static int[][] flipHorizontal(int[][] matrix) {
		int c = 0; //used c to work through the concept to understand it myself so I shall keep it named "c"
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < (matrix.length) / 2; j++) { //don't need matrix[i].length and could use matrix.length since they're definitely the same but whatever
				c = matrix[i][matrix.length-j-1];
				matrix[i][matrix.length-j-1] = matrix[i][j];
				matrix[i][j] = c;
			}
		}
		return matrix;
	}
	
	static int[][] smoothen(int[][] matrix){
		int[][] newMatrix = new int[matrix.length][matrix.length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				int sum = 0; //sum of neighboring cells
				int div = 0; //number of cells to divide by
				if (i > 0 && j > 0) { //top left
					sum += matrix[i-1][j-1];
					div++;
				}
				if(i > 0) { //top
					sum += matrix[i-1][j];
					div++;
				}
				if(i > 0 && j < matrix.length - 1) { //top right
					sum += matrix[i-1][j+1];
					div++;
				}
				if(j > 0) { //middle left
					sum += matrix[i][j-1];
					div++;
				}
				if(j < matrix.length - 1) { //middle right
					sum += matrix[i][j+1];
					div++;
				}
				if(i < matrix.length - 1 && j > 0) { //bottom left
					sum += matrix[i+1][j-1];
					div++;
				}
				if(i < matrix.length - 1) { //bottom
					sum += matrix[i+1][j];
					div++;
				}
				if(i < matrix.length - 1 && j < matrix.length - 1) { //bottom right
					sum += matrix[i+1][j+1];
					div++;
				}
				sum += matrix[i][j]; //itself
				div++;
				
				int avg = sum / div;
				newMatrix[i][j] = avg;
			}
		}
		return newMatrix;
	}
	
	
	public static void main(String[] args) {
	}
}
