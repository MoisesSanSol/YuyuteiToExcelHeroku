package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import yyt2xls.CardRow;
import yyt2xls.YuyuteiScrapper;
import yyt2xls.ToExcel;

public class BackgroundRunner extends Thread {

	public String yytSeries;
	public YuyuteiScrapper scrappper;
    public ToExcel toExcel;

    public BackgroundRunner(){
		this.scrappper = new YuyuteiScrapper();
		this.toExcel = new ToExcel();
    }
    
    public void run() {
       try{
			ArrayList<CardRow> cards = this.scrappper.parseYuyuteiPage("http://yuyu-tei.jp/game_ws/sell/sell_price.php?ver=" + this.yytSeries);
			byte[] bytes = this.toExcel.generateExcel(cards);
			FileOutputStream stream = new FileOutputStream("excel.xls");
			try {
			    stream.write(bytes);
			} finally {
			    stream.close();
			}
       }
       catch(Exception whatever){
       }
    }

    public String getExcelProgress() {
    	int rounded = Math.round(this.toExcel.getProgress());
        return Integer.toString(rounded);
    }

    public String getCartasProgress() {
        int rounded = Math.round(this.scrappper.getProgress());
        return Integer.toString(rounded);
    }
    
}