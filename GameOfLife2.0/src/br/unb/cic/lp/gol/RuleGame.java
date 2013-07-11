package br.unb.cic.lp.gol;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public abstract class RuleGame extends Collegue implements StrategyRule, Subject{
	private ArrayList<Observer> observers;
	private Caretaker caretaker;
	
	
	public RuleGame(ConcretMediatorEngView mediator) {
		super(mediator);
		
		caretaker = new Caretaker();
		
		Cell[][] cells = new Cell[getHeight()][getWidth()];
		mediator.setCell(cells);
		
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				cells[i][j] = new Cell();
			}
		}
		
		observers = new ArrayList<Observer>();
		
	}
	
	/* verifica se uma celula deve ser mantida viva */
	protected abstract boolean shouldKeepAlive(int i, int j);

	/* verifica se uma celula deve (re)nascer */
	protected abstract boolean shouldRevive(int i, int j);
	

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void delObserver(int indice) {
		observers.remove(indice);
	}

	@Override
	public void notifyObservers(CellState cs) {
		for(Observer ob: observers){
			ob.updateObserver(cs);
		}
	}
	
	
	/**
	 * Calcula uma nova geracao do ambiente. Essa implementacao utiliza o
	 * algoritmo do Conway, ou seja:
	 * 
	 * a) uma celula morta com exatamente tres celulas vizinhas vivas se torna
	 * uma celula viva.
	 * 
	 * b) uma celula viva com duas ou tres celulas vizinhas vivas permanece
	 * viva.
	 * 
	 * c) em todos os outros casos a celula morre ou continua morta.
	 */
	public final void nextGeneration() {
		saveState();
		
		List<Cell> mustRevive = new ArrayList<Cell>();
		List<Cell> mustKill = new ArrayList<Cell>();
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				if (shouldRevive(i, j)) {
					mustRevive.add(getMediator().getCells()[i][j]);
				} 
				else if ((!shouldKeepAlive(i, j)) && getMediator().getCells()[i][j].isAlive()) {
					mustKill.add(getMediator().getCells()[i][j]);
				}
			}
		}
		
		for (Cell cell : mustRevive) {
			cell.reviveCell();
			notifyObservers(CellState.REVIVED);
		}
		
		for (Cell cell : mustKill) {
			cell.killCell();
			notifyObservers(CellState.DEAD);
		}
	}
	
	private void saveState() {
		Originator orig = new Originator((Statistics) observers.get(0), getMediator().getCells(), getHeight(), getWidth());
		caretaker.addNewMemento(orig.getNewMemento());
	}
	
	public void undoGame(){
		Memento lastMemento = caretaker.getLastMemento(); 
		
		if(lastMemento != null){
			loadSavedState(lastMemento.getSavedCellsStates());
			((Statistics) observers.get(0)).setRevivedCells(lastMemento.getSavedStatistic().getRevivedCells());
			((Statistics) observers.get(0)).setKilledCells(lastMemento.getSavedStatistic().getKilledCells());
		}
	}

	private void loadSavedState(ICellState[][] savedCellsStates) {
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				getMediator().getCells()[i][j].setCellState(savedCellsStates[i][j]);
			}
		}
	}

	/**
	 * Torna a celula de posicao (i, j) viva
	 * 
	 * @param i posicao vertical da celula
	 * @param j posicao horizontal da celula
	 * 
	 * @throws InvalidParameterException caso a posicao (i, j) nao seja valida.
	 */
	public void makeCellAlive(int i, int j) throws InvalidParameterException {
		if(validPosition(i, j)) {
			getMediator().getCells()[i][j].aliveCell();
			notifyObservers(CellState.REVIVED);
		}
		else {
			new InvalidParameterException("Invalid position (" + i + ", " + j + ")" );
		}
	}
	

	/**
	 * Retorna o numero de celulas vivas no ambiente. 
	 * Esse metodo eh particularmente util para o calculo de 
	 * estatisticas e para melhorar a testabilidade.
	 * 
	 * @return  numero de celulas vivas.
	 */
	public int numberOfAliveCells() {
		int aliveCells = 0;
		for(int i = 0; i < getHeight(); i++) {
			for(int j = 0; j < getWidth(); j++) {
				if(isCellAlive(i,j)) {
					aliveCells++;
				}
			}
		}
		return aliveCells;
	}

	/*
	 * Computa o numero de celulas vizinhas vivas, dada uma posicao no ambiente
	 * de referencia identificada pelos argumentos (i,j).
	 */
	protected int numberOfNeighborhoodAliveCells(int i, int j) {
		int alive = 0;
		for (int a = i - 1; a <= i + 1; a++) {
			for (int b = j - 1; b <= j + 1; b++) {
				if (validPosition(a, b)  && (!(a==i && b == j)) && getMediator().getCells()[a][b].isAlive()) {
					alive++;
				}
			}
		}
		return alive;
	}
	
	public boolean validPosition(int a, int b){
		return validPositionH(a) && validPositionW(b);
	}
}
