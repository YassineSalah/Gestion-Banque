package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.*;


public class GestionCompteImp implements IGestionCompte {
	
	Connection con;
	public GestionCompteImp(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/banque";
			con=DriverManager.getConnection(url,"root","");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public Compte getCompte(long numCp) {
		Compte cp=new Compte();
		String req="select * from comptes where numCpt=?";
		try {
			PreparedStatement ps=con.prepareStatement(req);
			ps.setInt(1,(int) numCp);
			
			ps.execute();
		    ResultSet res = ps.getResultSet();
		
		    while(res.next()) {
		    	cp.setNumCpt(res.getInt("numCpt"));
		    	cp.setDateCre(res.getString("dateCre"));
		    	cp.setSolde(res.getDouble("solde"));
		    	cp.setTypeCpt(res.getString("typeCpt"));
			    cp.setNumCl(res.getInt("numCl"));
		    }            
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	return cp;
	}

	@Override
	public Client getClient(long numCl) {
		Client cl=new Client();
		String req="select * from clients where numCl=?";
		try {
			PreparedStatement ps=con.prepareStatement(req);
			ps.setInt(1,(int) numCl);
			
			ps.execute();
		    ResultSet res = ps.getResultSet();
		
		    while(res.next()) {
		    	cl.setNom(res.getString("nom"));
		    	cl.setNumCl(res.getInt("numCl"));
		    	
		    }            
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return cl;
	}

	@Override
	public List<Operation> getAllOperation(long numCp) {
		  
		List<Operation> list=new ArrayList<Operation>();
		String req="select * from operations where numCpt=?";
		try {
			PreparedStatement ps=con.prepareStatement(req);
			ps.setInt(1, (int)numCp);
			
			ps.execute();
		    ResultSet res = ps.getResultSet();
			
		    Operation op;
		     
		            while(res.next()) {
		            	op=new Operation();
		    		op.setNumOp(res.getInt("numOp"));
		    		op.setTypeOp(res.getString("typeOp"));
		    		op.setMontant(res.getDouble("montant"));
		    		op.setDateOp(res.getString("dateOp"));
		    		op.setNumCpt(res.getInt("numCpt"));
		    		list.add(op);
		    	    
		    	}
		    
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void addOperation(Operation op) {
		String req="insert into operations(numOp,typeOp,montant,dateOp,numCpt) values(?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(req);
			int nb=this.getNbreOp((int) op.numCpt);
			ps.setInt(1,nb+1);
			ps.setString(2,op.typeOp);
			ps.setDouble(3,op.montant);
			
			ps.setInt(5,(int) op.numCpt);
			ps.setString(4,Compte.DateSyst());
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	@Override
	public void updateCompte(int numCpt, double montant) {
		Compte cmpt=getCompte(numCpt);
		double solde=cmpt.getSolde();
		if(montant<0) {
		cmpt.setSolde(solde+montant);
		}
		else {
			cmpt.setSolde(solde+montant);
		}
		String req="DELETE from comptes where numCpt=?";
		try {
			PreparedStatement ps=con.prepareStatement(req);
			ps.setInt(1, numCpt);
			
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String req1="insert into comptes(numCpt,dateCre,solde,typeCpt,numCl) values(?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(req1);
			ps.setInt(1, (int) cmpt.getNumCpt());
			ps.setString(2,cmpt.getDateCre());
			ps.setDouble(3,cmpt.getSolde());
			ps.setString(4,cmpt.getTypeCpt());
			ps.setInt(5,(int) cmpt.getNumCl());
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}


	@Override
	public int getNbreOp(int numCpt) {
		List<Operation> liste=this.getAllOperation(numCpt);
		return liste.size();
	}

}
