package br.unb.cic.lp.gol;


public interface Subject {
	public void addObserver(Observer observer);
	public void delObserver(int indice);
	public void notifyObservers(CellState cs);
}
