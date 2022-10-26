/*
 * solve sudoku using backtracking,
 * the puzzle is a 2d array, where inner array is rows
 * return if solution exists
 * return solved puzzle if possible
 */
public class Sudoku {
    private static final int EMPTY = -1;
    private static final int FULL_GRID = 100;
    private boolean isSolved;
    private int[][] puzzleToSolve = new int[9][9];

    public Sudoku(int[][] puzzle){
        puzzleToSolve = puzzle;
        isSolved = solveSudoku();
    }

    private boolean solveSudoku(){
        //choose where can go
        int[] emptySpace = findNextEmpty();
        int row = emptySpace[0];
        int col = emptySpace[1];

        //check if grid is full
        if (row == FULL_GRID || col ==FULL_GRID){
            return true;
        }
        //if empty place, make guess between 1-9
        for(int guess=1; guess<10; guess++){
            //checks if guess is valid
            boolean isValidGuess = isGuessValid(row, col, guess);
            if(isValidGuess){
                puzzleToSolve[row][col] = guess;

                //recursively call function
                if (solveSudoku()){
                    return true;
                }
            }
            //if not valid or guess is wrong, backtrack - new guess
            puzzleToSolve[row][col] = -1;
        }
        //no number works therefore puzzle unsolvable
        return false;
    }

    //finds the next row & col on the puzzle that is EMPTY
    private int[] findNextEmpty(){
        int[] emptyCoords = {FULL_GRID,FULL_GRID};
        for(int i=0; i<puzzleToSolve.length; i++){
            for(int j=0; j<puzzleToSolve[i].length; j++){
                if(puzzleToSolve[i][j] == EMPTY){
                    emptyCoords[0] = i;
                    emptyCoords[1] = j;
                    return emptyCoords;
                }
            }
        }
        return emptyCoords;
    }

    //checks if guess is valid
    private boolean isGuessValid(int row, int col, int guess) {
        //checks if guess is in row or column
        boolean validGuess = true;
        int search = 0;
        while (validGuess && search < 9){
            if (puzzleToSolve[row][search]==guess){
                validGuess = false;
                return false;
            } else if (puzzleToSolve[search][col]==guess){
                validGuess = false;
                return false;
            }
            search++;
        }

        //check if guess is in mini grid
        int miniGridStartRow = (row/3) * 3;
        int miniGridStartCol = (col/3) * 3;
        for(int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(puzzleToSolve[i+miniGridStartRow][j+miniGridStartCol]==guess){
                    validGuess = false;
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSolvable(){
        return isSolved;
    }

    public int[][] getSolved(){
        return puzzleToSolve;
    }
}

