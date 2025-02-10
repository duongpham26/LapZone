package com.duongpham26.LaptopShop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duongpham26.LaptopShop.domain.Order;
import com.duongpham26.LaptopShop.domain.OrderDetail;
import com.duongpham26.LaptopShop.repository.OrderDetailRepository;
import com.duongpham26.LaptopShop.repository.OrderRepository;

@Service
public class OrderService {

    public final OrderRepository orderRepository;

    private final OrderDetailRepository orderDetailRepository;

    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public List<Order> fetchAllOrders() {
        return this.orderRepository.findAll();
    }

    public void deleteOrderById(long id) {
        // delete order detail
        Optional<Order> orderOptional = this.fetchOrderById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();

            List<OrderDetail> orderDetails = order.getOrderDetails();
            for (OrderDetail orderDetail : orderDetails) {
                this.orderDetailRepository.deleteById(orderDetail.getId());
            }
        }
        this.orderRepository.deleteById(id);
    }

    public void updateOrder(Order order) {
        Optional<Order> orderOptional = this.fetchOrderById(order.getId());
        if (orderOptional.isPresent()) {
            Order currentOrder = orderOptional.get();
            currentOrder.setStatus(order.getStatus());
            this.orderRepository.save(currentOrder);
        }
    }

    public Optional<Order> fetchOrderById(long id) {
        return this.orderRepository.findById(id);
    }
}
