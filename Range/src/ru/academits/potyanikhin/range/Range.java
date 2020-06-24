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

    public String stringRange(Range range) {
        return ("от " + range.getFrom() + " до " + range.getTo());
    }

    public String getCrossInterval(Range range) {
        if ((range.from > to) || (from < range.to)) {
            return null;
        }

        range.from = Math.max(from, range.from);
        range.to = Math.min(to, range.to);
        return stringRange(range);
    }

    public Range getUnionInterval(Range range) {
        range.from = Math.max(from, range.from);
        range.to = Math.max(to, range.to);
        return range;
    }
}
