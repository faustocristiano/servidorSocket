import java.io.BufferedReader;
import java.net.ServerSocket;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ServidorTCP{

    
    public static void main(String[] args) {             
         String diretorio= args[0];
         System.out.println(diretorio);
        List<String> listagemDiretorio = new ArrayList<>();   
         while(true){
            try(ServerSocket socket = new ServerSocket(1234)){
                System.out.println("Aguardando por conexoes em: " + socket.getInetAddress() + ":" + socket.getLocalPort());
                try(Socket clientSocket = socket.accept()){
                    // Estabelecendo fluxos de entrada e saÃ­da
                    BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    ObjectOutputStream saida= new ObjectOutputStream(clientSocket.getOutputStream());
                   
                    // lendo mensagem enviada pelo cliente
                    String mensagem = entrada.readLine();
                        if(mensagem.equals("list")){   
                            //lista o diretorio e coloca o nome dos aquivos em uma lista                                           
                            File servidor = new File(diretorio);
                            for(File arquivos:servidor.listFiles()){ 
                                listagemDiretorio.add(arquivos.getName());                                    
                                }
                            //envia a lista como obeto pro cliente      
                            saida.writeObject(listagemDiretorio);
                            listagemDiretorio.clear();                               

                        } else{                                                                 
                            File servidor = new File(diretorio+mensagem);
                            InputStream file = new FileInputStream(servidor);                            
                            //le o arquivo por comleto em bytes e envia como obeto para o cliente
                            byte[] pacotes = file.readAllBytes();
                            saida.writeObject(pacotes); 
                            saida.flush(); 
                            file.close();                      
                            }     
                                             
                }catch(Exception e){
                    System.err.println(e.toString());
                }
            }catch(Exception e){
                System.err.println(e.toString());
            }
        } 
    }
}