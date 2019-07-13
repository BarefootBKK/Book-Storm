package com.book.service.impl;

import com.book.dao.StoreDao;
import com.book.mapper.StoreMapper;
import com.book.model.Store;
import com.book.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;
    @Autowired
    private StoreDao storeDao;

    @Override
    public Store getStoreById(Integer id) {
        return storeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Store getStoreByBookId(Long bookId) {
        return storeDao.getStoreByBookId(bookId);
    }

    @Override
    public Store getStoreByUsername(String username) {
        return storeDao.getStoreByUsername(username);
    }
}
