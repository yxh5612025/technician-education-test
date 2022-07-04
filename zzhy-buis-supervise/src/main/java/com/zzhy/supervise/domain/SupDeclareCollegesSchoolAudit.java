package com.zzhy.supervise.domain;

import java.util.Date;

public class SupDeclareCollegesSchoolAudit {

    private static final long serialVersionUID = 1L;

    private Long auditId;

    private String deptLevel;

    private String auditLevel;

    private String appointStatus;

    private Long schoolId;

    private Byte auditOrder;

    private String type;

    private Long sourceId;

    private Long supProcessConfigId;

    private Long schProcessConfigId;

    private Long partProcessAuditId;

    private Long deptId;

    private String deptName;

    private Long roleId;

    private String roleName;

    private String auditStatus;

    private Long auditBy;

    private Date auditTime;

    private String auditRemark;

    private String status;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String delFlag;

    private String remark;

    private String showType;

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel == null ? null : deptLevel.trim();
    }

    public String getAuditLevel() {
        return auditLevel;
    }

    public void setAuditLevel(String auditLevel) {
        this.auditLevel = auditLevel == null ? null : auditLevel.trim();
    }

    public String getAppointStatus() {
        return appointStatus;
    }

    public void setAppointStatus(String appointStatus) {
        this.appointStatus = appointStatus == null ? null : appointStatus.trim();
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Byte getAuditOrder() {
        return auditOrder;
    }

    public void setAuditOrder(Byte auditOrder) {
        this.auditOrder = auditOrder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getSupProcessConfigId() {
        return supProcessConfigId;
    }

    public void setSupProcessConfigId(Long supProcessConfigId) {
        this.supProcessConfigId = supProcessConfigId;
    }

    public Long getSchProcessConfigId() {
        return schProcessConfigId;
    }

    public void setSchProcessConfigId(Long schProcessConfigId) {
        this.schProcessConfigId = schProcessConfigId;
    }

    public Long getPartProcessAuditId() {
        return partProcessAuditId;
    }

    public void setPartProcessAuditId(Long partProcessAuditId) {
        this.partProcessAuditId = partProcessAuditId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public Long getAuditBy() {
        return auditBy;
    }

    public void setAuditBy(Long auditBy) {
        this.auditBy = auditBy;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark == null ? null : auditRemark.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType == null ? null : showType.trim();
    }
}
