function getID(id) { return document.getElementById(id) }

var board = function() {

	var frm = document.frm_board;
	var url = 'index.jsp?inc=./board/';
	
	
	// 입력화면
	var btnInsert = getID('btnInsert'); 
	var btnSelect = getID('btnSelect'); 
	var btnSave = getID('btnSave'); 
	
	// 페이지 고정
	var btnFind = getID('btnFind');
	
	if(btnFind != null) {
		btnFind.onclick = function() {
			frm.nowPage.value = 1;
			frm.action = url + 'select.jsp';
			frm.submit();
		}
	}

	// btnSave, result.jsp로 이동 : 입력화면 
	if(btnSave != null) {
		btnSave.onclick = function() {
			frm.action = url + 'result.jsp';
			frm.submit();
		
		}
	}
	
	// btnSelect, select.jsp로 이동 : 입력화면 
	if(btnSelect != null) {
		btnSelect.onclick = function() {
			frm.action = url + 'select.jsp';
			frm.submit();
		}
	}
	
	// btnInsert, insert.jsp로 이동 : 입력화면 
	
	if(btnInsert != null) {
		btnInsert.onclick = function() {
			frm.action = url +  'insert.jsp';
			frm.submit();
		}
		
	}
	
}