package com.jaxton.neon.objects;


import com.jaxton.neon.framework.ObjectId;
import com.jaxton.neon.window.Handler;

public class Player extends Avatar {


    public Player(float x, float y, Handler handler, ObjectId id)
    {
        super(x, y, handler, id);
        this.handler = handler;
    }


}
