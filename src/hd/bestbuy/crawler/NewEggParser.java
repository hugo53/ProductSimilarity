package hd.bestbuy.crawler;

// match with class='label' and class = 'data' in htmlstring by String originalHtml = page.getWebResponse().getContentAsString();
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class NewEggParser {

	private WebClient client = null;
	private HtmlPage page = null;
	private String startUrl;
	private List<String> keywordList = new ArrayList<String>();
	private Map<String, String> attributeMap = new HashMap<String, String>();

	public NewEggParser() {
		initKeywordList(new File("data/keyword-newegg.txt"));

		client = new WebClient(BrowserVersion.FIREFOX_3_6);
		client.setJavaScriptEnabled(true);
		client.setThrowExceptionOnScriptError(false);
		client.setThrowExceptionOnFailingStatusCode(false);
		client.setAjaxController(new NicelyResynchronizingAjaxController());
		client.waitForBackgroundJavaScript(1000);
		client.setCssEnabled(false);
	}

	private void initKeywordList(File infile) {
		try {
			Scanner in = new Scanner(infile);
			while (in.hasNext()) {
				keywordList.add(in.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	public void crawl(String url, File outfile)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException {
		try {
			page = client.getPage(url);
			// out.print(page.asText());

			String originalHtml = page.getWebResponse().getContentAsString();
			// out.print(originalHtml);

			// List<?> l = page.getElementsByName("data");

			// DomText property = (DomText) l.get(0);
			// System.out.println(property.getTextContent());

			// GET INFOR

			// get price
			String price = getPropertyByXPath(page,
					"//*[@id=\"singleFinalPrice\"]/text()");
			String warranty = getPropertyByXPath(page,
					"//*[@id=\"MfrWarranty\"]/ul/li[1]/text()");
			attributeMap.put("price", price);
			attributeMap.put("warranty", warranty);

			List<?> attributeDivs = page.getByXPath("//*[@id=\"Specs\"]");
			HtmlDivision one = (HtmlDivision) attributeDivs.get(0);
			String[] attributeLines = one.asXml().split("\n");

			for (int i = 0; i < attributeLines.length; i++) {
				if (keywordList.contains(stringProcess(attributeLines[i]))) {
					attributeMap.put(stringProcess(attributeLines[i]),
							stringProcess(attributeLines[i + 3]));
					i = i + 3;
				}

			}

			writeCVS(attributeMap, outfile);

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

	// write attributes map to outfile cvs, as form for input similarity module
	public void writeCVS(Map<String, String> attrMap, File outfile) {
		try {
			PrintWriter out = new PrintWriter(outfile);
			System.out.println("kaka: " + attrMap.get("Series"));
			out.println(attrMap.get("Series") + "," + attrMap.get("Model")
					+ "," + attrMap.get("Screen Size") + attrMap.get("Memory")
					+ "," + attrMap.get("Max Memory Supported") + ","
					+ attrMap.get("HDD") + "," + attrMap.get("HDD Interface")
					+ "," + attrMap.get("Optical Drive Type") + ","
					+ attrMap.get("Weight") + "," + attrMap.get("GPU/VPU")
					+ "," + attrMap.get("Operating System") + ","
					+ attrMap.get("CPU Type") + "," + attrMap.get("CPU Speed")
					+ "," + attrMap.get("CPU L2 Cache") + ","
					+ attrMap.get("Battery") + "," + attrMap.get("warranty")
					+ "," + attrMap.get("price"));
			out.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Remove blank or \n
	public String stringProcess(String str) {
		str = str.trim();
		return str.replaceAll("(\\r|\\n)", "");
	}

	// Get number for 15.6", just get 15, because
	public String inchesScreen(String str) {
		str = stringProcess(str);
		if (str.length() >= 5) {
			return str.substring(0, 4);
		}
		return null;
	}

	public static void main(String[] args)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException {
		NewEggParser one = new NewEggParser();
		// one.crawl("http://www.bestbuy.com/site/HP+-+15.6%26%2334%3B+Pavilion+Laptop+-+8GB+Memory+-+750GB+Hard+Drive+-+Natural+Silver/5608295.p?id=1218672046425&skuId=5608295");
		File outfile = new File("output-newegg");
		one.crawl(
				"http://www.newegg.com/Product/Product.aspx?Item=N82E16834215257",
				outfile);
		one.closeCrawler();
		System.out.println(one.inchesScreen("15.6''"));
	}

}
