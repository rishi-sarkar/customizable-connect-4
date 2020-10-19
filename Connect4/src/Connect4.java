import java.util.Scanner;
public class Connect4 {
	static int Row = 6, Col = 7;
	static String blank[][] = new String[Row][Col];
	static Scanner input = new Scanner(System.in);
	public static int valid() {
		int user = 0;
		for (;;) {
			System.out.println("Pick a column: ");
			user = input.nextInt();
			user--;
			if (user > (Col-1)) {
			} else if (full(user)) {
				break;
			}
		}
		return user;
	}
	public static int row(int col, String piece) {
		int row = 0;
		for (int i = (Row-1); i >= 0; i--) {
			if (blank[i][col].equals(" ")) {
				blank[i][col] = piece;
				row = i;
				break;
			}
		}
		return row;
	}
	public static boolean full(int col) {
		int counter = 0;
		for (int i = 0; i < Row; i++) {
			if (blank[i][col].equals(" ")) {
				counter++;
				break;
			}
		}
		if (counter > 0) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean sidewin(int row, int col, String piece) {
		if (col < 3) {
			if (blank[row][col + 1].equals(piece) && blank[row][col + 2].equals(piece) && blank[row][col + 3].equals(piece)) {
				return true;
			}
		} else if (col > (Col-4)) {
			if (blank[row][col - 1].equals(piece) && blank[row][col - 2].equals(piece) && blank[row][col - 3].equals(piece)) {
				return true;
			}
		} else {
			if (blank[row][col - 1].equals(piece) && blank[row][col - 2].equals(piece) && blank[row][col - 3].equals(piece)) {
				return true;
			} else if (blank[row][col + 1].equals(piece) && blank[row][col + 2].equals(piece) && blank[row][col + 3].equals(piece)) {
				return true;
			}
		}
		return false;
	}
	public static boolean bottomwin(int row, int col, String piece) {
		if (row <= (Row-4)) {
			if (blank[row+1][col].equals(piece) && blank[row+2][col].equals(piece) && blank[row+3][col].equals(piece)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public static boolean diagwin(int row, int col, String piece) {
		if (row >= 4 && col < 3) {
			if (blank[row-1][col+1].equals(piece) && blank[row-2][col+2].equals(piece) && blank[row-3][col+3].equals(piece)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (row >= 4 && col > (Col-4)) {
			if (blank[row-1][col-1].equals(piece) && blank[row-2][col-2].equals(piece) && blank[row-3][col-3].equals(piece)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (row <= (Row-4) && col < 3) {
			if (blank[row+1][col+1].equals(piece) && blank[row+2][col+2].equals(piece) && blank[row+3][col+3].equals(piece)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (row <= (Row-4) && col > (Col-4)) {
			if (blank[row+1][col-1].equals(piece) && blank[row+2][col-2].equals(piece) && blank[row+3][col-3].equals(piece)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (row <= (Row-4) && col > 3 && col < (Col-4)) {
			if (blank[row+1][col-1].equals(piece) && blank[row+2][col-2].equals(piece) && blank[row+3][col-3].equals(piece)) {
				return true;
			}
			else if (blank[row+1][col+1].equals(piece) && blank[row+2][col+2].equals(piece) && blank[row+3][col+3].equals(piece)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (row >= 4 && col > 3 && col < (Col-4)) {
			if (blank[row-1][col+1].equals(piece) && blank[row-2][col+2].equals(piece) && blank[row-3][col+3].equals(piece)) {
				return true;
			}
			else if (blank[row-1][col-1].equals(piece) && blank[row-2][col-2].equals(piece) && blank[row-3][col-3].equals(piece)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public static boolean sidemiddlewin (int row, int col, String piece) {
		if (col == 1) {
			if (blank[row][col + 1].equals(piece) && blank[row][col + 2].equals(piece) && blank[row][col - 1].equals(piece)) {
				return true;
			}
		} else if (col == (Col-2)) {
			if (blank[row][col + 1].equals(piece) && blank[row][col - 1].equals(piece) && blank[row][col - 2].equals(piece)) {
				return true;
			}
		} else if (col > 1 && col < (Col-2)){
			if (blank[row][col + 1].equals(piece) && blank[row][col + 2].equals(piece) && blank[row][col - 1].equals(piece)) {
				return true;
			} else if (blank[row][col + 1].equals(piece) && blank[row][col - 1].equals(piece) && blank[row][col - 2].equals(piece)) {
				return true;
			}
		}
		return false;
	}
	public static boolean diagmiddlewin (int row, int col, String piece) {
		int counter1 = 0, counter2 = 0;
		for (int i = 1; i <= Col; i++) {
			if (row+i <= (Row-1) && col+i <= (Col-1)) {			
				if (blank[row + i][col + i].equals(piece)) {
					counter1++;
				}
				else {
					break;
				}
			}
		}
		for (int i = 1; i <= Col; i++) {
			if (row-i >= 0 && col-i >= 0) {			
				if (blank[row - i][col - i].equals(piece)) {
					counter1++;
				}
				else {
					break;
				}
			}
		}
		
		for (int i = 1; i <= Col; i++) {
			if (row-i >= 0 && col+i <= (Col-1)) {			
				if (blank[row - i][col + i].equals(piece)) {
					counter2++;
				}
				else {
					break;
				}
			}
		}
		for (int i = 1; i <= Col; i++) {
			if (row+i <= (Row-1) && col-i >=0) {			
				if (blank[row + i][col - i].equals(piece)) {
					counter2++;
				}
				else {
					break;
				}
			}
		}
		if (counter1 >= 3) {
			return true;
		}
		else if (counter2 >=3) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean checkfull() {
		String temp [][] = blank;
		int counter = 0;
		for (int i = 0; i < Row; i++) {
			for (int j = 0; j < Col; j++) {
				if (temp[i][j].equals(" ")) {
					counter++;
				}
				if (counter > 0) {
					return false;
				}
			}
		}
		return true;
	}
	public static void print() {
		for (int row = 0; row < Row; row++) {
			System.out.print(" –");
			for (int i = 0; i < Col; i++) {
				System.out.print("––––");
			}
			System.out.println();
			for (int col = 0; col < Col; col++) {
				System.out.print(" | " + blank[row][col]);
			}
			System.out.println(" |");
		}
		System.out.print(" –");
		for (int i = 0; i < Col; i++) {
			System.out.print("––––");
		}
		System.out.println();
		System.out.print("   ");
		for (int col = 1; col < (Col+1); col++) {
			System.out.print(col + "   ");
		}
		System.out.println();
		System.out.println();
	}
	public static void clear() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}
	public static void scoreboard(String[] piece, int [] points) {
		System.out.println("SCOREBOARD|");
		System.out.println("–––––––––––");
		for (int i = 0; i < points.length; i++) {
			System.out.println("Player " + (i+1) + "(" + piece[i] + "): [" + + points[i] + "]");
		}
	}
	public static void main(String args[]) throws InterruptedException {
		
		int players, OCDcounter = 0, tempRow = 6, tempCol = 7, tempUseless = 0;
		String reply = "";
		
		System.out.print("How many players in game?: ");
		do {
			players = input.nextInt();
		} while (players <= 1);
		
		int first = 0;
		
		System.out.println("\n");
		
		int [] user = new int [players];
		int [] row = new int [players];
		int [] points = new int [players];
		String [] piece = new String [players];
//piece choice
		for (int i = 0; i < players; i++) {
			do {
				System.out.print("Pick your designated piece (" + (i+1) + "): ");
				piece[i] = input.next();
			} while (piece[i].length() != 1);
		}
		System.out.println("\n");
//size of board		
		System.out.println("\nWhat size do you want the board to be:");
		System.out.print("For default size, press 'y' or press any other key:");
		reply = input.next();
		if (!reply.equals("y")) {
			System.out.println("\n");
			do {
				System.out.print("Number of rows: ");
				tempRow = input.nextInt();
				System.out.print("Number of columns: ");
				tempCol = input.nextInt();
			} while (tempRow < 5 || tempCol < 4);
		}
//initialize board and its sizes
		blank = new String[tempRow][tempCol];
		Row = tempRow;
		Col = tempCol;
//blank board
		for (int r0w = 0; r0w < Row; r0w++) {
			for (int col = 0; col < Col; col++) {
				blank[r0w][col] = " ";
			}
		}
//clear lines
		clear();
//start of game
		int tempfirst = first;
		for (;;) {
			for (int i = tempfirst; i < players; i++) {
				if (OCDcounter == 0) {
					System.out.println("PLAYER " + (i+1) + "'S TURN (" + piece[i] + ")");
					print();
					OCDcounter++;
				}
				user[i] = valid();
				row[i] = row(user[i], piece[i]);
				clear();
				if (i == (players-1)) {
					System.out.println("PLAYER " + 1 + "'S TURN (" + piece[0] + ")");
				} else {
					System.out.println("PLAYER " + (i+2) + "'S TURN (" + piece[i+1] + ")");
				}
				print();
				if (sidewin(row[i], user[i], piece[i]) || bottomwin(row[i], user[i], piece[i]) || diagwin(row[i], user[i], piece[i])){
					System.out.println("PLAYER " + (i+1) + " WINS");
					Thread.sleep(4000);
					clear();
					points[i]++;
					OCDcounter = 4;
					break;
				} else if (sidemiddlewin(row[i], user[i], piece[i]) || diagmiddlewin(row[i], user[i], piece[i])){
					System.out.println("PLAYER " + (i+1) + " WINS");
					Thread.sleep(4000);
					clear();
					points[i]++;
					OCDcounter = 4;
					break;
				} else if (checkfull()) {
					System.out.println("THE GAME IS A DRAW");
					Thread.sleep(4000);
					clear();
					OCDcounter = 4;
					break;
				}
				if (i == (players-1)) {
					tempfirst = 0;
				}
			}
			if (OCDcounter == 4) {
				scoreboard(piece, points);
				if (tempUseless == 0) {
					System.out.print("Press 'y' to continue or any other key to leave: ");
					tempUseless++;
				} else {
					System.out.print("Do you want to play on?: ");
				}
				do {
					reply = input.next();
					if (reply.equals("y")) {
						if ((first+1) == players) {
							first = 0;
							tempfirst = first;
						} else {
							first++;
							tempfirst = first;
						}
						clear();
						for (int r0w = 0; r0w < Row; r0w++) {
							for (int col = 0; col < Col; col++) {
								blank[r0w][col] = " ";
							}
						}
						OCDcounter = 0;
					} else if (reply.equals("n")){
						break;
					}
				} while (!reply.equals("y") && !reply.equals("n"));
				if (reply.equals("n")) {
					break;
				}
			}
		}
		input.close();
	}
}