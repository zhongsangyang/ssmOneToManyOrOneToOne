package com.baomidou.springmvc.service.system;

import com.baomidou.springmvc.model.system.TCustomer;
import com.baomidou.springmvc.model.system.TTicket;
import com.baomidou.mybatisplus.service.IService;
import sun.security.krb5.internal.Ticket;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zsy带你飞123
 * @since 2018-04-16
 */
public interface TTicketService extends IService<TTicket> {
    TTicket selectCustomerByTicketId (Integer ticketId);

}
