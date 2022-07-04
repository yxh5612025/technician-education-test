package com.zzhy.supervise.service.impl;

import java.util.Date;
import java.util.List;

import com.zzhy.common.core.controller.BaseController;
import com.zzhy.common.core.domain.entity.SysDept;
import com.zzhy.common.core.domain.entity.SysRole;
import com.zzhy.common.enums.ReportingEnum;
import com.zzhy.common.utils.DateUtils;
import com.zzhy.supervise.domain.CollegesProcessAuditConfig;
import com.zzhy.supervise.domain.School;
import com.zzhy.supervise.domain.SupDeclareCollegesSchoolAudit;
import com.zzhy.supervise.mapper.CollegesProcessConfigMapper;
import com.zzhy.supervise.mapper.SchoolMapper;
import com.zzhy.supervise.service.ICollegesProcessConfigService;
import com.zzhy.system.domain.SysUserRole;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zzhy.supervise.mapper.CollegesBasicReportingMapper;
import com.zzhy.supervise.domain.CollegesBasicReporting;
import com.zzhy.supervise.service.ICollegesBasicReportingService;

/**
 * 院校基本情况报备Service业务层处理
 * 
 * @author zzhy
 * @date 2022-06-05
 */
@Service
public class CollegesBasicReportingServiceImpl implements ICollegesBasicReportingService 
{
    @Autowired
    private CollegesBasicReportingMapper collegesBasicReportingMapper;

    @Autowired
    private CollegesProcessConfigMapper collegesProcessConfigMapper;

    @Autowired
    private SchoolMapper schoolMapper;
    /**
     * 查询院校基本情况报备
     * 
     * @param reportingId 院校基本情况报备主键
     * @return 院校基本情况报备
     */
    @Override
    public CollegesBasicReporting selectCollegesBasicReportingByReportingId(Long reportingId)
    {
        return collegesBasicReportingMapper.selectCollegesBasicReportingByReportingId(reportingId);
    }

    /**
     * 查询院校基本情况报备列表
     * 
     * @param collegesBasicReporting 院校基本情况报备
     * @return 院校基本情况报备
     */
    @Override
    public List<CollegesBasicReporting> selectCollegesBasicReportingList(CollegesBasicReporting collegesBasicReporting)
    {
        return collegesBasicReportingMapper.selectCollegesBasicReportingList(collegesBasicReporting);
    }

