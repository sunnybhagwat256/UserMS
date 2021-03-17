package com.infosys.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.user.dto.OrderDetailsDTO;
import com.infosys.user.dto.BuyerDTO;
import com.infosys.user.dto.LoginDTO;
import com.infosys.user.entity.Buyer;
import com.infosys.user.repository.BuyerRepository;
import com.infosys.user.validator.UserValidator;

@Service
public class BuyerService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BuyerRepository buyerRepo;

	// buyer login
	public int login(LoginDTO loginDTO) {
		Optional<Buyer> optBuyer = buyerRepo.getByEmail(loginDTO.getEmail());
		if (optBuyer.isPresent()) {
			Buyer buyer = optBuyer.get();
			if (buyer.getPassword().equals(loginDTO.getPassword())) {
				return 200;
			}
			return 403;
		}
		return 401;
	}

	// get all buyers
	public List<BuyerDTO> getAllBuyers() {
		logger.info("all buyers details");
		List<Buyer> buyers = buyerRepo.findAll();
		List<BuyerDTO> buyersDTO = new ArrayList<>();
		for (Buyer buyer : buyers) {
			BuyerDTO buyerDTO = BuyerDTO.valueof(buyer);
			buyersDTO.add(buyerDTO);
		}
		return buyersDTO;
	}

	// get specific buyer details
	public BuyerDTO getSpecificBuyer(Integer buyerid) {

		logger.info("get specific buyer details");
		BuyerDTO buyerDTO = null;
		Optional<Buyer> opt = buyerRepo.findById(buyerid);
		if (opt.isPresent()) {
			Buyer buyer = opt.get();
			buyerDTO = BuyerDTO.valueof(buyer);
		}
		return buyerDTO;
	}

	// Register buyer
	public void saveBuyerDetails(BuyerDTO buyerDTO) throws Exception {
		logger.info("Saving buyer details for:" + buyerDTO.getBuyerid());
		Buyer buyerExist = buyerRepo.getByPhonenumber(buyerDTO.getPhonenumber());// check if buyer if present with same
																					// phonenumber
		if (buyerExist != null)
			throw new Exception("Service.DUPLICATE_CONTACT");
		UserValidator.validateBuyer(buyerDTO);
		Buyer buyer = buyerDTO.createEntity();
		buyerRepo.save(buyer);

	}

	// delete buyer details
	public void removeBuyer(Integer buyerid) {
		logger.info("removing Buyer details for:" + buyerid);
		Buyer buyer = buyerRepo.findById(buyerid).orElse(null);
		if (buyer != null) {
			buyerRepo.deleteById(buyerid);
		}

	}
	//view past orders
	public List<OrderDetailsDTO> viewPastOrders(int buyerid, OrderDetailsDTO[] orders) {
		List<OrderDetailsDTO> list = new ArrayList<>();
		for (OrderDetailsDTO o : orders) {
			if (o.getBuyerid() == buyerid) {
				list.add(o);
			}
		}
		return list;
	}

}
