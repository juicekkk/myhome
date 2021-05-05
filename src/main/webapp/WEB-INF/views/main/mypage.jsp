<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<style>


</style>
<div class="boardWrap">

    <div class="titleWrap">
        <p>이름이 없으면</p>
        <p>꽃을 보려거든, 이름 없이 태어나라<br>봄 한 시절에 피는 저게 무슨 꽃인지 나는<br>그해 여름이 되어서야 알게 되었다</p>
    </div>

    <form method="post" enctype="multipart/form-data" action="/memberMod.do" name="memberForm" id="memberForm">
        <div class="joinWrap">
            <div class="joinContentsWrap">
                <div class="joinContent">
                    <label>아이디</label>
                    <input type="text" name="userId" id="userId" placeholder="ID" value="${memberInfo.userId}" readonly="readonly">
                </div>
                <div class="joinContent">
                    <label>비밀번호</label>
                    <a href="/modify/pwd.do" id="pwdModifyBtn"><input type="button" value="비밀번호변경"></a>
                </div>
                <div class="joinContent">
                    <label>닉네임</label>
                    <input type="text" name="nickName" id="nickName" value="${memberInfo.nickName}">
                </div>
                <div class="joinContent">
                    <label>이메일</label>
                    <input type="text" name="email1" id="email1" placeholder="EMAIL" value="${memberInfo.email1}">
                    <span style="display: flex; flex-wrap: wrap; align-items: center;">@</span>
                    <select name="email2" id="email2">
                        <option value="">선택</option>
                        <option value="naver.com" <c:if test="${memberInfo.email2 eq 'naver.com'}">selected</c:if>>naver.com</option>
                        <option value="gmail.com" <c:if test="${memberInfo.email2 eq 'gmail.com'}">selected</c:if>>gmail.com</option>
                    </select>
                </div>
                <div class="joinContent">
                    <label>질문</label>
                    <select name="question" style="margin: 0 15px;">
                        <option value="">비밀번호찾기 시 사용</option>
                        <option value="1" <c:if test="${memberInfo.question eq '1'}">selected</c:if>>나의 보물 1호는 무엇인가요?</option>
                        <option value="2" <c:if test="${memberInfo.question eq '2'}">selected</c:if>>어머니 성함은 무엇인가요?</option>
                        <option value="3" <c:if test="${memberInfo.question eq '3'}">selected</c:if>>아버지 성함은 무엇인가요?</option>
                        <option value="4" <c:if test="${memberInfo.question eq '4'}">selected</c:if>>학창시절 별명은 무엇인가요?</option>
                        <option value="5" <c:if test="${memberInfo.question eq '5'}">selected</c:if>>나의 학교 이름은 무엇인가요?</option>
                    </select>
                </div>
                <div class="joinContent">
                    <label>답변</label>
                    <input type="text" name="answer" id="answer" value="${memberInfo.answer}">
                </div>
            </div>
            <div class="modifyBtnWrap">
                <a><input type="button" value="회원탈퇴" id="memberDel" style="background: #bf3a46;"></a>
                <a><input type="button" value="변경" id="memberMod"></a>
            </div>
        </div>
    </form>

</div>

<script type="text/javascript">

    $('#memberMod').click(function () {
        if($('#userId').val() == ''){
            alert('아이디를 입력해주세요.');
            return false;
        }

        if($('#nickName').val() == ''){
            alert('닉네임을 입력해주세요.');
            return false;
        }

        if($('select[name=question]').val() == ''){
            alert('비밀번호 찾기 질문을 선택해주세요.');
            return false;
        }

        if($('#answer').val() == ''){
            alert('비밀번호 찾기 답변을 입력해주세요.');
            return false;
        }

        $.ajax({
            url:'/memberMod.do', //request 보낼 서버의 경로
            type:'post', // 메소드(get, post, put 등)
            data:$('#memberForm').serialize(), //보낼 데이터
            dataType : 'json',
            success: function(data) {
                //서버로부터 정상적으로 응답이 왔을 때 실행
                if(data.code == 200){
                    alert("수정되었습니다.");
                    window.location = "/mypage.do";
                }
            }, error:function(request,status,error){
                alert('오류가 발생했습니다. 관리자에게 문의해주세요.');
            }

        });

    });

    $('#memberDel').click(function () {

        var result = confirm('정말로 탈퇴하시겠습니까?');
        if(result) {
            $.ajax({
                url:'/memberDel.do', //request 보낼 서버의 경로
                type:'post', // 메소드(get, post, put 등)
                data:$('#memberForm').serialize(), //보낼 데이터
                dataType : 'json',
                success: function(data) {
                    //서버로부터 정상적으로 응답이 왔을 때 실행
                    if(data.code == 200){
                        alert("탈퇴 처리되었습니다.");
                        window.location = "/";
                    }
                }, error:function(request,status,error){
                    alert('오류가 발생했습니다. 관리자에게 문의해주세요.');
                }

            });
        }

    });
</script>