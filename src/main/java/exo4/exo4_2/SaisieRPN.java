package exo4.exo4_2;

import java.util.Scanner;
import java.util.Stack;

public class SaisieRPN {

	private MoteurRPN moteur;
	private Interpreteur interpreteur;
	private Stack<Double> pile;
	private Scanner scan;
	
	public SaisieRPN() {
		pile = new Stack<Double>();
		Undo u = new Undo(pile);
		u.alertChange();
		moteur = MoteurRPN.init(pile, u);
		interpreteur = Interpreteur.init(u);
	}

	public double calcul() throws Exception {
		scan = new Scanner(System.in);
		double d;
		boolean continuer = true;
		String line = "";
		System.out.print("************Calculatrice RPN****************************\n"+" Commandes autorisées : \n"
		+ "- une opération parmis {+,-,*,/}\n"+ "- \"undo\" pour revenir en arrière \n"+ "- \"quit\" pour quiter la calculatrice\n>");
		while (continuer) {
			try { 
				d = scan.nextDouble();
				moteur.addOperande(d);
			} catch (java.util.InputMismatchException e) {
				line = scan.nextLine();
				try { 
					moteur.executeCommand(line);
				} catch (Exception m) {
					try {
						
						interpreteur.executeCommand(line);
					} catch (Exception i) {
						System.err.println("Commande non reconnue");
						
					}
				}
			}
			if (line.equalsIgnoreCase("quiter")) {
				continuer = false;
			} else {
				System.out.print("\nExpression : " + pile + "\n");
				
			}
		}
		scan.close();
	
		if (pile.size() != 1) {
			System.err.println("Il faut pas dépasser un nombre");
			throw new Exception();
		}
		
		System.out.println("Resultat : " + pile);
		return pile.pop();
	}
}