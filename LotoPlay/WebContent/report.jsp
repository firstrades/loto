<%@page import="loto.common.FrequentUse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html data-ng-app="loto">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Report</title>

	<link type="text/css" href="<%=FrequentUse.style%>" rel="stylesheet" />
    <script src="<%=FrequentUse.jQuery%>"></script>
   <%--  <script src="<%=FrequentUse.script%>"></script> --%>
    
    <script src="<%=FrequentUse.angular%>"></script>
    <script src="js/script_angular.js"></script>
    
    <!-- Calendar -->
    <script src="js/BeatPicker.min.js"></script>
    <link rel="stylesheet" href="css/BeatPicker.min.css"/>
    
<style>
button{
display:none;
}
</style>

</head>

<body data-ng-controller='MainController'>

<div class="wrapper">
	<div class="main_div">
	
		
	
			<table width="100%" cellpadding="0" cellspacing="0" style="margin-left:68px;">
				<tbody>
					<tr>
						<td style="width:22%;"> <img alt="" src="images/litan.png" style="width: 27%;" />  </td>
						<td style="width:23%;"> 
							<p style="float:left;"> Date :- &nbsp;</p> 
							<p id="demo" style="float:left;font-size: 14px; color: #FF0000;    font-weight: bold;">  </p>   
							<script>
								var d = new Date();
								document.getElementById("demo").innerHTML = d.toDateString();
							</script> 
						</td>
						<td style="width:20%;">
							<p style="float:left;margin-top: 25px;">From :- </p> 
							<p style="float:left;">  
								<input type="text" id="fromDate" data-beatpicker="true" class="tbox" placeholder="YYYY-MM-DD" style="background-position: 229px 8px;background-repeat: no-repeat; width:93px;margin: 0px 13px;"  /> 
							</p>
	    				</td>    
						<td >
							<p style="float:left;margin-top: 25px;">To :- </p> 
							<p style="float:left;width: 51px;">  
								<input type="text" id="toDate" data-beatpicker="true" class="tbox" placeholder="YYYY-MM-DD" style="background-position: 229px 8px;background-repeat: no-repeat; width:93px;margin: 0px 13px;"  /> 
							</p>
	    				</td> 
	    				<td>
							<input type="button" value="Ok" tabindex="5" class="btn btn-success" style="background:  linear-gradient(#E00C0C, #CE1313 60%, #981C1C) !important; border: 1px solid #961111  !important;" data-ng-click="submit()" />
	    				</td>   
					</tr>
				</tbody>
			</table>

		

		<div class="entry_packages">
        	<table width="90%" cellpadding="0" cellspacing="0" class="tableStyleTwo">
          		<tbody>
          			<tr>	
          				<td>Date</td>
			            <td>Time Range</td>		            
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
          			<tr data-ng-repeat="item in items">            			
            			<td>{{item.date}}</td>
            			<td>{{item.time}}</td>
            			<td>{{item.zero}}</td>
             			<td>{{item.one}}</td>
              			<td>{{item.two}}</td>
               			<td>{{item.three}}</td>
                 		<td>{{item.four}}</td>
             			<td>{{item.five}}</td>
              			<td>{{item.six}}</td>
               			<td>{{item.seven}}</td>
                     	<td>{{item.eight}}</td>
             			<td>{{item.nine}}</td>              
          			</tr>          			
         
        		</tbody>
        	</table>
        </div>

	</div>
</div>

</body>
</html>
