package com.zzhy.system.service;

import java.util.List;
import com.zzhy.system.domain.Ga07;

/**
 * 助学金标准Service接口
 * 
 * @author zzhy
 * @date 2021-12-21
 */
public interface IGa07Service 
{
    /**
     * 查询助学金标准
     * 
     * @param age661 助学金标准主键
     * @return 助学金标准
     */
    public Ga07 selectGa07ByAge661(String age661);

    /**
     * 查询助学金标准列表
     * 
     * @param ga07 助学金标准
     * @return 助学金标准集合
     */
    public List<Ga07> selectGa07List(Ga07 ga07);

    /**
     * 新增助学金标准
     * 
     * @param ga07 助学金标准
     * @return 结果
     */
    public int insertGa07(Ga07 ga07);

    /**
     * 修改助学金标准
     * 
     * @param ga07 助学金标准
     * @return 结果
     */
    public int updateGa07(Ga07 ga07);

    /**
     * 批量删除助学金标准
     * 
     * @param age661s 需要删除的助学金标准主键集合
     * @return 结果
     */
    public int deleteGa07ByAge661s(String[] age661s);

    /**
     * 删除助学金标准信息
     * 
     * @param age661 助学金标准主键
     * @return 结果
     */
    public int deleteGa07ByAge661(String age661);
}
