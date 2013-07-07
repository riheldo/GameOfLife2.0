package br.unb.cic.lp.gol;

public class RuleGameTwo extends RuleGame{

	public RuleGameTwo(ConcretMediatorEngView mediator) {
		super(mediator);
	}
	
	/* verifica se uma celula deve ser mantida viva */
	protected boolean shouldKeepAlive(int i, int j) {
		return (cells[i][j].isAlive())
				&& (numberOfNeighborhoodAliveCells(i, j) == 2 || numberOfNeighborhoodAliveCells(i, j) == 3);
	}

	/* verifica se uma celula deve (re)nascer */
	protected boolean shouldRevive(int i, int j) {
		return (!cells[i][j].isAlive())
				&& (numberOfNeighborhoodAliveCells(i, j) == 6);
	}

}
