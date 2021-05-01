<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<style>


</style>
<div class="boardWrap type1">

    <div class="titleWrap">
        <p>별들을 별 밤을 봅니다</p>
        <p>행복스럽고 옷을 속에서 따뜻한 뜨고, 것이다.<br>이는 얼마나 없는 꽃이 얼음과 곳이 것이다.<br>노래하며 심장의 우리 이것이다.</p>
    </div>

    <div class="contents">

        <div class="boardBtnWrap">
            <select name="searchType">
                <option value="1" selected="selected">제목</option>
                <option value="2">제목+내용</option>
                <option value="3">작성자</option>
            </select>
            <input type="text" class="searchText" placeholder="검색어를 입력해주세요." name="searchText">
            <a><input type="button" value="검색" class="searchBtn"></a>
            <a href="/write/eat.do"><input type="button" value="글쓰기" class="write"></a>
        </div>

        <div class="content">
            <div class="imgWrap">
                <img class="scale" src="${path}/resources/images/contents/board1/thumb/thumb.jpg">
            </div>
            <span class="sub">평의스러운 끝</span>
            <span class="main">그들은 이 그들의 봄바람이다</span>
        </div>

        <div class="content">
            <div class="imgWrap">
                <img class="scale" src="${path}/resources/images/contents/board1/thumb/thumb2.jpg">
            </div>
            <span class="sub">인간의 주는 충분히 운다</span>
            <span class="main">청춘의 들어 할지니</span>
        </div>

        <div class="content">
            <div class="imgWrap">
                <img class="scale" src="${path}/resources/images/contents/board1/thumb/thumb3.jpg">
            </div>
            <span class="sub">보이는 있음으로</span>
            <span class="main">찾아다녀도, 사는가, 되려니와</span>
        </div>
        <div class="content">
            <div class="imgWrap">
                <img class="noImg" src="${path}/resources/images/no_Image.png">
            </div>
            <span class="sub">품에 얼마나</span>
            <span class="main">커다란 새가 곧 청춘은 꽃이 사막이다</span>
        </div>

        <div class="content">
            <div class="imgWrap">
                <img class="scale" src="${path}/resources/images/contents/board1/thumb/thumb4.jpg">
            </div>
            <span class="sub">열매를 관현악이며</span>
            <span class="main">청춘의 들어 할지니</span>
        </div>

        <div class="boardBtnWrap">
            <select name="searchType">
                <option value="1" selected="selected">제목</option>
                <option value="2">제목+내용</option>
                <option value="3">작성자</option>
            </select>
            <input type="text" class="searchText" placeholder="검색어를 입력해주세요." name="searchText">
            <a><input type="button" value="검색" class="searchBtn"></a>
            <a href="/write/eat.do"><input type="button" value="글쓰기" class="write"></a>
        </div>

    </div>

</div>