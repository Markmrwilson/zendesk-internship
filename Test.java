import static org.junit.Assert.*;

public class Test {

	String ticket1 = "1.\nSubject: Sample ticket: Meet the ticket"
			+ "\nReceived: 2018-06-05T07:56:36Z\nPriority: normal"
			+ "\nStatus: open\nHi Mark,\n\nEmails, chats, voicemails, "
			+ "and tweets are captured in Zendesk Support as tickets. "
			+ "Start typing above to respond and click Submit to send. "
			+ "To test how an email becomes a ticket, send a message to "
			+ "support@markmrwilson.zendesk.com.\n\nCurious about what "
			+ "your customers will see when you reply? Check out this "
			+ "video:\nhttps://demos.zendesk.com/hc/en-us/articles/202341799\n";

	String ticket2 = "2.\nSubject: velit eiusmod reprehenderit officia cupidatat"
			+ "\nReceived: 2018-06-09T10:05:51Z"
			+ "\nPriority: null"
			+ "\nStatus: solved"
			+ "\nAute ex sunt culpa ex ea esse sint cupidatat aliqua ex consequat "
			+ "sit reprehenderit. Velit labore proident quis culpa ad duis adipisicing"
			+ " laboris voluptate velit incididunt minim consequat nulla. Laboris "
			+ "adipisicing reprehenderit minim tempor officia ullamco occaecat ut "
			+ "laborum.\n\nAliquip velit adipisicing exercitation irure aliqua qui. "
			+ "Commodo eu laborum cillum nostrud eu. Mollit duis qui non ea deserunt "
			+ "est est et officia ut excepteur Lorem pariatur deserunt.";
	
	String page1 = "Page 1: 1 - 25 of 101 tickets\n\n"
			+ "1. (O) Sample ticket: Meet the ticket\n"
			+ "2. (S) velit eiusmod reprehenderit officia cupidatat\n"
			+ "3. (O) excepteur laborum ex occaecat Lorem\n"
			+ "4. (O) ad sunt qui aute ullamco\n"
			+ "5. (P) aliquip mollit quis laborum incididunt\n"
			+ "6. (O) nisi aliquip ipsum nostrud amet\n"
			+ "7. (O) cillum quis nostrud labore amet\n"
			+ "8. (O) proident est nisi non irure\n"
			+ "9. (O) veniam ea eu minim aute\n"
			+ "10. (O) magna reprehenderit nisi est cillum\n"
			+ "11. (O) quis veniam ad sunt non\n"
			+ "12. (O) tempor aliquip sint dolore incididunt\n"
			+ "13. (O) labore pariatur ut laboris laboris\n"
			+ "14. (O) officia mollit aliqua eu nostrud\n"
			+ "15. (O) do incididunt incididunt quis anim\n"
			+ "16. (O) tempor magna anim ea id\n"
			+ "17. (O) exercitation sit incididunt magna laboris\n"
			+ "18. (O) laborum ea ut in cupidatat\n"
			+ "19. (O) est fugiat labore pariatur esse\n"
			+ "20. (O) commodo sint laboris est et\n"
			+ "21. (O) laboris sint Lorem ex Lorem\n"
			+ "22. (O) esse adipisicing consectetur sunt tempor\n"
			+ "23. (O) sunt enim pariatur id id\n"
			+ "24. (O) et ad ut enim labore\n"
			+ "25. (O) voluptate dolor deserunt ea deserunt";

	@org.junit.Test
	public void testTicket1() {
		TicketHolder ticketHolder = new TicketHolder();
		ticketHolder.makeTickets();
		assertEquals(ticket1, ticketHolder.inspectTicket(1));
	}
	
	@org.junit.Test
	public void testTicket2() {
		TicketHolder ticketHolder = new TicketHolder();
		ticketHolder.makeTickets();
		assertEquals(ticket2, ticketHolder.inspectTicket(2));
	}
	
	@org.junit.Test
	public void testPage1(){
		TicketHolder ticketHolder = new TicketHolder();
		ticketHolder.makeTickets();
		assertEquals(page1, ticketHolder.printPage(1));
	}

}
