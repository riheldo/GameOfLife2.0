package br.unb.cic.lp.gol;

public interface ICellState {

	public void aliveCell();
	public void killCell();
	public void reviveCell();
	
	public String getSimbollCell();
	public boolean isAlive();
	
}
