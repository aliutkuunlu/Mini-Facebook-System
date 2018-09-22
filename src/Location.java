
public class Location {
	
	private double longtitude;
	private double latitude;
	
	/**
	 * to getLatitude
	 * @return
	 */
	public double getLatitude() 
	{
		return latitude;
	}
	/**
	 * to setLatitude
	 * @param latitude
	 */
	public void setLatitude(double latitude) 
	{
		this.latitude = latitude;
	}
	/**
	 * to getLongtitude
	 * @return
	 */
	public double getLongtitude() 
	{
		return longtitude;
	}
	/**
	 * to setLongtitude
	 * @param longtitude
	 */
	public void setLongtitude(double longtitude) 
	{
		this.longtitude = longtitude;
	}
	@Override
	public String toString() 
	{
		return  + longtitude + "\t" + latitude + "]";
	}
	

}
