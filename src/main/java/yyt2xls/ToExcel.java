package yyt2xls;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class ToExcel {

	
	public void generateExcel(ArrayList<CardRow> cards) throws Exception{
		
		Workbook excel = new HSSFWorkbook();
        Sheet hoja = excel.createSheet("Precios");
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
       	 	
	        celdaId.setCellValue(card.cardId);
	        celdaRarity.setCellValue(card.rarity);
       	 	celdaPrice.setCellValue(Integer.parseInt(card.price));
	        celdaSale.setCellValue(card.sale);
	        celdaStock.setCellValue(card.stock);
	        celdaCuantas.setCellValue(4);
	        celdaTotal.setCellFormula("C"  + (count + 1) + " * F" + (count + 1));
	        celdaTotal.setCellStyle(style);
		}
		
		// Set up the file writing
		String fullPath = "C:\\Users\\Moises BSS\\Desktop\\PruebasTemporales\\" + "\\" + "cannan" + ".xls";

		hoja.setAutoFilter(new CellRangeAddress(0, 0, 0, 5));
		
		for(int i = 0; i <= 5; i++){
	        hoja.autoSizeColumn(i);
	        hoja.setColumnWidth(i ,hoja.getColumnWidth(i) + 700);
		}

		hoja.autoSizeColumn(6);
		hoja.createFreezePane(0, 1);
		
		File file = new File(fullPath);
		if(file.exists()) file.delete();
		file.createNewFile();

		FileOutputStream stream = new FileOutputStream(file);
        excel.write(stream);
        stream.close();
        excel.close();

        Desktop.getDesktop().open(file);
	}
	
}
