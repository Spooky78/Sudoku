public class Main {
    public static void main(String[] args) {

        int[][] puzzle1Unsolved =  new int[][]{
                {-1, -1, -1, -1, -1, -1, 2, -1, -1},
                {6, -1, 2, -1, -1, -1, 5, -1, -1},
                {-1, 8, -1, -1, -1, 7, -1, 9, -1},
                {-1, 7, -1, -1, 6, -1, -1, -1, -1},
                {-1, -1, -1, 9, -1, 1, -1, -1, -1},
                {-1, -1, -1, -1, 2, -1, -1, 4, -1},
                {-1, -1, 5, -1, -1, -1, 6, -1, 3},
                {-1, 9, -1, 4, -1, -1, -1, 7, -1},
                {-1, -1, 6, -1, -1, -1, -1, -1, -1}};

        for (int[] ints : puzzle1Unsolved) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();

        Sudoku sudoku1 = new Sudoku(puzzle1Unsolved);
        //if solvable print else error
        if (sudoku1.isSolvable()){
            int[][] puzzleSolved = sudoku1.getSolved();
            for (int[] ints : puzzleSolved) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Can't solve puzzle");
        }
    }
}