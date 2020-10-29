package input;

import cena.Inicial;
import cena.Renderer;
import cena.Jogo;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.opengl.GL2;

/**
 *
 * @author Siabreu
 */
public class KeyBoard implements KeyListener, MouseListener {

    private Inicial cena_inicial;
    private Jogo cena_jogo;

    public KeyBoard(Jogo cena_jogo) {
        this.cena_jogo = cena_jogo;
    }

    public KeyBoard(Inicial cena_inicial) {
        this.cena_inicial = cena_inicial;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        //Movimenta o eixo X da nave para a direita
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            cena_jogo.naveX += 5;
        }
        //Movimenta o eixo X da nave para a esquerda
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            cena_jogo.naveX -= 5;
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            //variavel que controla a velocidade do tiro
            int delay = 50;
            for (int i = 0; i < 40; i++) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException error) {
                    System.out.println("ERRO");
                }
                //a cada repetição a bala movimenta 5 positivo, ou seja, anda 5 casas pra cima
                cena_jogo.tiroY += 5;
            }
            //ao final da execução ela reseta ao ponto de inicio
            cena_jogo.tiroY = 0;
        }

//        switch (e.getKeyChar()) {
//            case 'r':
//                cena_inicial.angulo += 45;
//                break;
//            case 't':
//                cena_inicial.tonalizacao = cena_inicial.tonalizacao == GL2.GL_SMOOTH ? GL2.GL_FLAT : GL2.GL_SMOOTH;
//                break;
//            case 'l':
//                cena_inicial.liga = !cena_inicial.liga;
//                System.out.println(cena_inicial.liga);
//                break;
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int botao = e.getButton();

        if (botao == MouseEvent.BUTTON1) {
            System.out.println("Clique ESQ");
            cena_inicial.clicked = true;
            //Pega as coordenados do clique do mouse
            cena_inicial.mouseX = (float) e.getX();
            cena_inicial.mouseY = (float) e.getY();

            //Realiza da conversão das coordenadas da tela para coordenadas da janela
            cena_inicial.tx = ((2 * 100 * cena_inicial.mouseX) / cena_inicial.larguraFrame) - 100;
            cena_inicial.ty = (((2 * 100) * (cena_inicial.mouseY - cena_inicial.alturaFrame)) / -cena_inicial.alturaFrame) - 100;

            System.out.println("tx: " + cena_inicial.tx + ", ty: " + cena_inicial.ty);
        }
        System.out.println("mouse");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseEvent e) {
    }

}
