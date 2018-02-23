package main;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class MainComPortIntegrator {
	
	public MainComPortIntegrator() {
		super();
	}
	
	public void connect(String portName, ConnectionParams cp) throws Exception{
		CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
		System.out.println("***PARAMETERS*** \nCOMPORT :**"+portName+"**\nDATABITS :**"+cp.getDatabitsMean()+"**\nSTOPBITS :**"+cp.getStopbitsMean()+"**\nPARITY :**"+cp.getParityMean()+"**");
		if(portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
			return;
		}else {
			CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);
			if(commPort instanceof SerialPort) {
				SerialPort serialPort = (SerialPort) commPort;
				serialPort.setSerialPortParams(9600, cp.getDatabits(), cp.getStopbits(), cp.getParity());
				(new Thread(new SerialReader(serialPort))).start();
			}
		}
	}
	
	public static void main(String[] args) {
		ConnectionParams cp = null;
		if(args.length<4) {
			System.out.println("please enter a parameters like \"COM1\" \"8\"(databits) \"1\"(stopbits) \"0\"(parity) ");
			return;
		}else {
			cp = new ConnectionParams();
			cp.setDatabitsString(args[1]);
			cp.setStopbitsString(args[2]);
			cp.setParityString(args[3]);
		}
		try {
			(new MainComPortIntegrator()).connect(args[0],cp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
