package com.book.service.impl;

import com.book.mapper.BxBookRatingsMapper;
import com.book.model.BxBookRatings;
import com.book.service.BookRatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by 夏日云泊镇 on 2019/7/9
 **/
@Service
public class BookRatingServiceImpl implements BookRatingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookRatingServiceImpl.class);
    @Autowired
    private BxBookRatingsMapper bookRatingsMapper;

    @Override
    public int add(Long userId, Long bookId, Integer score) {
        saveToFile(userId, bookId, score);
        // 保存到数据库
        BxBookRatings bxBookRatings = new BxBookRatings();
        bxBookRatings.setUserId(userId);
        bxBookRatings.setBookId(bookId);
        bxBookRatings.setScore(score);
        return bookRatingsMapper.insert(bxBookRatings);
    }

    /**
     * 保存成txt文件
     */
    private void saveToFile(Long userId, Long bookId, Integer score) {
        try {
            File file = new File("./book-main/src/main/resources/ratings/bx_book_ratings.txt");
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            out.write(String.valueOf(userId) + "," + String.valueOf(bookId) + "," + String.valueOf(score) + "\r\n");
            out.close();
        } catch (Exception e) {
            LOGGER.info("Rating文件写入出错：" + e.toString());
        }
    }
}
