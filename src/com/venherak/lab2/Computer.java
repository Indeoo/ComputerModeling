package com.venherak.lab2;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Device> devices;
    private double systemTime;

    public Computer(List<Device> devices) {
        this.devices = devices;
        this.systemTime = 0;
    }

    public Computer() {
        this.devices = new ArrayList<>();
        this.systemTime = 0;
    }

    void start(double stepTime, double modelingTime) {
        while (systemTime < modelingTime) {
            for (Device device : devices) {
                device.proceed(stepTime);
            }
            systemTime += stepTime;
        }
        System.out.println("Core1    "  + devices.get(0).workTime / systemTime);
        System.out.println("Core2    "  + devices.get(0).workTime2 / systemTime);
        devices.remove(0);
        for (Device device : devices) {
            System.out.println(device.getName() + " " + device.getLoadCoeff(systemTime));
        }
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        for (Device device : devices) {
            resultString.append(device.toString()).append("\n");
        }

        return resultString.toString();
    }
}
