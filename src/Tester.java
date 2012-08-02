import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Tester {

	/**
	 * @param args
	 * @throws IOException
	 * @throws MalformedURLException
	 * @throws FailingHttpStatusCodeException
	 */
	public static void main(String[] args)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException {
		// TODO Auto-generated method stub
		WebClient client = new WebClient(BrowserVersion.FIREFOX_3_6);
		client.setJavaScriptEnabled(true);
		client.setThrowExceptionOnScriptError(false);
		client.setThrowExceptionOnFailingStatusCode(false);

		client.setAjaxController(new NicelyResynchronizingAjaxController());
		client.waitForBackgroundJavaScript(1000);

		client.setCssEnabled(false);

		HtmlPage page = client
				.getPage("http://www.bestbuy.com/site/HP+-+15.6%26%2334%3B+Pavilion+Laptop+-+6GB+Memory+-+640GB+Hard+Drive+-+Midnight+Black/5608338.p?id=1218672045876&skuId=5608338");
		System.out.println("page title is: " + page.getTitleText());

		// Get product's name
		// HtmlDivision div = page.getHtmlElementById("wrapper");
		List<?> divs = page.getByXPath("//*[@id=\"productsummary\"]/h1");
		System.out.println("size of divs is " + divs.size());

		HtmlHeading1 a = (HtmlHeading1) divs.get(0);
		System.out.println("it is " + a.getTextContent());

		client.closeAllWindows();
	}
}
