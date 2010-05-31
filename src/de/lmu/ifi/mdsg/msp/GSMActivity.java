package de.lmu.ifi.mdsg.msp;

import java.util.List;

import org.w3c.dom.Text;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.google.android.maps.MapActivity;

public class GSMActivity extends MapActivity {
	
	int signalstrength = -1;
	TextView gsmTextView;
	GsmMonitor gsmMonitorView;
	
	GsmCellLocation gsmCellLocation;
	TelephonyManager telephonyManager;
	List<NeighboringCellInfo> neighboringCells;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_gsm_layout);
		
		gsmTextView = (TextView) findViewById(R.id.gsmtextview);
		
		
		
		gsmTextView.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				Intent monitoractivity = new Intent(GSMActivity.this,GsmMonitorActivity.class);
				startActivity(monitoractivity);
			}
			
			
		}
		);
			
		// PhoneStateListener 
		PhoneStateListener listener = new PhoneStateListener(){
			
			//Signalstaerke
			public void onSignalStrengthChanged(int asu){
				
				signalstrength = asu;
			
							
			}
			
					
			//CellLocation	
			public void onCellLocationChanged(CellLocation location){
				
				StringBuffer buffer = new StringBuffer();
				
				buffer.append("CellLocation :"+location.toString()+" Signalstärke :"+ (-113 + 2*signalstrength)
					+" CellID :"+gsmCellLocation.getCid()+ " Networktyp :"+telephonyManager.getNetworkType());
				
				for(int i = 0; i < neighboringCells.size(); i++){
					buffer.append(" Neighbor Signalstärke " + i + ": " + (-113 + 2*neighboringCells.get(i).getRssi()));
					buffer.append(" Neighbour CellID "+ i +": "+neighboringCells.get(i).getCid());
				}

				
				
				gsmTextView.setText(buffer.toString());		
				
			}		
			
 
			
			
		};
		
		telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		
		gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
		//neighboringCell = new NeighboringCellInfo();
		neighboringCells = (List<NeighboringCellInfo>) telephonyManager.getNeighboringCellInfo();
		
		telephonyManager.listen(listener, PhoneStateListener.LISTEN_SIGNAL_STRENGTH);
		telephonyManager.listen(listener, PhoneStateListener.LISTEN_CELL_LOCATION);
		
		

		
	
		
		
		
	}

	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	

	
}
