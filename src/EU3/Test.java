package eu3;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chessboard schack = new Chessboard();
		
		//Chessboard.Chesspiece bonde = schack.new Pawn ('w', 'P');
		
		Chessboard.Chesspiece[] piece = new Chessboard.Chesspiece[] {
				schack.new Pawn ('w', 'P'),
				schack.new Rook ('w', 'R'),
				schack.new Bishop ('w', 'B'),
				schack.new Queen ('w', 'Q'),
				schack.new Knight ('w', 'N'),
				schack.new King ('w', 'K')
		};
		
		char row;
		byte column;
		Random random = new Random();
		
		for(int i = 0; i < piece.length; i++) {			
			column = (byte)(random.nextInt(7) + 1);
			row = (char)(random.nextInt(7) + (int)'a');
			
			try {
				piece[i].moveTo(row, column);

			} catch (NotValidFieldException e) {
			}
			
			System.out.println(schack.toString());
			piece[i].moveOut();
			
		}
		
	}

}
