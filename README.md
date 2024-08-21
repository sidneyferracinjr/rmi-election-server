<p align="center">
  <img src="https://controversia.com.br/wp-content/uploads/2016/10/votar.jpg" width="50%" height="50%" alt="Logo do Projeto">
</p>
<div align="center">
  <h1>🗳️ Servidor de Eleição RMI 🗳️</h1>
  <h3>Projeto da disciplina de Sistemas Distribuidos</h3>
</div>
<br>
Este projeto é uma aplicação Java utilizando RMI (Remote Method Invocation) para emular uma eleição em uma cidade. Ele simula o comportamento de urnas eletrônicas, onde cada urna (cliente) envia votos para um servidor central, que é responsável por contar e exibir os resultados atualizados a cada 5 segundos.

## Funcionalidades

- **Servidor RMI**:
  - Recebe e contabiliza votos de diferentes urnas.
  - Exibe a apuração de votos a cada 5 segundos.

- **Cliente RMI (Urna Eletrônica)**:
  - Envia os votos para o servidor.
  - Permite a entrada dos votos e dos nomes dos candidatos via console.

## Requisitos

- **Java 8** ou superior (Java 11 ou Java 17 recomendados)
- **Maven**

## Configuração do Ambiente

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/seu-usuario/ElectionSystem.git
   cd ElectionSystem
   ```

2. **Compile o projeto com Maven**:

   ```bash
   mvn clean compile
   ```

3. **Inicie o Registry RMI** (em um terminal separado):

   ```bash
   rmiregistry
   ```

4. **Inicie o servidor**:

   ```bash
   mvn exec:java -Dexec.mainClass="com.example.server.ElectionServer"
   ```

5. **Inicie um ou mais clientes** (em terminais separados):

   ```bash
   mvn exec:java -Dexec.mainClass="com.example.client.ElectionClient"
   ```

## Como Usar

### No Cliente (Urna Eletrônica):

1. Quando o cliente iniciar, você poderá inserir o nome de um candidato e a quantidade de votos a ser registrado.
2. Os dados serão enviados ao servidor central, que os contabilizará.

### No Servidor:

1. O servidor exibirá a apuração de votos a cada 5 segundos, mostrando os candidatos e a quantidade total de votos recebidos.

## Exemplo de Uso

**Entrada do Cliente:**

```plaintext
Digite o nome do candidato: João
Digite o número de votos: 10
Voto registrado com sucesso.

Digite o nome do candidato: Maria
Digite o número de votos: 5
Voto registrado com sucesso.
```

**Saída do Servidor:**

```plaintext
Servidor de eleições pronto.

--- Apuração Atualizada ---
João: 10 votos
Maria: 5 votos
```

## Considerações

- **Thread Safety:** O servidor é thread-safe, garantindo que vários clientes (urnas) possam enviar votos simultaneamente sem problemas de concorrência.
- **Atualização de Resultados:** O servidor atualiza os resultados a cada 5 segundos, conforme exigido.

## Licença

Este projeto é apenas para fins educacionais. Sinta-se livre para usá-lo e modificá-lo conforme necessário.
