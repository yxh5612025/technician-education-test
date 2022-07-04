package com.zzhy.common.core.domain.entity;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zzhy.common.core.domain.BaseEntity;

/**
 * 部门表 sys_dept
 * 
 * @author ruoyi
 */
@Data
public class SysDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门ID */
    @ApiModelProperty(value = "部门ID")
    private Long deptId;

    /** 父部门ID */
    @ApiModelProperty(value = "父部门ID")
    private Long parentId;

    /** 祖级列表 */
    @ApiModelProperty(value = "祖级列表")
    private String ancestors;

    /** 部门名称 */
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    /** 显示顺序 */
    @ApiModelProperty(value = "显示顺序")
    private String orderNum;

    /** 负责人 */
    @ApiModelProperty(value = "负责人")
    private String leader;

    /** 联系电话 */
    @ApiModelProperty(value = "联系电话")
    private String phone;

    /** 邮箱 */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /** 部门状态:0正常,1停用 */
    @ApiModelProperty(value = "部门状态:0正常,1停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
    private String delFlag;

    //机构类型  1部门，2学校，3院/系，8科室，9校区
    @ApiModelProperty(value = "机构类型  1部门，2学校，3院/系，8科室，9校区")
    private Integer orgType;

    //层级 1区/县，2市，3省
    @ApiModelProperty(value = "层级 1区/县，2市，3省")
    private Integer hierarchy;

    //行政区划
    @ApiModelProperty(value = "行政区划")
    private Long areaId;

    //详情ID(学校,院系,校区 等表的ID)
    @ApiModelProperty(value = "详情ID(学校,院系,校区 等表的ID)")
    private Long detailId;

    //标识符   1表示查询全部，2表示排除科室
    @ApiModelProperty(value = "标识符   1表示查询全部，2表示排除科室")
    private Integer flag;

    /** 父部门名称 */
    @ApiModelProperty(value = "父部门名称")
    private String parentName;
    
    /** 子部门 */
    private List<SysDept> children = new ArrayList<SysDept>();


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public Integer getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(Integer hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Long getDeptId()
    {
        return deptId;
    }

    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getParentId()
    {
        return parentId;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    public String getAncestors()
    {
        return ancestors;
    }

    public void setAncestors(String ancestors)
    {
        this.ancestors = ancestors;
    }

    @NotBlank(message = "部门名称不能为空")
    @Size(min = 0, max = 30, message = "部门名称长度不能超过30个字符")
    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    @NotBlank(message = "显示顺序不能为空")
    public String getOrderNum()
    {
        return orderNum;
    }

    public void setOrderNum(String orderNum)
    {
        this.orderNum = orderNum;
    }

    public String getLeader()
    {
        return leader;
    }

    public void setLeader(String leader)
    {
        this.leader = leader;
    }

    @Size(min = 0, max = 11, message = "联系电话长度不能超过11个字符")
    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getParentName()
    {
        return parentName;
    }

    public void setParentName(String parentName)
    {
        this.parentName = parentName;
    }

    public List<SysDept> getChildren()
    {
        return children;
    }

    public void setChildren(List<SysDept> children)
    {
        this.children = children;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptId", getDeptId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("deptName", getDeptName())
            .append("orderNum", getOrderNum())
            .append("leader", getLeader())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
