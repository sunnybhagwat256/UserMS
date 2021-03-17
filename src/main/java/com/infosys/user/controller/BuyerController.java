package com.infosys.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.user.dto.OrderDetailsDTO;
import com.infosys.user.dto.BuyerDTO;
import com.infosys.user.dto.LoginDTO;
import com.infosys.user.service.BuyerService;

@RestController
@CrossOrigin
public class BuyerController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	BuyerService buyerService;

	@Value("${orderDetails.uri}")
	String orderDetailsUri;

	// buyer can LOGIN if registered
	@PostMapping(value = "/login/buyer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> loginBuyer(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for buyer {} with password {}", loginDTO.getEmail(), loginDTO.getPassword());
		if (buyerService.login(loginDTO) == 200) {
			return new ResponseEntity<String>("login successful", HttpStatus.OK);
		} else if (buyerService.login(loginDTO) == 403) {
			return new ResponseEntity<String>("login failed. Wrong credentials", HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<String>("Buyer login failed. User not found", HttpStatus.NOT_FOUND);
	}

	// get all buyers
	@GetMapping(value = "/buyers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BuyerDTO> getAllBuys() {
		return buyerService.getAllBuyers();
	}

	// get details of a specific buyer
	@GetMapping(value = "/buyers/{buyerid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BuyerDTO getSpecificBuyer(@PathVariable Integer buyerid) {
		logger.info("Fetching details of order {}", buyerid);
		return buyerService.getSpecificBuyer(buyerid);
	}

	// Register buyer with all validation
	@PostMapping(value = "/RegisterBuyer")
	public ResponseEntity<String> saveBuyerDetails(@RequestBody BuyerDTO buyerDTO) throws Exception {
		buyerService.saveBuyerDetails(buyerDTO);
		return new ResponseEntity<String>("Buyer details added successfully", HttpStatus.OK);
	}

	// delete buyer details
	@DeleteMapping(value = "/buyers/{buyerid}")
	public ResponseEntity<String> removeBuyer(@PathVariable Integer buyerid) {
		buyerService.removeBuyer(buyerid);
		return new ResponseEntity<String>("Buyer Details deleted successfully", HttpStatus.OK);
	}

	// view past order
	@GetMapping(value = "/pastorder/{buyerid}")
	public List<OrderDetailsDTO> ViewOrders(@PathVariable int buyerid) {
		List<OrderDetailsDTO> pastOrder = new ArrayList<>();
		String url = "http://13.235.90.171:8300/api/orders";
		OrderDetailsDTO[] orders = new RestTemplate().getForObject(url, OrderDetailsDTO[].class);
		pastOrder = buyerService.viewPastOrders(buyerid, orders);
		return pastOrder;
	}
}
