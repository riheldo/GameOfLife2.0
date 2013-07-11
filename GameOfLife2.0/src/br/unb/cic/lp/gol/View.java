package br.unb.cic.lp.gol;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class View {
	private JFrame jframe;
	private JButton nextgeneration, undo, halt;
	
	private ActionListener action_mca;
	private ActionListener action_next;
	private ActionListener action_undo;
	private ActionListener action_halt;
	
	private JButton cells_btn[][];
	
	private ConcretMediatorEngView mediator;
	
	View(ConcretMediatorEngView mediator){
		jframe = new JFrame();
		this.mediator = mediator;
		
		cells_btn = new JButton[mediator.getWidth()][mediator.getHeight()];
	}
	public void rodar(){
		jframe.setSize(mediator.getWidth()*58 + 50,mediator.getHeight()*33 + 200);
		
		
		jframe.setTitle("GameOfLife");
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (jframe.getWidth() / 2);
		int yPos = (dim.height / 2) - (jframe.getHeight() / 2);
		jframe.setLocation(xPos, yPos);
		
		JPanel panel = new JPanel();
		
		
		for(int i = 0; i < mediator.getWidth(); i++){
			for(int j = 0; j < mediator.getHeight(); j++){
				ModifiedJButton botao = new ModifiedJButton(i, j, mediator.getCellVI(i, j));
				botao.addActionListener(action_mca);
				cells_btn[i][j] = botao;
				panel.add(botao);
			}
		}
		
		int lado = mediator.getHeight() * 58;
		panel.setBounds((jframe.getWidth()-lado-12)/2, 80, lado, lado);
		jframe.add(panel);
		
		//NextGeneration
		nextgeneration = new JButton("Next Generation");
		nextgeneration.addActionListener(action_next);
		
		//Undo
		undo = new JButton("      Undo     ");
		undo.addActionListener(action_undo);
		
		//Halt
		halt = new JButton("      Halt     ");
		halt.addActionListener(action_halt);
		
		JPanel panelMenu = new JPanel();
		
		panelMenu.add(nextgeneration);
		panelMenu.add(undo);
		panelMenu.add(halt);
		
		jframe.add(panelMenu);
		
		
		jframe.setVisible(true);
	}
	
	public void update(int i, int j){
		cells_btn[i][j].setText(mediator.getCellVI(i, j));
	}
	
	public void updateAll(){
		for(int i = 0; i < mediator.getWidth(); i++){
			for(int j = 0; j < mediator.getHeight(); j++){
				cells_btn[i][j].setText(mediator.getCellVI(i, j));
			}
		}
	}
	
	public void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(jframe, errorMessage);
	}
	
	public void displayStatistics(int revivedCells, int killedCells){
		JOptionPane.showMessageDialog(jframe, "Revived Cells: " + revivedCells + ", KilledCells: " + killedCells + ".");
	}
	
	public void addActionForButtonMCA(ActionListener mca){
		action_mca = mca;
	}
	
	public void addActionForButtonNext(ActionListener next){
		action_next = next;
	}
	
	public void addActionForButtonUndo(ActionListener undo){
		action_undo = undo;
	}
	
	public void addActionForButtonHalt(ActionListener halt){
		action_halt = halt;
	}
}
