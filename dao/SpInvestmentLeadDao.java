package .dao;

import .entity.SpInvestmentLead;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 招商线索列表(SpInvestmentLead)表数据库访问层
 *
 * @author MengHuan
 * @since 2023-04-03 11:09:31
 */
public interface SpInvestmentLeadDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SpInvestmentLead queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param spInvestmentLead 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SpInvestmentLead> queryAllByLimit(SpInvestmentLead spInvestmentLead, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param spInvestmentLead 查询条件
     * @return 总行数
     */
    long count(SpInvestmentLead spInvestmentLead);

    /**
     * 新增数据
     *
     * @param spInvestmentLead 实例对象
     * @return 影响行数
     */
    int insert(SpInvestmentLead spInvestmentLead);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SpInvestmentLead> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SpInvestmentLead> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SpInvestmentLead> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SpInvestmentLead> entities);

    /**
     * 修改数据
     *
     * @param spInvestmentLead 实例对象
     * @return 影响行数
     */
    int update(SpInvestmentLead spInvestmentLead);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

