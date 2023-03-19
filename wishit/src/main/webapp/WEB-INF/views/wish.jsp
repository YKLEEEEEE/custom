<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="CP" value="${pageContext.request.contextPath }"></c:set>
<c:set var="RES" value="/resources" ></c:set>
<c:set var="CP_RES" value="${CP}${RES}" ></c:set>
<!DOCTYPE html>
<html>  
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="${CP_RES}/bootstrap/css/bootstrap.min.css">

<!-- jQuery -->
<script src="${CP_RES}/bootstrap/js/jquery-1.12.4.js"></script>
<!-- callAjax -->
<script src="${CP_RES}/bootstrap/js/callAjax.js"></script>
<!-- String, Number, Date Util  -->
<script src="${CP_RES}/bootstrap/js/eUtil.js"></script>
<!-- paging -->
<script src="${CP_RES}/bootstrap/js/jquery.bootpag.js"></script>    
<!-- bootstrap js -->
<script src="${CP_RES}/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">

<style>

.mp0{
    margin: 0px;
    padding: 0px;

}
.tcenter{
    text-align: center;
}
.outer {
  text-align: center;
}
.inner {
  display: inline-block;
}
.padding1{
    padding: 5px;
}
.margin10{
    margin: 10px:
}
.textcenter{
    text-align: center;
}
.divcenter {
    display: inline-block;
    width : 500px;
    height : 100px;
}
.box{
    border: 1px solid #000;
    margin: 10px;
    padding: 10px;
}

</style>

<title>test</title>


<script>
$(document).ready(function(){
	

	
	
	
    $("#dosave").on("click",function(){
        console.log("dosve");
        
        window.location.href = "${CP}/wishtest/moveToReg.do";//======================
        
    });
	
    
    $("#boardTable>tbody").on("dblclick","tr",function(e){
        console.log("#boardTable>tbody");
        let tdArray = $(this).children();
        let busiNumC = tdArray.eq(0).text();
        
        if(confirm("상세 조회를 하시겠습니까?")==false)return;
        let url = "${CP}/wishtest/doSelectOne.do";
        url = url+"?busiNumC="+busiNumC;
        window.location.href = url;
        
        console.log("busiNumC: "+busiNumC);
    });
    
    
    
	
	//==========================조회
    $("#doRetrieve").on("click",function(){
    	console.log("doRetrieve");
        let method = "GET";
        let url    = "/wishtest/doRetrieve.do";
        let async  = true;
        let params = {
            searchWordBn : $('#searchWordBn').val(),
            searchWordC: $('#searchWordC').val(),
        };
        PClass.callAjax(method,url,async,params,function(data){
            console.log(data);
            let parsedJson = JSON.parse(data);
            console.log(parsedJson);
            let htmlData = "";
            
            $("#boardTable>tbody").empty();
            
            if(null != parsedJson && parsedJson.length > 0){
            console.log("-----------------");
            
            $.each(parsedJson,function(index,value){
	            htmlData += "<tr>";
	            htmlData += "  <td class='text-center'>"+<c:out value='value.busiNumC'></c:out>+"</td>";
	            htmlData += "  <td class='text-center'>"+<c:out value='value.custom'></c:out>+"</td>";
	            htmlData += "<tr>";
	            });
            }
            else{
                htmlData += "<tr>";
                htmlData += " <td class='text-center'>";
                htmlData += "   No data found";
                htmlData += " </td>";
                htmlData += "</tr>";
                
                
            }//else
            $("#boardTable>tbody").append(htmlData);
            
        });

    });
	//=========================조회 끝
	
	
});

</script>
</head>
<body>
    <input type="button" id="dosave" name="dosave" value="등록">
    <div class="  outer">
    <div class="divcenter box outer">        
        <table class="inner">
            <tr>
                <td class="padding1">사업자 번호</td>
                <td class="padding1"><input type="text" class="textcenter " name="searchWordBn" id="searchWordBn" placeholder="111-11-11111"></td>
                <td class="padding1">&nbsp;</td>
            </tr>
            <tr>
                <td class="padding1">거래처명</td>
                <td class="padding1"><input type="text" class="textcenter " name="searchWordC" id="searchWordC" placeholder="롯데마트"></td>
                <td class="padding1"><input type="button" id="doRetrieve" value="조회"></td>
            </tr>
        </table>
    </div>
    </div >
    <div class=" outer">
    <div class="divcenter mp0">
	    <table class="table table-bordered mp0" id="boardTable">
	      <thead class="mp0">
	        <tr>
	          <th class="text-center col-sm-5">사업자번호</th>
	          <th class="text-center col-sm-7">거래처명</th>
	        </tr>
	      </thead>
	      <tbody>
	
	      </tbody>
	    </table>
    </div>
    </div>
</body>
</html>