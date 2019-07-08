package com.jaxton.neon.framework;

import java.awt.*;
import java.util.LinkedList;

public abstract class GameObject {

    protected float x, y;
    protected ObjectId id;

    public GameObject(float x, float y, ObjectId id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }

    public ObjectId getId() {
        return id;
    }
}
