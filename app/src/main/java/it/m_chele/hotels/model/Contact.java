package it.m_chele.hotels.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

// Generato con "com.robohorse.robopojogenerator"
public class Contact implements Parcelable {

	@SerializedName("phoneNumber")
	private String phoneNumber;

	@SerializedName("email")
	private String email;

	protected Contact(Parcel in) {
		phoneNumber = in.readString();
		email = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(phoneNumber);
		dest.writeString(email);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<Contact> CREATOR = new Creator<Contact>() {
		@Override
		public Contact createFromParcel(Parcel in) {
			return new Contact(in);
		}

		@Override
		public Contact[] newArray(int size) {
			return new Contact[size];
		}
	};

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Contact{" + 
			"phoneNumber = '" + phoneNumber + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}