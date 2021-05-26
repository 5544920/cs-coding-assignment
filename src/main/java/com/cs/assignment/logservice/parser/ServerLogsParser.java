package com.cs.assignment.logservice.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cs.assignment.logservice.model.ServerLogBean;

@Component
public class ServerLogsParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServerLogsParser.class);

	@SuppressWarnings("resource")
	public List<ServerLogBean> fetchServerLogs(File file) {
		Scanner scanner;
		List<ServerLogBean> list = new ArrayList<>();
		try {
			scanner = new Scanner(file).useDelimiter(Pattern.compile("}"));

			while (scanner.hasNext()) {
				String response = scanner.next().trim();
				if (response != "") {
					String newResponse = response + "}";
					JSONObject responseJson = new JSONObject(newResponse);
					// String responseInstances = responseJson.toString();
					ServerLogBean bean = new ServerLogBean();
					if (responseJson.has("id")) {
						bean.setEventId(responseJson.getString("id"));
					}
					if (responseJson.has("state")) {
						bean.setEventState(responseJson.getString("state"));
					}
					if (responseJson.has("type")) {
						bean.setEventType(responseJson.getString("type"));
					}
					if (responseJson.has("host")) {
						bean.setEventHost(responseJson.getString("host"));
					}
					if (responseJson.has("timestamp")) {
						bean.setTimestamp(responseJson.getLong("timestamp"));
					}

					list.add(bean);
				} else
					break;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("The file is not available at provided path" + e.getMessage());
		} catch (JSONException e) {
			LOGGER.error("There is issue while parsing the JSON" + e.getMessage());
		}

		System.out.println(list);

		return list;

	}

}
