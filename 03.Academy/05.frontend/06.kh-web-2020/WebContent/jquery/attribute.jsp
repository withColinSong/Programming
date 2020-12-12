<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attribute</title>
<style>
	#target{
		border:1px solid #aaa;
		width:400px;
		height:200px;
	}
  .a_type{
  	background-color:#00f;
  	color:#fff;
  }
  .a_type>h1{
  	color : #fff;
  	font-family:궁서체;
  }
  
  .b_type{
  	background-color :#f99;
  	color:#ff0;
  }
  
  .b_type>h1{
  	color:#ff0;
  	font-family:명조체
  }
</style>

</head>
<body>
<div id='attr'>
	<div id='target'>
		<h1>Jquery Attr</h1>
	</div>

	<div id='btns'>
		<input type='button' value='A Type' id='btnAtype' />
		<input type='button' value='B Type' id='btnBtype' />
		<input type='button' value='Inite'  id='btnInite' />
	</div>
</div>
<script>
// A, B type에 click event 추가
var target = $('#attr>#target');
$('#attr #btnAtype')[0].onclick = function(){
	$(target).attr('class', 'a_type');
}

$('#attr #btnBtype')[0].onclick = function(){
	$(target).attr('class', 'b_type');
}
$('#attr #btnInite')[0].onclick = function(){
	$(target).attr('class', '');
}


</script>




</body>
</html>



