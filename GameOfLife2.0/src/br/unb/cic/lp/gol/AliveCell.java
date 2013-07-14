package br.unb.cic.lp.gol;

public class AliveCell implements ICellState {
	
	private Cell masterCell;
	
	public AliveCell(Cell cell){
		this.masterCell = cell;
	}

	@Override
	public String getSimbollCell() {
		return CellState.ALIVE.getViewInfo();
	}

	@Override
	public void aliveCell() {
		// dont do anything, the cell is alive
	}

	@Override
	public void killCell() {
		masterCell.setCellState(masterCell.getDeadCell());
	}

	@Override
	public void reviveCell() {
		masterCell.setCellState(masterCell.getAliveCell());
	}
	
	public boolean isAlive(){
		return true;
	}

}
