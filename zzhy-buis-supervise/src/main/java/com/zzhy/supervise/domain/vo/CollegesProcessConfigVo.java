package com.zzhy.supervise.domain.vo;

import com.zzhy.common.annotation.Excel;
import com.zzhy.common.core.domain.BaseEntity;
import com.zzhy.supervise.domain.CollegesProcessAuditConfig;
import com.zzhy.supervise.domain.CollegesProcessConfig;
import lombok.Data;

import java.util.List;
@Data
public class CollegesProcessConfigVo extends BaseEntity {
    //院校端申报流程审核配置
    private List<CollegesProcessAuditConfig> CollegesProcessAuditConfig;

    /** 院校端的配置id */
    private Long schConfigId;

    /** 监管端流程配置id */
    @Excel(name = "监管端流程配置id")
    private Long supProcessId;

    /** 流程编码 */
    @Excel(name = "流程编码")
    private String processCode;

    /** 流程名称 */
    @Excel(name = "流程名称")
    private String processName;

    /** 流程头像 */
    @Excel(name = "流程头像")
    private String processImg;

    /** 审核层级,默认为1层 */
    @Excel(name = "审核层级,默认为1层")
    private Long auditLevel;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 状态 1正常,2停用 */
    @Excel(name = "状态 1正常,2停用")
    private String status;

    /** 删除标志（1代表存在 2代表删除） */
    private String delFlag;

    /** 上传文件的的相对路径 */
    @Excel(name = "上传文件的的相对路径")
    private String filePath;

    public CollegesProcessConfigVo() {
    }

    @Override
    public String toString() {
        return "CollegesProcessConfigVo{" +
                "CollegesProcessAuditConfig=" + CollegesProcessAuditConfig +
                ", schConfigId=" + schConfigId +
                ", supProcessId=" + supProcessId +
                ", processCode='" + processCode + '\'' +
                ", processName='" + processName + '\'' +
                ", processImg='" + processImg + '\'' +
                ", auditLevel=" + auditLevel +
                ", sort=" + sort +
                ", status='" + status + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }

    public CollegesProcessConfigVo(List<com.zzhy.supervise.domain.CollegesProcessAuditConfig> collegesProcessAuditConfig, Long schConfigId, Long supProcessId, String processCode, String processName, String processImg, Long auditLevel, Long sort, String status, String delFlag, String filePath) {
        CollegesProcessAuditConfig = collegesProcessAuditConfig;
        this.schConfigId = schConfigId;
        this.supProcessId = supProcessId;
        this.processCode = processCode;
        this.processName = processName;
        this.processImg = processImg;
        this.auditLevel = auditLevel;
        this.sort = sort;
        this.status = status;
        this.delFlag = delFlag;
        this.filePath = filePath;
    }

    public List<com.zzhy.supervise.domain.CollegesProcessAuditConfig> getCollegesProcessAuditConfig() {
        return CollegesProcessAuditConfig;
    }

    public void setCollegesProcessAuditConfig(List<com.zzhy.supervise.domain.CollegesProcessAuditConfig> collegesProcessAuditConfig) {
        CollegesProcessAuditConfig = collegesProcessAuditConfig;
    }

    public Long getSchConfigId() {
        return schConfigId;
    }

    public void setSchConfigId(Long schConfigId) {
        this.schConfigId = schConfigId;
    }

    public Long getSupProcessId() {
        return supProcessId;
    }

    public void setSupProcessId(Long supProcessId) {
        this.supProcessId = supProcessId;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessImg() {
        return processImg;
    }

    public void setProcessImg(String processImg) {
        this.processImg = processImg;
    }

    public Long getAuditLevel() {
        return auditLevel;
    }

    public void setAuditLevel(Long auditLevel) {
        this.auditLevel = auditLevel;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
