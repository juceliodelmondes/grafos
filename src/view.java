
/*
Método que controla a view
*/
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import javax.swing.*;

public class view extends JFrame implements ActionListener, MouseListener
{
    Container containerPrincipal, containerBotoes, containerTexto;
    ImageIcon verticeA, verticeB, verticeC, verticeD, verticeE, verticeF, verticeG, verticeH, verticeI, verticeJ;
    JLabel labelVA, labelVB, labelVC, labelVD, labelVE, labelVF, labelVG, labelVH, labelVI, labelVJ;
    JButton botoes[];
    String textos[] = {"Adicionar vértice", "Remover vértice", "Adicionar aresta", "Apagar tudo", "Processar"};
    Font fonteBotao;
    JTextArea textoResultado;
    int modo = 0;
    final String diretorioVertice = "imagens//vertices//";
    int quantidadeVertice = 0;
    int verticePosicionado[];
    char vertices[] = {'0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    int modoDeAresta = 0;
    int inicioX, inicioY;
    int destinoX, destinoY;
    final Color corAresta = Color.ORANGE;
    char arestaInicio, arestaDestino;
    public view()
    {
        super("Arvore mínima - Jucelio Delmondes do Amaral - 28263538");
        verticePosicionado = new int[11];
        for(int i = 0; i < 11; i ++)
        {
            verticePosicionado[i] = 0;
        }
       
        setCursor(0);
        fonteBotao = new Font("Arial", Font.BOLD, 15);
        containerPrincipal = new Container();
        containerPrincipal.setLayout(new BorderLayout());
        containerPrincipal.addMouseListener(this);
        this.add(containerPrincipal);
        
        
        verticeA = new ImageIcon(diretorioVertice+"A.png");
        
        labelVA = new JLabel(verticeA);
        labelVA.setBounds(0, 0, 80, 80);
        labelVA.show(false);        
        containerPrincipal.add(BorderLayout.CENTER, labelVA);   
        
        
        verticeB = new ImageIcon(diretorioVertice+"B.png");
        labelVB = new JLabel(verticeB);
        labelVB.setBounds(0, 0, 80, 80);
        labelVB.show(false);
        containerPrincipal.add(BorderLayout.CENTER, labelVB);
               
        verticeC = new ImageIcon(diretorioVertice+"C.png");
        labelVC = new JLabel(verticeC);
        labelVC.setBounds(0, 0, 80, 80);
        labelVC.show(false);
        containerPrincipal.add(BorderLayout.CENTER, labelVC);
        
        verticeD = new ImageIcon(diretorioVertice+"D.png");
        labelVD = new JLabel(verticeD);
        labelVD.setBounds(0, 0, 80, 80);
        labelVD.show(false);
        containerPrincipal.add(BorderLayout.CENTER, labelVD);
        
        verticeE = new ImageIcon(diretorioVertice+"E.png");
        labelVE = new JLabel(verticeE);
        labelVE.setBounds(0, 0, 80, 80);
        labelVE.show(false);
        containerPrincipal.add(BorderLayout.CENTER, labelVE);
                
        verticeF = new ImageIcon(diretorioVertice+"F.png");
        labelVF = new JLabel(verticeF);
        labelVF.setBounds(0, 0, 80, 80);
        labelVF.show(false);
        containerPrincipal.add(BorderLayout.CENTER, labelVF);
        
        verticeG = new ImageIcon(diretorioVertice+"G.png");
        labelVG = new JLabel(verticeG);
        labelVG.setBounds(0, 0, 80, 80);
        labelVG.show(false);
        containerPrincipal.add(BorderLayout.CENTER, labelVG);

        verticeH = new ImageIcon(diretorioVertice+"H.png");
        labelVH = new JLabel(verticeH);
        labelVH.setBounds(0, 0, 80, 80);
        labelVH.show(false);
        containerPrincipal.add(BorderLayout.CENTER, labelVH);
        
        verticeI = new ImageIcon(diretorioVertice+"I.png");
        labelVI = new JLabel(verticeI);
        labelVI.setBounds(0, 0, 80, 80);
        labelVI.show(false);
        containerPrincipal.add(BorderLayout.CENTER, labelVI);
        
        verticeJ = new ImageIcon(diretorioVertice+"J.png");
        labelVJ = new JLabel(verticeJ);
        labelVJ.setBounds(0, 0, 80, 80);
        labelVJ.show(false);
        containerPrincipal.add(BorderLayout.CENTER, labelVJ);
        
        containerPrincipal.setBackground(Color.red);
        
        containerBotoes = new Container();
        containerBotoes.setLayout(new GridLayout(1, 4));
        containerPrincipal.add(containerBotoes, BorderLayout.SOUTH);
        
        containerTexto = new Container();
        containerTexto.setLayout(null);
        containerPrincipal.add(containerTexto, BorderLayout.WEST);
        
        textoResultado = new JTextArea("AAAAAAAAAAAA");
        textoResultado.setBounds(80, 80, 80, 80);
        textoResultado.setVisible(true);
        containerTexto.add(textoResultado);
        
        botoes = new JButton[5];
        
        for(int i = 0; i < botoes.length; i++) // vai percorrer os botaum
        {
            botoes[i] = new JButton(textos[i]);
            
            botoes[i].setBounds(300, 300, 300, 300);
            botoes[i].setFont(fonteBotao);
            botoes[i].addActionListener(this);
            containerBotoes.add(botoes[i]);
        }
        
        botoes[0].setToolTipText("Adiciona um vértice ao campo acima!");
        botoes[1].setToolTipText("Remove um vértice que foi adicionado ao campo acima!");
        botoes[2].setToolTipText("Adiciona uma aresta ao campo acima!");
        botoes[3].setToolTipText("Remove uma aresta que foi adicionado ao campo acima!");
        botoes[4].setToolTipText("Encontra o menor caminho possível passando por todos os vértices!");
        
        //containerPrincipal.remove(labelVertice);
        //containerPrincipal.add(labelVertice);

        this.setSize(850, 620);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.show();
    }

    public void atualizarVertices()
    {
        for(int i = 0; i <= 10; i++)
        {
            if(verticePosicionado[i] == 1)
            {
                if(i == 1)
                {
                    labelVA.show(false);
                    labelVA.show(true);
                }
                else
                if(i == 2)
                {
                    labelVB.show(false);
                    labelVB.show(true);
                }
                else
                if(i == 3)
                {
                    labelVC.show(false);
                    labelVC.show(true);
                }
                else
                if(i == 4)
                {
                    labelVD.show(false);
                    labelVD.show(true);
                }
                else
                if(i == 5)
                {
                    labelVE.show(false);
                    labelVE.show(true);
                }
                else
                if(i == 6)
                {
                    labelVF.show(false);
                    labelVF.show(true);
                }
                else
                if(i == 7)
                {
                    labelVG.show(false);
                    labelVG.show(true);
                }
                else
                if(i == 8)
                {
                    labelVH.show(false);
                    labelVH.show(true);
                }
                else
                if(i == 9)
                {
                    labelVI.show(false);
                    labelVI.show(true);
                }
                else
                if(i == 10)
                {
                    labelVJ.show(false);
                    labelVJ.show(true);
                }
            }
        }
    }
    
    public void criarAresta(Graphics g, int inicioX, int inicioY, int destinoX, int destinoY, Color cor, String texto) 
    {
        if(inicioX == destinoX && inicioY == destinoY)
        {
            JOptionPane.showMessageDialog(null, "Não é possível adicionar aresta no mesmo vértice");
        }
        else
        {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            
            g2.setFont(new Font("Arial", Font.BOLD, 25));
            g2.setPaint(cor);
            g2.draw(new Line2D.Double(inicioX, inicioY, destinoX, destinoY));
            int metadeX = (inicioX + destinoX)/2;
            int metadeY = (inicioY + destinoY)/2;
            g2.drawString(texto, metadeX+5, metadeY+5);
            Controle.processamento.somarArestas(1); //soma mais uma aresta adicionada
            System.out.println("Aresta criada no vértice "+arestaInicio+" até o vértice "+arestaDestino+ "! Com o valor de distância: "+texto);
            Controle.processamento.adicionarQuantidadeAresta(arestaInicio, arestaDestino);
            //System.out.println("Total de arestas do vértice A: "+ Controle.processamento.consultarAresta('C')+" com o total de: "+Controle.processamento.consultarTotalArestas()+" arestas!");
            
            //separa as letras correspondentes dos vértices para os numeros correspondentes. Exemplo: aresta C = 3
            int verticeDeInicio = 0, verticeDeDestino = 0;
            if(arestaInicio == 'A') verticeDeInicio = 1;
            if(arestaInicio == 'B') verticeDeInicio = 2;
            if(arestaInicio == 'C') verticeDeInicio = 3;
            if(arestaInicio == 'D') verticeDeInicio = 4;
            if(arestaInicio == 'E') verticeDeInicio = 5;
            if(arestaInicio == 'F') verticeDeInicio = 6;
            if(arestaInicio == 'G') verticeDeInicio = 7;
            if(arestaInicio == 'H') verticeDeInicio = 8;
            if(arestaInicio == 'I') verticeDeInicio = 9;
            if(arestaInicio == 'J') verticeDeInicio = 10;
            
            if(arestaDestino == 'A') verticeDeDestino = 1;
            if(arestaDestino == 'B') verticeDeDestino = 2;
            if(arestaDestino == 'C') verticeDeDestino = 3;
            if(arestaDestino == 'D') verticeDeDestino = 4;
            if(arestaDestino == 'E') verticeDeDestino = 5;
            if(arestaDestino == 'F') verticeDeDestino = 6;
            if(arestaDestino == 'G') verticeDeDestino = 7;
            if(arestaDestino == 'H') verticeDeDestino = 8;
            if(arestaDestino == 'I') verticeDeDestino = 9;
            if(arestaDestino == 'J') verticeDeDestino = 10;
            Controle.processamento.adicionarAresta(verticeDeInicio, verticeDeDestino, Integer.parseInt(texto));
        }
    }
    
    public void zerarArestas(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.dispose();
    }
    
    public void actionPerformed(ActionEvent evento) //quando clicar no botao
    {
        if(evento.getSource() == botoes[0]) //adicionar vértice
        {
            modo = 1;
            labelVA.removeMouseListener(this);//previne bug de cordenadas da imagem x cordenadas de fundo
            labelVB.removeMouseListener(this);
            labelVC.removeMouseListener(this);
            labelVD.removeMouseListener(this);
            labelVE.removeMouseListener(this);
            labelVF.removeMouseListener(this);
            labelVG.removeMouseListener(this);
            labelVH.removeMouseListener(this);
            labelVI.removeMouseListener(this);
            labelVJ.removeMouseListener(this);
        }
        else
        if(evento.getSource() == botoes[1]) //remover vértice
        {
            modo = 2;
            labelVA.removeMouseListener(this);
            labelVB.removeMouseListener(this);
            labelVC.removeMouseListener(this);
            labelVD.removeMouseListener(this);
            labelVE.removeMouseListener(this);
            labelVF.removeMouseListener(this);
            labelVG.removeMouseListener(this);
            labelVH.removeMouseListener(this);
            labelVI.removeMouseListener(this);
            labelVJ.removeMouseListener(this);
            
            labelVA.addMouseListener(this);
            labelVB.addMouseListener(this);
            labelVC.addMouseListener(this);
            labelVD.addMouseListener(this);
            labelVE.addMouseListener(this);
            labelVF.addMouseListener(this);
            labelVG.addMouseListener(this);
            labelVH.addMouseListener(this);
            labelVI.addMouseListener(this);
            labelVJ.addMouseListener(this);
        }
        else
        if(evento.getSource() == botoes[2]) //adicionar aresta
        {
            if(verificarQuantidadeVertices() > 1)
            {
                modoDeAresta = 1;
                System.out.print(modoDeAresta);
                modo = 3;
                labelVA.removeMouseListener(this);//previne bug de cordenadas da imagem x cordenadas de fundo
                labelVB.removeMouseListener(this);
                labelVC.removeMouseListener(this);
                labelVD.removeMouseListener(this);
                labelVE.removeMouseListener(this);
                labelVF.removeMouseListener(this);
                labelVG.removeMouseListener(this);
                labelVH.removeMouseListener(this);
                labelVI.removeMouseListener(this);
                labelVJ.removeMouseListener(this);
            
                labelVA.addMouseListener(this);
                labelVB.addMouseListener(this);
                labelVC.addMouseListener(this);
                labelVD.addMouseListener(this);
                labelVE.addMouseListener(this);
                labelVF.addMouseListener(this);
                labelVG.addMouseListener(this);
                labelVH.addMouseListener(this);
                labelVI.addMouseListener(this);
                labelVJ.addMouseListener(this);
            }
            else
            {
                try
                {
                    JOptionPane.showMessageDialog(null, "É necessário ter no mínimo dois vértices!");
                }
                catch(Exception er)
                {
                    
                }
            }
        }
        else
        if(evento.getSource() == botoes[3]) //apagar tudo
        {
            modo = 4;
            labelVA.show(false);
            labelVB.show(false);
            labelVC.show(false);
            labelVD.show(false);
            labelVE.show(false);
            labelVF.show(false);
            labelVG.show(false);
            labelVH.show(false);
            labelVI.show(false);
            labelVJ.show(false);
            for(int i = 0; i <= 10; i++)
            {    
                if(verticePosicionado[i] == 1)
                {
                    verticePosicionado[i] = 0;
                }
            }
            zerarArestas(getGraphics());
            Controle.processamento.zerarTotalArestas();
            Controle.processamento.zerarVertices();
        }
        else
        if(evento.getSource() == botoes[4]) //processar
        {
            modo = 1;
            JOptionPane.showMessageDialog(null, Controle.processamento.processar());
            labelVA.show(false);
            labelVB.show(false);
            labelVC.show(false);
            labelVD.show(false);
            labelVE.show(false);
            labelVF.show(false);
            labelVG.show(false);
            labelVH.show(false);
            labelVI.show(false);
            labelVJ.show(false);
            for(int i = 0; i <= 10; i++)
            {    
                if(verticePosicionado[i] == 1)
                {
                    verticePosicionado[i] = 0;
                }
            }
            zerarArestas(getGraphics());
            Controle.processamento.zerarTotalArestas();
            Controle.processamento.zerarVertices();
        }
    }

    public int verificarQuantidadeVertices()
    {
        int valor = 0;
        for(int i = 1; i <= 10; i++)
        {
            if(verticePosicionado[i] == 1)
            {
                valor ++;
            }
        }
        return valor;
    }
    
    public void mouseClicked(MouseEvent e) 
    {
         
        
    }

    public void mousePressed(MouseEvent e) 
    {
        
    }

    public void mouseReleased(MouseEvent e) // quando soltar clique do mouse
    {
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            if(modo == 1)
            {
                int numeroVertice = 0;
                for(int i = 1; i <= 10; i++)
                {
                    if(verticePosicionado[i] == 0)
                    {
                        numeroVertice = i;
                        verticePosicionado[i] = 1;
                        break;
                    }

                }

                System.out.println("Criando vértice "+ this.vertices[numeroVertice]);
                int x = 0;
                int y = 0;
                x = e.getX();
                y = e.getY();
                System.out.println(x+" "+y);
                
                if(numeroVertice >= 1 && numeroVertice <= 10) Controle.processamento.somarVertice();
                if(numeroVertice == 1) //cria vértice a
                {
                    labelVA.setBounds(x-40, y-40, 80, 80);
                    labelVA.show(true);
                }
                else
                if(numeroVertice == 2)//cria vertice b
                {
                    labelVB.setBounds(x-40, y-40, 80, 80);
                    labelVB.show(true);
                }
                else
                if(numeroVertice == 3) //cria vertice c
                {
                    labelVC.setBounds(x-40, y-40, 80, 80);
                    labelVC.show(true);
                }
                else
                if(numeroVertice == 4) //cria vertice d
                {
                    labelVD.setBounds(x-40, y-40, 80, 80);
                    labelVD.show(true);
                }
                else
                if(numeroVertice == 5)// cria vertice e
                {
                    labelVE.setBounds(x-40, y-40, 80, 80);
                    labelVE.show(true);
                }
                else
                if(numeroVertice == 6) //cria vertice f
                {
                    labelVF.setBounds(x-40, y-40, 80, 80);
                    labelVF.show(true);
                }
                else
                if(numeroVertice == 7) //cria vertice g
                {
                    labelVG.setBounds(x-40, y-40, 80, 80);
                    labelVG.show(true);
                }
                else
                if(numeroVertice == 8) // cria vertice h
                {
                    labelVH.setBounds(x-40, y-40, 80, 80);
                    labelVH.show(true);
                }
                else
                if(numeroVertice == 9) //cria vertice i
                {

                    labelVI.setBounds(x-40, y-40, 80, 80);
                    labelVI.show(true);
                }
                else
                if(numeroVertice == 10) //cria vertice j
                {
                    labelVJ.setBounds(x-40, y-40, 80, 80);
                    labelVJ.show(true);
                }
            }
            else
            if(modo == 2) //modo (excluir vértice)
            {
                if(e.getSource() == labelVA)
                {
                    System.out.println("Removendo vértice A");
                    labelVA.show(false);
                    verticePosicionado[1] = 0;
                    Controle.processamento.subtrairVertice();
                }
                else
                if(e.getSource() == labelVB)
                {
                    System.out.println("Removendo vértice B");
                    labelVB.show(false);
                    verticePosicionado[2] = 0;
                    Controle.processamento.subtrairVertice();
                }
                else
                if(e.getSource() == labelVC)
                {
                    System.out.println("Removendo vértice C");
                    labelVC.show(false);
                    verticePosicionado[3] = 0;
                    Controle.processamento.subtrairVertice();
                }
                else
                if(e.getSource() == labelVD)
                {
                    System.out.println("Removendo vértice D");
                    labelVD.show(false);
                    verticePosicionado[4] = 0;
                    Controle.processamento.subtrairVertice();
                }
                else
                if(e.getSource() == labelVE)
                {
                    System.out.println("Removendo vértice E");
                    labelVE.show(false);
                    verticePosicionado[5] = 0;
                    Controle.processamento.subtrairVertice();
                }
                else
                if(e.getSource() == labelVF)
                {
                    System.out.println("Removendo vértice F");
                    labelVF.show(false);
                    verticePosicionado[6] = 0;
                    Controle.processamento.subtrairVertice();
                }
                else
                if(e.getSource() == labelVG)
                {
                    System.out.println("Removendo vértice G");
                    labelVG.show(false);
                    verticePosicionado[7] = 0;
                    Controle.processamento.subtrairVertice();
                }
                else
                if(e.getSource() == labelVH)
                {
                    System.out.println("Removendo vértice H");
                    labelVH.show(false);
                    verticePosicionado[8] = 0;
                    Controle.processamento.subtrairVertice();
                }
                else
                if(e.getSource() == labelVI)
                {
                    System.out.println("Removendo vértice I");
                    labelVI.show(false);
                    verticePosicionado[9] = 0;
                    Controle.processamento.subtrairVertice();
                }
                else
                if(e.getSource() == labelVJ)
                {
                    System.out.println("Removendo vértice J");
                    labelVJ.show(false);
                    verticePosicionado[10] = 0;
                    Controle.processamento.subtrairVertice();
                }
            }
            else
            if(modo == 3) //modo de adicionar aresta
            {
                try
                {
                    if(e.getSource() == labelVA) //verifica onde clicou
                    {
                        if(modoDeAresta == 1)  //se ele clicou no label de vertice a, define a posicao de inicio da aresta
                        {
                            inicioX = labelVA.getX()+40;
                            inicioY = labelVA.getY()+80;
                            modoDeAresta = 2;
                            arestaInicio = 'A';
                        }
                        else
                        if(modoDeAresta == 2)
                        {
                            destinoX = labelVA.getX()+40;
                            destinoY = labelVA.getY()+80;
                            modoDeAresta=1;
                            arestaDestino = 'A';

                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor de distancia da aresta!"));
                            criarAresta(getGraphics(), inicioX, inicioY, destinoX, destinoY, corAresta, ""+valor);
                        }
                    }
                    else
                    if(e.getSource() == labelVB) //verifica onde clicou
                    {
                        if(modoDeAresta == 1)  //se ele clicou no label de vertice a, define a posicao de inicio da aresta
                        {
                            inicioX = labelVB.getX()+40;
                            inicioY = labelVB.getY()+80;
                            modoDeAresta = 2;
                            arestaInicio = 'B';
                        }
                        else
                        if(modoDeAresta == 2)
                        {
                            destinoX = labelVB.getX()+40;
                            destinoY = labelVB.getY()+80;
                            modoDeAresta=1;
                            arestaDestino = 'B';

                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor de distancia da aresta!"));
                            criarAresta(getGraphics(), inicioX, inicioY, destinoX, destinoY, corAresta, ""+valor);
                        }
                    }
                    else
                    if(e.getSource() == labelVC) //verifica onde clicou
                    {
                        if(modoDeAresta == 1)  //se ele clicou no label de vertice a, define a posicao de inicio da aresta
                        {
                            inicioX = labelVC.getX()+40;
                            inicioY = labelVC.getY()+80;
                            modoDeAresta = 2;
                            arestaInicio = 'C';
                        }
                        else
                        if(modoDeAresta == 2)
                        {
                            destinoX = labelVC.getX()+40;
                            destinoY = labelVC.getY()+80;
                            modoDeAresta=1;
                            arestaDestino = 'C';

                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor de distancia da aresta!"));
                            criarAresta(getGraphics(), inicioX, inicioY, destinoX, destinoY, corAresta, ""+valor);
                        }
                    }
                    else
                    if(e.getSource() == labelVD) //verifica onde clicou
                    {
                        if(modoDeAresta == 1)  //se ele clicou no label de vertice a, define a posicao de inicio da aresta
                        {
                            inicioX = labelVD.getX()+40;
                            inicioY = labelVD.getY()+80;
                            modoDeAresta = 2;
                            arestaInicio = 'D';
                        }
                        else
                        if(modoDeAresta == 2)
                        {
                            destinoX = labelVD.getX()+40;
                            destinoY = labelVD.getY()+80;
                            modoDeAresta=1;
                            arestaDestino = 'D';
                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor de distancia da aresta!"));
                            criarAresta(getGraphics(), inicioX, inicioY, destinoX, destinoY, corAresta, ""+valor);
                        }
                    }
                    else
                    if(e.getSource() == labelVE) //verifica onde clicou
                    {
                        if(modoDeAresta == 1)  //se ele clicou no label de vertice a, define a posicao de inicio da aresta
                        {
                            inicioX = labelVE.getX()+40;
                            inicioY = labelVE.getY()+80;
                            modoDeAresta = 2;
                            arestaInicio = 'E';
                        }
                        else
                        if(modoDeAresta == 2)
                        {
                            destinoX = labelVE.getX()+40;
                            destinoY = labelVE.getY()+80;
                            modoDeAresta=1;
                            arestaDestino = 'E';
                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor de distancia da aresta!"));
                            criarAresta(getGraphics(), inicioX, inicioY, destinoX, destinoY, corAresta, ""+valor);
                        }
                    }
                    else
                    if(e.getSource() == labelVF) //verifica onde clicou
                    {
                        if(modoDeAresta == 1)  //se ele clicou no label de vertice a, define a posicao de inicio da aresta
                        {
                            inicioX = labelVF.getX()+40;
                            inicioY = labelVF.getY()+80;
                            modoDeAresta = 2;
                            arestaInicio = 'F';
                        }
                        else
                        if(modoDeAresta == 2)
                        {
                            destinoX = labelVF.getX()+40;
                            destinoY = labelVF.getY()+80;
                            modoDeAresta=1;
                            arestaDestino = 'F';
                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor de distancia da aresta!"));
                            criarAresta(getGraphics(), inicioX, inicioY, destinoX, destinoY, corAresta, ""+valor);
                        }
                    }
                    else
                    if(e.getSource() == labelVG) //verifica onde clicou
                    {
                        if(modoDeAresta == 1)  //se ele clicou no label de vertice a, define a posicao de inicio da aresta
                        {
                            inicioX = labelVG.getX()+40;
                            inicioY = labelVG.getY()+80;
                            modoDeAresta = 2;
                            arestaInicio = 'G';
                        }
                        else
                        if(modoDeAresta == 2)
                        {
                            destinoX = labelVG.getX()+40;
                            destinoY = labelVG.getY()+80;
                            modoDeAresta=1;
                            arestaDestino = 'G';
                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor de distancia da aresta!"));
                            criarAresta(getGraphics(), inicioX, inicioY, destinoX, destinoY, corAresta, ""+valor);
                        }
                    }
                    else
                    if(e.getSource() == labelVH) //verifica onde clicou
                    {
                        if(modoDeAresta == 1)  //se ele clicou no label de vertice a, define a posicao de inicio da aresta
                        {
                            inicioX = labelVH.getX()+40;
                            inicioY = labelVH.getY()+80;
                            modoDeAresta = 2;
                            arestaInicio = 'H';
                        }
                        else
                        if(modoDeAresta == 2)
                        {
                            destinoX = labelVH.getX()+40;
                            destinoY = labelVH.getY()+80;
                            modoDeAresta=1;
                            arestaDestino = 'H';
                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor de distancia da aresta!"));
                            criarAresta(getGraphics(), inicioX, inicioY, destinoX, destinoY, corAresta, ""+valor);
                        }
                    }
                    else
                    if(e.getSource() == labelVI) //verifica onde clicou
                    {
                        if(modoDeAresta == 1)  //se ele clicou no label de vertice a, define a posicao de inicio da aresta
                        {
                            inicioX = labelVI.getX()+40;
                            inicioY = labelVI.getY()+80;
                            modoDeAresta = 2;
                            arestaInicio = 'I';
                        }
                        else
                        if(modoDeAresta == 2)
                        {
                            destinoX = labelVI.getX()+40;
                            destinoY = labelVI.getY()+80;
                            modoDeAresta=1;
                            arestaDestino = 'I';
                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor de distancia da aresta!"));
                            criarAresta(getGraphics(), inicioX, inicioY, destinoX, destinoY, corAresta, ""+valor);
                        }
                    }
                    else
                    if(e.getSource() == labelVJ) //verifica onde clicou
                    {
                        if(modoDeAresta == 1)  //se ele clicou no label de vertice a, define a posicao de inicio da aresta
                        {
                            inicioX = labelVJ.getX()+40;
                            inicioY = labelVJ.getY()+80;
                            modoDeAresta = 2;
                            arestaInicio = 'J';
                        }
                        else
                        if(modoDeAresta == 2)
                        {
                            destinoX = labelVJ.getX()+40;
                            destinoY = labelVJ.getY()+80;
                            modoDeAresta=1;
                            arestaDestino = 'J';
                            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o valor de distancia da aresta!"));
                            criarAresta(getGraphics(), inicioX, inicioY, destinoX, destinoY, corAresta, ""+valor);
                        }
                    }
                }
                catch (Exception er)
                {

                }
            }
            if(modo == 4) //apagar tudo
            {

            }
        }
    }
    public void mouseEntered(MouseEvent e) //entrou em uma determinada área
    {
        if(e.getPoint().x > 0 && e.getPoint().x <= 850 && e.getPoint().y > 0 && e.getPoint().y <= 650)
        {
            setCursor(1);
        }
        
    }

    public void mouseExited(MouseEvent e) //saiu de uma determinada área
    {
        if(e.getPoint().x > 0 && e.getPoint().x <= 850 && e.getPoint().y > 0 && e.getPoint().y <= 650)
        {
            setCursor(0);
        }
    }
}