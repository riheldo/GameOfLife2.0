package br.unb.cic.lp.gol;

public class Caretaker {
	private Memento[] memento;
	private int lastMementoIndex;
	
	public Caretaker(){
		memento = new Memento[5];
		lastMementoIndex = -1;
		
		for(int i = 0; i < 5; i++)
			memento[i] = null;
	}
	
	public void addNewMemento(Memento newMemento){		
		if(lastMementoIndex == 4)
			lastMementoIndex = 0;
		else
			lastMementoIndex++;
		memento[lastMementoIndex] = newMemento;
	}
	
	public Memento getLastMemento(){
		if(memento[lastMementoIndex] == null)
			return null;
		
		int ilm = lastMementoIndex;
		
		Memento mementoaux = memento[ilm];
		memento[ilm] = null;
		
		if(lastMementoIndex == 0)
			lastMementoIndex = 4;
		else
			lastMementoIndex--;
		
		return mementoaux;
	}
}
