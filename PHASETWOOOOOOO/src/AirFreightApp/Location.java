/*
CPCS-324 Project, Phase 1
Students Name            | ID         | Section
--------------------------------------------------
Duna Ziad Hejazi         | 2107548    | B0B
Hadeel Ali Alqarni       | 2105488    | B0B
Njoud Naji Alahmadi      | 2109470    | B0B
Sereen Hussain Baageel   | 2105237    | B0B
*/
package AirFreightApp;
import GraphFramework.Edge;
import GraphFramework.Vertex;
public class Location extends Vertex {

    //CONSTRUCTORS
    public Location(String label) {
        super(label);
    }

    public Location(char id) {
        super(id);
    }

    public Location(int city) {
       super(city);
    }

    //-----------------------------------------------------

    //METHODS
    @Override
    public void displayInfo() {
        super.displayInfo(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    
    
}
