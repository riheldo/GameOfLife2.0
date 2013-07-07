package br.unb.cic.lp.gol;

public class RevivedCell implements ICellState {
	
	private Cell masterCell;
	
	public RevivedCell(Cell cell){
		this.masterCell = cell;
	}
	
	@Override
	public String getSimbollCell() {
		return CellState.REVIVED.getViewInfo();
	}

	@Override
	public void aliveCell() {
		masterCell.setCellState(masterCell.getAliveCell());
	}

	@Override
	public void killCell() {
		masterCell.setCellState(masterCell.getDeadCell());
	}

	@Override
	public void reviveCell() {
		// dont do anything, the cell is already revived
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

}
