package com.example.lottery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lottery.document.TickerDocument;
import com.example.lottery.repository.TickerRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("tickers")
public class MarketController {

	private TickerRepository tickerRepository;

	public MarketController(TickerRepository tickerRepository) {
		this.tickerRepository = tickerRepository;
	}

	@GetMapping(params = {"min","max"})
	// async
	public Flux<TickerDocument> getTickersByPriceBetween(
			@RequestParam("min") double minPrice,
			@RequestParam("max") double maxPrice){
		       // async
		return tickerRepository.findAllByPriceBetween(minPrice, maxPrice);
	}
}
