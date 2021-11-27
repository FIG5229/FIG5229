package com.integration.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "audience")
@Component
public class Audience extends BaseEntity {
	private String clientId;
	private String base64Secret;
	private String name;
	private int expiresSecond;
	private int dfilter;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getBase64Secret() {
		return base64Secret;
	}
	public void setBase64Secret(String base64Secret) {
		this.base64Secret = base64Secret;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExpiresSecond() {
		return expiresSecond;
	}
	public void setExpiresSecond(int expiresSecond) {
		this.expiresSecond = expiresSecond;
	}
	public int getDfilter() {
		return dfilter;
	}
	public void setDfilter(int dfilter) {
		this.dfilter = dfilter;
	}
	
	
	
}