    /**
     * 新增院校基本情况报备
     * 
     * @param collegesBasicReporting 院校基本情况报备
     * @return 结果
     */
    @Override
    public int insertCollegesBasicReporting(CollegesBasicReporting collegesBasicReporting)
    {
        collegesBasicReporting.setCreateTime(DateUtils.getNowDate());
        collegesBasicReporting.setSchProcessId(ReportingEnum.SourceId.YXBB.value);
        collegesBasicReporting.setReportingDate(DateUtils.getNowDate());
        collegesBasicReporting.setReportingYear(DateUtils.getYear(new Date()));
        int i = collegesBasicReportingMapper.insertCollegesBasicReporting(collegesBasicReporting);
        int j = 0;
        byte audit_order =0;
        Long userId = new BaseController().getUserId();
        Long schoolId = collegesProcessConfigMapper.selectSysUserByUserId(userId);
        List<CollegesProcessAuditConfig> collegesProcessAuditConfigs = collegesProcessConfigMapper.selectCollegesProcessAuditConfiglistBySchoolIdAndSchConfigId(2L, schoolId);
        byte auditOrder = (byte) (collegesProcessAuditConfigs.size());
        School school = schoolMapper.selectSchoolBySchoolId(schoolId);
        SysDept sysDept = collegesBasicReportingMapper.selectDeptByDeptId(school.getDeptId());

        for (CollegesProcessAuditConfig collegesProcessAuditConfig:collegesProcessAuditConfigs) {
            audit_order++;
            SupDeclareCollegesSchoolAudit supDeclareCollegesSchoolAudit = new SupDeclareCollegesSchoolAudit();
            supDeclareCollegesSchoolAudit.setSchoolId(schoolId);
            supDeclareCollegesSchoolAudit.setRoleId(collegesProcessAuditConfig.getRoleId());
            supDeclareCollegesSchoolAudit.setRoleName(collegesProcessAuditConfig.getRoleName());
            supDeclareCollegesSchoolAudit.setAuditOrder(audit_order);
            supDeclareCollegesSchoolAudit.setType("1");
            supDeclareCollegesSchoolAudit.setSchProcessConfigId(ReportingEnum.SourceId.YXBB.value);
            supDeclareCollegesSchoolAudit.setSourceId(collegesBasicReporting.getReportingId());
            supDeclareCollegesSchoolAudit.setDeptId(collegesProcessAuditConfig.getRoleId());
            supDeclareCollegesSchoolAudit.setDeptName(collegesProcessAuditConfig.getRoleName());
            supDeclareCollegesSchoolAudit.setAuditStatus("1");
            supDeclareCollegesSchoolAudit.setAuditBy(userId);
            j = collegesBasicReportingMapper.insertDeclareCollegesSchoolAudit(supDeclareCollegesSchoolAudit);



        }
        String ancestors = sysDept.getAncestors();
        String[] str = ancestors.split(",");
        for(int c=str.length-1;c<0;c--){
            long id = Long.parseLong(str[c]);
            if (id != 0){
                auditOrder++;
                SupDeclareCollegesSchoolAudit supDeclareCollegesSchoolAudit = new SupDeclareCollegesSchoolAudit();
                supDeclareCollegesSchoolAudit.setSchoolId(schoolId);
                supDeclareCollegesSchoolAudit.setType("1");
                supDeclareCollegesSchoolAudit.setSchProcessConfigId(ReportingEnum.SourceId.YXBB.value);
                supDeclareCollegesSchoolAudit.setAuditStatus("1");
                supDeclareCollegesSchoolAudit.setAuditBy(userId);
                SysDept sysDept1 = collegesBasicReportingMapper.selectDeptByDeptId(id);
                String deptName = sysDept1.getDeptName();
                supDeclareCollegesSchoolAudit.setAuditOrder(auditOrder);
                supDeclareCollegesSchoolAudit.setDeptId(id);
                supDeclareCollegesSchoolAudit.setDeptName(deptName);
                supDeclareCollegesSchoolAudit.setRoleId(id);
                supDeclareCollegesSchoolAudit.setRoleName(deptName);
                supDeclareCollegesSchoolAudit.setSourceId(collegesBasicReporting.getReportingId());
                j = collegesBasicReportingMapper.insertDeclareCollegesSchoolAudit(supDeclareCollegesSchoolAudit);
            }
        }



        return i > 0 && j > 0 ? 1 : 0;
    }

    /**
     * 修改院校基本情况报备
     * 
     * @param collegesBasicReporting 院校基本情况报备
     * @return 结果
     */
    @Override
    public int updateCollegesBasicReporting(CollegesBasicReporting collegesBasicReporting)
    {
        collegesBasicReporting.setUpdateTime(DateUtils.getNowDate());
        return collegesBasicReportingMapper.updateCollegesBasicReporting(collegesBasicReporting);

    }

    /**
     * 批量删除院校基本情况报备
     * 
     * @param reportingIds 需要删除的院校基本情况报备主键
     * @return 结果
     */
    @Override
    public int deleteCollegesBasicReportingByReportingIds(Long[] reportingIds)
    {
        return collegesBasicReportingMapper.deleteCollegesBasicReportingByReportingIds(reportingIds);
    }

    /**
     * 删除院校基本情况报备信息
     * 
     * @param reportingId 院校基本情况报备主键
     * @return 结果
     */
    @Override
    public int deleteCollegesBasicReportingByReportingId(Long reportingId)
    {
        return collegesBasicReportingMapper.deleteCollegesBasicReportingByReportingId(reportingId);
    }

    @Override
    public List<SupDeclareCollegesSchoolAudit> selectSupDeclareCollegesSchoolAudit(Long reportingId) {
        return  collegesBasicReportingMapper.selectSupDeclareCollegesSchoolAudit(reportingId);
    }
}
