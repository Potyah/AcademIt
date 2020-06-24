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
        return ("[от " + range.getFrom() + " до " + range.getTo() + "]; ");
    }

    public String stringRangeArray(Range[] rangeArray) {
        String string = "";
        for (int i = 0; i < rangeArray.length; i++) {
            string += (stringRange(rangeArray[i]));
        }
        return string;
    }

    public boolean getCrossCheck(double firstFrom, double firstTo, double secondFrom, double secondTo) {
        return (!(firstFrom >= secondTo)) && (!(secondFrom >= firstTo));
    }

    public String getCrossInterval(Range secondRange) {
        if (!getCrossCheck(from, to, secondRange.from, secondRange.to)) {
            return null;
        } else {
            Range crossIntervalRange = new Range(0, 0);
            crossIntervalRange.from = Math.max(from, secondRange.from);
            crossIntervalRange.to = Math.min(to, secondRange.to);

            return stringRange(crossIntervalRange);
        }
    }

    public String getUnionInterval(Range secondRange) {
        Range unionIntervalRange = new Range(0, 0);

        if (getCrossCheck(from, to, secondRange.from, secondRange.to)) {
            unionIntervalRange.from = Math.min(from, secondRange.from);
            unionIntervalRange.to = Math.max(to, secondRange.to);

            return stringRange(unionIntervalRange);
        } else {
            Range[] rangeArray = new Range[2];
            rangeArray[0] = this;
            rangeArray[1] = secondRange;

            return stringRangeArray(rangeArray);
        }
    }
}
