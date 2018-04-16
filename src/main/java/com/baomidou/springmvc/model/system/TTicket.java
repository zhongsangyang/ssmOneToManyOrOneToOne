package com.baomidou.springmvc.model.system;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zsy带你飞123
 * @since 2018-04-16
 */
@TableName("t_ticket")
public class TTicket implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ticketId", type = IdType.AUTO)
    private Integer ticketId;
    private String ticketAddress;
    private Integer ticketPrice;
    private Integer ticketCId;
    private TCustomer tCustomer;

    public TCustomer gettCustomer() {
        return tCustomer;
    }

    public void settCustomer(TCustomer tCustomer) {
        this.tCustomer = tCustomer;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketAddress() {
        return ticketAddress;
    }

    public void setTicketAddress(String ticketAddress) {
        this.ticketAddress = ticketAddress;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getTicketCId() {
        return ticketCId;
    }

    public void setTicketCId(Integer ticketCId) {
        this.ticketCId = ticketCId;
    }

    @Override
    public String toString() {
        return "TTicket{" +
                "ticketId=" + ticketId +
                ", ticketAddress='" + ticketAddress + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", ticketCId=" + ticketCId +
                ", tCustomer=" + tCustomer +
                '}';
    }
}
