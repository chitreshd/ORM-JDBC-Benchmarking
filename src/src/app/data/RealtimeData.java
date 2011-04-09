/**
 * 
 */
package src.app.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */
public class RealtimeData {
	private String symbol;
	private String companyInfo;
	private Date date;
	private float price;
	private float percentChange;
	private float yield;
	private float pe;
	private float peg;
	private float shortD;
	private String range;
	private float avg50D;
	private float chng50D;
	private float avg200D;
	private float chng200D;
	private float target1Y;
	private double volume;
	private double avgVolume;
	
	/**
	 * @return
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * @param symbol
	 */
	public void setSymbol(String symbol) throws IllegalArgumentException{
		if((symbol == null) || (symbol.isEmpty()))
			throw new IllegalArgumentException();
		this.symbol = symbol;
	}
	/**
	 * @return
	 */
	public String getCompanyInfo() {
		return companyInfo;
	}
	/**
	 * @param companyInfo
	 */
	public void setCompanyInfo(String companyInfo) throws IllegalArgumentException{
		if((companyInfo == null) || (companyInfo.isEmpty()))
			throw new IllegalArgumentException();
		this.companyInfo = companyInfo;
	}
	/**
	 * @return
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return
	 */
	public float getPercentChange() {
		return percentChange;
	}
	/**
	 * @param percentChange
	 */
	public void setPercentChange(float percentChange) {
		this.percentChange = percentChange;
	}
	/**
	 * @return
	 */
	public float getYield() {
		return yield;
	}
	/**
	 * @param yield
	 */
	public void setYield(float yield) {
		this.yield = yield;
	}
	/**
	 * @return
	 */
	public float getPe() {
		return pe;
	}
	/**
	 * @param pe
	 */
	public void setPe(float pe) {
		this.pe = pe;
	}
	/**
	 * @return
	 */
	public float getPeg() {
		return peg;
	}
	/**
	 * @param peg
	 */
	public void setPeg(float peg) {
		this.peg = peg;
	}
	/**
	 * @return
	 */
	public float getShortD() {
		return shortD;
	}
	/**
	 * @param shortD
	 */
	public void setShortD(float shortD) {
		this.shortD = shortD;
	}
	/**
	 * @return
	 */
	public String getRange() {
		return range;
	}
	/**
	 * @param range
	 */
	public void setRange(String range) {
		this.range = range;
	}
	/**
	 * @return
	 */
	public float getAvg50D() {
		return avg50D;
	}
	/**
	 * @param avg50d
	 */
	public void setAvg50D(float avg50d) {
		avg50D = avg50d;
	}
	/**
	 * @return
	 */
	public float getChng50D() {
		return chng50D;
	}
	/**
	 * @param chng50d
	 */
	public void setChng50D(float chng50d) {
		chng50D = chng50d;
	}
	/**
	 * @return
	 */
	public float getAvg200D() {
		return avg200D;
	}
	/**
	 * @param avg200d
	 */
	public void setAvg200D(float avg200d) {
		avg200D = avg200d;
	}
	/**
	 * @return
	 */
	public float getChng200D() {
		return chng200D;
	}
	/**
	 * @param chng200d
	 */
	public void setChng200D(float chng200d) {
		chng200D = chng200d;
	}
	/**
	 * @return
	 */
	public float getTarget1Y() {
		return target1Y;
	}
	/**
	 * @param target1y
	 */
	public void setTarget1Y(float target1y) {
		target1Y = target1y;
	}
	/**
	 * @return
	 */
	public double getVolume() {
		return volume;
	}
	/**
	 * @param volume
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}
	/**
	 * @return
	 */
	public double getAvgVolume() {
		return avgVolume;
	}
	/**
	 * @param avgVolume
	 */
	public void setAvgVolume(double avgVolume) {
		this.avgVolume = avgVolume;
	}
	/**
	 * @param date the date to set
	 */
	/**
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * @param date the date to set
	 */
	/**
	 * @param date
	 * @throws ParseException 
	 */
	public void setDate(String date){
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		try {
			this.date = format.parse(date);
		} catch (ParseException e) {
			// TODO This is a time being fix.
			setDate("03/04/2011");		
		}		
	}
	/**
	 * @return the date
	 */
	/**
	 * @return
	 */
	public Date getDate() {
		return date;
	}
	@Override
	public String toString() {
		return "RealtimeData [symbol=" + symbol + ", companyInfo="
				+ companyInfo + ", date=" + date + ", price=" + price
				+ ", percentChange=" + percentChange + ", yield=" + yield
				+ ", pe=" + pe + ", peg=" + peg + ", shortD=" + shortD
				+ ", range=" + range + ", avg50D=" + avg50D + ", chng50D="
				+ chng50D + ", avg200D=" + avg200D + ", chng200D=" + chng200D
				+ ", target1Y=" + target1Y + ", volume=" + volume
				+ ", avgVolume=" + avgVolume + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(avg200D);
		result = prime * result + Float.floatToIntBits(avg50D);
		long temp;
		temp = Double.doubleToLongBits(avgVolume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(chng200D);
		result = prime * result + Float.floatToIntBits(chng50D);
		result = prime * result
				+ ((companyInfo == null) ? 0 : companyInfo.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + Float.floatToIntBits(pe);
		result = prime * result + Float.floatToIntBits(peg);
		result = prime * result + Float.floatToIntBits(percentChange);
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((range == null) ? 0 : range.hashCode());
		result = prime * result + Float.floatToIntBits(shortD);
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + Float.floatToIntBits(target1Y);
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(yield);
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RealtimeData other = (RealtimeData) obj;
		if (Float.floatToIntBits(avg200D) != Float
				.floatToIntBits(other.avg200D))
			return false;
		if (Float.floatToIntBits(avg50D) != Float.floatToIntBits(other.avg50D))
			return false;
		if (Double.doubleToLongBits(avgVolume) != Double
				.doubleToLongBits(other.avgVolume))
			return false;
		if (Float.floatToIntBits(chng200D) != Float
				.floatToIntBits(other.chng200D))
			return false;
		if (Float.floatToIntBits(chng50D) != Float
				.floatToIntBits(other.chng50D))
			return false;
		if (companyInfo == null) {
			if (other.companyInfo != null)
				return false;
		} else if (!companyInfo.equals(other.companyInfo))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Float.floatToIntBits(pe) != Float.floatToIntBits(other.pe))
			return false;
		if (Float.floatToIntBits(peg) != Float.floatToIntBits(other.peg))
			return false;
		if (Float.floatToIntBits(percentChange) != Float
				.floatToIntBits(other.percentChange))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (range == null) {
			if (other.range != null)
				return false;
		} else if (!range.equals(other.range))
			return false;
		if (Float.floatToIntBits(shortD) != Float.floatToIntBits(other.shortD))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (Float.floatToIntBits(target1Y) != Float
				.floatToIntBits(other.target1Y))
			return false;
		if (Double.doubleToLongBits(volume) != Double
				.doubleToLongBits(other.volume))
			return false;
		if (Float.floatToIntBits(yield) != Float.floatToIntBits(other.yield))
			return false;
		return true;
	}	
	
}
