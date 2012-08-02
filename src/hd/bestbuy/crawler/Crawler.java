package hd.bestbuy.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Crawler {

	private WebClient client = null;
	private HtmlPage page = null;
	private String startUrl;

	public Crawler(boolean enableJS) {
		client = new WebClient(BrowserVersion.FIREFOX_3_6);
		client.setJavaScriptEnabled(enableJS);
		client.setThrowExceptionOnScriptError(false);
		client.setThrowExceptionOnFailingStatusCode(false);

		if (enableJS) {
			client.setAjaxController(new NicelyResynchronizingAjaxController());
			client.waitForBackgroundJavaScript(1000);
		}

		client.setCssEnabled(false);
	}

	/**
	 * @return the startUrl
	 */
	public String getStartUrl() {
		return startUrl;
	}

	/**
	 * @param startUrl
	 *            the startUrl to set
	 */
	public void setStartUrl(String startUrl) {
		this.startUrl = startUrl;
	}

	public String getPropertyByXPath(HtmlPage page, String xPath) {
		List<?> divs = page.getByXPath(xPath);
		if (divs.size() == 1) {
			DomText property = (DomText) divs.get(0);
			return property.getTextContent();
		}
		return "NULL";
	}

	public void crawl(String url) {
		WebClient client = new WebClient();
		try {
			HtmlPage page = client.getPage(url);

			// GET INFORS
			// get name
			String name = getPropertyByXPath(page,
					"//*[@id=\"productsummary\"]/h1");

			String model = getPropertyByXPath(page,
					"//*[@id=\"productsummary\"]/div[1]/div/h2/text()");

			String sku = getPropertyByXPath(page,
					"//*[@id=\"productsummary\"]/div[1]/div/text()");

			String reviewPoint = getPropertyByXPath(page,
					"//*[@id=\"productsummary\"]/div[2]/div/span/strong/span[1]");

			String warrantyPart = getPropertyByXPath(page,
					"//*[@id=\"tabbed-specifications\"]/ul/li[1]/div[2]");

			System.out.println(name + "--" + model + "--" + sku + "--"
					+ reviewPoint + "-- " + warrantyPart);
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void crawlAllPages() {

	}

	public static void main(String[] args) {
		Crawler one = new Crawler(true);
		one.crawl("http://www.bestbuy.com/site/HP+-+15.6%26%2334%3B+Pavilion+Laptop+-+8GB+Memory+-+750GB+Hard+Drive+-+Natural+Silver/5608295.p?id=1218672046425&skuId=5608295");
	}
}
