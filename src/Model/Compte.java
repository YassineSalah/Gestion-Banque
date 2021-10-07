package Model;

import java.util.Calendar;

public class Compte {
	@Override
	public String toString() {
		return "Compte [solde=" + solde + ", dateCre=" + dateCre + ", typeCpt=" + typeCpt +",numCl="+numCl+ "]";
	}
	public static long numCpt=0;
	public double solde=0;
	public String dateCre;
	public String typeCpt;
	public long numCl;
	
	public long getNumCl() {
		return numCl;
	}

	public void setNumCl(long numCl) {
		this.numCl = numCl;
	}

	public static String DateSyst() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.DATE)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR);
	}
	
	public Compte() {
		super();
	}
	public Compte(String typeCpt) {
		super();
		this.typeCpt = typeCpt;
		this.dateCre=this.DateSyst();
	}
	public long getNumCpt() {
		return numCpt;
	}
	public void setNumCpt(long numCpt) {
		this.numCpt = numCpt;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getDateCre() {
		return dateCre;
	}
	public void setDateCre(String dateCre) {
		this.dateCre = dateCre;
	}
	public String getTypeCpt() {
		return typeCpt;
	}
	public void setTypeCpt(String typeCpt) {
		this.typeCpt = typeCpt;
	}

}
