<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<style>


</style>
<div class="boardWrap">

    <div class="titleWrap">
        <p>이방인</p>
        <p>그제야 나는 알게 될지 몰라<br>그토록 찾아 헤매던<br>나의 머물곳이 너였음을</p>
    </div>

    <div class="findWrap">
        <div class="findContentsWrap">

            <form method="post" enctype="multipart/form-data" action="/memberFindId.do" name="memberForm" id="memberIdFindForm">
                <div class="findContent">
                    <div class="find">
                        <label>닉네임</label>
                        <input type="text" name="nickName" id="nickName" placeholder="NICKNAME">
                    </div>
                    <div class="find">
                        <label>이메일</label>
                        <input type="text" name="email1" id="email1" placeholder="EMAIL">
                        <span style="display: flex; flex-wrap: wrap; align-items: center;">@</span>
                        <select name="email2" id="email2">
                            <option value="">선택</option>
                            <option value="naver.com">naver.com</option>
                            <option value="gmail.com">gmail.com</option>
                        </select>
                    </div>

                    <div class="findBtnWrap">
                        <a><input type="button" value="아이디찾기" id="findIdBtn"></a>
                    </div>
                </div>
            </form>

            <div class="findContent">
                <div class="find">
                    <label>아이디</label>
                    <input type="text" name="userId" id="userId" placeholder="ID">
                </div>
                <div class="find">
                    <label>질문</label>
                    <select name="question" id="question" style="margin: 0px;">
                        <option value="">비밀번호찾기 시 사용</option>
                        <option value="1">나의 보물 1호는 무엇인가요?</option>
                        <option value="2">어머니 성함은 무엇인가요?</option>
                        <option value="3">아버지 성함은 무엇인가요?</option>
                        <option value="4">학창시절 별명은 무엇인가요?</option>
                        <option value="5">나의 학교 이름은 무엇인가요?</option>
                    </select>
                </div>
                <div class="find">
                    <label>답변</label>
                    <input type="text" name="answer" id="answer">
                </div>

                <div class="findBtnWrap">
                    <a><input type="button" value="비밀번호찾기"></a>
                </div>
            </div>
        </div>
    </div>

</div>


<script>

    $("#findIdBtn").click(function () {

        if($('#nickName').val() == ''){
            alert('닉네임을 입력해주세요.');
            return false;
        }

        if($('#email1').val() == '' || $('select[name=email2]').val() == ''){
            alert('이메일을 입력해주세요.');
            return false;
        }

        $.ajax({
            url:'/memberFind.do', //request 보낼 서버의 경로
            type:'post', // 메소드(get, post, put 등)
            data:$('#memberIdFindForm').serialize(), //보낼 데이터
            dataType : 'json',
            success: function(data) {
                //서버로부터 정상적으로 응답이 왔을 때 실행
                if(data.code == 200 && data.result != null){
                    alert("등록된 아이디는 " + data.result + " 입니다.");
                } else {
                    alert("일치하는 정보가 없습니다.");
                }
            }, error:function(request,status,error){
                alert('오류가 발생했습니다. 관리자에게 문의해주세요.');
            }

        });
    });

</script>