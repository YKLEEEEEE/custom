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
<!-- jQuery -->
<script src="${CP_RES}/bootstrap/js/jquery-1.12.4.js"></script>
<!-- callAjax -->
<script src="${CP_RES}/bootstrap/js/callAjax.js"></script>


<style>
.box{
    border: 1px solid #000;
    padding: 10px;
    margin: 0px;
}
</style>
<title>Insert title here</title>
<script>
function setParentText(){
	opener.document.getElementById("countryEng").value = $.trim(document.getElementById("countryEng").value)
    opener.document.getElementById("countryKor").value = $.trim(document.getElementById("countryKor").value)
    window.close()
}


$(document).ready(function(){
    $("#boardTable>tbody").on("dblclick","tr",function(e){
        console.log("#boardTable>tbody");
        let tdArray = $(this).children();
        let countryEng = tdArray.eq(0).text();
        let countryKor = tdArray.eq(1).text();
        
        $("#countryEng").val(countryEng);
        $("#countryKor").val(countryKor);
        
        console.log("$('#countryEng').val(countryEng): "+$("#countryEng").val());
        console.log("countryEng: "+countryEng);
        console.log("countryKor: "+countryKor);
    });
});


</script>
</head>
<body>
<h2>국가</h2>
    <br>
	    <input type="text" readonly="readonly" id="countryEng">
	    <input type="text" readonly="readonly" id="countryKor">
	    <input type="button" onclick="setParentText()" value="확인">
    <table id="boardTable">

        <thead>
            <tr>
                <th class="box">
                    <label>영문 국가명</label>
                </th>
                <th class="box" style="width: 200px;">
                    <label>한글 국가명</label>
                </th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td class="box">
                    <label>KOR</label>
                </td>
                <td class="box" style="width: 200px;">
                    <label>대한민국</label>
                </td>
            </tr>
            <tr>
                <td class="box">
                    <label>CN</label>
                </td>
                <td class="box" style="width: 200px;">
                    <label>중국</label>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>