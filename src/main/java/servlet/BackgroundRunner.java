package servlet;

import java.util.ArrayList;
import yyt2xls.CardRow;

import yyt2xls.ToExcel;

public class BackgroundRunner extends Thread {

	public ArrayList<CardRow> cards;
    public ToExcel toExcel;

    public void run() {
       try{
    	this.toExcel.generateExcelwImages(this.cards);
       }
       catch(Exception whatever){
       }
    }

    public float getProgress() {
        return this.toExcel.getProgress();
    }

}