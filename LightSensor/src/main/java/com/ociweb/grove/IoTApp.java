package com.ociweb.grove;
import static com.ociweb.iot.grove.simple_analog.SimpleAnalogTwig.LightSensor;
import static com.ociweb.iot.grove.simple_digital.SimpleDigitalTwig.LED;
import static com.ociweb.iot.maker.Port.A2;
import static com.ociweb.iot.maker.Port.D2;

import com.ociweb.iot.maker.FogApp;
import com.ociweb.iot.maker.FogRuntime;
import com.ociweb.iot.maker.Hardware;
import com.ociweb.iot.maker.Port;

public class IoTApp implements FogApp
{
    private static final Port LIGHT_SENSOR_PORT= A2;
    private static final Port LED_PORT = D2;
   
    
    public static void main( String[] args ) {
        FogRuntime.run(new IoTApp());
    }
    @Override
    public void declareConnections(Hardware c) {         
        c.connect(LightSensor, LIGHT_SENSOR_PORT);
        c.connect(LED, LED_PORT, 200); //200 is the rate in milliseconds to update the device data
    }

    @Override
    public void declareBehavior(FogRuntime runtime) {
    	runtime.addAnalogListener(new LightSensorBehavior(runtime));
    	
    }
}
