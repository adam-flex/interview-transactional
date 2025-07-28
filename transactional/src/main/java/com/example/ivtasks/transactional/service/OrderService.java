package com.example.ivtasks.transactional.service;


import com.example.ivtasks.transactional.entity.Order;
import com.example.ivtasks.transactional.entity.Product;
import com.example.ivtasks.transactional.repository.OrderRepository;
import com.example.ivtasks.transactional.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@SuppressWarnings("SpringTransactionalMethodCallsInspection")
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public void save() {
        Product product = new Product("prd1");
        Order order = new Order(200);
        processNewProductOrder(product, order);
    }

    /**
     * We want this method to be transactional
     */
    @Transactional
    public void processNewProductOrder(Product product, Order order) {
        saveProduct(product);
        saveOrder(order); // this will throw exception when saving
    }

    private void saveProduct(Product product) {
        productRepository.save(product);
    }

    private void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void printDbStatus() {
        logger.info("Printing DB status");
        orderRepository.findAll().forEach(o -> logger.info(o.toString()));
        productRepository.findAll().forEach(p -> logger.info(p.toString()));
    }
}

