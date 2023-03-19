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
.box{
    border: 1px solid #000;
    margin: 10px;
    padding: 10px;
}
.wideset{
    width: 25%
}


</style>

<title>test</title>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>


$.trim($("#trimtest").val());

function countrySearch(){
    var url = "pop.do";
    var name = "popup test";
    var option = "width = 500, height = 500, top = 100, left = 200, location = no"
    window.open(url, name, option);
}//==========팝업끝


function sample6_execDaumPostcode() {
    $("#postNum").empty();
    $("#addr1").empty();
    $("#addr2").empty();
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }

            
            } 

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postNum').value = data.zonecode;
            document.getElementById("addr1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addr2").focus();
        }
    }).open();
}//==================================주소 api



//===========================================ready
$(document).ready(function(){

	//$("#taxYn").val("${vo.taxYn }").prop("selected", true);
	
	
        
    $("#doUpdate").on("click",function(){
        if($('#specialRelation').is(':checked')==true){
            $("#specialRelation").val("1");
        }else{
            $("#specialRelation").val("2");
        }
        console.log($("#specialRelation").val());
        if($('#tradeStop').is(':checked')==true){
            $("#tradeStop").val("1");
        }else{
            $("#tradeStop").val("2");
        }
    	
    	console.log("doUpdate");
    	if(confirm("수정하시겠습니까?") == false)return;
    	
    	
        let method  = "POST";
        let url     = "/wishtest/doUpdate.do";
        let async   = true;
        let params  ={
                busiNumC : $("#busiNumC").val(),
                custom : $("#custom").val(),
                shortN : $("#shortN").val(),
                ceo : $("#ceo").val(),
                chargePerson : $("#chargePerson").val(),
                busiCondition : $("#busiCondition").val(),
                item : $("#item").val(),
                postNum : $("#postNum").val(),
                addr1 : $("#addr1").val(),
                addr2 : $("#addr2").val(),
                tel : $("#tel").val(),
                fax : $("#fax").val(),
                homePage : $("#homePage").val(),
                coYn : $('input[id="coYn"]:checked').val(),
                foreignYn : $('input[id="foreignYn"]:checked').val(),
                taxYn : $("#taxYn").val(),
                countryEng : $.trim($("#countryEng").val()),
                countryKor : $.trim($("#countryKor").val()),
                specialRelation : $("#specialRelation").val(),
                tradeStop : $("#tradeStop").val(),
                contractPeriodS : $("#contractPeriodS").val(),
                contractPeriodE : $("#contractPeriodE").val(),
                regiInfoMan : $("#regiInfoMan").val(),
                modiInfoMan : $("#modiInfoMan").val(),
                busiNumA : $("#busiNumC").val(),
                factory : $("#factory").val(),
                tradeBank : $("#tradeBank").val(),
                accountNum : $("#accountNum").val()
        };
        PClass.callAjax(method,url,async,params,function(data){
            console.log(data);
            let parsedJson = JSON.parse(data);
            if("1" == parsedJson.msgId){
                alert(parsedJson.msgContents);
                moveToList();
            }else{
                alert(parsedJson.msgContents);
            }
        });
    });//=============수정
	
	
	
    
    
    $("#doDelete").on("click",function(){
    	console.log("doDelete");
    	if(confirm("삭제 하시겠습니까?") == false)return;
        let method = "GET";
        let url    = "/wishtest/doDelete.do";
        let async  = true;
        let params ={
        	busiNumC: $("#busiNumC").val(),
        	busiNumA: $("#busiNumC").val()
        };
        PClass.callAjax(method,url,async,params,function(data){
            console.log(data);
            let parsedJson = JSON.parse(data);
            if("1" == parsedJson.msgId){
              alert(parsedJson.msgContents);
              moveToList();
            }else{
              alert(parsedJson.msgContents);
            }
         });//=========================================PClass.callAjax끝

    });//===========================doDelete끝
    

    
});
    
function moveToList(){
    window.location.href="${CP}/wishtest/wish.do";
}

