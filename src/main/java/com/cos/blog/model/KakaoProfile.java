package com.cos.blog.model;
  
public class KakaoProfile {

private Integer id;
private String connected_At;
private Properties properties;
private Kakao_Account kakao_Account;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getConnected_At() {
		return connected_At;
	}
	
	public void setConnected_At(String connected_At) {
		this.connected_At = connected_At;
	}
	
	public Properties getProperties() {
		return properties;
	}
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	public Kakao_Account getKakao_Account() {
		return kakao_Account;
	}
	
	public void setKakao_Account(Kakao_Account kakao_Account) {
		this.kakao_Account = kakao_Account;
	}
	
	public class Properties {

		private String nickname;
		private String profile_Image;
		private String thumbnail_Image;

			public String getNickname() {
				return nickname;
			}
			
			public void setNickname(String nickname) {
				this.nickname = nickname;
			}
			
			public String getProfile_Image() {
				return profile_Image;
			}
			
			public void setProfile_Image(String profile_Image) {
				this.profile_Image = profile_Image;
			}
			
			public String getThumbnail_Image() {
				return thumbnail_Image;
			}
			
			public void setThumbnail_Image(String thumbnail_Image) {
				this.thumbnail_Image = thumbnail_Image;
			}

		}
	public class Kakao_Account {

		private Boolean profile_Needs_Agreement;
		private Profile profile;
		private Boolean has_Email;
		private Boolean email_Needs_Agreement;
		private Boolean is_Email_Valid;
		private Boolean is_Email_Verified;
		private String email;

			public Boolean getProfile_Needs_Agreement() {
				return profile_Needs_Agreement;
			}
			
			public void setProfile_Needs_Agreement(Boolean profile_Needs_Agreement) {
				this.profile_Needs_Agreement = profile_Needs_Agreement;
			}
			
			public Profile getProfile() {
				return profile;
			}
			
			public void setProfile(Profile profile) {
				this.profile = profile;
			}
			
			public Boolean getHas_Email() {
				return has_Email;
			}
			
			public void setHas_Email(Boolean has_Email) {
				this.has_Email = has_Email;
			}
			
			public Boolean getEmail_Needs_Agreement() {
				return email_Needs_Agreement;
			}
			
			public void setEmail_Needs_Agreement(Boolean email_Needs_Agreement) {
				this.email_Needs_Agreement = email_Needs_Agreement;
			}
			
			public Boolean getIs_Email_Valid() {
				return is_Email_Valid;
			}
			
			public void setIs_Email_Valid(Boolean is_Email_Valid) {
				this.is_Email_Valid = is_Email_Valid;
			}
			
			public Boolean getIs_Email_Verified() {
				return is_Email_Verified;
			}
			
			public void setIs_Email_Verified(Boolean is_Email_Verified) {
				this.is_Email_Verified = is_Email_Verified;
			}
			
			public String getEmail() {
				return email;
			}
			
			public void setEmail(String email) {
				this.email = email;
			}
			
			public class Profile {

				private String nickname;
				private String thumbnail_Image_Url;
				private String profile_Image_Url;

					public String getNickname() {
						return nickname;
					}
					
					public void setNickname(String nickname) {
						this.nickname = nickname;
					}
					
					public String getThumbnail_Image_Url() {
						return thumbnail_Image_Url;
					}
					
					public void setThumbnail_Image_Url(String thumbnail_Image_Url) {
						this.thumbnail_Image_Url = thumbnail_Image_Url;
					}
					
					public String getProfile_Image_Url() {
						return profile_Image_Url;
					}
					
					public void setProfile_Image_Url(String profile_Image_Url) {
						this.profile_Image_Url = profile_Image_Url;
					}

				}
				 
		}
	
}


 
  

 
 

