import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ImageHelperTest {

	
	//validMatrix
	//test case for valid matrix, higher column number, and higher row number
	@Test
	void validMatrixTest() {
		String msg = "should be a valid matrix";
		int[][] test = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
		assertTrue(ImageHelper.validMatrix(test), msg);
	}
	
	@Test
	void tooManyInOneColumn() {
		String msg = "should be a valid matrix";
		int[][] test = {{1, 2, 3},{4, 5, 6, 7},{8, 9, 10}};
		assertFalse(ImageHelper.validMatrix(test), msg);
	}
	
	@Test
	void tooManyRows() {
		String msg = "should be a valid matrix";
		int[][] test = {{1, 2, 3},{4, 5, 6},{7, 8, 9},{10, 11, 12}};
		assertFalse(ImageHelper.validMatrix(test), msg);
	}
	
	
	
	//rotateClockwise
	//test case for even and odd
	@Test
	public void evenMatrixRotationClockwise() {
		String msg = "should be rotated clockwise correctly";
		int[][] test = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
		int[][] expected = {{13, 9, 5, 1},{14, 10, 6, 2},{15, 11, 7, 3},{16, 12, 8, 4}};
		assertArrayEquals(expected, ImageHelper.rotateClockwise(test), msg);
	}
	
	@Test
	public void oddMatrixRotationClockwise() {
		String msg = "should be rotated clockwise correctly";
		int[][] test = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
		int[][] expected = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2}, {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
		assertArrayEquals(expected, ImageHelper.rotateClockwise(test), msg);
	}
	
	//rotateCounterClockwise
	//test case for even and odd
	@Test
	public void evenMatrixRotationCounterClockwise() {
		String msg = "should be rotated counter-clockwise correctly";
		int[][] test = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
		int[][] expected = {{4, 8, 12, 16},{3, 7, 11, 15},{2, 6, 10, 14},{1, 5, 9, 13}};
		assertArrayEquals(expected, ImageHelper.rotateCounterClockwise(test), msg);
	}
	
	@Test
	public void oddMatrixRotationCounterClockwise() {
		String msg = "should be rotated counter-clockwise correctly";
		int[][] test = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
		int[][] expected = {{5, 10, 15, 20, 25}, {4, 9, 14, 19, 24}, {3, 8, 13, 18, 23}, {2, 7, 12, 17, 22}, {1, 6, 11, 16, 21}};
		assertArrayEquals(expected, ImageHelper.rotateCounterClockwise(test), msg);
	}
	
	//flipVertical
	//test case for even and odd
	@Test
	public void evenMatrixVerticalFlip() {
		String msg = "should be flipped vertically";
		int[][] test = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};
		int[][] expected = {{31, 32, 33, 34, 35, 36}, {25, 26, 27, 28, 29, 30}, {19, 20, 21, 22, 23, 24}, {13, 14, 15, 16, 17, 18}, {7, 8, 9, 10, 11, 12}, {1, 2, 3, 4, 5, 6}};
		assertArrayEquals(expected, ImageHelper.flipVertical(test), msg);
	}
	
	@Test
	public void oddMatrixVerticalFlip() {
		String msg = "should be flipped vertically";
		int[][] test = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
		int[][] expected = {{43, 44, 45, 46, 47, 48, 49}, {36, 37, 38, 39, 40, 41, 42}, {29, 30, 31, 32, 33, 34, 35}, {22, 23, 24, 25, 26, 27, 28}, {15, 16, 17, 18, 19, 20, 21}, {8, 9, 10, 11, 12, 13, 14}, {1, 2, 3, 4, 5, 6, 7}};
		assertArrayEquals(expected, ImageHelper.flipVertical(test), msg);
	}
	
	//flipHorizontal
	//test case for even and odd
	@Test
	public void evenMatrixHorizontalFlip() {
		String msg = "should be flipped horizontally";
		int[][] test = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};
		int[][] expected = {{6, 5, 4, 3, 2, 1}, {12, 11, 10, 9, 8, 7}, {18, 17, 16, 15, 14, 13}, {24, 23, 22, 21, 20, 19}, {30, 29, 28, 27, 26, 25}, {36, 35, 34, 33, 32, 31}};
		assertArrayEquals(expected, ImageHelper.flipHorizontal(test), msg);
	}
	
	@Test
	public void oddMatrixHorizontalFlip() {
		String msg = "should be flipped horizontally";
		int[][] test = {{1, 2, 3, 4, 5, 6, 7}, {8, 9, 10, 11, 12, 13, 14}, {15, 16, 17, 18, 19, 20, 21}, {22, 23, 24, 25, 26, 27, 28}, {29, 30, 31, 32, 33, 34, 35}, {36, 37, 38, 39, 40, 41, 42}, {43, 44, 45, 46, 47, 48, 49}};
		int[][] expected = {{7, 6, 5, 4, 3, 2, 1}, {14, 13, 12, 11, 10, 9, 8}, {21, 20, 19, 18, 17, 16, 15}, {28, 27, 26, 25, 24, 23, 22}, {35, 34, 33, 32, 31, 30, 29}, {42, 41, 40, 39, 38, 37, 36}, {49, 48, 47, 46, 45, 44, 43}};
		assertArrayEquals(expected, ImageHelper.flipHorizontal(test), msg);
	}
	
	//smoothen
	//one test case for validity
	@Test
	public void smoothenMatrix() {
		String msg = "should be smoothened out";
		int[][] test = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
		int[][] expected = {{137, 141, 137}, {141, 138, 141}, {137, 141, 137}};
		assertArrayEquals(expected, ImageHelper.smoothen(test), msg);
	}


}
