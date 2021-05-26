package com.cs.assignment.logservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ServerLogBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String eventId;

	@Transient
	private String eventState;

	@Transient
	private Long timestamp;

	private String eventType;

	private String eventHost;

	private int eventDuration;

	private String eventAlert;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventState() {
		return eventState;
	}

	public void setEventState(String eventState) {
		this.eventState = eventState;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventHost() {
		return eventHost;
	}

	public void setEventHost(String eventHost) {
		this.eventHost = eventHost;
	}

	public int getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(int eventDuration) {
		this.eventDuration = eventDuration;
	}

	public String getEventAlert() {
		return eventAlert;
	}

	public void setEventAlert(String eventAlert) {
		this.eventAlert = eventAlert;
	}

	@Override
	public String toString() {
		return "ServerLogBean [eventId=" + eventId + ", eventState=" + eventState + ", timestamp=" + timestamp
				+ ", eventType=" + eventType + ", eventHost=" + eventHost + ", eventDuration=" + eventDuration
				+ ", eventAlert=" + eventAlert + "]";
	}

}
