package com.adhack.adhack;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.Vector;

public class Test {
	public static void main(String[] args) {
		try {
			XmlRpcClient server = new XmlRpcClient();
			XmlRpcClientConfigImpl xmlRpcClientConfig = new XmlRpcClientConfigImpl();
			xmlRpcClientConfig.setServerURL(new URL("https://api.sape.ru/xmlrpc/"));
			server.setConfig(xmlRpcClientConfig);
			Vector params = new Vector();

			Object result = server.execute("sape.get_languages", params);

//			int sum = ((Integer) result).intValue();
			System.out.println("The sum is: "+ result);

		} catch (Exception exception) {
			System.err.println("JavaClient: " + exception);
		}
	}
}
