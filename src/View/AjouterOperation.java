package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.GestionCompteImp;
import Model.Operation;


public class AjouterOperation implements ActionListener{
	JFrame f2=new JFrame("Ajouter Opération");
	JLabel labnumCpt=new JLabel("Num Compte");
	JTextField txtnumCpt=new JTextField();
	JRadioButton rdret = new JRadioButton("Retrait");
	JRadioButton rdvers = new JRadioButton("Versement");
	JLabel lmnt = new JLabel("Montant");
	JTextField txtmnt=new JTextField();
	JButton bEnrg=new JButton("Enregistrer");
	public AjouterOperation(int numCpt) {
		f2.setVisible(true);
		f2.setSize(400,400);
		f2.setLayout(new GridLayout (4,2,30,30));
		f2.add(labnumCpt);f2.add(txtnumCpt);
		f2.add(rdret);f2.add(rdvers);
		f2.add(lmnt);f2.add(txtmnt);
		f2.add(bEnrg);
		txtnumCpt.setText(numCpt+"");
		bEnrg.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		GestionCompteImp ge=new GestionCompteImp();
		Operation op=new Operation();
		System.out.println(Integer.parseInt(txtnumCpt.getText()));
		op.setMontant(Integer.parseInt(txtmnt.getText()));
		op.setNumCpt(Integer.parseInt(txtnumCpt.getText()));
		op.setNumOp(ge.getNbreOp(Integer.parseInt(txtnumCpt.getText()))+1);
		if(rdret.isSelected()==true) {
		op.setTypeOp("retrait");
		ge.updateCompte(Integer.parseInt(txtnumCpt.getText()),-(Integer.parseInt(txtmnt.getText())));
		}
		else {
			op.setTypeOp("versement");
			ge.updateCompte(Integer.parseInt(txtnumCpt.getText()),Integer.parseInt(txtmnt.getText()));
		}
		
		
		
		ge.addOperation(op);
		txtmnt.setText("");
		
	}

}
