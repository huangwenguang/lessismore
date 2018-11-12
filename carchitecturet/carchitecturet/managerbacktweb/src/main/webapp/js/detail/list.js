function search(){
	$("#submit-form").submit();
}
var del = function(requesturl, id){
	bootbox.confirm("你确定删除吗?", function (result) {
        if (result) {
        	var url = "del.do";
    		var sendData = {
    				"id": id
    			};
    			$.post(url,sendData, function(backData) {
    				if(backData.status == 1){
    					//$("#submit-form").submit();       					
    					window.location.href = "list.do?cid="+backData.data;
    				} else{
    					warningAlert(backData.message[0].msg);
    				}
    			});
        }
    });
}

var edit = function(url, id){
	 window.location.href = "edit.do?id="+id;
}

var down = function(url, id){
	 window.location.href = "down.do?id="+id;
}

var share = function(id){
	//閼惧嘲褰囪ぐ鎾冲缂冩垵娼冮敍灞筋渾閿涳拷http://localhost:8083/uimcardprj/share/meun.jsp  
    var curWwwPath = window.document.location.href;  
    //閼惧嘲褰囨稉缁樻簚閸︽澘娼冩稊瀣倵閻ㄥ嫮娲拌ぐ鏇礉婵″偊绱�uimcardprj/share/meun.jsp  
    var pathName = window.document.location.pathname;  
   
    var pos = curWwwPath.indexOf(pathName);  
    //閼惧嘲褰囨稉缁樻簚閸︽澘娼冮敍灞筋渾閿涳拷http://localhost:8083  
    var localhostPaht = curWwwPath.substring(0,pos);  
    //閼惧嘲褰囩敮锟�"閻ㄥ嫰銆嶉惄顔兼倳閿涘苯顪嗛敍锟絬imcardprj  
    var projectName= pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    var url = localhostPaht + projectName +"/file/down.do?id="+id;
	
    $("#url").html(url);
    $("#mymodal").modal("toggle");
}