package com.zzhy.supervise.mapper;

import java.util.List;

import com.zzhy.common.core.domain.entity.SysDept;
import com.zzhy.supervise.domain.CollegesBasicReporting;
import com.zzhy.supervise.domain.SupDeclareCollegesSchoolAudit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * 院校基本情况报备Mapper接口
 * 
 * @author zzhy
 * @date 2022-06-05
 */
public interface CollegesBasicReportingMapper 
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
     * 删除院校基本情况报备
     * 
     * @param reportingId 院校基本情况报备主键
     * @return 结果
     */
    public int deleteCollegesBasicReportingByReportingId(Long reportingId);

    /**
     * 批量删除院校基本情况报备
     * 
     * @param reportingIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCollegesBasicReportingByReportingIds(Long[] reportingIds);

    @Insert("insert into sup_declare_colleges_school_audit (school_id,source_id,dept_id,dept_name,role_id,role_name,audit_order,type,sch_process_config_id,audit_status,audit_by) " +
            "values (#{schoolId},#{sourceId},#{deptId},#{deptName},#{roleId},#{roleName},#{auditOrder},#{type},#{schProcessConfigId},#{auditStatus},#{auditBy})")
    int insertDeclareCollegesSchoolAudit(SupDeclareCollegesSchoolAudit supDeclareCollegesSchoolAudit);

    @Select("select * from sys_dept where dept_id = #{deptId} ")
    SysDept selectDeptByDeptId(Long deptId);

    @Select("select * from sup_declare_colleges_school_audit where source_id= #{sourceId} ")
    List<SupDeclareCollegesSchoolAudit> selectSupDeclareCollegesSchoolAudit(Long reportingId);
}
