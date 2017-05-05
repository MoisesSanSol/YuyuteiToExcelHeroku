import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yyt2xls.CardRow;
import yyt2xls.ToExcel;
import yyt2xls.YuyuteiScrapper;

@WebServlet(
        name = "MyServlet", 
        urlPatterns = {"/yyt2xls"}
    )
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	byte[] bytes = new byte[0];
    	
    	String yytSeries = request.getParameter("series"); 
    	
    	try{
	    	YuyuteiScrapper yytscrapper = new YuyuteiScrapper();
	    	ToExcel formatter = new ToExcel();
			ArrayList<CardRow> cards = yytscrapper.parseYuyuteiPage("http://yuyu-tei.jp/game_ws/sell/sell_price.php?ver=" + yytSeries);
			bytes = formatter.generateExcel(cards);
    	}
    	catch(Exception everthing){
    		//Ignore
    	}
    	
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=yuyutei_" + yytSeries + ".xls");
    	
        ServletOutputStream out = response.getOutputStream();
        out.write(bytes);
        out.flush();
        out.close();
    }
    
}
