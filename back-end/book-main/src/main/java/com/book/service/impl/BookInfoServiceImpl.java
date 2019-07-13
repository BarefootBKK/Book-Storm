package com.book.service.impl;

import cn.hutool.core.date.DateTime;
import com.book.component.BookRecommender;
import com.book.dao.BookInfoDao;
import com.book.dao.CommentDao;
import com.book.dao.StoreDao;
import com.book.dto.BookWithStoreAndComment;
import com.book.dto.HomeBookContent;
import com.book.mapper.BookInfoMapper;
import com.book.model.BookInfo;
import com.book.model.BookInfoExample;
import com.book.service.BookInfoService;
import com.book.util.UserUtil;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    private static final Logger log = LoggerFactory.getLogger(BookInfoServiceImpl.class);
    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Autowired
    private BookInfoDao bookInfoDao;
    @Autowired
    private StoreDao storeDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private UserUtil userUtil;

    @Override
    public List<HomeBookContent> listHome(HttpServletRequest request) {
        List<HomeBookContent> contents = new ArrayList<>();
        HomeBookContent popularContent = new HomeBookContent("热门图书", listWithPopular(10, 1));
        Long userId = userUtil.getAuthenticatedUserId(request);
        HomeBookContent recommendContent;
        if (userId != null) {
            recommendContent = new HomeBookContent("个性化推荐", listWithPersonalized(userId, 10, 1));
        } else {
            recommendContent = new HomeBookContent("个性化推荐", listWithPopular(9, 2));
        }
        HomeBookContent newContent = new HomeBookContent("新上架", listWithLatest(10, 1));
        contents.add(popularContent);
        contents.add(recommendContent);
        contents.add(newContent);
        return contents;
    }

    @Override
    public List<BookInfo> listAll() {
        return bookInfoMapper.selectByExample(new BookInfoExample());
    }

    @Override
    public int createBook(BookInfo bookInfo) {
        bookInfo.setCreated(new DateTime());
        bookInfo.setImageUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562752463657&di=7aedd27eb2ab378c14d84bcce6aba9b6&imgtype=0&src=http%3A%2F%2Fwww.books88.com%2FBooks_Pic%2F20080509%2FL9787200065046.jpg");
        return bookInfoMapper.insert(bookInfo);
    }

    @Override
    public BookInfo updateBookInfo(BookInfo bookInfo) {
        bookInfoMapper.updateByPrimaryKey(bookInfo);
        return bookInfo;
    }

    @Override
    public List<BookInfo> listAll(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return bookInfoMapper.selectByExample(new BookInfoExample());
    }

    @Override
    public BookInfo getBookInfoById(Long id) {
        return bookInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BookInfo> listByKeyword(String query, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return bookInfoDao.queryBookInfoLike(query);
    }

    @Override
    public List<BookInfo> listByStoreId(Integer storeId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        BookInfoExample bookInfoExample = new BookInfoExample();
        bookInfoExample.createCriteria().andStoreIdEqualTo(storeId);
        return bookInfoMapper.selectByExample(bookInfoExample);
    }

    @Override
    public BookWithStoreAndComment getBookWithStoreAndComment(Long bookId) {
        BookWithStoreAndComment bookWithStoreAndComment = new BookWithStoreAndComment();
        bookWithStoreAndComment.setBookInfo(bookInfoMapper.selectByPrimaryKey(bookId));
        bookWithStoreAndComment.setStore(storeDao.getStoreByBookId(bookId));
        bookWithStoreAndComment.setCommentList(commentDao.getCommentListByBookId(bookId));
        bookInfoDao.updateBookLookMount(bookId);
        return bookWithStoreAndComment;
    }

    @Override
    public List<BookInfo> listByCategory(String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return bookInfoDao.listByCategory(name);
    }

    @Override
    public List<BookInfo> listWithPersonalized(Long userId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        BookRecommender bookRecommender = new BookRecommender();
        List<Long> bookIds = bookRecommender.itemUserAverageCF(userId, pageSize);
        List<BookInfo> bookInfoList = new ArrayList<>();
        for (Long id : bookIds) {
            bookInfoList.add(bookInfoMapper.selectByPrimaryKey(id));
        }
        bookInfoList.addAll(listWithPopular(9, 2));
        return bookInfoList;
    }

    @Override
    public List<BookInfo> listWithPopular(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return bookInfoDao.listPopularBooks();
    }

    @Override
    public List<BookInfo> listWithLatest(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return bookInfoDao.listLatestBooks();
    }
}