package cena;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 *
 * @author binho
 */
public class Jogo implements GLEventListener {

    private GL2 gl;
    private GLU glu;
    private GLUT glut;
    public boolean liga = true;
    private static GLWindow window = null;
    public float naveX, naveY, naveZ;
    public float tiroX, tiroY, tiroZ;

    public int larguraFrame;
    public int alturaFrame;

    @Override
    public void init(GLAutoDrawable drawable) {
        //dados iniciais da cena
        GL2 gl = drawable.getGL().getGL2();

        //habilita o buffer de profundidade
        gl.glEnable(GL2.GL_DEPTH_TEST);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        Elementos nave = new Elementos();
        //obtem o contexto Opengl
        gl = drawable.getGL().getGL2();
        glut = new GLUT(); //objeto da biblioteca glut

        //define a cor da janela (R, G, G, alpha)
        gl.glClearColor(0, 0, 0, 1);
        //limpa a janela com a cor especificada

        //limpa o buffer de profundidade
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity(); //lê a matriz identidade

        gl.glPushMatrix();
        //Translação que controla o movimento da nave
        gl.glTranslatef(naveX, naveY, naveZ);
        gl.glColor3f(1, 0, 0);
        //Chama o metodo que desenha a nave
        nave.DesenhaNave(gl);
        gl.glPopMatrix();

        gl.glLoadIdentity();
        gl.glPushMatrix();
        gl.glTranslatef(naveX, tiroY - 5, tiroZ);
        gl.glColor3f(1, 0, 0);
        nave.DesenhaTiro(gl);
        gl.glPopMatrix();

        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //obtem o contexto grafico Opengl
        gl = drawable.getGL().getGL2();
        //ativa a matriz de projeção
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity(); //lê a matriz identidade
        //projeção ortogonal (xMin, xMax, yMin, yMax, zMin, zMax)
        gl.glOrtho(-100, 100, -100, 100, -100, 100);
        //ativa a matriz de modelagem
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        System.out.println("Reshape: " + width + ", " + height);

        larguraFrame = width;
        alturaFrame = height;
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

}
