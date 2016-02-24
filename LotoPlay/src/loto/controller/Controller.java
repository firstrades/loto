package loto.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import loto.dao.MainDAO;
import loto.model.Loto;
import loto.model.Report;
import loto.model.Ticket;

@MultipartConfig
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private static Logger log = Logger.getLogger(Controller.class.getName());
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entered Controller");	
		
		String servletPath = request.getServletPath();  
		
		
		if (servletPath.equals("/Loto")) {
			
			System.out.println("Entered Loto");
			
			/************** Get Request **************/				
			String username = request.getParameter("username");  
			String password = request.getParameter("password");  
			
			/************** Database *****************/
			MainDAO dao    = MainDAO.getNewInstance();
			boolean status = dao.getCheckLogin(username, password);
			
			if (status == true) {				
				request.getRequestDispatcher("loto.jsp").forward(request, response);
			} else {				
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} // Loto
		
		else if (servletPath.equals("/InsertPlayData")) {
			
			System.out.println("Entered InsertPlayData");
			
			/************* Get Request ***************/
			String zero1  = request.getParameter("zero" ).trim();  
			String one1   = request.getParameter("one"  ).trim();  
			String two1   = request.getParameter("two"  ).trim();   
			String three1 = request.getParameter("three").trim();
			String four1  = request.getParameter("four" ).trim();
			String five1  = request.getParameter("five" ).trim();
			String six1   = request.getParameter("six"  ).trim();
			String seven1 = request.getParameter("seven").trim();
			String eight1 = request.getParameter("eight").trim();
			String nine1  = request.getParameter("nine" ).trim();
			
			/************* Process ***************/
			int zero = 0, one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0;
			
			if (zero1 != null && !zero1.equals(""))
				zero  = Integer.parseInt(zero1);
			
			if (one1 != null && !one1.equals(""))
				one   = Integer.parseInt(one1 );
			
			if (two1 != null && !two1.equals(""))
				two   = Integer.parseInt(two1 );
			
			if (three1 != null && !three1.equals(""))
				three = Integer.parseInt(three1 );
			
			if (four1 != null && !four1.equals(""))
				four  = Integer.parseInt(four1 );
			
			if (five1 != null && !five1.equals(""))
				five  = Integer.parseInt(five1 );
			
			if (six1 != null && !six1.equals(""))
				six   = Integer.parseInt(six1 );
			
			if (seven1 != null && !seven1.equals(""))
				seven = Integer.parseInt(seven1 );
			
			if (eight1 != null && !eight1.equals(""))
				eight = Integer.parseInt(eight1 );
			
			if (nine1 != null && !nine1.equals(""))
				nine  = Integer.parseInt(nine1 );				
			
			
			/*java.util.Date date = new java.util.Date();
			Object currentTime = new java.sql.Timestamp(date.getTime());    
			java.sql.Timestamp currentTime1 = new java.sql.Timestamp(date.getTime());
			System.out.println(currentTime1);*/
			
			/*java.util.Date utilDate = new java.util.Date();
			java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());  

			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
			String currentTime = sdf.format(sq);*/
			
			/************ Database ******************/			
			Loto loto = MainDAO.setInputData(zero, one, two, three, four, five, six, seven, eight, nine);
			
			/************* Data for next page **************/
			JSONObject jsonObject = new JSONObject();
			
			try {
				jsonObject.put("totalAmount", loto.getTotalAmount()  );
				jsonObject.put("zero",   loto.getNumbers().getZero() );
				jsonObject.put("one",    loto.getNumbers().getOne()  );
				jsonObject.put("two",    loto.getNumbers().getTwo()  );
				jsonObject.put("three",  loto.getNumbers().getThree());
				jsonObject.put("four",   loto.getNumbers().getFour() );
				jsonObject.put("five",   loto.getNumbers().getFive() );
				jsonObject.put("six",    loto.getNumbers().getSix()  );
				jsonObject.put("seven",  loto.getNumbers().getSeven());
				jsonObject.put("eight",  loto.getNumbers().getEight());
				jsonObject.put("nine",   loto.getNumbers().getNine() );
				jsonObject.put("id",     loto.getId()                );
			} catch (JSONException e) {				
				e.printStackTrace();
				//log.error(e);
			}
			
			response.setContentType("application/json");
			response.getWriter().write(jsonObject.toString());
			
		} // InsertPlayData
		
		else if (servletPath.equals("/Report")) {
			
			System.out.println("Entered Report");
			
			/************** Get Request **************/				
			String from1  = null;	
			String to1    = null;		  
			
	        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	        
	        String jsonData = null;
	        
	        if (br != null) {
	        	
	            jsonData = br.readLine();                               
	        }
	        
	        try {
	        	
				JSONObject jsonObject1 = new JSONObject(jsonData);
				
				from1  = jsonObject1.getString("from");  //System.out.println(from1);
				to1    = jsonObject1.getString("to");			  //System.out.println(to1);	
				
			} catch (JSONException e) {				
				e.printStackTrace();
			}
	        
	        /**************** Process ***************/
	        
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date fromDate, toDate;
	        java.sql.Date from = null, to = null;
	        
			try {
				fromDate = format.parse(from1);   
				from     = new java.sql.Date(fromDate.getTime());  //System.out.println(from);
				
				toDate   = format.parse(to1);
				to       = new java.sql.Date(toDate.getTime());  //System.out.println(to);
				
			} catch (ParseException e) {
				
				e.printStackTrace();
				//log.error(e);
			}
	        
	        /************* Datebase ******************/
			
			MainDAO dao = MainDAO.getNewInstance();
			List<Report> list = dao.getReport(from, to);
			
			
			
			/************* Data for next page **************/
			JSONArray jsonArray   = new JSONArray();
			
			
			for (Report report : list) {
				
				JSONObject jsonObject = new JSONObject();				
				
				try {
					
					jsonObject.put("date",  report.getDateTime().getDate() );
					jsonObject.put("time",  report.getDateTime().getTimeLength());
					jsonObject.put("zero",  report.getNumbers().getZero()  );
					jsonObject.put("one",   report.getNumbers().getOne()   );
					jsonObject.put("two",   report.getNumbers().getTwo()   );
					jsonObject.put("three", report.getNumbers().getThree() );
					jsonObject.put("four",  report.getNumbers().getFour()  );
					jsonObject.put("five",  report.getNumbers().getFive()  );
					jsonObject.put("six",   report.getNumbers().getSix()   );
					jsonObject.put("seven", report.getNumbers().getSeven() );
					jsonObject.put("eight", report.getNumbers().getEight() );
					jsonObject.put("nine",  report.getNumbers().getNine()  );					
					
					
					jsonArray.put(jsonObject);
					
				} catch (JSONException e) {				
					e.printStackTrace();
					//log.error(e);
				}
			}
			
			
			
			response.setContentType("application/json");
			response.getWriter().write(jsonArray.toString());
			
			
		} // Report
		
		else if (servletPath.equals("/Print")) {
			
			System.out.println("Entered Print");
			
			/************** Get Request **************/				
			String id1 = request.getParameter("id");  	System.out.println(id1);
			
			/************* Process *****************/
			int id = Integer.parseInt(id1);
			
			/************** Database *****************/
			MainDAO dao    = MainDAO.getNewInstance();
			Ticket ticket = dao.getTicket(id);
			
			/*********** Set Request ************/			
			request.setAttribute("ticket", ticket);
			
			/********* Next Page ****************/
			
			request.getRequestDispatcher("print.jsp").forward(request, response);
			
		} // Print
		
		
	}
}


