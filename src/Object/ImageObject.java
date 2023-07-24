package Object;

import IState.State;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageObject implements GameObject{

    private static final int MAX_MSTATE = 1;

    private BufferedImage[] spriteImages;
    private int x;
    private int y;
    private boolean visible;
    private static ImageObject clownInstance;
    // private int type;
    private State state;
    private String path = "";

    public ImageObject(int x, int y, State state, String imageName) {
        this.state = state;
        this.state.setX(x);
        this.state.setY(y);
        
        this.spriteImages = new BufferedImage[MAX_MSTATE];
        this.visible = true;
        this.path = imageName;

        try {
            spriteImages[0] = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imageName));
        } 
        catch (IOException e) {
            System.out.println("Image can't be loaded!");
        }
    }
    
    public ImageObject(GameObject o, State state, String imageName) { // type
        this.x = o.getX();
        this.y = o.getY();
        this.state = state;
        this.spriteImages=o.getSpriteImages();
        this.visible = true;
        this.path = imageName;
    }
    
    public static ImageObject getInstance(int posX, int posY,State state, String path) {
        if (clownInstance == null) {
            clownInstance = new ImageObject(posX, posY, state, path);
        }
        return clownInstance;
    }
    
    public String getPath(){
        return path;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    @Override
    public int getX() {
        return state.getX(); 
    }

    @Override
    public void setX(int x) {
        this.state.setX(x);
    }

    @Override
    public int getY() {
        return state.getY();
    }

    @Override
    public void setY(int y) {
        this.state.setY(y);
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public void setState(State state){
        this.state = state;
        state.setX(this.state.getX());
        state.setY(this.state.getY());  
    }

    public State getState(){
        return this.state;
    }
    
    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }
}
