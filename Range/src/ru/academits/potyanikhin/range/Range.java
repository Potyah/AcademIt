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

    public Range getCrossInterval(Range range) {
        this.from = Math.max(from, range.from);
        this.to = Math.min(to, range.to);
        return range;
    }

    public Range getUnionInterval(Range range) {
        this.from = Math.max(from, range.from);
        this.to = Math.max(to, range.to);
return range;
    }
}
