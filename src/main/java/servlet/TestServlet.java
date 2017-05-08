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
        name = "MyServlet", 
        urlPatterns = {"/test"}
    )
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	try{
    		
    		System.out.println("Hey!");
    		
            response.setContentType("text/plain");
            response.setHeader("Content-Disposition", "attachment; filename=prueba.txt");
            
            

				File newFile = new File("prueba.txt");
				Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), "UTF-8"));
				writer.write("chufa");
				writer.close();
				
		        ServletOutputStream out = response.getOutputStream();
		        out.write("lol".getBytes());
		        out.flush();
		        out.close();
	
    	}
    	catch(Exception everthing){
    		//Ignore
    	}
    	

    	

    }
    
}
