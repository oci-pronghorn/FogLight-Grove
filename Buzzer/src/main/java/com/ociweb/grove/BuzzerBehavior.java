package com.ociweb.grove;

import com.ociweb.iot.maker.*;

import static com.ociweb.iot.grove.analogdigital.AnalogDigitalTwig.*;
import static com.ociweb.iot.maker.Port.*;
import static com.ociweb.iot.maker.FogCommandChannel.*;

public class BuzzerBehavior implements DigitalListener {
	
	private static final Port BUZZER_PORT = D8;
	
	private final FogCommandChannel channel1;
	
	public BuzzerBehavior(FogRuntime runtime) {
		// TODO Auto-generated constructor stub
        channel1 = runtime.newCommandChannel(PIN_WRITER);
	}

	@Override
	public void digitalEvent(Port port, long time, long durationMillis, int value) {
		// TODO Auto-generated method stub
	    channel1.setValueAndBlock(BUZZER_PORT, value == 1, 500);

	}

}
