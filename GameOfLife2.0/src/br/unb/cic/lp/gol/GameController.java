package br.unb.cic.lp.gol;

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
	private GameView board;
	private Statistics statistics;
	
	public void setConfig(GameEngine engine, GameView view, Statistics statistic){
		setEngine(engine);
		setBoard(view);
		setStatistics(statistic);
	}
	
	public GameEngine getEngine() {
		return engine;
	}
	
	public void setEngine(GameEngine engine) {
		this.engine = engine;
	}
	
	public GameView getBoard() {
		return board;
	}
	
	public void setBoard(GameView board) {
		this.board = board;
	}
	
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	
	public void start() {
		board.setEnd(false);
		run();
	}
	
	
	//comeca
	private void run(){
		MenuOptions opcaoMenu;
		while(!board.getEnd()){
			board.update();
			
			opcaoMenu = board.printOptions();
			switch(opcaoMenu) {
				case MAKE_CELL_ALIVE : makeCellAlive(); break;
				case NEXT_GENERATION : nextGeneration(); break;
				case HALT : halt(); break;
			}
		}
	}
	
	public void halt() {
		//oops, nao muito legal fazer sysout na classe Controller e na classe statistic
		board.printStatistics(statistics.getRevivedCells(), statistics.getKilledCells());
		board.setEnd(true);
	}
	
	public void makeCellAlive() {
		int i = board.putCellinRow();
		int j = board.putCellinColumn();
		
		try {
			engine.getStrategyRG().makeCellAlive(i, j);
		}
		catch(InvalidParameterException e) {
			board.showError(e.getMessage());
		}
	}
	
	public void nextGeneration() {
		engine.nextGeneration();
	}
	
}
