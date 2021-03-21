<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<style>

</style>
<div id="floatWrap">
    <div class="plusWrap">
        <img src="${path}/resources/images/plusIcon.png">
    </div>

    <div class="iconWrap">
        <div>
            <a href="/mypage.do">
                <img src="${path}/resources/images/mypageIcon.png">
                <span>MYPAGE</span>
            </a>
        </div>
        <div>
            <a href="/setting.do">
                <img src="${path}/resources/images/settingIcon.png">
                <span>SETTING</span>
            </a>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(".plusWrap").click(function(){
        $(".iconWrap").toggle();
    });
</script>
