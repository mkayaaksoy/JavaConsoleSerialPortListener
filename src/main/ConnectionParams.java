package main;

import java.io.Serializable;

import gnu.io.SerialPort;

public class ConnectionParams implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private int databits = 8;
	private int stopbits = 1;
	private int parity = 0;
	private String databitsString;
	private String stopbitsString;
	private String parityString;
	private String databitsMean;
	private String stopbitsMean;
	private String parityMean;
	
	public int getDatabits() {
		return databits;
	}
	public void setDatabits(int databits) {
		this.databits = databits;
	}
	public int getStopbits() {
		return stopbits;
	}
	public void setStopbits(int stopbits) {
		this.stopbits = stopbits;
	}
	public int getParity() {
		return parity;
	}
	public void setParity(int parity) {
		this.parity = parity;
	}
	public String getDatabitsString() {
		return databitsString;
	}
	
	public String getStopbitsString() {
		return stopbitsString;
	}
	public String getParityString() {
		return parityString;
	}
	public String getDatabitsMean() {
		return databitsMean;
	}
	public void setDatabitsMean(String databitsMean) {
		this.databitsMean = databitsMean;
	}
	public String getStopbitsMean() {
		return stopbitsMean;
	}
	public void setStopbitsMean(String stopbitsMean) {
		this.stopbitsMean = stopbitsMean;
	}
	public String getParityMean() {
		return parityMean;
	}
	public void setParityMean(String parityMean) {
		this.parityMean = parityMean;
	}
	//**-------**\\
	public void setDatabitsString(String databitsString) {
		this.databitsString = databitsString;
		if(databitsString.equals("5")) {
			this.databits = SerialPort.DATABITS_5;
			this.databitsMean = "DATABITS_5";
		}else if(databitsString.equals("6")) {
			this.databits = SerialPort.DATABITS_6;
			this.databitsMean = "DATABITS_6";
		}else if(databitsString.equals("7")) {
			this.databits = SerialPort.DATABITS_7;
			this.databitsMean = "DATABITS_7";
		}else if(databitsString.equals("8")) {
			this.databits = SerialPort.DATABITS_8;
			this.databitsMean = "DATABITS_8";
		}
	}
	public void setStopbitsString(String stopbitsString) {
		this.stopbitsString = stopbitsString;
		if(stopbitsString.equals("1")) {
			this.stopbits = SerialPort.STOPBITS_1;
			this.stopbitsMean = "STOPSBITS_1";
		}else if(stopbitsString.equals("3")) {
			this.stopbits = SerialPort.STOPBITS_1_5;
			this.stopbitsMean = "STOPSBITS_1_5";
		}else if(stopbitsString.equals("2")) {
			this.stopbits = SerialPort.STOPBITS_2;
			this.stopbitsMean = "STOPSBITS_2";
		}
	}
	
	public void setParityString(String parityString) {
		this.parityString = parityString;
		if(parityString.equals("0")) {
			this.parity = SerialPort.PARITY_NONE;
			this.parityMean = "PARITY_NONE";
		}else if(parityString.equals("1")) {
			this.parity = SerialPort.PARITY_ODD;
			this.parityMean = "PARITY_ODD";
		}else if(parityString.equals("2")) {
			this.parity = SerialPort.PARITY_EVEN;
			this.parityMean = "PARITY_EVEN";
		}else if(parityString.equals("3")) {
			this.parity = SerialPort.PARITY_MARK;
			this.parityMean = "PARITY_MARK";
		}else if(parityString.equals("4")) {
			this.parity = SerialPort.PARITY_SPACE;
			this.parityMean = "PARITY_SPACE";
		}
	}
	

	
	

}
