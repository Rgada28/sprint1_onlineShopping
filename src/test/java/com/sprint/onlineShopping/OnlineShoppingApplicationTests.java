package com.sprint.onlineShopping;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

import com.sprint.onlineShopping.controller.BuyerController;
import com.sprint.onlineShopping.model.Buyer;
import com.sprint.onlineShopping.repository.BuyerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class OnlineShoppingApplicationTests {

	@MockBean
	private BuyerRepository buyerRepository;
	
	@Autowired
	private BuyerController buyerController;
	
	@Test
	public void serviceTest() {
		assertThat(buyerRepository).isNotNull();
	}

	@Test
	public void getBuyersTest() {
		when(buyerRepository.findAll()).thenReturn(  Stream.of(
				new Buyer(1000, "John", "John@example.com", "!J0hnDo3", 1, LocalDate.of(1990, 04, 12)),
				new Buyer(1004, "ramesh", "ramesh@gmail.com", "R@m3$h19", 2, LocalDate.of(1994, 02, 19))).collect(Collectors.toList()));
		assertEquals(2, buyerController.list().size());
	}
	
	
}
