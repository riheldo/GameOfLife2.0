package br.unb.cic.lp.gol;

public class DeadCell implements ICellState {
	
	private Cell masterCell;
	
	public DeadCell(Cell cell){
		this.masterCell = cell;
	}
	
	@Override
	public String getSimbollCell() {
		return CellState.DEAD.getViewInfo();
	}

	@Override
	public void aliveCell() {
		masterCell.setCellState(masterCell.getAliveCell());
	}

	@Override
	public void killCell() {
		//dont do anything, the cell is already dead
	}

	@Override
	public void reviveCell() {
		masterCell.setCellState(masterCell.getRevivedCell());
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

}
