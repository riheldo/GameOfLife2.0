package br.unb.cic.lp.gol;

public class Originator {
	private Memento memento;
	
	public Originator(Statistics stat, Cell[][] cells, int H, int W){
		memento = new Memento(stat, cells, H, W);
	}
	
	public Memento getNewMemento(){
		return memento;
	}
	
}
