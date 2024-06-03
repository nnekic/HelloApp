package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class HelloSalut {
	
	private static final String API_URL = "https://hellosalut.stefanbohacek.dev/?ip=";
	
		
		public static String Greeting(String ip) throws Exception {
			String urlString = API_URL + ip;
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder content = new StringBuilder();
			while((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			
			in.close();
			connection.disconnect();
			
			JSONObject jsonResponse = new JSONObject(content.toString());
	        return jsonResponse.getString("hello");
		}
		
	
	
}
