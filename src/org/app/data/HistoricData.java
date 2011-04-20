package org.app.data;


/**
 * @author Chitresh Deshpande
 * 
 * Copyright 2011, San Jose State University
 *
 */
public class HistoricData extends AData{
	
	protected float open;
	protected float close;
	protected float high;
	protected float low;
	protected double volume;
	protected float adjClose;
	public float getOpen() {
		return open;
	}
	public void setOpen(float open) {
		this.open = open;
	}
	public float getClose() {
		return close;
	}
	public void setClose(float close) {
		this.close = close;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public float getLow() {
		return low;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public float getAdjClose() {
		return adjClose;
	}
	public void setAdjClose(float adjClose) {
		this.adjClose = adjClose;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Float.floatToIntBits(adjClose);
		result = prime * result + Float.floatToIntBits(close);
		result = prime * result + Float.floatToIntBits(high);
		result = prime * result + Float.floatToIntBits(low);
		result = prime * result + Float.floatToIntBits(open);
		long temp;
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		HistoricData other = (HistoricData) obj;
		if (Float.floatToIntBits(adjClose) != Float
				.floatToIntBits(other.adjClose))
			return false;
		if (Float.floatToIntBits(close) != Float.floatToIntBits(other.close))
			return false;
		if (Float.floatToIntBits(high) != Float.floatToIntBits(other.high))
			return false;
		if (Float.floatToIntBits(low) != Float.floatToIntBits(other.low))
			return false;
		if (Float.floatToIntBits(open) != Float.floatToIntBits(other.open))
			return false;
		if (Double.doubleToLongBits(volume) != Double
				.doubleToLongBits(other.volume))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HistoricData [open=" + open + ", close=" + close + ", high="
				+ high + ", low=" + low + ", volume=" + volume + ", adjClose="
				+ adjClose + ", symbol=" + symbol + ", date=" + date + "]";
	}
	
	
	
	
	
	
	

}
