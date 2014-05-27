package ctec.pmappinvertorconvert.activity;

import ctec.pmappincertorconvert.view.AnimationView;
import ctec.pmappinvertorconvert.model.ShapeHolder;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class FirstAppActivity extends Activity
{

	private Button onOff;
	private Button changeCanvasColor;
	private Button changeBallColor;
	private AnimationView myCanvas;
	private Button addBall;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_app);
		onOff = (Button) findViewById(R.id.onOffButton);
		changeCanvasColor = (Button) findViewById(R.id.changeCanvasColorButton);
		changeBallColor = (Button) findViewById(R.id.changeBallColorButton);
		myCanvas = (AnimationView) findViewById(R.id.animationView1);
		addBall = (Button) findViewById(R.id.addBallButton);

		setupListeners();

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first_app, menu);
		return true;
	}

	private void setupListeners()
	{
		onOff.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View currentView)
			{

			}
		});
		changeCanvasColor.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View currentView)
			{
				myCanvas.changeBackgroundColor();
			}
		});
		changeBallColor.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View currentView)
			{
				 

			}
		});
		addBall.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View currentView)
			{
				
				//ShapeHolder newBall = addBall(event.getX(), event.getY());
						
			}
		});
	}

}
