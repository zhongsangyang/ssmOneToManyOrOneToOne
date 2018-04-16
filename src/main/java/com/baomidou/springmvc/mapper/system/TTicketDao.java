package com.baomidou.springmvc.mapper.system;

import com.baomidou.springmvc.model.system.TCustomer;
import com.baomidou.springmvc.model.system.TTicket;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zsy带你飞123
 * @since 2018-04-16
 */

public interface TTicketDao extends BaseMapper<TTicket> {
    TTicket selectCustomerByTicketId (Integer ticketId);
}
