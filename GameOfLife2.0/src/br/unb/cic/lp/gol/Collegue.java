package br.unb.cic.lp.gol;

public abstract class Collegue {
	private ConcretMediatorEngView mediator;
	
	public Collegue(ConcretMediatorEngView mediator) {
		this.mediator = mediator;
	}
	
	protected ConcretMediatorEngView getMediator(){
		return mediator;
	}
	
	protected void setHeight(int height){
		mediator.setHeight(height);
	}
	
	protected void setWidth(int width){
		mediator.setWidth(width);
	}
	
	protected int getHeight(){
		return mediator.getHeight();
	}
	
	protected int getWidth(){
		return mediator.getWidth();
	}
	
	protected boolean isCellAlive(int i, int j){
		return mediator.isCellAlive(i, j);
	}
	
	protected String cellViewInfo(int i, int j){
		return mediator.getCellVI(i, j);
	}
	
	protected boolean validPositionH(int a) {
		return a >= 0 && a < getHeight();
	}
	
	protected boolean validPositionW(int b) {
		return b >= 0 && b < getWidth();
	}
}
