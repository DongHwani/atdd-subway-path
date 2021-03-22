package nextstep.subway.path.domain;

import nextstep.subway.line.domain.Line;
import nextstep.subway.line.domain.Lines;
import nextstep.subway.path.domain.exception.CannotFindPathException;
import nextstep.subway.station.domain.Station;
import nextstep.subway.station.domain.Stations;

import java.util.List;

public class PathFinder {

    private Lines lines;
    private PathStrategy pathStrategy;

    public PathFinder(List<Line> lines) {
        this.lines = new Lines(lines);
    }

    public PathFinder(PathStrategy pathStrategy) {
        this.pathStrategy = pathStrategy;
    }

    public Stations findShortestPath(Station source, Station target) {
        if(source.equals(target)) {
            throw new CannotFindPathException("출발역과 도착역이 같을 순 없습니다");
        }

        return pathStrategy.getPath(source, target);
    }

}
