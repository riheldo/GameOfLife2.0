package br.unb.cic.lp.gol;

public class Main {

	public static void main(String args[]) {
		GameController controller = new GameController();
		
		Statistics statistics = new Statistics();
		
		ConcretMediatorEngView mediator = new ConcretMediatorEngView();
		mediator.setHeight(10);
		mediator.setWidth(10);
		
		GameEngine engine = new GameEngine(mediator, statistics);	
		
		GameView board = new GameView(mediator);
		
		controller.setConfig(engine, board, statistics);
		
		controller.start();
	}
}
