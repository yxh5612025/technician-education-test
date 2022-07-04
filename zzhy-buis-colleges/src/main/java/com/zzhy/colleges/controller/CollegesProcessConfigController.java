package com.zzhy.colleges.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.zzhy.supervise.domain.CollegesProcessAuditConfig;
import com.zzhy.supervise.domain.vo.CollegesProcessConfigVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zzhy.common.annotation.Log;
import com.zzhy.common.core.controller.BaseController;
import com.zzhy.common.core.domain.AjaxResult;
import com.zzhy.common.enums.BusinessType;
import com.zzhy.supervise.domain.CollegesProcessConfig;
import com.zzhy.supervise.service.ICollegesProcessConfigService;
import com.zzhy.common.utils.poi.ExcelUtil;
import com.zzhy.common.core.page.TableDataInfo;

/**
 * 院校端申报流程配置Controller
 *
 * @author zzhy
 * @date 2022-06-05
 */
@RestController
@RequestMapping("/colleges/config")
public class CollegesProcessConfigController extends BaseController
{
    @Autowired
    private ICollegesProcessConfigService collegesProcessConfigService;

    /**
     * 查询院校端申报流程配置列表
     */
    @PreAuthorize("@ss.hasPermi('colleges:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(CollegesProcessConfig collegesProcessConfig)
    {
        long schoolId = collegesProcessConfigService.selectSysUserByUserId( getUserId());
        startPage();
        List<CollegesProcessConfigVo> list = collegesProcessConfigService.selectCollegesProcessConfigVoListAndSchoolId(collegesProcessConfig,schoolId);
        return getDataTable(list);
    }

    /**
     * 查询登录用户包含的角色以及当前学校已经配置审核配置表并进行回显
     */
//    @GetMapping("/declareConfigId/{declareConfigId}")
//    public AjaxResult declareConfigId(@PathVariable Long declareConfigId ){
//
//        return AjaxResult.success(collegesProcessConfigService.selectSysRoleList(declareConfigId,getUserId()));
//    }
    @GetMapping("/declareConfigId")
    public AjaxResult declareConfigId( Long declareConfigId ){

        return AjaxResult.success(collegesProcessConfigService.selectSysRoleList(declareConfigId,getUserId()));
    }
    @PutMapping("/edit")
    public  AjaxResult edit(@RequestBody Map<String,List<CollegesProcessAuditConfig>> configList){
        Boolean flag = collegesProcessConfigService.updateCollegesAuditProcessConfig(configList);
        return flag ? AjaxResult.success() :AjaxResult.error();
    }
    /**
     * 导出院校端申报流程配置列表
     */
    @PreAuthorize("@ss.hasPermi('supervise:config:export')")
    @Log(title = "院校端申报流程配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CollegesProcessConfig collegesProcessConfig)
    {
        List<CollegesProcessConfig> list = collegesProcessConfigService.selectCollegesProcessConfigList(collegesProcessConfig);
        ExcelUtil<CollegesProcessConfig> util = new ExcelUtil<CollegesProcessConfig>(CollegesProcessConfig.class);
        util.exportExcel(response, list, "院校端申报流程配置数据");
    }

    /**
     * 获取院校端申报流程配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('supervise:config:query')")
    @GetMapping(value = "/{schConfigId}")
    public AjaxResult getInfo(@PathVariable("schConfigId") Long schConfigId)
    {
        return AjaxResult.success(collegesProcessConfigService.selectCollegesProcessConfigBySchConfigId(schConfigId));
    }

    /**
     * 新增院校端申报流程配置
     */
    @PreAuthorize("@ss.hasPermi('supervise:config:add')")
    @Log(title = "院校端申报流程配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CollegesProcessConfig collegesProcessConfig)
    {
        return toAjax(collegesProcessConfigService.insertCollegesProcessConfig(collegesProcessConfig));
    }

    /**
     * 修改院校端申报流程配置
     */
    @PreAuthorize("@ss.hasPermi('supervise:config:edit')")
    @Log(title = "院校端申报流程配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CollegesProcessConfig collegesProcessConfig)
    {
        return toAjax(collegesProcessConfigService.updateCollegesProcessConfig(collegesProcessConfig));
    }

    /**
     * 删除院校端申报流程配置
     */
    @PreAuthorize("@ss.hasPermi('supervise:config:remove')")
    @Log(title = "院校端申报流程配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{schConfigIds}")
    public AjaxResult remove(@PathVariable Long[] schConfigIds)
    {
        return toAjax(collegesProcessConfigService.deleteCollegesProcessConfigBySchConfigIds(schConfigIds));
    }
}
