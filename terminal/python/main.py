import os



board = [
    [ "♖", "♘", "♗", "♔", "♕", "♗", "♘", "♖" ],
    [ "♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙" ],
    [ "0", "0", "0", "0", "0", "0", "0", "0" ],
    [ "0", "0", "0", "0", "0", "0", "0", "0" ],
    [ "0", "0", "0", "0", "0", "0", "0", "0" ],
    [ "0", "0", "0", "0", "0", "0", "0", "0" ],
    [ "♟", "♟", "♟", "♟", "♟", "♟", "♟", "♟" ],
    [ "♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜" ]]


# def init_board():
#     # rook, knight, bishop, king, queen, bishop, knight, rook
#     # rook, knight, bishop, rook, king, bishop, knight, rook

def print_board():
    os.system('cls')
    isBlack = False
    for i in range(8):
        for j in range(8):
            isBlack = not isBlack
            if(board[i][j] == "0"):
                if not isBlack:
                    print("▉▉", end="")
                else:
                    print("  ", end="")

            else:
                print(board[i][j] + " ", end="")
        print()
        isBlack = not isBlack

print_board()