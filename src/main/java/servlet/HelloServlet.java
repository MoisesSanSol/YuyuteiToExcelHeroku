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
import yyt2xls.ToExcel;
import yyt2xls.YuyuteiScrapper;

@WebServlet(
        name = "MyServletHello", 
        urlPatterns = {"/yyt2xls"}
    )
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	byte[] bytes = new byte[0];
    	
    	String yytSeries = request.getParameter("series");
    	boolean imagenes = Boolean.parseBoolean(request.getParameter("imagenes"));
    	boolean foils = Boolean.parseBoolean(request.getParameter("paralelas"));
    	boolean trial = Boolean.parseBoolean(request.getParameter("trial"));
    	boolean promos = Boolean.parseBoolean(request.getParameter("promocionales"));
    	
    	try{
	    	YuyuteiScrapper yytscrapper = new YuyuteiScrapper();
	    	ToExcel formatter = new ToExcel();
			ArrayList<CardRow> allCards = yytscrapper.parseYuyuteiPage("http://yuyu-tei.jp/game_ws/sell/sell_price.php?ver=" + yytSeries);
			ArrayList<CardRow> filteredCards = formatter.filtrarSet(allCards, foils, trial, promos);
			/*if(imagenes){
				bytes = formatter.generateExcelwImages(filteredCards);
			}
			else{
				bytes = formatter.generateExcel(filteredCards);
			}*/
			
			BackgroundRunner longProcess = new BackgroundRunner();
            longProcess.setDaemon(true);
            longProcess.cards = filteredCards;
            longProcess.toExcel = formatter;
            longProcess.start();
            request.getSession().setAttribute("longProcess", longProcess);
            request.getRequestDispatcher("generandoExcel.jsp").forward(request, response);
			
    	}
    	catch(Exception everthing){
    		System.out.println("Hey! Excp!");
    	}
    	
        /*response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=yuyutei_" + yytSeries + ".xls");
    	
        ServletOutputStream out = response.getOutputStream();
        out.write(bytes);
        out.flush();
        out.close();*/
    }
    
}
