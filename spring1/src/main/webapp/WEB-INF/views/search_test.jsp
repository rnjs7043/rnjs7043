<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
		uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search_test.jsp</title>
</head>
<body>

<form id="searchForm" name="searchForm"
		action="/test/search">
	<br><br>부서 :
	<select id="searchDeptNo" name="searchDeptNo">
		<option value=""
			<c:if test="${searchVO.searchDeptNo == 0}">
				selected="selected"</c:if> >전체</option>
		<option value="10"
			<c:if test="${searchVO.searchDeptNo == 10}">
				selected="selected"</c:if> >회계</option>
		<option value="20"
			<c:if test="${searchVO.searchDeptNo == 20}">
				selected="selected"</c:if> >연구</option>
		<option value="30"
			<c:if test="${searchVO.searchDeptNo == 30}">
				selected="selected"</c:if> >영업</option>
		<option value="40"
			<c:if test="${searchVO.searchDeptNo == 40}">
				selected="selected"</c:if> >운영</option>
	</select>
	<br><br>직업 :
	<select id="searchJob" name="searchJob">
		<option value=""
			<c:if test="${searchVO.searchJob =='0'}">
			selected="selected"</c:if> >전체</option>
		<option value="CLERK"
			<c:if test="${searchVO.searchJob =='CLERK'}">
			selected="selected"</c:if> >사무</option>
		<option value="SALESMAN"
			<c:if test="${searchVO.searchJob =='SALESMAN'}">
			selected="selected"</c:if> >영업</option>
		<option value="MANAGER"
			<c:if test="${searchVO.searchJob =='MANAGER'}">
			selected="selected"</c:if> >관리</option>
		<option value="ANALYST"
			<c:if test="${searchVO.searchJob =='ANALYST'}">
			selected="selected"</c:if> >분석</option>
		<option value="PRESIDENT"
			<c:if test="${searchVO.searchJob =='PRESIDENT'}">
			selected="selected"</c:if> >대표</option>
	</select>
	<br><br>이름 :
	<input type="text" id="searchName" name="searchName"
			value="${searchVO.searchName}" />
	<br><br>
	<input type="submit" value="btn_search" />

	<br><br>
	<c:if test="${list != null}">
		<table border="1">
			<c:forEach items="${list}"
						var="vo" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${vo.empno}</td>
				<td>${vo.ename}</td>
				<td>${vo.job}</td>
				<td>${vo.mgr}</td>
				<td>${vo.hiredate}</td>
				<td>${vo.sal}</td>
				<td>${vo.comm}</td>
				<td>${vo.deptno}</td>
			</tr>
			</c:forEach>
		</table>
	</c:if>

</form>

</body>
</html>
