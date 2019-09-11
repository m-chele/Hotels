package it.m_chele.hotels.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// Generato con "com.robohorse.robopojogenerator"
public class Hotels{

	@SerializedName("hotels")
	private List<HotelsItem> hotels;

	public void setHotels(List<HotelsItem> hotels){
		this.hotels = hotels;
	}

	public List<HotelsItem> getHotels(){
		return hotels;
	}

	@Override
 	public String toString(){
		return 
			"Hotels{" + 
			"hotels = '" + hotels + '\'' + 
			"}";
		}
}