package be.uantwerpen.sc.services;

import be.uantwerpen.sc.models.map.MapJson;
import be.uantwerpen.sc.models.map.Neighbour;
import be.uantwerpen.sc.models.map.NodeJson;
import be.uantwerpen.sc.tools.Dijkstra;
import be.uantwerpen.sc.tools.Edge;
import be.uantwerpen.sc.tools.Vertex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 27/02/2016.
 */
@Service
public class PathPlanningService
{

    @Autowired
    private MapControlService mapControlService;

    private Dijkstra dijkstra;

    public PathPlanningService()
    {
        this.dijkstra = new Dijkstra();
    }

    public void Calculatepath(int start,int stop){
        MapJson mapJson = mapControlService.buildMapJson();
        List<Vertex> vertexes = new ArrayList<>();
        for (NodeJson nj : mapJson.getNodeJsons()){
            vertexes.add(new Vertex(nj));
        }

        List<Edge> edges;
        int i = 0;
        for (NodeJson nj : mapJson.getNodeJsons()){
            edges = new ArrayList<>();
            for (Neighbour neighbour : nj.getNeighbours()){
                for (Vertex v : vertexes){
                    if(v.getId() == neighbour.getPointEntity().getPid()){
                        edges.add(new Edge(v,neighbour.getWeight()));
                    }
                }
            }
            vertexes.get(i).setAdjacencies(edges);
            i++;
        }

        Vertex v = vertexes.get(start-1);

        dijkstra.computePaths(v); // run Dijkstra
        System.out.println("Distance to " + vertexes.get(stop-1) + ": " + vertexes.get(stop-1).minDistance);
        List<Vertex> path = dijkstra.getShortestPathTo(vertexes.get(stop-1));
        System.out.println("Path: " + path);
    }
}
