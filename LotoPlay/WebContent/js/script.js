$(function() {  	
	
	
	/************* Time Change ******************/
	
	setInterval(function() { 
		
		var date    = new Date();
		var hour    = date.getHours();  
		var minutes = date.getMinutes();  
		
		var totalMinutes = hour * 60 + minutes;  
		
		if (totalMinutes >= 675 && totalMinutes < 885)		
			$('#timeRange').html('<option>11:15AM</option>');  //  11:15AM - 2:45PM
		else if (totalMinutes >= 885 && totalMinutes < 1155)
			$('#timeRange').html('<option>2:45PM</option>');   //  2:45PM - 7:15PM
		else if (totalMinutes >= 1155 || totalMinutes < 675)
			$('#timeRange').html('<option>7:15PM</option>');  //  7:15PM - 11:15AM
		
	}, 1000);
	
	/********************************************/
	
	$('form#input').submit(function(event) {		
		
		event.preventDefault();	
		
		var r = confirm("Press OK to Submit.");
		
		if (r == true) {
			
			var formData = new FormData($(this)[0]);
			
			$.ajax({
			    url: 'InsertPlayData',
			    type: 'POST',
			    data: formData,
			    async: false,
			    cache: false,
			    contentType: false,
			    processData: false,
			    success: function (data) {   
			    	
			    	$('#totalAmount').html(data.totalAmount);
			    	
			    	$('#zero')       .html(data.zero); 
			    	$('#one')        .html(data.one);
			    	$('#two')        .html(data.two);
			    	$('#three')      .html(data.three);
			    	$('#four')       .html(data.four);
			    	$('#five')       .html(data.five);
			    	$('#six')        .html(data.six);
			    	$('#seven')      .html(data.seven);
			    	$('#eight')      .html(data.eight);
			    	$('#nine')       .html(data.nine);
			    	
			    	$("input[name=zero]")  .val('');
			    	$("input[name=one]")   .val('');
			    	$("input[name=two]")   .val('');
			    	$("input[name=three]") .val('');
			    	$("input[name=four]")  .val('');
			    	$("input[name=five]")  .val('');
			    	$("input[name=six]")   .val('');
			    	$("input[name=seven]") .val('');
			    	$("input[name=eight]") .val('');
			    	$("input[name=nine]")  .val(''); 
			    	
			    	$('td#print').empty();
			    	$('td#print').append('<a href="Print?id=' + data.id + '" class="btn btn-success" style="background-image: linear-gradient(#068EDE, #32628C 60%, #346199) !important;text-decoration:none;border: 1px solid #0B5786 !important; padding: 5px 17px;"> Print  </a>');
			    },
			  	error: function() {
			  		
			  	}
			  });
			
		} // if
		
		
		return false;
	});
	
	$('#reset').click(function() {  
		
		$('#totalAmount').html('000');
	});
	
	
	
	
	
	/******************* Total Count ***********************/
	
	$("input[name=zero]")  .bind("keypress", {}, keypressInBox);
	$("input[name=one]")   .bind("keypress", {}, keypressInBox);
	$("input[name=two]")   .bind("keypress", {}, keypressInBox);
	$("input[name=three]") .bind("keypress", {}, keypressInBox);
	$("input[name=four]")  .bind("keypress", {}, keypressInBox);
	$("input[name=five]")  .bind("keypress", {}, keypressInBox);
	$("input[name=six]")   .bind("keypress", {}, keypressInBox);
	$("input[name=seven]") .bind("keypress", {}, keypressInBox);
	$("input[name=eight]") .bind("keypress", {}, keypressInBox);
	$("input[name=nine]")  .bind("keypress", {}, keypressInBox);
	

	function keypressInBox(e) {
		
	    var code = (e.keyCode ? e.keyCode : e.which); // different browsers
	    
	    if (code == 13) {        
	    	
	        e.preventDefault();

	        var zero  = parserToNumber($("input[name=zero]").val());
	        var one   = parserToNumber($("input[name=one]").val());
	        var two   = parserToNumber($("input[name=two]").val());
	        var three = parserToNumber($("input[name=three]").val());
	        var four  = parserToNumber($("input[name=four]").val());
	        var five  = parserToNumber($("input[name=five]").val());
	        var six   = parserToNumber($("input[name=six]").val());
	        var seven = parserToNumber($("input[name=seven]").val());
	        var eight = parserToNumber($("input[name=eight]").val());
	        var nine  = parserToNumber($("input[name=nine]").val()); 
	        
	        var total = (zero + one + two + three + four + five + six + seven + eight + nine) * 10;	        
	        
	        $('#subTotal').html(total);
	    }
	};
	
	function parserToNumber(input) {
		
		if (input == '1' || input == '2' || input == '3' || input == '4' || input == '5' || input == '6' || input == '7' || 
				input == '8' || input == '9') {
			
			return parseInt(input);
		}
		
		else {
			
			return 0;
		}
	};
	
	
	
	/************ Date *************/
	
	var date = new Date();
	document.getElementById("date").innerHTML = date.toDateString();
	
	/************ Time **************/
	
	function checkTime(i) {
		
	       return (i < 10) ? "0" + i : i;
	};

    function startTime() {
    	
    	var today = new Date();
    	
        h = checkTime(today.getHours());
        m = checkTime(today.getMinutes());
        s = checkTime(today.getSeconds());
        
        document.getElementById('time').innerHTML = h + ":" + m + ":" + s;
        
        setTimeout(function () {
           startTime();
        }, 500);
   };
   
   startTime();
	
});




	   
	

