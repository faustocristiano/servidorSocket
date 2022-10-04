import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Socket;

public class ClienteTCP {
    
    public static void main(String[] args) throws IOException{
        String servidorIP = args[0];
        int servidorPorta = Integer.parseInt(args[1]);
        String opcao = args[2]+"\n";      
        try(Socket conexao = new Socket(servidorIP, servidorPorta)){
            System.out.println("Conectado! " + conexao);
            /* Estabelece fluxos de entrada e saida */
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
            ObjectInputStream entrada= new ObjectInputStream(conexao.getInputStream());    
            if(opcao.equals("list\n")){
                saida.write(opcao.getBytes());
                saida.flush();  
                //System.out.println(entrada.readObject()); 
                String arquivos = String.valueOf(entrada.readObject());
                arquivos=arquivos.substring(1, arquivos.length() - 1); 
                //Usado split(, ), para organzizar em colunas os itens da lista
                String[] listaArq = arquivos.split(", ");
                System.out.println("Seguem arquivos do diretorio remoto :");
                for(int i=0;i<listaArq.length;i++){
                    System.out.println(listaArq[i]); 
                    }    
                }
            
            if(opcao.contains("get")){ 
                //envia o nome do arquivo para o servidor
                String nomeArquivo=args[3]+"\n";           
                saida.write(nomeArquivo.getBytes());
                saida.flush();                
                //cria arquivo informado pelo usuario
                File arquivo = new File(args[3]); 
                //instancia o arquivo                     
                OutputStream file = new FileOutputStream(arquivo);
                byte[] recebida = (byte[]) entrada.readObject();
                //salva no arquivo
                file.write(recebida);   
                file.close();          
                System.out.println(new String(recebida, java.nio.charset.StandardCharsets.UTF_8));            
                
            }           
        }catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}   