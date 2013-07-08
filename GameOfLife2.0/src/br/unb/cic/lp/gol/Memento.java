package br.unb.cic.lp.gol;

public class Memento {
	private Statistics statistica;
	private ICellState[][] cellsStates;
	
	public Memento(Statistics newStatistic, Cell[][] oldCells, int H, int W){
		statistica = newStatistic.clone();
		
		cellsStates = new ICellState[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				cellsStates[i][j] = oldCells[i][j].getActualCellState();
			}
		}
	}
	
	public Statistics getSavedStatistic(){
		return statistica;
	}
	
	public ICellState[][] getSavedCellsStates(){
			return cellsStates;
	}
	
}
