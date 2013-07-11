package br.unb.cic.lp.gol;

import javax.swing.JButton;

public class ModifiedJButton extends JButton{
	private int i;
	private int j;
	
	public ModifiedJButton(int i, int j, String initial){
		super(initial);
		this.i = i;
		this.j = j;
	}
	
	public int getI(){
		return i;
	}
	public int getJ(){
		return j;
	}
}