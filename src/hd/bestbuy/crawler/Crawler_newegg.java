package hd.bestbuy.crawler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.type.PrimitiveType;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Crawler_newegg {
	
	public List<String> toCrawl = new ArrayList<String>(); 
	public List<String> crawled = new ArrayList<String>();
	public List<String> crawledItems = new ArrayList<String>();
	
	private WebClient client = null;
	private HtmlPage page = null;
	private String startUrl;

	public Crawler_newegg() {
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
/*
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

*/	
	private  boolean isSkipLink (String tmp){
		//if( tmp.startsWith("/")||(!tmp.contains("newegg.com"))||(!tmp.startsWith("http")))
			if(tmp.startsWith("http://www.newegg.com")
					&& (tmp.contains("name=Laptops-Notebooks")
					 ||tmp.contains("Item="))&&(!tmp.contains("ProductReview"))
					)
			  return false;
			return true;
		
	}
	
	public List<String> get_all_link(String url) throws FailingHttpStatusCodeException,
			MalformedURLException, IOException {
		List<String> tmp = new ArrayList<String>();
		try {
			page = client.getPage(url);
			//String originalHtml	= page.getWebResponse().getContentAsString();
			//String originalHtml = page.asText();
			//System.out.println(originalHtml);
			
			List<HtmlAnchor> anchors = page.getAnchors();
			for (Iterator iter = anchors.iterator();iter.hasNext();){
				HtmlAnchor anchor = (HtmlAnchor)iter.next();
				
				if(isSkipLink(anchor.getHrefAttribute())){
					continue;
				}
				//System.out.println(anchor.getHrefAttribute());
				//printWriter.println(anchor.getHrefAttribute());
				tmp.add(anchor.getHrefAttribute());
			}
			
			// GET INFORS
						
			// get name
			/*String name = getPropertyByXPath(page,
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
*/
			/*System.out.println(name + "--" + model + "--" + sku + "--"
					+ reviewPoint + "--" + warrantyPart);
			*/// + reviewPoint + "-- " + warrantyPart);
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
	
	return tmp;
	}

	public void crawl_web(List <String> seed) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		String tmp;
		toCrawl.addAll(seed);
		System.out.println(toCrawl.size());
		while(!toCrawl.isEmpty()){
			tmp = toCrawl.remove(toCrawl.size()-1);
			System.out.println(toCrawl.size());
			//System.out.println(tmp);
			if(!crawled.contains(tmp)){
				for(String newPage : get_all_link(tmp)){
					if(newPage.contains("Item=")){
						crawled.add(newPage);
						crawledItems.add(newPage);
						continue;
					}
					if(!toCrawl.contains(newPage))
						toCrawl.add(newPage);
				}
				crawled.add(tmp);
				System.out.println("ed" + crawled.size());
			}
			/*for(String newPage : get_all_link(tmp)){
					crawled.add(newPage);
			}
			crawled.add(tmp);
			System.out.println("ed" + crawled.size());*/
		}
	}

	public void printPages(){
		for (String p : crawledItems){
			System.out.println(p);
		}
	}
	
	public void closeCrawler() {
		client.closeAllWindows();
	}

	
	  public static void main(String[] args) throws
	  FailingHttpStatusCodeException, MalformedURLException, IOException {
	  List <String> seed = new ArrayList<String>();
	  seed.add("http://www.newegg.com/Store/SubCategory.aspx?SubCategory=32&name=Laptops-Notebooks");
	  Crawler_newegg one = new Crawler_newegg(); 
	  one.crawl_web(seed);
	  one.printPages();
	  one.closeCrawler(); 
	  
	  }
	 
}

