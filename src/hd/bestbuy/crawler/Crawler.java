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

	public Crawler() {
		client = new WebClient(BrowserVersion.FIREFOX_3_6);
		client.setJavaScriptEnabled(true);
		client.setThrowExceptionOnScriptError(false);
		client.setThrowExceptionOnFailingStatusCode(false);
		client.setAjaxController(new NicelyResynchronizingAjaxController());
		client.waitForBackgroundJavaScript(1000);
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
		if (divs.size() > 0) {
			if (divs.size() == 1) {
				DomText property = (DomText) divs.get(0);
				return property.getTextContent();
			} else {
				if (divs.size() == 2) {
					DomText property = (DomText) divs.get(1);
					return property.getTextContent();
				}
				if (divs.size() == 4) {
					DomText property = (DomText) divs.get(2);
					return property.getTextContent();
				}
			}
		}
		return "NULL";
	}

	public void crawl(String url) throws FailingHttpStatusCodeException,
			MalformedURLException, IOException {
		try {
			page = client.getPage(url);

			// GET INFORS
			// get name
			String name = getPropertyByXPath(page,
					"//*[@id=\"productsummary\"]/h1/text()");

			// get model
			String model = getPropertyByXPath(page,
					"//*[@id=\"productsummary\"]/div[1]/div/h2/text()");

			// get sku
			String sku = getPropertyByXPath(page,
					"//*[@id=\"productsummary\"]/div[1]/div/text()");
			// *[@id="productsummary"]/div[1]/div/span[1]/strong

			// get review point
			String reviewPoint = getPropertyByXPath(page,
					"//*[@id=\"productsummary\"]/div[2]/div/span/strong/span[1]/text()");

			// get warranty part
			String warrantyPart = getPropertyByXPath(page,
					"//*[@id=\"tabbed-specifications\"]/ul/li[1]/div[2]/text()");

			System.out.println(name + "--" + model + "--" + sku + "--"
					+ reviewPoint + "--" + warrantyPart);
			// + reviewPoint + "-- " + warrantyPart);
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

	public void closeCrawler() {
		client.closeAllWindows();
	}

	/*
	 * public static void main(String[] args) throws
	 * FailingHttpStatusCodeException, MalformedURLException, IOException {
	 * Crawler one = new Crawler(); one.crawl(
	 * "http://www.bestbuy.com/site/HP+-+15.6%26%2334%3B+Pavilion+Laptop+-+8GB+Memory+-+750GB+Hard+Drive+-+Natural+Silver/5608295.p?id=1218672046425&skuId=5608295"
	 * ); one.closeCrawler(); }
	 */
}
