package com.example.demo.controller;

import com.example.demo.payload.EditOrderPayload;
import com.example.demo.payload.OrderPayload;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrderService orderService;

    @PutMapping("/addOrder")
    public ResponseEntity<?> addOrder(@RequestBody OrderPayload data){
        long id = orderService.addOrder(data);
        return ResponseEntity.ok("Pesanan telah diterima dengan nomor register "+id);
    }

    @PutMapping("/editOrder")
    public ResponseEntity<?> editOrder(@RequestBody EditOrderPayload data){
        Integer updated = orderService.editOrder(data);
        if(updated != null){
            return ResponseEntity.ok("Jumlah pesanan untuk nomor register " + data.getId() + " terupdate menjadi " + updated);
        } else return ResponseEntity.status(500).body("Pesanan tidak ditemukan");
    }

    @RequestMapping("/listOrder")
    public ResponseEntity<?> listOrder(@RequestParam("nama_pemesan") String nama_pemesan){
        return ResponseEntity.ok(orderService.getOrderList(nama_pemesan));
    }
}
