package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.SerialPort;

public class SerialReader implements Runnable {

	char ACKCHAR = (char) 0x06;

	String characterSet = "US-ASCII";
	String ACKString = "" + ACKCHAR;

	InputStream inputStream;
	SerialPort serialPort;
	OutputStream outputStream;

	public SerialReader(SerialPort serialPort) {
		try {
			this.serialPort = serialPort;
			this.inputStream = serialPort.getInputStream();
			this.outputStream = serialPort.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		int readedChar = -1;
		byte[] buffer = new byte[1024];
		try {
			while ((readedChar = this.inputStream.read(buffer)) > -1) {
				try {
					if(readedChar == 0)
						continue;
					System.out.print(new String(buffer,0,readedChar));
					this.outputStream.write(ACKString.getBytes());
					System.out.println("\nSending : " + ACKString);
				} catch (IOException e) {
					e.printStackTrace();
					close();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			inputStream.close();
		} catch (Exception e) {
		} finally {
			inputStream = null;
		}

		try {
			outputStream.close();
		} catch (Exception e) {
		} finally {
			outputStream = null;
		}

		try {
			serialPort.close();
		} catch (Exception e) {
		} finally {
			serialPort = null;
		}

	}

}
