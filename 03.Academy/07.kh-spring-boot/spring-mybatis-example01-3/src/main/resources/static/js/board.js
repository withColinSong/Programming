/**
 * 게시판에서 사용하는 스크립트

js 즉시 실행하는 함수
함수 전체를 () 씌워줌.
(함수)();
 */


brd = function() {
	
	
	$('#btnFind').on('click', function(){
		var param = $('#frm_board').serialize();
		console.log(param);
		
		// $('#here').load('/BInsert', param); 같은 코드
		
		$.ajax ({
			url: '/bSelect',
			data : param,
			dataType: 'html',
			method : 'POST',
			success: function(data) {
				console.log(data)
				$('#here').html(data);
			}
			
		});
	});
	
	
	$('#btnInsert').on('click', function(){
		console.log('테스트')
		var param = $('#frm_board').serialize();
		
		$('#here').load('/BInsert', param); // 참고 : get방식으로 전송된다

	});
	
		$('#btnSave').on('click', function(){
		
		var frm = $('#frm_board')[0];
		frm.enctype='multipart/form-data';
		
		var data = new FormData(frm);

		$.ajax ({
			url: '/bInsertR',
			data : data,
			dataType: 'html',
			method : 'POST',
			processData : false,
			contentType: false,
			success: function(data) {
				console.log(data)
				$('#here').html(data);
			}
			
		});
	});
	
};