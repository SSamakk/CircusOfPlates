package Factory;

import IState.MoveableObject;
import Object.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;
import Strategy.IStrategy;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Shapes {
    
    private final List<GameObject> shapes = new LinkedList<>();
    private final int max;
    private final int bombs;
    private static IStrategy difficulty; 

    public Shapes(IStrategy strategy) {
        
        difficulty = strategy;
        max = difficulty.NoOfFallingShapes();
        bombs = Shapes.difficulty.maxBombs();
    }
   
    public List<GameObject> createPlates(int width, int height) {
        
        int x;
        int y;
        String imagePath;
        int j;
        for(j = 0; j < bombs; j++){
            x = (int) (Math.random() * width);
            y = (int) (-1 * Math.random() * height/2);
            imagePath = "bomb.png";
            shapes.add(new ImageObject(x, y, new MoveableObject(), imagePath));
        }
        // Add plates 
        for (int i = j; i < max; i++) {
            x = (int) (Math.random() * width);
            y = (int) (-1 * Math.random() * height/2);
            int imgNum = (int) (Math.random() * 4 + 1);
            imagePath = "plate" + imgNum + ".png";
            shapes.add(new ImageObject(x, y, new MoveableObject(),imagePath)); 
        }
        Collections.shuffle(shapes);
        return shapes;
    }

    
}
