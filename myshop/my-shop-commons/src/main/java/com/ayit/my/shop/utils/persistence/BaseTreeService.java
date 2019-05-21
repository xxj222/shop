package com.ayit.my.shop.utils.persistence;


import java.util.List;

public interface BaseTreeService<T extends BaseEntity> {
    /**
     *查询所有的用户
     * @return
     */
    public List<T> selectAll();

    /**
     * 插入
     * @param entity
     */

    BaseResult Save(T  entity);

    /**
     * 根据用户ID查询用户
     * @param id
     * @return
     */
    T selectById(long id);

    /**
     *
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 根据Id更新
     * @param entity
     */

    void update(T entity);

    /**
     * g根据id查所有的类目
     * @param id
     * @return
     */
    public List<T> selectAllById(Long id);
}
