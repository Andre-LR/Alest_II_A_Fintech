import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Ordem;

public class Sistema {
    Scanner in = new Scanner(System.in);
    List<Ordem> listaOrdens = new ArrayList<>();
    
    public Sistema(){};

    public String showDados(){
        String txt="";
        for (Ordem ordem : listaOrdens) {
            txt = txt + ordem.toString();
        }

        return txt;
    }

    public void lerArquivo(){
        System.out.println("Escolha um arquivo para ser lido");
        System.out.println("trinta.txt\ntrezentos.txt\ncem_mil.txt\ncem.txt\nmil.txt\ncinco_mil.txt\ncinquenta_mil.txt");

        String path = in.next();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = "";
            List<Ordem> listaOrdens = new ArrayList<>();
            int qtdOrdens = 0;
            boolean isFirstLine = true;
            
            //Ler todas as linhas do arquivo
            while(line != null){
                String dadosLinha[];
                //Ler linha do arquivo
                line = br.readLine();
                
                //A primeira será correspondente ao n° de ordens enviadas
                //Se for a primeira linha do arquivo, extrair o dado e colocar na qtdOrdens
                if(isFirstLine){
                    dadosLinha = line.split(";");
                    qtdOrdens = Integer.parseInt(dadosLinha[0]);
                    isFirstLine = false;

                }else{
                    //Colocar os dados da ordem no vetor que contérá os dados da linha
                    dadosLinha = line.split(" ");
                    
                    //Organizar os dados nas variaveis
                    String tipoOrdem = dadosLinha[0];
                    int qtdAcoes = Integer.parseInt(dadosLinha[1]);
                    int precoAcao = Integer.parseInt(dadosLinha[2]);
                    
                    //Instanciar a nova ordem e colocar na lista de ordens
                    Ordem novaOrdem = new Ordem(tipoOrdem,qtdAcoes,precoAcao);
                    listaOrdens.add(novaOrdem);
                }
            }
            
        }catch (IOException e){
            System.err.println("Erro no carregamento: " + e.getMessage());
        }
        finally {
            System.out.println("Operação finalizada...");
        }
    }
}