# Android Sensor Application (Accelerometer)

## Introduction

In this project, I developed an Android application that reads accelerometer sensor data and displays it on the screen.

The accelerometer detects device movement in three directions:
- X axis
- Y axis
- Z axis

---

## How the App Works

1. The app gets SensorManager from the system.
2. It accesses the accelerometer sensor.
3. The sensor listens for movement.
4. When the device moves, values change.
5. The app updates X, Y, Z values on screen.

---

## Code Structure

To keep the code clean, I separated:

- MainActivity → UI handling
- AccelerometerManager → Sensor handling

This makes the project easier to understand and maintain.

---

## Lifecycle Handling

The sensor starts in `onResume()`  
The sensor stops in `onPause()`

This prevents battery waste and memory leaks.

---

## Conclusion

This project demonstrates how to integrate hardware sensors in Android using clean structure and lifecycle management.

The same structure can be extended for:
- Gyroscope
- Pressure sensor
- Temperature sensor
- Light sensor
