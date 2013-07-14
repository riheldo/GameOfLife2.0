package br.unb.cic.lp.gol;

public class Cell implements ICellState{
	private ICellState aliveCell;
	private ICellState deadCell;
//	private ICellState revivedCell;
	
	private ICellState actualCellState;
	
	public Cell(){
		aliveCell = new AliveCell(this);
		deadCell = new DeadCell(this);
//		revivedCell = new RevivedCell(this);
		
		actualCellState = new DeadCell(this);
	}
	
	public void setCellState(ICellState newCellState){
		actualCellState = newCellState;
	}

	@Override
	public String getSimbollCell() {
		return actualCellState.getSimbollCell();
	}

	@Override
	public void aliveCell() {
		actualCellState.aliveCell();
	}

	@Override
	public void killCell() {
		actualCellState.killCell();
	}

	@Override
	public void reviveCell() {
		actualCellState.reviveCell();
	}
	
	@Override
	public boolean isAlive(){
		return actualCellState.isAlive();
	}
	
	public ICellState getAliveCell(){
		return this.aliveCell;
	}
	public ICellState getDeadCell(){
		return this.deadCell;
	}
//	public ICellState getRevivedCell(){
//		return this.revivedCell;
//	}
	
	public Cell clone(){
		Cell newCell = new Cell();
		newCell.setCellState(actualCellState);
		return newCell;
	}
	
	public ICellState getActualCellState(){
		return actualCellState;
	}

}
