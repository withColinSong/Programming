/**
 * 
 */

/* 반드시 미리 선언해야 함
	chk = function() { 
	
	} 
	
	미리 선언하지 않아도 된다. 호이스팅 가능 
	function chk() {
		alert('hi')
	}

*/

chk = function() {
	console.log('하이')
}


function goURL(url) {
	$('#here').load(url);
}

