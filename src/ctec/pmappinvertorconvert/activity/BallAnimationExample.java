package ctec.pmappinvertorconvert.activity;

/**
 * http://www.edumobile.org/android/android-development/ball-animation-example/
 */
import java.util.ArrayList;

import ctec.pmappinvertorconvert.model.ShapeHolder;

import android.animation.Animator;

import android.animation.AnimatorListenerAdapter;

import android.animation.AnimatorSet;

import android.animation.ArgbEvaluator;

import android.animation.ObjectAnimator;

import android.animation.ValueAnimator;

import android.app.Activity;

import android.content.Context;

import android.graphics.Canvas;

import android.graphics.Paint;

import android.graphics.RadialGradient;

import android.graphics.Shader;

import android.graphics.drawable.ShapeDrawable;

import android.graphics.drawable.shapes.OvalShape;

import android.os.Bundle;

import android.view.MotionEvent;

import android.view.View;

import android.view.animation.AccelerateInterpolator;

import android.view.animation.DecelerateInterpolator;

import android.widget.LinearLayout;

public class BallAnimationExample extends Activity
{

	public class MyAnimationView extends View
	{

		private static final int RED = 0xffFF8080;

		private static final int BLUE = 0xff8080FF;

		private static final int CYAN = 0xff80ffff;

		private static final int GREEN = 0xff80ff80;

		public final ArrayList<ShapeHolder> balls = new ArrayList();

		AnimatorSet animation = null;

		public MyAnimationView(Context context)
		{

			super(context);

		}

		private ShapeHolder addBall(float x, float y)
		{

			OvalShape circle = new OvalShape();

			circle.resize(50f, 50f);

			ShapeDrawable drawable = new ShapeDrawable(circle);

			ShapeHolder shapeHolder = new ShapeHolder(drawable);

			shapeHolder.setX(x - 25f);

			shapeHolder.setY(y - 25f);

			Paint paint = drawable.getPaint();
			new Paint(Paint.ANTI_ALIAS_FLAG);

			shapeHolder.setPaint(paint);

			balls.add(shapeHolder);

			return shapeHolder;

		}

		@Override
		protected void onDraw(Canvas canvas)
		{

			for (int i = 0; i < balls.size(); i++)
			{

				ShapeHolder shapeHolder = balls.get(i);

				canvas.save();

				canvas.translate(shapeHolder.getX(), shapeHolder.getY());

				shapeHolder.getShape().draw(canvas);

				canvas.restore();

			}

		}
	}

}
