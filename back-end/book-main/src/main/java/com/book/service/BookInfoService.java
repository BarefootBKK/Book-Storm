package com.book.service;

import com.book.dto.BookWithStoreAndComment;
import com.book.dto.HomeBookContent;
import com.book.model.BookInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 图书信息接口
 */
public interface BookInfoService {

    /**
     * 获取首页数据（个人推荐/热门推荐/新上架）
     * @param request 用户请求
     * @return 首页展示数据
     */
    List<HomeBookContent> listHome(HttpServletRequest request);

    /**
     * 查询所有图书
     * @return
     */
    List<BookInfo> listAll();

    /**
     * 创建图书
     * @param bookInfo
     * @return
     */
    int createBook(BookInfo bookInfo);

    /**
     * 更新图书信息
     * @param bookInfo
     * @return
     */
    BookInfo updateBookInfo(BookInfo bookInfo);

    /**
     * 分页获取书籍
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<BookInfo> listAll(Integer pageSize, Integer pageNum);

    /**
     * 根据关键词获取图书
     * @param query 查询关键词
     * @param pageSize 分页大小
     * @param pageNum 页数
     * @return 图书list
     */
    List<BookInfo> listByKeyword(String query, Integer pageSize, Integer pageNum);

    /**
     * 根据书籍类别查询
     * @param name 类别关键词
     * @param pageSize 分页大小
     * @param pageNum 页数
     * @return 图书list
     */
    List<BookInfo> listByCategory(String name, Integer pageSize, Integer pageNum);

    /**
     * 获取图书信息（带店铺详情和评论列表）
     * @param bookId
     * @return
     */
    BookWithStoreAndComment getBookWithStoreAndComment(Long bookId);

    /**
     * 根据书籍id查找图书
     * @param id
     * @return
     */
    BookInfo getBookInfoById(Long id);

    /**
     * 根据店铺id查找图书
     * @param storeId 店铺id
     * @param pageSize 分页大小
     * @param pageNum 页数
     * @return 书籍信息列表
     */
    List<BookInfo> listByStoreId(Integer storeId, Integer pageSize, Integer pageNum);

    /**
     * 个性化推荐
     * @param userId 用户id
     * @param pageSize
     * @param pageNum
     * @return 个性化推荐的图书列表
     */
    List<BookInfo> listWithPersonalized(Long userId, Integer pageSize, Integer pageNum);

    /**
     * 热门推荐
     * @param pageSize
     * @param pageNum
     * @return 热门推荐数据
     */
    List<BookInfo> listWithPopular(Integer pageSize, Integer pageNum);

    /**
     * 新上架的图书
     * @param pageSize
     * @param pageNum
     * @return 新上架图书列表
     */
    List<BookInfo> listWithLatest(Integer pageSize, Integer pageNum);
}
