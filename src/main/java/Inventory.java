import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<Integer, Rack> racks = new HashMap<>();

    public void addRack(Rack rack){
        racks.put(rack.getRackNumber(), rack);
    }

    public Rack getRack(int rackNumber){
        return racks.get(rackNumber);
    }

    public Collection<Rack> getAllRacks(){
        return racks.values();
    }
}
