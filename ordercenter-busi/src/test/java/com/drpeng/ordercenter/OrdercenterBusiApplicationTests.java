package com.drpeng.ordercenter;

import com.drpeng.ordercenter.common.service.IIdGeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdercenterBusiApplicationTests {

	@Autowired
	private IIdGeneratorService idGeneratorService;

	private Logger logger = LoggerFactory.getLogger(OrdercenterBusiApplicationTests.class);

	@Test
	public void contextLoads() {
	}

	@Test
	public void testIdGenerator() {
		long idNumber = idGeneratorService.getNextOrdNumber();
		logger.debug("idNumber = " + idNumber);
	}

}
