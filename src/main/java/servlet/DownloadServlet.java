package servlet;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
        name = "MyServlet2", 
        urlPatterns = {"/download"}
    )
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
      	
    	try{
    		BackgroundRunner longProcess = (BackgroundRunner) request.getSession().getAttribute("longProcess");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=" + longProcess.yytSeries + "_yyt_export.xls");
            request.getSession().removeAttribute("longProcess");
			File oldFile = new File("excel.xls");
			FileInputStream in = new FileInputStream(oldFile);
	        ServletOutputStream out = response.getOutputStream();
		    byte[] buffer = new byte[4096];
		    int length;
		    while ((length = in.read(buffer)) > 0) {
		        out.write(buffer, 0, length);
		    }
			out.flush();
	        out.close();

    	}
    	catch(Exception everthing){
    		//Ignore
    	}
    }
}
