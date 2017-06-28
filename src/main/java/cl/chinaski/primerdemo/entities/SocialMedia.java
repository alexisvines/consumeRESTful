package cl.chinaski.primerdemo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SocialMedia {
	private int idSocialMedia;
	private String name;
	private String icon;
	
	public int getIdSocialMedia() {
		return idSocialMedia;
	}
	public void setIdSocialMedia(int idSocialMedia) {
		this.idSocialMedia = idSocialMedia;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

}
