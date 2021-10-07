package Model;

import java.util.*;

public class Client {
	public static long numCl=0;
	public String nom;
	
	public void setNumCl(long numCl) {
		this.numCl=numCl;
	}
	
	@Override
	public String toString() {
		return "Client [numCl="+numCl+",nom=" + nom + "]";
	}

	public long getNumCl() {
		return numCl;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Client(String nom) {
		super();
		this.nom = nom;
		this.numCl++;
	}

	public Client() {
		super();
	}

}
