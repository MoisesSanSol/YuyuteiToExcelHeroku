package yyt2xls;

import java.io.File;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class YuyuteiScrapper {
	
	public ArrayList<CardRow> parseYuyuteiPage(String pageUrl) throws Exception{
		ArrayList<CardRow> cardRows = new ArrayList<CardRow>();
		
		Document doc = Jsoup.connect(pageUrl).maxBodySize(0).get();
		/*File input = new File("C:\\Users\\Moises BSS\\Desktop\\PruebasTemporales\\canaan.html");
		Document doc = Jsoup.parse(input, "UTF-8");*/

		Elements cards = doc.select("[class^=card_unit]");
		
		for(Element card : cards){
			
			CardRow cardRow = new CardRow();
			
			cardRow.rarity = card.className().replace("card_unit rarity_", "");
			
			Element name = card.select(".id").first();
			cardRow.cardId = name.text();
			
			Element price = card.select(".price").first();
			cardRow.price = price.text().replace("円", "");

			if(price.html().contains("sale")){
				String[] prices = cardRow.price.split(" ");
				cardRow.sale = "Sale (" + prices[0] + ")";
				cardRow.price = prices[1];
			}
			
			Element stock = card.select(".stock").first();
			cardRow.stock = stock.text().replace("残：", "").replace("◯", "O");
			
			Element url = card.select("a[href]").first();
			cardRow.url = "http://yuyu-tei.jp" + url.attr("href");
			
			cardRows.add(cardRow);
		}
		
		return cardRows;
	}
	
}
