public class ImageHelperNotes {

	static boolean validMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix.length != matrix[i].length) return false;
		}
		return true;
	}
	
	static int[][] rotateClockwise(int[][] matrix){
		//to rotate, make two separate cases for an odd n and even n (example: 3x3 and 4x4 should be handled differently)
		//For rotating corners "a", "b", "c", "d", store d in another variable "e", set d = c, set c = b, set b = a, and set a = e.
		//Same goes for rotating non-corner pieces
		//If middle piece in odd, no rotation
		
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
		//to rotate, make two separate cases for an odd n and even n (example: 3x3 and 4x4 should be handled differently)
		//For rotating corners "a", "b", "c", "d", store d in another variable "e", set d = c, set c = b, set b = a, and set a = e.
		//Same goes for rotating non-corner pieces
		//If middle piece in odd, no rotation
		
		//FOR ROTATION DO TWO FOR LOOPS BUT THEY ONLY IMPACT A QUARTER OF THE SCREEN AND j = i EVERYTIME (start at 0,0 and then 1,1 bc you'll have the whole outside ring done by this time)
		//do top left, top right, bottom right, and bottom left all at once in one loop
		//then go one to the right of top left, one below top right, one left of bottom right, and one up for bottom left somehow
		//find some way to check if the inner loop has run an even number of times by the end (BUT THERE'S STILL ONE VALUE LEFT)
		//if it has, then it's an odd valued loop, and you do that final rotation
		
		//ORRRRR TWO INNER LOOPS INSIDE OUTER LOOP AND THE BOTTOM ONE JUST RUNS AT j-1 SO YOU HAVE A DEDICATED EVEN LOOP AND ODD LOOP TO FIX ALL PROBLEMS (just have i go down by 2 at a time)
		//since odd and even nxn's will be handled differently, it'll make it easier to handle when you subtract 2 enough times from an odd nxn and get 1 remainder (make something separate for that
		//OR JUST REALIZE THAT ITLL BE THE MIDDLE CIRCLE AND NOBODY CARES BC IT'S NOT GOING TO MOVE
		//Insane
		
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
		//to flip, make two separate cases for an odd n and even n (example: 3x3 and 4x4 should be handled differently)
		//For flipping variables "a" and "b", store b in another variable "c" while setting b = a. Then set a = c. Done.
		//Middle column stays exactly the same if odd.
		int c = 0; //used c to work through the concept to understand it myself so I shall keep it named "c"
		
		for (int i = 0; i < (matrix.length) / 2; i++) { //DONT NEED EVEN OR ODD CHOOSING BC MIDDLE STAYS THE SAME SO FUCK THAT
			for (int j = 0; j < matrix[i].length; j++) { //don't need matrix[i].length and could use matrix.length since they're definitely the same but whatever
				c = matrix[matrix.length-i-1][j];
				matrix[matrix.length-i-1][j] = matrix[i][j];
				matrix[i][j] = c;
			}
		}
		
		/*if (matrix.length % 2 == 0) {	//even n value
			for (int i = 0; i < (matrix.length) / 2; i++) {
				for (int j = 0; j < matrix[i].length; j++) { //don't need matrix[i].length and could use matrix.length since they're definitely the same but whatever
					c = matrix[matrix.length-i-1][j];
					matrix[matrix.length-i-1][j] = matrix[i][j];
					matrix[i][j] = c;
				}
			}
		}
		else {							//odd n value
			for (int i = 0; i < (matrix.length) / 2; i++) {
				for (int j = 0; j < matrix[i].length; j++) { //don't need matrix[i].length and could use matrix.length since they're definitely the same but whatever
					c = matrix[matrix.length-i-1][j];
					matrix[matrix.length-i-1][j] = matrix[i][j];
					matrix[i][j] = c;
				}
			}
		}*/
		return matrix;
	}
	
	static int[][] flipHorizontal(int[][] matrix) {
		//to rotate, make two separate cases for an odd n and even n (example: 3x3 and 4x4 should be handled differently)
		//For flipping variables "a" and "b", store b in another variable "c" while setting b = a. Then set a = c. Done.
		//Middle row stays exactly the same if odd.
		
		
		//FOR FLIP DO ONE SET OF TWO FOR LOOPS AND GO HALFWAY (ROUNDING DOWN SO THE MIDDLE ONE DOESNT GET MESSED UP)
		//CHANGE THE TWO VARIABLES AT ONCE IN ONE LOOP (do top left and bottom left at once) THEN MOVE ON (1 to the right from top left and one to the right from bottom left)
		
		if (matrix.length % 2 == 0) {	//even n value
			
		}
		else {							//odd n value
			
		}
		return matrix;
	}
	
	static int[][] testingMatrix(){ //((used just for test)
		java.util.Scanner input = new java.util.Scanner(System.in);
		int n = 0;
		System.out.println("Give n a number to feel whole again: ");
		n = input.nextInt();
		
		int nice = 0;
		int[][] hello = new int[n][n];
		System.out.println("whole length = " + hello.length);
		
		for (int i = 0; i < hello.length; i++) {
			System.out.println("length = " + hello[i].length);
			for (int j = 0; j < (hello[i].length); j++) {
				System.out.print("i = " + i);
				System.out.println(" j = " + j);
				hello[i][j] = nice;
				nice++;
			}
		}
		
		return hello;
	}
	
	static int[][] smoothen(int[][] matrix){                   //Extra credit he assigned AS I WAS GOING TO HAND IT IN (surprisingly easy to do tho tbh)
		int[][] newMatrix = new int[matrix.length][matrix.length];
		
		//function is meant to make new matrix where each cell's value is replaced with the average of itself and all neighboring cells
		//but also depends on the amount of cells (if corner cell, only 4 values (including itself) get averaged)
		
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
		//No main, so no need to test valid inputs
		
				//int[][] flipVertTest = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
				//int[][] flipVertTest = {{1, 2},{3, 4}};
				//int[][] flipVertTest = {{1}};
				//int[][] flipVertTest = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
				int[][] flipVertTest = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
				//int[][] flipVertTest = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
				//int[][] flipVertTest = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};
				
				//int[][] rotateTest = {{1}};
				//int[][] rotateTest = {{1, 2},{3, 4}};
				int[][] rotateTest = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
				//int[][] rotateTest = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
				//int[][] rotateTest = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
				//int[][] rotateTest = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};
				
				//for rotations and flips, could even set "e" or "c" (respectively) to 0 or -1 by the end so even the extra variable keeps nothing from the matrix for security? (just an idea)
				
				/*int[][] done = testingMatrix();
				for (int i = 0; i < done.length; i++) {
					for (int j = 0; j < done[i].length;j++) {
						//System.out.print("[" + i + ", " + j + "],");
						System.out.print("[" + done[i][j] + "]");
					}
					System.out.println();
				}*/
				
				for (int i = 0; i < flipVertTest.length; i++) {
					for (int j = 0; j < flipVertTest[i].length;j++) {
						//System.out.print("[" + i + ", " + j + "],");
						System.out.print("[" + flipVertTest[i][j] + "]");
					}
					System.out.println();
				}
				
				System.out.println();
				
				System.out.println();
				
				int[][] flipping = flipVertical(flipVertTest);
				
				for (int i = 0; i < flipping.length; i++) {
					for (int j = 0; j < flipping[i].length;j++) {
						//System.out.print("[" + i + ", " + j + "],");
						System.out.print("[" + flipping[i][j] + "]");
					}
					System.out.println();
				}
				
				System.out.println();
				
				flipping = flipVertical(flipVertTest);
				
				for (int i = 0; i < flipping.length; i++) {
					for (int j = 0; j < flipping[i].length;j++) {
						//System.out.print("[" + i + ", " + j + "],");
						System.out.print("[" + flipping[i][j] + "]");
					}
					System.out.println();
				}
				
				System.out.println();
				
				System.out.println();
				
				int[][] horizontalTime = flipHorizontal(flipVertTest);
				
				for (int i = 0; i < horizontalTime.length; i++) {
					for (int j = 0; j < horizontalTime[i].length;j++) {
						//System.out.print("[" + i + ", " + j + "],");
						System.out.print("[" + horizontalTime[i][j] + "]");
					}
					System.out.println();
				}
				
				System.out.println();
				
				horizontalTime = flipHorizontal(flipVertTest);
				
				for (int i = 0; i < horizontalTime.length; i++) {
					for (int j = 0; j < horizontalTime[i].length;j++) {
						//System.out.print("[" + i + ", " + j + "],");
						System.out.print("[" + horizontalTime[i][j] + "]");
					}
					System.out.println();
				}
				
				System.out.println();
				
				System.out.println();
				
				//for the clockwise and counterclockwise rotations (I'll need the room)
				
				for (int i = 0; i < rotateTest.length; i++) {
					for (int j = 0; j < rotateTest[i].length;j++) {
						//System.out.print("[" + i + ", " + j + "],");
						System.out.print("[" + rotateTest[i][j] + "]");
					}
					System.out.println();
				}
				
				System.out.println();
				
				System.out.println();
				
				int[][] rotateClock = rotateClockwise(rotateTest);
				
				for (int i = 0; i < rotateClock.length; i++) {
					for (int j = 0; j < rotateClock[i].length;j++) {
						//System.out.print("[" + i + ", " + j + "],");
						System.out.print("[" + rotateClock[i][j] + "]");
					}
					System.out.println();
				}
				
				System.out.println();
				
				int[][] rotateCounter = rotateCounterClockwise(rotateClock);
				
				for (int i = 0; i < rotateCounter.length; i++) {
					for (int j = 0; j < rotateCounter[i].length;j++) {
						//System.out.print("[" + i + ", " + j + "],");
						System.out.print("[" + rotateCounter[i][j] + "]");
					}
					System.out.println();
				}
				
				System.out.println();
				
				int[][] matrixTest = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
				int[][] testTime = smoothen(matrixTest);
				
				for (int i = 0; i < testTime.length; i++) {
					for (int j = 0; j < testTime.length; j++) {
						System.out.print("[" + testTime[i][j] + "]");
					}
					System.out.println();
				}
		
		
		//maybe i dont need to make a case for odd and even bc the middle never changes for flips
		//for rotation maybe I can repeat the code but make it stop at i = 1 (OR I can make a test in the outer loop saying that  if (matrix.length % 2 != 0 && i == 1) then I break the loop and finish
		//NEED static call for test cases to work apparently
	}

}
