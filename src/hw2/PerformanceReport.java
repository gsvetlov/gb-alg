package hw2;

import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PerformanceReport {
    private List<LocalTime> performanceTimes;
    private LocalTime averageTime;
    private String title;

    public PerformanceReport(Collection<Long> performanceTimes, String title) {
        this.performanceTimes = performanceTimes.stream().map(LocalTime::ofNanoOfDay).collect(Collectors.toList());
        averageTime = LocalTime
                .ofNanoOfDay(performanceTimes.stream().mapToLong(Long::longValue).sum() / performanceTimes.size());
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<LocalTime> getPerformanceTimes() {
        return performanceTimes;
    }

    public LocalTime getAverageTime() {
        return averageTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("PerformanceReport: ").append(title);
        builder.append(" [averageTime: ").append(averageTime).append(", performanceTimes: ").append(performanceTimes)
                .append("]");
        return builder.toString();
    }

}
