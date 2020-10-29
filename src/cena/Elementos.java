package cena;

import com.jogamp.opengl.GL2;

//Classe criada para o controle dos elementos que aparecem na tela do jogo
public class Elementos {

    //Metodo que desenha a Nave na tela
    public void DesenhaNave(GL2 gl) {
        gl.glPushMatrix();
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex2f(0, -87);
        gl.glVertex2f(-7.5f, -95);
        gl.glVertex2f(0, -80);
        gl.glVertex2f(7.5f, -95);
        gl.glEnd();
        gl.glPopMatrix();
    }
    
    //Metodo que desenha o tiro
    public void DesenhaTiro(GL2 gl) {
        gl.glPushMatrix();
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2f(0, -80);
        gl.glVertex2f(0, -75);
        gl.glEnd();
        gl.glPopMatrix();
    }

}
