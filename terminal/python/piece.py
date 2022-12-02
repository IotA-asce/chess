class Piece:
    def __init__(self, piece, isBlack, piece_name, position, moves, isDead, isLeft) -> None:
        self.piece = piece
        self.isBlack = isBlack                  # is black -> color of piece
        self.piece_name = piece_name
        self.position = position
        self.moves = moves
        self.isDead = isDead

        # if chess piece is King
        self.isKing = True if piece_name.lower() == "king" else False
        self.isMovesAvailable = True

        # if piece is either rook, knight or bishop
        self.isLeft = isLeft
    


