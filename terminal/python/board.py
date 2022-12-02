import os
from piece import Piece

class Board:
    def __init__(self, player_one_name = "Player 1", player_two_name = "Player 2") -> None:
        self.matrix =   [
                        [ "♖", "♘", "♗", "♔", "♕", "♗", "♘", "♖" ],
                        [ "♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙" ],
                        [ "0",  "0",  "0",  "0",  "0", "0",  "0",  "0" ],
                        [ "0",  "0",  "0",  "0",  "0", "0",  "0",  "0" ],
                        [ "0",  "0",  "0",  "0",  "0", "0",  "0",  "0" ],
                        [ "0",  "0",  "0",  "0",  "0", "0",  "0",  "0" ],
                        [ "♟", "♟", "♟", "♟", "♟", "♟", "♟", "♟" ],
                        [ "♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜" ]
                        ]

        self.isWon = False
        self.player_one_name = player_one_name
        self.player_two_name = player_two_name
        pieceList = [
            Piece(piece_name="rook",   piece="♖", isDead=False, isBlack=False, position=[0,0], moves=[], isLeft=True),
            Piece(piece_name="knight", piece="♘", isDead=False, isBlack=False, position=[0,1], moves=[], isLeft=True),
            Piece(piece_name="bishop", piece="", isDead=False, isBlack=False, position=[0,2], moves=[], isLeft=True),
            Piece(piece_name="king",   piece="", isDead=False, isBlack=False, position=[0,3], moves=[], isLeft=True),
            Piece(piece_name="queen",  piece="", isDead=False, isBlack=False, position=[0,4], moves=[], isLeft=True),
            Piece(piece_name="bishop", piece="", isDead=False, isBlack=False, position=[0,5], moves=[], isLeft=True),
            Piece(piece_name="knight", piece="", isDead=False, isBlack=False, position=[0,6], moves=[], isLeft=True),
            Piece(piece_name="rook",   piece="♖", isDead=False, isBlack=False, position=[0,7], moves=[], isLeft=True),
            
            Piece(piece_name="pawn", piece="♙", isDead=False, isBlack=False, position=[1,0], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♙", isDead=False, isBlack=False, position=[1,1], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♙", isDead=False, isBlack=False, position=[1,2], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♙", isDead=False, isBlack=False, position=[1,3], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♙", isDead=False, isBlack=False, position=[1,4], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♙", isDead=False, isBlack=False, position=[1,5], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♙", isDead=False, isBlack=False, position=[1,6], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♙", isDead=False, isBlack=False, position=[1,7], moves=[1,0], isLeft=True),
            

            Piece(piece_name="rook",   piece="", isDead=False, isBlack=True, position=[6,0], moves=[], isLeft=True),
            Piece(piece_name="knight", piece="", isDead=False, isBlack=True, position=[6,1], moves=[], isLeft=True),
            Piece(piece_name="bishop", piece="", isDead=False, isBlack=True, position=[6,2], moves=[], isLeft=True),
            Piece(piece_name="queen",  piece="", isDead=False, isBlack=True, position=[6,3], moves=[], isLeft=True),
            Piece(piece_name="king",   piece="", isDead=False, isBlack=True, position=[6,4], moves=[], isLeft=True),
            Piece(piece_name="bishop", piece="", isDead=False, isBlack=True, position=[6,5], moves=[], isLeft=True),
            Piece(piece_name="knight", piece="", isDead=False, isBlack=True, position=[6,6], moves=[], isLeft=True),
            Piece(piece_name="rook",   piece="", isDead=False, isBlack=True, position=[6,7], moves=[], isLeft=True),
            
            Piece(piece_name="pawn", piece="♟", isDead=False, isBlack=True, position=[7,0], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♟", isDead=False, isBlack=True, position=[7,1], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♟", isDead=False, isBlack=True, position=[7,2], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♟", isDead=False, isBlack=True, position=[7,3], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♟", isDead=False, isBlack=True, position=[7,4], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♟", isDead=False, isBlack=True, position=[7,5], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♟", isDead=False, isBlack=True, position=[7,6], moves=[1,0], isLeft=True),
            Piece(piece_name="pawn", piece="♟", isDead=False, isBlack=True, position=[7,7], moves=[1,0], isLeft=True)
        ]

    def print_board(self):
        os.system('cls')
        isBlack = False
        for i in range(8):
            for j in range(8):
                isBlack = not isBlack
                x = self.matrix[i][j]
                if x == "0":
                    if isBlack:
                        print("██", end="")
                    else:
                        print("  ", end="")
                else:
                    print(x + " ", end="")
            print()
            isBlack = not isBlack


b = Board()
b.print_board()