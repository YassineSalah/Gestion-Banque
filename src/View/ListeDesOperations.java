package View;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Controller.GestionCompteImp;
import Model.Operation;

public class ListeDesOperations {
	JFrame f3=new JFrame("Liste des Opérations");
	String nomColumn[]={"Num","Type de l'opération ","Montant","Date de l'opération"};
   
    JTable jt;  
       
	public ListeDesOperations(int numCp) {
		GestionCompteImp ge=new GestionCompteImp();
		List<Operation> list=ge.getAllOperation(numCp);
		int n=list.size();
		int j=0;
		Object[][] datas = new Object[n][nomColumn.length];
		for(Operation op:list) {
			
		datas[j][0]=op.numOp+"";
		datas[j][1]=""+op.typeOp;
		datas[j][2]=""+op.montant;
	    datas[j][3]=""+op.dateOp;  
		j++;	 
		}
		jt=new JTable(datas,nomColumn); 
		f3.setVisible(true);
		f3.setSize(400,400);
		jt.setBounds(30,40,200,300);          
	    JScrollPane sp=new JScrollPane(jt); 
		f3.add(sp); 
		
	}




	

}
