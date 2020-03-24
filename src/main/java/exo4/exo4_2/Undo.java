package exo4.exo4_2;
import java.util.Stack;
public class Undo implements GenericCom{
	private Stack<Stack<Double>> undo;
	private Stack<Double> pile;
	public void apply() {
		// TODO Auto-generated method stub
		
	}
	public void appl() {
		// TODO Auto-generated method stub
		while (!pile.isEmpty()) {
			pile.pop();
		}
		undo.pop();
		copyLastStack();
	}
	public Undo(Stack<Double> pile) {
		super();
		this.pile = pile;
	}
	public boolean canApply() {
		return !undo.isEmpty();
	}

	public void alertChange() {
		@SuppressWarnings("unchecked")
		Stack<Double> s = (Stack<Double>) pile.clone();
		undo.push(s);
	}

	private void copyLastStack() {
		for (double d : undo.lastElement()) {
			pile.push(d);
		}
	}

	

}
