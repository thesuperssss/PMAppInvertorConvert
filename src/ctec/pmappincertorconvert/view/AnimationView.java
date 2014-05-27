package ctec.pmappincertorconvert.view;

import java.util.ArrayList;

import ctec.pmappinvertorconvert.activity.R;
import ctec.pmappinvertorconvert.model.ShapeHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class AnimationView extends ImageView
{
	/**
	 * Allows for access to the application resources.
	 */
	private Context currentContext;
	/**
	 * Used for the repeated execution of the code, specifically to invalidate the view.
	 */
	private Runnable canvasRunnable;
	/**
	 * Drawable image that can move within the Canvas.
	 */
	private BitmapDrawable yesAndroid;
	/**
	 * Drawable image that can move within the Canvas.
	 */
	private BitmapDrawable noAndroid;
	/**
	 * Used to manage the runnable that provides for the invalidation.
	 */
	private Handler canvasHandler;
	/**
	 * How often in milliseconds that are between the redraws of the View.
	 */
	private final int FRAME_RATE = 30;
	/**
	 * Starting background color for the View.
	 */
	private int backgroundColor = Color.WHITE;
	/**
	 * Position variables for the images.
	 */
	private int yesX, yesY, noX, noY;
	/**
	 * Speed values for the images
	 */
	private int noXVelocity, noYVelocity, yesXVelocity, yesYVelocity;
	
	public final ArrayList balls = new ArrayList();

	/**
	 * Creates a CanvasView object for use within Android. This is a widget designed to load images and basic animation.
	 * 
	 * @param context
	 * @param attrs
	 */
	public AnimationView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		currentContext = context;

		// Initialize position variables.
		yesX = 23;
		yesY = 30;
		noX = 50;
		noY = 17;

		// Initialize the speeds of the images
		yesXVelocity = 5;
		noXVelocity = 10;

		yesYVelocity = 15;
		noYVelocity = 5;

		canvasRunnable = new Runnable()
		{

			@Override
			public void run()
			{
				invalidate();
			}
		};
		canvasHandler = new Handler();

	}
	private ShapeHolder addBall(float x, float y)
	{

		OvalShape circle = new OvalShape();

		circle.resize(50f, 50f);

		ShapeDrawable drawable = new ShapeDrawable(circle);

		ShapeHolder shapeHolder = new ShapeHolder(drawable);

		shapeHolder.setX(x - 25f);

		shapeHolder.setY(y - 25f);

		Paint paint = drawable.getPaint(); // new Paint(Paint.ANTI_ALIAS_FLAG);



		 shapeHolder.setPaint(paint);

		 balls.add(shapeHolder);

		return shapeHolder;

	}

	/**
	 * Draws a background rectangle so the canvas can be a different color than the default.
	 * 
	 * @param currentCanvas
	 *            A reference to the current Canvas object.
	 */
	private void drawBackgroundRectangle(Canvas currentCanvas)
	{
		Paint canvasPaint = new Paint();
		canvasPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		canvasPaint.setStrokeWidth(5);
		canvasPaint.setAntiAlias(true);
		canvasPaint.setColor(backgroundColor);
		currentCanvas.drawRect(0, 0, this.getWidth(), this.getHeight(), canvasPaint);

	}

	/**
	 * This is what code you call when you want to redraw the screen. Note that this is not the collision detection method but instead what is drawn every time the screen refreshes.
	 * 
	 * @param currentCanvas
	 *            Refers to the canvas passed to the method by the Android OS.
	 */
	protected void onDraw(Canvas currentCanvas)
	{
//		yesAndroid = (BitmapDrawable) currentContext.getResources().getDrawable(R.drawable.android_yes);
//		noAndroid = (BitmapDrawable) currentContext.getResources().getDrawable(R.drawable.android_no);
//
//		drawBackgroundRectangle(currentCanvas);
//
//		bounceYesImage();
//		bounceNoImage();
//
//		currentCanvas.drawBitmap(yesAndroid.getBitmap(), yesX, yesY, null);
//		currentCanvas.drawBitmap(noAndroid.getBitmap(), noX, noY, null);
//		canvasHandler.postDelayed(canvasRunnable, FRAME_RATE);

		Paint p = new Paint();
		int red2, green2, blue2;
		red2 = (int) (Math.random() * 256);
		green2 = (int) (Math.random() * 256);
		blue2 = (int) (Math.random() * 256);
		
		p.setAntiAlias(true);
		p.setColor(Color.argb(255, red2, green2, blue2));
		p.setStyle(Paint.Style.FILL); 
		p.setStrokeWidth(4.5f);

		currentCanvas.drawCircle(50, 50, 30, p);
		
	}

	/**
	 * Creates a new random background color for the canvas.
	 */
	public void changeBackgroundColor()
	{
		int red, green, blue;
		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		backgroundColor = Color.argb(255, red, green, blue);		
		
	}

	/**
	 * Adjusts the movement of the android_yes image based on its position. If the image bounces of the top or bottom walls the background color of the canvas is changed.
	 */
	private void bounceYesImage()
	{
		if (yesX < 0 && yesY < 0)
		{
			yesX = this.getWidth() / 2;
			yesY = this.getHeight() / 2;
		}
		else
		{
			yesX += yesXVelocity;
			yesY += yesYVelocity;

			if ((yesX > this.getWidth() - yesAndroid.getBitmap().getWidth()) || (yesX < 0))
			{
				yesXVelocity *= -1;
			}

			if ((yesY > this.getHeight() - yesAndroid.getBitmap().getHeight()) || (yesY < 0))
			{
				yesYVelocity *= -1;
				
			}
		}
	}

	/**
	 * Adjusts the movement of the android_no image based on its position. If the image bounces of the left or right walls the background color of the canvas is changed.
	 */
	private void bounceNoImage()
	{
		if (noX < 0 && noY < 0)
		{
			noX = this.getWidth() / 2;
			noY = this.getHeight() / 2;
		}
		else
		{
			noX += noXVelocity;
			noY += noYVelocity;

			if ((noX > this.getWidth() - noAndroid.getBitmap().getWidth()) || (noX < 0))
			{
				noXVelocity *= -1;
				
			}

			if ((noY > this.getHeight() - noAndroid.getBitmap().getHeight()) || (noY < 0))
			{
				noYVelocity *= -1;
			}
		}

	}
	
	

}
