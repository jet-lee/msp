package de.lmu.ifi.mdsg.msp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GPSActivity extends Activity {

	TextView gpsOverview;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_gps_layout);
		
		gpsOverview = (TextView)findViewById(R.id.gpstextview);
	}
}
