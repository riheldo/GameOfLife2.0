package br.unb.cic.lp.gol;


/**
 * Representa um ambiente (environment) do jogo GameOfLife.
 * 
 * Essa implementacao eh nao inifinita, ou seja, nem todas as celulas possuem
 * oito celulas vizinhas. Por exemplo, a celula de coordenada (0,0) possui
 * apenas tres celulas vizinhas, (0,1), (1,0) e (1,1).
 * 
 * Um ambiente eh representado como um array bidimensional de celulas, com
 * altura (height) e comprimento (width).
 * 
 * @author rbonifacio
 */
public class GameEngine{
	private StrategyRule strategy;

	/**
	 * Construtor da classe Environment.
	 * 
	 * @param height
	 *            dimensao vertical do ambiente
	 * @param width
	 *            dimentsao horizontal do ambiente
	 */
	public GameEngine(ConcretMediatorEngView mediator, Statistics statistics) {
		this.strategy = new RuleGameOne(mediator);
		((RuleGame) strategy).addObserver(statistics);
	}
	
	public void nextGeneration(){
		this.strategy.nextGeneration();
	}
	
	public RuleGame getStrategyRG(){
		return ((RuleGame)strategy);
	}

}
