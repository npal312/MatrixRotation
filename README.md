# MatrixRotation
Performs various operations on a given n x n 2D matrix.

Assignment Description: (From SSW-315)

Write an ImageHelper class to provide the following methods to its user for a given n x n 2D matrix representing an image (where n is the length of the matrix).

boolean validMatrix(int[][] matrix)
void flipVertical(int[][] matrix)
void flipHorizontal(int[][] matrix)
void rotateClockwise(int[][] matrix)
void rotateCounterCockwise(int[][] matrix)

Constraints: 

All methods should operate on the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix for the operation.
1 <= n <= 1000
 

rotateClockwise Example 1:
Input: rotateClockwise([[1,2,3],[4,5,6],[7,8,9]])
Output: [[7,4,1],[8,5,2],[9,6,3]]

rotateClockwise Example 2:
Input: rotateClockwise([[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]])
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Notes:

Submission instructions might change as we discuss the assignment and clarify ambiguities.
Each method should implement rotation in the most efficient manner (e.g., counterClockwise rotation should not rotate image 3 times).
Homework will be done individually: each student must hand in their own answers. It is acceptable for students to discuss understanding the material but not solving the problems or programming. Use of the Internet is allowed, but should not include searching for existing solutions.
You need to have a test for each method. You may use Arrays.deepEquals() method to compare two matrixes in the test code.
You can not use any Java utility class that help with matrix or image manipulation.
Bonus [1 point]: Implement int[][] smoothen(int[][] matrix) method that returns a new matrix where each cell's value is replaced with the average of itself and all of its neighboring cells. Note that a cell typically has 8 neighboring cells (blue region for matrix[1][1]) but a cell on the edges of the image would have fewer neighbors (red region for matrix[4][4]).


smoothen() Example:
Input: smoothen([[100,200,100],[200,50,200],[100,200,100]])
Output: [[137,141,137],[141,138,141],[137,141,137]]

Explanation:
For the points (0,0), (0,2), (2,0), (2,2): (100+200+200+50)/4 = floor(137.5) = 137
For the points (0,1), (1,0), (1,2), (2,1): (200+200+50+200+100+100)/6 = floor(141.666667) = 141
For the point (1,1): (50+200+200+200+200+100+100+100+100)/9 = floor(138.888889) = 138
Submission:

Java source code named ImageHelper.java
Java source code for unit testing ImageHelperTest.java.
Screenshot of your test run as pdf or image (jpg, jpeg, png)
Grading:

1.5 points - Each method (i.e., validMatrix, flipVertical, flipHorizontal, rotateClockwise, rotateCounterCockwise)
0.4 points - Each method's test
0.5 points - Formatting and code structure
-0.5 points - lack of IDE run screenshot
+1 point - bonus for smoothen method with test
