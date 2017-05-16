package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import yyt2xls.CardRow;
import yyt2xls.YuyuteiScrapper;
import yyt2xls.JktcgScrapper;
import yyt2xls.ToExcel;

public class BackgroundRunner extends Thread {

	public String yytSeries;
	public String jktcgUrl;
	public String submit;
	public boolean foils = false;
	public boolean promos = false;
	public boolean trial = false;
	public boolean withColor = false;

	public YuyuteiScrapper yytScrappper;
	public JktcgScrapper jktcgSrappper;
	public ToExcel toExcel;

	public boolean isJktcg = false;
	
	public String fileName;
	
    public BackgroundRunner(){
		this.toExcel = new ToExcel();
    }
    
    public void run() {
    	System.out.println("LongProcess Running");
       try{
    	   ArrayList<CardRow> cards = new ArrayList<CardRow>();
    	   if(this.submit.equals("Generar Excel JKTCG")){
    		   this.jktcgSrappper = new JktcgScrapper();
    		   this.jktcgSrappper.foils = this.foils;
    		   this.jktcgSrappper.promos = this.promos;
    		   this.jktcgSrappper.trial = this.trial;
    		   this.jktcgSrappper.withColor = this.withColor;
    		   this.isJktcg = true;
    		   this.fileName = "jktcg_export";
    			String frameUrl = this.jktcgSrappper.getJktcgSinglesFrame("http://jktcg.com/" + this.jktcgUrl);
    		   cards = this.jktcgSrappper.parseJktcgPage(frameUrl);
    	   }
    	   else{
    		   this.yytScrappper = new YuyuteiScrapper();
    		   this.yytScrappper.foils = this.foils;
    		   this.yytScrappper.promos = this.promos;
    		   this.yytScrappper.trial = this.trial;
    		   this.yytScrappper.withColor = this.withColor;
    		   this.fileName = this.yytSeries + "_yyt_export";
    		   cards = this.yytScrappper.parseYuyuteiPage("http://yuyu-tei.jp/game_ws/sell/sell_price.php?ver=" + this.yytSeries);
    	   }
			
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
    	String roundedStr;
    	if(this.isJktcg){
    		int rounded = Math.round(this.jktcgSrappper.getProgress());
    		roundedStr = Integer.toString(rounded) + " cartas procesadas";
    	}
    	else{
    		int rounded = Math.round(this.yytScrappper.getProgress());
    		roundedStr = Integer.toString(rounded) + "%";
    	}
        return roundedStr;
    }
    
}