<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.oat.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>APTITUDE TEST</title>
</style>
<%--<script language ="javascript" >
        var tim;       
        var min = '${sessionScope.min}';
        var sec = '${sessionScope.sec}';
       
        
        function customSubmit(someValue){  
        	 document.questionForm.minute.value = min;   
        	 document.questionForm.second.value = sec; 
        	 document.questionForm.submit();  
        	 }  
			
        function examTimer() {
            if (parseInt(sec) >0) {
			
			    document.getElementById("showtime").innerHTML = "Time Remaining :"+min+" Minute ," + sec+" Seconds";
                sec = parseInt(sec) - 1;                
                tim = setTimeout("examTimer()", 1000);
            }
            else {
			
			    if (parseInt(min)==0 && parseInt(sec)==0){
			    	document.getElementById("showtime").innerHTML = "Time Remaining :"+min+" Minute ," + sec+" Seconds";
				     alert("Time Up");
				     document.questionForm.minute.value=0;
				     document.questionForm.second.value=0;
				     document.questionForm.submit();
					 
			     }
				 
                if (parseInt(sec) == 0) {				
				    document.getElementById("showtime").innerHTML = "Time Remaining :"+min+" Minute ," + sec+" Seconds";					
                    min = parseInt(min) - 1;
					sec=59;
                    tim = setTimeout("examTimer()", 1000);
                }
               
            }
        }
    </script>--%>

<%-- <script>
		var sec = 10;   // set the seconds
		var min =00;   // set the minutes	
  		
  		
		function countDown() {
		   sec--;

		   if (sec == -01)
		   {
			   sec = 59;
			   min = min - 1; 
		   }
		   else { min = min; }

		   if (sec<=9) 
		   { 
			   sec = "0" + sec; 
		   }
		   

		   time = (min<=9 ? "0" + min : min)+ " : " + sec ;
		   timeLeft = time;

		   if (document.getElementById)
		   { 
		   		theTime.innerHTML = time; 
		   }

		   SD=window.setTimeout("countDown();", 1000);

   		   // To check time is over or not		   
		   if (imin == '00' && sec == '00') 
		   { 
			   
		   }
		}
	</script>--%>
<style type="text/css">
<%--
 .timeClass {
  font-family:arial,verdana,helvetica,sans-serif;
  font-weight:normal;
  font-size:10pt;
  }
--%>
</style> 
<script type="text/javascript">
function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    setInterval(function () {
        minutes = parseInt(timer / 60, 10)
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) 
        {
            timer = duration;
        }
    }, 1000);
}

window.onload = function ()
{
    var fiveMinutes = 60 * 1,
        display = document.querySelector('#time');
    startTimer(fiveMinutes, display);
};
if(minutes == '00' && seconds == '00')
{
	 document.questionForm.submit();
}
</script>
</head>

<body>

<h1 style="text-align:center;">APTITUDE TEST</h1>
<form method="post" action="OATController" name="questionForm">
<br>
<div align="right"><h4>Remaining Time</h4><span id="time"></span> minutes!   
</div> 
<table>
		 <tr><td width="100%" align="right"><span id="theTime" class="timeClass"></span></td></tr>		
</table>
<%--<script type="text/javascript">window.onload = examTimer();</script>--%> 

<fieldset>
<h3>Enter Your username before beginning the test:</h3>
<label for="username"><b>Username</b></label>
<input type="text" placeholder="Enter your Username" name="username" required>
</fieldset>
<% ArrayList<String>answers=new ArrayList<String>(); %>
<% ArrayList<OATBean> al=(ArrayList<OATBean>)session.getAttribute("OATal"); %>
<% for(int i=0;i<al.size();i++){ %>
<% OATBean bean = (OATBean)al.get(i); %>
<table>
<tr><h3><%= bean.getQ_Paper_ID() %>.<%= bean.getQuestion() %></h3>
<input type="hidden" name="questionid" value="<%= bean.getquestion_ID() %>"/>
<td><input type="radio"name="<%=i%>" value="<%= bean.getOption1() %>"><%= bean.getOption1() %></td>
<td><input type="radio"name="<%=i%>" value="<%= bean.getOption2() %>"><%= bean.getOption2() %></td>
<td><input type="radio"name="<%=i%>" value="<%= bean.getOption3() %>"><%=bean.getOption3() %></td>
<td><input type="radio"name="<%=i%>" value="<%= bean.getOption4() %>"><%= bean.getOption4() %></td>
</table>
<%} %>
<br>
<br>
<%-- <center><input type="submit" name="complete" value="Finish Exam" onclick="customSubmit()" /></center>--%>
<center><button type="submit" name="complete">Submit</button></center>
</form>
</body>
</html>