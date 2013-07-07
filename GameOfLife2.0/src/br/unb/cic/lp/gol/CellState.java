package br.unb.cic.lp.gol;

public enum CellState {
	KILL(0),
	REVIVE(1);
	
	public final int indice;
	
	private CellState(int ind){
		this.indice = ind;
	}
	
	public int getIndice(){
		return indice;
	}
}
