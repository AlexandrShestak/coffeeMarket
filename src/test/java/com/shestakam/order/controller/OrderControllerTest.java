package com.shestakam.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shestakam.coffee.brand.dao.CoffeeBrandDao;
import com.shestakam.order.OrderPriceCalculator;
import com.shestakam.order.dao.OrderDao;
import com.shestakam.order.entity.Order;
import com.shestakam.order.orderItem.dao.HibernateOrderItemDao;
import com.shestakam.order.orderItem.dao.OrderItemDao;
import com.shestakam.order.orderItem.entity.OrderItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/dispatcherServlet-servlet.xml", "/beansContext.xml"})
@WebAppConfiguration

public class OrderControllerTest {

    private MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    @Qualifier("hibernateCoffeeBrandDao")
    private CoffeeBrandDao coffeeBrandDao;

    @Autowired
    @Qualifier("hibernateOrderDao")
    private OrderDao orderDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private OrderPriceCalculator orderPriceCalculator;



    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testCalculateOrderPrice() throws Exception {
        String jsonString = "[{\"amount\":1,\"brandId\":1},{\"amount\":1,\"brandId\":3},{\"amount\":2,\"brandId\":5}]";

        mockMvc.perform(post("/calculatePrice")
                .contentType(contentType)
                .content(jsonString))
                .andExpect(status().isOk())
                .andExpect(content().string("11"));

    }

    @Test
    public void testCalculateOrderPriceWithSale() throws Exception {
        String jsonString = "[{\"amount\":10,\"brandId\":1},{\"amount\":1,\"brandId\":3},{\"amount\":2,\"brandId\":5}]";

        mockMvc.perform(post("/calculatePrice")
                .contentType(contentType)
                .content(jsonString))
                .andExpect(status().isOk())
                .andExpect(content().string("23"));

    }

    @Test
    public void testCalculateOrderPriceWithDelivery() throws Exception {
        String jsonString = "[{\"amount\":2,\"brandId\":1},{\"amount\":1,\"brandId\":2}]";
        mockMvc.perform(post("/calculatePrice")
                .contentType(contentType)
                .content(jsonString))
                .andExpect(status().isOk())
                .andExpect(content().string("9"));
    }

    @Test
    public void testMakeOrder() throws Exception {
        Order order = new Order();
        order.setUsername("Eduar Lopec");
        order.setAddress("Leninckai 10,23");
        order.setTotalPrice(9);

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setAmount(1);
        orderItem1.setBrandId(1L);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setAmount(3);
        orderItem2.setBrandId(3L);

        OrderItem orderItem3 = new OrderItem();
        orderItem3.setAmount(2);
        orderItem3.setBrandId(4L);

        Set<OrderItem> orderItemSet = new HashSet<>();
        orderItemSet.add(orderItem1);
        orderItemSet.add(orderItem2);
        orderItemSet.add(orderItem3);
        order.setOrderItemSet(orderItemSet);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(order);

        int orderItemsSizeBefore = orderItemDao.getAll().size();
        int ordersSizeBefore = orderDao.getAll().size();
        mockMvc.perform(post("/makeOrder")
                .contentType(contentType)
                .content(jsonString))
               .andExpect(status().isOk());

        int orderItemsSizeAfter = orderItemDao.getAll().size();
        Assert.assertEquals(orderItemsSizeBefore+3,orderItemsSizeAfter);

        int ordersSizeAfter = orderDao.getAll().size();
        Assert.assertEquals(ordersSizeBefore+1,ordersSizeAfter);
    }
}