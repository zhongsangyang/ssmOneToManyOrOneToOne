package com.baomidou.springmvc.service.impl;

import com.baomidou.springmvc.model.system.TCustomer;
import com.baomidou.springmvc.mapper.system.TCustomerDao;
import com.baomidou.springmvc.service.system.TCustomerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zsy带你飞123
 * @since 2018-04-16
 */
@Service
public class TCustomerServiceImpl extends ServiceImpl<TCustomerDao, TCustomer> implements TCustomerService {
    @Autowired
    private TCustomerDao tCustomerDao;
    @Override
    public TCustomer selectCoustemerByName(Integer customerId) {
        return tCustomerDao.selectCoustemerByName(customerId);
    }
}
