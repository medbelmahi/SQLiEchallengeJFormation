<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- success message Start -->
     	<s:if test="isSessionActionMessage()">
      	<div class="row">
      		<div class="col-md-12">
      			<div class="alert alert-info fade in">
                       <button type="button" class="close close-sm" data-dismiss="alert">
                           <i class="fa fa-times"></i>
                       </button>
                       <strong>Message : </strong>  <s:property value="sessionActionMessageText" />
                   </div>
      		</div>
      	</div>
      </s:if>
<!-- success message End -->


<!-- Error message Start -->
<s:if test="isSessionActionError()">
	<div class="row">
       		<div class="col-md-12">
       			<div class="alert alert-block alert-danger fade in">
                          <button type="button" class="close close-sm" data-dismiss="alert">
                              <i class="fa fa-times"></i>
                          </button>
                          <strong>Erreur ! </strong> <s:property value="sessionActionErrorText" />
                      </div>
       		</div>
       </div>
   </s:if>
<!-- Error message End -->