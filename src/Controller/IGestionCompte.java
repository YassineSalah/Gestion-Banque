package Controller;
import java.util.List;

import Model.*;

public interface IGestionCompte {
	public Compte getCompte(long numCp);
	public Client getClient(long numCl);
	public List<Operation> getAllOperation(long numCp);
	public void addOperation(Operation op);
	public void updateCompte(int num,double montant);
    public int getNbreOp(int numCpt);
}
