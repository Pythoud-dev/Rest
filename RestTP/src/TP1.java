import java.awt.PageAttributes.MediaType;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

import com.sun.javafx.collections.MappingChange.Map;

public class TP1 {

	public static void main(String args[]) {
		try {
			URL url = new URL("https://api.github.com/orgs/octokit/repos");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type","text/json");
			System.out.println(conn.getResponseCode());

			java.util.Map<String, List<String>> map = conn.getHeaderFields();
			for (Entry<String, List<String>> entry : map.entrySet()) {
			    System.out.println("Key : " + entry.getKey() + " ,Value : " + entry.getValue());
			}

			//get response body
//			InputStream output = conn.getInputStream();
	//		Scanner s = new Scanner(output).useDelimiter("\\A");
		//	String result = s.hasNext() ? s.next() : "";
			//System.out.println(result);
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
