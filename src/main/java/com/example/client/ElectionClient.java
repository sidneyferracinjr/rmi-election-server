package com.example.client;

import com.example.common.Election;

import java.rmi.Naming;
import java.util.Scanner;

public class ElectionClient {
    public static void main(String[] args) {
        try {
            // Localiza o servidor RMI usando o nome registrado
            Election election = (Election) Naming.lookup("rmi://localhost/ElectionService");

            try (// Scanner para leitura de entradas do usuário
			Scanner scanner = new Scanner(System.in)) {
				// Loop para inserir votos repetidamente
				while (true) {
				    // Leitura do nome do candidato
				    System.out.print("Digite o nome do candidato: ");
				    String candidateName = scanner.nextLine();

				    // Leitura do número de votos
				    System.out.print("Digite o número de votos: ");
				    int voteCount = Integer.parseInt(scanner.nextLine());

				    // Envia os votos para o servidor
				    election.registerVote(candidateName, voteCount);
				    System.out.println("Voto registrado com sucesso.");

				    // Opcional: Perguntar ao usuário se deseja continuar ou sair
				    System.out.print("Deseja registrar outro voto? (s/n): ");
				    String continueVoting = scanner.nextLine();
				    if (continueVoting.equalsIgnoreCase("n")) {
				        break;
				    }
				}
			}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
