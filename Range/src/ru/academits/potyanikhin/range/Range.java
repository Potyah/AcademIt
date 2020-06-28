package ru.academits.potyanikhin.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return (number >= from) && (number <= to);
    }

    public String toString() {
        return ("от " + from + " до " + to);
    }

    public static boolean isIntersectionCheck(double firstFrom, double firstTo, double secondFrom, double secondTo) {
        return (!(firstFrom >= secondTo)) && (!(secondFrom >= firstTo));
    }

    public Range getIntersection(Range range) {
        if (!isIntersectionCheck(from, to, range.from, range.to)) {
            return null;
        }

        return new Range((Math.max(from, range.from)), Math.min(to, range.to));
    }

    public Range[] getUnion(Range range) {
        if ((isIntersectionCheck(from, to, range.from, range.to)) ||
                ((to == range.from) || (from == range.to))) {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
        }

        return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
    }

    public Range[] getDifference(Range range) {
        if (((from >= range.from) && (to <= range.to))) {
            return new Range[0];
        }

        if (!isIntersectionCheck(from, to, range.from, range.to)) {
            return new Range[]{new Range(this.from, this.to)};
        }

        if (from == range.from) {
            return new Range[]{new Range(Math.min(to, range.to), Math.max(to, range.to))};
        }

        if (to == range.to) {
            return new Range[]{new Range(Math.min(from, range.from), Math.max(from, range.from))};
        }

        return new Range[]{new Range(Math.min(from, range.from), Math.max(from, range.from)), new Range(Math.min(to, range.to), Math.max(to, range.to))};
    }
}