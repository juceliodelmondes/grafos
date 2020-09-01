
import javax.swing.JOptionPane;

public class logica 
{
    String textoFinal = "";
    int quantidadeArestas[];
    int valorTotal = 0;
    int totalArestas;
    int totalVertices;
    int verticeUtilizado[];
    int matriz[][];
    int somaAresta;
    char nomeVertice[] = {'N', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    int valorDeImpressao=0; //variável que limita as informações de print, para não imprimir a mais
    
    /*
        matriz matriz;
        a linha represtenta o inicio e a coluna representa o destino
    exemplo ligando vertice A ao vertice B com uma matriz de valor 5
    
        matriz[verticeInicio][verticeDestino] = valor da matriz;
        matriz[1][2] = 5;
    
    */
    
    public logica()
    {
        somaAresta = 0;
        matriz = new int[11][11];
        quantidadeArestas = new int[11];
        verticeUtilizado = new int[11];
        desmarcarVertices();
        zerarTotalArestas();
    }
    
    public void marcarVertice(int tmpVertice) //marca o vértice para não ser reutilizado duas vezes.
    {
        verticeUtilizado[tmpVertice] = 1;
    }
    
    public void desmarcarVertices()
    {
        for(int verticeAtual = 1; verticeAtual <= 10; verticeAtual++)
        {
            verticeUtilizado[verticeAtual] = 0;
        }
    }
    
    public int verificarMarcacao(int tmpVertice) //retorna o valor 1 se o vertice já está sendo utilizado
    {
        return verticeUtilizado[tmpVertice];
    }
    
    public void adicionarAresta(int vertice1, int vertice2, int valorAresta)
    {
        matriz[vertice1][vertice2] = valorAresta;
        matriz[vertice2][vertice1] = valorAresta; // coloca o mesmo valor.
        
        for(int i = 1; i <= 10; i++)
        {
            for(int j = 1; j <= 10; j++)
            {
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void adicionarQuantidadeAresta(char vertice1, char vertice2)
    {
        if(vertice1 == 'A' || vertice2 == 'A') quantidadeArestas[1]++;
        if(vertice1 == 'B' || vertice2 == 'B') quantidadeArestas[2]++;
        if(vertice1 == 'C' || vertice2 == 'C') quantidadeArestas[3]++;
        if(vertice1 == 'D' || vertice2 == 'D') quantidadeArestas[4]++;
        if(vertice1 == 'E' || vertice2 == 'E') quantidadeArestas[5]++;
        if(vertice1 == 'F' || vertice2 == 'F') quantidadeArestas[6]++;
        if(vertice1 == 'G' || vertice2 == 'G') quantidadeArestas[7]++;
        if(vertice1 == 'H' || vertice2 == 'H') quantidadeArestas[8]++;
        if(vertice1 == 'I' || vertice2 == 'I') quantidadeArestas[9]++;
        if(vertice1 == 'J' || vertice2 == 'J') quantidadeArestas[10]++;
    }
    
    public int consultarAresta(char vertice)
    {
        if(vertice == 'A') return quantidadeArestas[1];
        if(vertice == 'B') return quantidadeArestas[2];
        if(vertice == 'C') return quantidadeArestas[3];
        if(vertice == 'D') return quantidadeArestas[4];
        if(vertice == 'E') return quantidadeArestas[5];
        if(vertice == 'F') return quantidadeArestas[6];
        if(vertice == 'G') return quantidadeArestas[7];
        if(vertice == 'H') return quantidadeArestas[8];
        if(vertice == 'I') return quantidadeArestas[9];
        if(vertice == 'J') return quantidadeArestas[10];
        else return -1;
    }
    
    public void somarVertice()
    {
        this.totalVertices += 1;
    }
    
    public int quantidadeVertice()
    {
        return this.totalVertices;
    }
    
    public void subtrairVertice()
    {
        if(totalVertices > 0)
        {
            totalVertices -= 1;
        }
    }
    
    public void zerarVertices()
    {
        totalVertices = 0;
    }
    
    public void somarArestas(int valor)
    {
        totalArestas += valor;
    }
    public int consultarTotalArestas()
    {
        return totalArestas;
    }
    
    public void zerarAresta()
    {
        for(int i = 0; i <= 10; i++)
        {
            quantidadeArestas[i] = 0;
        }
    }
    
    public void zerarTotalArestas()
    {
        totalArestas = 0;
        for(int i = 1; i <= 10; i ++) //zera a matriz
        {
            for(int j = 1; j <= 10; j ++)
            {
                matriz[i][j] = 0;
            }
        }
        zerarAresta();
    }
    
    
    public void imprimirMatriz()
    {
        for(int i = 0; i < matriz.length; i++)
        {
            for(int j = 0; j < matriz.length; j ++)
            {
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }
    
    public String processar()
    {
        valorDeImpressao = 1;
        valorTotal=0;
        textoFinal = "";
        int caminho1 = 1;
        int caminho2 = retornarProximaLinha(caminho1);
        int caminho3 = retornarProximaLinha(caminho2);
        int caminho4 = retornarProximaLinha(caminho3);
        int caminho5 = retornarProximaLinha(caminho4);
        int caminho6 = retornarProximaLinha(caminho5);
        int caminho7 = retornarProximaLinha(caminho6);
        int caminho8 = retornarProximaLinha(caminho7);
        int caminho9 = retornarProximaLinha(caminho8);
        int caminho10 = retornarProximaLinha(caminho9);
        int caminho11 = retornarProximaLinha(caminho10);
        imprimirMatriz();
        String retorno = "Arvore mínima:\n"+textoFinal+"\nResultado da soma: "+valorTotal;
        return retorno;
    }
    
    
    public int retornarProximaLinha(int linha)
    {
        if(valorDeImpressao < quantidadeVertice())
        {
            if(linha > 0)
            {
                int menorNumero = 1000;
                int pos = 100;
                int aresta = 0;
                for(int i = 1; i < 11; i++)
                {
                    if(menorNumero > matriz[linha][i] && matriz[linha][i] > 0)
                    {
                        menorNumero = matriz[linha][i];
                        pos = i; //retorna o numero da coluna, dizendo que será a proxima linha
                        matriz[linha][i] = 0; //zera a posicao anterior
                        matriz[i][linha] = 0; //zera posicao contrária
                        
                    }
                }
                textoFinal+="{"+nomeVertice[linha]+","+nomeVertice[pos]+"} com o valor de aresta: "+menorNumero+"\n";
                valorTotal+=menorNumero;
                valorDeImpressao++;
                //zerarColuna
                for(int i = 1; i < matriz.length; i++)
                {
                    matriz[i][1] = 0; //zera a primeira coluna, para nao voltar para o inicio
                    matriz[i][pos] = 0; //deleta coluna inteira
                }
                
                return pos;
            }
            else return 0;
        }
        else return 0;
    }
    
    /*
    public String processar()
    {
        int linhaVertice = 1000, colunaVertice = 1000, menorAresta = 1000, menorCaminho = 0;
        System.out.println("Total de vértices: "+this.totalVertices);
        for(int l = 1; l <= 10; l ++)
        {
            for(int c = 1; c <= 10; c++)
            {
                if(aresta[l][c] > 0)
                {
                    if(verificarMarcacao(l) == 0)
                    {
                        if(menorAresta > aresta[l][c])
                        {
                            linhaVertice = l;
                            colunaVertice = c;
                            menorAresta = aresta[l][c];
                            menorCaminho += aresta[l][c];
                            marcarVertice(l); //marca o vértice de inicio, marcando o vértice da linha
                            System.out.println(nomeVertice[l]);
                        }
                    }
                }
            }
        }
        System.out.println("Os vértices: "+this.nomeVertice[linhaVertice]+ " e "+this.nomeVertice[colunaVertice]+ " contém a menor distância! Com o valor de aresta: " + menorAresta);
        System.out.println("Soma dos caminhos: "+menorCaminho);
        return "";
    }*/
    
}
