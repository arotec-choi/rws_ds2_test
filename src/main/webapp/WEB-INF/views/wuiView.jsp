<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style type="text/css">
	.myButton {
	background-color:#44c767;
	border-radius:28px;
	border:1px solid #18ab29;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:17px;
	padding:16px 31px;
	text-decoration:none;
	text-shadow:0px 1px 0px #2f6627;
}
.myButton:hover {
	background-color:#5cbf2a;
}
.myButton:active {
	position:relative;
	top:1px;
}
	</style>
	
	<style type="text/css">
		#wrap{
			margin: 0 auto;
			width: 1500px;
			height: 600px;
		}
	</style>
	
	<link rel="stylesheet" type="text/css"
	href="/resources/css/w2ui-1.5.css">
	<script src="/resources/js/jquery-3.3.1.min.js"></script>
	<script src="/resources/js/w2ui-1.5.js"></script>
			
</head>
<body>
<a href="rws_ds2" class="myButton">처음으로</a>
	<div>
	<div id="detail">
	<script type="text/javascript">
	$(document).ready(function(){
		var number = 0;
		
		var pstyle = 'background:#add6ff';
		$('#wrap').w2grid({
			recordHeight : 30,
			autoLoad: false,
			header : "wuiVIW 페이지 입니다.",
			show : {
	              toolbar:true
	            , footer:true
	            , selectColumn:true
	            , header : true
	            , footer : true
	            , lineNumbers : true
	            , expandColumn : true 
	            , selectColumn : true
	            , emptyRecords : false
	            , toolbarAdd : true			// 등록버튼
	            , toolbarDelete  : true		// 삭제버튼
	            , toolbarSave    : false		// 저장버튼
	            , toolbarEdit:true           // 수정 버튼
	            , recordTitles   : true
	        },
	        	multiSearch:false,
	        	searches : [
	        	         {field:'NAME', caption:'NAME', size:'40%',editable:{ type:"text" }, sortable:true}
	                ],
	        recid:"FLOWMTR_ID",
			name:'grid',
			url : 'viewData',
			method : 'post',
			dataType:"json",			
			columns:[
			         {field:'FLOWMTR_ID', caption:'FLOWMTR_ID', size:'75%'},
			         {field:'NAME', caption:'NAME', size:'40%',editable:{ type:"text" }, sortable:true},
			         {field:'INST_DATE', caption:'INST_DATE', size:'65%',editable:{ type:"text" }},
			         {field:'FMETE_FORM', caption:'FMETE_FORM', size:'70%',editable:{ type:"text" }},
			         {field:'FMETE_TYPE', caption:'FMETE_TYPE', size:'70%',editable:{ type:"text" }},
			         {field:'WTRSYS', caption:'WTRSYS', size:'55%',editable:{ type:"text" }},
			         {field:'AUTO_TYPE', caption:'AUTO_TYPE', size:'65%',editable:{ type:"text" }},
			         {field:'PIPE_DIA', caption:'PIPE_DIA', size:'65%',editable:{ type:"text" }},
			         {field:'PIPE_ID', caption:'PIPE_ID', size:'65%',editable:{ type:"text" }},
			         {field:'IN_AREA', caption:'IN_AREA', size:'65%',editable:{ type:"text" }},
			         {field:'OUT_AREA', caption:'OUT_AREA', size:'65%',editable:{ type:"text" }},
			         {field:'ADDR', caption:'ADDR', size:'40%',editable:{ type:"text" }},
			         {field:'REMARK', caption:'REMARK', size:'40%'},
			         {field:'SBLOCK_ID', caption:'SBLOCK_ID', size:'70%',editable:{ type:"text" }},
			         {field:'OFFICE_ID', caption:'OFFICE_ID', size:'70%',editable:{ type:"text" }},
			         {field:'STD_WHMR_V', caption:'STD_WHMR_V', size:'70%',editable:{ type:"int", min:0, max:99999999}},
			         {field:'FAC_NAME', caption:'FAC_NAME', size:'70%',editable:{ type:"text" }},
			         {field:'DATA_TYPE', caption:'DATA_TYPE', size:'70%',editable:{ type:"text" }},
			         {field:'OUT_ZONE', caption:'OUT_ZONE', size:'70%',editable:{ type:"text" }},
			         {field:'FLSY_NAME', caption:'FLSY_NAME', size:'70%',editable:{ type:"text" }},
			         {field:'GIS_CODE', caption:'GIS_CODE', size:'70%',editable:{ type:"text" }},
			         {field:'TSMTR_DATE', caption:'TSMTR_DATE', size:'70%',editable:{ type:"text" }},
			         {field:'OFFICE', caption:'OFFICE', size:'40%',editable:{ type:"text" }},
			         {field:'J_BLOCK', caption:'J_BLOCK', size:'70%',editable:{ type:"text" }},
			         {field:'S_BLOCK', caption:'S_BLOCK', size:'70%',editable:{ type:"text" }},
			         {field:'STD_WHMR', caption:'STD_WHMR', size:'70%',editable:{ type:"text" }},
			         {field:'USE_CLA', caption:'USE_CLA', size:'70%',editable:{ type:"int", min:0, max:99999999},hidden:true},
			         {field:'REP_CHK', caption:'REP_CHK', size:'70%', editable:{ type:"checkbox" }},
			         {field:'CMC_ERR_VALUE', caption:'CMC_ERR_VALUE', size:'70%',editable:{ type:"int", min:0, max:99999999}}
						
			         ],
			         
			          onAdd:function(event) {
			             w2alert("그리드에 행을 추가합니다.", "추가");
			         }
			         , onEdit:function(event) {
			        				        		 
			        	 w2alert("수정합니다.", "수정");
			             //stringify는 배열을 문자열json으로 바꿔준다.
			            // var record = JSON.stringify(this.get(event.recid));	
			             var record = this.get(event.recid);
			             //수정한 데이터만 json으로 변환
			             var dataChanges = JSON.stringify(w2ui['grid'].getChanges());
			             console.log("aaaaa"+record);
			             console.log("수정값"+dataChanges);
			             $.ajax({
			                 type: "post", 
			                 url: "/dataModify",
			                  dataType: "json", 
			                 contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			                 data:{dataList : dataChanges},

					         postData: {
					             param1 : 'value1',
					             param2 : 'value2'
					         },
			                 success:function(data){
								console.log("수정되었습니다");
			                	// w2alert('수정되었습니다.');
			                	 
			             	}, 
			             	error:function(){
								
									w2alert('수정실패');	
								
			             		

			             	}       
			             });
			         	console.log("event"+event);
			        	         
			         }
			         , onDelete:function(event) {
			             console.log("삭제합니다.");
			         }
			         , onSave:function(event) {
			             w2alert("그리드의 변경사항을 저장합니다.", "저장");
			            
			         },		
			    /*      onDblClick : function(event) {
			        	 var record = this.get(event.recid);
			        	 console.log(record.FLOWMTR_ID);
			        	 w2popup.load({url:'wuiEdit',title:'수정페이지', showMax:true, height:'500px', width:'500px'})
			        	 
					} */
					
			        		         
		})
				
	})
	
	
	</script>
	
	
	
	</div>



	<div id="wrap"></div>
</div>

</body>

</html>