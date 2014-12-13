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
                    <div class="row state-overview">
                    	<div onclick="popUpEvaluation();" class="col-md-6 col-xs-12 col-sm-6">
                            <div class="panel red">
                                <div class="symbol">
                                    <i class="fa fa-tags"></i>
                                </div>
                                <div class="state-value">
<!--                                     <div class="value">3490</div> -->
                                    <div class="title">Evalutation</div>
                                </div>
                            </div>
                        </div>
	                        <div onclick="popUpAbsence();" class="col-md-6 col-xs-12 col-sm-6">
	                            <div class="panel red">
	                                <div class="symbol">
	                                    <i class="fa fa-tags"></i>
	                                </div>
	                                <div class="state-value">
	<!--                                     <div class="value">3490</div> -->
	                                    <div class="title">Absence</div>
	                                </div>
	                            </div>
	                        </div>
                    </div>
<!--                     <button type="submit" class="btn btn-primary">Submit</button> -->
                </form>

            </div>
        </section>
    </div>
    
</div>
<!-- Dashboard forma End -->