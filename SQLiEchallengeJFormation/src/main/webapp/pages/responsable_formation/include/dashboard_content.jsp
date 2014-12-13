<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!-- Dashboard forma Start -->
<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <header class="panel-heading">
                
            </header>
            <div class="panel-body">
                <form role="form">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Choisir une formation</label>
                        <select id="selectIdFormation" name="idFormation" class="form-control m-bot15">
                                <s:iterator value="formations">
                                	<option value='<s:property value="idFormation" />'><s:property value="titreFormation" /></option>
                                </s:iterator>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Choisir une session</label>
	                        <select id="selectIdSession" name="idSession" class="form-control m-bot15">
	                                
	                        </select>
                    </div>
                    <div class="text-center ">
		                <a class="btn btn-success btn-lg" href='#' onclick="popUpEvaluation();"><i class="fa fa-pie-char"></i> Resultat des evalutations </a>
		                
		                <a class="btn btn-primary btn-lg" href='#' onclick="popUpAbsence();" ><i class="fa fa-area-chart"></i> Analyse d'absence </a>
		            </div>
		            
                </form>

            </div>
        </section>
    </div>
    
</div>
<!-- Dashboard forma End -->