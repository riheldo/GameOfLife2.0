package br.unb.cic.lp.gol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

/**
 * Classe que atua como um controlador do 
 * padr‹o MVC, separando os componentes da 
 * camada de apresentacao e model. 
 * 
 * @author rbonifacio
 */
public class GameController {

	private GameEngine engine;
	private View board;
	private Statistics statistics;
	private boolean end;
	
	public void setConfig(GameEngine engine, View board, Statistics statistic){
		this.engine = engine;
		this.board = board;
		setStatistics(statistic);
		
		board.addActionForButtonMCA(new ActionForButtonMCA());
		board.addActionForButtonNext(new ActionForButtonNext());
		board.addActionForButtonUndo(new ActionForButtonUndo());
		board.addActionForButtonHalt(new ActionForButtonHalt());
	}
	
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	
	public void start() {
		end = false;
//		run();
		board.rodar();
	}
	
	
	//comeca
//	private void run(){
//		MenuOptions opcaoMenu;
//		while(!end){
//			board.update();
//			
//			opcaoMenu = board.printOptions();
//			switch(opcaoMenu) {
//				case MAKE_CELL_ALIVE : makeCellAlive(); break;
//				case NEXT_GENERATION : nextGeneration(); break;
//				case UNDO : undo(); break;
//				case HALT : halt(); break;
//			}
//		}
//	}
	
	public void halt() {
		//oops, nao muito legal fazer sysout na classe Controller e na classe statistic
		board.displayStatistics(statistics.getRevivedCells(), statistics.getKilledCells());
	}
	
	public void makeCellAlive(int i, int j) {		
		try {
			engine.getStrategyRG().makeCellAlive(i, j);
			board.update(i, j);
		}
		catch(InvalidParameterException e) {
			board.displayErrorMessage(e.getMessage());
		}
	}
	
	public void nextGeneration() {
		engine.nextGeneration();
		board.updateAll();
	}
	
	private void undo(){
		engine.undoGame();
		board.updateAll();
	}
	
	class ActionForButtonMCA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int i = ((ModifiedJButton) e.getSource()).getI();
			int j = ((ModifiedJButton) e.getSource()).getJ();
			makeCellAlive(i, j);
		}
		
	}
	
	class ActionForButtonNext implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			nextGeneration();
		}
		
	}
	
	class ActionForButtonUndo implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			undo();
		}
		
	}
	
	class ActionForButtonHalt implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			halt();
		}
		
	}
	
}
