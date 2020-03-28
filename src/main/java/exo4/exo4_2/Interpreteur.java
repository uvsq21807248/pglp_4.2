package exo4.exo4_2;

import java.util.HashMap;
import java.util.Map;

public final class Interpreteur {
	
	private Map<String, GenericCom> commands;
	
	private Interpreteur() {
		commands = new HashMap<String, GenericCom>();
	}
	
	public void addCommand(final String name,final GenericCom command) {
		this.commands.put(name, command);
	}
	
	public void executeCommand(final String name) throws Exception {
		if (commands.containsKey(name)) {
			try {
				commands.get(name).apply();
			} catch (Exception e) {
				System.err.println("Commande non réussit");
			}
		} else {
			throw new Exception();
		}
	}
	
	public static Interpreteur init(final Undo u) {
		Interpreteur i = new Interpreteur();
		i.addCommand("undo", u);
		i.addCommand("quit", new Quit());
		return i;
	}
}