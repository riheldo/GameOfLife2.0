package br.unb.cic.lp.gol;

public enum MenuOptions {
	MAKE_CELL_ALIVE(1),
	NEXT_GENERATION(2),
	UNDO(3),
	HALT(4);
	
	private final int opcao;
	
	MenuOptions(int opc) {
		this.opcao = opc;
	}
	
	public int getMenuOption(){
		return opcao;
	}
}
