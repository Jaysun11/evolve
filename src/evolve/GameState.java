package evolve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jason on 27/10/16.
 */
public class GameState extends State{

    private ArrayList<CreatureInstance> creatureInstances = new ArrayList<>();
    private World world;
    public GameState(Game game, World world) {
        super(game);
        float y =  1 + (int)(Math.random() * 768-51);
        float x =  1 + (int)(Math.random() * 1024-51);
        creatureInstances.add(new CreatureInstance(game, x, y, 50, 50));

        this.world = world;

        //ADD BUTTON FOR TESTING
        JButton addButton = new JButton("ADD");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                float y =  1 + (int)(Math.random() * 768-51);
                float x =  1 + (int)(Math.random() * 1024-51);
                creatureInstances.add(new CreatureInstance(game, x, y, 50, 50));
            }
        });
        addButton.setBounds(0, 0, 200, 50);
        this.game.getPanel().getFrame().getContentPane().add(addButton);
        Canvas canvas = this.game.getPanel().getCanvas();
        this.game.getPanel().getFrame().add(canvas);
        this.game.getPanel().getFrame().pack();



    }

    @Override
    public void tick() {
        for (int i = 0; i < creatureInstances.size(); i++) {
            creatureInstances.get(i).tick();
        }

    }

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < creatureInstances.size(); i++) {
            creatureInstances.get(i).render(g);
        }


    }
}
