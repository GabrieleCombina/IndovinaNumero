package it.polito.tdp.indonumero;

import java.security.InvalidParameterException;

public class Model {
	
	private int NMAX = 100;
	private int TMAX = 7;
	
	private int segreto; //numero da individuare
	private int tentativi; //tentativi già fatti
	
	private boolean inGame = false;
	
	public Model() {
		this.inGame = false;
	}
	
	/**
	 * Avvia una partita, generando un nuovo numero segreto
	 */
	public void newGame() {
		this.segreto = (int)(Math.random()*NMAX)+1;
    	this.tentativi = 0;
    	this.inGame = true;
	}
	/**
	 * Fai un tentativo di indovinare il numero segreto
	 * @param t valore numerico del tentativo
	 * @return  0 se è indovinato, 1 se è troppo grande, -1 se è troppo piccolo
	 */
	public int tentativo(int t) {
		if(!inGame)
			throw new IllegalStateException("Partita non attiva");
		if(this.valoreValido(t)) 
			throw new InvalidParameterException("Tentativo fuori dal range");
		
		this.tentativi++;
		if(this.tentativi == this.TMAX) {
			this.inGame = false;
		}
		if(t==this.segreto) {
			this.inGame = false;
			return 0;
		}
		if(t<this.segreto)
			return -1;

		return 1;
	}
	
	/**
	 * 
	 * @param tentativo
	 * @return
	 */
	
	public boolean valoreValido(int tentativo) {
		return tentativo>=1 && tentativo<=this.NMAX;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getTentativi() {
		return tentativi;
	}

	public boolean isInGame() {
		return inGame;
	}

	public Object getSegreto() {
		// TODO Auto-generated method stub
		return segreto;
	}
	
	
}
