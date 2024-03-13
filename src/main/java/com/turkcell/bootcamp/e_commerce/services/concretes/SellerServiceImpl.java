package com.turkcell.bootcamp.e_commerce.services.concretes;

import com.turkcell.bootcamp.e_commerce.core.exception.types.BusinessException;
import com.turkcell.bootcamp.e_commerce.core.services.abstracts.MessageService;
import com.turkcell.bootcamp.e_commerce.core.services.constants.Messages;
import com.turkcell.bootcamp.e_commerce.entities.Seller;
import com.turkcell.bootcamp.e_commerce.repositories.SellerRepository;
import com.turkcell.bootcamp.e_commerce.services.abstracts.SellerService;
import com.turkcell.bootcamp.e_commerce.services.dtos.seller.requests.AddSellerRequest;
import com.turkcell.bootcamp.e_commerce.services.mappers.SellerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;
    private MessageService messageService;

    @Override
    public void add(AddSellerRequest request) throws Exception {
        sellersWithSameTaxNumberShouldNotExist(request.getTaxNumber());
        Seller seller = SellerMapper.INSTANCE.sellerFromAddSellerRequest(request);
        sellerRepository.save(seller);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.NOT_FOUND_ERROR, id));
        }
        sellerRepository.deleteById(id);
    }
    @Override
    public List<Seller> getAll() {
        List<Seller> sellers = sellerRepository.findAll();
        return sellers;
    }

    @Override
    public Seller getById(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.NOT_FOUND_ERROR, id));
        }
        return sellerRepository.findById(id).get();
    }

    public boolean isIdExist(int id) {
        return sellerRepository.existsById(id);
    }

    public void sellersWithSameTaxNumberShouldNotExist(String taxNumber) throws Exception {
        Optional<Seller> sellerWithSameTaxNumber = sellerRepository.findByTaxNumber(taxNumber);
        if (sellerWithSameTaxNumber.isPresent()) {
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.SAME_TAX_NUMBER_ERROR, taxNumber));
        }
    }
}
