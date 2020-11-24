package api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class DWGraph_DSTest {
    private directed_weighted_graph g1;
    @BeforeEach
    void setUp(){
        node_data n;
        geo_location location;
        g1=new DWGraph_DS();
        for(int i=0;i<5;i++){
         location=new Location(i,i+5,i*10);
         n=new Node(i,location,(i+5)*10,"",0);
         g1.addNode(n);
        }
        for(int i=1;i<5;i++)
            g1.connect(i-1,i,i*10);
    }
    @Test
    void getNode() {
        for(int i=0;i<5;i++)assertNotNull(g1.getNode(i));
        assertThrows(RuntimeException.class,()->{
            geo_location l=new Location(1,5,10);
           g1.addNode(new Node(1,l,10,"",0));
        });
        node_data n=new Node(0,new Location(0,5,0),50,"",0);
        assertEquals(n,g1.getNode(0));
    }

    @Test
    void getEdge() {
        for (int i=1;i<5;i++)
            assertEquals(new Edge(i-1,i,i*10),g1.getEdge(i-1,i));

    }

    @Test
    void addNode() {

    }

    @Test
    void connect() {

    }

    @Test
    void getV() {
        assertEquals(5,g1.getV().size());
    }

    @Test
    void getE() {
        Collection<edge_data> g=  g1.getE(4);
        assertTrue(g.isEmpty());
        g=g1.getE(0);
        assertEquals(1,g.size());


    }

    @Test
    void removeNode() {
    }

    @Test
    void removeEdge() {
    }

    @Test
    void nodeSize() {
    }

    @Test
    void edgeSize() {
    }

    @Test
    void getMC() {
    }
}