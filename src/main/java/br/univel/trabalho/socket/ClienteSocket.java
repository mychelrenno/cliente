package br.univel.trabalho.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteSocket {

	private static ClienteSocket clienteSocket;
	private Socket client;
	private Object entrada;

	public static synchronized ClienteSocket getInstance() {
		if (clienteSocket == null) {
			clienteSocket = new ClienteSocket();
		}
		return clienteSocket;
	}

	public Object send(Object saida) {
		try {

			client = new Socket("127.0.0.1", 8080);
			// output = saída
			ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
			output.writeObject(saida);
			output.flush();
			System.out.println("Saída cliente: " + saida.getClass().toString());

			// input = entrada
			ObjectInputStream input = new ObjectInputStream(client.getInputStream());
			entrada = input.readObject();
			System.out.println("Entrada cliente: " + entrada.getClass().toString());

			output.close();
			input.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return entrada;
	}
}
