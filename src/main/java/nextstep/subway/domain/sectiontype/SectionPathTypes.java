package nextstep.subway.domain.sectiontype;

import nextstep.subway.domain.Section;
import nextstep.subway.domain.SectionEdge;
import nextstep.subway.domain.Station;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.util.Arrays;
import java.util.List;

public class SectionPathTypes {
    private List<SectionPathTypeCondition> conditionList;

    {
        conditionList = Arrays.asList(
                new DistanceSectionPathType()
                , new DurationSectionPathType());
    }

    public void setEdgeWeight(SectionPathType sectionPathType, SimpleDirectedWeightedGraph<Station, SectionEdge> graph, Section it, SectionEdge sectionEdge) {
        for (SectionPathTypeCondition condition : conditionList) {
            if(condition.sameCondition(sectionPathType)){
                condition.setEdgeWeight(graph, it, sectionEdge);
            }
        }
    }
}