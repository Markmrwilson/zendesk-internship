import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Base64;

//Connects to the Zendesk site and downloads the ticket information, 
//then converts it to a JSONObject.
public class Connection {

	public JSONObject downloadTickets(String URL){
		try {
			
			//Set up the connection to the URL given
			URL myURL = new URL(URL);
			URLConnection myURLConnection = myURL.openConnection();
			
			//Add basic authorization to the request (username and password)
			byte[] encodedAuthorizationBytes = Base64.getEncoder().encode
					("markmrwilson@gmail.com:h3fyh85n8odujnf357".getBytes());
			String encodedAuthorization = new String(encodedAuthorizationBytes);
			myURLConnection.setRequestProperty("Authorization", "Basic " 
					+ encodedAuthorization);
			
			//Connect
			myURLConnection.connect();
			
			//Set up a BufferedReader to collect all the characters returned
			BufferedReader in = new BufferedReader(new InputStreamReader(
					myURLConnection.getInputStream()));
			
			//Parse the contents of the reader into a JSONObject
			JSONParser parser = new JSONParser();
			try {
				JSONObject tickets = (JSONObject) parser.parse(in);
				in.close();
				return tickets;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//If something goes wrong, return null so the calling function knows
		return null;
	}
}
