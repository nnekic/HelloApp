package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IpAppRetrieve {

	public static String getIp() throws Exception {
		
		String urlString  = "https://api.ipify.org/?format=text";
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		
		BufferedReader  in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuilder content = new StringBuilder();
		while((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		
		in.close();
		connection.disconnect();
		
		return content.toString();
	}
	
}
