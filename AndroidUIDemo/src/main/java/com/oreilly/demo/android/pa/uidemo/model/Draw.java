package com.oreilly.demo.android.pa.uidemo.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

import edu.luc.etl.cs313.android.shapes.model.*;

/**
 * A Visitor for drawing a shape to an Android canvas.
 */
public class Draw implements Visitor<Void> {

	// TODO entirely your job (except onCircle)

	private final Canvas canvas;
	private final Paint paint;

	public Draw(final Canvas canvas, final Paint paint) {
		this.canvas = canvas; // FIXME
		this.paint = paint; // FIXME
		paint.setStyle(Style.STROKE);
	}

	@Override
	public Void onCircle(final Circle c) {
		canvas.drawCircle(0, 0, c.getRadius(), paint);
		return null;
	}

	@Override
	public Void onStroke(final Stroke c) {
        paint.setStyle(Style.FILL_AND_STROKE);
        paint.setColor(c.getColor());
        c.getShape().accept(this);
        paint.setStyle(Style.FILL_AND_STROKE);
        paint.setColor(Color.BLACK);
		return null;
	}

	@Override
	public Void onFill(final Fill f) {
        paint.setStyle(Style.FILL_AND_STROKE);
        f.getShape().accept(this);
		return null;
	}

	@Override
	public Void onGroup(final Group g) {
        for (int i = 0; i < g.getShapes().size(); i++){
            g.getShapes().get(i).accept(this);
        }
		return null;
	}

	@Override
	public Void onLocation(final Location l) {
        canvas.translate(l.getX(), l.getY());
        l.getShape().accept(this);
        canvas.translate(-l.getX(), -l.getY());
		return null;
	}

	@Override
	public Void onRectangle(final Rectangle r) {
        canvas.drawRect(0, 0, r.getWidth(), r.getHeight(), paint);
		return null;
	}

	@Override
	public Void onOutline(Outline o) {
        paint.setStyle(Style.STROKE);
        o.getShape().accept(this);
		return null;
        new Shape.getX();

	}

	@Override
	public Void onPolygon(final Polygon s) {
		final float[] pts = new float[2*s.getPoints().size()];
        int it = 0;
        for (int i = 0; i < pts.length; i++){
            pts[i]=s.getPoints().get(it).getX();
            i++;
            pts[i]=s.getPoints().get(it).getY();
            it++;
        }
		canvas.drawLines(pts, paint);
		return null;
	}
}