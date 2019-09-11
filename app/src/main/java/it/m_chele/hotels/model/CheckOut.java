package it.m_chele.hotels.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

// Generato con "com.robohorse.robopojogenerator"
public class CheckOut implements Parcelable {

	@SerializedName("from")
	private String from;

	@SerializedName("to")
	private String to;

	protected CheckOut(Parcel in) {
		from = in.readString();
		to = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(from);
		dest.writeString(to);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<CheckOut> CREATOR = new Creator<CheckOut>() {
		@Override
		public CheckOut createFromParcel(Parcel in) {
			return new CheckOut(in);
		}

		@Override
		public CheckOut[] newArray(int size) {
			return new CheckOut[size];
		}
	};

	public void setFrom(String from){
		this.from = from;
	}

	public String getFrom(){
		return from;
	}

	public void setTo(String to){
		this.to = to;
	}

	public String getTo(){
		return to;
	}

	@Override
 	public String toString(){
		return 
			"CheckOut{" + 
			"from = '" + from + '\'' + 
			",to = '" + to + '\'' + 
			"}";
		}
}