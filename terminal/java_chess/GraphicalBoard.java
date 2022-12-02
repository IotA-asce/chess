import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

public class GraphicalBoard extends JFrame {
    private int[][] board;
    private final int BOARD_SIZE = 8;
    private final int BOARD_PIXELS_SIZE = 800;
    private final int TILE_PIXELS_SIZE = 100;

    private JFrame jFrame;
    private int[] oldMousePositons = new int[2];
    private int[] newMousePositons = new int[2];
    private boolean oldValueTaken = false;
    
    ChessPanel chessPanel = new ChessPanel();
    
    public GraphicalBoard() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        jFrame = new JFrame();

        jFrame.addMouseListener(new MouseInputAdapter() {
            /**
             * Listens to click events on the board and updates the mouse position variables
             */

            @Override
            public void mousePressed(java.awt.event.MouseEvent event) {
                System.out.println(event.getX() / TILE_PIXELS_SIZE + " " + event.getY() / TILE_PIXELS_SIZE);

                if (!oldValueTaken) {
                    oldMousePositons[0] = event.getX() / TILE_PIXELS_SIZE;
                    oldMousePositons[1] = event.getY() / TILE_PIXELS_SIZE;
                } else {
                    newMousePositons[0] = event.getX() / TILE_PIXELS_SIZE;
                    newMousePositons[1] = event.getY() / TILE_PIXELS_SIZE;
                    updateBoard(oldMousePositons, newMousePositons);
                    printBoard();
                }

            }

        });

        // init the board
        for (int i = 0; i < board.length; i++) {
            board[1][i] = -1; // PAWN placement
            board[6][i] = 1;
        }

        board[0][0] = -2; // ROOK
        board[7][0] = 2;
        board[0][7] = -2;
        board[7][7] = 2;

        board[0][1] = -3; // KNIGHT
        board[7][1] = 3;
        board[0][6] = -3;
        board[7][6] = 3;

        board[0][2] = -4; // BISHOP
        board[7][2] = 4;
        board[0][5] = -4;
        board[7][5] = 4;

        board[0][3] = -5; // QUEEN
        board[7][4] = 5;

        board[0][4] = -6; // KING
        board[7][3] = 6;
    }

    public void updateBoard(int[] oldPositions, int[] newPositions) {
        int chessPieceAtOldPosition = board[oldPositions[0]][oldPositions[1]];

        board[newPositions[0]][newPositions[1]] = chessPieceAtOldPosition;
        board[oldPositions[0]][oldPositions[1]] = 0;
        chessPanel.board = board;
        jFrame.getContentPane().remove(chessPanel);
        jFrame.getContentPane().add(chessPanel);
        SwingUtilities.updateComponentTreeUI(jFrame);
        printBoard();
    }

    public int getBoardSize() {
        return BOARD_SIZE;
    }

    // Queen operation
    public void addQueen(int row, int column) {
        board[row][column] = 5;
    }

    public void removeQueen(int row, int column) {
        board[row][column] = 0;
    }

    // Forbidden move check
    public boolean isForbidden(int row, int column) {

        // Row check
        for (int columnItterator = 0; columnItterator < BOARD_SIZE; columnItterator++) {
            if (board[row][columnItterator] == 5) {
                return true;
            }
        }

        // Column check
        for (int rowItterator = 0; rowItterator < BOARD_SIZE; rowItterator++) {
            if (board[rowItterator][column] == 5) {
                return true;
            }
        }

        for (int rowItterator = 0; rowItterator < BOARD_SIZE; rowItterator++) {
            for (int columnItterator = 0; columnItterator < BOARD_SIZE; columnItterator++) {
                if ((rowItterator != row) && (columnItterator != column) && board[row][column] == 5) {
                    if (Math.abs(rowItterator - row) == Math.abs(columnItterator - column)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void display() {
        jFrame.setSize(800, 800);
        jFrame.setTitle("Chess");

        chessPanel = new ChessPanel();
        chessPanel.board = board;

        jFrame.getContentPane().add(chessPanel);
        jFrame.setVisible(true);

    }

    @Override
    public String toString() {
        String chessBoardString = "Chessboard: \n";
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                chessBoardString += "\t" + board[i][j];
            }
            chessBoardString += "\n";
        }

        return chessBoardString;
    }

    private void printBoard(){
        String chessBoardString = "Chessboard: \n";
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                chessBoardString += "\t" + board[i][j];
            }
            chessBoardString += "\n";
        }
        
        System.out.println(chessBoardString);
    }
}
