package View;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;

import Controller.GestionCompteImp;
import Model.Client;
import Model.Compte;
import Model.Operation;

public class test implements ActionListener {
	JFrame f=new JFrame("Consulter Compte");
	JLabel labnumCpt=new JLabel("Num Compte");
	JTextField txtnumCpt=new JTextField(10);
	
	JLabel labnomCl=new JLabel("Nom Client");
	JTextField txtnomCl=new JTextField(10);
	JLabel labsolde=new JLabel("Solde");
	JTextField txtsolde=new JTextField(10);
	JButton bval=new JButton("Valider");
	
	JButton bquitt=new JButton("quitter");
	JMenuBar menuBar=new JMenuBar();
	JMenu menuOp=new JMenu("Opérations");
	JMenu menufich=new JMenu("fichier");
	JMenuItem itemAjtOp=new JMenuItem("Ajouter Opération");
	JMenuItem itemListOp=new JMenuItem("Liste des opérations");
	
	
	public test()   {
		
		f.setVisible(true);
		f.setResizable(true);
		f.setSize(400,400); 
		txtnomCl.setBorder(new LineBorder(Color.red, 2));
        txtnumCpt.setBorder(new LineBorder(Color.red, 2));
        txtsolde.setBorder(new LineBorder(Color.red, 2));
		f.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1.0;
        c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		f.add(f.add(labnumCpt), c);
		c.gridx = 1;
		c.gridy = 0;
		f.add(f.add(txtnumCpt), c);
		c.gridx = 2;
		c.gridy = 0;
		f.add(f.add(bval), c);
		c.gridx = 0;
		c.gridy = 1;
		f.add(f.add(labnomCl), c);
		c.gridx = 1;
		c.gridy = 1;
		f.add(f.add(txtnomCl), c);
		c.gridx = 0;
		c.gridy = 2;
		f.add(f.add(labsolde), c);
		c.gridx = 1;
		c.gridy = 2;
		f.add(f.add(txtsolde), c);
		c.gridx = 0;
		c.gridy = 3;
		f.add(f.add(bquitt), c);
		
		bval.addActionListener(this);
		bquitt.addActionListener(this);
		itemAjtOp.addActionListener(this);
		itemListOp.addActionListener(this);
		f.setJMenuBar(menuBar);
	
		menuBar.add(menufich);
		menuBar.add(menuOp);
		menuOp.add(itemAjtOp);
		menuOp.add(itemListOp);
		

		
	}
	
	
	public static void main(String[] args)  {
	
		new test();
	

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bquitt) {
			System.exit(0);
		}
		int numCpt1=0;
		if(txtnumCpt.getText()!="") {
		   numCpt1=Integer.parseInt(txtnumCpt.getText());}
		if(e.getSource()==bval) {
			
			GestionCompteImp ge=new GestionCompteImp();
			Compte cp=ge.getCompte(numCpt1);
			int numCl=(int) cp.getNumCl();
			Client cl=ge.getClient(numCl);
			txtnomCl.setText(cl.getNom());
			txtsolde.setText(cp.getSolde()+"");
		}

		if(e.getSource()==itemAjtOp) {
			
			new AjouterOperation(numCpt1);
			
		}
		if(e.getSource()==itemListOp) {
			
			new ListeDesOperations(numCpt1);
			
		}
		
	}

}
