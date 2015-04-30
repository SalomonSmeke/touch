package com.oreilly.demo.android.pa.uidemo.draw;

/**
 * A visitor on edu.luc.etl.cs313.android.shapes.model. Instances represent functions from Shape to
 * a generic result type.
 */
public interface Visitor<Result> {

    /**
     *
     * @param l lines
     * @return line visitor
     */
	Result onLine(Line l);

    /**
     *
     * @param sp sprite
     * @return sprite visitor
     */
	Result onSprite(Sprite sp);

    /**
     *
     * @param sq square
     * @return square visitor
     */
	Result onSquare(Square sq);

    /**
     *
     * @param sq square with fill
     * @return square with fill visitor
     */
    Result onSquareF(SquareF sq);

    /**
     *
     * @param ci circle with fill
     * @return circle with fill visitor
     */
    Result onCircleF(CircleF ci);

    /**
     *
     * @param ci circle
     * @return circle visitor
     */
    Result onCircle(Circle ci);

    /**
     *
     * @param t text
     * @return text visitor
     */
	Result onText(Text t);

}
