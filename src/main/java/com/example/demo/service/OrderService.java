package com.example.demo.service;

import com.example.demo.model.Orders;
import com.example.demo.payload.EditOrderPayload;
import com.example.demo.payload.OrderPayload;
import com.example.demo.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrdersRepository ordersRepository;

    public long addOrder(OrderPayload data){

        Orders orders = new Orders(data.getNamaBarang(), data.getKeterangan(), data.getQty(),data.getAlamatPemesan(), data.getNamaPemesan(),data.getTanggal());
        return ordersRepository.save(orders).getId();
    }

    public Integer editOrder(EditOrderPayload data){
        Optional<Orders> orders = ordersRepository.findById(data.getId());
        if(orders.isPresent()){
            Orders order = orders.get();
            order.setQty(data.getQty());
            ordersRepository.save(order);
            return order.getQty();
        } else return null;
    }

    public ArrayList<HashMap<String,Object>> getOrderList(String name){
        List<Orders> orders = ordersRepository.findAllByNamaPembeli(name);
        ArrayList<HashMap<String,Object>> result = new ArrayList<>();
        for (Orders order : orders){
            HashMap<String,Object> map = new HashMap<>();
            map.put("nama",order.getNamaBarang());
            map.put("qty",order.getQty());
            result.add(map);
        }
        return result;
    }
}
