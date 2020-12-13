/**
 * 
 */

var logInOut = function() {
	/*$('#btnLogin').on('click', function() {
		$('#frm_log').action = "./member/login.jsp"
		$('#frm_log').submit();
	});
	
	$('#btnLogout').on('click', function() {
		location.href = './member/logout.jsp';
	});

*/	
	// js버전
	var btnLogin = document.getElementById('btnLogin');
	var btnLogout = document.getElementById('btnLogout');
	if(btnLogin != null) {
		btnLogin.onclick = function() {
		var frm = document.frm_log;
		frm.action = './member/login.jsp';
		frm.submit(); 
		}
	}
	
	if(btnLogout != null) {
		btnLogout.onclick = function() {
		location.href = './member/logout.jsp';
		}
	}
}