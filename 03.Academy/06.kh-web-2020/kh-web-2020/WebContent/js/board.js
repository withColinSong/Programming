function getID(id) { return document.getElementById(id) }

var board = function() {

	var frm = document.frm_board;
	var url = 'index.jsp?inc=./board/';
	
	
	// 입력 화면
	var btnInsert = getID('btnInsert'); 
	var btnSelect = getID('btnSelect'); 
	var btnSave = getID('btnSave'); 
	
	// 페이지 고정
	var btnFind = getID('btnFind');
	
	// 삭제 버튼
	var btnDelete = getID('btnDelete');
	
	// 수정 버튼 (view.jsp 안에 있는 수정 버튼)
	var btnModify = getID('btnModify');
	
	// 수정 버튼 (update.jsp) 
	var btnUpdate = getID('btnUpdate');
	
	// 댓글 버튼으로 이동 (view.jsp)
	var btnRepl = getID('btnRepl');
	if(btnRepl != null) {
		btnRepl.onclick = function() {
			frm.action = url + "repl.jsp";
			frm.submit();
		}
	}
	
	// 댓글 저장 버튼 (repl.jsp)
	var btnReplSave = getID('btnReplSave'); 
	
	if(btnReplSave != null) {
		btnReplSave.onclick = function() {
		frm.action = url + "result.jsp";
		frm.submit();
		
		}
	}
	
	if(btnUpdate != null) {
		btnUpdate.onclick = function() {
			var pwd = prompt("수정하려면 암호를 입력하세요.");
			if(pwd != null ) {
				frm.pwd.value = pwd;
				frm.action = url + "result.jsp";
				frm.submit();
			}
			
		}
	}
	
	if(btnModify != null) {
		btnModify.onclick = function() {
			frm.action = url + "update.jsp";
			frm.submit();
		}
	}
	
	
	if(btnDelete != null) {
		btnDelete.onclick = function() {
			var yesNo = confirm("정말 삭제하시겠습니까?");
			if(yesNo) {
				frm.action = url + "result.jsp";
				frm.submit();
			}
		}
	}
	
	
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
	
} //member 끝

// 페이지 이동
function goPage(page) {
	var frm = document.frm_board;
	frm.nowPage.value = page;
	frm.action = "index.jsp?inc=./board/select.jsp";
	frm.submit();
}

function view(serial) {
	var frm = document.frm_board;
	frm.serial.value = serial;
	frm.action = "index.jsp?inc=./board/view.jsp";
	frm.submit();
	
}

