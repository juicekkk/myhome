<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<style>


</style>
<div class="boardWrap type2">

    <div class="titleWrap">
        <p>낙엽 한 장</p>
        <p>나릿물 떠내려온 잎 하나 눈에 띄어<br>살가운 마음으로 살며시 건졌더니<br>멀리 본 늦가을 산이 손안에서 고와라</p>
    </div>

    <div class="contents">

        <form method="POST" enctype="multipart/form-data" id="writeForm">

            <div class="boardContent">
                <span>CATEGORY</span>
                <select name="categoryCode">
                    <option value="${categoryCode}">${categoryCode}</option>
                </select>
            </div>

            <div class="boardContent">
                <span>TITLE</span>
                <input type="text" name="title">
            </div>

            <div class="boardContent">
                <span>SUB TITLE</span>
                <input type="text" name="subTitle">
            </div>

            <div class="boardContent">
                <span>THUMBNAIL</span>
                <input type="file" name="thumbnail" class="thumbnail">
            </div>

            <div class="boardContent">
                <span>SHARE</span>
                <div style="margin-top: 15px;">
                    <input type="radio" name="share" value="Y" style="width: 30px">Y
                    <input type="radio" name="share" value="N" checked="checked" style="width: 30px">N
                </div>
            </div>

            <div class="boardContent">
                <span>CONTENT</span>
                <textarea name="contents"></textarea>
            </div>

            <div class="boardBtnWrap">
                <a href="/${categoryCode}.do"><input type="button" value="목록"></a>
                <a><input type="button" value="등록" id="boardReg"></a>
            </div>
        </form>

    </div>

</div>

<script>
    $('#boardReg').click(function () {
        var form = $('#writeForm')[0]
        var data = new FormData(form);

        $.ajax({
            url: '/boardReg.do' //request 보낼 서버의 경로
            , type: "POST"
            , enctype: 'multipart/form-data'
            , data: data
            , processData: false
            , contentType: false
            , cache: false
            , success: function (data) {
                console.log(data);
                //서버로부터 정상적으로 응답이 왔을 때 실행
                if(data.code == 200){
                    alert("등록되었습니다.");
                    let categoryCode = '${categoryCode}';
                    $(location).attr('href','/'+categoryCode+".do");
                }
            }, error: function (request, status, error) {
                alert('오류가 발생했습니다. 관리자에게 문의해주세요.');
            }

        });
    });
</script>