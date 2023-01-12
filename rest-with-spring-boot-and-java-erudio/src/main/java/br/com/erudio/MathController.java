package br.com.erudio;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.service.MathService;

@RestController
public class MathController {
	
	private static  String template = "Hello, %s!";
	private   AtomicLong counter = new AtomicLong();
	private  MathService service = new MathService();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method= RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		service.verificacao(numberOne, numberTwo);
		return service.convertToDouble(numberOne) + service.convertToDouble(numberTwo);
	}

	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}",method= RequestMethod.GET)
	public Double sub(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		service.verificacao(numberOne, numberTwo);
		return service.convertToDouble(numberOne) - service.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/mul/{numberOne}/{numberTwo}",method= RequestMethod.GET)
	public Double mul(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		service.verificacao(numberOne, numberTwo);
		return service.convertToDouble(numberOne) * service.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}",method= RequestMethod.GET)
	public Double div(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		service.verificacao(numberOne, numberTwo);
		return service.convertToDouble(numberOne) / service.convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/med/{numberOne}/{numberTwo}",method= RequestMethod.GET)
	public Double media(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		service.verificacao(numberOne, numberTwo);
		Double number = service.convertToDouble(numberOne) + service.convertToDouble(numberTwo);
		return number / 2;
	}
	@RequestMapping(value = "/raiz/{numberOne}",method= RequestMethod.GET)
	public Double raiz(@PathVariable(value = "numberOne") String numberOne) throws Exception{
		service.verificacaoNumeroUnico(numberOne);
		return Math.sqrt(service.convertToDouble(numberOne)) ;
	}
	
	
}
