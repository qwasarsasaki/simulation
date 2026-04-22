package simulation;

import actions.Action;
import actions.init.SpawnGrassAction;
import actions.init.SpawnHerbivoreAction;
import actions.turn.MoveCreaturesAction;
import map.GameMap;
import renderer.ConsoleRenderer;
import renderer.Renderer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Simulation {
    private GameMap map;
    private int stepsCounter;
    private Renderer render;
    private List<Action> initActions;
    private List<Action> turnActions;

    public Simulation() {
        map = new GameMap(10, 10);
        this.render = new ConsoleRenderer();
        initActions = new ArrayList<>();
        for (int i = 0; i < 3; i++) { initActions.add(new SpawnGrassAction()); }
        initActions.add(new SpawnHerbivoreAction());

        turnActions = new ArrayList<>();
        turnActions.add(new MoveCreaturesAction());
    }
    public void nextTurn() {
        for (Action action : turnActions) {
            action.execute(map);
        }
        render.render(map);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void startSimulation() {
        for (Action action : initActions) {
            action.execute(map);
        }
        render.render(map);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            nextTurn();
        }
    }
    public void pauseSimulation() {}
}
