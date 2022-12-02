public class GameControl {

    private final int BOARD_SIZE = 8;
    private int [][] board;
    private int [][] grayScaleMapBlack = new int[BOARD_SIZE][BOARD_SIZE];
    private int [][] grayScaleMapWhite = new int[BOARD_SIZE][BOARD_SIZE];

    

    public GameControl(int [][] board) {
        this.board = board;
    }

    public boolean checkValidity(int [] oldChessPiecePosition, int [] newChessPiecePosition){
        int boardPieceAtPosition = board[oldChessPiecePosition[1]][oldChessPiecePosition[0]];
        
        
        
        return false;
    }

    public boolean checkPawnMove(int [] oldChessPiecePosition, int [] newChessPiecePosition, int [][] board){
        

        
        return false;
    }
}
