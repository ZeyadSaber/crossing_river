package controller;

public class Button {
	Command myCommand;
	public Button(Command newCommand) {
		myCommand = newCommand;
	}
	
	public void execute() {
		myCommand.execute();
	}
}
