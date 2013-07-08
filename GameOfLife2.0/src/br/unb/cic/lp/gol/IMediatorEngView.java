package br.unb.cic.lp.gol;

public interface IMediatorEngView {
	public void setHeight(int height);
	public int getHeight();
	public void setWidth(int width);
	public int getWidth();
	
	public boolean isCellAlive(int i, int j);
	public void setCell(Cell[][] cell);
	public Cell[][] getCells();
}
