package com.zzhy.supervise.service;

import java.util.List;
import java.util.Map;

import com.zzhy.supervise.domain.CollegesProcessAuditConfig;
import com.zzhy.supervise.domain.CollegesProcessConfig;
import com.zzhy.supervise.domain.vo.CollegesProcessConfigVo;

/**
 * 院校端申报流程配置Service接口
 * 
 * @author zzhy
 * @date 2022-06-05
 */
public interface ICollegesProcessConfigService 
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
     * 批量删除院校端申报流程配置
     * 
     * @param schConfigIds 需要删除的院校端申报流程配置主键集合
     * @return 结果
     */
    public int deleteCollegesProcessConfigBySchConfigIds(Long[] schConfigIds);

    /**
     * 删除院校端申报流程配置信息
     * 
     * @param schConfigId 院校端申报流程配置主键
     * @return 结果
     */
    public int deleteCollegesProcessConfigBySchConfigId(Long schConfigId);
    /**
     * 根据用户id查询学校id
     * @param userId
     * @return
     */
    long selectSysUserByUserId(Long userId);
    /**
     封装数据
     */
    List<CollegesProcessConfigVo> selectCollegesProcessConfigVoListAndSchoolId(CollegesProcessConfig collegesProcessConfig, long schoolId);
    /**
     * 查询登录用户包含的角色以及当前学校已经配置审核配置表并进行回显
     */
    Map<String, List> selectSysRoleList(Long declareConfigId,Long userId);

    Boolean updateCollegesAuditProcessConfig(Map<String, List<CollegesProcessAuditConfig>> collegesProcessAuditConfigs);
}
