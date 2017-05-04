package yyt2xls;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception{
		System.out.println("*** Starting ***");
		
		YuyuteiScrapper yytscrapper = new YuyuteiScrapper();
		ArrayList<CardRow> cards = yytscrapper.parseYuyuteiPage("http://yuyu-tei.jp/game_ws/sell/sell_price.php?ver=konosuba");
		
		ToExcel excelGenerator = new ToExcel();
		excelGenerator.generateExcel(cards);
		
		System.out.println("*** Finished ***");
	}

}
