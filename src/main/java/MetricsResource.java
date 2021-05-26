import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.metrics.annotation.Counted;


@Path("mymetrics")
public class MetricsResource {
    
    @Counted
    @GET
    @Path("/counted")
    public String getCounted(){
        return "Counted \n";
    }

    @Counted
    @GET
    @Path("/timed")
    public String getTimed(){
        return "timed \n";
    }

}
