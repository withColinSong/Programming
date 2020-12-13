<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>drop</title>
<link rel='stylesheet' type='text/css'
   href='https://code.jquery.com/ui/1.12.1/themes/south-street/jquery-ui.css'/>
<script src='http://code.jquery.com/ui/1.12.1/jquery-ui.js'></script>
<style>
.abc{
	background-color:#aaa;
}
#drop>div{
	border:2px solid #00f;
}
#drag{ width:100px; height:100px}
#droppable{ width:300px ; height:300px;}
</style>
</head>
<body>
<div id='drop'>
	<div id='drag'>이부분을 옮겨 보세요</div>

	<div id='droppable'>여기에 떨어뜨리세요~~</div>
</div>

<script>
	$('#drag').draggable();
	$('#droppable').droppable({
		drop : function(){
			$(this).addClass('abc'); //$(this).attr('class', 'abc')
			$(this).html('참 잘했어요~~~')
		},
		out : function(){
			$(this).html('어디가세요????');
			$(this).removeAttr('class');
		}
	})
</script>
</body>
</html>




