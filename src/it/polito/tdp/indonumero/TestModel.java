package it.polito.tdp.indonumero;

public class TestModel {
	public static void main(String[] args) {
		Model model = new Model();
		
		int min = 1;
		int max = model.getNMAX();
		model.newGame();
		while(model.isInGame()) {
			int t = (min+max)/2;
			System.out.format(" Tra %d e %d provo %d\n", min, max, t);
			int ris = model.tentativo(7);
			if(ris>0) {
				max = t-1;
			}
			else min = t+1;
			System.out.println(ris);
		}
	}
}
