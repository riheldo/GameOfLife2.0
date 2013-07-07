package br.unb.cic.lp.gol;

import java.security.InvalidParameterException;

public class ConcretMediatorEngView implements IMediatorEngView{
	private int height = 0;
	private int width = 0;
	
	private Cell[][] cells;
	
	public void setCell(Cell[][] cell){
		this.cells = cell;
	}
	
	@Override
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public int getHeight() {
		return this.height;
	}
	
	@Override
	public void setWidth(int width) {
		this.width = width;
	}
	@Override
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Verifica se uma celula na posicao (i, j) estah viva.
	 * 
	 * @param i Posicao vertical da celula
	 * @param j Posicao horizontal da celula
	 * @return Verdadeiro caso a celula de posicao (i,j) esteja viva.
	 * 
	 * @throws InvalidParameterException caso a posicao (i,j) nao seja valida. 
	 */
	public boolean isCellAlive(int i, int j) throws InvalidParameterException {
		return cells[i][j].isAlive();
	}

}
