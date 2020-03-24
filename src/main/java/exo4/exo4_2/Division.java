package exo4.exo4_2;

public class Division implements SpecificCom {
	public double apply(double operande1, double operande2) throws Exception {
		if(operande2 == 0) {
			System.err.println("On peut pas diviser par 0");
			throw new Exception();
		}
		return operande1 / operande2;
	}

	public void apply() {
		// TODO Auto-generated method stub
		
	}

}
