package com.zzhy.supervise.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zzhy.common.core.controller.BaseController;
import com.zzhy.common.core.domain.entity.SysRole;
import com.zzhy.common.utils.DateUtils;
import com.zzhy.common.utils.StringUtils;
import com.zzhy.supervise.domain.CollegesProcessAuditConfig;
import com.zzhy.supervise.domain.vo.CollegesProcessConfigVo;
import com.zzhy.system.domain.SysUserRole;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zzhy.supervise.mapper.CollegesProcessConfigMapper;
import com.zzhy.supervise.domain.CollegesProcessConfig;
import com.zzhy.supervise.service.ICollegesProcessConfigService;

/**
 * 院校端申报流程配置Service业务层处理
 *
 * @author zzhy
 * @date 2022-06-05
 */
@Service
public class CollegesProcessConfigServiceImpl implements ICollegesProcessConfigService
{
    @Autowired
    private CollegesProcessConfigMapper collegesProcessConfigMapper;

    /**
     * 查询院校端申报流程配置
     *
     * @param schConfigId 院校端申报流程配置主键
     * @return 院校端申报流程配置
     */
    @Override
    public CollegesProcessConfig selectCollegesProcessConfigBySchConfigId(Long schConfigId)
    {
        return collegesProcessConfigMapper.selectCollegesProcessConfigBySchConfigId(schConfigId);
    }
    /**
     * 查询院校端申报流程配置列表
     *
     * @param collegesProcessConfig 院校端申报流程配置
     * @return 院校端申报流程配置
     */
    @Override
    public List<CollegesProcessConfig> selectCollegesProcessConfigList(CollegesProcessConfig collegesProcessConfig) {
        return collegesProcessConfigMapper.selectCollegesProcessConfigList(collegesProcessConfig);
    }





    /**
     * 新增院校端申报流程配置
     *
     * @param collegesProcessConfig 院校端申报流程配置
     * @return 结果
     */
    @Override
    public int insertCollegesProcessConfig(CollegesProcessConfig collegesProcessConfig)
    {
        collegesProcessConfig.setCreateTime(DateUtils.getNowDate());
        return collegesProcessConfigMapper.insertCollegesProcessConfig(collegesProcessConfig);
    }

    /**
     * 修改院校端申报流程配置
     *
     * @param collegesProcessConfig 院校端申报流程配置
     * @return 结果
     */
    @Override
    public int updateCollegesProcessConfig(CollegesProcessConfig collegesProcessConfig)
    {
        collegesProcessConfig.setUpdateTime(DateUtils.getNowDate());
        return collegesProcessConfigMapper.updateCollegesProcessConfig(collegesProcessConfig);
    }

    /**
     * 批量删除院校端申报流程配置
     *
     * @param schConfigIds 需要删除的院校端申报流程配置主键
     * @return 结果
     */
    @Override
    public int deleteCollegesProcessConfigBySchConfigIds(Long[] schConfigIds)
    {
        return collegesProcessConfigMapper.deleteCollegesProcessConfigBySchConfigIds(schConfigIds);
    }

    /**
     * 删除院校端申报流程配置信息
     *
     * @param schConfigId 院校端申报流程配置主键
     * @return 结果
     */
    @Override
    public int deleteCollegesProcessConfigBySchConfigId(Long schConfigId)
    {
        return collegesProcessConfigMapper.deleteCollegesProcessConfigBySchConfigId(schConfigId);
    }

    @Override
    public long selectSysUserByUserId(Long userId) {
        return collegesProcessConfigMapper.selectSysUserByUserId(userId);
    }

    @Override
    public List<CollegesProcessConfigVo> selectCollegesProcessConfigVoListAndSchoolId(CollegesProcessConfig collegesProcessConfig, long schoolId) {
        List<CollegesProcessConfigVo> collegesProcessConfigVos = new ArrayList<CollegesProcessConfigVo>();
        List<CollegesProcessConfig> collegesProcessConfigs = collegesProcessConfigMapper.selectCollegesProcessConfigList(collegesProcessConfig);
        for (CollegesProcessConfig collegesProcessConfig1 : collegesProcessConfigs){
            CollegesProcessConfigVo collegesProcessConfigVo = new CollegesProcessConfigVo();
            BeanUtils.copyProperties(collegesProcessConfig1,collegesProcessConfigVo);
            List collegesProcessAuditConfigs= collegesProcessConfigMapper.selectCollegesProcessConfigVoListAndSchoolId(collegesProcessConfig1.getSchConfigId(),schoolId);
            collegesProcessConfigVo.setCollegesProcessAuditConfig(collegesProcessAuditConfigs);
            collegesProcessConfigVos.add(collegesProcessConfigVo);
        }
        return collegesProcessConfigVos;
    }

    @Override
    public Map<String, List> selectSysRoleList(Long declareConfigId,Long userId) {
        HashMap<String, List> map = new HashMap<>();
        CollegesProcessConfig collegesProcessConfig = new CollegesProcessConfig();
        collegesProcessConfig.setSchConfigId(declareConfigId);
        long schoolId = selectSysUserByUserId(userId);
        List<SysUserRole> sysUserRoleList = collegesProcessConfigMapper.selectSysUserRoleByUserId(userId);
        List<SysRole> sysRoleList = new ArrayList<>();
        for (SysUserRole sysUserRole: sysUserRoleList) {
            SysRole sysRole =  collegesProcessConfigMapper.selectSysRoleByRoleId(sysUserRole.getRoleId());
            sysRoleList.add(sysRole);
        }
        List<CollegesProcessAuditConfig> collegesProcessAuditConfigs = collegesProcessConfigMapper.selectCollegesProcessAuditConfiglistBySchoolIdAndSchConfigId(declareConfigId, schoolId);

        map.put("roles",sysRoleList);

        map.put("configList",collegesProcessAuditConfigs);
        return map;
    }

    @Override
    public Boolean updateCollegesAuditProcessConfig(Map<String, List<CollegesProcessAuditConfig>> collegesProcessAuditConfigs) {
        List<CollegesProcessAuditConfig> collegesProcessAuditConfigList = collegesProcessAuditConfigs.get("configList");
        CollegesProcessAuditConfig collegesProcessAuditConfig1 = collegesProcessAuditConfigList.get(0);
        collegesProcessConfigMapper.deleteCollegesProcessAuditConfigBycollegesProcessAuditConfig(collegesProcessAuditConfig1);

        for (CollegesProcessAuditConfig collegesProcessAuditConfig :collegesProcessAuditConfigList) {
                Boolean flag = true;
                if (StringUtils.isEmpty(collegesProcessAuditConfig.getRoleName())||collegesProcessAuditConfig.getSchConfigId()==null
                        || collegesProcessAuditConfig.getRoleId() ==null || collegesProcessAuditConfig.getAuditOrder() == null){
                    return false;
                }



                collegesProcessAuditConfig.setSchoolId( selectSysUserByUserId(new BaseController().getUserId()));
                int count = collegesProcessConfigMapper.insertCollegesProcessAuditConfig(collegesProcessAuditConfig);
                if (count < 1){
                    return false;
                }
            }




        return true;
    }
}
