package com.baomidou.springmvc.mapper.system;

import com.baomidou.springmvc.model.system.TCustomer;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zsy带你飞123
 * @since 2018-04-16
 */
@Repository
public interface TCustomerDao extends BaseMapper<TCustomer> {
    TCustomer selectCoustemerByName(Integer customerId);
}
