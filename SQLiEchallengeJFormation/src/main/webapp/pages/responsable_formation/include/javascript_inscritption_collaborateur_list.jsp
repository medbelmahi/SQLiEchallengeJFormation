<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!-- menu collapsed Start -->
	<script type="text/javascript">
// 	$("input[type=checkbox][checked]").next().html('<small style="left: 23px; transition: left 0.2s; -webkit-transition: left 0.2s;"></small>');
	$("input[type=checkbox][checked]").next().children()[0].style.left="23px";
	menuCollapsed();
	</script>
<!-- menu collapsed End -->