/*
 *    eGov  SmartCity eGovernance suite aims to improve the internal efficiency,transparency,
 *    accountability and the service delivery of the government  organizations.
 *
 *     Copyright (C) 2017  eGovernments Foundation
 *
 *     The updated version of eGov suite of products as by eGovernments Foundation
 *     is available at http://www.egovernments.org
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program. If not, see http://www.gnu.org/licenses/ or
 *     http://www.gnu.org/licenses/gpl.html .
 *
 *     In addition to the terms of the GPL license to be adhered to in using this
 *     program, the following additional terms are to be complied with:
 *
 *         1) All versions of this program, verbatim or modified must carry this
 *            Legal Notice.
 *            Further, all user interfaces, including but not limited to citizen facing interfaces,
 *            Urban Local Bodies interfaces, dashboards, mobile applications, of the program and any
 *            derived works should carry eGovernments Foundation logo on the top right corner.
 *
 *            For the logo, please refer http://egovernments.org/html/logo/egov_logo.png.
 *            For any further queries on attribution, including queries on brand guidelines,
 *            please contact contact@egovernments.org
 *
 *         2) Any misrepresentation of the origin of the material is prohibited. It
 *            is required that all modified versions of this material be marked in
 *            reasonable ways as different from the original version.
 *
 *         3) This license does not grant any rights to any user of the program
 *            with regards to rights under trademark law for use of the trade names
 *            or trademarks of eGovernments Foundation.
 *
 *   In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
 *
 */

package org.egov.ptis.client.model;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class TaxDetails implements Serializable {
	private BigDecimal generalTax = BigDecimal.ZERO;
	private BigDecimal totalTax = BigDecimal.ZERO;
	private BigDecimal eduCess = BigDecimal.ZERO;
	private BigDecimal libCess = BigDecimal.ZERO;
	private BigDecimal sewarageTax = BigDecimal.ZERO;
	private BigDecimal pubServiceCharge = BigDecimal.ZERO;
	private BigDecimal penalty = BigDecimal.ZERO;
	private BigDecimal unAuthPenalty = BigDecimal.ZERO;
	private String demandYear;
	public BigDecimal getGeneralTax() {
		return generalTax;
	}
	public void setGeneralTax(BigDecimal generalTax) {
		this.generalTax = generalTax;
	}
	public BigDecimal getTotalTax() {
		//TODO: Need to check the all the taxes
		if(getGeneralTax() != null && getEduCess() != null && getLibCess() != null && getSewarageTax() != null && getPenalty() != null && getUnAuthPenalty() != null) {
			return getGeneralTax().add(getEduCess()).add(getLibCess()).add(getSewarageTax()).add(getPenalty()).add(getUnAuthPenalty());
		} else {
			return BigDecimal.ZERO;
		}
		//return getGeneralTax().add(getEduCess()).add(getLibCess()).add(getSewarageTax()).add(getPenalty()).add(getUnAuthPenalty());
	}
	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}
	public BigDecimal getEduCess() {
		return eduCess;
	}
	public void setEduCess(BigDecimal eduCess) {
		this.eduCess = eduCess;
	}
	public BigDecimal getLibCess() {
		return libCess;
	}
	public void setLibCess(BigDecimal libCess) {
		this.libCess = libCess;
	}
	public BigDecimal getSewarageTax() {
		return sewarageTax;
	}
	public void setSewarageTax(BigDecimal sewarageTax) {
		this.sewarageTax = sewarageTax;
	}
	public BigDecimal getPubServiceCharge() {
		return pubServiceCharge;
	}
	public void setPubServiceCharge(BigDecimal pubServiceCharge) {
		this.pubServiceCharge = pubServiceCharge;
	}
	public BigDecimal getPenalty() {
		return penalty;
	}
	public void setPenalty(BigDecimal penalty) {
		this.penalty = penalty;
	}
	public BigDecimal getUnAuthPenalty() {
		return unAuthPenalty;
	}
	public void setUnAuthPenalty(BigDecimal unAuthPenalty) {
		this.unAuthPenalty = unAuthPenalty;
	}
	public String getDemandYear() {
		return demandYear;
	}
	public void setDemandYear(String demandYear) {
		this.demandYear = demandYear;
	}
	@Override
	public String toString() {
		return "TaxDetails [generalTax=" + generalTax + ", totalTax=" + totalTax + ", eduCess=" + eduCess + ", libCess="
				+ libCess + ", sewarageTax=" + sewarageTax + ", pubServiceCharge=" + pubServiceCharge + ", penalty="
				+ penalty + ", unAuthPenalty=" + unAuthPenalty + ", demandYear=" + demandYear + "]";
	}
}
