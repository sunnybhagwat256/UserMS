package com.infosys.user.validator;


	import com.infosys.user.dto.BuyerDTO;
	import com.infosys.user.dto.SellerDTO;

	public class UserValidator {
		public static void validateBuyer(BuyerDTO buyerDTO) throws Exception{
			if(!validateName(buyerDTO.getName())) {
				throw new Exception("Validator.INVALID_NAME");
			}
			if(!validateEmail(buyerDTO.getEmail())) {
				throw new Exception("Validator.INVALID_EMAIL");
			}
			if(!validateContact(buyerDTO.getPhonenumber())) {
				throw new Exception("Validator.INVALID_PHONENUMBER");
			}
			if(!validatePassword(buyerDTO.getPassword())) {
				throw new Exception("Validator.INVALID_PASSWORD");
			}
		}
		
		public static void validateSeller(SellerDTO sellerDTO) throws Exception{
			if(!validateName(sellerDTO.getName())) {
				throw new Exception("Validator.INVALID_NAME");
			}
			if(!validateEmail(sellerDTO.getEmail())) {
				throw new Exception("Validator.INVALID_EMAIL");
			}
			if(!validateContact(sellerDTO.getPhonenumber())) {
				throw new Exception("Validator.INVALID_PHONENUMBER");
			}
			if(!validatePassword(sellerDTO.getPassword())) {
				throw new Exception("Validator.INVALID_PASSWORD");
			}
		}
		
		public static Boolean validateName(String name) {
			String regx="^[a-zA-Z][a-zA-Z\\s]*[a-zA-Z]$";
			if(name.matches(regx)) {
				return true;
			}
			else
				return false;
		}
		
		public static Boolean validateEmail(String email) {
			String regx="^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.com$";
			if(email.matches(regx)) {
				return true;
			}
			else
				return false;
		}
		
		public  static Boolean validateContact(String phoneNumber) {
			String regx="^\\d{10}$";
			if(phoneNumber.matches(regx)) {
				return true;
			}
			else
				return false;
		}
		
		public static Boolean validatePassword(String password) {
			String regx="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{7,20}$";
			if(password.matches(regx)) {
				return true;
			}
			else
				return false;
			
		}

	
}
