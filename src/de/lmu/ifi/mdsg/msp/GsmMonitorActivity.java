package de.lmu.ifi.mdsg.msp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;



public class GsmMonitorActivity extends Activity {

/**********************************************************************************************/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(new GsmMonitor(this));

	}
	
/**********************************************************************************************/
}
