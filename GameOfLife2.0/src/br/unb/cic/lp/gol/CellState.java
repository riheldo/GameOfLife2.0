package br.unb.cic.lp.gol;

public enum CellState {
	DEAD(0, "|     |"),
	ALIVE(1, "|  o  |"),
	REVIVED(2, "|  x  |");
	
	public final int indice;
	public final String viewInformation;
	
	private CellState(int ind, String vi){
		this.indice = ind;
		this.viewInformation = vi;
	}
	
	public int getIndice(){
		return indice;
	}
	
	public String getViewInfo(){
		return viewInformation;
	}
}
