package com.cs.assignment.logservice.serviceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cs.assignment.logservice.dao.LogProcessingRepository;
import com.cs.assignment.logservice.model.ServerLogBean;
import com.cs.assignment.logservice.parser.ServerLogsParser;
import com.cs.assignment.logservice.service.LogProcessingService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogProcessingServiceImplTests {

	@Autowired
	private LogProcessingService logProcessingService;

	@MockBean
	private LogProcessingRepository repo;

	@MockBean
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

		when(logsParser.fetchServerLogs(new File("./src/logfile/logfile"))).thenReturn(list);

		when(repo.save(any(ServerLogBean.class))).thenReturn(any(ServerLogBean.class));

		logProcessingService.saveProcessedLogData();
	}

	@Test
	public void testSaveProcessedLogDataValidInput2() {
		list = new ArrayList<>();
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
		bean1.setTimestamp(124l);
		list.add(bean1);

		// doNothing().when(logProcessingService).saveProcessedLogData();

		when(logsParser.fetchServerLogs(new File("./src/logfile/logfile"))).thenReturn(list);

		when(repo.save(any(ServerLogBean.class))).thenReturn(any(ServerLogBean.class));

		logProcessingService.saveProcessedLogData();
	}

	@Test
	public void testSaveProcessedLogDataValidInput3() {
		list = new ArrayList<>();
		ServerLogBean bean = new ServerLogBean();
		bean.setEventId("fjg");
		bean.setEventHost("12345");
		bean.setEventState("FINISHED");
		bean.setEventType("APPLOG");
		bean.setTimestamp(130l);
		list.add(bean);
		ServerLogBean bean1 = new ServerLogBean();
		bean1.setEventId("fjg");
		bean1.setEventHost("12345");
		bean1.setEventState("STARTED");
		bean1.setEventType("APPLOG");
		bean1.setTimestamp(124l);
		list.add(bean1);

		// doNothing().when(logProcessingService).saveProcessedLogData();

		when(logsParser.fetchServerLogs(new File("./src/logfile/logfile"))).thenReturn(list);

		when(repo.save(any(ServerLogBean.class))).thenReturn(any(ServerLogBean.class));

		logProcessingService.saveProcessedLogData();
	}

}
