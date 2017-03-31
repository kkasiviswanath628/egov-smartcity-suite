<%--
  ~ eGov suite of products aim to improve the internal efficiency,transparency,
  ~    accountability and the service delivery of the government  organizations.
  ~
  ~     Copyright (C) <2015>  eGovernments Foundation
  ~
  ~     The updated version of eGov suite of products as by eGovernments Foundation
  ~     is available at http://www.egovernments.org
  ~
  ~     This program is free software: you can redistribute it and/or modify
  ~     it under the terms of the GNU General Public License as published by
  ~     the Free Software Foundation, either version 3 of the License, or
  ~     any later version.
  ~
  ~     This program is distributed in the hope that it will be useful,
  ~     but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  ~     GNU General Public License for more details.
  ~
  ~     You should have received a copy of the GNU General Public License
  ~     along with this program. If not, see http://www.gnu.org/licenses/ or
  ~     http://www.gnu.org/licenses/gpl.html .
  ~
  ~     In addition to the terms of the GPL license to be adhered to in using this
  ~     program, the following additional terms are to be complied with:
  ~
  ~         1) All versions of this program, verbatim or modified must carry this
  ~            Legal Notice.
  ~
  ~         2) Any misrepresentation of the origin of the material is prohibited. It
  ~            is required that all modified versions of this material be marked in
  ~            reasonable ways as different from the original version.
  ~
  ~         3) This license does not grant any rights to any user of the program
  ~            with regards to rights under trademark law for use of the trade names
  ~            or trademarks of eGovernments Foundation.
  ~
  ~   In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/taglibs/cdn.tld" prefix="cdn"%>
<form:form name="searchRequestContractor" role="form" action=""
	modelAttribute="searchRequestContractor" id="searchRequestContractor"
	class="form-horizontal form-groups-bordered">
	<input type = "hidden" value = "${ mode }" />
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-primary" data-collapsed="0">
				<div class="panel-heading">
					<div class="panel-title" style="text-align:center;"><spring:message code="title.search.contractor" /></div>
				</div>
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-2 control-label text-right"><spring:message code="lbl.name" /></label>
						<div class="col-sm-3 add-margin greybox2wk">
							<form:input path="nameOfAgency" id="name" class="form-control table-input"  maxlength = "50" />
					        <form:errors path="nameOfAgency" cssClass="error" />
						</div>
						<label class="col-sm-2 control-label text-right"><spring:message code="lbl.contractor.code" /></label>
						<div class="col-sm-3 add-margin greybox2wk">
							<form:input path="contractorCode" id="name" class="form-control table-input"  maxlength = "50" />
					        <form:errors path="contractorCode" cssClass="error" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label text-right"><spring:message code="lbl.department" /></label>
						<div class="col-sm-3 add-margin">
							<form:select  path="department" id="department" cssClass="form-control">
					           <form:option value="" > <spring:message code="lbl.select" /></form:option>
					            <form:options items="${departmentList}" itemLabel="name" itemValue="id" />
					        </form:select>
					        <form:errors path="department" cssClass="error" />
						</div>
						<label class="col-sm-2 control-label text-right"><spring:message code="lbl.status" /></label>
						<div class="col-sm-3 add-margin">
							<form:select  path="status" id="status" cssClass="form-control">
					           <form:option value="" > <spring:message code="lbl.select" /></form:option>
					           <form:options items="${statusList}" itemLabel="code" itemValue="id" />
					        </form:select>
					        <form:errors path="status" cssClass="error" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label text-right"><spring:message code="lbl.contractorclass" /></label>
						<div class="col-sm-3 add-margin">
							<form:select  path="contractorClass" id="contractorClass" cssClass="form-control">
					           <form:option value="" > <spring:message code="lbl.select" /></form:option>
					           <form:options items="${contractorClassList}" itemLabel="grade" itemValue="id" />
					        </form:select>
					        <form:errors path="contractorClass" cssClass="error" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<input type="hidden" value="${mode }" id="mode" name="mode" />
	<div class="row">
		<div class="col-sm-12 text-center">
			<button type='button' class='btn btn-primary' id="btnsearch">
				<spring:message code='lbl.search' />
			</button>
			<a href='javascript:void(0)' class='btn btn-default'
				onclick='self.close()'><spring:message code='lbl.close' /></a>
		</div>
	</div>
</form:form>
<jsp:include page="contractor-searchresult.jsp" />
<c:choose>
	<c:when test="${mode != 'view'}">
		<script
			src="<cdn:url value='/resources/js/master/contractor.js?rnd=${app_release_no}'/>"></script>
	</c:when>
	<c:otherwise>
		<script
			src="<cdn:url value='/resources/js/master/searchcontractor.js?rnd=${app_release_no}'/>"></script>
	</c:otherwise>
</c:choose>