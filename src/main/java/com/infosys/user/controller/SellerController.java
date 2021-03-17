package com.infosys.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.infosys.user.dto.LoginDTO;
import com.infosys.user.dto.SellerDTO;

import com.infosys.user.service.SellerService;

@RestController
@CrossOrigin
public class SellerController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	SellerService sellerService;

	// seller can login if registered
	@PostMapping(value = "/login/seller")
	public ResponseEntity<String> loginSeller(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for seller {} with password {}", loginDTO.getEmail(), loginDTO.getPassword());
		if (sellerService.login(loginDTO) == 200) {
			return new ResponseEntity<String>("login successful", HttpStatus.OK);
		} else if (sellerService.login(loginDTO) == 403) {
			return new ResponseEntity<String>("login failed. Wrong credentials", HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<String>("Buyer login failed. User not found", HttpStatus.NOT_FOUND);
	}

	// get all sellers
	@GetMapping(value = "/sellers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SellerDTO> getAllsells() {
		return sellerService.getAllSellers();
	}

	// get details of a specific seller
	@GetMapping(value = "/sellers/{sellerid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SellerDTO getSpecificSeller(@PathVariable Integer sellerid) {
		logger.info("Fetching details of seller {}", sellerid);
		return sellerService.getSpecificSeller(sellerid);
	}

	// Register seller with all validation
	@PostMapping(value = "/RegisterSeller")
	public ResponseEntity<String> saveSellerDetails(@RequestBody SellerDTO sellerDTO) throws Exception {
		sellerService.saveSellerDetails(sellerDTO);
		return new ResponseEntity<String>("Seller details added successfully", HttpStatus.OK);
	}

	// delete seller details
	@DeleteMapping(value = "/sellers/{sellerid}")
	public ResponseEntity<String> removeSeller(@PathVariable Integer sellerid) {
		sellerService.removeSeller(sellerid);
		return new ResponseEntity<String>("seller Details deleted successfully", HttpStatus.OK);
	}
}
