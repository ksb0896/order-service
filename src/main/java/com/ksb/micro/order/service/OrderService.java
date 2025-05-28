package com.ksb.micro.order.service;

import com.ksb.micro.order.dto.OrderRequest;
import com.ksb.micro.order.model.Order;
import com.ksb.micro.order.repository.OrderRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
public void placeOrder(OrderRequest orderRequest){
    //map orderRequest to order object
    Order order = new Order();
    order.setOrderNumber(UUID.randomUUID().toString());
    order.setPrice(orderRequest.price());
    order.setSkuCode(orderRequest.skuCode());
    order.setQuantity(orderRequest.quantity());

    //save order to orderRepository
    orderRepository.save(order);

}
}
