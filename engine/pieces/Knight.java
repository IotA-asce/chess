package engine.pieces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import engine.Alliance;
import engine.board.Board;
import engine.board.Move;

public class Knight extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATES = { -17, -15, -10, -6, 6, 10, 15, 17 };

    Knight(PieceType type, final Alliance alliance, final int piecePosition, boolean isFirstMove) {
        super(type, alliance, piecePosition, isFirstMove);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int locationBonus() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Piece movPiece(Move move) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Move> calculateLegalMoves(Board board) {
        // TODO Auto-generated method stub

        int candidateDestinationCoordinate;
        final List<Move> legalMoves = new ArrayList<>();

        for (final int currentCandidate : CANDIDATE_MOVE_COORDINATES) {
            candidateDestinationCoordinate = this.piecePosition + currentCandidate;
            if (true /* isValidTileCoordinate */) {
                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                if (!candidateDestinationTile.isTileOccupied()) {
                    legalMoves.add(new Move());
                }
            }
        }
        return Collections.unmodifiableList(legalMoves);
    }

}
