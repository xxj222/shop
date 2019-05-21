package com.ayit.my.shop.utils.persistence;

import java.util.List;
import java.util.Map;

public interface BaseDao<T>  {

    /**
     *查询所有的用户
     * @return
     */
    public List<T> selectAll();

    /**
     * 插入
     * @param entity
     */

    void insert(T  entity);

    /**
     * 根据用户ID查询用户
     * @param id
     * @return
     */
    T selectById(long id);

    /**
     * 通过ID删除
     * @param id
     */
    void delete(long id);

    /**
     * 根据Id更新
     * @param entity
     */

    void update(T entity);



    /**
     *
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     s
     * @return
     */
    List<T> queryPage(Map<String,Object> map);

    /**
     * 查询总记录数
     * @return
     */
    int count(T entity);
}
