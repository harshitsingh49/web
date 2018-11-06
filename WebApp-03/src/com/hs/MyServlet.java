package com.hs;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public MyServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String docType =
				"<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType +
				"<html>\n" +
      	          "<head>" +
      	          "<b><title>OutPut Page</title></b>"+
      	          "<style>"+
      	          "div.a {"+
      	          "text-align: center;"+
      	          "}"+ "</style>"+
      	                "<link rel='stylesheet' type='text/css' href='style.css' />"+  
      	                "</head>"+

      	      "<body bgcolor = \"#f0f0f0\">\n" +
      	      "<p align = \"center\">" + 
      	      "<div class='a'>"+ 
      	      "<label for='Birth Year'><b>Entered Birth Year:   </b></label>"+
      	      request.getParameter("year")+
      	      "<br>"+"<br>"+
      	      "  <b>Output</b>: "+
      	      yearToWord(Integer.parseInt(request.getParameter("year")))  + "\n"+
      	      "</div>"+        
      	      "</p>\n" + 
      	      "</body>"+
      	      "</html>"
				); 
	}

	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	// Method to convert Birth Year in Word.
	public static String yearToWord(int year){
		String word = " ";
		String unitPlace[] ={ "Zero","One","Two","Three","Four","Five","Six","Seven",
				"Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fiftten",
				"Sixten","Seventeen","Eighteen","Nineteen" };

		String tensPlace[] = {"Zero ","Ten ","Twenty ","Thirty ","Fourty ","Fifty ","Sixty ",
				"Seventy ","Eighty ","Ninety "};
		// Conditions to check the digit place in year.	
		if((year / 1000)> 0){
			word = word+ yearToWord(year/1000) + " Thousand ";
			year = year %1000;
		}
		if((year / 100)>0){
			word = word+ yearToWord(year/100) + " Hundread "+ "and ";
			year = year %100;
		}
		if(year >0){
			if(year < 20){
				word = word+ unitPlace[year];
			}else{
				word = word+ tensPlace[year /10];
				if((year % 10)> 0){
					word = word + unitPlace[year % 10];
				}
			}
		}

		return word;	
	}

}
