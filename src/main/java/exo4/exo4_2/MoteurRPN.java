package exo4.exo4_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MoteurRPN {
	private Map<String, SpecificCom> operations;

	private Stack<Double> pile;

	private Undo undo;
	
	private MoteurRPN(final Stack<Double> pilee, final Undo undoo) {
		operations = new HashMap<String, SpecificCom>();
		pile = pilee;
		undo = undoo;
	}
	
	public void addOperande(final double op) {
		pile.push(op);
		undo.alertChange();
	}

	public void addCommand(final String namec,final SpecificCom command) {
		this.operations.put(namec, command);
	}

	public boolean executeCommand(final String namec) throws Exception {
		if (operations.containsKey(namec)) {
			if (pile.size() < 2) {
				System.err.println("nb opérandes ");
				return false;
			}
			double operande2 = pile.pop();
			double operande1 = pile.pop();
			try {
				pile.push(operations.get(namec)
				.apply(operande1, operande2));
				undo.alertChange();
				return true;
			} catch (Exception e) {
				pile.push(operande1);
				pile.push(operande2);
				return false;
			}
		} else {
			throw new Exception();
		}
	}

	public static MoteurRPN init(final Stack<Double> pile, final Undo u) {
		MoteurRPN m = new MoteurRPN(pile, u);
		m.addCommand("+", new Addition());
		m.addCommand("-", new Soustraction());
		m.addCommand("*", new Multiplication());
		m.addCommand("/", new Division());
		return m;
	}

}
