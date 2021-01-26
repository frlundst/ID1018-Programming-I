package eu3;

public class Chessboard {

	// Subclass Field används i constructor för chessboard
	public static class Field {
		private char row;
		private byte column;
		private Chesspiece piece = null;
		private boolean marked = false;

		public Field(char row, byte column) {
			this.row = row;
			this.column = column;
		}

		public void put(Chesspiece piece) {
			this.piece = piece;
		}

		public Chesspiece take() {
			Chesspiece removed = this.piece;
			this.piece = null;
			return removed;
		}

		public void mark() {
			this.marked = true;
		}

		public void unmark() {
			this.marked = false;
		}

		public String toString() {
			String s = (marked) ? "xx" : "--";
			return (piece == null) ? s : piece.toString();
		}
	}

	public static final int NUMBER_OF_ROWS = 8;
	public static final int NUMBER_OF_COLUMNS = 8;
	public static final int FIRST_ROW = 'a';
	public static final int FIRST_COLUMN = 1;
	private Field[][] fields;

	// Schackbräde constructor
	public Chessboard() {
		fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		char row = 0;
		byte column = 0;
		for (int r = 0; r < NUMBER_OF_ROWS; r++) {
			row = (char) (FIRST_ROW + r);
			column = FIRST_COLUMN;
			for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				fields[r][c] = new Field(row, column);
				column++;
			}
		}
	}

	public String toString() { // Ska skriva ut själva schackbrädan
		StringBuilder sb = new StringBuilder();

		String columns = "  ";
		for (int i = 1; i <= NUMBER_OF_COLUMNS; i++) {
			columns += i + "  ";
		}
		sb.append(columns + "\n");

		String row = "";
		for (int i = 1; i <= NUMBER_OF_ROWS; i++) {
			row += fields[i - 1][0].row + " ";

			for (int j = 1; j <= NUMBER_OF_COLUMNS; j++) {
				row += fields[i - 1][j - 1].toString() + " ";
			}
			sb.append(row + "\n");
			row = "";
		}
		return sb.toString();
	}

	public boolean isValidField(char row, byte column) { //
		boolean valid = false;
		if (column >= 1 && column <= 8 && (int) (row) >= 97 && (int) (row) <= 104) {
			valid = true;
		}
		return valid;
	}

	// Pjäsklass
	public abstract class Chesspiece {
		private char color;// w -white, b -black
		private char name;// K -King, Q -Queen, R -Rook, B -Bishop, N -Knight,// P –Pawn
		protected char row = 0;
		protected byte column = -1;

		protected Chesspiece(char color, char name) {
			this.color = color;
			this.name = name;
		}

		public String toString() { // toString för enskild pjäs
			return "" + color + name;
		}

		public boolean isOnBoard() {
			return Chessboard.this.isValidField(row, column);
		}

		public void moveTo(char row, byte column) throws NotValidFieldException {
			if (!Chessboard.this.isValidField(row, column))
				throw new NotValidFieldException("bad field: " + row + column);
			this.row = row;
			this.column = column;
			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			this.markReachableFields();
			Chessboard.this.fields[r][c].put(this);
		}

		public void moveOut() {
			this.unmarkReachableFields();
			Chessboard.this.fields[row - FIRST_ROW][column - FIRST_COLUMN].take();
			row = 0;
			column = -1;
		}

		public abstract void markReachableFields();

		public abstract void unmarkReachableFields();
	}

	// Pjäser
	public class Pawn extends Chesspiece {
		public Pawn(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].mark();
			}
		}

		public void unmarkReachableFields() {
			byte col = (byte) (column + 1);
			if (Chessboard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
		}
	}

	public class Rook extends Chesspiece {
		public Rook(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			if (Chessboard.this.isValidField(row, column)) {
				for (int i = (int) column; i >= 1; i--) { // Vänster
					int r = row - FIRST_ROW;
					int c = column - i;
					Chessboard.this.fields[r][c].mark();
				}
				for (int i = (int) column; i <= 8; i++) { // Höger
					int r = row - FIRST_ROW;
					int c = i - 1;
					Chessboard.this.fields[r][c].mark();
				}
				for (int i = (int) row; i <= (int) 'h'; i++) { // Ner
					int r = i - 97;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
				for (int i = (int) row; i >= (int) 'a'; i--) { // Upp
					int r = i - 97;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
			}
		}

		public void unmarkReachableFields() {
			for (int i = (int) column; i >= 1; i--) { // Vänster
				int r = row - FIRST_ROW;
				int c = column - i;
				Chessboard.this.fields[r][c].unmark();
			}
			for (int i = (int) column; i <= 8; i++) { // Höger
				int r = row - FIRST_ROW;
				int c = i - 1;
				Chessboard.this.fields[r][c].unmark();
			}
			for (int i = (int) row; i <= (int) 'h'; i++) { // Ner
				int r = i - 97;
				int c = column - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
			for (int i = (int) row; i >= (int) 'a'; i--) { // Upp
				int r = i - 97;
				int c = column - FIRST_COLUMN;
				Chessboard.this.fields[r][c].unmark();
			}
		}
	}

	public class Knight extends Chesspiece {
		public Knight(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			int[] colX = { 1, 2, 2, 1, -1, -2, -1, -2 };
			int[] rowY = { 2, 1, -1, -2, -2, -1, 2, 1 };
			byte col = (byte) (column);
			int Row = (int) row;
			if (Chessboard.this.isValidField(row, col)) {
				for (int i = 0; i <= 7; i++) {
					int resultX = colX[i] + Row - 97;
					int resultY = rowY[i] + col - 1;
					if (resultX < 0 || resultY < 0 || resultX >= 8 || resultY >= 8)
						continue;
					Chessboard.this.fields[resultX][resultY].mark();
				}
			}
		}

		public void unmarkReachableFields() {
			int[] colX = { 1, 2, 2, 1, -1, -2, -1, -2 };
			int[] rowY = { 2, 1, -1, -2, -2, -1, 2, 1 };
			byte col = (byte) (column);
			int Row = (int) row;
			if (Chessboard.this.isValidField(row, col)) {
				for (int i = 0; i <= 7; i++) {
					int resultX = colX[i] + Row - 97;
					int resultY = rowY[i] + col - 1;
					if (resultX < 0 || resultY < 0 || resultX >= 8 || resultY >= 8)
						continue;
					Chessboard.this.fields[resultX][resultY].unmark();
				}
			}
		}
	}

	public class Bishop extends Chesspiece {
		public Bishop(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			if (Chessboard.this.isValidField(row, column)) {
				for (int j = (int) row, i = column; j <= (int) 'h'; j++, i++) {
					int r = j - 97;
					int c = i - FIRST_COLUMN;
					if (Chessboard.this.isValidField((char) j, (byte) i))
						Chessboard.this.fields[r][c].mark();
				}
				for (int j = (int) row, i = column; j >= (int) 'a'; j--, i++) {
					int r = j - 97;
					int c = i - FIRST_COLUMN;
					if (Chessboard.this.isValidField((char) j, (byte) i))
						Chessboard.this.fields[r][c].mark();
				}
				for (int j = (int) row, i = column; j <= (int) 'h'; j++, i--) {
					int r = j - 97;
					int c = i - FIRST_COLUMN;
					if (Chessboard.this.isValidField((char) j, (byte) i))
						Chessboard.this.fields[r][c].mark();
				}
				for (int j = (int) row, i = column; j >= (int) 'a'; j--, i--) {
					int r = j - 97;
					int c = i - FIRST_COLUMN;
					if (Chessboard.this.isValidField((char) j, (byte) i))
						Chessboard.this.fields[r][c].mark();
				}

			}
		}

		public void unmarkReachableFields() {
			for (int j = (int) row, i = column; j <= (int) 'h'; j++, i++) {
				int r = j - 97;
				int c = i - FIRST_COLUMN;
				if (Chessboard.this.isValidField((char) j, (byte) i))
					Chessboard.this.fields[r][c].unmark();
			}
			for (int j = (int) row, i = column; j >= (int) 'a'; j--, i++) {
				int r = j - 97;
				int c = i - FIRST_COLUMN;
				if (Chessboard.this.isValidField((char) j, (byte) i))
					Chessboard.this.fields[r][c].unmark();
			}
			for (int j = (int) row, i = column; j <= (int) 'h'; j++, i--) {
				int r = j - 97;
				int c = i - FIRST_COLUMN;
				if (Chessboard.this.isValidField((char) j, (byte) i))
					Chessboard.this.fields[r][c].unmark();
			}
			for (int j = (int) row, i = column; j >= (int) 'a'; j--, i--) {
				int r = j - 97;
				int c = i - FIRST_COLUMN;
				if (Chessboard.this.isValidField((char) j, (byte) i))
					Chessboard.this.fields[r][c].unmark();
			}
		}
	}

	public class Queen extends Chesspiece {
		public Queen(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			if (Chessboard.this.isValidField(row, column)) {
				for (int j = (int) row, i = column; j <= (int) 'h'; j++, i++) {
					int r = j - 97;
					int c = i - FIRST_COLUMN;
					if (Chessboard.this.isValidField((char) j, (byte) i))
						Chessboard.this.fields[r][c].mark();
				}
				for (int j = (int) row, i = column; j >= (int) 'a'; j--, i++) {
					int r = j - 97;
					int c = i - FIRST_COLUMN;
					if (Chessboard.this.isValidField((char) j, (byte) i))
						Chessboard.this.fields[r][c].mark();
				}
				for (int j = (int) row, i = column; j <= (int) 'h'; j++, i--) {
					int r = j - 97;
					int c = i - FIRST_COLUMN;
					if (Chessboard.this.isValidField((char) j, (byte) i))
						Chessboard.this.fields[r][c].mark();
				}
				for (int j = (int) row, i = column; j >= (int) 'a'; j--, i--) {
					int r = j - 97;
					int c = i - FIRST_COLUMN;
					if (Chessboard.this.isValidField((char) j, (byte) i))
						Chessboard.this.fields[r][c].mark();
				}

				for (int i = (int) column; i >= 1; i--) { // Vänster
					int r = row - FIRST_ROW;
					int c = column - i;
					Chessboard.this.fields[r][c].mark();
				}
				for (int i = (int) column; i <= 8; i++) { // Höger
					int r = row - FIRST_ROW;
					int c = i - 1;
					Chessboard.this.fields[r][c].mark();
				}
				for (int i = (int) row; i <= (int) 'h'; i++) { // Ner
					int r = i - 97;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}
				for (int i = (int) row; i >= (int) 'a'; i--) { // Upp
					int r = i - 97;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].mark();
				}

			}
		}

		public void unmarkReachableFields() {
			if (Chessboard.this.isValidField(row, column)) {
				for (int j = (int) row, i = column; j <= (int) 'h'; j++, i++) {
					int r = j - 97;
					int c = i - FIRST_COLUMN;
					if (Chessboard.this.isValidField((char) j, (byte) i))
						Chessboard.this.fields[r][c].unmark();
				}
				for (int j = (int) row, i = column; j >= (int) 'a'; j--, i++) {
					int r = j - 97;
					int c = i - FIRST_COLUMN;
					if (Chessboard.this.isValidField((char) j, (byte) i))
						Chessboard.this.fields[r][c].unmark();
				}
				for (int j = (int) row, i = column; j <= (int) 'h'; j++, i--) {
					int r = j - 97;
					int c = i - FIRST_COLUMN;
					if (Chessboard.this.isValidField((char) j, (byte) i))
						Chessboard.this.fields[r][c].unmark();
				}
				for (int j = (int) row, i = column; j >= (int) 'a'; j--, i--) {
					int r = j - 97;
					int c = i - FIRST_COLUMN;
					if (Chessboard.this.isValidField((char) j, (byte) i))
						Chessboard.this.fields[r][c].unmark();
				}

				for (int i = (int) column; i >= 1; i--) { // Vänster
					int r = row - FIRST_ROW;
					int c = column - i;
					Chessboard.this.fields[r][c].unmark();
				}
				for (int i = (int) column; i <= 8; i++) { // Höger
					int r = row - FIRST_ROW;
					int c = i - 1;
					Chessboard.this.fields[r][c].unmark();
				}
				for (int i = (int) row; i <= (int) 'h'; i++) { // Ner
					int r = i - 97;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}
				for (int i = (int) row; i >= (int) 'a'; i--) { // Upp
					int r = i - 97;
					int c = column - FIRST_COLUMN;
					Chessboard.this.fields[r][c].unmark();
				}

			}
		}
	}

	public class King extends Chesspiece {
		public King(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			int[] colX = {1,1,1,0,-1,-1,-1,0};
            int[] rowY = {1,0,-1,-1,-1,0,1,1};
            byte col = (byte)(column);
            int Row = row;
            if (Chessboard.this.isValidField(row, col)) {
                for(int i = 0; i <= 7; i++) {
                    int resultX = row + rowY[i] - 97;
                    int resultY = col + colX[i] - 1;
                    if (resultX < 0 || resultY < 0 || resultX >= 8 || resultY >= 8)
                        continue;
                    Chessboard.this.fields[resultX][resultY].mark();
                }
            }
		}

		public void unmarkReachableFields() {
			int[] colX = {1,1,1,0,-1,-1,-1,0};
            int[] rowY = {1,0,-1,-1,-1,0,1,1};
            byte col = (byte)(column);
            int Row = row;
            if (Chessboard.this.isValidField(row, col)) {
                for(int i = 0; i <= 7; i++) {
                    int resultX = row + rowY[i] - 97;
                    int resultY = col + colX[i] - 1;
                    if (resultX < 0 || resultY < 0 || resultX >= 8 || resultY >= 8)
                        continue;
                    Chessboard.this.fields[resultX][resultY].unmark();
                }
            }
		}
	}

}
