<%@page import="loto.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Loto</title>

	<link type="text/css" href="<%=FrequentUse.style %>" rel="stylesheet" />
	<script type="text/javascript" src="<%=FrequentUse.jQuery%>"></script>
	<script type="text/javascript" src="<%=FrequentUse.script%>"></script>
	
</head>

<body>
	<div class="wrapper">
		<div class="main_div">
		
			<table width="100%" cellpadding="0" cellspacing="0" style="margin-left:68px;">
				<tbody>
					<tr>
						<td style="width:28%;"> <img alt="" src="images/litan.png" style="width: 27%;" />  </td>
						<td> 
							<p style="float:left;"> Date :- &nbsp;</p> 
							<p id="date" style="float:left;font-size: 16px; color: #FF0000; font-weight: bold;">  </p>   							
						</td>
						<td style="color:red;font-weight: bold;"><div id="time" style="margin-left:-60%"></div></td>
						<td style="margin-right: 87px;float: right;margin-top:25px;"> 
							Time :- <select class="tbox" style="height:29px !important; width: 146px;" id="timeRange">
			 							<option value="0"> select Time </option>
			  							<option value="0">11:00AM - 3:00PM </option>
			  							<option value="0">3:00PM - 7:00PM</option>
			  							<option value="0">7:00PM - 12:00AM</option>			
			   						</select> <br>  <br />  <br />  
			   			</td>
					</tr>
			
				</tbody>
			</table>

			<div class="entry_packages" style="padding: 1px 12px;">
			        <table width="100%" cellpadding="0" cellspacing="0" class="tableStyleTwo" style="position: relative;">
			        	<tbody>
				          	<tr>
					            <td style="position: relative;width: 120px;">0</td>
					            <td style="position: relative;width: 120px;">1</td>
					            <td style="position: relative;width: 120px;">2</td>
					            <td style="position: relative;width: 120px;">3</td>
					            <td style="position: relative;width: 120px;">4</td>
					            <td style="position: relative;width: 120px;">5</td>
					            <td style="position: relative;width: 120px;">6</td>
					            <td style="position: relative;width: 120px;">7</td>
					            <td style="position: relative;width: 120px;">8</td>
					            <td style="position: relative;width: 120px;">9</td>			            
				          	</tr>
				          	<tr>
				          		<td id="zero" style="position: relative;width: 120px;"> 0 </td>
					            <td id="one" style="position: relative;width: 120px;">  0 </td>
					            <td id="two" style="position: relative;width: 120px;">  0 </td>
					            <td id="three" style="position: relative;width: 120px;">0 </td>
					            <td id="four" style="position: relative;width: 120px;"> 0 </td>
					            <td id="five" style="position: relative;width: 120px;"> 0 </td>
					            <td id="six" style="position: relative;width: 120px;">  0 </td>
					            <td id="seven" style="position: relative;width: 120px;">0 </td>
					            <td id="eight" style="position: relative;width: 120px;">0 </td>
					            <td id="nine" style="position: relative;width: 120px;"> 0 </td>					            
				          	</tr>
			         
			        	</tbody>
			        </table>
			</div>  

			<div class="entry_packages" style="float: left; margin-left: 13px;">
				<table  cellpadding="0" cellspacing="0" class="tableStyleTwo" style="width:300px;position: relative;">
			    	<tbody>
			        	<tr>
			        		<td>  Total Amount :- </td>
			        		<td id="totalAmount" style="position: relative;width: 120px;">  000  </td>			        		
			        	</tr>
			        </tbody>
			    </table>			
			</div>
				<div class="entry_packages" style="float: right; margin-right: 13PX;">
				<table  cellpadding="0" cellspacing="0" class="tableStyleTwo" style="width:300px;position: relative;">
			    	<tbody>
			        	<tr>
			        		<td>  Sub Amount :- </td>
			        		<td id="subTotal" style="position: relative;width: 120px;">  000  </td>			        		
			        	</tr>
			        </tbody>
			    </table>			
			</div>

			<form id="input" method="post" enctype="multipart/form-data">
			
				<div class="entry_packages" style="padding: 1px 12px;">
					<table width="100%" cellpadding="0" cellspacing="0" class="tableStyleTwo">
				    	<tbody>
				    		<tr>
					            <td>0</td>
					            <td>1</td>
					            <td>2</td>
					            <td>3</td>
					            <td>4</td>
					            <td>5</td>
					            <td>6</td>
					            <td>7</td>
					            <td>8</td>
					            <td>9</td>				            
				          	</tr>
				          	<tr>
					            <td> <input type="text" name="zero"  class="tbox"/> </td>
					            <td> <input type="text" name="one"   class="tbox"/> </td>
					            <td> <input type="text" name="two"   class="tbox"/> </td>
					            <td> <input type="text" name="three" class="tbox"/> </td>
					            <td> <input type="text" name="four"  class="tbox"/> </td>
					            <td> <input type="text" name="five"  class="tbox"/> </td>
					            <td> <input type="text" name="six"   class="tbox"/> </td>
					            <td> <input type="text" name="seven" class="tbox"/> </td>
					            <td> <input type="text" name="eight" class="tbox"/> </td>
					            <td> <input type="text" name="nine"  class="tbox"/> </td>
				          	</tr>				         
				        </tbody>
					</table>					
				</div> 			        
			        
			    	<table style="margin-bottom: 29px;">
			        	<tbody>
			        		<tr>
			        			<td> 
			         				<input type="reset" value="clear" id="reset" tabindex="5" class="btn btn-success" style="background:  linear-gradient(#E00C0C, #CE1313 60%, #981C1C) !important; border: 1px solid #961111  !important;" /> 
			         			</td>			         
			          			<td> 
			          				<a href="report.jsp" class="btn btn-success" style="background-image: linear-gradient(#88c149, #73a839 60%, #699934) !important; border: 1px solid #4D7522 !important; padding: 5px 22px; text-decoration: none;"> Report  </a>			         				
			         			</td>			         
			         			<td id="print">  
			         				<a href="#" class="btn btn-success" style="background-image: linear-gradient(#068EDE, #32628C 60%, #346199) !important;text-decoration:none;    border: 1px solid #0B5786 !important; padding: 5px 17px;"> Print  </a> 
			         			</td>			         
			          			<td> 
			         				<input type="submit" value="Ok" tabindex="5" class="btn btn-success" style="background-image: linear-gradient(#EA6C00, #E6850F 60%, #EC7208) !important; border: 1px solid #B75013 !important;position: relative;left: 759%;" /> 			         
			         			</td>			        
			        		</tr>			        
			        	</tbody>
			        </table>
			        
			</form>
        
		</div>
	</div>

</body>
</html>
