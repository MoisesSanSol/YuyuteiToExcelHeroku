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

    	try{
    	
	    	String yytSeries = request.getParameter("series");
	    	boolean imagenes = Boolean.parseBoolean(request.getParameter("imagenes"));
	    	boolean foils = Boolean.parseBoolean(request.getParameter("paralelas"));
	    	boolean trial = Boolean.parseBoolean(request.getParameter("trial"));
	    	boolean promos = Boolean.parseBoolean(request.getParameter("promocionales"));
	    	boolean color = Boolean.parseBoolean(request.getParameter("color"));
	    	
			BackgroundRunner longProcess = new BackgroundRunner();
            longProcess.setDaemon(true);
            longProcess.yytSeries = yytSeries;
            longProcess.scrappper.foils = foils;
            longProcess.scrappper.trial = trial;
            longProcess.scrappper.promos = promos;
            longProcess.scrappper.withColor = color;
            longProcess.toExcel.withImages = imagenes;
            longProcess.start();
            
            request.getSession().setAttribute("longProcess", longProcess);
            request.getRequestDispatcher("generandoExcel.jsp").forward(request, response);
			
    	}
    	catch(Exception everything){
    		System.out.println("Hey! Excp!");
    		everything.printStackTrace();
    	}
    }
    
}
