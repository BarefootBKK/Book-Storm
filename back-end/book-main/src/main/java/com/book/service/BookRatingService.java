package com.book.service;

/**
 * Created by 夏日云泊镇 on 2019/7/9
 **/

/**
 * 打分接口
 * 根据用户访问信息对用户和书籍打分
 * 打分格式参考数据库表：bx_book_ratings
 */
public interface BookRatingService {
    /**
     * 添加打分数据
     * @param userId 用户id
     * @param bookId 书籍id
     * @param score 分数
     * @return 数据库插入数据的条数
     */
    int add(Long userId, Long bookId, Integer score);
}
