package com.turkcell.bootcamp.e_commerce.controllers;

import com.turkcell.bootcamp.e_commerce.entities.Seller;
import com.turkcell.bootcamp.e_commerce.services.abstracts.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
@AllArgsConstructor
public class SellersController {

    private final SellerService sellerService;
    @PostMapping
    public void add(@RequestBody Seller seller) throws Exception {
        sellerService.add(seller);
    }
    @GetMapping("/getall")
    public List<Seller> getall() throws Exception {
        return sellerService.getAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws Exception {
        sellerService.delete(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody Seller seller) throws Exception {
        sellerService.update(seller);
    }
    @GetMapping("/{id}")
    public Seller getById(@PathVariable(name = "id") int id) throws Exception {
        return sellerService.getById(id);
    }
}
