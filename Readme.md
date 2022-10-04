# **Projeto:**
- Tem como finalidade, desenvolver uma aplicação entre um servidor/cliente, utilizando a API socket dísponivel na biblioteca java.net.Socket; 

# **Compilação:**
- Para compilar o projeto servidor, o usuário deve acessar o shell, estar na pasta onde fica a classe do ServidorTCP.java, e executar o comando: javac ServidorTCP.java
- Para compilar o projeto cliente, o usuário deve acessar o shell, estar na pasta onde fica a classe do ClienteTCP.java, e executar o comando: javac clienteTCP.java
 
#  **Comandos:**
- Servidor: para subir o servidor, o usuario deve executar o comando no mesmo diretorio que foi compilado o ServidorTCP.java, e digitar o comando: java ServidorTCP, seguido do caminho de destino da pasta onde estão os arquivos do servidor, por exemplo: *java ServidorTCP /home/arquivos*

- Cliente: Existem duas opções para o cliente:
  - 1ª: primeiro a opção list, onde o servidor irá informar os arquivos disponiveis. O usuário devera executar o seguinte comando via shell no diretório onde está compilada a classe ClienteTCP.java: java ClienteTCP IP_do_Servidor Porta_do_Servidor list, por exemplo: *java ClienteTCP 127.0.0.0 1234 list*
  
  - 2ª: Com a listagem dos arquivos disponíveis, o usuário devera solicitar ao servidor o arquivo,e informar via *>* o redirecionamento para qual arquivo ira salvar, por exempo: *java ClienteTCP 127.0.0.0 quartus.txt > recebido.txt*

