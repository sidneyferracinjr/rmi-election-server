package com.example.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface Election extends Remote {

    /**
     * Registra um voto para um candidato específico.
     *
     * @param candidateName Nome do candidato.
     * @param voteCount Número de votos a serem registrados.
     * @throws RemoteException Se ocorrer um erro de comunicação remota.
     */
    void registerVote(String candidateName, int voteCount) throws RemoteException;

    /**
     * Retorna os resultados atuais da eleição.
     *
     * @return Um mapa contendo os nomes dos candidatos como chaves e o número de votos como valores.
     * @throws RemoteException Se ocorrer um erro de comunicação remota.
     */
    Map<String, Integer> getResults() throws RemoteException;
}
