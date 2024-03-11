package com.turkcell.bootcamp.e_commerce.services.concretes;

import com.turkcell.bootcamp.e_commerce.entities.Seller;
import com.turkcell.bootcamp.e_commerce.repositories.abstracts.SellerRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;

    @Override
    public void add(Seller seller) throws Exception {
        if (isIdExist(seller.getId())) {
            throw new Exception("This seller already exists.");
        }
        sellerRepository.save(seller);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such a seller");
        }
        sellerRepository.deleteById(id);
    }
    /*
    @Override
    public void update(Seller seller) throws Exception {
        if (!isIdExist(seller.getId())) {
            throw new Exception("There is no such a seller");
        }
        sellerRepository.update(seller);
    }
    */
    @Override
    public List<Seller> getAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller getById(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("There is no such a seller");
        }
        return sellerRepository.getById(id);
    }

    public boolean isIdExist(int id) {
        for (Seller seller : getAll()) {
            if (seller.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
