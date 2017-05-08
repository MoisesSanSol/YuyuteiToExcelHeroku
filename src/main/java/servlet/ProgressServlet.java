package servlet;

import java.io.File;
import java.io.FileInputStream;
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
        name = "TestServlet", 
        urlPatterns = {"/checkExcelProgress"}
    )
public class ProgressServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
        {
    	
            if ("XMLHttpRequest".equals(request.getHeader("x-requested-with"))) {

            	BackgroundRunner longProcess = (BackgroundRunner) request.getSession().getAttribute("longProcess");
                response.setContentType("application/json");
                float progress = longProcess.getProgress();
                
                //System.out.println("Hey! Checking!" + progress);
                
                if(progress == 100){
                	request.getSession().removeAttribute("longProcess");
                }
                
               	response.getWriter().write(String.valueOf(progress));

            } else {
                request.getRequestDispatcher("generandoExcel.jsp").forward(request, response);
            }
        }

        /*protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
        {
        	
        	System.out.println("Hey! Post!");
        	BackgroundRunner longProcess = new BackgroundRunner();
            longProcess.setDaemon(true);
            longProcess.start();
            request.getSession().setAttribute("longProcess", longProcess);
            request.getRequestDispatcher("runLongProcess.jsp").forward(request, response);
        }*/
}
