package demo2.x.com.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Demo2Tool {

	public static String doGet(String url, String cookieName, String cookieValue) {
		StringBuffer sb = new StringBuffer();
		HttpURLConnection httpURLConnection = null;

		try {
			URL urls = new URL(url + "?cookieName=" + cookieName + "&cookieValue=" + cookieValue);

			httpURLConnection = (HttpURLConnection) urls.openConnection();

			httpURLConnection.setRequestMethod("GET");

			httpURLConnection.connect();

			InputStream is = httpURLConnection.getInputStream();

			InputStreamReader isr = new InputStreamReader(is);

			BufferedReader br = new BufferedReader(isr);

			String tmp = null;
			while ((tmp = br.readLine()) != null) {
				sb.append(tmp);
			}
			br.close();
			isr.close();
			is.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (httpURLConnection != null) {
				httpURLConnection.disconnect();
			}
		}
		return sb.toString();
	}
}
