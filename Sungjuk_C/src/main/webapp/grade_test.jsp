<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="inhaProfessor" class="C.교수" scope="page" />
<jsp:useBean id="studentGrade" class="C.성적" scope="page" />

<%
    String studentId = "20260001";
    
    String correctProfId = "inha";
    String test1_AddResult = studentGrade.성적입력요청(inhaProfessor, correctProfId, studentId, 80, 90, 85);
    String test1_SearchResult = studentGrade.학점조회요청(inhaProfessor, correctProfId, studentId);

    String wrongProfId = "hacker123";
    String test2_AddResult = studentGrade.성적입력요청(inhaProfessor, wrongProfId, studentId, 100, 100, 100);
    String test2_SearchResult = studentGrade.학점조회요청(inhaProfessor, wrongProfId, studentId);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>성적 관리 시스템</title>
    <style>
        body { font-family: 'Malgun Gothic', sans-serif; padding: 20px; line-height: 1.6; }
        .box { border: 1px solid #ccc; padding: 15px; margin-bottom: 20px; border-radius: 5px; background-color: #f9f9f9; }
        .success { color: #0056b3; font-weight: bold; margin: 5px 0; }
        .error { color: #d9534f; font-weight: bold; margin: 5px 0; }
    </style>
</head>
<body>
    <h2>✅ 성적 관리 시스템 실행 결과 (통합 성적 클래스)</h2>
    <hr>
    
    <div class="box">
        <h3>[CASE 1] 정상 입력 및 조회 (교수 ID: inha)</h3>
        <p class="success"><%= test1_AddResult %></p>
        <p class="success"><%= test1_SearchResult %></p>
    </div>
    
    <div class="box">
        <h3>[CASE 2] 권한 없는 사용자 접근 (교수 ID: hacker123)</h3>
        <p class="error"><%= test2_AddResult %></p>
        <p class="error"><%= test2_SearchResult %></p>
    </div>
</body>
</html>