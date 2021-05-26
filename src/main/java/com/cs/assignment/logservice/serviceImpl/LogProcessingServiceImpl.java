package com.cs.assignment.logservice.serviceImpl;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.assignment.logservice.dao.LogProcessingRepository;
import com.cs.assignment.logservice.model.ServerLogBean;
import com.cs.assignment.logservice.parser.ServerLogsParser;
import com.cs.assignment.logservice.service.LogProcessingService;

@Service
public class LogProcessingServiceImpl implements LogProcessingService {

	@Autowired
	private LogProcessingRepository repo;

	@Autowired
	private ServerLogsParser logsParser;

	private static final Logger LOGGER = LoggerFactory.getLogger(LogProcessingServiceImpl.class);

	@Override
	public void saveProcessedLogData() {
		File file = new File("./src/logfile/logfile");
		List<ServerLogBean> list = logsParser.fetchServerLogs(file);
		int duration = 0;

		LOGGER.info("Started processing on the server logs");

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {

				if (list.get(i).getEventId().equalsIgnoreCase(list.get(j).getEventId())) {
					if (list.get(i).getEventState().equalsIgnoreCase("FINISHED"))
						duration = (int) (list.get(i).getTimestamp() - list.get(j).getTimestamp());
					else
						duration = (int) (list.get(j).getTimestamp() - list.get(i).getTimestamp());

					ServerLogBean bean = new ServerLogBean();
					bean.setEventId(list.get(i).getEventId());
					bean.setEventDuration(duration);
					if (list.get(i).getEventHost() != null)
						bean.setEventHost(list.get(i).getEventHost());
					if (list.get(i).getEventType() != null)
						bean.setEventType(list.get(i).getEventType());
					if (duration > 4)
						bean.setEventAlert("true");
					else
						bean.setEventAlert("false");

					repo.save(bean);

					// System.out.println(bean.getEventAlert() + " " +
					// bean.getEventId() + " " + bean.getEventDuration());

					break;

				}

			}
		}

		LOGGER.info("Data successfully saved to the H2 database");

		LOGGER.info("Finished with processing server logs");

	}

}
