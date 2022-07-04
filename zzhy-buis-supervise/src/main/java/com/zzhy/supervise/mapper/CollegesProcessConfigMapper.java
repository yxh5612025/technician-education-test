package com.zzhy.supervise.mapper;

import java.util.List;

import com.zzhy.common.core.domain.entity.SysRole;
import com.zzhy.supervise.domain.CollegesProcessAuditConfig;
import com.zzhy.supervise.domain.CollegesProcessConfig;
import com.zzhy.system.domain.SysUserRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.data.repository.query.Param;

/**
 * 院校端申报流程配置Mapper接口
 * 
 * @author zzhy
 * @date 2022-06-05
 */
public interface CollegesProcessConfigMapper 
{
    /**
     * 查询院校端申报流程配置
     * 
     * @param schConfigId 院校端申报流程配置主键
     * @return 院校端申报流程配置
     */
    public CollegesProcessConfig selectCollegesProcessConfigBySchConfigId(Long schConfigId);

    /**
     * 查询院校端申报流程配置列表
     * 
     * @param collegesProcessConfig 院校端申报流程配置
     * @return 院校端申报流程配置集合
     */
    public List<CollegesProcessConfig> selectCollegesProcessConfigList(CollegesProcessConfig collegesProcessConfig);

    /**
     * 新增院校端申报流程配置
     * 
     * @param collegesProcessConfig 院校端申报流程配置
     * @return 结果
     */
    public int insertCollegesProcessConfig(CollegesProcessConfig collegesProcessConfig);

    /**
     * 修改院校端申报流程配置
     * 
     * @param collegesProcessConfig 院校端申报流程配置
     * @return 结果
     */
    public int updateCollegesProcessConfig(CollegesProcessConfig collegesProcessConfig);

    /**
     * 删除院校端申报流程配置
     * 
     * @param schConfigId 院校端申报流程配置主键
     * @return 结果
     */
    public int deleteCollegesProcessConfigBySchConfigId(Long schConfigId);

    /**
     * 批量删除院校端申报流程配置
     * 
     * @param schConfigIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCollegesProcessConfigBySchConfigIds(Long[] schConfigIds);




    @Select("select school_id from sys_user where user_id = #{userId}")
    long selectSysUserByUserId(Long userId);

    @Select("select * from sch_colleges_process_audit_config where sch_config_id = #{arg0} and school_id = #{arg1} and del_flag = '1'")
    List<CollegesProcessAuditConfig> selectCollegesProcessConfigVoListAndSchoolId(Long schConfigId, Long schoolId);

    @Select("select user_id,role_id from sys_user_role where user_id = #{userId}")
    List<SysUserRole> selectSysUserRoleByUserId(Long userId);

    @Select("select * from sys_role where role_id = #{roleId}")
    SysRole selectSysRoleByRoleId(Long roleId);

    @Update("update sch_colleges_process_audit_config set del_flag ='2' where sch_config_id =#{schConfigId}   ")//  and del_flag = '1' and audit_order=#{auditOrder}
    Boolean deleteCollegesProcessAuditConfigBycollegesProcessAuditConfig(CollegesProcessAuditConfig collegesProcessAuditConfig);

    @Select("select * from sch_colleges_process_audit_config where sch_config_id =#{arg0} and school_id = #{arg1} and del_flag = '1' ")
    List<CollegesProcessAuditConfig> selectCollegesProcessAuditConfiglistBySchoolIdAndSchConfigId(Long schConfigId,Long schoolId);

//    @Select("select * from sch_colleges_process_audit_config where sch_config_id =#{schConfigId}  and del_flag ='1'  and  role_id= #{roleId} and role_name =#{roleName}") //and audit_order=#{auditOrder}
//    CollegesProcessAuditConfig selectCollegesProcessAuditConfig(CollegesProcessAuditConfig collegesProcessAuditConfig);

    @Insert({"insert into sch_colleges_process_audit_config(sch_config_id, dept_id,school_id,audit_order,role_id,role_name,audit_state,audit_by,audit_time,sort,status,create_by,create_time,update_by,update_time,del_flag) " +
            "values(#{schConfigId},#{deptId},#{schoolId},#{auditOrder},#{roleId},#{roleName},#{auditState},#{auditBy},#{auditTime},#{sort},#{status},#{createBy},#{createTime},#{updateBy},#{updateTime},'1')"})
    int insertCollegesProcessAuditConfig(CollegesProcessAuditConfig collegesProcessAuditConfig);


}
