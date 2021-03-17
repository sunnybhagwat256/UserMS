package com.infosys.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.user.dto.LoginDTO;
import com.infosys.user.dto.SellerDTO;
import com.infosys.user.entity.Seller;
import com.infosys.user.repository.SellerRepository;
import com.infosys.user.validator.UserValidator;

@Service
public class SellerService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SellerRepository sellerRepo;

	// seller login
	public int login(LoginDTO loginDTO) {
		Optional<Seller> optSeller = sellerRepo.getByEmail(loginDTO.getEmail());
		if (optSeller.isPresent()) {
			Seller seller = optSeller.get();
			if (seller.getPassword().equals(loginDTO.getPassword())) {
				return 200;
			}
			return 403;
		}
		return 401;
	}

	// get seller details
	public List<SellerDTO> getAllSellers() {
		List<Seller> sellers = sellerRepo.findAll();
		List<SellerDTO> sellersDTO = new ArrayList<>();
		for (Seller seller : sellers) {
			SellerDTO sellerDTO = SellerDTO.valueOf(seller);
			sellersDTO.add(sellerDTO);
		}

		return sellersDTO;
	}

	// get specific seller details
	public SellerDTO getSpecificSeller(Integer sellerid) {

		logger.info("get specific seller details");
		SellerDTO sellerDTO = null;
		Optional<Seller> opt = sellerRepo.findById(sellerid);
		if (opt.isPresent()) {
			Seller seller = opt.get();
			sellerDTO = SellerDTO.valueOf(seller);
		}
		return sellerDTO;
	}

	// register seller details
	public void saveSellerDetails(SellerDTO sellerDTO) throws Exception {
		logger.info("Saving seller details for:" + sellerDTO.getSellerid());
		Seller sellerExists = sellerRepo.getByPhonenumber(sellerDTO.getPhonenumber());
		if (sellerExists != null)
			throw new Exception("Service.DUPLICATE_CONTACT");
		UserValidator.validateSeller(sellerDTO);
		Seller seller = sellerDTO.createEntity();
		sellerRepo.save(seller);

	}

	// delete seller details
	public void removeSeller(Integer sellerid) {
		logger.info("removing seller details for:" + sellerid);
		Seller seller = sellerRepo.findById(sellerid).orElse(null);
		if (seller != null) {
			sellerRepo.deleteById(sellerid);
		}

	}

}
