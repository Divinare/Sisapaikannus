package com.joe.indoorlocalization.State;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.joe.indoorlocalization.FloorChanger;
import com.joe.indoorlocalization.Models.FingerPrint;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by joe on 31/12/15.
 */
public class ApplicationState extends Application {

    static String TAG = ApplicationState.class.getSimpleName();
    public CalibrationState calibrationState;
    public LocateState locateState;
    public FloorChanger floorChanger;

    private int x;
    private int y;
    private double z = 1.0;
    private int currentFloor = 1;
    private boolean automaticallyChangeFloor = true;
    private ArrayList<FingerPrint> fingerPrints = new ArrayList();


    private TreeMap<Integer, String> blueprints = new TreeMap<>();

    public ApplicationState() {
        this.locateState = new LocateState();
        this.calibrationState = new CalibrationState();
    }

    public void initFloorChanger(Context context) {
        floorChanger = new FloorChanger(this);
        this.floorChanger.init(context);
    }

    public void emptyCurrentDatabase() {
        this.fingerPrints = new ArrayList<>();
    }

    public void addFingerPrint(FingerPrint fp) {
        this.fingerPrints.add(fp);
    }

    public ArrayList<FingerPrint> getFingerPrints() {
        return this.fingerPrints;
    }

    public void removeFingerPrint(int z, float x, float y) {
        for(FingerPrint fp : this.fingerPrints) {
            if(fp.getZ() == z && fp.getX() == x && fp.getY() == y) {
                this.fingerPrints.remove(fp);
                Log.d(TAG, "Removing fingerPrint with z: " + z + " x: " + x + " y: " + y);
                break;
            }
        }
    }

    public int getX() {
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public double getZ() {
        return this.z;
    }
    public void setZ(double z) {
        this.z = z;
    }
    public int getCurrentFloor() {
        return this.currentFloor;
    }
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public boolean getAutomaticallyChangeFloor() {
        return this.automaticallyChangeFloor;
    }
    public void toggleAutomaticallyChangeFloor() {
        this.automaticallyChangeFloor = !this.automaticallyChangeFloor;
    }

    public TreeMap<Integer, String> getBlueprints() {
        return this.blueprints;
    }

    public void addToBlueprints(int floorNumber, String path) {
        this.blueprints.put(floorNumber, path);
    }
}
