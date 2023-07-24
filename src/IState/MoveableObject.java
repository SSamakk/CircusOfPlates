package IState;

/**
 *
 * @author shaym
 */

public class MoveableObject implements State {
    private int x;
    private int y;
    
    public MoveableObject(){
        
    }
    
    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }
}
