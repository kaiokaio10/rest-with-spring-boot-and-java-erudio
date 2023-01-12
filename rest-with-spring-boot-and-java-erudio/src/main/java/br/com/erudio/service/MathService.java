package br.com.erudio.service;

import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@Service
public class MathService {

	public Double convertToDouble(String strNumber) {
		
		
		String number = strNumber.replace(",", ".");
		
		if (isNumeric(number)) {
			return Double.parseDouble(number);
			
		}
		return null;
	}

	public boolean isNumeric(String strNumber) {
		
		
		if (strNumber == null) {
			return false;
		}
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	public void verificacao(String numberOne,String numberTwo)throws Exception {
		
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please a numeric value");
			
		}
	}
	public void verificacaoNumeroUnico(String numberOne)throws Exception {
		
		
		if (!isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Please a numeric value");
			
		}
	}
}
