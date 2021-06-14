package com.mehs.dev.taxitest;

import java.io.IOException;
import com.github.dockerjava.zerodep.shaded.org.apache.hc.client5.http.ClientProtocolException;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaxiTestApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(TaxiTestApplicationTests.class);

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllDrivers() throws ClientProtocolException, IOException {
		log.info("prueba uno");
	}

}
