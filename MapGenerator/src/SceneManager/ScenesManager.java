package SceneManager;


import Camera.CameraManager;
import Interfaces.StandardBehaviour;

import java.awt.*;
import java.io.IOException;


public class ScenesManager implements StandardBehaviour
{
    CameraManager camera=new CameraManager();

    private allScenes currentActiveSceneName=allScenes.GAME;

    private Scene gameScene=new GameScene();
    private Scene menuScene=new MenuScene();
    private Scene currentActiveScene=menuScene;
    public static ScenesManager instance=new ScenesManager();


    public void runCurrentScene()
    {
        currentActiveScene.Update();
        camera.Update();
    }

    public void renderCurrentScene(Graphics2D graphics2d)
    {
        currentActiveScene.draw(graphics2d);
    }

    @Override
    public void Start() throws IOException {

    }

    @Override
    public void Update() {

    }


    public void setCurrentActiveScene(allScenes nextScene) throws IOException {
        currentActiveSceneName=nextScene;
        switch (currentActiveSceneName)
        {
            case GAME:
            {
                currentActiveScene=gameScene;
                break;
            }
            case MENU:
            {
                currentActiveScene=menuScene;
                break;
            }
        }

        currentActiveScene.Start();
    }
}
