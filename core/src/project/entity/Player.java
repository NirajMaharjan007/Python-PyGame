/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.entity;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import project.animation.player.PlayerAnimation;
import project.misc.Log;

public class Player extends Entity {
    private final static Player INSTANCE = new Player();
    boolean isUp, isDown, isRight, isLeft, isIdle;

    private PlayerAnimation.PlayerRight player_right;

    private Player() {
        System.out.println("this is a player");
        position.set(45, 45);
        isUp = isDown = isRight = isLeft = false;
        isIdle = true;
    }

    public static Player getInstance() {
        return INSTANCE;
    }

    public void create() {
        System.out.println("Created Player");
        player_right = new PlayerAnimation.PlayerRight();
        player_right.setPosition(position);
    }

    private void move() {
        int speed = 4;
        isIdle = false;

        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            position.add(0, speed);
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            position.add(0, -speed);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.add(-speed, 0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.add(speed, 0);
        } else {
            isIdle = true;
        }
    }

    private void boundary() {
        if (position.x > Gdx.graphics.getWidth())
            position.x = 0;
        if (position.x < 0)
            position.x = Gdx.graphics.getWidth();
        if (position.y > Gdx.graphics.getHeight())
            position.y = 0;
        if (position.y < 0)
            position.y = Gdx.graphics.getHeight();
    }

    @Override
    public void render(SpriteBatch batch) {
        this.boundary();
        position.add(4, 0);
        player_right.render(batch);
    }

    @Override
    public void dispose() {
        player_right.dispose();
        Log.getInstance().setLog("Player dispose");
    }

}
