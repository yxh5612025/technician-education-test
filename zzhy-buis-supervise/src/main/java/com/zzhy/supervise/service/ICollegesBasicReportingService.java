package com.zzhy.supervise.service;

import java.util.List;
import com.zzhy.supervise.domain.CollegesBasicReporting;
import com.zzhy.supervise.domain.SupDeclareCollegesSchoolAudit;

/**
 * 院校基本情况报备Service接口
 * 
 * @author zzhy
 * @date 2022-06-05
 */
public interface ICollegesBasicReportingService 
{
    /**
     * 查询院校基本情况报备
     * 
     * @param reportingId 院校基本情况报备主键
     * @return 院校基本情况报备
     */
    public CollegesBasicReporting selectCollegesBasicReportingByReportingId(Long reportingId);

    /**
     * 查询院校基本情况报备列表
     * 
     * @param collegesBasicReporting 院校基本情况报备
     * @return 院校基本情况报备集合
     */
    public List<CollegesBasicReporting> selectCollegesBasicReportingList(CollegesBasicReporting collegesBasicReporting);

    /**
     * 新增院校基本情况报备
     * 
     * @param collegesBasicReporting 院校基本情况报备
     * @return 结果
     */
    public int insertCollegesBasicReporting(CollegesBasicReporting collegesBasicReporting);

    /**
     * 修改院校基本情况报备
     * 
     * @param collegesBasicReporting 院校基本情况报备
     * @return 结果
     */
    public int updateCollegesBasicReporting(CollegesBasicReporting collegesBasicReporting);

    /**
     * 批量删除院校基本情况报备
     * 
     * @param reportingIds 需要删除的院校基本情况报备主键集合
     * @return 结果
     */
    public int deleteCollegesBasicReportingByReportingIds(Long[] reportingIds);

    /**
     * 删除院校基本情况报备信息
     * 
     * @param reportingId 院校基本情况报备主键
     * @return 结果
     */
    public int deleteCollegesBasicReportingByReportingId(Long reportingId);

    List<SupDeclareCollegesSchoolAudit> selectSupDeclareCollegesSchoolAudit(Long reportingId);
}
