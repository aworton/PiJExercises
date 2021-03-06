public class App{
    public static void main(String[] args){
        MatrixChecker checker = new MatrixChecker();

        int[] sym = {1,5,8,8,5,1};
        int[] notSym = {1,8,8,8,5,1};

        int[][] sym2d = new int[2][2];
        sym2d[0][0] = 1;
        sym2d[0][1] = 1;
        sym2d[1][0] = 1;
        sym2d[1][1] = 1;

        int[][] notSym2d = new int[2][2];
        notSym2d[0][0] = 1;
        notSym2d[0][1] = 2;
        notSym2d[1][0] = 3;
        notSym2d[1][1] = 4;

        int[][] triangular = new int[2][2];
        triangular[0][0] = 1;
        triangular[0][1] = 2;
        triangular[1][0] = 0;
        triangular[1][1] = 4;

        int[][] notTriangular = new int[2][2];
        notTriangular[0][0] = 1;
        notTriangular[0][1] = 2;
        notTriangular[1][0] = 3;
        notTriangular[1][1] = 4;

        System.out.println(checker.isSymmetrical(sym));
        System.out.println(checker.isSymmetrical(notSym));

        System.out.println(checker.isSymmetrical(sym2d));
        System.out.println(checker.isSymmetrical(notSym2d));

        System.out.println(checker.isTriangular(triangular));
        System.out.println(checker.isTriangular(notTriangular));


    }
}