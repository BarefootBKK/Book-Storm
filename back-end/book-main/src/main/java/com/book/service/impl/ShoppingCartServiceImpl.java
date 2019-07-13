package com.book.service.impl;

import cn.hutool.core.date.DateTime;
import com.book.dao.ShoppingCartDao;
import com.book.dto.OrderDetailParam;
import com.book.dto.ShoppingCartItemParam;
import com.book.dto.ShoppingCartResponse;
import com.book.mapper.ShoppingCartMapper;
import com.book.model.ShoppingCart;
import com.book.model.ShoppingCartExample;
import com.book.service.ShoppingCartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    public List<ShoppingCartResponse> listCartItemWithBookInfo(String username) {
        if (username == null) {
            return null;
        }
        return shoppingCartDao.listWithBookInfo(username);
    }

    @Override
    public List<ShoppingCartResponse> insert(ShoppingCartItemParam shoppingCartItemParam) {
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartItemParam, shoppingCart);
        shoppingCart.setCreated(new DateTime());
        shoppingCartMapper.insert(shoppingCart);
        return shoppingCartDao.listWithBookInfo(shoppingCartItemParam.getUsername());
    }

    @Override
    public List<ShoppingCart> list(String username) {
        ShoppingCartExample example = new ShoppingCartExample();
        ShoppingCartExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        return shoppingCartMapper.selectByExample(example);
    }

    @Override
    public int deleteByOrderDetail(List<OrderDetailParam> orderDetailParamList) {
        int count = 0;
        for (OrderDetailParam orderDetailParam : orderDetailParamList) {
            count += shoppingCartMapper.deleteByPrimaryKey(orderDetailParam.getShoppingCartId());
        }
        return count;
    }
}
