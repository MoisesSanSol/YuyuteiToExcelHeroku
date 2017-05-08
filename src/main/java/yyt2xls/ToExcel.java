package yyt2xls;

import java.awt.Dimension;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;

public class ToExcel {

	float progress;
	
	public byte[] generateExcel(ArrayList<CardRow> cards) throws Exception{
		
		Workbook excel = new HSSFWorkbook();
        Sheet hoja = excel.createSheet("Precios");
        CreationHelper helper =  excel.getCreationHelper();
        Drawing drawing = hoja.createDrawingPatriarch();
        YuyuteiScrapper yytScrapper = new YuyuteiScrapper(); 
        
        Row headers = hoja.createRow(0);
        Cell headerId = headers.createCell(0);
        Cell headerRarity = headers.createCell(1);
        Cell headerPrice = headers.createCell(2);
        Cell headerSale = headers.createCell(3);
        Cell headerStock = headers.createCell(4);
        Cell headerCuantas = headers.createCell(5);
        Cell headerTotal = headers.createCell(6);
        Cell total = headers.createCell(7);
        headerId.setCellValue("Id");
        headerRarity.setCellValue("Rareza");
        headerPrice.setCellValue("Precio");
        headerSale.setCellValue("Sale");
        headerStock.setCellValue("Stock");
        headerCuantas.setCellValue("Cantidad");
        headerTotal.setCellValue("Total: ");
        total.setCellType(CellType.FORMULA);
        total.setCellFormula("SUBTOTAL(109, G:G)");
        //total.setCellFormula("SUMPRODUCT(SUBTOTAL(109,OFFSET(C:C,ROW(C:C)-MIN(ROW(C:C)),,1,1)),F:F)");

		CellStyle style = excel.createCellStyle();
        Font font = excel.createFont();
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
        
        CellStyle hlink_style = excel.createCellStyle();
        Font hlink_font = excel.createFont();
        hlink_font.setUnderline(Font.U_SINGLE);
        hlink_font.setColor(HSSFColor.BLUE.index);
        hlink_style.setFont(hlink_font);
        
        int count = 0;
        
		for (CardRow card : cards) {
			
			count++;
			
			Row fila = hoja.createRow(count);
	        Cell celdaId = fila.createCell(0);
	        Cell celdaRarity = fila.createCell(1);
	        Cell celdaPrice = fila.createCell(2);
       	 	Cell celdaSale = fila.createCell(3);
       	 	Cell celdaStock = fila.createCell(4);
       	 	Cell celdaCuantas = fila.createCell(5);
       	 	Cell celdaTotal = fila.createCell(6);
       	 	
       	 	HSSFHyperlink url_link = (HSSFHyperlink) helper.createHyperlink(HSSFHyperlink.LINK_URL);
            url_link.setAddress(card.url);
            celdaId.setHyperlink(url_link);
	        celdaId.setCellValue(card.cardId);
            celdaId.setCellStyle(hlink_style);
	        
	        celdaRarity.setCellValue(card.rarity);
       	 	celdaPrice.setCellValue(Integer.parseInt(card.price));
	        celdaSale.setCellValue(card.sale);
	        celdaStock.setCellValue(card.stock);
	        celdaCuantas.setCellValue(4);
	        celdaTotal.setCellFormula("C"  + (count + 1) + " * F" + (count + 1));
	        celdaTotal.setCellStyle(style);
	        
		}

		hoja.setAutoFilter(new CellRangeAddress(0, 0, 0, 5));
		
		for(int i = 0; i <= 5; i++){
	        hoja.autoSizeColumn(i);
	        hoja.setColumnWidth(i ,hoja.getColumnWidth(i) + 700);
		}

		hoja.autoSizeColumn(6);
		hoja.createFreezePane(0, 1);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			excel.write(bos);
		} finally {
			excel.close();
		    bos.close();
		}
		
		byte[] bytes = bos.toByteArray();
		
