/*
 *    eGov  SmartCity eGovernance suite aims to improve the internal efficiency,transparency,
 *    accountability and the service delivery of the government  organizations.
 *
 *     Copyright (C) 2018  eGovernments Foundation
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

package org.egov.tl.entity;

import com.google.gson.annotations.Expose;
import org.egov.commons.EgwStatus;
import org.egov.demand.model.EgDemandDetails;
import org.egov.infra.admin.master.entity.Boundary;
import org.egov.infra.admin.master.entity.User;
import org.egov.infra.config.core.ApplicationThreadLocals;
import org.egov.infra.persistence.validator.annotation.Unique;
import org.egov.infra.workflow.entity.StateAware;
import org.egov.pims.commons.Position;
import org.egov.tl.entity.contracts.LicenseStateInfo;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.lang.System.lineSeparator;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.egov.infra.config.core.LocalizationSettings.currencySymbolUtf8;
import static org.egov.infra.security.utils.SecureCodeUtils.generatePDF417Code;
import static org.egov.infra.utils.ApplicationConstant.UNDERSCORE;
import static org.egov.infra.utils.DateUtils.toDefaultDateTimeFormat;
import static org.egov.infra.utils.StringUtils.appendTimestamp;
import static org.egov.tl.utils.Constants.CLOSURE_NATUREOFTASK;
import static org.egov.tl.utils.Constants.LICENSE_FEE_TYPE;
import static org.egov.tl.utils.Constants.LICENSE_STATUS_CANCELLED;
import static org.egov.tl.utils.Constants.NEW_LIC_APPTYPE;
import static org.egov.tl.utils.Constants.PERMANENT_NATUREOFBUSINESS;
import static org.egov.tl.utils.Constants.RENEWAL_LIC_APPTYPE;
import static org.egov.tl.utils.Constants.STATUS_ACKNOWLEDGED;
import static org.egov.tl.utils.Constants.STATUS_ACTIVE;
import static org.egov.tl.utils.Constants.STATUS_COLLECTIONPENDING;
import static org.egov.tl.utils.Constants.TEMP_NATUREOFBUSINESS;
import static org.egov.tl.utils.Constants.WF_STATE_COMMISSIONER_APPROVED_STR;
import static org.egov.tl.utils.Constants.WORKFLOW_STATE_REJECTED;

@Entity
@Table(name = "EGTL_LICENSE")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = License.SEQUENCE, sequenceName = License.SEQUENCE, allocationSize = 1)
@Unique(fields = {"licenseNumber", "applicationNumber", "oldLicenseNumber"}, enableDfltMsg = true, isSuperclass = true)
public class License extends StateAware<Position> {

    public static final String SEQUENCE = "SEQ_EGTL_LICENSE";
    private static final long serialVersionUID = -4621190785979222546L;
    @Id
    @GeneratedValue(generator = SEQUENCE, strategy = GenerationType.SEQUENCE)
    @Expose
    protected Long id;

    @NotBlank
    @SafeHtml
    @Length(max = 128)
    @Column(name = "APPL_NUM")
    @Audited
    protected String applicationNumber;

    @SafeHtml
    @Length(max = 50)
    @Column(name = "LICENSE_NUMBER")
    protected String licenseNumber;

    @SafeHtml
    @NotBlank
    @Length(max = 256)
    @Column(name = "NAME_OF_ESTAB")
    @Audited
    protected String nameOfEstablishment;

    @SafeHtml
    @Length(max = 50)
    @Column(name = "OLD_LICENSE_NUMBER")
    protected String oldLicenseNumber;

    @SafeHtml
    @Length(max = 512)
    @Column(name = "REMARKS")
    protected String remarks;

    @SafeHtml
    @NotBlank
    @Length(max = 120)
    @Column(name = "OWNERSHIP_TYPE")
    @Audited
    protected String ownershipType;

    @SafeHtml
    @NotBlank
    @Length(max = 250)
    @Column(name = "ADDRESS")
    @Audited
    protected String address;

    @SafeHtml
    @Length(max = 100)
    @Column(name = "TEMP_LICENSE_NUMBER")
    protected String tempLicenseNumber;

    @SafeHtml
    @Length(max = 50)
    @Column(name = "AGREEMENT_DOCUMENT_NO")
    @Audited
    protected String agreementDocNo;

    @SafeHtml
    @Length(max = 40)
    @Column(name = "digisignedcertfilestoreid")
    protected String digiSignedCertFileStoreId;

    @SafeHtml
    @Length(max = 64)
    @Column(name = "ASSESSMENTNO")
    protected String assessmentNo;

    @NotNull
    @Column(name = "APPL_DATE")
    @Temporal(TemporalType.DATE)
    @Audited
    protected Date applicationDate;

    @Column(name = "COMMENCEMENTDATE")
    @Temporal(TemporalType.DATE)
    @Audited
    protected Date commencementDate;

    @Column(name = "AGREEMENT_DATE")
    @Temporal(TemporalType.DATE)
    @Audited
    protected Date agreementDate;

    @Column(name = "DATEOFEXPIRY")
    @Temporal(TemporalType.DATE)
    protected Date dateOfExpiry;

    @Column(name = "IS_ACTIVE")
    protected boolean isActive;

    @Column(name = "ISLEGACY")
    protected boolean legacy;

    @Column(name = "TRADE_AREA_WEIGHT")
    @Audited
    protected BigDecimal tradeArea_weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EGWSTATUSID")
    protected EgwStatus egwStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ADM_BNDRY")
    protected Boundary boundary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PARENT_BNDRY")
    protected Boundary parentBoundary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adminward")
    protected Boundary adminWard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NATUREOFBUSINESS")
    protected NatureOfBusiness natureOfBusiness;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_demand")
    protected LicenseDemand licenseDemand;

    @Valid
    @OneToOne(mappedBy = "license", cascade = CascadeType.ALL)
    protected Licensee licensee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_STATUS")
    protected LicenseStatus status;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SUB_CATEGORY")
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected LicenseSubCategory tradeName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "licenseAppType")
    protected LicenseAppType licenseAppType;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORY")
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected LicenseCategory category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "license")
    protected List<LicenseDocument> documents = new ArrayList<>();

    @SafeHtml
    @Length(max = 40)
    protected String certificateFileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approvedBy")
    private User approvedBy;

    //To be removed
    private boolean newWorkflow;

    private boolean collectionPending;

    private boolean closed;

    @SafeHtml
    private String applicationSource;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(final Long id) {
        this.id = id;
    }

    public LicenseDemand getLicenseDemand() {
        return licenseDemand;
    }

    public void setLicenseDemand(final LicenseDemand licenseDemand) {
        this.licenseDemand = licenseDemand;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(final Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(final String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public Boundary getBoundary() {
        return boundary;
    }

    public void setBoundary(final Boundary boundary) {
        this.boundary = boundary;
    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(final Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(final boolean isActive) {
        this.isActive = isActive;
    }

    public Licensee getLicensee() {
        return licensee;
    }

    public void setLicensee(final Licensee licensee) {
        this.licensee = licensee;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(final String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getNameOfEstablishment() {
        return nameOfEstablishment;
    }

    public void setNameOfEstablishment(final String nameOfEstablishment) {
        this.nameOfEstablishment = nameOfEstablishment;
    }

    public String getOldLicenseNumber() {
        return oldLicenseNumber;
    }

    public void setOldLicenseNumber(final String oldLicenseNumber) {
        this.oldLicenseNumber = oldLicenseNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(final String remarks) {
        this.remarks = remarks;
    }

    public LicenseStatus getStatus() {
        return status;
    }

    public void setStatus(final LicenseStatus status) {
        this.status = status;
    }

    public String getTempLicenseNumber() {
        return tempLicenseNumber;
    }

    public void setTempLicenseNumber(final String tempLicenseNumber) {
        this.tempLicenseNumber = tempLicenseNumber;
    }

    public LicenseSubCategory getTradeName() {
        return tradeName;
    }

    public void setTradeName(final LicenseSubCategory tradeName) {
        this.tradeName = tradeName;
    }

    public void setActive(final boolean isActive) {
        this.isActive = isActive;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public LicenseCategory getCategory() {
        return category;
    }

    public void setCategory(final LicenseCategory category) {
        this.category = category;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(final String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public BigDecimal getTradeArea_weight() {
        return tradeArea_weight;
    }

    public void setTradeArea_weight(final BigDecimal tradeAreaweight) {
        tradeArea_weight = tradeAreaweight;
    }

    public NatureOfBusiness getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(final NatureOfBusiness natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public LicenseAppType getLicenseAppType() {
        return licenseAppType;
    }

    public void setLicenseAppType(final LicenseAppType licenseAppType) {
        this.licenseAppType = licenseAppType;
    }

    public boolean isLegacy() {
        return legacy;
    }

    public void setLegacy(final boolean legacy) {
        this.legacy = legacy;
    }

    public Date getCommencementDate() {
        return commencementDate;
    }

    public void setCommencementDate(final Date commencementDate) {
        this.commencementDate = commencementDate;
    }

    public EgwStatus getEgwStatus() {
        return egwStatus;
    }

    public void setEgwStatus(final EgwStatus egwStatus) {
        this.egwStatus = egwStatus;
    }

    public Boundary getParentBoundary() {
        return parentBoundary;
    }

    public void setParentBoundary(final Boundary parentBoundary) {
        this.parentBoundary = parentBoundary;
    }

    public Date getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(final Date agreementDate) {
        this.agreementDate = agreementDate;
    }

    public String getAgreementDocNo() {
        return agreementDocNo;
    }

    public void setAgreementDocNo(final String agreementDocNo) {
        this.agreementDocNo = agreementDocNo;
    }

    public String getDigiSignedCertFileStoreId() {
        return digiSignedCertFileStoreId;
    }

    public void setDigiSignedCertFileStoreId(final String digiSignedCertFileStoreId) {
        this.digiSignedCertFileStoreId = digiSignedCertFileStoreId;
    }

    public String getAssessmentNo() {
        return assessmentNo;
    }

    public void setAssessmentNo(final String assessmentNo) {
        this.assessmentNo = assessmentNo;
    }

    public List<LicenseDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(final List<LicenseDocument> documents) {
        this.documents = documents;
    }

    @Override
    public String getStateDetails() {
        return "";
    }

    public LicenseDemand getCurrentDemand() {
        return getLicenseDemand();
    }

    public boolean isPaid() {
        return getTotalBalance().compareTo(BigDecimal.ZERO) == 0;
    }

    public BigDecimal getTotalBalance() {
        return licenseDemand.getBaseDemand().subtract(licenseDemand.getAmtCollected());
    }

    public boolean isRejected() {
        return hasState() && getState().getValue().contains(WORKFLOW_STATE_REJECTED);
    }

    public boolean isApproved() {
        return hasState() && WF_STATE_COMMISSIONER_APPROVED_STR.equals(getState().getValue());
    }

    public boolean isAcknowledged() {
        return getStatus() != null && STATUS_ACKNOWLEDGED.equals(getStatus().getStatusCode());
    }

    public boolean canCollectFee() {
        return !isPaid() && !isRejected() && !isNatureOfTaskClosure() && (isAcknowledged() || isApproved());
    }

    private boolean isNatureOfTaskClosure() {
        return this.hasState() && CLOSURE_NATUREOFTASK.equals(this.getState().getNatureOfTask());
    }

    public boolean isStatusActive() {
        return getStatus() != null && STATUS_ACTIVE.equals(getStatus().getStatusCode());
    }

    public boolean isNewApplication() {
        return getLicenseAppType() != null && NEW_LIC_APPTYPE.equals(getLicenseAppType().getName());
    }

    public boolean isNewPermanentApplication() {
        return isNewApplication() && isPermanent();
    }

    public boolean isReNewApplication() {
        return getLicenseAppType() != null && RENEWAL_LIC_APPTYPE.equals(getLicenseAppType().getName());
    }

    public boolean isPermanent() {
        return PERMANENT_NATUREOFBUSINESS.equals(getNatureOfBusiness().getName());
    }

    public boolean isTemporary() {
        return TEMP_NATUREOFBUSINESS.equals(getNatureOfBusiness().getName());
    }

    public boolean isReadyForRenewal() {
        return isActiveAndPermanent()
                && getDateOfExpiry().before(getCurrentDemand().getEgInstallmentMaster().getToDate())
                && (transitionCompleted() || isLegacyWithNoState());
    }

    public boolean isActiveAndPermanent() {
        return isPermanent() && isActive;
    }

    public boolean isClosureApplicable() {
        return isStatusActive() || (getIsActive() && LICENSE_STATUS_CANCELLED.equals(getStatus().getName()));
    }

    public BigDecimal getLatestAmountPaid() {
        Optional<EgDemandDetails> demandDetails = this.getCurrentDemand().getEgDemandDetails().stream()
                .sorted(Comparator.comparing(EgDemandDetails::getInstallmentEndDate).reversed())
                .filter(demandDetail -> demandDetail.getEgDemandReason().getEgDemandReasonMaster().getReasonMaster().equals(LICENSE_FEE_TYPE))
                .filter(demandDetail -> demandDetail.getAmount().subtract(demandDetail.getAmtCollected())
                        .doubleValue() <= 0)
                .findFirst();
        return demandDetails.isPresent() ? demandDetails.get().getAmtCollected() : BigDecimal.ZERO;
    }

    public boolean isLegacyWithNoState() {
        return isLegacy() && !hasState();
    }

    public boolean isNewWorkflow() {
        return newWorkflow;
    }

    public void setNewWorkflow(boolean newWorkflow) {
        this.newWorkflow = newWorkflow;
    }

    public boolean isCollectionPending() {
        return collectionPending;
    }

    public void setCollectionPending(boolean collectionPending) {
        this.collectionPending = collectionPending;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public LicenseStateInfo extraInfo() {
        return super.extraInfoAs(LicenseStateInfo.class);
    }

    public boolean canCollectLicenseFee() {
        return this.isNewWorkflow() && !isNatureOfTaskClosure() && !isPaid() &&
                (STATUS_ACKNOWLEDGED.equals(this.getStatus().getStatusCode())
                        || STATUS_COLLECTIONPENDING.equals(this.getStatus().getStatusCode()));
    }

    public Boundary getAdminWard() {
        return adminWard;
    }

    public void setAdminWard(Boundary adminWard) {
        this.adminWard = adminWard;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getCertificateFileId() {
        return certificateFileId;
    }

    public void setCertificateFileId(String certificateFileId) {
        this.certificateFileId = certificateFileId;
    }

    public String getApplicationSource() {
        return applicationSource;
    }

    public void setApplicationSource(String applicationSource) {
        this.applicationSource = applicationSource;
    }

    public String generateCertificateFileName() {
        return new StringBuilder()
                .append(licenseAppType.getName().toLowerCase())
                .append(UNDERSCORE).append(appendTimestamp((isBlank(this.getLicenseNumber())
                        ? this.getApplicationNumber()
                        : this.getLicenseNumber()).replaceAll("[/-]", UNDERSCORE))).toString();
    }

    public File qrCode(String installmentYear, BigDecimal licenseFeePaid) {
        StringBuilder qrCodeContent = new StringBuilder(170);
        qrCodeContent.append("License Number : ").append(getLicenseNumber()).append(lineSeparator());
        qrCodeContent.append("Trade Title : ").append(getNameOfEstablishment()).append(lineSeparator());
        qrCodeContent.append("Owner Name : ").append(getLicensee().getApplicantName()).append(lineSeparator());
        qrCodeContent.append("Valid Till : ").append(toDefaultDateTimeFormat(getDateOfExpiry())).append(lineSeparator());
        qrCodeContent.append("Installment Year : ").append(installmentYear).append(lineSeparator());
        qrCodeContent.append("Paid Amount : ").append(currencySymbolUtf8()).append(licenseFeePaid).append(lineSeparator());
        qrCodeContent.append("More : ").append(ApplicationThreadLocals.getDomainURL())
                .append("/tl/viewtradelicense/viewTradeLicense-view.action?id=").append(getId());
        return generatePDF417Code(qrCodeContent.toString());
    }
}