import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


//Holds a list of tickets, and provides information about their contents
public class TicketHolder {

	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	private Connection connection = new Connection();

	//Sets the attributes of the ticket, then adds it to the list
	public void makeTicket(JSONObject json){
		Ticket ticket = new Ticket();
		ticket.setID((Long) json.get("id"));
		ticket.setCreatedAt((String) json.get("created_at"));
		ticket.setSubject((String) json.get("subject"));
		ticket.setDescription((String) json.get("description")); 
		ticket.setPriority((String) json.get("priority"));
		ticket.setStatus((String) json.get("status"));
		ticket.setShortStatus();
		tickets.add(ticket);
	}

	//Calls the Connection to download the tickets from the Zendesk site
	public void makeTickets(){
		//First page of the tickets, sorted by ID
		String nextURL = "https://markmrwilson.zendesk.com/api/v2/tickets.json?sort_by=id";
		//Keep getting new tickets until there are no more
		while (nextURL != "end"){
			JSONObject json = connection.downloadTickets(nextURL);
			if (json == null){
				System.out.println("Couldn't access tickets, sorry! Exiting program.");
				System.exit(0);
			}
			//After tickets are downloaded, add them to the ticketList 
			//before checking if there's another page
			JSONArray array = (JSONArray) json.get("tickets");
			Iterator<JSONObject> it = array.iterator();
			while (it.hasNext()){
				JSONObject ticket = it.next();
				makeTicket(ticket);
			}
			//If Zendesk tells us there's another page of tickets, go to that page
			//and download them
			if (json.get("next_page") != null){
				nextURL = json.get("next_page").toString();
			}
			else{
				nextURL = "end";
			}
		}
	}

	//Returns a page of 25 tickets, displayed as 
	//ID - status - subject
	public String printPage(int page){
		String pageString = new String();
		int pageLimit = page * 25;
		//Page must be above 0
		if (page < 1){
			pageString = "Please enter a valid page number.";
		}
		//If user has requested the last page (or a page after that),
		//stop displaying tickets after we run out.
		else if (pageLimit >= tickets.size()){
			pageString = ("Page " + page + ": " + 
					(pageLimit - 24) + " - " + tickets.size() + 
					" of " + tickets.size() + " tickets\n");
			for (int i = pageLimit - 25; i < tickets.size(); i++){
				pageString += ("\n" + tickets.get(i).getID() + ". " + 
						tickets.get(i).getShortStatus() + " " + 
						tickets.get(i).getSubject());
			}
		}
		//Otherwise if user has requested a page full of tickets, display them all
		else{
			pageString = ("Page " + page + ": " + 
					(pageLimit - 24) + " - " + pageLimit + 
					" of " + tickets.size() + " tickets\n");
			for (int i = pageLimit - 25; i < pageLimit; i++){
				pageString += ("\n" + tickets.get(i).getID() + ". " + 
						tickets.get(i).getShortStatus() + " " + 
						tickets.get(i).getSubject());
			}
		}
		return pageString;
	}

	//Shows the details of a ticket:
	//ID - subject - date received - priority - status - contents
	public String inspectTicket(int num){
		String ticketString = new String();
		if (num > tickets.size()){
			ticketString = "That ticket doesn't exist.";
		}
		else{
			Ticket ticket = tickets.get(num - 1);
			ticketString = (ticket.getID() + ".\n" + 
					"Subject: " + ticket.getSubject() +
					"\nReceived: " + ticket.getCreatedAt() +
					"\nPriority: " + ticket.getPriority() +
					"\nStatus: " + ticket.getStatus() + 
					"\n" + ticket.getDescription());
		}
		return ticketString;
	}
}

