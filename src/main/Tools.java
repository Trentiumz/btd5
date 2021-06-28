package main;

import processing.core.PVector;

public class Tools {
    /**
     * Returns if a point is inside a circle
     *
     * @param radius the radius of the circle
     * @param center the center of the circle
     * @param point  the point to query
     * @return if the point is inside the circle
     */
    public static boolean pointInCircle(float radius, PVector center, PVector point) {
        return point.sub(center).mag() <= radius;
    }

    /**
     * returns if two circles are touching
     *
     * @param r1 the radius of the first circle
     * @param r2 the radius of the second circle
     * @param c1 the center of the first circle
     * @param c2 the center of the second circle
     * @return whether the two circles are touching
     */
    public static boolean circlesTouching(float r1, float r2, PVector c1, PVector c2) {
        return c2.sub(c1).mag() <= (r1 + r2);
    }

    /**
     * Returns the distance from a line segment to a point
     *
     * @param endPoint1 the first endpoint of the line
     * @param endPoint2 the second endpoint of the line
     * @param point     the coordinate of the point
     * @return the distance from the point to the line defined by the two endpoints
     */
    public static float lineToPointDistance(PVector endPoint1, PVector endPoint2, PVector point) {
        PVector line = endPoint2.sub(endPoint1);
        point = point.sub(endPoint1);
        // cosine of the angle from the point to the line
        float cosAng = line.dot(point) / line.mag() / point.mag();
        // if the horizontal distance is larger than the line itself or if the , then return the distance
        if (point.mag() * cosAng >= line.mag() || point.mag() * cosAng < 0)
            return Math.min(line.dist(point), line.mag());
            // otherwise, return the sin * magnitude of point
        else return (float) Math.sqrt(1 - cosAng * cosAng) * point.mag();
    }

    /**
     * returns if a line touches a circle
     *
     * @param endPoint1    first endpoint of the line
     * @param endPoint2    second endpoint of the line
     * @param circleCenter center of the circle
     * @param circleRadius radius of the circle
     * @return whether or not the line is in the circle
     */
    public static boolean lineInCircle(PVector endPoint1, PVector endPoint2, PVector circleCenter, float circleRadius) {
        return lineToPointDistance(endPoint1, endPoint2, circleCenter) <= circleRadius;
    }
}
