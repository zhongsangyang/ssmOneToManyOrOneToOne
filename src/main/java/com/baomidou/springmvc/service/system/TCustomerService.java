package com.baomidou.springmvc.service.system;

import com.baomidou.springmvc.model.system.TCustomer;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zsy带你飞123
 * @since 2018-04-16
 */
public interface TCustomerService extends IService<TCustomer> {
    TCustomer selectCoustemerByName(Integer customerId);

}
