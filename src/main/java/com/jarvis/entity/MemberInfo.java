package com.jarvis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MemberInfo")
public class MemberInfo {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Column(name = "ID")
	    private Long id;
	 	
	 	@Column(name = "SOURCE")
		private String source;
	 	
	 	@Column(name = "SOURCE_ID")
		private String sourceID;
	 	
	 	@Column(name = "RECORD_TYPE")
		private String recordType;
	 	
	 	@Column(name = "CREATE_DATE")
		private String createDate;
	 	
	 	@Column(name = "COMMON_FILLER")
		private String commonFiller;
	 	
	 	@Column(name = "LAST_NAME")
		private String lastName;
	 	
	 	@Column(name = "FIRST_NAME")
		private String firstName;
	 	
	 	@Column(name = "MIDDLE_NAME")
		private String middleName;
	 	
	 	@Column(name = "Name_Prefix")
		private String namePrefix;
	 	
	 	@Column(name = "Gender")
		private String gender;
	 	
	 	@Column(name = "DOB")
		private String dob;

	 	@Column(name = "ADDRESS_LINE_1")
		private String addressLine1;
	 	
	 	@Column(name = "ADDRESS_LINE_2")
		private String addressLine2;

	 	@Column(name = "CITY")
		private String city;
	 	
	 	@Column(name = "STATE")
		private String state;
	 	
	 	@Column(name = "POSTAL_CODE")
		private String postalCode;

	 	@Column(name = "PLUS4")
		private String plus4;
	 	
	 	@Column(name = "PRIMARY_PHONE_NUMBER")
		private String primaryPhoneNumber;
	 	
	 	@Column(name = "ALTERNATE_ID")
		private String alternateID;
	 	
	 	@Column(name = "PREVIOUS_SUBSCRIBER_ID")
		private String previousSubscriberID;

	 	@Column(name = "SOCIAL_SECURITY_NUMBER")
		private String socialSecurityNumber;
	 	
	 	@Column(name = "PHONE_NUMBER")
		private String phoneNumber;
	 	
	 	@Column(name = "EMAIL_ADDRESS")
		private String emailAddress;
	 	
	 	@Column(name = "LAGUAGE_CODE")
		private String laguageCode;
	 	
	 	@Column(name = "RACE")
		private String race;
	 	
	 	@Column(name = "DOD")
		private String dod;

	 	@Column(name = "COUNTRY")
		private String country;
	 	
	 	@Column(name = "COUNTRY_CODE")
		private String countryCode;
 
	 	@Column(name = "GROUP_ID")
		private String groupID;
	 	
	 	@Column(name = "PREFERENCE")
		private String preference;
	 	
	 	@Column(name = "IDCARD")
		private String idcard;
	 	
	 	@Column(name = "PHONEID")
		private String phoneID;

		public String getPreference() {
			return preference;
		}

		public void setPreference(String preference) {
			this.preference = preference;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getSourceID() {
			return sourceID;
		}

		public void setSourceID(String sourceID) {
			this.sourceID = sourceID;
		}

		public String getRecordType() {
			return recordType;
		}

		public void setRecordType(String recordType) {
			this.recordType = recordType;
		}

		public String getCreateDate() {
			return createDate;
		}

		public void setCreateDate(String createDate) {
			this.createDate = createDate;
		}

		public String getCommonFiller() {
			return commonFiller;
		}

		public void setCommonFiller(String commonFiller) {
			this.commonFiller = commonFiller;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getNamePrefix() {
			return namePrefix;
		}

		public void setNamePrefix(String namePrefix) {
			this.namePrefix = namePrefix;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getAddressLine1() {
			return addressLine1;
		}

		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}

		public String getAddressLine2() {
			return addressLine2;
		}

		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public String getPlus4() {
			return plus4;
		}

		public void setPlus4(String plus4) {
			this.plus4 = plus4;
		}

		public String getPrimaryPhoneNumber() {
			return primaryPhoneNumber;
		}

		public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
			this.primaryPhoneNumber = primaryPhoneNumber;
		}

		public String getAlternateID() {
			return alternateID;
		}

		public void setAlternateID(String alternateID) {
			this.alternateID = alternateID;
		}

		public String getPreviousSubscriberID() {
			return previousSubscriberID;
		}

		public void setPreviousSubscriberID(String previousSubscriberID) {
			this.previousSubscriberID = previousSubscriberID;
		}

		public String getSocialSecurityNumber() {
			return socialSecurityNumber;
		}

		public void setSocialSecurityNumber(String socialSecurityNumber) {
			this.socialSecurityNumber = socialSecurityNumber;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public String getLaguageCode() {
			return laguageCode;
		}

		public void setLaguageCode(String laguageCode) {
			this.laguageCode = laguageCode;
		}

		public String getRace() {
			return race;
		}

		public void setRace(String race) {
			this.race = race;
		}

		public String getDod() {
			return dod;
		}

		public void setDod(String dod) {
			this.dod = dod;
		}

		public String getGroupID() {
			return groupID;
		}

		public void setGroupID(String groupID) {
			this.groupID = groupID;
		}

		public String getIdcard() {
			return idcard;
		}

		public void setIdcard(String idcard) {
			this.idcard = idcard;
		}

		public String getPhoneID() {
			return phoneID;
		}

		public void setPhoneID(String phoneID) {
			this.phoneID = phoneID;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCountryCode() {
			return countryCode;
		}

		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}	 	

}
