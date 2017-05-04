package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yyt2xls.CardRow;
import yyt2xls.YuyuteiScrapper;

@WebServlet(
        name = "MyServlet", 
        urlPatterns = {"/hello"}
    )
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	String printable = "";
    	try{
    	YuyuteiScrapper yytscrapper = new YuyuteiScrapper();
		ArrayList<CardRow> cards = yytscrapper.parseYuyuteiPage("http://yuyu-tei.jp/game_ws/sell/sell_price.php?ver=konosuba");
    	for (CardRow card : cards) {
    		printable = printable + card.cardId;
    	}
    	}
    	catch(Exception everthing){
    		//Ignore
    	}
        ServletOutputStream out = resp.getOutputStream();
        out.write(printable.getBytes());
        out.flush();
        out.close();
    }
    
}
