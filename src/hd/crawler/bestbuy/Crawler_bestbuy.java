package hd.crawler.bestbuy;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import javax.lang.model.type.PrimitiveType;
	public class Crawler_bestbuy {

		public List<String> toCrawl = new ArrayList<String>(); 
		public List<String> crawled = new ArrayList<String>();
		public List<String> crawledItems = new ArrayList<String>();
		public List<String> keywords  = new ArrayList<String>();
		
		private WebClient client = null;
		private HtmlPage page = null;
		private String startUrl;

		public Crawler_bestbuy() {
			client = new WebClient(BrowserVersion.FIREFOX_3_6);
			client.setJavaScriptEnabled(true);
			client.setThrowExceptionOnScriptError(false);
			client.setThrowExceptionOnFailingStatusCode(false);
			client.setAjaxController(new NicelyResynchronizingAjaxController());
			client.waitForBackgroundJavaScript(1000);
			client.setCssEnabled(false);
			keywords.add("All-Laptop");
			keywords.add("+Laptop");
			keywords.add("+MacBook");
			keywords.add("+Chromebook");
			keywords.add("+Netbook");
			keywords.add("+Notebook");
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
		
		private  boolean isSkipLink (String tmp){
				//if(tmp.startsWith("http://www.bestbuy.com/site/Laptop-Computers/All-Laptops")
					//	&& (tmp.contains("name=Laptops-Notebooks")
					//	 ||tmp.contains("Item="))&&(!tmp.contains("ProductReview"))
					//	)
			if(tmp.contains("All-Laptops")||isItemLink(tmp))
				  return false;
				return true;
			
		}
		
		public List<String> get_all_link(String url) throws FailingHttpStatusCodeException,
				MalformedURLException, IOException {
			List<String> tmp = new ArrayList<String>();
			if(!url.contains("bestbuy"))
				url = "http://www.bestbuy.com"+url;
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
					if(!anchor.getHrefAttribute().contains("bestbuy"))
						tmp.add("http://www.bestbuy.com"+anchor.getHrefAttribute());
					else 
						tmp.add(anchor.getHrefAttribute());
				}
			
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
						if(isItemLink(newPage)){
							crawled.add(newPage);
							crawledItems.add(newPage);
							System.out.println(newPage);
							continue;
						}
						if(!toCrawl.contains(newPage))
							toCrawl.add(newPage);
					}
					crawled.add(tmp);
				}
			}
		}
		
		public boolean isItemLink(String url){
			for(String temp : keywords){
				if(url.contains(temp)&& !temp.equals("All-Laptop"))
					return true;
			}
			return false;
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
			  seed.add("http://www.bestbuy.com/site/Laptop-Computers/All-Laptops/pcmcat138500050001.c?id=pcmcat138500050001&gf=y");
		
			  Crawler_bestbuy robot = new Crawler_bestbuy(); 
			  robot.crawl_web(seed);
			  robot.printPages();
			  robot.closeCrawler(); 
		  }
	}

