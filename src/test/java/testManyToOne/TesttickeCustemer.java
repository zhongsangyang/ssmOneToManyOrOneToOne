package testManyToOne;

import com.baomidou.springmvc.model.system.TCustomer;
import com.baomidou.springmvc.model.system.TTicket;
import com.baomidou.springmvc.service.system.TCustomerService;
import com.baomidou.springmvc.service.system.TTicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:/mybatis/system/*.xml","classpath:/mybatis/*.xml","classpath:/spring/spring.xml"})
public class TesttickeCustemer {
    @Autowired
    private TCustomerService customerService;
    @Autowired
    private TTicketService tTicketService;
    @Test

    public void oneToManyTest() {
       TCustomer tCustomer= customerService.selectCoustemerByName(1);
        System.out.println(tCustomer);
    }
    @Test

    public void oneToOneTest() {
        TTicket tCustomer= tTicketService.selectCustomerByTicketId(1);
        System.out.println(tCustomer);
    }
}
