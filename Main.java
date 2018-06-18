import java.util.Scanner;

public class Main {

	public static void main (String[] args){

		//Get a list of all the tickets from the Zendesk site
		TicketHolder ticketHolder = new TicketHolder();
		ticketHolder.makeTickets();

		String instructions = 
				"\nCommands:\npage [number]: go to page specified (e.g. page 1)"
						+ "\ninspect [number]: inspect ticket specified (e.g. inspect 22)"
						+ "\nexit: exit\n";
		System.out.println("Welcome to the Zendesk ticket viewer."
				+ "\nType 'help' to see commands.\n");
		
		//Start by displaying the first page of tickets
		System.out.println(ticketHolder.printPage(1));

		//Set up user input
		Scanner input = new Scanner(System.in);

		//Parse user input and print desired display,
		//until user exits the program
		while(true){
			String[] command = input.nextLine().split(" ");
			switch(command[0]){
			case "page":
				if(command.length != 2){
					System.out.println("Please enter a valid command.");
				}
				else{
					System.out.println(ticketHolder.printPage
							(Integer.parseInt(command[1])));
				}
				break;
			case "inspect":
				if(command.length != 2){
					System.out.println("Please enter a valid command.");
				}
				else{
					System.out.println(ticketHolder.inspectTicket
							(Integer.parseInt(command[1])));
				}
				break;
			case "help":
				System.out.println(instructions);
				break;
			case "exit":
				System.exit(0);
			default:
				System.out.println("Please enter a valid command.");
				break;
			}
		}
	}
}