		return bytes;
	}
	
	public void generateExcelwImages(ArrayList<CardRow> cards) throws Exception{
		
		Workbook excel = new HSSFWorkbook();
        Sheet hoja = excel.createSheet("Precios");
        CreationHelper helper =  excel.getCreationHelper();
        Drawing drawing = hoja.createDrawingPatriarch();
        YuyuteiScrapper yytScrapper = new YuyuteiScrapper(); 
        
        Row headers = hoja.createRow(0);
        Cell headerId = headers.createCell(1);
        Cell headerRarity = headers.createCell(2);
        Cell headerPrice = headers.createCell(3);
        Cell headerSale = headers.createCell(4);
        Cell headerStock = headers.createCell(5);
        Cell headerCuantas = headers.createCell(6);
        Cell headerTotal = headers.createCell(7);
        Cell total = headers.createCell(8);
        headerId.setCellValue("Id");
        headerRarity.setCellValue("Rareza");
        headerPrice.setCellValue("Precio");
        headerSale.setCellValue("Sale");
        headerStock.setCellValue("Stock");
        headerCuantas.setCellValue("Cantidad");
        headerTotal.setCellValue("Total: ");
        total.setCellType(CellType.FORMULA);
        total.setCellFormula("SUBTOTAL(109, H:H)");
        //total.setCellFormula("SUMPRODUCT(SUBTOTAL(109,OFFSET(C:C,ROW(C:C)-MIN(ROW(C:C)),,1,1)),F:F)");

		CellStyle style = excel.createCellStyle();
        Font font = excel.createFont();
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
        
        CellStyle hlink_style = excel.createCellStyle();
        Font hlink_font = excel.createFont();
        hlink_font.setUnderline(Font.U_SINGLE);
        hlink_font.setColor(HSSFColor.BLUE.index);
        hlink_style.setFont(hlink_font);
        
        int count = 0;
        
		for (CardRow card : cards) {
			
			//System.out.println("Hey! Card! " + card.cardId);
			
			count++;
			
			Row fila = hoja.createRow(count);
			Cell celdaImg = fila.createCell(0);
	        Cell celdaId = fila.createCell(1);
	        Cell celdaRarity = fila.createCell(2);
	        Cell celdaPrice = fila.createCell(3);
       	 	Cell celdaSale = fila.createCell(4);
       	 	Cell celdaStock = fila.createCell(5);
       	 	Cell celdaCuantas = fila.createCell(6);
       	 	Cell celdaTotal = fila.createCell(7);
       	 	
       	 	HSSFHyperlink url_link = (HSSFHyperlink) helper.createHyperlink(HSSFHyperlink.LINK_URL);
            url_link.setAddress(card.url);
            celdaId.setHyperlink(url_link);
	        celdaId.setCellValue(card.cardId);
            celdaId.setCellStyle(hlink_style);
           
            celdaImg.setHyperlink(url_link);
            
	        celdaRarity.setCellValue(card.rarity);
       	 	celdaPrice.setCellValue(Integer.parseInt(card.price));
	        celdaSale.setCellValue(card.sale);
	        celdaStock.setCellValue(card.stock);
	        celdaCuantas.setCellValue(4);
	        celdaTotal.setCellFormula("D"  + (count + 1) + " * G" + (count + 1));
	        celdaTotal.setCellStyle(style);
	        
	        fila.setHeightInPoints(66);
	        ClientAnchor anchor = helper.createClientAnchor();

	        anchor.setCol1(0);
	        anchor.setCol2(1);
	        anchor.setRow1(count);
	        anchor.setRow2(count + 1);

	        byte[] imgBytes = yytScrapper.getYuyuteiCardImage(card.imgUrl);
	        
	        int pictureIndex = excel.addPicture(imgBytes, Workbook.PICTURE_TYPE_PNG);
	        drawing.createPicture(anchor, pictureIndex);
	        
	        progress = (float)(((double)count / (double)cards.size()) * 100);
		}

		hoja.setAutoFilter(new CellRangeAddress(0, 0, 1, 6));
		
		for(int i = 1; i <= 6; i++){
	        hoja.autoSizeColumn(i);
	        hoja.setColumnWidth(i, hoja.getColumnWidth(i) + 700);
		}

		hoja.autoSizeColumn(6);
		hoja.createFreezePane(0, 1);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			excel.write(bos);
		} finally {
			excel.close();
		    bos.close();
		}
		
		FileOutputStream archivo = new FileOutputStream("excel.xls");
		excel.write(archivo);
        archivo.close();
        excel.close();

        //byte[] bytes = bos.toByteArray();
        //return bytes;
	}
	
	public ArrayList<CardRow> filtrarSet(ArrayList<CardRow> cards, boolean foils, boolean trial, boolean promos){
		
		ArrayList<CardRow> filteredCards = new ArrayList<CardRow>();
		
		for(CardRow card : cards){
			
			if(card.rarity.startsWith("S") || card.rarity.equals("RRR") || card.rarity.equals("XR")){
				if(foils){
					filteredCards.add(card);
				}
			}
			else if(card.rarity.equals("PR")){
				if(promos){
					filteredCards.add(card);
				}
			}
			else if(card.rarity.equals("TD")){
				if(trial){
					filteredCards.add(card);
				}
			}
			else{
				filteredCards.add(card);
			}
		}
		
		return filteredCards;
	}
	
	public float getProgress(){
		return progress;
	}
	
}
