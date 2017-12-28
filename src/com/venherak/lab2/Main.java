package com.venherak.lab2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer(getMainConfiguration());

        computer.start(0.001, 500.0);
    }

    private static List<Device> getMainConfiguration() {
        List<Device> deviceList = new ArrayList<>();

        Device centralProcessor = new Device(5, 6, 2, 2, "CPU");
        Device northBridge = new Device(2, 0, 1, 1, "NB");
        Device randomAccessMemory = new Device(3, 0, 1, 1, "RAM");
        Device southBridge = new Device(7, 0, 1, 1, "SB");
        Device videoProcessor = new Device(4, 0, 1, 1,"VP");
        Device cdDrive = new Device(1, 0, 1, 1,"KD");
        Device MA = new Device(5, 0, 1, 1,"MA");
        centralProcessor.getNextDevices().put(northBridge, 1.0);
        videoProcessor.getNextDevices().put(centralProcessor, 1.0);
        MA.getNextDevices().put(southBridge, 1.0);
        cdDrive.getNextDevices().put(southBridge, 1.0);
        northBridge.getNextDevices().put(centralProcessor, 0.4);
        northBridge.getNextDevices().put(randomAccessMemory, 0.4);
        northBridge.getNextDevices().put(southBridge, 0.2);
        randomAccessMemory.getNextDevices().put(northBridge, 1.0);
        southBridge.getNextDevices().put(videoProcessor, 0.4);
        southBridge.getNextDevices().put(MA, 0.4);
        southBridge.getNextDevices().put(cdDrive, 0.2);
        deviceList.add(centralProcessor);
        deviceList.add(northBridge);
        deviceList.add(randomAccessMemory);
        deviceList.add(southBridge);
        deviceList.add(videoProcessor);
        deviceList.add(cdDrive);
        deviceList.add(MA);

        return deviceList;
    }
}
