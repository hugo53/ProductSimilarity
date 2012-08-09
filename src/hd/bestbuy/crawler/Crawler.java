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

public class Crawler {

	private WebClient client = null;
	private HtmlPage page = null;
	private String startUrl;
	private List<String> keywordList = new ArrayList<String>();
	private Map<String, String> attributeMap = new HashMap<String, String>();

	public Crawler() {
		initKeywordList(new File("data/keywords.txt"));

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

			// GET INFORS
			// get name
			String name = getPropertyByXPath(page,
					"//*[@id=\"productsummary\"]/h1/text()");

			// get model
			String model = getPropertyByXPath(page,
					"//*[@id=\"productsummary\"]/div[1]/div/h2/text()");

			// get price
			String price = getPropertyByXPath(page,
					"//*[@id=\"saleprice\"]/div[2]/span/text()");

			attributeMap.put("name", name);
			attributeMap.put("model", model);
			attributeMap.put("price", price);

			List<?> attributeDivs = page
					.getByXPath("//*[@id=\"tabbed-specifications\"]");

			HtmlDivision one = (HtmlDivision) attributeDivs.get(0);

			String[] attributeLines = one.asText().split("\n");
			// out.println(attributeLines.length);
			for (int i = 0; i < attributeLines.length; i++) {
				if (keywordList.contains(attributeLines[i])) {
					attributeMap.put(attributeLines[i], attributeLines[i + 1]);
				}
				i = i + 1;
			}

			writeCVS(attributeMap, outfile);

			/*
			 * // get screen
			 * 
			 * String screen = getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[12]/div[2]/text()");
			 * 
			 * // get ram String ram = getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[13]/div[2]/text()");
			 * 
			 * // get ram max String ram_max_support = getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[14]/div[2]/text()"); //
			 * get hdd-size String hdd_size = getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[16]/div[2]/text()"); //
			 * get hdd type String hdd_type = getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[16]/div[2]/text()");
			 * 
			 * // optical drive String optical_drive = getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[17]/div[2]/text()"); //
			 * weight String weight = getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[5]/div[2]/text()");
			 * 
			 * // graphics String graphics = getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[21]/div[2]/text()");
			 * 
			 * // os String os = getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[44]/div[2]/text()");
			 * 
			 * // cpu type String cpu_type = getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[8]/div[2]/text()");
			 * 
			 * // cpu-speed String cpu_speed = getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[9]/div[2]/text()");
			 * 
			 * // cpu-cache String cpu_cache = getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[12]/div[2]/text()");
			 * 
			 * // battery String battery = getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[10]/div[2]/text()");
			 * 
			 * // "//*[@id=\"tabbed-specifications\"]/ul/li[9]/div[2]/text()");
			 * // * // get warranty part String warrantyPart =
			 * getPropertyByXPath(page,
			 * "//*[@id=\"tabbed-specifications\"]/ul/li[1]/div[2]/text()");
			 */

			/*
			 * out.print(stringProcess(name) + "," + stringProcess(model) + ","
			 * + stringProcess(screen) + "," + stringProcess(ram) + "," +
			 * stringProcess(ram_max_support) + "," + stringProcess(hdd_size) +
			 * "," + stringProcess(hdd_type) + "," +
			 * stringProcess(optical_drive) + "," + stringProcess(weight) + ","
			 * + stringProcess(graphics) + "," + stringProcess(os) + "," +
			 * stringProcess(cpu_type) + "," + stringProcess(cpu_speed) + "," +
			 * stringProcess(cpu_cache) + "," + stringProcess(battery) + "," +
			 * stringProcess(warrantyPart) + "," + stringProcess(price));
			 */

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
			out.println(stringProcess(attrMap.get("name"))
					+ ","
					+ stringProcess(attrMap.get("model"))
					+ ","
					+ stringProcess(attrMap
							.get("Screen Size (Measured Diagonally)"))
					+ stringProcess(attrMap.get("System Memory (RAM)"))
					+ ","
					+ stringProcess(attrMap
							.get("System Memory (RAM) Expandable To")) + ","
					+ stringProcess(attrMap.get("Computer Hard Drive Size"))
					+ "," + stringProcess(attrMap.get("Hard Drive Type")) + ","
					+ stringProcess(attrMap.get("Optical Drive")) + ","
					+ stringProcess(attrMap.get("Product Weight")) + ","
					+ stringProcess(attrMap.get("Graphics")) + ","
					+ stringProcess(attrMap.get("Operating System")) + ","
					+ stringProcess(attrMap.get("Processor")) + ","
					+ stringProcess(attrMap.get("Processor Speed")) + ","
					+ stringProcess(attrMap.get("Cache Memory")) + ","
					+ stringProcess(attrMap.get("Battery Type")) + ","
					+ stringProcess(attrMap.get("Warranty Terms - Parts"))
					+ "," + stringProcess(attrMap.get("price")));
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
		Crawler one = new Crawler();
		// one.crawl("http://www.bestbuy.com/site/HP+-+15.6%26%2334%3B+Pavilion+Laptop+-+8GB+Memory+-+750GB+Hard+Drive+-+Natural+Silver/5608295.p?id=1218672046425&skuId=5608295");
		File outfile = new File("bestbuyoutfile");
		one.crawl(
				"http://www.bestbuy.com/site/Lenovo+-+ThinkPad+Edge+031946U+15.6%22+LED+Notebook+-+Intel+Core+i3+i3-380M+2.53+GHz+-+Black+Textured/5299059.p;jsessionid=2B8F7647BA13D0D9128E50984111BA59.bbolsp-app05-30?id=1218631451356&skuId=5299059&st=thinkpad&cp=1&lp=2",
				outfile);
		one.closeCrawler();
		System.out.println(one.inchesScreen("15.6''"));
	}
}
