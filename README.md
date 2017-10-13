<b>Exemplos com Apache Mina</b>

Série de exemplos com apache mina utilizando o padrao NIO Socket (socket não blocante)

A vantagem de usar a NIO sobre a IO bloqueante é que as operações envolvidas não precisam aguardar 
por um resultado imediato (por isso são consideradas assíncronas). Ao criar um servidor TCP/IP, por exemplo, 
usando IO bloqueante, cada conexão deve ser processada por uma thread separada, pois operações de 
leitura/escrita podem ficar bloqueadas à espera de resposta, enquanto no NIO uma única thread pode lidar, 
de forma assíncrona, com várias conexões. Isso faz com que o desempenho do servidor seja mais eficiente.

Exemplos com comunicação em conexões TCP
Exemplos com comunicação em conexões UDP

# TCP

Para efetuar testes:

- execute a classe MinaServer (por default esta na porta 5000)
- execute a classe TcpClient (por default esta na porta 5000)
- agora basta enviar comandos pelo console do TcpClient e podera observar a comunicação TCP entre Server e Cliente
