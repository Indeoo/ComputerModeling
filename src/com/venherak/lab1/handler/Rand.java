package com.venherak.lab1.handler;

import java.util.Random;

public class Rand extends AbstractHandler {

    public Rand(double miu) {
        super(miu);
    }

    @Override
    public void performCurrentTask() {
        if(this.getTasklist().size() > 0) {
            if(this.getCurrentTask().getProcessTime() > 0) {
                this.getCurrentTask().processTask(miu);
            } else {
                this.getTasklist().remove(this.getCurrentTaskId());
                this.setCurrentTaskId(getRandom());
            }
        }
    }
    public int getRandom() {
        Random generator = new Random();
        //return generator.nextInt(this.getTasklist().size());
        return 0;
    }
}
