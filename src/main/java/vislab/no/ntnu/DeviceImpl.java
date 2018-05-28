package vislab.no.ntnu;

import java.net.InetAddress;
import java.net.UnknownHostException;

import vislab.no.ntnu.annotations.DeviceSPI;
import vislab.no.ntnu.providers.Device;
import vislab.no.ntnu.providers.PowerStates;

@DeviceSPI
public class DeviceImpl implements Device {
    private static final String MANUFACTURER = "TEMP";
    private static final String MODEL = "LATE";
    private InetAddress hostAddress;
    private int portNumber = 0;

    //TODO: Implement a function to turn the device on
    public int powerOn() {
        return 0;
    }

    //TODO: Implement a function to turn the device off
    public int powerOff() {
        return 0;
    }

    //TODO: Implement a function to return the current power state
    public int getPowerState() {
        return PowerStates.OFF;
    }

    public String getMake() {
        return MANUFACTURER;
    }

    public String getModel() {
        return MODEL;
    }

    public String getDeviceName() {
        return MANUFACTURER + " " + MODEL;
    }

    public String getHostAddress() {
        return hostAddress.toString();
    }

    public int getPortNumber() {
        return portNumber;
    }

    /**
     * Returns true if the give string was a valid IP address
     * @param ipString string representation of an ip.
     * @return true if the give string was a valid IP address
     */
    public boolean setIpAddress(String ipString) {
        try{
            hostAddress = InetAddress.getByName(ipString);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }

    /**
     * Sets the port for the device.
     * @param port the port number
     */
    public void setPort(int port) {
        portNumber = port;
    }
    /**
     * Method for setting up and making the this object ready for use.
     * @return false if it could not be setup correctly.
     */
    public boolean initialize() {
        return false;
    }
}