</script>
</head>
<body>
<form action='a.jsp'>
<div>
    <div>
	    <div>
	    
	        <input type='reset'>
	        <input type="button" id="doUpdate" value="수정">
	        <input type="button" id="doDelete" value="삭제">
	    </div>
        <table class="box">
            <tr class="text-center col-sm-12 col-dm-12 col-lg-12">
                <td class="text-center">사업자번호</td>
                <td><input type="text" id=busiNumC placeholder="111-11-11111" value="${vo.busiNumC }"></td>
                <td class="text-center ">약 칭</td>
                <td><input type="text"  id="shortN" placeholder="롯데마트" value="${vo.shortN }"></td>
            </tr>
            <tr class="text-center col-sm-12 col-dm-12 col-lg-12">
                <td class="text-center">거래처 명</td>
                <td><input type="text" id="custom" placeholder="롯데마트" value="${vo.custom }"></td>
            </tr>
            <tr class="text-center col-sm-12 col-dm-12 col-lg-12">
                <td class="text-center" >대 표 자</td>
                <td><input type="text" id="ceo" placeholder="홍길동" value="${vo.ceo }"></td>
                <td class="text-center">담 당 자</td>
                <td><input type="text" id="chargePerson" placeholder="홍길동" value="${vo.chargePerson }"></td>
            </tr>
            <tr class="text-center col-sm-12 col-dm-12 col-lg-12">
                <td class="text-center">업 태</td>
                <td><input type="text" id="busiCondition" value="${vo.busiCondition }"></td>
                <td class="text-center">종목</td>
                <td><input type="text" id="item" value="${vo.item }"></td>
            </tr>
            <tr class="text-center col-sm-12 col-dm-12 col-lg-12">
                <td class="text-center">우편번호</td>
                <td><input type="text" id="postNum" value="${vo.postNum }"readonly="readonly"></td><!-- readonly="readonly"  -->
                <td><input type="button" value="검색" onclick="sample6_execDaumPostcode()"></td>
                <td class="text-center">주소1</td>
                <td><input type="text" id="addr1" value="${vo.addr1 }" readonly="readonly"></td>
            </tr>
            <tr class="text-center col-sm-12 col-dm-12 col-lg-12">
                <td class="text-center">주소2</td>
                <td><input type="text" id="addr2" value="${vo.addr2 }"></td>
            </tr>
            <tr class="text-center col-sm-12 col-dm-12 col-lg-12">
                <td class="text-center">전화번호</td>
                <td><input type="text" id="tel" value="${vo.tel }"></td>
                <td class="text-center">팩스번호</td>
                <td><input type="text" id="fax" value="${vo.fax }"></td>
            </tr>
            <tr class="text-center col-sm-12 col-dm-12 col-lg-12">
                <td class="text-center">홈페이지</td>
                <td><input type="text" id="homePage" value="${vo.homePage }"></td>
            </tr>

            <tr class="col-sm-12 col-dm-12 col-lg-12" style="dispaly:flex;">
                <td class="wideset">
                <label>법인여부</label>
                </td>
                <td class="box wideset">
                <c:choose>
                    <c:when test="${vo.coYn == '1'}">
	                    <fieldset>
	                    <label>
	                      <span>법인</span>
	                      <span><input type="radio" id="coYn" name="coYn" value="1" checked="checked"/></span>
	                    </label>
	                    <label>
	                      <span>개인</span>
	                      <span><input type="radio" id="coYn" name="coYn" value="2" /></span>
	                    </label>
	                    </fieldset>
		            </c:when>
		            <c:when test="${vo.coYn == '2'}">
	                    <fieldset>
	                    <label>
	                      <span>법인</span>
	                      <span><input type="radio" id="coYn" name="coYn" value="1" /></span>
	                    </label>
	                    <label>
	                      <span>개인</span>
	                      <span><input type="radio" id="coYn" name="coYn" value="2" checked="checked"/></span>
	                    </label>
	                    </fieldset>
                    </c:when>
                </c:choose>
                </td>

                <td class="wideset">
                <label>해외여부</label>
                </td>
                <td class="box wideset">
                <c:choose>
                    <c:when test="${vo.foreignYn == '1'}">
		                <fieldset>
		                    <label>
		                      <span>국내</span>
		                      <input type="radio" id="foreignYn" name="foreignYn" value="1" checked="checked" />
		                    </label>
		                    <label>
		                      <span>해외</span>
		                      <input type="radio" id="foreignYn" name="foreignYn" value="2" />
		                    </label>
		                </fieldset>
	                </c:when>
                    <c:when test="${vo.foreignYn == '2'}">
                        <fieldset>
                            <label>
                              <span>국내</span>
                              <input type="radio" id="foreignYn" name="foreignYn" value="1"/>
                            </label>
                            <label>
                              <span>해외</span>
                              <input type="radio" id="foreignYn" name="foreignYn" value="2" checked="checked">
                            </label>
                        </fieldset>
                    </c:when>
                </c:choose>
                </td>
            </tr>
            <tr class="col-sm-12 col-dm-12 col-lg-12">
                <td>과세구분</td>
                <td>
                    <select class="form-control input-sm" name="taxYn" id="taxYn">
                      <option value="1"  <c:if test="${vo.taxYn == 1}">selected="selected"</c:if>>과세/면세</option>
                      <option value="2" <c:if test="${vo.taxYn == 2}">selected="selected"</c:if>>비과세</option>
                    </select>
                </td>
                <td>국가</td>
                <td>
                    <td><input type="text" id="countryEng" value="${vo.countryEng }" readonly="readonly"><!-- readonly="readonly"  -->
                </td>
                <td>
                    <td><input type="text" id="countryKor" value="${vo.countryKor }" readonly="readonly"><!-- readonly="readonly"  -->
                </td>
                <td><input type="button" value="검색" onclick="countrySearch()"></td>
            </tr>
            
            <tr class="col-sm-12 col-dm-12 col-lg-12">
            
                <c:if test="${vo.specialRelation == 1}">
                    <td> 특수 관계자</td>
                    <td><input type="checkbox" id="specialRelation" checked="checked"></td>
                </c:if>
                <c:if test="${vo.specialRelation == 2}">
                    <td> 특수 관계자</td>
                    <td><input type="checkbox" id="specialRelation"></td>
                </c:if>
                <c:if test="${vo.tradeStop == 1}">
	                <td> 거래중지</td>  
	                <td><input type="checkbox" id="tradeStop"checked="checked"></td>
	            </c:if>
                <c:if test="${vo.tradeStop == 2}">
                    <td> 거래중지</td>
                    <td><input type="checkbox" id="tradeStop"></td>
                </c:if>
            </tr>
            <tr class="col-sm-12 col-dm-12 col-lg-12">
                <td>계약기간</td>
                <td><input type="date" id="contractPeriodS" value="${vo.contractPeriodS }"></td>
                <td>~</td>
                <td><input type="date" id="contractPeriodE" value="${vo.contractPeriodE }"></td>
            </tr>
            <tr class="col-sm-12 col-dm-12 col-lg-12">
                <td>등록 정보</td>
                <td><input type="text" id="regiInfoMan" placeholder="홍길동" value="${vo.regiInfoMan }"></td>
                <td><input type="text" id="regiInfoDate" value="${vo.regiInfoDate }" readonly="readonly"></td>
                <td>변경 정보</td>
                <td><input type="text" id="modiInfoMan" placeholder="홍길동" value="${vo.modiInfoMan }"></td>
                <td><input type="text" id="modiInfoDate" value="${vo.modiInfoDate }" readonly="readonly"></td>
            </tr>

        <thead class="col-sm-12 col-dm-12 col-lg-12 ">
          <tr class="col-sm-12 col-dm-12 col-lg-12 ">
            <th class="text-center wideset box" >사무소</th>
            <th class="text-center wideset box" >은행</th>
            <th class="text-center wideset box" >계좌번호</th>
          </tr>
        </thead>
        <tbody class="col-sm-12 col-dm-12 col-lg-12 ">
          <tr class="col-sm-12 col-dm-12 col-lg-12 ">
            <td class="text-center wideset box"><input type="text" id="factory" value="${vo.factory }"></td>
            <td class="text-center wideset box"><input type="text" id="tradeBank" value="${vo.tradeBank }"></td>
            <td class="text-center wideset box"><input type="text" id="accountNum" value="${vo.accountNum }"></td>
          </tr>
        </tbody>
        </table>
    </div>
</div>
</form>
</body>
</html>