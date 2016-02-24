<%@page import="loto.model.Ticket"%>
<%@page import="loto.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Print</title>
<link type="text/css" href="css/style.css" rel="stylesheet" />
    <%-- <script src="<%=FrequentUse.jQuery%>"></script> --%>
    <script src="js/BeatPicker.min.js"></script>
    <link rel="stylesheet" href="css/BeatPicker.min.css"/>
    <style>
	button{
		display:none;
	}
	</style>
	<script type="text/javascript">window.print();</script>
</head>

<%
	Ticket ticket = (Ticket) request.getAttribute("ticket");
	
	int totalNumber = ticket.getNumbers().getZero() + ticket.getNumbers().getOne() + ticket.getNumbers().getTwo() + ticket.getNumbers().getThree()
			 + ticket.getNumbers().getFour() + ticket.getNumbers().getFive() + ticket.getNumbers().getSix() + ticket.getNumbers().getSeven()
			  + ticket.getNumbers().getEight() + ticket.getNumbers().getNine();

%>

<body>

<div class="wrapper" style="width:320px;">
	<div class="main_div">
	
		<table width="100%" cellpadding="0" cellspacing="0" style="margin-top:13px; text-align:center;">
			<tbody>
				<tr>
					<td>LOTO LOTARI </td>
					<td><%=ticket.getDateTime() %></td>
				</tr>
			</tbody>
		</table>



<div class="entry_packages">
        <table width="90%" cellpadding="0" cellspacing="0" class="tableStyleTwo">
          <tbody>
          	<tr>
            	<td>Ticket Id.</td>
            	<td><%=ticket.getId() %></td>
            </tr>
            <tr>
            	<td>0</td>
            	<td><%=ticket.getNumbers().getZero() %></td>
            </tr>
            <tr>
            	<td>1</td>
            	<td><%=ticket.getNumbers().getOne() %></td>
            </tr>
            <tr>
            	<td>2</td>
            	<td><%=ticket.getNumbers().getTwo() %></td>
            </tr>
            <tr>
            	<td>3</td>
            	<td><%=ticket.getNumbers().getThree() %></td>
            </tr>
            <tr>
            	<td>4</td>
            	<td><%=ticket.getNumbers().getFour() %></td>
            </tr>
            <tr>
            	<td>5</td>
            	<td><%=ticket.getNumbers().getFive() %></td>
            </tr>
            <tr>
            	<td>6</td>
            	<td><%=ticket.getNumbers().getSix() %></td>
            </tr>
            <tr>
            	<td>7</td>
            	<td><%=ticket.getNumbers().getSeven() %></td>
          	</tr>
	        <tr>
	        	<td>8</td>
	            <td><%=ticket.getNumbers().getEight() %></td>
	        </tr>
	        <tr>
	            <td>9</td>
	            <td><%=ticket.getNumbers().getNine() %></td>
	        </tr>
            <tr>
            	<td style="font-size:20px; color:#E60000;">Total</td>
            	<td style="font-size:20px; color:#E60000;"> 
            		<p style="float:left; margin-left:20px;"> &nbsp;&nbsp; <%=totalNumber %>*10 </p> &nbsp;&nbsp; 
            		<p style="float:left;margin-left:10px;"> =  </p>&nbsp;&nbsp;
            		<p style="float:left;margin-left:6px;">  <%=totalNumber * 10 %> </p>
            	</td>
            </tr>      
         
          </tbody>
        </table>
      
        </div>


	</div>
</div>

</body>
</html>
