<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<link rel="stylesheet" href="<c:url value='/resources/global/css/font-icons/entypo/css/entypo.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/global/css/bootstrap/typeahead.css'/>">
<div class="row" id="page-content">
	<div class="col-md-12">
		<div class="panel" data-collapsed="0">
			<div class="panel-body">
				 <c:if test="${not empty message}">
                    <div id="message" class="success">${message}</div>
                </c:if>
		<form:form  method="post" class="form-horizontal form-groups-bordered" modelAttribute="boundary" id="hierarchyTypeView" >
			<div class="panel panel-primary" data-collapsed="0">
				<div class="panel-heading">
					<div class="panel-title">
						<strong><spring:message code="lbl.hdr.viewBoundary"/>${boundary.bndryNameLocal}</strong>
					</div>
				</div> 
				
				<div class="panel-body custom-form">
					<div class="form-group">
						<label class="col-sm-3 control-label"><spring:message code="lbl.hierarchyType"/></label>
						<div class="col-sm-6" style="padding-top: 7px">
							<strong><c:out value="${boundary.boundaryType.hierarchyType.name}" /></strong>                 
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">
							<spring:message code="lbl.boundaryType"/>
						</label>
						<div class="col-sm-6" style="padding-top: 7px">
							<strong><c:out value="${boundary.boundaryType.name}" /></strong>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">
							<spring:message code="lbl.boundary.name"/>
						</label>
						<div class="col-sm-6" style="padding-top: 7px">
							<strong><c:out value="${boundary.name}" /></strong>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">
							<spring:message code="lbl.boundary.nameLocal"/>
						</label>
						<div class="col-sm-6" style="padding-top: 7px">
							<strong><c:out value="${boundary.bndryNameLocal}" /></strong>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">
							<spring:message code="lbl.boundary.number"/>
						</label>
						<div class="col-sm-6" style="padding-top: 7px">
							<strong><c:out value="${boundary.boundaryNum}" /></strong>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">
							<spring:message code="lbl.boundary.fromDate"/>
						</label>
						<div class="col-sm-6" style="padding-top: 7px">
							<fmt:formatDate value="${boundary.fromDate}" pattern="dd-MM-yyyy" var="fromDate"/>
							<strong><c:out value="${fromDate}" /></strong>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">
							<spring:message code="lbl.boundary.toDate"/>
						</label>
						<div class="col-sm-6" style="padding-top: 7px">
							<fmt:formatDate value="${boundary.toDate}" pattern="dd-MM-yyyy" var="toDate"/>
							<strong><c:out value="${toDate}" /></strong>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="text-center">
			       <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="lbl.close"/></button>
				</div>
			</div>
		</form:form>
			</div>
        </div>
    </div>
</div>

<script src="<c:url value='/resources/global/js/bootstrap/typeahead.bundle.js'/>"></script>
<script src="<c:url value='/resources/global/js/jquery/plugins/exif.js'/>"></script>
<script src="<c:url value='/resources/global/js/jquery/plugins/jquery.inputmask.bundle.min.js'/>"></script>

