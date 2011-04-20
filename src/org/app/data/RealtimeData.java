/**
 * 
 */
package org.app.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.app.main.RealTimeDataExtractor;


/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */

public class RealtimeData extends AData {
	private static final Log log = LogFactory
	.getLog(RealTimeDataExtractor.class);
	
	
	protected String companyInfo;
	
	
	protected float price;
	protected float percentChange;
	protected float yield;
	protected float pe;
	protected float peg;
	protected float shortD;
	protected String range;
	protected float avg50D;
	protected float chng50D;
	protected float avg200D;
	protected float chng200D;
	protected float target1Y;
	protected double volume;
	protected double avgVolume;
	
	
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
	 * @param date the date to set
	 */
	/**
	 * @param date
	 * @throws ParseException 
	 */
	public void setDate(String date){
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		try {
			setDate(format.parse(date));
		} catch (ParseException e) {
			// TODO This is a time being fix.
			setDate("03/04/2011");
			log.error("Date was null and hence setting up the date as today's date.");
		}		
	}
	/**
	 * @return the date
	 */
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	
	
	
	
	@Override
	public String toString() {
		return "RealtimeData [companyInfo=" + companyInfo + ", price=" + price
				+ ", percentChange=" + percentChange + ", yield=" + yield
				+ ", pe=" + pe + ", peg=" + peg + ", shortD=" + shortD
				+ ", range=" + range + ", avg50D=" + avg50D + ", chng50D="
				+ chng50D + ", avg200D=" + avg200D + ", chng200D=" + chng200D
				+ ", target1Y=" + target1Y + ", volume=" + volume
				+ ", avgVolume=" + avgVolume + ", symbol=" + symbol + ", date="
				+ date + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(avg200D);
		result = prime * result + Float.floatToIntBits(avg50D);
		long temp;
		temp = Double.doubleToLongBits(avgVolume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(chng200D);
		result = prime * result + Float.floatToIntBits(chng50D);
		result = prime * result
				+ ((companyInfo == null) ? 0 : companyInfo.hashCode());
		result = prime * result + Float.floatToIntBits(pe);
		result = prime * result + Float.floatToIntBits(peg);
		result = prime * result + Float.floatToIntBits(percentChange);
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((range == null) ? 0 : range.hashCode());
		result = prime * result + Float.floatToIntBits(shortD);
		result = prime * result + Float.floatToIntBits(target1Y);
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(yield);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
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
	
	public boolean isGood(){
		/*The bean is not good 
			if any of the string elements is null
			if symbol or date is empty*/
			if(symbol == null || companyInfo == null || date == null)
				return false;
			else if (symbol.isEmpty())
				return false;
			else		
				return true;
	}
	
}
