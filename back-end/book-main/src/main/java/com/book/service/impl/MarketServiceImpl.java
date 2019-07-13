package com.book.service.impl;

import com.book.mapper.MarketMapper;
import com.book.model.Market;
import com.book.model.MarketExample;
import com.book.service.MarketService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketServiceImpl implements MarketService {
    @Autowired
    private MarketMapper marketMapper;

    @Override
    public List<Market> list() {
        return marketMapper.selectByExample(new MarketExample());
    }

    @Override
    public List<Market> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return marketMapper.selectByExample(new MarketExample());
    }
}
