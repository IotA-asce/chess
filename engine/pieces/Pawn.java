package engine.pieces;

import java.util.Collection;

import engine.Alliance;
import engine.board.Board;
import engine.board.Move;

public class Pawn extends Piece {
    private final static int[] CANDIDATE_MOVE_COORDINATES = { 8, 16, 7, 9 };

    public Pawn(final Alliance alliance, final int piecePosition) {
        super(PieceType.PAWN, alliance, piecePosition, true);
    }

    public Pawn(final Alliance alliance, final int piecePosition, final boolean isFirstMove) {
        super(PieceType.PAWN, alliance, piecePosition, isFirstMove);
    }

    @Override
    public int locationBonus() {
        return this.pieceAlliance.pawnBonus(this.piecePosition);
    }

    @Override
    public Collection<Move> calculateLegaMoves(final Board board) {
        return null;
    }

}
