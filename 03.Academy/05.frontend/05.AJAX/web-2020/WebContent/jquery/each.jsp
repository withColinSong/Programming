<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>each</title>

</head>
<body>
<div id='each'>
	<div id='source'>
		<div><font color='red'>가</font></div>
		<div>나</div>
		<div>다</div>
		<div>라</div>
	</div>
	
	<div id='target'>...</div>
	
	<div id='btns'>
		<input type='button' value='SIZE' id='btnSize' />
		<input type='button' value='TEXT' id='btnText' />
		<input type='button' value='HTML' id='btnHtml' /> 
		<input type='button' value='EACH' id='btnEach' />
	</div>
</div>
<script>
$('#each #btnEach')[0].onclick = function(){
	let bg = ['#00f', '#44f', '#88f', '#aaf'];
	$('#each>#source>div').each(function(index){
		$(this).css('background-color', bg[index]);
	});
}


$('#each #btnText')[0].onclick = function(){
	//var div = $('#each>#source>div:first');
	//var div = $('#each>#source>div').first();
	var div = $('#each>#source>div').get(0);
	var text = $(div).text();
	$('#each #target').text(text);
}

$('#each #btnHtml')[0].onclick = function(){
	let div = $('#each>#source>div:first'); 
	let html = $(div).html(); 
	$('#each #target').html(html);
}






$('#target').css({
	'border' : '2px solid #aaa',
	'padding': '35px'
})
$('#each #btnSize')[0].onclick = function(){
   var len = $('#each>#source>div').length; //.length
   $('#each>#target').html('div 개수 : ' + len);
}

</script>

</body>
</html>



