/**
 * 방명록에서 사용되는 스크립트
 * 작성자 : it여행자
 * 작성일 : 2020.12
 */

var guestbook = function(){

	// -------------------------------------------
	// 방명록 입력 버튼이 클릭된 경우 
	// -------------------------------------------
	var btnInsert = document.getElementById('btnInsert');
	
	//방법1
	if(btnInsert != null){
		btnInsert.onclick = function(){
			var frm = document.frm_gb_insert;
			frm.action = './guestbook/insert_result.jsp';
			frm.submit();
		}
	}
}

// -------------------------------------------
// 방명록 삭제 버튼 클릭
// -------------------------------------------
function funcDelete(frm){
	let pwd = prompt("방명록을 삭제하시리면 작성시 암호를 입력해 주세용.");
	frm.pwd.value = pwd;
	frm.action = './guestbook/delete_result.jsp';
	frm.submit();
}

//-------------------------------------------
//방명록 수정 버튼 클릭
//-------------------------------------------
function funcUpdate(frm){
	if(frm.btnUpdate.value=='수정'){
		frm.doc.disabled=false; 
		frm.btnUpdate.value='수정내용저장';
	}else if(frm.btnUpdate.value=='수정내용저장'){
		let pwd = prompt("수정된 내용을 저장하시려면 암호를 입력하세요");
		frm.pwd.value = pwd;
		frm.action = './guestbook/update_result.jsp';
		frm.submit();
	}
}













