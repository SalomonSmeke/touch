package com.oreilly.demo.android.pa.uidemo.draw;

/**
 * A visitor on edu.luc.etl.cs313.android.shapes.model. Instances represent functions from Shape to
 * a generic result type.
 */
public interface Visitor<Result> {
	Result onLine(Line l);
	Result onSprite(Sprite sp);
	Result onSquare(Square sq);
	Result onText(Text t);
}
