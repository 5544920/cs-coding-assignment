package com.cs.assignment.logservice.parser;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cs.assignment.logservice.model.ServerLogBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerLogsParserTests {

	@InjectMocks
	private ServerLogsParser logsParser;

	private List<ServerLogBean> list = new ArrayList<>();

	@Before
	public void setData() {

		ServerLogBean bean = new ServerLogBean();
		bean.setEventId("fjg");
		bean.setEventHost("12345");
		bean.setEventState("STARTED");
		bean.setEventType("APPLOG");
		bean.setTimestamp(123l);
		list.add(bean);
		ServerLogBean bean1 = new ServerLogBean();
		bean1.setEventId("fjg");
		bean1.setEventHost("12345");
		bean1.setEventState("FINISHED");
		bean1.setEventType("APPLOG");
		bean1.setTimestamp(128l);
		list.add(bean1);

	}

	@Test
	public void testSaveProcessedLogDataValidInput() {

		// doNothing().when(logProcessingService).saveProcessedLogData();

		//when(logsParser.fetchServerLogs(any(File.class))).thenReturn(list);

		List<ServerLogBean> list2 = logsParser.fetchServerLogs(new File("./src/logfile/logfile"));

		assertNotNull(list2);
	}

}
