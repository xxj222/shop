package com.ayit.my.shop.utils.persistence;

import com.ayit.my.shop.utils.PageInfo;

import java.util.List;

public interface BaseService<T extends BaseEntity> {
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
     * 通过ID删除
     * @param id
     */
    void delete(long id);

    /**
     * 根据Id更新
     * @param tbContent
     */

    void update(T tbContent);


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
    PageInfo<T> queryPage(int start, int length, int draw, T entity);

    /**
     * 查询总记录数
     * @return
     */
    int count(T entity);
}
