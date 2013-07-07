package br.unb.cic.lp.gol;

import java.util.Scanner;

/**
 * Atua como um componente de apresentacao (view), exibindo o estado atual do
 * game com uma implementacao baseada em caracteres ASCII.
 * 
 * @author rbonifacio
 */
public class GameView extends Collegue {
	private static final String LINE = "+-----+";
	private static final String DEAD_CELL = "|     |";
	private static final String ALIVE_CELL = "|  o  |";
	
	private static final int INVALID_OPTION = 0;
	private static final int MAKE_CELL_ALIVE = 1;
	private static final int NEXT_GENERATION = 2;
	private static final int HALT = 3; 
	
	private boolean end;

	/**
	 * Construtor da classe GameBoard
	 */
	public GameView(ConcretMediatorEngView mediator) {
		super(mediator);
	}

	/**
	 * Atualiza o componente view (representado pela classe GameBoard),
	 * possivelmente como uma resposta a uma atualiza�‹o do jogo.
	 */
	public void update() {
		printFirstRow();
		printLine();
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				System.out.print(isCellAlive(i, j) ? ALIVE_CELL : DEAD_CELL);
			}
			System.out.println("   " + i);
			printLine();
		}
	}

	public MenuOptions printOptions() {
		Scanner s = new Scanner(System.in);
		
		int option;
		System.out.println("\n \n");
		
		do {
			System.out.println("Select one of the options: \n \n"); 
			System.out.println("[1] Make a cell alive");
			System.out.println("[2] Next generation");
			System.out.println("[3] Halt");
		
			System.out.print("\n \n Option: ");
			
			option = parseOption(s.nextLine());
		}while(option == 0);
		
		switch(option) {
			case MAKE_CELL_ALIVE : return MenuOptions.MAKE_CELL_ALIVE;
			case NEXT_GENERATION : return MenuOptions.NEXT_GENERATION;
			case HALT : return MenuOptions.HALT;
		}
		return null;
	}
	
	
	/*
	 * tirar metodo e distribuir em outros dois, putCellinRow() e putCellinCollumn()
	 * */
//	private void makeCellAlive() {
//		int i, j = 0;
//		Scanner s = new Scanner(System.in);
//		
//		do {
//			System.out.print("\n Inform the row number (0 - " + engine.getHeight() + "): " );
//			
//			i = s.nextInt();
//			
//			System.out.print("\n Inform the column number (0 - " + engine.getWidth() + "): " );
//			
//			j = s.nextInt();
//		}while(!validPosition(i,j));
//		
//		controller.makeCellAlive(i, j);
//	}
	
	public int putCellinRow(){
		int i = 0;
		Scanner s = new Scanner(System.in);
		
		do{
			System.out.println("\n Inform the row number (0 - " + getHeight() + "): ");
			i = s.nextInt();
		}while(!validPositionH(i));
		
		return i;
	}
	
	public int putCellinColumn(){
		int j = 0;
		Scanner s = new Scanner(System.in);
		
		do{
			System.out.print("\n Inform the column number (0 - " + getWidth() + "): " );
			j = s.nextInt();
			
		}while(!validPositionW(j));
		
		return j;
	}
	
//	private boolean validPosition(int i, int j) {
//		System.out.println(i);
//		return i >= 0 && i < getHeight() && j >= 0 && j < getWidth();
//	}

	private int parseOption(String option) {
		if(option.equals("1")) {
			return MAKE_CELL_ALIVE;
		}
		else if (option.equals("2")) {
			return NEXT_GENERATION;
		}
		else if (option.equals("3")) {
			return HALT;
		}
		else return INVALID_OPTION;
	}

	/* Imprime uma linha usada como separador das linhas do tabuleiro */
	private void printLine() {
		for (int j = 0; j < getWidth(); j++) {
			System.out.print(LINE);
		}
		System.out.print("\n");
	}

	/*
	 * Imprime os identificadores das colunas na primeira linha do tabuleiro
	 */
	private void printFirstRow() {
		System.out.println("\n \n");
		for (int j = 0; j < getWidth(); j++) {
			System.out.print("   " + j + "   ");
		}
		System.out.print("\n");
	}
	
	public void printStatistics(int revivedCells, int killedCells) {
		System.out.println("\n \n");
		System.out.println("=================================");
		System.out.println("           Statistics            ");
		System.out.println("=================================");
		System.out.println("Revived cells: " + revivedCells);
		System.out.println("Killed cells: " + killedCells);
		System.out.println("=================================");
	}
	
	public void setEnd(boolean end){
		this.end = end;
	}
	
	public boolean getEnd(){
		return this.end;
	}

	public void showError(String message) {
		System.out.println(message);		
	}
}
