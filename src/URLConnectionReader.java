import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
	public static void main(String[] args) throws Exception {
		PrintStream out = new PrintStream("out.txt");

		URL yahoo = new URL(
				"http://www.bestbuy.com/site/HP+-+15.6%26%2334%3B+Pavilion+Laptop+-+8GB+Memory+-+750GB+Hard+Drive+-+Natural+Silver/5608295.p?id=1218672046425&skuId=5608295");
		URLConnection yc = yahoo.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
			out.println(inputLine);
		}
		in.close();
		out.close();

	}
}