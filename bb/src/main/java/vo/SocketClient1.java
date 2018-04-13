/**@(#)SocketClient.java Mar 19,2018 1:07:51 PM**Copyright 2018 Rockwell Automation,Inc.All rights reserved.*Rockwell Automation PROPRIETARY/CONFIDENTIAL.Use is subject to license terms.*/
package vo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient1
{
	public static void main(String args[])
		throws Exception
	{
		// Ҫ���ӵķ����IP��ַ�Ͷ˿�
		String host = "192.168.6.123";
		int port = 8001;
		// �����˽�������
		Socket socket = new Socket(host, port);
		// �������Ӻ��������
		OutputStream outputStream = socket.getOutputStream();
		String message = "zorosb";
		socket.getOutputStream().write(message.getBytes("UTF-8"));
		// ͨ��shutdownOutput���ٷ������Ѿ����������ݣ�����ֻ�ܽ�������
		socket.shutdownOutput();

		InputStream inputStream = socket.getInputStream();
		byte[] bytes = new byte[1024];
		int len;
		StringBuilder sb = new StringBuilder();
		while ((len = inputStream.read(bytes)) != -1)
		{
			// ע��ָ�������ʽ�����ͷ��ͽ��շ�һ��Ҫͳһ������ʹ��UTF-8
			sb.append(new String(bytes, 0, len, "UTF-8"));
		}
		System.out.println("get message from server: " + sb);

//		inputStream.close();
//		outputStream.close();
//		socket.close();
	}
}
// package test;
//
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.io.Writer;
// import java.net.Socket;
// import java.net.SocketException;
// import java.net.SocketTimeoutException;
// import java.text.SimpleDateFormat;
// import java.util.Date;
//
// public class SocketClient1
// {
// public static String _pattern = "yyyy-MM-dd HH:mm:ss SSS";
//
// public static SimpleDateFormat format = new SimpleDateFormat(_pattern);
//
// // ���ó�ʱ��
// public static int _sec = 5;
//
// public static void main(String[] args)
// {
// System.out.println("----------Client----------");
//
// Socket socket = null;
// try
// {
// // �����˽�������
// socket = new Socket("192.168.6.123", 8001);
// socket.setSoTimeout(_sec * 1000);
//
// System.out.println(format.format(new Date()));
// System.out.println("����������\n");
//
// // ������д����
// Writer writer = new OutputStreamWriter(socket.getOutputStream());
//
// System.out.println(format.format(new Date()));
// System.out.println("����д��\n");
// Thread.sleep(10000);
// writer.write("��û���յ�\n");
//
// System.out.println(format.format(new Date()));
// System.out.println("д���� ������\n");
//
// writer.flush();
//
// BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
// System.out.println(format.format(new Date()) + "\n" + _sec + "���ʱ�� ���������յ�����\n");
//
// System.out.println(format.format(new Date()) + "\nServer:" + br.readLine());
//
// }
// catch (SocketTimeoutException e)
// {
// System.out.println(format.format(new Date()) + "\n" + _sec + "��û�յ��ظ� ������\n\n\n\n\n");
// e.printStackTrace();
// }
// catch (SocketException e)
// {
// e.printStackTrace();
// }
// catch (Exception e)
// {
// e.printStackTrace();
// }
// }
// }
