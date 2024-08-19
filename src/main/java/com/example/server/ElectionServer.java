package com.example.server;

import com.example.common.Election;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class ElectionServer extends UnicastRemoteObject implements Election {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Integer> votes;

    protected ElectionServer() throws RemoteException {
        super();
        votes = new HashMap<>();
    }

    @Override
    public synchronized void registerVote(String candidateName, int voteCount) throws RemoteException {
        votes.put(candidateName, votes.getOrDefault(candidateName, 0) + voteCount);
    }

    @Override
    public synchronized Map<String, Integer> getResults() throws RemoteException {
        return votes;
    }

    public static void main(String[] args) {
        try {
            // Criação e registro do servidor RMI
            ElectionServer server = new ElectionServer();
            Naming.rebind("rmi://localhost/ElectionService", server);
            System.out.println("Servidor de eleições pronto.");

            // Thread para exibir resultados a cada 5 segundos
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(5000);
                        System.out.println("\n--- Apuração Atualizada ---");
                        server.getResults().forEach((candidate, count) ->
                            System.out.println(candidate + ": " + count + " votos"));
                    } catch (InterruptedException | RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
