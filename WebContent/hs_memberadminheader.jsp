<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!--header style-->
<link rel="stylesheet" href="css/hs_adminheader.css" >
<!--header style-->

</head>
<body>
  <div>
    <div class="hs_header_top">
     <a href="hs_memberadminmain.jsp" id="hs_header_h1">홈드림</a>
     <a href="hs_memberadminmain.jsp" class="hs_header_hc" style="color: rgb(0, 153, 255);">회원관리</a>
     <a href="hs_storeadminmain.jsp" class="hs_header_hc">스토어관리</a>
     <a href="hs_communityadminmain.jsp" class="hs_header_hc">커뮤니티관리</a>
     <a href=""  class="hs_header_hc">로그아웃</a>
     <b class="hs_header_admin">관리자모드</b>    
    </div>
    <div class="hs_header_bottom">
    <div class="hs_header_line"></div>
    <div class="hs_header_cg">
     <nav class="hs_header_nav">
         <a href="ej_list.do" style="color: rgb(0, 153, 255);">조회 및 삭제</a>
         <a href="ej_orderlist.do">주문배송관리</a>
     </nav>  
    </div> 
    <div class="hs_header_line"></div> 
    </div>
  </div>  
</body>
</html>