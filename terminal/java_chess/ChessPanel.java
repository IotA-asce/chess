import java.util.*;
import java.awt.*;
import javax.swing.*;

public class ChessPanel extends JPanel {
    int TILE_SIZE = 100;
    int BOARD_SIZE = 8;
    int[][] board;

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Dimension dimension = this.getSize();
        double minDimension = dimension.getHeight();
        if (dimension.getWidth() < minDimension) {
            minDimension = dimension.getWidth();
        }

        int cellSize = (int) (minDimension / BOARD_SIZE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // black pieces
        Image blackPawn = toolkit.getImage("./assets/IMAGE_SET/b_pawn_png_shadow_512px.png");
        Image blackRook = toolkit.getImage("./assets/IMAGE_SET/b_rook_png_shadow_512px.png");
        Image blackKnight = toolkit.getImage("./assets/IMAGE_SET/b_knight_png_shadow_512px.png");
        Image blackBihop = toolkit.getImage("./assets/IMAGE_SET/b_bishop_png_shadow_512px.png");
        Image blackQueen = toolkit.getImage("./assets/IMAGE_SET/b_queen_png_shadow_512px.png");
        Image blackKing = toolkit.getImage("./assets/IMAGE_SET/b_king_png_shadow_512px.png");

        // white pieces
        Image whitePawn = toolkit.getImage("./assets/IMAGE_SET/w_pawn_png_shadow_512px.png");
        Image whiteRook = toolkit.getImage("./assets/IMAGE_SET/w_rook_png_shadow_512px.png");
        Image whiteKnight = toolkit.getImage("./assets/IMAGE_SET/w_knight_png_shadow_512px.png");
        Image whiteBihop = toolkit.getImage("./assets/IMAGE_SET/w_bishop_png_shadow_512px.png");
        Image whiteQueen = toolkit.getImage("./assets/IMAGE_SET/w_queen_png_shadow_512px.png");
        Image whiteKing = toolkit.getImage("./assets/IMAGE_SET/w_king_png_shadow_512px.png");

        boolean isWhiteTile = true;
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                int topLeftXPos = column * cellSize;
                int topLeftYPos = row * cellSize;

                if (!isWhiteTile) {
                    graphics.setColor(Color.WHITE);
                    graphics.fillRect(topLeftXPos, topLeftYPos, cellSize, cellSize);

                    for (int i = topLeftXPos; i < board.length; i++) {
                        graphics.drawLine(topLeftXPos, column, topLeftXPos + TILE_SIZE, column);
                    }

                    for (int i = topLeftYPos; i < board.length; i++) {
                        graphics.drawLine(row, topLeftYPos, row, topLeftYPos + TILE_SIZE);
                    }
                }
                

                graphics.setColor(Color.BLACK);
                graphics.drawRect(topLeftXPos, topLeftYPos, cellSize, cellSize);

                if (column < board.length - 1) {
                    isWhiteTile = !isWhiteTile;
                }

                if(board[row][column] != 0){
                    int boardPositionValue = board[row][column];
                    // System.out.println(boardPositionValue);

                    if(boardPositionValue == -1)
                        graphics.drawImage(blackPawn, topLeftXPos + 1, topLeftYPos + 1, cellSize - 2, cellSize - 2, this);
                    else if(boardPositionValue == 1)
                        graphics.drawImage(whitePawn, topLeftXPos + 1, topLeftYPos + 1, cellSize - 2, cellSize - 2, this);
                    else if(boardPositionValue == -2)
                        graphics.drawImage(blackRook, topLeftXPos + 1, topLeftYPos + 1, cellSize - 2, cellSize - 2, this);
                    else if(boardPositionValue == 2)
                        graphics.drawImage(whiteRook, topLeftXPos + 1, topLeftYPos + 1, cellSize - 2, cellSize - 2, this);
                    else if(boardPositionValue == -3)
                        graphics.drawImage(blackKnight, topLeftXPos + 1, topLeftYPos + 1, cellSize - 2, cellSize - 2, this);
                    else if(boardPositionValue == 3)
                        graphics.drawImage(whiteKnight, topLeftXPos + 1, topLeftYPos + 1, cellSize - 2, cellSize - 2, this);
                    else if(boardPositionValue == -4)
                        graphics.drawImage(blackBihop, topLeftXPos + 1, topLeftYPos + 1, cellSize - 2, cellSize - 2, this);
                    else if(boardPositionValue == 4)
                        graphics.drawImage(whiteBihop, topLeftXPos + 1, topLeftYPos + 1, cellSize - 2, cellSize - 2, this);
                    else if(boardPositionValue == -5)
                        graphics.drawImage(blackQueen, topLeftXPos + 1, topLeftYPos + 1, cellSize - 2, cellSize - 2, this);
                    else if(boardPositionValue == 5)
                        graphics.drawImage(whiteQueen, topLeftXPos + 1, topLeftYPos + 1, cellSize - 2, cellSize - 2, this);
                    else if(boardPositionValue == -6)
                        graphics.drawImage(blackKing, topLeftXPos + 1, topLeftYPos + 1, cellSize - 2, cellSize - 2, this);
                    else if(boardPositionValue == 6)
                        graphics.drawImage(whiteKing, topLeftXPos + 1, topLeftYPos + 1, cellSize - 2, cellSize - 2, this);                            
                }
            }
        }
    }
}
