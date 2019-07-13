package com.book.service.impl;

import com.book.dao.UserViewDao;
import com.book.dto.AdminHomeModuleChart;
import com.book.dto.AdminHomeModules;
import com.book.dto.UserViewsParam;
import com.book.mapper.BxBookRatingsMapper;
import com.book.mapper.BxClickstreamLogMapper;
import com.book.model.BxBookRatings;
import com.book.model.BxBookRatingsExample;
import com.book.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminServiceImpl implements AdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Autowired
    private BxClickstreamLogMapper clickstreamLogMapper;
    @Autowired
    private UserViewDao userViewDao;
    @Autowired
    private BxBookRatingsMapper bookRatingsMapper;

    @Override
    public List<AdminHomeModules> getHomeModules() {
        return getModules("用户访问量", "订单成交量");
    }

    @Override
    public List<AdminHomeModules> getHomeSales() {
        return getModules("销售额");
    }

    @Override
    public AdminHomeModules getUserViews() {
        List<UserViewsParam> userViewsParamList = userViewDao.listUserViews();
        int count = userViewsParamList == null ? 0 : userViewsParamList.size();
        LOGGER.info("访问量：" + userViewsParamList.get(0).getTime() + "  " + userViewsParamList.get(0).getCnt());
        return getModules("用户访问量").get(0);
    }

    private List<AdminHomeModules> getModules(String... names) {
        List<AdminHomeModules> adminHomeModulesList = new ArrayList<>();
        for (int count = 0; count < names.length; count++) {
            AdminHomeModules adminHomeModules = new AdminHomeModules();
            adminHomeModules.setTitle(names[count]);
            AdminHomeModuleChart adminHomeModuleChart = new AdminHomeModuleChart();
            String[] columns = {"小时", "点击量"};
            List<Map<String, Integer>> rows = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Map<String, Integer> map = new HashMap<>();
                map.put(columns[0], i);
                map.put(columns[1], new Random().nextInt(100));
                rows.add(map);
            }
            adminHomeModuleChart.setColumns(columns);
            adminHomeModuleChart.setRows(rows);
            adminHomeModules.setChartData(adminHomeModuleChart);
            adminHomeModulesList.add(adminHomeModules);
        }
        return adminHomeModulesList;
    }

    @Override
    public double getBookPurchaseRate() {
        BxBookRatingsExample ratingsExample = new BxBookRatingsExample();
        ratingsExample.createCriteria().andScoreEqualTo(2);
        List<BxBookRatings> list = bookRatingsMapper.selectByExample(ratingsExample);
        int totalCount =  list == null ? 0 : list.size();
        BxBookRatingsExample bxBookRatingsExample = new BxBookRatingsExample();
        bxBookRatingsExample.createCriteria().andScoreEqualTo(7);
        List<BxBookRatings> listPurchase = bookRatingsMapper.selectByExample(bxBookRatingsExample);
        int purchaseCount = listPurchase == null ? 0 : listPurchase.size();
        return ((double) purchaseCount / (double) totalCount);
    }
}
