package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="country_master")
public class Country //parent table
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="country_id")
	private int countryId;//0
	
	@Column(name="country_name")
	private String countryName;//null
	
	@Column(name="country_code")
	private String countryCode;//null
	
	@OneToMany(mappedBy="countryRef",cascade=CascadeType.ALL)
	private List<City> cityRef;//default value null

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<City> getCityRef() {
		return cityRef;
	}

	public void setCityRef(List<City> cityRef) {
		this.cityRef = cityRef;
	}
	
	//helper method
	public void addCities(City tempCity)//Object of city class
	{
		if(cityRef==null)
		{
			cityRef=new ArrayList<City>();
		}
		
		
		cityRef.add(tempCity);
		tempCity.setCountryRef(this);//set city for current country	
	}
}
