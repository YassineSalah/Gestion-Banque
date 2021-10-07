package Model;

public class Operation {
	public long numOp;
	public String dateOp;
	public double montant;
	public String typeOp;
	public long numCpt;
	
	public long getNumOp() {
		return numOp;
	}
	public void setNumOp(long numOp) {
		this.numOp = numOp;
	}
	public String getDateOp() {
		return dateOp;
	}
	public Operation() {
		super();
		this.dateOp=Compte.DateSyst();
		
	}
	public Operation(double montant, String typeOp) {
		super();
		this.montant = montant;
		this.typeOp = typeOp;
		this.dateOp=Compte.DateSyst();
	}
	public long getNumCpt() {
		return numCpt;
	}
	public void setNumCpt(long numCpt) {
		this.numCpt = numCpt;
	}
	@Override
	public String toString() {
		return "Operation [numOp=" + numOp + ", dateOp=" + dateOp + ", montant=" + montant + ", typeOp=" + typeOp
				+ ", numCpt=" + numCpt + "]";
	}
	public void setDateOp(String dateOp) {
		this.dateOp = dateOp;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getTypeOp() {
		return typeOp;
	}
	public void setTypeOp(String typeOp) {
		this.typeOp = typeOp;
	}

}
